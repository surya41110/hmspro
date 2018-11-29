package com.nareshit.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SeucirtyWebAppInitializer extends AbstractSecurityWebApplicationInitializer {

	public SeucirtyWebAppInitializer() {
		super(SecurityConfig.class);
	}
}
