package com.learn.orm.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="USER")
public class User {

	@Id
	@Column(name="AUTH_ID")
	private String authId;
	
	
	@Column(name="AUTH_Name")
	private String authName;


	@OneToMany(mappedBy="user")
	private Set<ProjectGroup> projectGroupSet;
	
	@OneToMany(mappedBy = "developer",cascade = CascadeType.ALL,orphanRemoval = true)
	private Set<DevPgJoin> devPgJoinSet;
	
	
	@OneToMany(mappedBy = "reviewer",cascade = CascadeType.ALL,orphanRemoval = true)
	private Set<DevPgToRevJoin> devPgToRevJoinSet;


	public String getAuthId() {
		return authId;
	}


	public void setAuthId(String authId) {
		this.authId = authId;
	}


	public String getAuthName() {
		return authName;
	}


	public void setAuthName(String authName) {
		this.authName = authName;
	}


	public Set<ProjectGroup> getProjectGroupSet() {
		return projectGroupSet;
	}


	public void setProjectGroupSet(Set<ProjectGroup> projectGroupSet) {
		this.projectGroupSet = projectGroupSet;
	}


	public Set<DevPgJoin> getDevPgJoinSet() {
		return devPgJoinSet;
	}


	public void setDevPgJoinSet(Set<DevPgJoin> devPgJoinSet) {
		this.devPgJoinSet = devPgJoinSet;
	}


	public Set<DevPgToRevJoin> getDevPgToRevJoinSet() {
		return devPgToRevJoinSet;
	}


	public void setDevPgToRevJoinSet(Set<DevPgToRevJoin> devPgToRevJoinSet) {
		this.devPgToRevJoinSet = devPgToRevJoinSet;
	}
	


	
	
		
	
	
	
}
