package com.nareshit.service;

import java.util.List;


import com.nareshit.bean.PatientBean;
import com.nareshit.domain.Patient;


public interface PatientService {

	public PatientBean savePatient(Patient hosp);
	public PatientBean updatePatient(Patient pat);
	public PatientBean getPatientById(int id);
	public List<PatientBean> getAllPatients();
	public List<PatientBean> searchPatient(String patName, String criteria);
}
