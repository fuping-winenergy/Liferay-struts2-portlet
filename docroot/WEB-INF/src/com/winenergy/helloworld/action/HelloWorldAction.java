package com.winenergy.helloworld.action;

import com.winenergy.helloworld.model.MessageStore;

import org.apache.struts2.dispatcher.DefaultActionSupport;
//import com.opensymphony.xwork2.ActionSupport;

/**
 * Acts as a Struts 2 controller that responds
 * to a user action by setting the value
 * of the Message model class, and returns a String 
 * result.
 * @author Fuping Ma
 *
 */
public class HelloWorldAction extends DefaultActionSupport {

	private static final long serialVersionUID = 1L;
	
	/**
	 * The model class that stores the message
	 * to display in the view.
	 */
	private MessageStore messageStore;
	
	/*
	 * Creates the MessageStore model object and 
	 * returns success.  The MessageStore model
	 * object will be available to the view.
	 * (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute() throws Exception {
		
		messageStore = new MessageStore() ;
		return SUCCESS;
	}

	public MessageStore getMessageStore() {
		return messageStore;
	}

	public void setMessageStore(MessageStore messageStore) {
		this.messageStore = messageStore;
	}

}
