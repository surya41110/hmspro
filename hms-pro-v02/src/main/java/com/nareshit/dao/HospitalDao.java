package com.nareshit.dao;

import java.util.List;

import com.nareshit.domain.Hospital;

public interface HospitalDao {

	public Hospital addHospital(Hospital hosp);
	public Hospital getHospitalByid(int id);
	public List<Hospital> getAllHospitals();
	public List<Hospital> searchHospital(String name, String email);
	
}
