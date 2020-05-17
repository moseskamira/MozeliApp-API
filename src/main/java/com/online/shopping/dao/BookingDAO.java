package com.online.shopping.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.online.shopping.models.Booking;

@Repository
public interface BookingDAO extends JpaRepository<Booking, Long>{
	

}
