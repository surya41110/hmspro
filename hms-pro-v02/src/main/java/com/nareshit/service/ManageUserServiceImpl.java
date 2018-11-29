package com.nareshit.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nareshit.bean.UserBean;
import com.nareshit.bean.UserBean;
import com.nareshit.dao.ManageUserDao;
import com.nareshit.dao.RoleDao;
import com.nareshit.domain.Permission;
import com.nareshit.domain.RoleToPermission;
import com.nareshit.domain.User;
import com.nareshit.domain.User;

@Service
public class ManageUserServiceImpl implements ManageUserService {

	@Autowired
	private ManageUserDao userDao;
	@Override
	public Map<String, List<String>> authenticateUser(String username, String password) {
		User user = userDao.authenticateUser(username, password);
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		
		List<String> permList = new ArrayList<String>();
		for(RoleToPermission perm : user.getRole().getPermList()) {
			permList.add(perm.getPerm().getPermission());
		}
		
		map.put(user.getRole().getRole(), permList);
		
		return map;
	}
	
	public static UserBean mapDomainToBean(User userDomain) {
		UserBean user = new UserBean();
		user.setId(userDomain.getId());
		user.setEmail(userDomain.getEmail());
		user.setFname(userDomain.getFname());
		user.setMobile(userDomain.getMobile());
		
		boolean userStatus = userDomain.isStatus();
		user.setStatus(String.valueOf(userStatus));
		
		
		
		
		/*user.setStatus(String.valueOf(userStatus));
		List<AddressBean> addBeansList = null;
		List<Address> addrList = userDomain.getAddrList();
		if(addrList != null && addrList.size() >0) {
			addBeansList = new ArrayList<AddressBean>();
			for(Address ad : addrList) {
				addBeansList.add(AddressMapper.mapDomainToBean(ad));
			}
			user.setAddrInfo(addBeansList);
		}*/
		
		return user;
	}

		
	
	

}
