/**
 * 
 */
package com.example.springdata.query;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Anoop Butola
 *
 */
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
