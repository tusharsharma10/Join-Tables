package com.learn.orm.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="DEV_PG_JOIN")
public class DevPgJoin {

	@Id
	private String id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private ProjectGroup projectGroup;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private User developer;
	
	
	@OneToMany(mappedBy="devPgJoin",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<DevPgToRevJoin> devPgToRevJoinSet;


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public ProjectGroup getProjectGroup() {
		return projectGroup;
	}


	public void setProjectGroup(ProjectGroup projectGroup) {
		this.projectGroup = projectGroup;
	}


	public User getDeveloper() {
		return developer;
	}


	public void setDeveloper(User developer) {
		this.developer = developer;
	}


	public Set<DevPgToRevJoin> getDevPgToRevJoinSet() {
		return devPgToRevJoinSet;
	}


	public void setDevPgToRevJoinSet(Set<DevPgToRevJoin> devPgToRevJoinSet) {
		this.devPgToRevJoinSet = devPgToRevJoinSet;
	}
	
	
	
}
