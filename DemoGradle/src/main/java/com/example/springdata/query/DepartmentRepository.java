/**
 * 
 */
package com.example.springdata.query;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Anoop Butola
 *
 */
public interface DepartmentRepository extends CrudRepository<Department, Long> {

	
	//it seems for query to work default constructor is required 
	@Query("SELECT dept FROM Department dept WHERE dept.id = ?1")
	Department findDepartmentById(long id);
	 
	@Query("SELECT dept FROM Department dept WHERE dept.id = ?1 and dept.name = ?2")
	Department findDepartmentByIdAndName(long id, String deptName);
}
