package com.online.shopping.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.online.shopping.models.Region;

@Repository
public interface RegionDAO extends JpaRepository<Region, Long>{

}
