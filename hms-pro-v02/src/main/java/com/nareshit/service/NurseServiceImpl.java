package com.nareshit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nareshit.bean.NurseBean;
import com.nareshit.dao.NurseDao;
import com.nareshit.dao.RoleDao;
import com.nareshit.domain.Nurse;
import com.nareshit.utility.NurseMapper;

@Service
public class NurseServiceImpl implements NurseService {

	@Autowired
	private NurseDao nurDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private BCryptPasswordEncoder pwdEncoder;
	
	@Override
	public NurseBean saveNurse(NurseBean hosp) {
		Nurse nur = mapBeanToDomain(hosp);
		Nurse hospDoamin = nurDao.addNurse(nur);
		return NurseMapper.mapDomainToBean(hospDoamin);
	}

	@Override
	public List<NurseBean> getAllNurses() {
		List<Nurse> nurseList = nurDao.getAllNurses();
		List<NurseBean> nurseBeanList = NurseMapper.mapDomainListToBean(nurseList.iterator());
		return nurseBeanList;
	}
	
	@Override
	public NurseBean getNurseByid(int id) {
		Nurse Nurse = nurDao.getNurseByid(id);
		NurseBean NurseBean = NurseMapper.mapDomainToBean(Nurse);
		return NurseBean;
	}

	@Override
	public List<NurseBean> searchNurse(String name, String serachValue) {
		String criteria = "";
		if (serachValue.equals("Name")) {
			criteria = criteria + "fname";
		} else {
			criteria = criteria + "email";
		}
		List<Nurse> nurseList = nurDao.searchNurse(name, criteria);

		List<NurseBean> nurseBeanList = NurseMapper.mapDomainListToBean(nurseList.iterator());
		return nurseBeanList;
	}

	@Override
	public NurseBean updateNurse(NurseBean nurBean) {
		Nurse Nurse = NurseMapper.mapBeanToDomain(nurBean);
		Nurse = nurDao.updateNurse(Nurse);
		nurBean = NurseMapper.mapDomainToBean(Nurse);
		return nurBean;
	}

	@Override
	public void deleteNurse(int id) {
		System.out.println("nur serv del");
		nurDao.deleteNurse(id);
	}
	
	public Nurse mapBeanToDomain(NurseBean nurseBean) {
		Nurse nurse = new Nurse();
		if(nurseBean.getId() > 0) {
			nurse.setId(nurseBean.getId());
		}
		
		String pwdSathHash = pwdEncoder.encode(nurseBean.getPassword());
		String cpwdSaltHash = pwdEncoder.encode(nurseBean.getCpassword());
		
		/*nurse.setPassword(nurseBean.getPassword());
		nurse.setConpassword(nurseBean.getCpassword());*/
		nurse.setPassword(pwdSathHash);
		nurse.setConpassword(cpwdSaltHash);
		nurse.setEmail(nurseBean.getEmail());
		nurse.setFname(nurseBean.getFname());
		nurse.setMobile(nurseBean.getMobile());
		
		
		//nurse.setStatus(Boolean.parseBoolean(String.valueOf(Status.getCodeByName(nurseBean.getStatus()))));
		nurse.setStatus(Boolean.parseBoolean(nurseBean.getStatus()));
		
		return nurse;
		
	
	}

}
