package com.nareshit.service;

import java.util.List;

import com.nareshit.bean.NurseBean;


public interface NurseService {

	public NurseBean saveNurse(NurseBean nurse);
	public List<NurseBean> getAllNurses();
	public NurseBean getNurseByid(int id);
	public List<NurseBean> searchNurse(String name, String email);
	public NurseBean updateNurse(NurseBean nurse);
	public void deleteNurse(int id);
}
