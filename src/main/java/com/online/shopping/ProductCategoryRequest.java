package com.online.shopping;

import javax.validation.constraints.NotBlank;


public class ProductCategoryRequest {
	Long catId;
	
	@NotBlank
	String catName;

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
		return "ProductCategoryRequest [catId=" + catId + ", catName=" + catName + "]";
	}
	
	
	
	

}
