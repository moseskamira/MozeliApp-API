package com.mobifest.mozeli.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="region") 
public class Region {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="regionId", unique=true)
	Long regionId;
	
	@Column(name="regionName")
	String regionName;
	
	@Column(name="regionAmount")
	String regionAmount;

	public Region() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Region(Long regionId, String regionName, String regionAmount) {
		super();
		this.regionId = regionId;
		this.regionName = regionName;
		this.regionAmount = regionAmount;
	}

	public Long getRegionId() {
		return regionId;
	}

	public void setRegionId(Long regionId) {
		this.regionId = regionId;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getRegionAmount() {
		return regionAmount;
	}

	public void setRegionAmount(String regionAmount) {
		this.regionAmount = regionAmount;
	}

	@Override
	public String toString() {
		return "Region [regionId=" + regionId + ", regionName=" + regionName + ", regionAmount=" + regionAmount + "]";
	}
	
	
	
	

}
