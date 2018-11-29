package com.nareshit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nareshit.bean.PermissionBean;
import com.nareshit.dao.PermissionDao;
import com.nareshit.domain.Permission;
import com.nareshit.utility.PermissionMapper;

@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	private PermissionDao permDao;
	
	@Override
	public PermissionBean savePermission(Permission perm) {
		Permission permDoamin = permDao.addPermission(perm);
		return PermissionMapper.mapDomainToBean(permDoamin);
	}

	@Override
	public List<PermissionBean> getAllPermissions() {
		List<Permission> doctList = permDao.getAllPermissions();
		List<PermissionBean> doctBeanList = PermissionMapper.mapDomainListToBean(doctList.iterator());
		return doctBeanList;
	}

	@Override
	public PermissionBean getPermissionById(int id) {
        Permission perm = permDao.getPermissionByid(id);
		return PermissionMapper.mapDomainToBean(perm);
	}

	@Override
	public PermissionBean updatePermission(Permission perm) {
		 perm = permDao.updatePermission(perm);
		return PermissionMapper.mapDomainToBean(perm);
	}

}
