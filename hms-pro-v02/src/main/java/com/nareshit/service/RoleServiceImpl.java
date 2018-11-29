package com.nareshit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nareshit.bean.RoleBean;
import com.nareshit.dao.PermissionDao;
import com.nareshit.dao.RoleDao;
import com.nareshit.domain.Permission;
import com.nareshit.domain.Role;
import com.nareshit.domain.RoleToPermission;
import com.nareshit.utility.RoleMapper;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private PermissionDao permDao;
	
	@Override
	public RoleBean saveRole(RoleBean roleBean) {
		
	     String[] permArray = roleBean.getPermissions();
	    /* List<Permission> permList = new ArrayList<Permission>();
	     for(String p: permArray) {
	    	 permList.add(permDao.getPermissionByName(p));
	     }*/
	     Role role = new Role();
			if(roleBean.getId() > 0) {
				role.setId(roleBean.getId());
			}
			role.setRole(roleBean.getRole());
			
			List<RoleToPermission> permList = new ArrayList<RoleToPermission>();	
	     for(String p: permArray) {
	    	 RoleToPermission roleToPerm = new RoleToPermission();
	    	 roleToPerm.setPerm(permDao.getPermissionByName(p));
	    	 roleToPerm.setRole(role);
	    	 permList.add(roleToPerm);
	     }
	     /*List<RoleToPermission> permList = new ArrayList<Permission>();
		Role role = RoleMapper.mapBeanToDomain(roleBean);*/
		role.setPermList(permList);
		Role roleDoamin = roleDao.addRole(role);
		return RoleMapper.mapDomainToBean(roleDoamin);
	}

	@Override
	public List<RoleBean> getAllRoles() {
		List<Role> doctList = roleDao.getAllRoles();
		List<RoleBean> doctBeanList = RoleMapper.mapDomainListToBean(doctList.iterator());
		return doctBeanList;
	}

	@Override
	public RoleBean getRoleById(int id) {
        Role role = roleDao.getRoleByid(id);
		return RoleMapper.mapDomainToBean(role);
	}

	@Override
	public RoleBean updateRole(Role role) {
		 role = roleDao.updateRole(role);
		return RoleMapper.mapDomainToBean(role);
	}

}
