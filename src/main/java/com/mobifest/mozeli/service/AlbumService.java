package com.mobifest.mozeli.service;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mobifest.mozeli.dao.AlbumDAO;
import com.mobifest.mozeli.models.Album;



@Service
public class AlbumService {
	@Autowired
	AlbumDAO albumDao;
	
	public ResponseEntity<Album> addAlbum(Album album) {
		Album savedAlbum = albumDao.saveAndFlush(album);
		return ResponseEntity.ok().body(savedAlbum);
	}
	
	public ResponseEntity<Optional<Album>> getSingleAlbum(Long id) {
		Optional<Album> fetchedAlbum = albumDao.findById(id);
		return ResponseEntity.ok().body(fetchedAlbum);
	}
	
	public ResponseEntity<List<Album>> getAllAlbum() {
		List<Album> availableAlbumList = albumDao.findAll();
		return !availableAlbumList.isEmpty() ? ResponseEntity.ok().body(availableAlbumList) : 
			ResponseEntity.ok().body(new ArrayList<Album>());
	}
	
	public ResponseEntity<String> deleteAlbum(Long id) {
		albumDao.deleteById(id);
		return ResponseEntity.ok().body("Successfully Deleted");
	}
	
	public ResponseEntity<Album> updateAlbum(Long id, Album album) {
		Album albumToUpdate = albumDao.getOne(id);
		albumToUpdate.setCatName(album.getCatName());
		Album updatedAlbum = albumDao.saveAndFlush(albumToUpdate);
		return ResponseEntity.ok().body(updatedAlbum);
	}
}
