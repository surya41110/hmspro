package com.nareshit.utility;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.nareshit.bean.PatientBean;
import com.nareshit.domain.Patient;

public class PatientMapper {

	public static Patient mapBeanToDomain(PatientBean patBean) {
		Patient pat = new Patient();
		if(patBean.getId() > 0) {
			pat.setId(patBean.getId());
		}
		
		pat.setPassword(patBean.getPassword());
		pat.setConpassword(patBean.getCpassword());
		pat.setEmail(patBean.getEmail());
		pat.setFname(patBean.getFname());
		pat.setMobile(patBean.getMobile());
		
		
		//pat.setStatus(Boolean.parseBoolean(String.valueOf(Status.getCodeByName(patBean.getStatus()))));
		pat.setStatus(Boolean.parseBoolean(patBean.getStatus()));
		
		return pat;
		
	
	}
	
	public static PatientBean mapDomainToBean(Patient patDomain) {
		PatientBean pat = new PatientBean();
		pat.setId(patDomain.getId());
		pat.setEmail(patDomain.getEmail());
		pat.setFname(patDomain.getFname());
		pat.setMobile(patDomain.getMobile());
		
		
		boolean patStatus = patDomain.isStatus();
		pat.setStatus(String.valueOf(patStatus));
		/*pat.setStatus(String.valueOf(patStatus));
		List<AddressBean> addBeansList = null;
		List<Address> addrList = patDomain.getAddrList();
		if(addrList != null && addrList.size() >0) {
			addBeansList = new ArrayList<AddressBean>();
			for(Address ad : addrList) {
				addBeansList.add(AddressMapper.mapDomainToBean(ad));
			}
			pat.setAddrInfo(addBeansList);
		}*/
		
		return pat;
	}
	
	public static List<PatientBean> mapDomainListToBean(Iterator<Patient> patList){
		List<PatientBean> patBeansList = null;
		if(patList != null) {
			patBeansList = new ArrayList<PatientBean>();
			while(patList.hasNext()) {
				patBeansList.add(mapDomainToBean(patList.next()));
			}
		}
		return patBeansList;
	}
		
}
