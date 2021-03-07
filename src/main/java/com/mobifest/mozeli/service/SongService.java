package com.mobifest.mozeli.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	public Song saveSong(Long albumId, Song song) {
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
		return savedSong;
	}
	
	public List<Song> getAllSongs() {
		List<Song> songList = songDao.findAll();
		return !songList.isEmpty() ? songList : new ArrayList<Song>();
	}
	
	public List<Song> getSongsPerAlbum(Long albumId) {
		Album album = albumDao.getOne(albumId);
		List<Song> songsList = album.getProducts();
		return !songsList.isEmpty() ? songsList : new ArrayList<Song>();
	}
	
	public Song getSingleSong(Long albumId, Long songId) {
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
		return mySong;
	}
	
	public String deleteSong(Long albumId, Long songId) {
		Song songToBeDeleted = songDao.getOne(songId);
		songDao.delete(songToBeDeleted);
		return "Successfully Deleted Song";
	}
	
	public Song updateSong(Long albumId, Long songId, Song song) {
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
		return updatedSong;
	}
	
	public List<Song> getAllSongsFromRecent() {
		List<Song> songList = songDao.findAllSongsDescending();
		return !songList.isEmpty() ? songList : new ArrayList<Song>();
	}
	
}
