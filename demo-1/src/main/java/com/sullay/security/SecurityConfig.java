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
		 http
         .authorizeRequests()
             .antMatchers("/html/**","/").permitAll()
             .anyRequest().authenticated()
             .and()
         .formLogin()
         	 .loginPage("/login_page")
             .loginProcessingUrl("/login")
             .usernameParameter("username")
             .passwordParameter("password")
             .permitAll()
             .and()
         .logout()
             .permitAll()
             .and()
         .csrf().disable();
	}
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication().passwordEncoder(passwordEncoder).withUser("sullay").password(passwordEncoder.encode("sullay")).roles("USER");
	}
	
	
}
