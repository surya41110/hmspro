package com.nareshit.utility;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.nareshit.bean.PermissionBean;
import com.nareshit.domain.Permission;

public class PermissionMapper {

	public static Permission mapBeanToDomain(PermissionBean permBean) {
		Permission perm = new Permission();
		if(permBean.getId() > 0) {
			perm.setId(permBean.getId());
		}
		perm.setPermission(permBean.getPermission());
		
		
		return perm;
		
	
	}
	
	public static PermissionBean mapDomainToBean(Permission permDomain) {
		PermissionBean perm = new PermissionBean();
		perm.setId(permDomain.getId());
		perm.setPermission(permDomain.getPermission());
		return perm;
	}
	
	public static List<PermissionBean> mapDomainListToBean(Iterator<Permission> permList){
		List<PermissionBean> permBeansList = null;
		if(permList != null) {
			permBeansList = new ArrayList<PermissionBean>();
			while(permList.hasNext()) {
				permBeansList.add(mapDomainToBean(permList.next()));
			}
		}
		return permBeansList;
	}
		
}
