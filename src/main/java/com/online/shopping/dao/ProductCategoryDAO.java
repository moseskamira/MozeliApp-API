package com.online.shopping.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.online.shopping.models.ProductCategory;

@Repository
public interface ProductCategoryDAO extends JpaRepository<ProductCategory, Long>{
	

}
