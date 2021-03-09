package com.mobifest.mozeli.controllers;

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
import com.mobifest.mozeli.models.Admin;
import com.mobifest.mozeli.models.Booking;
import com.mobifest.mozeli.models.FeedBack;
import com.mobifest.mozeli.models.Message;
import com.mobifest.mozeli.models.Song;
import com.mobifest.mozeli.models.Album;
import com.mobifest.mozeli.models.Profile;
import com.mobifest.mozeli.models.Region;
import com.mobifest.mozeli.service.AdminService;
import com.mobifest.mozeli.service.BookingService;
import com.mobifest.mozeli.service.EmailNotificationService;
import com.mobifest.mozeli.service.FeedBackService;
import com.mobifest.mozeli.service.AlbumService;
import com.mobifest.mozeli.service.SongService;
import com.mobifest.mozeli.service.ProfileService;
import com.mobifest.mozeli.service.RegionService;
import com.mobifest.mozeli.utils.AuthenticationResponse;

import org.springframework.mail.SimpleMailMessage;

@RestController
@RequestMapping("mozeli")
public class MozeliQuickAppController {
	@Autowired
	AlbumService albumService;
	
	@Autowired
	SongService songService;
	
	@Autowired
	BookingService bookingService;
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	RegionService regionService;
	
	@Autowired
	ProfileService profileService;
	
	@Autowired
	FeedBackService feedBackService;
	
	@Autowired
	EmailNotificationService emailNotificationService;

	@CrossOrigin(origins = "*")
	@PostMapping("/login")
	public ResponseEntity<AuthenticationResponse> adminLogin(@RequestBody Admin myAdmin) throws Exception {
		ResponseEntity<AuthenticationResponse> response = null;
		return response = adminService.login(myAdmin);
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/album")
	public ResponseEntity<Album> addSongAlbum(@RequestBody Album songAlbum) {
		return albumService.addAlbum(songAlbum);
	}
	
	@GetMapping("/album/{albumId}")
	public ResponseEntity<Optional<Album>> fetchSingleAlbum(@PathVariable("albumId") Long id) {
		return albumService.getSingleAlbum(id);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/album")
	public ResponseEntity<List<Album>> fetchAllAlbums() {
		return albumService.getAllAlbum();
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping("/album/{albumId}")
	public ResponseEntity<String> deleteAlbum(@PathVariable("albumId") Long id) {
		return albumService.deleteAlbum(id);
	}
	
	@PutMapping("/album/{albumId}")
	public ResponseEntity<Album> updateAlbum(@PathVariable("albumId") Long id, @RequestBody Album album) {
		return albumService.updateAlbum(id, album);
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/album/{albumId}/song")
	public ResponseEntity<Song> addSong(@PathVariable("albumId") Long albumId, @RequestBody Song song) {
		return songService.saveSong(albumId, song);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/album/song")
	public ResponseEntity<List<Song>> fetchAllSong() {
		return songService.getAllSongsFromRecent();
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/album/{albumId}/song")
	public ResponseEntity<List<Song>> fetchSongsPerAlbum(@PathVariable("albumId") Long id) {
		return songService.getSongsPerAlbum(id);	
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/album/{albumId}/song/{songId}")
	public ResponseEntity<Song> fetchSingleProduct(@PathVariable("albumId") Long prodCatId, @PathVariable("songId") Long id) {
		return songService.getSingleSong(prodCatId, id);
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping("/album/{albumId}/song/{songId}")
	public String deleteSong(@PathVariable("albumId") Long albumId, @PathVariable("songId") Long id) {
		songService.deleteSong(albumId, id);	
		return "Song Deleted Successfully";
	}
	@CrossOrigin(origins = "*")
	@PutMapping("/album/{albumId}/song/{songId}")
	public ResponseEntity<Song> updateSong(@PathVariable("albumId") Long albumId, @PathVariable("songId") Long id, @RequestBody Song song) {
		return songService.updateSong(albumId, id, song);
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/sendNotification")
	public SimpleMailMessage sendEmailMessage(@RequestBody Message emailMessage) {
		return emailNotificationService.sendEmailMessage(emailMessage);
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/booking")
	public ResponseEntity<Booking> saveBookingReq(@RequestBody Booking booking) {
		return bookingService.saveBooking(booking);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/booking")
	public ResponseEntity<List<Booking>> fetchAllBookingReq() {
		return bookingService.getAllBookingReqs();	
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/booking/{bookingReqTicket}")
	public ResponseEntity<Booking> fetchByTicket(@PathVariable("bookingReqTicket") String ticketNo) {
		return bookingService.fetchByTicketNumber(ticketNo);	
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping("/booking/{bookingReqId}")
	public String deleteBookingReq(@PathVariable("bookingReqId") Long bookReqId) {
		return bookingService.deleteBookingReq(bookReqId);	
	}
	
	
	@CrossOrigin(origins = "*")
	@PostMapping("/region")
	public ResponseEntity<Region> addRegion(@RequestBody Region region) {
		return regionService.saveRegion(region);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/region")
	public ResponseEntity<List<Region>> fetchAllRegions() {
		return regionService.getAllRegions();	
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping("/region/{regionId}")
	public ResponseEntity<String> deleteRegion(@PathVariable("regionId") Long regionId) {
		return regionService.deleteRegion(regionId);	
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/admin")
	public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) {
		return adminService.saveAdmin(admin);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/admin")
	public ResponseEntity<List<Admin>> fetchAllAdmins() {
		return adminService.getAllAdmins();	
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping("/admin/{adminId}")
	public String deleteAdmin(@PathVariable("adminId") Long adminId) {
		return adminService.deleteAdmin(adminId);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/admin/{adminUserName}")
	public ResponseEntity<Admin> fetchByUserName(@PathVariable("adminUserName") String userName) {
		return adminService.getAdminByUserName(userName);	
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/profile")
	public Profile addNewProfile(@RequestBody Profile profile) {
		return profileService.saveProfile(profile);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/profile")
	public Profile fetchLatestProfile() {
		return profileService.getLastUpdatedProfile();	
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/profiles")
	public List<Profile> fetchAllProfiles() {
		return profileService.fetchAllProfiles();	
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping("/profile/{profileId}")
	public String deleteProfile(@PathVariable("profileId") Long profId) {
		return profileService.deleteProfile(profId);
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/comment")
	public ResponseEntity<FeedBack> addComment(@RequestBody FeedBack feedBack) {
		return feedBackService.addFeedBack(feedBack);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/comment")
	public ResponseEntity<List<FeedBack>> fetchAllComment() {
		return feedBackService.fetchAllComments();	
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping("/comment/{feedBackId}")
	public ResponseEntity<String> deleteComment(@PathVariable("feedBackId") Long feedId) {
		return feedBackService.deleteComment(feedId);
	}
	
}
