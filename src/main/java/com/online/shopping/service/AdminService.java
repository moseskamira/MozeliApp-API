package com.online.shopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.shopping.dao.AdminDao;
import com.online.shopping.models.Admin;

@Service
public class AdminService {
	
	@Autowired
	AdminDao adminDao;
	
	public Admin saveAdmin(Admin admin) {
		Admin adminToSave = new Admin();
		adminToSave.setAdminFullName(admin.getAdminFullName());
		adminToSave.setAdminUserName(admin.getAdminUserName());
		adminToSave.setAdminPassword(admin.getAdminPassword());
		Admin savedAdmin = adminDao.saveAndFlush(adminToSave);
		return savedAdmin;
		}
	
	public List<Admin> getAllAdmins() {
		List<Admin> adminList = adminDao.findAll();
		return adminList;
		}
	
	public Admin getAdminByUserName(String userName) {
		Admin admin = adminDao.findByUserName(userName);
		if (admin != null) {
			return admin;
			}else {
				return new Admin(null, "", "", "");
				}
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

}
