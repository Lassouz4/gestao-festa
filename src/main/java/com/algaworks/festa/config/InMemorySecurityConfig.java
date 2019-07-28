package com.algaworks.festa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCrypt;


@Configuration
public class InMemorySecurityConfig {
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder)throws Exception {
			String hash= BCrypt.hashpw("123", BCrypt.gensalt());
			builder
			.inMemoryAuthentication()
			.withUser("joao").password("{bcrypt}"+hash).roles("USER");
			}

}
