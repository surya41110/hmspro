package com.nareshit.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.nareshit.dao.ManageUserDao;
import com.nareshit.domain.Role;
import com.nareshit.domain.RoleToPermission;
import com.nareshit.domain.User;

@Component
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private ManageUserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.getUserByUserName(username);
		Role role = user.getRole();
		List<RoleToPermission> perms = role.getPermList();
		List<GrantedAuthority> authList = new ArrayList<>();
		GrantedAuthority roleAuth = new SimpleGrantedAuthority("ROLE_"+role.getRole());
		for(RoleToPermission rpm : perms) {
			GrantedAuthority permAuth = new SimpleGrantedAuthority(rpm.getPerm().getPermission());
			authList.add(permAuth);
		}
		authList.add(roleAuth);
		
		UserDetails springSecurityUser = new org.springframework.security.core.userdetails.User(user.getFname(), user.getPassword(), authList);
		return springSecurityUser;
	}

}
