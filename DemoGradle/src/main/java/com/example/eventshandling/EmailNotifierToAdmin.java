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
			EventModel model=(EventModel)event;
			switch(model.getEventModelDetail().getTaskType()){
			case BOOTSTRAP_TASK:
				  System.out.println("Bootstrap event called::");
				break;
				
			case NON_BOOTSTRAP_TASK:
				 System.out.println("Non Bootstrap event called::");
				break;
				
				default:
					break;
				
			}
			System.out.println("event of instnce type EventModel is trigerred");
		}
		
		//setUser Password as encoded  one as were not set earlier.
		
	}
	
	

}
