package com.mobifest.mozeli.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="feedBack")
public class FeedBack {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="feedBackId", unique=true)
	Long feedBackId;
	
	@Column(name="commenterFullName")
	String commenterFullName;
	
	@Column(name="commenterEmail")
	String commenterEmail;
	
	@Column(name="commenterText")
	String commenterText;

	public FeedBack() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FeedBack(Long feedBackId, String commenterFullName, String commenterEmail, String commenterText) {
		super();
		this.feedBackId = feedBackId;
		this.commenterFullName = commenterFullName;
		this.commenterEmail = commenterEmail;
		this.commenterText = commenterText;
	}

	
	
	public Long getFeedBackId() {
		return feedBackId;
	}

	public void setFeedBackId(Long feedBackId) {
		this.feedBackId = feedBackId;
	}

	public String getCommenterFullName() {
		return commenterFullName;
	}

	public void setCommenterFullName(String commenterFullName) {
		this.commenterFullName = commenterFullName;
	}

	public String getCommenterEmail() {
		return commenterEmail;
	}

	public void setCommenterEmail(String commenterEmail) {
		this.commenterEmail = commenterEmail;
	}

	public String getCommenterText() {
		return commenterText;
	}

	public void setCommenterText(String commenterText) {
		this.commenterText = commenterText;
	}

	@Override
	public String toString() {
		return "FeedBack [feedBackId=" + feedBackId + ", commenterFullName=" + commenterFullName + ", commenterEmail="
				+ commenterEmail + ", commenterText=" + commenterText + "]";
	}

}
