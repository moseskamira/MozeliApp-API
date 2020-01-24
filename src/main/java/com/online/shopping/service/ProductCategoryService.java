package com.online.shopping.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.shopping.ProductCategory;
import com.online.shopping.dao.ProductCategoryDAO;

@Service
public class ProductCategoryService {
	@Autowired
	ProductCategoryDAO productCategoryDao;
	
	public ProductCategory addProductCategory(ProductCategory productCategory) {
		ProductCategory savedProdCat = productCategoryDao.saveAndFlush(productCategory);
		return savedProdCat;
	}
	
	public Optional<ProductCategory> getSingleProductCategory(Long id) {
		Optional<ProductCategory> fetchedProdCat = productCategoryDao.findById(id);
		return fetchedProdCat;
	}
	
	public List<ProductCategory> getAllProductCategories() {
		List<ProductCategory> availableProdCatList = productCategoryDao.findAll();
		return availableProdCatList;
	}
	
	public String deleteProductCategory(Long id) {
		productCategoryDao.deleteById(id);
		return "Successfully Deleted";
	}
}
