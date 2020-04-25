/**
 * 
 */
package com.example.springdata.query;

import java.io.Serializable;

/**
 * @author Anoop Butola
 *
 */
public class GenericResponse extends Object implements Serializable{

	public String responseMsg;
	public String responseCode;
	public Object responseObject;
	/**
	 * @param responseMsg
	 * @param responseCode
	 * @param responseObject
	 */
	public GenericResponse(String responseMsg, String responseCode, Object responseObject) {
		super();
		this.responseMsg = responseMsg;
		this.responseCode = responseCode;
		this.responseObject = responseObject;
	}
	public String getResponseMsg() {
		return responseMsg;
	}
	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public Object getResponseObject() {
		return responseObject;
	}
	public void setResponseObject(Object responseObject) {
		this.responseObject = responseObject;
	}
	
	
	
	
}
