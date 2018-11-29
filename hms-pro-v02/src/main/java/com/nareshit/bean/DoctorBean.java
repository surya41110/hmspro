package com.nareshit.bean;

import java.io.Serializable;
import java.util.List;

public class DoctorBean extends UserBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private List<PatientBean> pinfo;

	private String experience;
	
	private String role;
	
	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getExperience() {
		return experience;
	}


	public void setExperience(String experience) {
		this.experience = experience;
	}


	public List<String> getSpecialization() {
		return specialization;
	}


	public void setSpecialization(List<String> specialization) {
		this.specialization = specialization;
	}


	private List<String> specialization;
	private String specialist;

	
	//setters and gettters
	
	public String getSpecialist() {
		return specialist;
	}


	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}


	public List<PatientBean> getPinfo() {
		return pinfo;
	}


	public void setPinfo(List<PatientBean> pinfo) {
		this.pinfo = pinfo;
	}

	// hashcode and equals method
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((pinfo == null) ? 0 : pinfo.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		DoctorBean other = (DoctorBean) obj;
		if (pinfo == null) {
			if (other.pinfo != null)
				return false;
		} else if (!pinfo.equals(other.pinfo))
			return false;
		return true;
	}
	
	
	
	
	

}
