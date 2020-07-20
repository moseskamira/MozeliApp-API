package com.online.shopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.shopping.dao.ProductCategoryDAO;
import com.online.shopping.dao.ProductDAO;
import com.online.shopping.models.Product;
import com.online.shopping.models.ProductCategory;

@Service
public class ProductService {
	@Autowired
	ProductDAO songDao;
	
	@Autowired
	ProductCategoryDAO albumDao;
	
	public Product saveSong(Long albumId, Product song) {
		ProductCategory album = albumDao.getOne(albumId);
		Product mySong = new Product();
		mySong.setProdCat(album);
		mySong.setProdName(song.getProdName());
		mySong.setProdDescrip(song.getProdDescrip());
		mySong.setProdImageUrl(song.getProdImageUrl());
		mySong.setAudioUrl(song.getAudioUrl());
		mySong.setStudioName(song.getStudioName());
		mySong.setProducerName(song.getProducerName());
		mySong.setUnitPrice(song.getUnitPrice());
		mySong.setProdLike(song.isProdLike());
		Product savedSong = songDao.saveAndFlush(mySong);
		return savedSong;
	}
	
	public List<Product> getAllSongs() {
		List<Product> songList = songDao.findAll();
		return songList;
	}
	
	public List<Product> getSongsPerAlbum(Long albumId) {
		ProductCategory album = albumDao.getOne(albumId);
		List<Product> songsList = album.getProducts();
		return songsList;
	}
	
	public Product getSingleSong(Long albumId, Long songId) {
		ProductCategory album = albumDao.getOne(albumId);
		List<Product> songsList = album.getProducts();
		Product mySong = null;
		if(!songsList.isEmpty()) {
			for(Product song : songsList) {
				if(song.getProdId()==songId) {
					mySong=song;
				}
			}
		}
		return mySong;
	}
	
	public String deleteSong(Long albumId, Long songId) {
		Product songToBeDeleted = songDao.getOne(songId);
		songDao.delete(songToBeDeleted);
		return "Successfully Deleted Song";
	}
	
	public Product updateSong(Long albumId, Long songId, Product song) {
		ProductCategory album = albumDao.getOne(albumId);
		List<Product> mySongsList = album.getProducts();
		Product updatedSong = null;
		if(!mySongsList.isEmpty()) {
			for(Product songToUpdate : mySongsList) {
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
}
