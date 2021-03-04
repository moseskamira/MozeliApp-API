package com.mobifest.mozeli.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mobifest.mozeli.models.Profile;

@Repository
public interface ProfileDao extends JpaRepository<Profile, Long>{

    Profile findTopByOrderByProfileIdDesc();
	
}
