package com.learn.orm.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PROJECT_GROUP")
public class ProjectGroup {

	
	
	@Id
	@Column(name="PG_NAME")
	private String pgName;
	
	@Column(name="PROJECT_NAME")
	private String projectName;
	
	@Column(name="TEAM_NAME")
	private String teamName;
	
	@ManyToOne
	@JoinColumn(name="OWNER", referencedColumnName="AUTH_ID")
	private User user;
	
	
	
	
	
	
	@OneToMany(mappedBy = "projectGroup",cascade = CascadeType.ALL,orphanRemoval = true)
	private Set<DevPgJoin> devpgjoinSet;



	public String getPgName() {
		return pgName;
	}



	public void setPgName(String pgName) {
		this.pgName = pgName;
	}



	public String getProjectName() {
		return projectName;
	}



	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}






	public String getTeamName() {
		return teamName;
	}



	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	



	public Set<DevPgJoin> getDevpgjoinSet() {
		return devpgjoinSet;
	}



	public void setDevpgjoinSet(Set<DevPgJoin> devpgjoinSet) {
		this.devpgjoinSet = devpgjoinSet;
	}
	
	
	
	
	 

	

	
	
	
}
