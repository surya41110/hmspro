package com.nareshit.controller;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.expression.WebSecurityExpressionRoot;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nareshit.service.ManageUserService;

@Controller
public class ManageUserProfileController {

	@Autowired
	private ManageUserService userService;
	
	
	@RequestMapping(value="/accessDenied")
	public String getAccessDeniedPage() {
		return "accessDenied";
	}
	
	@RequestMapping(value="/login")
	public String doLogin(HttpServletRequest request) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userName = auth.getName();
		System.out.println("logged in user name is:\t"+userName);
		String password = (String) auth.getCredentials();
		System.out.println("logged in user password is:\t"+password);
		System.out.println("logged in user session id:\t"+request.getSession().getId());
		System.out.println("credentias are:\t"+userName+":"+password);
		boolean credNonEmpty = (userName != null && !userName.isEmpty()); 
		if(credNonEmpty) {
			/*Map<String, List<String>> map = userService.authenticateUser(userName, password);
			for(Object key : map.keySet().toArray()) {
				System.out.println("key is:\t"+key);
				System.out.println("perm are:\t"+map.get(key));
				if(key.equals("Doctor")) {
					return "redirect:./doctor";
				}
				if(key.equals("superAdmin")) {
					return "redirect:./superAdmin";
				}
			}*/
			
			Collection<? extends GrantedAuthority> authList = auth.getAuthorities();
			/*if(authList.contains("superAdmin")) {
				return "redirect:./superAdmin";
			}
			if(authList.contains("Doctor")) {
				return "redirect:./doctor";
			}*/
			
			for(GrantedAuthority ga : authList) {
				System.out.println("authorities are:\t"+ga.getAuthority());
				if(ga.getAuthority().equals("superAdmin") ||
						ga.getAuthority().equals("ROLE_superAdmin")) {
					return "redirect:./superAdmin";
				}
				if(ga.getAuthority().equals("ROLE_Doctor")) {
					return "redirect:./doctor";
				}
				if(ga.getAuthority().equals("ROLE_Admin")) {
					return "redirect:./admin";
				}
			}
			
		}
		return null;
	}
}
