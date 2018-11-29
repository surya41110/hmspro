package com.nareshit.utility;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.nareshit.bean.NurseBean;
import com.nareshit.domain.Nurse;

public class NurseMapper {

	public static Nurse mapBeanToDomain(NurseBean nurBean) {
		Nurse nur = new Nurse();
		if (nurBean.getId() > 0) {
			nur.setId(nurBean.getId());
		}

		nur.setPassword(nurBean.getPassword());
		nur.setConpassword(nurBean.getCpassword());
		nur.setEmail(nurBean.getEmail());
		nur.setFname(nurBean.getFname());
		nur.setMobile(nurBean.getMobile());

		// nur.setStatus(Boolean.parseBoolean(String.valueOf(Status.getCodeByName(nurBean.getStatus()))));
		nur.setStatus(Boolean.parseBoolean(nurBean.getStatus()));

		return nur;

	}

	public static NurseBean mapDomainToBean(Nurse nurDomain) {
		NurseBean nur = new NurseBean();
		nur.setId(nurDomain.getId());
		nur.setEmail(nurDomain.getEmail());
		nur.setFname(nurDomain.getFname());
		nur.setMobile(nurDomain.getMobile());

		boolean nurStatus = nurDomain.isStatus();
		nur.setStatus(String.valueOf(nurStatus));
		/*
		 * nur.setStatus(String.valueOf(nurStatus)); List<AddressBean> addBeansList =
		 * null; List<Address> addrList = nurDomain.getAddrList(); if(addrList != null
		 * && addrList.size() >0) { addBeansList = new ArrayList<AddressBean>();
		 * for(Address ad : addrList) {
		 * addBeansList.add(AddressMapper.mapDomainToBean(ad)); }
		 * nur.setAddrInfo(addBeansList); }
		 */

		return nur;
	}

	public static List<NurseBean> mapDomainListToBean(Iterator<Nurse> nurList) {
		List<NurseBean> nurBeansList = null;
		if (nurList != null) {
			nurBeansList = new ArrayList<NurseBean>();
			while (nurList.hasNext()) {
				nurBeansList.add(mapDomainToBean(nurList.next()));
			}
		}
		return nurBeansList;
	}

}
