package com.mobifest.mozeli.models;


import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="productCategory")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class Album {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="catId",unique=true)
	Long catId;
	
	@Column(name="name")
	String catName;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "prodCat", fetch = FetchType.LAZY)
	 @JsonIgnore
	List<Song> products; 
	
	public Album() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Album(Long catId, String catName, List<Song> products) {
		super();
		this.catId = catId;
		this.catName = catName;
		this.products = products;
	}
	public Long getCatId() {
		return catId;
	}
	public void setCatId(Long catId) {
		this.catId = catId;
	}
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	public List<Song> getProducts() {
		return products;
	}
	public void setProducts(List<Song> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Album [catId=" + catId + ", catName=" + catName + ", products=" + products + "]";
	}
}
