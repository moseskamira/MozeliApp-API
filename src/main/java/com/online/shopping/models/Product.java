package com.online.shopping.models;

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
@Table(name="product") 
public class Product {
	
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
	
	@Column(name="prodLike")
	boolean prodLike = false;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="catId")
	ProductCategory prodCat;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(Long prodId, String prodName, String prodDescrip, String prodImageUrl, boolean prodLike,
			ProductCategory prodCat, Long unitPrice) {
		super();
		this.prodId = prodId;
		this.prodName = prodName;
		this.prodDescrip = prodDescrip;
		this.prodImageUrl = prodImageUrl;
		this.prodLike = prodLike;
		this.prodCat = prodCat;
		this.unitPrice = unitPrice;
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

	public ProductCategory getProdCat() {
		return prodCat;
	}

	public void setProdCat(ProductCategory prodCat) {
		this.prodCat = prodCat;
	}
	
	

	public Long getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Long unitPrice) {
		this.unitPrice = unitPrice;
	}

	@Override
	public String toString() {
		return "Product [prodId=" + prodId + ", prodName=" + prodName + ", unitPrice=" + unitPrice + ", prodDescrip="
				+ prodDescrip + ", prodImageUrl=" + prodImageUrl + ", prodLike=" + prodLike + ", prodCat=" + prodCat
				+ "]";
	}

}
