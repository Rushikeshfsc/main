//package com.guielidnes.fluidscapes.JWT;
//
//import java.util.ArrayList;
//import java.util.Base64;
//import java.util.Date;
//import java.util.List;
//import java.util.Objects;
//import java.util.stream.Collectors;
//
//import javax.annotation.PostConstruct;
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.JwtException;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//
//@Component
//public class JwtTokenProvider {
//
//	 @Value("${security.jwt.token.secret-key:secret-key}")
//	  private String secretKey;
//	  // 3600000 mili sec =1h
//	 
//	 
//	  @Value("${security.jwt.token.expire-length:172800000}")
//	  private long validityInMilliseconds = 172800000; // 48h
//
//	  @Autowired
//	  private MyUserDetails myUserDetails;
//	  
//
//	  @PostConstruct
//	  protected void init() {
//	    secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
//	  }
//
//	  public String createToken(String username, String type) {
//		  List<String> appUserRoles = new ArrayList<>();
//		  appUserRoles.add(type);
//	    Claims claims = Jwts.claims().setSubject(username);
//	    if (type == null || type.isEmpty()) {
//	    	type = "USER";
//	    } 
//	    
//	    
//	    claims.put("auth",appUserRoles.stream().map(s -> new SimpleGrantedAuthority(s)).filter(Objects::nonNull).collect(Collectors.toList()));
//
//	    Date now = new Date();
//	    Date validity = new Date(now.getTime() + validityInMilliseconds);
//
//	    return Jwts.builder()//
//	        .setClaims(claims)//
//	        .setIssuedAt(now)//
//	        .setExpiration(validity)//
//	        .signWith(SignatureAlgorithm.HS256, secretKey)//
//	        .compact();
//	  }
//
//	  public Authentication getAuthentication(String token) {
//	    UserDetails userDetails = myUserDetails.loadUserByUsername(getUsername(token));
//	    return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
//	  }
//
//	  public String getUsername(String token) {
//	    return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
//	  }
//	  
//	  public String getAudienceFromToken(String token) {
//	      return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getAudience();
//	  }
//
//	  public String resolveToken(HttpServletRequest req) {
//	    String bearerToken = req.getHeader("Authorization");
//	    if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
//	      return bearerToken.substring(7);
//	    }
//	    return bearerToken;
//	  }
//	  
//	  public UserDetails getUsersInfo(String userName) {
//		    return myUserDetails.loadUserByUsername(userName);
//		  }
//
//	  public boolean validateToken(String token) throws Exception {
//	    try {
//	      Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
//	      return true;
//	    } catch (JwtException | IllegalArgumentException e) {
//	      throw new Exception("Expired or invalid JWT token");
//	    }
//	  }
//	
//	
//	
//}
