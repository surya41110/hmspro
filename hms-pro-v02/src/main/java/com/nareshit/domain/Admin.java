package com.nareshit.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="ADMIN")
@PrimaryKeyJoinColumn(name="profile_id")
public class Admin extends User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
/*
	@OneToOne
	private Hospital hospital;
	
	@OneToMany
	private Set<Doctor> doctors;*/
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="aid")
	private Integer id;


}
