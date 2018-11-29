package com.nareshit.service;

import org.springframework.stereotype.Service;

import com.nareshit.bean.HospitalBean;
import com.nareshit.domain.Hospital;


public interface HospitalService {

	public HospitalBean saveHospital(Hospital hosp);
	
}
