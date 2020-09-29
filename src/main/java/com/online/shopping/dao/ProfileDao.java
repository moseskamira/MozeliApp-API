package com.online.shopping.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.online.shopping.models.Profile;

@Repository
public interface ProfileDao extends JpaRepository<Profile, Long>{

    Profile findTopByOrderByProfileIdDesc();
	
}
