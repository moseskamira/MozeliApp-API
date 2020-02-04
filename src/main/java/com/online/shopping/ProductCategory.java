package com.online.shopping;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productCategory")
public class ProductCategory {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="catId",unique=true)
	Long catId;
	
	@Column(name="name")
	String catName;
	
	public ProductCategory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductCategory(Long catId, String catName) {
		super();
		this.catId = catId;
		this.catName = catName;
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
	@Override
	public String toString() {
		return "ProductCategory [catId=" + catId + ", catName=" + catName + "]";
	}
	
	
	
}
