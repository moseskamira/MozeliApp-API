package com.mobifest.mozeli.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="profile") 
public class Profile {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="profileId", unique=true)
	Long profileId;
	
	@Column(name="pdfFileUrl")
	String pdfFileUrl;

	public Profile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Profile(Long profileId, String pdfFileUrl) {
		super();
		this.profileId = profileId;
		this.pdfFileUrl = pdfFileUrl;
	}

	public Long getProfileId() {
		return profileId;
	}

	public void setProfileId(Long profileId) {
		this.profileId = profileId;
	}

	public String getPdfFileUrl() {
		return pdfFileUrl;
	}

	public void setPdfFileUrl(String pdfFileUrl) {
		this.pdfFileUrl = pdfFileUrl;
	}

	@Override
	public String toString() {
		return "Profile [profileId=" + profileId + ", pdfFileUrl=" + pdfFileUrl + "]";
	}
	
	

}
