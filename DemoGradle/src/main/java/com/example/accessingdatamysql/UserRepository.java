package com.example.accessingdatamysql;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Integer> {

	//https://www.baeldung.com/spring-data-jpa-query
	@Query("SELECT u FROM User u WHERE u.role!=1")
	Collection<User> findNonAdminUsers();
}