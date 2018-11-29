package com.nareshit.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nareshit.bean.HospitalBean;
import com.nareshit.domain.Hospital;
import com.nareshit.utility.Status;

//@Repository
public abstract class HospitalRepository implements CrudRepository<Hospital, Integer> {

	public List<Hospital>  findHospitalByName(String name){
		return null;
		
	}
	
	public Hospital mapBeanToDomain(HospitalBean hospBean) {
		Hospital hosp = new Hospital();
		hosp.setEmail(hospBean.getEmail());
		hosp.setName(hospBean.getName());
		hosp.setFax(hospBean.getFax());
		hosp.setPhone(hospBean.getPhone());
		hosp.setStatus(Boolean.parseBoolean(String.valueOf(Status.getCodeByName(hospBean.getStatus()))));
		
		return hosp;
		
	
	}
	
}
