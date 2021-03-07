package com.mobifest.mozeli.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.mobifest.mozeli.models.Album;

@Repository
public interface AlbumDAO extends JpaRepository<Album, Long>{
	

}
