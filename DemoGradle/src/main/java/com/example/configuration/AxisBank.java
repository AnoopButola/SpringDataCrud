package com.example.configuration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
/*
 * Helper Link  :: https://docs.spring.io/spring/docs/2.5.x/reference/beans.html#beans-factory-nature
 * 
 */
public class AxisBank implements BankInterest {

	@Override
	public Float rateOfInterest() {
		return 6f;
	}
	
	@PostConstruct
	public String postConstructMethod(){
		System.out.println("post construct called for AxisBank");
		return null;
	}
	
	
	@PreDestroy
	public String preDestroyMethod(){
		System.out.println("pre destroy called for AxisBank");
		return null;
	}
}
