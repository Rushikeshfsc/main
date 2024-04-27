package com.guielidnes.fluidscapes.serviceImplementation;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.websocket.Decoder.Text;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

//import com.guielidnes.fluidscapes.JWT.JwtTokenProvider;
//import com.guielidnes.fluidscapes.JWT.UserMapper;
//import com.guielidnes.fluidscapes.JWT.UserResponse;
import com.guielidnes.fluidscapes.entity.LoginHistory;
import com.guielidnes.fluidscapes.entity.LoginRequest;
import com.guielidnes.fluidscapes.entity.Users;
import com.guielidnes.fluidscapes.repository.LoginDetailRepository;
import com.guielidnes.fluidscapes.repository.UserRepository;
import com.guielidnes.fluidscapes.service.Loginservice;
import com.guielidnes.fluidscapes.service.UserService;

import antlr.Utils;


@Service
public class Loginhistoryimpl implements Loginservice {
	
	private static final Logger logger=LoggerFactory.getLogger(Loginhistoryimpl.class);
	
  @Autowired
	private UserService userService;
    
   @Autowired
	private LoginDetailRepository loginDetailRepository;
  @Autowired
  private UserRepository userrepository;
  
  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;
  
  //@Autowired
 //private	JwtTokenProvider jwtTokenProvider;
  

//	@Autowired
	//private  AuthenticationManager authenticationManager;
	
    //@Autowired
	//private LoginRequest request;
	
	//@Autowired
	//private UserMapper mapper;
	
	

@Override
public void Loginservice(UserService userService, LoginDetailRepository loginDetailRepository,UserRepository userrepository) {
	this.userService=userService;
	this.loginDetailRepository=loginDetailRepository;
	this.userrepository=userrepository;
	
}



@Override
public boolean login(String username, String password, InetAddress ipaddress) {
	 
Users user = userService.findByUsername(username);	
///////////////////new implementation//////////////////////////////////////
	
//LoginRequest request=new LoginRequest();
//Users user =this.userrepository.findByUsername(request.getUsername());
//authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
//
//UserResponse response=new UserResponse(null, username, password, password, null, ipaddress);
//mapper.setUserResponseToUser(request, user);
//response.setToken(jwtTokenProvider.createToken(user.getUsername(), user.getPassword()));
//this.userrepository.save(user);


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    BCryptPasswordEncoder brcypt= new BCryptPasswordEncoder();


	try {
		InetAddress localhost=(InetAddress) InetAddress.getLocalHost();
		
	} catch (UnknownHostException e) {
		
		e.printStackTrace();
	}
/////////////////////////////////////////////////////////////////////////////////	
	
	if(brcypt.matches(password, user.getPassword())) {
////////////////////////////////////////////////////////////////////////////////	
	 //if(user!=null && user.getPassword().equals(password)) {
	LoginHistory loginhistory=new LoginHistory();
	loginhistory.setUser(user);
	loginhistory.setLogintime(LocalDateTime.now());
   try {
	loginhistory.setIpaddress(InetAddress.getLocalHost());
} catch (UnknownHostException e) {
	
	e.printStackTrace();
}
   
	loginDetailRepository.save(loginhistory);
	
	logger.info("Login service implementation :login() method");
	

return true;
}
return false;

	
//return false;
}
}

	


