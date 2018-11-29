package com.nareshit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nareshit.bean.DoctorBean;
import com.nareshit.dao.DoctorDao;
import com.nareshit.dao.RoleDao;
import com.nareshit.domain.Doctor;
import com.nareshit.utility.DoctorMapper;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorDao docDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private BCryptPasswordEncoder pwdEncoder;
	
	@Override
	public DoctorBean saveDoctor(DoctorBean hosp) {
		Doctor doc = mapBeanToDomain(hosp);
		Doctor hospDoamin = docDao.addDoctor(doc);
		return DoctorMapper.mapDomainToBean(hospDoamin);
	}

	@Override
	public List<DoctorBean> getAllDoctors() {
		List<Doctor> doctList = docDao.getAllDoctors();
		List<DoctorBean> doctBeanList = DoctorMapper.mapDomainListToBean(doctList.iterator());
		return doctBeanList;
	}
	
	@Override
	public DoctorBean getDoctorByid(int id) {
		Doctor doctor = docDao.getDoctorByid(id);
		DoctorBean doctorBean = DoctorMapper.mapDomainToBean(doctor);
		return doctorBean;
	}

	@Override
	public List<DoctorBean> searchDoctor(String name, String serachValue) {
		String criteria = "";
		if (serachValue.equals("Name")) {
			criteria = criteria + "fname";
		} else {
			criteria = criteria + "email";
		}
		List<Doctor> doctList = docDao.searchDoctor(name, criteria);

		List<DoctorBean> doctBeanList = DoctorMapper.mapDomainListToBean(doctList.iterator());
		return doctBeanList;
	}

	@Override
	public DoctorBean updateDoctor(DoctorBean docBean) {
		Doctor doctor = DoctorMapper.mapBeanToDomain(docBean);
		doctor = docDao.updateDoctor(doctor);
		docBean = DoctorMapper.mapDomainToBean(doctor);
		return docBean;
	}

	@Override
	public void deleteDoctor(int id) {
		System.out.println("doc serv del");
		docDao.deleteDoctor(id);
	}
	
	public Doctor mapBeanToDomain(DoctorBean doctBean) {
		Doctor doct = new Doctor();
		if(doctBean.getId() > 0) {
			doct.setId(doctBean.getId());
		}
		
		String pwdSathHash = pwdEncoder.encode(doctBean.getPassword());
		String cpwdSaltHash = pwdEncoder.encode(doctBean.getCpassword());
		
		/*doct.setPassword(doctBean.getPassword());
		doct.setConpassword(doctBean.getCpassword());*/
		doct.setPassword(pwdSathHash);
		doct.setConpassword(cpwdSaltHash);
		doct.setEmail(doctBean.getEmail());
		doct.setFname(doctBean.getFname());
		doct.setMobile(doctBean.getMobile());
		doct.setSpecialization(doctBean.getSpecialist());
		doct.setExperience(doctBean.getExperience());
		
		doct.setRole(roleDao.getRoleByName(doctBean.getRole()));
		
		
		//doct.setStatus(Boolean.parseBoolean(String.valueOf(Status.getCodeByName(doctBean.getStatus()))));
		doct.setStatus(Boolean.parseBoolean(doctBean.getStatus()));
		
		return doct;
		
	
	}

}
