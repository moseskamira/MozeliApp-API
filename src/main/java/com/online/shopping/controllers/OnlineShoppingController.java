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
	ProductCategoryService albumService;
	
	@Autowired
	ProductService songService;
	
	@Autowired
	BookingService bookingService;
	
	@Autowired
    private JavaMailSender javaMailSender;

	@CrossOrigin(origins = "*")
	@PostMapping("/album")
	public ProductCategory addSongAlbum(@RequestBody ProductCategory songAlbum) {
		ProductCategory addedAlum = albumService.addAlbum(songAlbum);
		return addedAlum;
	}
	
	@GetMapping("/album/{albumId}")
	public Optional<ProductCategory> fetchSingleAlbum(@PathVariable("albumId") Long id) {
		Optional<ProductCategory> fetchedAlbum = albumService.getSingleAlbum(id);
		return fetchedAlbum;
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/album")
	public ResponseEntity<List<ProductCategory>> fetchAllAlbums() {
		List<ProductCategory> albumList = albumService.getAllAlbum();
		return ResponseEntity.ok().body(albumList);
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping("/album/{albumId}")
	public String deleteAlbum(@PathVariable("albumId") Long id) {
		albumService.deleteAlbum(id);
		return "Successfully Deleted Album";
	}
	
	@PutMapping("/album/{albumId}")
	public ProductCategory updateAlbum(@PathVariable("albumId") Long id, @RequestBody ProductCategory album) {
		ProductCategory updatedAlbum = albumService.updateAlbum(id, album);
		return updatedAlbum;
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/album/{albumId}/song")
	public Product addSong(@PathVariable("albumId") Long albumId, @RequestBody Product song) {
		Product addedSong = songService.saveSong(albumId, song);
		return addedSong;
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/album/song")
	public List<Product> fetchAllSong() {
		List<Product> songsList = songService.getAllSongs();
		return songsList;
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/album/{albumId}/song")
	public List<Product> fetchSongsPerAlbum(@PathVariable("albumId") Long id) {
		List<Product> songsList = songService.getSongsPerAlbum(id);	
		return songsList;
	}
	@CrossOrigin(origins = "*")
	@GetMapping("/album/{albumId}/song/{songId}")
	public Product fetchSingleProduct(@PathVariable("albumId") Long prodCatId, @PathVariable("songId") Long id) {
		Product myProduct = songService.getSingleSong(prodCatId, id);
		return myProduct;
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping("/album/{albumId}/song/{songId}")
	public String deleteSong(@PathVariable("albumId") Long albumId, @PathVariable("songId") Long id) {
		songService.deleteSong(albumId, id);	
		return "Song Deleted Successfully";
	}
	@CrossOrigin(origins = "*")
	@PutMapping("/album/{albumId}/song/{songId}")
	public Product updateSong(@PathVariable("albumId") Long albumId, @PathVariable("songId") Long id, @RequestBody Product song) {
		Product updatedSong = songService.updateSong(albumId, id, song);
		return updatedSong;
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
