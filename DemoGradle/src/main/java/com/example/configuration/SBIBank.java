package com.example.configuration;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

//@Component(value="sbiBank")
public class SBIBank implements BankInterest ,InitializingBean,DisposableBean{

	 
	 
	@Override
	public Float rateOfInterest() {
		return 8f;
	}
	
	SBIBank(){
		System.out.println("calling SBIBank constructor");
	}

	
	public void init() {
	       System.out.println("calling init lifecycle method of SBIBank:::");
	    }
	 
		
		 public void cleanup() {
			   System.out.println("calling cleanup lifecycle method of SBIBank:::");
			   
		    }

		@Override
		public void destroy() throws Exception {
			System.out.println("destroy  method of DisposableBean (SBIBank) is called:::");
			
		}

		@Override
		public void afterPropertiesSet() throws Exception {
			System.out.println("afterPropertiesSet  method of InitializingBean (SBIBank) is called:::");
			
		}
		
		
}
