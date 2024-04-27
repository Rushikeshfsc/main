//package com.guielidnes.fluidscapes.entity;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//
//@Entity
//public class AuthenticationRequest {
//
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//    private String id;
//    
//	private String username;
//    private String password;
//
//    // Constructors
//    public AuthenticationRequest() {
//    }
//
//    public AuthenticationRequest(String id,String username, String password) {
//        this.username = username;
//        this.password = password;
//        this.id=id;
//    }
//
//    // Getters and setters
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//	public String getId() {
//		return id;
//	}
//
//	public void setId(String id) {
//		this.id = id;
//	}
//
//}
