package com.example.configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * 
 * 
 * Spring @Configuration annotation helps in Spring annotation based configuration.
 *  @Configuration annotation indicates that a class declares one or more @Bean methods 
 *  and may be processed by the Spring container to generate bean definitions and
 *   service requests for those beans at runtime.

Since spring 2, we were writing our bean configurations to xml files.
 But Spring 3 gave the freedom to move bean definitions out of xml files. 
 we can give bean definitions in Java files itself. This is called
  Spring Java Config feature (using @Configuration annotation).
 * 
 * 
 * Use @Configuration annotation on top of any class to declare that this class
 *  provides one or more @Bean methods and may be processed by the
 *   Spring container to generate bean definitions and service requests 
 *   for those beans at runtime.
 */
@Configuration

public class ConfigurationClass {

	
	 @Bean(name="hdfcBank",initMethod="init",destroyMethod="cleanup")
	    public BankInterest getHdfcBank()
	    {
	        return new HDFCBank();
	    }
	 
	 @Bean(name="sbiBank",initMethod="init",destroyMethod="cleanup")
	 public BankInterest getsbiBank(){
		 return new SBIBank();
	 }
	 
	 
	 @Bean(name="axisBank")
		public AxisBank getAxisBank(){
			return new AxisBank();
		}

	 
}
