package com.nareshit.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomDatabaseAuthProvider implements  AuthenticationProvider{

	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder pwdEncoder;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String username = authentication.getName();
		String password = (String)authentication.getCredentials();
		System.out.println("user name is:\t"+username);
		System.out.println("password si:\t"+password);
		
		UserDetails userDetails = userDetailsService.loadUserByUsername(username);
		System.out.println("password is*************:\t"+userDetails.getPassword());
		
		boolean isPwdMatched = pwdEncoder.matches(password, userDetails.getPassword());
		System.out.println("is pwd matchng:\t"+isPwdMatched);
		if(isPwdMatched) {
			Authentication auth = new UsernamePasswordAuthenticationToken(userDetails.getUsername(), 
					userDetails.getPassword(), 
					userDetails.getAuthorities());
			return auth;
		}
		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}


	/*public static void main(String[] args) {
		System.out.println(new BCryptPasswordEncoder().encode("test"));
	}*/
	

}
