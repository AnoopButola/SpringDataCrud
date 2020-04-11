package com.example.springdata.query;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType
;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
 
    @OneToMany(mappedBy = "department")
    private List<Employee> employees;
 
    // getters and setters...
}