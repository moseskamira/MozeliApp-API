package com.online.shopping.models;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

@Entity
@Table(name="booking") 
public class Booking {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="bookingReqId", unique=true)
	Long bookingReqId;
	
	@Column(name="country")
	String country;
	
	@Column(name="countryRegion")
	@Nullable
	String countryRegion;
	
	@Column(name="regionalAmount")
	@Nullable
	Double regionalAmount;
	
	@Column(name="eventName")
	String eventName;
	
	@Column(name="venueName")
	String venueName;
	
	@Column(name="eventDate")
	String eventDate;
	
	@Column(name="eventTime")
	String eventTime;
	
	@Column(name="bookingReqTicket")
	String bookingReqTicket;
	
	@Column(name="sponsorFullName")
	String sponsorFullName;
	
	@Column(name="sponsorNIN")
	String sponsorNIN;
	
	@Column(name="sponsorPhone")
	String sponsorPhone;
	
	@Column(name="sponsorEmail")
	String sponsorEmail;
	
	@Column(name="sponsorLocation")
	String sponsorLocation;

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Booking(Long bookingReqId, String country, String countryRegion, Double regionalAmount, String eventName,
			String venueName, String eventDate, String eventTime, String bookingReqTicket, String sponsorFullName,
			String sponsorNIN, String sponsorPhone, String sponsorEmail, String sponsorLocation) {
		super();
		this.bookingReqId = bookingReqId;
		this.country = country;
		this.countryRegion = countryRegion;
		this.regionalAmount = regionalAmount;
		this.eventName = eventName;
		this.venueName = venueName;
		this.eventDate = eventDate;
		this.eventTime = eventTime;
		this.bookingReqTicket = bookingReqTicket;
		this.sponsorFullName = sponsorFullName;
		this.sponsorNIN = sponsorNIN;
		this.sponsorPhone = sponsorPhone;
		this.sponsorEmail = sponsorEmail;
		this.sponsorLocation = sponsorLocation;
	}

	public Long getBookingReqId() {
		return bookingReqId;
	}

	public void setBookingReqId(Long bookingReqId) {
		this.bookingReqId = bookingReqId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getVenueName() {
		return venueName;
	}

	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}

	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	public String getEventTime() {
		return eventTime;
	}

	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}

	public String getSponsorFullName() {
		return sponsorFullName;
	}

	public void setSponsorFullName(String sponsorFullName) {
		this.sponsorFullName = sponsorFullName;
	}

	public String getSponsorNIN() {
		return sponsorNIN;
	}

	public void setSponsorNIN(String sponsorNIN) {
		this.sponsorNIN = sponsorNIN;
	}

	public String getSponsorPhone() {
		return sponsorPhone;
	}

	public void setSponsorPhone(String sponsorPhone) {
		this.sponsorPhone = sponsorPhone;
	}

	public String getSponsorEmail() {
		return sponsorEmail;
	}

	public void setSponsorEmail(String sponsorEmail) {
		this.sponsorEmail = sponsorEmail;
	}

	public String getBookingReqTicket() {
		return bookingReqTicket;
	}

	public void setBookingReqTicket(String bookingReqTicket) {
		this.bookingReqTicket = bookingReqTicket;
	}

	public String getCountryRegion() {
		return countryRegion;
	}

	public void setCountryRegion(String countryRegion) {
		this.countryRegion = countryRegion;
	}

	public Double getRegionalAmount() {
		return regionalAmount;
	}

	public void setRegionalAmount(Double regionalAmount) {
		this.regionalAmount = regionalAmount;
	}

	public String getSponsorLocation() {
		return sponsorLocation;
	}

	public void setSponsorLocation(String sponsorLocation) {
		this.sponsorLocation = sponsorLocation;
	}



	@Override
	public String toString() {
		return "Booking [bookingReqId=" + bookingReqId + ", country=" + country + ", countryRegion=" + countryRegion
				+ ", regionalAmount=" + regionalAmount + ", eventName=" + eventName + ", venueName=" + venueName
				+ ", eventDate=" + eventDate + ", eventTime=" + eventTime + ", bookingReqTicket=" + bookingReqTicket
				+ ", sponsorFullName=" + sponsorFullName + ", sponsorNIN=" + sponsorNIN + ", sponsorPhone="
				+ sponsorPhone + ", sponsorEmail=" + sponsorEmail + ", sponsorLocation=" + sponsorLocation + "]";
	}

	
	
}
