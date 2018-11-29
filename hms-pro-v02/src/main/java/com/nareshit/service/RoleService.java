package com.nareshit.service;

import java.util.List;


import com.nareshit.bean.RoleBean;
import com.nareshit.domain.Role;


public interface RoleService {

	public RoleBean saveRole(RoleBean role);
	public RoleBean updateRole(Role role);
	public RoleBean getRoleById(int id);
	public List<RoleBean> getAllRoles();
}
