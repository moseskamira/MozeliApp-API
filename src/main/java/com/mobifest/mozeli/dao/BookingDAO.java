package com.mobifest.mozeli.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mobifest.mozeli.models.Booking;

@Repository
public interface BookingDAO extends JpaRepository<Booking, Long>{
	
	@Query("SELECT bookingObj FROM Booking bookingObj WHERE bookingObj.bookingReqTicket = ?1")
    Booking findByBookingReqTicket(String bookingReqTicket);
	
}
