package com.online.shopping.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.shopping.dao.ProductCategoryDAO;
import com.online.shopping.models.ProductCategory;



@Service
public class ProductCategoryService {
	@Autowired
	ProductCategoryDAO albumDao;
	
	public ProductCategory addAlbum(ProductCategory album) {
		ProductCategory savedAlbum = albumDao.saveAndFlush(album);
		return savedAlbum;
	}
	
	public Optional<ProductCategory> getSingleAlbum(Long id) {
		Optional<ProductCategory> fetchedAlbum = albumDao.findById(id);
		return fetchedAlbum;
	}
	
	public List<ProductCategory> getAllAlbum() {
		List<ProductCategory> availableAlbumList = albumDao.findAll();
		return availableAlbumList;
	}
	
	public String deleteAlbum(Long id) {
		albumDao.deleteById(id);
		return "Successfully Deleted";
	}
	
	public ProductCategory updateAlbum(Long id, ProductCategory album) {
		ProductCategory albumToUpdate = albumDao.getOne(id);
		albumToUpdate.setCatName(album.getCatName());
		ProductCategory updatedAlbum = albumDao.saveAndFlush(albumToUpdate);
		return updatedAlbum;
	}
}
