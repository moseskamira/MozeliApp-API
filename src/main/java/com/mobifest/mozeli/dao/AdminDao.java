package com.mobifest.mozeli.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mobifest.mozeli.models.Admin;

@Repository
public interface AdminDao extends JpaRepository<Admin, Long>{

	@Query("SELECT adminObj FROM Admin adminObj WHERE adminObj.adminUserName = ?1")
    Admin findByUserName(String adminUserName);
}
