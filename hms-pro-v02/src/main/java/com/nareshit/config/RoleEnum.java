package com.nareshit.config;


public enum RoleEnum {

	DOCTOR("ROLE_Doctor"),
	ADMIN("ROLE_Admin");
	
	private String role;
	
	RoleEnum(String role) {
		this.role=role;
		
	}
	
	public static boolean hasRole(String role) {
		for(RoleEnum st: RoleEnum.values()) {
			if(st.role.equals(role)) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(RoleEnum.hasRole("ROLE_ADMIN"));
	}
}
