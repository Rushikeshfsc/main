//package com.guielidnes.fluidscapes.JWT;
//
//import java.io.IOException;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//
//public class JwtTokenFilter extends OncePerRequestFilter {
//	
//	private JwtTokenProvider jwtTokenProvider;
//
//	public JwtTokenFilter(JwtTokenProvider jwtTokenProvider) {
//		this.jwtTokenProvider = jwtTokenProvider;
//	}
//
//	@Override
//	protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
//			FilterChain filterChain) throws ServletException, IOException {
//		
//
//			String token = jwtTokenProvider.resolveToken(httpServletRequest);
//			System.out.println("token =" + token);
//
//			try {
//				if (jwtTokenProvider.validateToken(token)) {
//					String userName = jwtTokenProvider.getUsername(token);
//					String tenant = jwtTokenProvider.getAudienceFromToken(token);
//
//					UserDetails userDetails = jwtTokenProvider.getUsersInfo(userName);
//					System.out.println("users ----" + userDetails.toString());
//					Authentication auth = jwtTokenProvider.getAuthentication(token);
//				
//					SecurityContextHolder.getContext().setAuthentication(auth);
//				
//				}
//
//			} catch (com.guielidnes.fluidscapes.exception.Exception ex) {
////	    	
//				SecurityContextHolder.clearContext();
////	      throw ex;
//				httpServletResponse.sendError(ex.getHttpStatus().value(), "Expired or invalid JWT token");
//				return;
//				
//			} catch (Exception ex) {
//				ex.printStackTrace();
//				SecurityContextHolder.clearContext();
//				httpServletResponse.sendError(HttpStatus.UNAUTHORIZED.value(), ex.getMessage());
//				return;
//			}
//
//			filterChain.doFilter(httpServletRequest, httpServletResponse);
//		}	
//
//}
