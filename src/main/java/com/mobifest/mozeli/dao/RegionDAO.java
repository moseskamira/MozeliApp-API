package com.mobifest.mozeli.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobifest.mozeli.models.Region;

@Repository
public interface RegionDAO extends JpaRepository<Region, Long>{

}
