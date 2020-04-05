package com.example.eventshandling;

import org.springframework.context.ApplicationEvent;

public class EventModel extends ApplicationEvent{

	
	public EventModel(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}
	
	// we cannot have simple constructor since base class 
	//does not have any default constructor  so super is required in this.
	public EventModel(){
		super(new Object());
	}
	
	public EventModel(EventModelDetail eventModel){
		super(eventModel);
	}
	/**
	 * 
	 */
	
	static class EventModelDetail{
		public EventModelDetail(){
			
		}
		private String message;
		private String createdUser;
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public String getCreatedUser() {
			return createdUser;
		}
		public void setCreatedUser(String createdUser) {
			this.createdUser = createdUser;
		}
		
	}
	
	
}
