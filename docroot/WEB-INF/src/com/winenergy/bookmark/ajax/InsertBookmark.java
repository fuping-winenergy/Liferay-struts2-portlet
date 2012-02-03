package com.winenergy.bookmark.ajax;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.Action;
import com.winenergy.bookmark.model.Bookmark;
import com.winenergy.bookmark.model.impl.BookmarkImpl;
import com.winenergy.bookmark.service.BookmarkLocalServiceUtil;
import com.winenergy.bookmark.validator.BookmarkValidator;

public class InsertBookmark {

	private String name;
	private String url;
	private List<String> validateErrors;
	
	public String insert() throws Exception {                   
		
		Bookmark bookmark = new BookmarkImpl();
		bookmark.setName(getName());
		bookmark.setUrl(getUrl());
		validateErrors = new ArrayList<String>();
		BookmarkValidator validator = new BookmarkValidator();
		
		if(validator.validateBookmark(bookmark, validateErrors)) {
			//insert the Bookmark to database
			BookmarkLocalServiceUtil.addBookmark(bookmark);   
		}
		
		return Action.SUCCESS;     
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
	
	public List<String> getValidateErrors() {
		return validateErrors;
	}

	public void setValidateErrors(List<String> validateErrors) {
		this.validateErrors = validateErrors;
	}
}
