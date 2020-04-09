package com.community.gateway.jwt.config;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;


public class AuthTokenFilter extends OncePerRequestFilter {
	@Autowired
	private JwtUtils jwtUtils;
	

	@Value("${gateway.app.headerstring}")
	private String headerString;
	
	@Value("${gateway.app.tokenprefix}")
	private String tokenPrefix;

	@Autowired
	private UserDetailsService userDetailsService;

	private static final Logger logger = LoggerFactory.getLogger(AuthTokenFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			String jwt = parseJwt(request);
			
		  //  if (username != null ) {

			
			if (jwt != null &&  SecurityContextHolder.getContext().getAuthentication() == null ) {
				String username = jwtUtils.getUserNameFromJwtToken(jwt);

				UserDetails userDetails = userDetailsService.loadUserByUsername(username);
				
				if(jwtUtils.validateJwtToken(jwt,userDetails)) {
					
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				  logger.info("authenticated user " + username + ", setting security context");
	              
				SecurityContextHolder.getContext().setAuthentication(authentication);
				}
			}
		} catch (Exception e) {
			logger.error("Cannot set user authentication: {}", e);
		}

		filterChain.doFilter(request, response);
	}

	private String parseJwt(HttpServletRequest request) {
		String headerAuth = request.getHeader(headerString);

	        String token = null;
	        String authToken = null;
	        if (headerAuth != null && headerAuth.startsWith(tokenPrefix)) {
	            authToken = headerAuth.replace(tokenPrefix,"");
	            try {
	                token = jwtUtils.getUsernameFromToken(authToken);
	            } catch (IllegalArgumentException e) {
	                logger.error("an error occured during getting username from token", e);
	            } catch (ExpiredJwtException e) {
	                logger.warn("the token is expired and not valid anymore", e);
	            } catch(SignatureException e){
	                logger.error("Authentication Failed. Username or Password not valid.");
	            }
	        } else {
	            logger.warn("couldn't find bearer string, will ignore the header");
	        }

		return token;
	}
}
