package com.nareshit.dao;

import java.util.List;

import com.nareshit.domain.Doctor;

public interface DoctorDao {

	public Doctor addDoctor(Doctor doc);
	public Doctor getDoctorByid(int id);
	public List<Doctor> getAllDoctors();
	public List<Doctor> searchDoctor(String name, String email);
	public Doctor updateDoctor(Doctor doc);
	public void deleteDoctor(int id);
	
}
