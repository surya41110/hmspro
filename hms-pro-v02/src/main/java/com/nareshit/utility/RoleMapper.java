package com.nareshit.utility;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nareshit.bean.RoleBean;
import com.nareshit.dao.PermissionDao;
import com.nareshit.domain.Permission;
import com.nareshit.domain.Role;


public class RoleMapper {


	
	public static Role mapBeanToDomain(RoleBean roleBean) {
		Role role = new Role();
		if(roleBean.getId() > 0) {
			role.setId(roleBean.getId());
		}
		role.setRole(roleBean.getRole());
		
		
		return role;
		
	
	}
	
	public static RoleBean mapDomainToBean(Role roleDomain) {
		RoleBean role = new RoleBean();
		role.setId(roleDomain.getId());
		role.setRole(roleDomain.getRole());
		String[] permArray = null;
		
		
		
		return role;
	}
	
	public static List<RoleBean> mapDomainListToBean(Iterator<Role> roleList){
		List<RoleBean> roleBeansList = null;
		if(roleList != null) {
			roleBeansList = new ArrayList<RoleBean>();
			while(roleList.hasNext()) {
				roleBeansList.add(mapDomainToBean(roleList.next()));
			}
		}
		return roleBeansList;
	}
		
}
