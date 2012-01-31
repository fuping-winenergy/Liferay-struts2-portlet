package com.winenergy.bookmark.ajax;

import java.util.List;

import com.opensymphony.xwork2.Action;
import com.winenergy.bookmark.validator.BookmarkValidator;

public class ValidateBookmark {

	private String name;
	private List<String> validateErrors;
	
	public String validateBookmarkName() {                   
		BookmarkValidator validator = new BookmarkValidator();
		setValidateErrors(validator.validateBookmarkName(getName()));
		
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

	public List<String> getValidateErrors() {
		return validateErrors;
	}

	public void setValidateErrors(List<String> validateErrors) {
		this.validateErrors = validateErrors;
	} 
}
