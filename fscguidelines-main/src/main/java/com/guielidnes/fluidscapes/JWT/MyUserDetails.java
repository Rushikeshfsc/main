//package com.guielidnes.fluidscapes.JWT;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.guielidnes.fluidscapes.entity.Users;
//import com.guielidnes.fluidscapes.repository.UserRepository;
//
//
//@Service
//public class MyUserDetails implements UserDetailsService{
//
//	
//	@Autowired
//	private UserRepository userRepository;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		final Users appUser = userRepository.findByUsername(username);
//		
//		if (appUser == null) {
//			throw new UsernameNotFoundException("User '" + username + "' not found");
//		}
//		return org.springframework.security.core.userdetails.User.withUsername(username)
//				.password(appUser.getPassword())
//				.authorities(toString()).accountExpired(false).accountLocked(false)
//				.credentialsExpired(false)
//				.disabled(false).build();
//	}
//	
//}
