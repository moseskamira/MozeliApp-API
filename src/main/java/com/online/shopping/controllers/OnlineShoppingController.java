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

import com.online.shopping.models.Booking;
import com.online.shopping.models.Message;
import com.online.shopping.models.Product;
import com.online.shopping.models.ProductCategory;
import com.online.shopping.service.BookingService;
import com.online.shopping.service.ProductCategoryService;
import com.online.shopping.service.ProductService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@RestController
@RequestMapping("mozeli")
public class OnlineShoppingController {
	@Autowired
	ProductCategoryService prodCatService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	BookingService bookingService;
	
	@Autowired
    private JavaMailSender javaMailSender;

	@CrossOrigin(origins = "*")
	@PostMapping("/album")
	public ProductCategory addProductCategory(@RequestBody ProductCategory prodCat) {
		ProductCategory addedProdCat = prodCatService.addProductCategory(prodCat);
		return addedProdCat;
	}
	
	@GetMapping("/album/{albumId}")
	public Optional<ProductCategory> fetchSingleProductCategory(@PathVariable("albumId") Long id) {
		Optional<ProductCategory> fetchedProdCat = prodCatService.getSingleProductCategory(id);
		return fetchedProdCat;
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/album")
	public ResponseEntity<List<ProductCategory>> fetAllProductCategories() {
		List<ProductCategory> prodCatList = prodCatService.getAllProductCategories();
		return ResponseEntity.ok().body(prodCatList);
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping("/album/{albumId}")
	public String deleteProductCategory(@PathVariable("albumId") Long id) {
		prodCatService.deleteProductCategory(id);
		return "Successfully Deleted Product Category";
	}
	
	@PutMapping("/album/{albumId}")
	public ProductCategory updateProductCategory(@PathVariable("albumId") Long id, @RequestBody ProductCategory prodCat) {
		ProductCategory updatedProdCat = prodCatService.updateProductCategory(id, prodCat);
		return updatedProdCat;
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/album/{albumId}/song")
	public Product addProduct(@PathVariable("albumId") Long prodCatId, @RequestBody Product product) {
		Product addedProduct = productService.saveProduct(prodCatId, product);
		return addedProduct;
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/album/song")
	public List<Product> fetchAllProducts() {
		List<Product> productsList = productService.getAllProducts();
		return productsList;
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/album/{albumId}/song")
	public List<Product> fetchProductsPerCategory(@PathVariable("albumId") Long id) {
		List<Product> catProductsList = productService.getProductsPerCategory(id);	
		return catProductsList;
	}
	@CrossOrigin(origins = "*")
	@GetMapping("/album/{albumId}/song/{songId}")
	public Product fetchSingleProduct(@PathVariable("albumId") Long prodCatId, @PathVariable("songId") Long id) {
		Product myProduct = productService.getSingleProduct(prodCatId, id);
		return myProduct;
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping("/album/{albumId}/song/{songId}")
	public String deleteProduct(@PathVariable("albumId") Long prodCatId, @PathVariable("songId") Long id) {
		productService.deleteProduct(prodCatId, id);	
		return "Product Deleted Successfully";
	}
	@CrossOrigin(origins = "*")
	@PutMapping("/album/{albumId}/song/{songId}")
	public Product updateProduct(@PathVariable("albumId") Long prodCatId, @PathVariable("songId") Long id, @RequestBody Product product) {
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
	
	@CrossOrigin(origins = "*")
	@PostMapping("/booking")
	public Booking saveBookingReq(@RequestBody Booking booking) {
		Booking savedBookingReq = bookingService.saveBooking(booking);
		return savedBookingReq;
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/booking")
	public List<Booking> fetchAllBookingReq() {
		List<Booking> bookingReqList = bookingService.getAllBookingReqs();	
		return bookingReqList;
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping("/booking")
	public String deleteBookingReq(@PathVariable("bookingReqId") Long bookReqId) {
		bookingService.deleteBookingReq(bookReqId);	
		return "BookingReq Deleted Successfully";
	}

	
}
