/**
 * 
 */
package com.example.springdata.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Anoop Butola
 *
 */
public class JsonDTO implements Serializable {
   
	
	private  String name;
	private String address;
	private Integer index;
	private Double salary;
    private JsonMainWrapper jsonMainWrapper;
    
    private List<JsonMainWrapper> jsonMainWarapperList; 
    
    
    
	
	public List<JsonMainWrapper> getJsonMainWarapperList() {
		return jsonMainWarapperList;
	}
	public void setJsonMainWarapperList(List<JsonMainWrapper> jsonMainWarapperList) {
		this.jsonMainWarapperList = jsonMainWarapperList;
	}
	public JsonMainWrapper getJsonMainWrapper() {
		return jsonMainWrapper;
	}
	public void setJsonMainWrapper(JsonMainWrapper jsonMainWrapper) {
		this.jsonMainWrapper = jsonMainWrapper;
	}
	@JsonIgnore
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}

	
}


