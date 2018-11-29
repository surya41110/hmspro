package com.nareshit.dao;

import java.util.List;

import com.nareshit.domain.Nurse;

public interface NurseDao {

	public Nurse addNurse(Nurse nurse);
	public Nurse getNurseByid(int id);
	public List<Nurse> getAllNurses();
	public List<Nurse> searchNurse(String name, String email);
	public Nurse updateNurse(Nurse nurse);
	public void deleteNurse(int id);
	
}
