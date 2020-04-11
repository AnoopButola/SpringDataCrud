package com.example.springdata.query;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Anoop Butola
 *
 */

@Entity
@Table(name="phone")
public class Phone {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
 
    private String number;
 
    @ManyToOne
    private Employee employee;
 
    // getters and setters...
}