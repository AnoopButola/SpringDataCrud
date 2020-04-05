package com.example.eventshandling;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@SuppressWarnings("rawtypes")
public class EmailNotifierToAdmin implements ApplicationListener  {

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		
		if(event instanceof EventModel){
			System.out.println("event of instnce type EventModel is trigerred");
		}
	}
	
	

}
