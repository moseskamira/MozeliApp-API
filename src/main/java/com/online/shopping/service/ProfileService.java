package com.online.shopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.shopping.dao.ProfileDao;
import com.online.shopping.models.Profile;

@Service
public class ProfileService {
	
	@Autowired
	ProfileDao profileDao;
	
	public Profile saveProfile(Profile prof) {
		Profile profile = new Profile();
		profile.setPdfFileUrl(prof.getPdfFileUrl());
		Profile savedProf = profileDao.saveAndFlush(profile);
		return savedProf;
	}
	
	public Profile getLastUpdatedProfile() {
		Profile lastUpdatedProfile = profileDao.findTopByOrderByProfileIdDesc();
		return lastUpdatedProfile;
	}
}
