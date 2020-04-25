package com.example.springdata.query;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType
;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Anoop Butola
 *
 */

@Entity
@Table(name = "department")
public class Department {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
 
    private String name;
 
    Department(String name){
    	this.name=name;
    }
    
    Department(){
    	
    }
    
    @OneToMany(mappedBy = "department")
    
    
    private List<Employee> employees;

    @JsonIgnore
    public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
 
    // getters and setters...
}