package com.exam.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class User_role {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userRoleid;
	
	//User
	@ManyToOne(fetch = FetchType.EAGER)
	private User user;
	
	//role
	@ManyToOne(fetch = FetchType.LAZY)
	private Role role;
	

	public User_role() {}


	public User_role(Long userRoleid, User user, Role role) {
		this.userRoleid = userRoleid;
		this.user = user;
		this.role = role;
	}


	public Long getUserRoleid() {
		return userRoleid;
	}


	public void setUserRoleid(Long userRoleid) {
		this.userRoleid = userRoleid;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}
	
	
	
	
}
