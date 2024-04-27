package com.guielidnes.fluidscapes.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.reflections.util.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.guielidnes.fluidscapes.entity.Users;
import com.guielidnes.fluidscapes.repository.UserRepository;
//import com.guielidnes.fluidscapes.NewJwt.Authservice;
//import com.guielidnes.fluidscapes.JWT.JwtTokenProvider;
import com.guielidnes.fluidscapes.entity.LoginRequest;

import com.guielidnes.fluidscapes.service.Loginservice;
import com.guielidnes.fluidscapes.service.UserService;


@CrossOrigin
@RestController

//@RequestMapping(value="/login",method = RequestMethod.POST)
@RequestMapping("/admin")
public class UserController {
	//Logger setup
   private static final Logger logger=LoggerFactory.getLogger(UserController.class)	;
    ///
     @Autowired
	private UserService userService;
     
	@Autowired
	private Loginservice loginservice;
	
	@Autowired
	private  BCryptPasswordEncoder passwordEncoder;
	
	  
	 //@Autowired
	//JwtTokenProvider jwtTokenProvider;
	  

	//@Autowired
	//AuthenticationManager authenticationManager;
	
	@Autowired
	UserRepository userepo;
	
	public UserController(UserService userservice,Loginservice loginservice) {
		this.userService=userservice;
		this.loginservice=loginservice;
		
	}
	
	 @PostMapping("/login")
	//@RequestMapping(value="/login",method=RequestMethod.POST)
	public ResponseEntity<String >login(@RequestBody LoginRequest loginRequest) throws UnknownHostException{
			 
		 
		if(loginservice.login(loginRequest.getUsername(), loginRequest.getPassword(),InetAddress.getLocalHost() )){
			
//		Users user=this.userepo.findByUsername(loginRequest.getUsername());
//		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword() ));
//		
//		LoginRequest login=new LoginRequest();
//		login.setToken(jwtTokenProvider.createToken(user.getUsername(), user.getPassword()));
//		this.userepo.save(user);
					
          return ResponseEntity.ok("Login Successfull"+loginRequest.toString()+"text");
          
          
          	
		}
		
		else {
		logger.info("Login of user controller:login() method");
		
		return ResponseEntity.badRequest().body("Invalide username or Password");
		}
		
	}
	
	@PostMapping("/register")
//	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String register(@RequestBody Users user) {
		
		Users existinguser = userService.findByUsername(user.getUsername());
		if(existinguser==null) {
			userService.create(user);
			
			logger.info("Register User Controller:register() method");
			return "Registration succcessfully"+user.toString();
		}else {
		return "username already exit";
		
		}
		
	}
	
	
//     @GetMapping("/getip/{id}")
//		public ResponseEntity<String>loginss(@PathVariable String id) throws UnknownHostException{
//			InetAddress IP=InetAddress.getLocalHost();
//			
//		System.out.println("ip of my System is:-"+IP.getHostAddress());
//			return ResponseEntity.badRequest().body("Invalid User or Paswword");
//			
			
		}
	


	/////...............................................................................................................

	
	
	

		
	





	
	
	
	
	
	
	

