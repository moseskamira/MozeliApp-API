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

	public ResponseEntity<AuthenticationResponse> login(String uName, String uPass) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(uName, uPass));
			
		}catch(BadCredentialsException e) {
			throw new Exception("Incorrect Username OR Password", e);
		}
		
		final UserDetails userDetails = userDetailService.loadUserByUsername(uName);
		String newGeneratedToken = jwtUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(newGeneratedToken));
	}

}
