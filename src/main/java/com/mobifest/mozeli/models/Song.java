package com.mobifest.mozeli.models;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="songTable") 
public class Song {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="prodId", unique=true)
	Long prodId;
	
	@Column(name="prodName")
	String prodName;
	
	@Column(name="unitPrice")
	Long unitPrice;
	
	@Column(name="prodDescrip")
	String prodDescrip;
	
	@Column(name="prodImageUrl")
	String prodImageUrl;
	
	@Column(name="audioUrl")
	String audioUrl;
	
	@Column(name="studioName")
	String studioName;
	
	@Column(name="producerName")
	String producerName;
	
	@Column(name="prodLike")
	boolean prodLike = false;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="catId")
	Album prodCat;

	public Song() {
		super();
	}

	public Song(Long prodId, String prodName, Long unitPrice, String prodDescrip, String prodImageUrl,
			String audioUrl, String studioName, String producerName, boolean prodLike, Album prodCat) {
		super();
		this.prodId = prodId;
		this.prodName = prodName;
		this.unitPrice = unitPrice;
		this.prodDescrip = prodDescrip;
		this.prodImageUrl = prodImageUrl;
		this.audioUrl = audioUrl;
		this.studioName = studioName;
		this.producerName = producerName;
		this.prodLike = prodLike;
		this.prodCat = prodCat;
	}

	public Long getProdId() {
		return prodId;
	}

	public void setProdId(Long prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getProdDescrip() {
		return prodDescrip;
	}

	public void setProdDescrip(String prodDescrip) {
		this.prodDescrip = prodDescrip;
	}

	public String getProdImageUrl() {
		return prodImageUrl;
	}

	public void setProdImageUrl(String prodImageUrl) {
		this.prodImageUrl = prodImageUrl;
	}

	public boolean isProdLike() {
		return prodLike;
	}

	public void setProdLike(boolean prodLike) {
		this.prodLike = prodLike;
	}

	public Album getProdCat() {
		return prodCat;
	}

	public void setProdCat(Album prodCat) {
		this.prodCat = prodCat;
	}
	
	public Long getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Long unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getAudioUrl() {
		return audioUrl;
	}

	public void setAudioUrl(String audioUrl) {
		this.audioUrl = audioUrl;
	}

	public String getStudioName() {
		return studioName;
	}

	public void setStudioName(String studioName) {
		this.studioName = studioName;
	}

	public String getProducerName() {
		return producerName;
	}

	public void setProducerName(String producerName) {
		this.producerName = producerName;
	}

	@Override
	public String toString() {
		return "Song [prodId=" + prodId + ", prodName=" + prodName + ", unitPrice=" + unitPrice + ", prodDescrip="
				+ prodDescrip + ", prodImageUrl=" + prodImageUrl + ", audioUrl=" + audioUrl + ", studioName="
				+ studioName + ", producerName=" + producerName + ", prodLike=" + prodLike + ", prodCat=" + prodCat
				+ "]";
	}

}
