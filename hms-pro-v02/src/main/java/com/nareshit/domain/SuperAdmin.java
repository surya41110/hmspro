package com.nareshit.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="SuperAdmin")
@PrimaryKeyJoinColumn(name="profile_id")
public class SuperAdmin extends User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@OneToMany
	private List<Hospital> hospitals;
	
	/*@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="sid")
	private Integer id;*/

	//setters and getters
	
	public List<Hospital> getHospitals() {
		return hospitals;
	}
	public void setHospitals(List<Hospital> hospitals) {
		this.hospitals = hospitals;
	}
	
	
	
	
	
	//default constructor
	public SuperAdmin() {
		super();
	}
	//parameterized constructor
	public SuperAdmin(List<Hospital> hospitals, Integer id) {
		super();
		this.hospitals = hospitals;
	}
	
	
	
	//toString method
	@Override
	public String toString() {
		return "SuperAdmin [hospitals=" + hospitals + ", id=" + 0 + "]";
	}
	
	
}
