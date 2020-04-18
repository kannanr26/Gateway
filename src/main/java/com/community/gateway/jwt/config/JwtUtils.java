package com.community.gateway.jwt.config;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtUtils {
	private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

	@Value("${gateway.app.jwtSecret}")
	private String jwtSecret;

	@Value("${gateway.app.jwtExpirationMs}")
	private int jwtExpirationMs;

	@Value("${gateway.app.signing_Key}")
	private String signing_Key;
	
	@Value("${gateway.app.issure}")
	private String issuer;
	

	
	  public String getUsernameFromToken(String token) {
	        return getClaimFromToken(token, Claims::getSubject);
	    }

	    public Date getExpirationDateFromToken(String token) {
	        return getClaimFromToken(token, Claims::getExpiration);
	    }

	    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
	        final Claims claims = getAllClaimsFromToken(token);
	        return claimsResolver.apply(claims);
	    }

	    private Claims getAllClaimsFromToken(String token) {
	        return Jwts.parser()
	                .setSigningKey(signing_Key)
	                .parseClaimsJws(token)
	                .getBody();
	    }

	    private Boolean isTokenExpired(String token) {
	        final Date expiration = getExpirationDateFromToken(token);
	        return expiration.before(new Date());
	    }
	    
	    
		public String getUserNameFromJwtToken(String token) {
			return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
		}
	    
		public String generateJwtToken(Authentication authentication) {

			UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
	        Claims claims = Jwts.claims().setSubject(userPrincipal.getUsername()+"-" +userPrincipal.getMobileNumber());
	        List<String>roles= userPrincipal.getAuthorities().stream().map(item -> item.getAuthority())
					.collect(Collectors.toList());
			String role=roles.get(0);
	       claims.put("scopes", Arrays.asList(new SimpleGrantedAuthority(role)));

	        return Jwts.builder()
	                .setClaims(claims)
	                .setIssuer(issuer)
	                .setIssuedAt(new Date(System.currentTimeMillis()))
	                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs*1000))
	                .signWith(SignatureAlgorithm.HS256, signing_Key)
	                .compact();
	    }

	    
	public boolean validateJwtToken(String authToken,UserDetails userDetails) {
		try {
			
			  final String username = getUsernameFromToken(authToken);
		        if(username.equals(userDetails.getUsername()) && !isTokenExpired(authToken) )
		        	//Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
						return true;
		} catch (SignatureException e) {
			logger.error("Invalid JWT signature: {}", e.getMessage());
		} catch (MalformedJwtException e) {
			logger.error("Invalid JWT token: {}", e.getMessage());
		} catch (ExpiredJwtException e) {
			logger.error("JWT token is expired: {}", e.getMessage());
		} catch (UnsupportedJwtException e) {
			logger.error("JWT token is unsupported: {}", e.getMessage());
		} catch (IllegalArgumentException e) {
			logger.error("JWT claims string is empty: {}", e.getMessage());
		}

		return false;
	}
}
