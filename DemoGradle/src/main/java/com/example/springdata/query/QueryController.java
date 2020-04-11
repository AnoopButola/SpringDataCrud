package com.example.springdata.query;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.accessingdatamysql.User;
import com.example.accessingdatamysql.UserRepository;

/*
 * https://www.baeldung.com/spring-data-jpa-query
 * 
 * 
 * https://www.baeldung.com/jpa-join-types  Entities  prepared from here 
 * 
 * 
 */

@RestController
@RequestMapping(value="/query")
public class QueryController {

	@Autowired
	 private UserRepository userRepository;
	
	@GetMapping("/users")
	public Collection<User> listUsersByRole(){
		return userRepository.findNonAdminUsers();
	}
}
