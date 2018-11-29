package com.nareshit.service;

import java.util.List;


import com.nareshit.bean.PermissionBean;
import com.nareshit.domain.Permission;


public interface PermissionService {

	public PermissionBean savePermission(Permission perm);
	public PermissionBean updatePermission(Permission perm);
	public PermissionBean getPermissionById(int id);
	public List<PermissionBean> getAllPermissions();
}
