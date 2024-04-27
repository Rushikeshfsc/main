package com.guielidnes.fluidscapes.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;

@Configuration
@EnableWebSecurity
@CrossOrigin
public class MyConfig  extends WebSecurityConfigurerAdapter {

	
	
	
	@Bean
	public  UserDetailsService getUserDetailservice() {
		
		return new UserDeatilsServiceImpl();
		
	}
	@Bean
	public BCryptPasswordEncoder passworencoder() {
		
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
		
		authenticationProvider.setUserDetailsService(this.getUserDetailservice());
		authenticationProvider.setPasswordEncoder(passworencoder());
		return authenticationProvider;
		
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.authenticationProvider(authenticationProvider());
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		
		.antMatchers("/admin").permitAll()
		.antMatchers("/login").permitAll()
		.antMatchers("register").permitAll()
	    .antMatchers("/admin/login").permitAll()
		.antMatchers("/admin/register").permitAll()
		.antMatchers("swagger-ui.html").permitAll()
		.antMatchers("/webjars/**").permitAll()
		.antMatchers("/**").permitAll()
	    .anyRequest().authenticated()
		.and()
		.formLogin()
		.and()
		.csrf()
		.disable();
		
	}
	
}
