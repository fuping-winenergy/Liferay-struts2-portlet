package com.winenergy.bookmark.action;

import java.util.ArrayList;

import org.apache.struts2.dispatcher.DefaultActionSupport;

import com.winenergy.bookmark.model.Bookmark;
import com.winenergy.bookmark.model.impl.BookmarkImpl;
import com.winenergy.bookmark.service.BookmarkLocalServiceUtil;
import com.winenergy.bookmark.validator.BookmarkValidator;

public class AddBookmarkAction extends DefaultActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4587665276501838677L;
	
	private String name;
	private String url;

	@Override
	public String execute() throws Exception {
		Bookmark bookmark = newBookmark();
		ArrayList<String> errors = new ArrayList<String>();
		BookmarkValidator validator = new BookmarkValidator();
		
		if(validator.validateBookmark(bookmark, errors)) {
			//insert the Bookmark to database
			BookmarkLocalServiceUtil.addBookmark(bookmark);
//			TODO: handle the success massage 
				
			return SUCCESS;
		}
		else {
//			TODO: handle the error massage 
			
			return ERROR;
		}
	}
	
	/**
	 * Create a new Bookmark Object from the view
	 * @return 
	 */
	public Bookmark newBookmark() {
		BookmarkImpl newBookmark =  new BookmarkImpl();
		newBookmark.setName(getName());
		newBookmark.setUrl(getUrl());
		
		return newBookmark;
	}

	/*
	 * Getters and Setters start here
	 */
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
	
}