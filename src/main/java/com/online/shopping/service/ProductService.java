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
	ProductDAO productDao;
	
	@Autowired
	ProductCategoryDAO productCategoryDao;
	
	public Product saveProduct(Long prodCatId, Product product) {
		ProductCategory prodCat = productCategoryDao.getOne(prodCatId);
		Product myProduct = new Product();
		myProduct.setProdCat(prodCat);
		myProduct.setProdName(product.getProdName());
		myProduct.setProdDescrip(product.getProdDescrip());
		myProduct.setProdImageUrl(product.getProdImageUrl());
		myProduct.setProdLike(product.isProdLike());
		Product savedProduct = productDao.saveAndFlush(myProduct);
		
		return savedProduct;
	}
	
	public List<Product> getAllProducts() {
		List<Product> productList = productDao.findAll();
		return productList;
	}
	
	public List<Product> getProductsPerCategory(Long prodCatId) {
		ProductCategory prodCat = productCategoryDao.getOne(prodCatId);
		List<Product> catProdList = prodCat.getProducts();
		return catProdList;
	}
	
	public Product getSingleProduct(Long prodCatId, Long prodId) {
		ProductCategory prodCat = productCategoryDao.getOne(prodCatId);
		List<Product> catProdList = prodCat.getProducts();
		Product myProduct = null;
		if(!catProdList.isEmpty()) {
			for(Product product : catProdList) {
				if(product.getProdId()==prodId) {
					myProduct=product;
				}
			}
		}
		return myProduct;
	}
}
