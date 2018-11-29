package com.nareshit.dao;

import java.util.List;

import com.nareshit.domain.Admin;

public interface AdminDao {

	public Admin addAdmin(Admin hosp);
	public Admin getAdminByid(int id);
	public List<Admin> getAllAdmins();
	public List<Admin> searchAdmin(String name, String email);
	
}
