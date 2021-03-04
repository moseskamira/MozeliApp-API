package com.mobifest.mozeli.utils;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mobifest.mozeli.dao.AdminDao;
import com.mobifest.mozeli.models.Admin;

@Service
public class UserDetailService implements UserDetailsService{
	
	@Autowired
	AdminDao adminDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Admin loginAdmin = adminDao.findByUserName(username);
		return loginAdmin != null ? new User(loginAdmin.getAdminUserName(), loginAdmin.getAdminPassword(), 
				new ArrayList<>()) : null;
	}

}
