package com.online.shopping.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin") 
public class Admin {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="adminId", unique=true)
	Long adminId;
	
	
	@Column(name="adminFullName")
	String adminFullName;
	
	@Column(name="adminUserName", unique=true)
	String adminUserName;
	
	@Column(name="adminPassword")
	String adminPassword;

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(Long adminId, String adminFullName, String adminUserName, String adminPassword) {
		super();
		this.adminId = adminId;
		this.adminFullName = adminFullName;
		this.adminUserName = adminUserName;
		this.adminPassword = adminPassword;
	}

	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	public String getAdminFullName() {
		return adminFullName;
	}

	public void setAdminFullName(String adminFullName) {
		this.adminFullName = adminFullName;
	}

	public String getAdminUserName() {
		return adminUserName;
	}

	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminFullName=" + adminFullName + ", adminUserName=" + adminUserName
				+ ", adminPassword=" + adminPassword + "]";
	}
	
	
	
	
	
	

}
