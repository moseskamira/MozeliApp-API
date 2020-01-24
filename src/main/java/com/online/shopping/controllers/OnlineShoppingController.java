package com.online.shopping.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.shopping.ProductCategory;
import com.online.shopping.service.ProductCategoryService;

@RestController
@RequestMapping("onlineshopping")
public class OnlineShoppingController {
	@Autowired
	ProductCategoryService prodCatService;
	ProductCategory productCategory;
//	@RequestMapping(value="")
//	public ModelAndView returnHomePage() {
//		ModelAndView mv = new ModelAndView("index");
//		mv.addObject("greeting", "WELCOME TO MOTECH SHOPPING CENTRE");
//		return mv;
//	}

//	@RequestMapping(value="/addProdCategory", method=RequestMethod.POST)
//	@ResponseBody
//	public ProductCategory saveProductCategory(@ModelAttribute("productCategory") ProductCategoryRequest prodCatReq) {
//		ProductCategory prodCat = new ProductCategory();
//		prodCat.setCatName(prodCatReq.getCatName());
//		prodCatService.addProductCategory(prodCat);
//		return prodCat;	
//	}
	@PostMapping("/prodCat")
	public ProductCategory addProdCat(@RequestBody ProductCategory prodCat) {
		ProductCategory addedProdCat = prodCatService.addProductCategory(prodCat);
		return addedProdCat;
	}
	
	@GetMapping("/prodCat/{catId}")
	public Optional<ProductCategory> fetchSingleProdCat(@PathVariable("catId") Long id) {
		Optional<ProductCategory> fetchedProdCat = prodCatService.getSingleProductCategory(id);
		return fetchedProdCat;
	}
	
	@GetMapping("/prodCat")
	public ResponseEntity<List<ProductCategory>> fetAllProductCategories() {
		List<ProductCategory> prodCatList = prodCatService.getAllProductCategories();
		return ResponseEntity.ok().body(prodCatList);
	}
	
	@DeleteMapping("/prodCat/{catId}")
	public String deleteProdCat(@PathVariable("catId") Long id) {
		prodCatService.deleteProductCategory(id);
		return "Successfully Deleted Product Category";
	}
	
	
	
	
	
}
