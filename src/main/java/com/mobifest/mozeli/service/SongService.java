package com.mobifest.mozeli.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mobifest.mozeli.dao.AlbumDAO;
import com.mobifest.mozeli.dao.SongDAO;
import com.mobifest.mozeli.models.Song;
import com.mobifest.mozeli.models.Album;

@Service
public class SongService {
	@Autowired
	SongDAO songDao;
	
	@Autowired
	AlbumDAO albumDao;
	
	public ResponseEntity<Song> saveSong(Long albumId, Song song) {
		Album album = albumDao.getOne(albumId);
		Song mySong = new Song();
		mySong.setProdCat(album);
		mySong.setProdName(song.getProdName());
		mySong.setProdDescrip(song.getProdDescrip());
		mySong.setProdImageUrl(song.getProdImageUrl());
		mySong.setAudioUrl(song.getAudioUrl());
		mySong.setStudioName(song.getStudioName());
		mySong.setProducerName(song.getProducerName());
		mySong.setUnitPrice(song.getUnitPrice());
		mySong.setProdLike(song.isProdLike());
		Song savedSong = songDao.saveAndFlush(mySong);
		return ResponseEntity.ok().body(savedSong);
	}
	
	public ResponseEntity<List<Song>> getAllSongs() {
		List<Song> songList = songDao.findAll();
		return !songList.isEmpty() ? ResponseEntity.ok().body(songList) : ResponseEntity.ok().body(new ArrayList<Song>());
	}
	
	public ResponseEntity<List<Song>> getSongsPerAlbum(Long albumId) {
		Album album = albumDao.getOne(albumId);
		List<Song> songsList = album.getProducts();
		return !songsList.isEmpty() ? ResponseEntity.ok().body(songsList) : ResponseEntity.ok().body(new ArrayList<Song>());
	}
	
	public ResponseEntity<Song> getSingleSong(Long albumId, Long songId) {
		Album album = albumDao.getOne(albumId);
		List<Song> songsList = album.getProducts();
		Song mySong = null;
		if(!songsList.isEmpty()) {
			for(Song song : songsList) {
				if(song.getProdId()==songId) {
					mySong=song;
				}
			}
		}
		return ResponseEntity.ok().body(mySong);
	}
	
	public ResponseEntity<String> deleteSong(Long albumId, Long songId) {
		Song songToBeDeleted = songDao.getOne(songId);
		songDao.delete(songToBeDeleted);
		return ResponseEntity.ok().body("Successfully Deleted Song");
	}
	
	public ResponseEntity<Song> updateSong(Long albumId, Long songId, Song song) {
		Album album = albumDao.getOne(albumId);
		List<Song> mySongsList = album.getProducts();
		Song updatedSong = null;
		if(!mySongsList.isEmpty()) {
			for(Song songToUpdate : mySongsList) {
				if(songToUpdate.getProdId()==songId) {
					songToUpdate.setProdName(song.getProdName());
					songToUpdate.setProdDescrip(song.getProdDescrip());
					songToUpdate.setProdImageUrl(song.getProdImageUrl());
					updatedSong = songDao.saveAndFlush(songToUpdate);
				}
			}
		}
		return ResponseEntity.ok().body(updatedSong);
	}
	
	public ResponseEntity<List<Song>> getAllSongsFromRecent() {
		List<Song> songList = songDao.findAllSongsDescending();
		return !songList.isEmpty() ? ResponseEntity.ok().body(songList) : ResponseEntity.ok().body(new ArrayList<Song>());
	}
	
}
