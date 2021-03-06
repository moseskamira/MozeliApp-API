package com.mobifest.mozeli.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mobifest.mozeli.dao.BookingDAO;
import com.mobifest.mozeli.models.Booking;

@Service
public class BookingService {
	
	@Autowired
	BookingDAO bookingDao;
	
	public ResponseEntity<Booking> saveBooking(Booking booking) {
		Booking myBookingObj = new Booking();
		myBookingObj.setCountry(booking.getCountry());
		myBookingObj.setCountryRegion(booking.getCountryRegion());
		myBookingObj.setCountryCurrency(booking.getCountryCurrency());
		myBookingObj.setRegionalAmount(booking.getRegionalAmount());
		myBookingObj.setEventName(booking.getEventName());
		myBookingObj.setEventDate(booking.getEventDate());
		myBookingObj.setEventTime(booking.getEventTime());
		myBookingObj.setVenueName(booking.getVenueName());
		myBookingObj.setSponsorFullName(booking.getSponsorFullName());
		myBookingObj.setSponsorNIN(booking.getSponsorNIN());
		myBookingObj.setSponsorPhone(booking.getSponsorPhone());
		myBookingObj.setSponsorEmail(booking.getSponsorEmail());
		myBookingObj.setSponsorLocation(booking.getSponsorLocation());
		myBookingObj.setBookingReqTicket(booking.getBookingReqTicket());
		
		Booking bookingObj = bookingDao.saveAndFlush(myBookingObj);
		return ResponseEntity.ok().body(bookingObj);
	}
	
	public ResponseEntity<List<Booking>> getAllBookingReqs() {
		List<Booking> bookingReqList = bookingDao.findAll();
		return !bookingReqList.isEmpty() ? ResponseEntity.ok().body(bookingReqList) : ResponseEntity.ok().body(new ArrayList<Booking>());
	}
	
	public String deleteBookingReq(Long bookReqId) {
		Booking bookingReqToDelete = bookingDao.getOne(bookReqId);
		if (bookingReqToDelete != null) {
			if (!bookingReqToDelete.getSponsorFullName().isEmpty()) {
				bookingDao.delete(bookingReqToDelete);
				return "Deleted Successfully";
			}else {
				return "Could Not Find Booking Request";
			}
		}else {
			return "Invalid Id Provided";
		}
	}
	
	public ResponseEntity<Booking> fetchByTicketNumber(String ticketNumber) {
		Booking booking = bookingDao.findByBookingReqTicket(ticketNumber);
		return booking != null ? ResponseEntity.ok().body(booking) : ResponseEntity.ok().body(returnEmptyBookingObj());
	}
	
	private Booking returnEmptyBookingObj() {
		Booking emptyBookingObj = new Booking();
		emptyBookingObj.setSponsorFullName("");
		return emptyBookingObj; 
	}
	
}
