package com.online.shopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.shopping.dao.BookingDAO;
import com.online.shopping.models.Booking;

@Service
public class BookingService {
	
	@Autowired
	BookingDAO bookingDao;
	
	public Booking saveBooking(Booking booking) {
		Booking myBookingObj = new Booking();
		myBookingObj.setCountry(booking.getCountry());
		myBookingObj.setEventName(booking.getEventName());
		myBookingObj.setEventDate(booking.getEventDate());
		myBookingObj.setEventTime(booking.getEventTime());
		myBookingObj.setVenueName(booking.getVenueName());
		myBookingObj.setSponsorFullName(booking.getSponsorFullName());
		myBookingObj.setSponsorNIN(booking.getSponsorNIN());
		myBookingObj.setSponsorPhone(booking.getSponsorPhone());
		myBookingObj.setSponsorEmail(booking.getSponsorEmail());
		myBookingObj.setBookingReqTicket(booking.getBookingReqTicket());
		
		Booking bookingObj = bookingDao.saveAndFlush(myBookingObj);
		return bookingObj;
	}
	
	public List<Booking> getAllBookingReqs() {
		List<Booking> bookingReqList = bookingDao.findAll();
		return bookingReqList;
	}
	
	public String deleteBookingReq(Long bookReqId) {
		Booking bookingReqToDelete = bookingDao.getOne(bookReqId);
		bookingDao.delete(bookingReqToDelete);
		return "Deleted Successfully";
	}

}
