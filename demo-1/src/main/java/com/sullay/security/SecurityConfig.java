package com.sullay.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		 	.antMatchers("/").access("hasRole('ROLE_USER')")
			.antMatchers("/admin").access("hasRole('ROLE_ADMIN')")
			.antMatchers("/dba").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_DBA')")
			.and().formLogin();
	}
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication().passwordEncoder(passwordEncoder).withUser("sullay").password(passwordEncoder.encode("sullay")).roles("USER");
		auth.inMemoryAuthentication().passwordEncoder(passwordEncoder).withUser("admin").password(passwordEncoder.encode("admin")).roles("ADMIN");
		auth.inMemoryAuthentication().passwordEncoder(passwordEncoder).withUser("dba").password(passwordEncoder.encode("dba")).roles("DBA");
	}
	
	
}
