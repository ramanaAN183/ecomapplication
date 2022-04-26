package com.ecom.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="user")
@Entity
public class UserModel {
	
	@Id
	@Column(name="id")
	private long id;
	
	@Column(name="username")
	private String name;
	
	@Column(name="password")
	private String password;

	@Column(name="user_role")
	private String role;
	
	@Column(name="is_active")
	private Boolean isActive;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "UserModel [id=" + id + ", name=" + name + ", password=" + password + ", role=" + role + ", isActive="
				+ isActive + "]";
	}
}
