package com.example.configuration;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/interest")
public class InterestController  {
	
	@Autowired 
	ConfigurationClass  config;
	

	@GetMapping()
	public String getRateByBankName(@RequestHeader(name = "X-BANK_NAME", required = true) String bankName){
		return bankName.equalsIgnoreCase("sbi")?config.getsbiBank().rateOfInterest().toString():config.getHdfcBank().rateOfInterest().toString();
	    
	}


	

}
