package com.example.configuration;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

//@Component
public class HDFCBank implements BankInterest ,InitializingBean,DisposableBean {

	/*calling sequence is
	//1)calling hdfcClass constructor
	  2)calling afterpropertiesSet method of InitializingBean interface(HDFCBank):::
      3)calling init lifecycle method of HDFCBank:::
      
	*/
	
	@Override
	public Float rateOfInterest() {
		
		return 7f;
	}
	
	HDFCBank(){
		System.out.println("calling hdfcClass constructor");
	}
	

	public void init() {
       System.out.println("calling init lifecycle method of HDFCBank:::");
    }
 
	
	 public void cleanup() {
		   System.out.println("calling cleanup lifecycle method of HDFCBank:::");
		   
	    }

	@Override
	public void afterPropertiesSet() throws Exception {
		 System.out.println("calling afterpropertiesSet method of InitializingBean interface(HDFCBank):::");		
	}

	@Override
	public void destroy() throws Exception {
		
		System.out.println("calling destroy method of DisposableBean interface(HDFCBank):::");	
	}
	
	

}
