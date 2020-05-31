package com.example.eventshandling;

import org.springframework.context.ApplicationEvent;

public class EventModel extends ApplicationEvent{

	private EventModelDetail eventModelDetail;
	public EventModelDetail getEventModelDetail() {
		return eventModelDetail;
	}

	public void setEventModelDetail(EventModelDetail eventModelDetail) {
		this.eventModelDetail = eventModelDetail;
	}

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
		this.eventModelDetail=eventModel;
	}
	/**
	 * 
	 */
	
	
	
	public  enum TaskType{
		BOOTSTRAP_TASK,
		NON_BOOTSTRAP_TASK
	}
	public static class EventModelDetail{
		public EventModelDetail(){
			
		}
		private  TaskType taskType;
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
		public TaskType getTaskType() {
			return taskType;
		}
		public void setTaskType(TaskType taskType) {
			this.taskType = taskType;
		}
		
		
	}
	
	
}
