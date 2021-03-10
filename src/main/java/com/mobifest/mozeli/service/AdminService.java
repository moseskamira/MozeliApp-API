package com.mobifest.mozeli.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.mobifest.mozeli.dao.AdminDao;
import com.mobifest.mozeli.models.Admin;
import com.mobifest.mozeli.utils.AuthenticationResponse;
import com.mobifest.mozeli.utils.JWTUtil;
import com.mobifest.mozeli.utils.UserDetailService;

@Service
public class AdminService {
	
	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailService userDetailService;
	
	@Autowired
	private JWTUtil jwtUtil;
	
	public ResponseEntity<Admin> saveAdmin(Admin admin) {
		Admin adminToSave = new Admin();
		adminToSave.setAdminFullName(admin.getAdminFullName());
		adminToSave.setAdminUserName(admin.getAdminUserName());
		adminToSave.setAdminPassword(admin.getAdminPassword());
		Admin savedAdmin = adminDao.saveAndFlush(adminToSave);
		return ResponseEntity.ok().body(savedAdmin);
		}
	
	public ResponseEntity<List<Admin>> getAllAdmins() {
		List<Admin> adminList = adminDao.findAll();
		return !adminList.isEmpty() ? ResponseEntity.ok().body(adminList) : ResponseEntity.ok().body(new ArrayList<Admin>());
		}
	
	public ResponseEntity<Admin> getAdminByUserName(String userName) {
		Admin admin = adminDao.findByUserName(userName);
		return admin != null ? ResponseEntity.ok().body(admin)  : ResponseEntity.ok().body(returnEmptyAdminObj());
		}
	
	private Admin returnEmptyAdminObj() {
		return new Admin(null, "", "", "");
	}
	
	public String deleteAdmin(Long adminId) {
		Admin adminToDelete = adminDao.getOne(adminId);
		if (adminToDelete != null) {
			if (!adminToDelete.getAdminFullName().isEmpty()) {
				adminDao.delete(adminToDelete);
				return "Admin Deleted Successfully";
			}else {
				return "Unable To Find Admin with Id"+adminId;			}
		}else {
			return "Invalid Admin Id provided";
			}
		}

	public ResponseEntity<AuthenticationResponse> login(Admin admin) throws Exception {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(admin.getAdminUserName(), admin.getAdminPassword()));
		final UserDetails userDetails = userDetailService.loadUserByUsername(admin.getAdminUserName());
		String newGeneratedToken = jwtUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(newGeneratedToken));
	}
	
	public ResponseEntity<String> changeAdminPassword(String userName, String oldPassword, String newPassword, String confirmPassword) {
		Admin oldAdmin = adminDao.findByUserName(userName);
		
		if(oldAdmin != null) {
			if(oldAdmin.getAdminPassword().equals(oldPassword)) {
				oldAdmin.setAdminPassword(newPassword);
				adminDao.save(oldAdmin);
				return ResponseEntity.ok().body("Password Successfully Changed");
			}else {
				return ResponseEntity.ok().body("Incorrect Old Password !");
			}
		}else {
			return ResponseEntity.ok().body("Username Not Found !");
		}
	}
	
	public String resetAdminPassword(String userName, String newPassword, String confirmPassword) throws Exception{
		if(newPassword.equals(confirmPassword)) {
			adminDao.resetAdminPassword(userName, newPassword);
			return "Password Successfully Reset";
		}else {
			return "Password Mismatch !";
		}
	}
		

}



