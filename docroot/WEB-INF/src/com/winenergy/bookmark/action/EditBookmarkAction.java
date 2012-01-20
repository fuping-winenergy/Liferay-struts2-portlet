package com.winenergy.bookmark.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.dispatcher.DefaultActionSupport;
import org.apache.struts2.interceptor.ParameterAware;

import com.liferay.portal.kernel.exception.SystemException;
import com.opensymphony.xwork2.Preparable;
import com.winenergy.bookmark.MessageStore;
import com.winenergy.bookmark.model.Bookmark;
import com.winenergy.bookmark.service.BookmarkLocalServiceUtil;
import com.winenergy.bookmark.validator.BookmarkValidator;

public class EditBookmarkAction extends DefaultActionSupport 
								implements Preparable, ParameterAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1672869159642951666L;
	
	private String oldName;
	private String name;
	private String url;
	
	private Bookmark bookmark; 
	private Map<String, String[]> parameters;
	private MessageStore messageStore;
	
   	@Override
   	public String execute() throws Exception {
		ArrayList<String> errors = new ArrayList<String>();
		BookmarkValidator validator = new BookmarkValidator();
		StringBuilder message = new StringBuilder();
		messageStore = new MessageStore() ;
		
		//assign new values to the bookmark
		getBookmark().setName(getName());
		getBookmark().setUrl(getUrl());
		
		if(validator.validateBookmark(bookmark, errors)) {
			//update the Bookmark in the database
			BookmarkLocalServiceUtil.updateBookmark(bookmark);
			//create success message
			message.append("Bookmark ").append(getName())
				.append(" has been updated successfully.");
			messageStore.setMessage(message.toString());
			
			//add success added message
			addActionMessage(messageStore.getMessage());
			
			return SUCCESS;
		}
		else {
			//handle error message
			message.append("Bookmark ").append(getName())
				.append("was not updated!");
			messageStore.setMessage(message.toString());
			
			addActionError(messageStore.getMessage());
			
			return ERROR;
		}
   	}

	@Override
	public void prepare() throws Exception {
		// Since the prepare interceptor is run before the parameter interceptor,    		
		// we have to get the parameter "manually".   		
		this.oldName = parameters.get("oldName")[0];   		
		setBookmark(retrieveBookmark());
	
	}
   
   	/**
	 * find the Bookmark Object from the view with the old bookmark name
	 * @return 
	 */
	private Bookmark retrieveBookmark() {
		List<Bookmark> bookmarks = new ArrayList<Bookmark>();
		
		try {
			bookmarks = BookmarkLocalServiceUtil.getBookmarkByName(getOldName());
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(bookmarks.isEmpty()) {
//			TODO: handle no result returns
			
		}
		else if(bookmarks.size() > 1) {
//			TODO: handle no unique results
			
		}
			
		return bookmarks.get(0);
	}
   	
   	/*
	 * Getters and Setters start here
	 */
   	public String getOldName() {
   		return oldName;
   	}
	
   	public void setOldName(String oldName) {
   		this.oldName = oldName;
   	}
	
   	public Bookmark getBookmark() {
		return bookmark;
	}

	public void setBookmark(Bookmark bookmark) {
		this.bookmark = bookmark;
	}
	
	public void setParameters(Map<String, String[]> parameters) {   		
		this.parameters = parameters;   	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public MessageStore getMessageStore() {
		return messageStore;
	}

	public void setMessageStore(MessageStore messageStore) {
		this.messageStore = messageStore;
	}
}