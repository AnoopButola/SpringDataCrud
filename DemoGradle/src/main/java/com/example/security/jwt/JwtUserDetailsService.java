/**
 * 
 */
package com.example.security.jwt;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.accessingdatamysql.User;
import com.example.accessingdatamysql.UserRepository;
import com.example.springdata.dto.UserDTO;

/**
 * @author Anoop Butola
 *
 */

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepo.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}

	public User save(UserDTO dtoUser) {
		User newUser = new User();
		newUser.setUsername(dtoUser.getUsername());
		newUser.setPassword(bcryptEncoder.encode(dtoUser.getPassword()));
		return userRepo.save(newUser);
	}
}
