package com.online.shopping.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.online.shopping.models.Product;


@Repository
public interface ProductDAO extends JpaRepository<Product, Long>{
	
	Product findTopByOrderByProdIdDesc();
	
	@Query("SELECT prodObj FROM Product prodObj WHERE prodObj.prodName = ?1")
	Product searchSongByName();
	
	@Query("SELECT prodObj FROM Product prodObj ORDER BY prodObj.prodId DESC")
	List<Product> findAllSongsDescending();

}
