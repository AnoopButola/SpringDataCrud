package com.example.eventshandling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/event")
public class EventController {
 
	@Autowired
	ApplicationContextProvider applicationContextProvider;
	
	@GetMapping()
	public String triggerEvent(){
		
		System.out.println("assuming user is created so we can notify adkin that new user has been created");
		
		EventModel.EventModelDetail model=new EventModel.EventModelDetail();
		model.setCreatedUser("Rest_CREATED");
		model.setMessage("ROLE IS ADMIN");
		EventModel event=new EventModel(model);
		applicationContextProvider.getApplicationContext().publishEvent(event);
		
		return "event trigerred succesfully ";
	}
}
