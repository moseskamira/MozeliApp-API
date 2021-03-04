package com.mobifest.mozeli.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mobifest.mozeli.models.Song;


@Repository
public interface SongDAO extends JpaRepository<Song, Long>{
	
	Song findTopByOrderByProdIdDesc();
	
	@Query("SELECT songObj FROM Song songObj WHERE songObj.prodName = ?1")
	Song searchSongByName();
	
	@Query("SELECT songObj FROM Song songObj ORDER BY songObj.prodId DESC")
	List<Song> findAllSongsDescending();

	
}
