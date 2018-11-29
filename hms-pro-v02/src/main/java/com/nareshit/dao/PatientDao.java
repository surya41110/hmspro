package com.nareshit.dao;

import java.util.List;

import com.nareshit.domain.Patient;

public interface PatientDao {

	public Patient addPatient(Patient hosp);
	public Patient updatePatient(Patient hosp);
	public Patient getPatientByid(int id);
	public List<Patient> getAllPatients();
	public List<Patient> searchPatient(String name, String email);
	
}
