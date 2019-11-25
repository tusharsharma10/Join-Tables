package com.learn.orm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="DEV_PG_TO_REV_JOIN")
public class DevPgToRevJoin {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name="ID")
	private Integer id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="FK_PG_DEV", referencedColumnName="ID")
	private DevPgJoin devPgJoin;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="FK_REV_ID",referencedColumnName="AUTH_ID")
	private User reviewer;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public DevPgJoin getDevPgJoin() {
		return devPgJoin;
	}


	public void setDevPgJoin(DevPgJoin devPgJoin) {
		this.devPgJoin = devPgJoin;
	}


	public User getReviewer() {
		return reviewer;
	}


	public void setReviewer(User reviewer) {
		this.reviewer = reviewer;
	}
	
	
	
}
