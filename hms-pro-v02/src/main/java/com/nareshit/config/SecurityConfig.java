package com.nareshit.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource ds;
	
	@Autowired
	private CustomDatabaseAuthProvider authProvider;
	
	@Autowired
	private CustomUserDetailsService userService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		//auth.authenticationProvider(authProvider);
		auth
		.userDetailsService(userService)
		.passwordEncoder(passwordEncoder())
		.and()
		.authenticationProvider(authProvider);
		
		/*auth
		.inMemoryAuthentication()
		.withUser("john")
		.password("test")
		.roles("superAdmin")
		.and()
		.withUser("kane")
		.password("test")
		.roles("Admin")
		.and()
		.withUser("jack")
		.password("test")
		.roles("Doctor");
		
		auth
		.jdbcAuthentication()
		.dataSource(ds)
		.usersByUsernameQuery("select u.firstname,u.pwd from user u where u.firstname=?")
		.authoritiesByUsernameQuery("select u.firstname, r.role from user u join role r where u.role_role_id=r.role_id and u.firstname=?");*/
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
	    .regexMatchers("/superAdmin/*").hasRole("superAdmin")
	    .regexMatchers("/doctor/*").hasRole("Doctor")
	    .regexMatchers("/admin/*").hasRole("Admin")
	    //.antMatchers("/admin/").hasAuthority("ROLE_superAdmin")
	    .antMatchers("/admin/").hasAuthority("Admin")
	    .antMatchers("/doctor/").hasAuthority("Admin")
	    //.and().rememberMe().key("hms-pro-v03").tokenValiditySeconds(1000)
	    .and().rememberMe().key("hms-pro-v03").tokenRepository(tokenReposiroty()).tokenValiditySeconds(1000)
	    .and()
	    .formLogin()
		.loginPage("/")
		.loginProcessingUrl("/login")
		.defaultSuccessUrl("/login")
		.and().exceptionHandling().accessDeniedPage("/accessDenied")
		.and()
		.logout()
		.logoutSuccessUrl("/")
		.invalidateHttpSession(true)
		.deleteCookies("JSESSIONID")
		.and().csrf().disable();
		
		
	}
	
	public JdbcTokenRepositoryImpl tokenReposiroty() {
		JdbcTokenRepositoryImpl persistToken = new JdbcTokenRepositoryImpl();
		persistToken.setDataSource(ds);
		return persistToken;
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	
}
