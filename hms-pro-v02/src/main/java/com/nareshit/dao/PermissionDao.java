package com.nareshit.dao;

import java.util.List;

import com.nareshit.domain.Permission;

public interface PermissionDao {

	public Permission addPermission(Permission Permission);
	public Permission updatePermission(Permission Permission);
	public Permission getPermissionByid(int id);
	public List<Permission> getAllPermissions();
	public List<Permission> searchPermission(String name);
	
	public Permission getPermissionByName(String name);
	
}
