package com.example.springdata.query;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Anoop Butola
 *
 */

@Entity
@Table(name="employee")
public class Employee {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
 
    private String name;
 
    private int age;
 
    @ManyToOne
    private Department department;
 
    @OneToMany(mappedBy = "employee")
    private List<Phone> phones;
 
    // getters and setters...
}
