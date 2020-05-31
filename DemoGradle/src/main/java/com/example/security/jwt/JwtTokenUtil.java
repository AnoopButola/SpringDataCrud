/**
 * 
 */
package com.example.security.jwt;

/**
 * @author Anoop Butola
 *
 */

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil implements Serializable {
	private static final long serialVersionUID = -2550185165626007488L;
	public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
	@Value("${jwt.secret}")
	private String secret;

	// retrieve username from jwt token
	public String getUsernameFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}

	// retrieve expiration date from jwt token
	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}

	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}

	// for retrieveing any information from token we will need the secret key
	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}

	// check if the token has expired
	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}

	// generate token for user
	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		return doGenerateToken(claims, userDetails.getUsername());
	}

	// while creating the token -
	// 1. Define claims of the token, like Issuer, Expiration, Subject, and the
	// ID
	// 2. Sign the JWT using the HS512 algorithm and secret key.
	// 3. According to JWS Compact
	// Serialization(https://tools.ietf.org/html/draft-ietf-jose-json-web-signature-41#section-3.1)
	// compaction of the JWT to a URL-safe string
	private String doGenerateToken(Map<String, Object> claims, String subject) {
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}

	// validate token
	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = getUsernameFromToken(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
}

/*
 * JwtAuthenticationController Expose a POST API /authenticate using the
 * JwtAuthenticationController. The POST API gets the username and password in
 * the body. Using the Spring Authentication Manager, we authenticate the
 * username and password. If the credentials are valid, a JWT token is created
 * using the JWTTokenUtil and is provided to the client.
 * 
 * package com.javainuse.controller; import java.util.Objects; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.security.authentication.AuthenticationManager; import
 * org.springframework.security.authentication.BadCredentialsException; import
 * org.springframework.security.authentication.DisabledException; import
 * org.springframework.security.authentication.
 * UsernamePasswordAuthenticationToken; import
 * org.springframework.security.core.userdetails.UserDetails; import
 * org.springframework.web.bind.annotation.CrossOrigin; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestMethod; import
 * org.springframework.web.bind.annotation.RestController; import
 * com.javainuse.service.JwtUserDetailsService; import
 * com.javainuse.config.JwtTokenUtil; import com.javainuse.model.JwtRequest;
 * import com.javainuse.model.JwtResponse;
 * 
 * @RestController
 * 
 * @CrossOrigin public class JwtAuthenticationController {
 * 
 * @Autowired private AuthenticationManager authenticationManager;
 * 
 * @Autowired private JwtTokenUtil jwtTokenUtil;
 * 
 * @Autowired private JwtUserDetailsService userDetailsService;
 * 
 * @RequestMapping(value = "/authenticate", method = RequestMethod.POST) public
 * ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest
 * authenticationRequest) throws Exception {
 * authenticate(authenticationRequest.getUsername(),
 * authenticationRequest.getPassword()); final UserDetails userDetails =
 * userDetailsService .loadUserByUsername(authenticationRequest.getUsername());
 * final String token = jwtTokenUtil.generateToken(userDetails); return
 * ResponseEntity.ok(new JwtResponse(token)); } private void authenticate(String
 * username, String password) throws Exception { try {
 * authenticationManager.authenticate(new
 * UsernamePasswordAuthenticationToken(username, password)); } catch
 * (DisabledException e) { throw new Exception("USER_DISABLED", e); } catch
 * (BadCredentialsException e) { throw new Exception("INVALID_CREDENTIALS", e);
 * } } }
 */