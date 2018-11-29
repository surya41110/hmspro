package com.nareshit.dao;

import java.util.List;

import com.nareshit.domain.Role;

public interface RoleDao {

	public Role addRole(Role role);
	public Role updateRole(Role role);
	public Role getRoleByid(int id);
	public List<Role> getAllRoles();
	public List<Role> searchRole(String name);
	Role getRoleByName(String name);
	
}
