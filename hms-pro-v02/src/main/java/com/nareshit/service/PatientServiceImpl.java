package com.nareshit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.nareshit.bean.PatientBean;
import com.nareshit.dao.PatientDao;
import com.nareshit.domain.Patient;
import com.nareshit.utility.PatientMapper;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientDao patDao;
	
	@Override
	public PatientBean savePatient(Patient pat) {
		Patient patDoamin = patDao.addPatient(pat);
		return PatientMapper.mapDomainToBean(patDoamin);
	}

	@Override
	public List<PatientBean> getAllPatients() {
		List<Patient> doctList = patDao.getAllPatients();
		List<PatientBean> doctBeanList = PatientMapper.mapDomainListToBean(doctList.iterator());
		return doctBeanList;
	}

	@Override
	@PreAuthorize("hasPermission('ROLE_Admin','edit')")
	public PatientBean getPatientById(int id) {
		
        Patient pat = patDao.getPatientByid(id);
		return PatientMapper.mapDomainToBean(pat);
	}

	@Override
	public PatientBean updatePatient(Patient pat) {
		 pat = patDao.updatePatient(pat);
		return PatientMapper.mapDomainToBean(pat);
	}
	
	@Override
	public List<PatientBean> searchPatient(String patName, String serachValue) {
		String criteria = "";
		if (serachValue.equals("Name")) {
			criteria = criteria + "fname";
		} else {
			criteria = criteria + "email";
		}
		List<Patient> patList=patDao.searchPatient(patName, criteria);
		List<PatientBean> patBeanList=PatientMapper.mapDomainListToBean(patList.iterator());
		return patBeanList;
	}


}
