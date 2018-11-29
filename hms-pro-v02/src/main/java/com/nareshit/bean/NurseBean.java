package com.nareshit.bean;

import java.io.Serializable;
import java.util.Set;

import com.nareshit.domain.Doctor;
import com.nareshit.domain.Nurse;

public class NurseBean extends UserBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Doctor doctor;

	private Set<Nurse> nurses;

}
