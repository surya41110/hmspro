package com.nareshit.config;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

public class CustomPermissionEvaluator implements PermissionEvaluator {

	@Override
	public boolean hasPermission(Authentication authentication, 
			Object targetDomainObject, 
			Object permission) {
		System.out.println(" i am in custom permision evalutor");
		System.out.println("module is:\t"+targetDomainObject);
		System.out.println("permission is:\t"+permission);
		boolean isRoleMatched = false;
		boolean isPermMatched = false;
		Collection<? extends GrantedAuthority> gaList = authentication.getAuthorities();
		if(gaList != null && gaList.size() >0) {
			System.out.println("authprities are not empty");
			for(GrantedAuthority ga : gaList) {
				System.out.println("authoruity from db is:\t"+ga.getAuthority());
				if(RoleEnum.hasRole(ga.getAuthority()) 
						&& targetDomainObject.equals(ga.getAuthority())) {
					System.out.println("role is verified:\t"+targetDomainObject);
					isRoleMatched = true;
					break;
					
				}
			}
			for(GrantedAuthority ga : gaList) {
				System.out.println("authoruity from db is:\t"+ga.getAuthority());
				if(ga.getAuthority().equals(permission)) {
						System.out.println("permision verified:\t"+permission);
						isPermMatched = true;
						break;
					}else {
						System.out.println("permi is not verified");
						continue;
					}
					
				
			}
		}
		System.out.println("is role matched :\t"+isRoleMatched);
		System.out.println("is perm matched:\t"+isPermMatched);
		if(isRoleMatched && isPermMatched) {
			return true;
		}
		return false;
	}

	@Override
	public boolean hasPermission(Authentication authentication, 
			Serializable targetId, 
			String targetType,
			Object permission) {
		// TODO Auto-generated method stub
		return false;
	}

}
