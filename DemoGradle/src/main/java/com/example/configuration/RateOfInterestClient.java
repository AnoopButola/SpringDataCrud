package com.example.configuration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RateOfInterestClient {

	public static void main(String[] args)
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationClass.class);
 
        /*
         * 20:16:01.949 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'hdfcBank'
calling hdfcClass constructor
20:16:01.974 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'sbiBank'
calling SBIBank constructor
         * 
         * 
         */
        
       // BankInterest  obj = (BankInterest) context.getBean("hdfcBank");
 
      //  System.out.println( obj.rateOfInterest());
    }
}
