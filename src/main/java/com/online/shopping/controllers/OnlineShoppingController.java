package com.online.shopping.controllers;


import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.online.shopping.models.Message;
import com.online.shopping.models.Product;
import com.online.shopping.models.ProductCategory;
import com.online.shopping.service.ProductCategoryService;
import com.online.shopping.service.ProductService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@RestController
@RequestMapping("onlineshopping")
public class OnlineShoppingController {
	@Autowired
	ProductCategoryService prodCatService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
    private JavaMailSender javaMailSender;

	@CrossOrigin(origins = "*")
	@PostMapping("/category")
	public ProductCategory addProductCategory(@RequestBody ProductCategory prodCat) {
		ProductCategory addedProdCat = prodCatService.addProductCategory(prodCat);
		return addedProdCat;
	}
	
	@GetMapping("/category/{catId}")
	public Optional<ProductCategory> fetchSingleProductCategory(@PathVariable("catId") Long id) {
		Optional<ProductCategory> fetchedProdCat = prodCatService.getSingleProductCategory(id);
		return fetchedProdCat;
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/category")
	public ResponseEntity<List<ProductCategory>> fetAllProductCategories() {
		List<ProductCategory> prodCatList = prodCatService.getAllProductCategories();
		return ResponseEntity.ok().body(prodCatList);
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping("/category/{catId}")
	public String deleteProductCategory(@PathVariable("catId") Long id) {
		prodCatService.deleteProductCategory(id);
		return "Successfully Deleted Product Category";
	}
	
	@PutMapping("/category/{catId}")
	public ProductCategory updateProductCategory(@PathVariable("catId") Long id, @RequestBody ProductCategory prodCat) {
		ProductCategory updatedProdCat = prodCatService.updateProductCategory(id, prodCat);
		return updatedProdCat;
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/category/{catId}/product")
	public Product addProduct(@PathVariable("catId") Long prodCatId, @RequestBody Product product) {
		Product addedProduct = productService.saveProduct(prodCatId, product);
		return addedProduct;
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/category/product")
	public List<Product> fetchAllProducts() {
		List<Product> productsList = productService.getAllProducts();
		return productsList;
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/category/{catId}/product")
	public List<Product> fetchProductsPerCategory(@PathVariable("catId") Long id) {
		List<Product> catProductsList = productService.getProductsPerCategory(id);	
		return catProductsList;
	}
	@CrossOrigin(origins = "*")
	@GetMapping("/category/{catId}/product/{prodId}")
	public Product fetchSingleProduct(@PathVariable("catId") Long prodCatId, @PathVariable("prodId") Long id) {
		Product myProduct = productService.getSingleProduct(prodCatId, id);
		return myProduct;
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping("/category/{catId}/product/{prodId}")
	public String deleteProduct(@PathVariable("catId") Long prodCatId, @PathVariable("prodId") Long id) {
		productService.deleteProduct(prodCatId, id);	
		return "Product Deleted Successfully";
	}
	@CrossOrigin(origins = "*")
	@PutMapping("/category/{catId}/product/{prodId}")
	public Product updateProduct(@PathVariable("catId") Long prodCatId, @PathVariable("prodId") Long id, @RequestBody Product product) {
		Product updatedProd = productService.updateProduct(prodCatId, id, product);
		return updatedProd;
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/sendNotification")
	public SimpleMailMessage sendEmailMessage(@RequestBody Message emailMessage) {
		SimpleMailMessage myMessage = new SimpleMailMessage();
		String recipient = emailMessage.getTo();
        String senderSubject = emailMessage.getSubject();
        String myText = emailMessage.getText();
        myMessage.setTo(recipient);
        myMessage.setSubject(senderSubject);
        myMessage.setText(myText);
        javaMailSender.send(myMessage);
        
        return myMessage;
	}
	
}
