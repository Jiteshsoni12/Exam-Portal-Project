package com.exam.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table (name="roles")
public class Role {
	@Id
	private Long id;
	private String roleName;
	
	
	public Role() {}


	public Role(Long id, String roleName) {
		this.id = id;
		this.roleName = roleName;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "role")
	@JsonIgnore
	private Set<User_role> userRoles = new HashSet<>();
	
	

	public Set<User_role> getUserRoles() {
		return userRoles;
	}


	public void setUserRoles(Set<User_role> userRoles) {
		this.userRoles = userRoles;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
	
	
	
}
