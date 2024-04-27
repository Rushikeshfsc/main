//package com.guielidnes.fluidscapes.JWT;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
//	
//public static final Logger logger = LoggerFactory.getLogger(WebSecurityConfig.class);
//      
//	@Autowired
//	private JwtTokenProvider jwtTokenProvider;
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		logger.info("in configure()");
//		// Disable CSRF (cross site request forgery)
//		http.csrf().disable();
//		http.cors();
//		// No session will be created or used by spring security
//		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//		// Entry points
//		http.authorizeRequests()
//		        .antMatchers("/welcome").permitAll()
//		        .antMatchers("/admin").permitAll()
//		        .antMatchers("/admin/login").permitAll()
//		        .antMatchers("/admin/register").permitAll()
//		        .antMatchers("/swagger-ui/index.html").permitAll()
//		        .antMatchers("/swagger-resources/**").permitAll()
//				.antMatchers("/v2/api-docs").permitAll()
//				.antMatchers("/webjars/**").permitAll()			
//				.antMatchers("/public").permitAll()
//				.antMatchers("/**").permitAll()
//				// Disallow everything else..
//				.anyRequest().authenticated();
//
//		// If a user try to access a resource without having enough permissions
////    http.exceptionHandling().accessDeniedPage("/login");
//
//		// Apply JWT
//		http.apply(new JwtTokenFilterConfigurer(jwtTokenProvider));
//
//		// Optional, if you want to test the API from a browser
//		// http.httpBasic();
//	}
//
//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		// Allow swagger to be accessed without authentication
//		web.ignoring().antMatchers("/v2/api-docs")//
//				.antMatchers("/swagger-resources/**")//
//				.antMatchers("/swagger-ui.html")//
//				.antMatchers("/configuration/**")//
//				.antMatchers("/webjars/**")//
//				.antMatchers("/public")
//				.antMatchers("/login/login")
//				.antMatchers("/login/verify-otp/**")
//				.antMatchers("/login/sent-otp-email")
//				.antMatchers("/login/set-new-password")
//				.antMatchers("/users/signup")
//				.antMatchers("/login/forgot-password")
//				.antMatchers("/swagger-ui/index.html");
//		      
//	}
//
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder(12);
//	}
//
//	@Override
//	@Bean
//	public AuthenticationManager authenticationManagerBean() throws Exception {
//		return super.authenticationManagerBean();
//	}
//
//
//}
