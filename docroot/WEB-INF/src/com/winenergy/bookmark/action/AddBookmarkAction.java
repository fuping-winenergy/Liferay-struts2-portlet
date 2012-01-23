package com.winenergy.bookmark.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.struts2.dispatcher.DefaultActionSupport;

import com.winenergy.bookmark.MessageStore;
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
	private List<String> validateErrors;

	@Override
	public String execute() throws Exception {
		if(validateBookmark().size() > 0)
			return SUCCESS;
		else
			return ERROR;
	}
	
	public List<String> validateBookmark() throws Exception {
		Bookmark bookmark = newBookmark();
		validateErrors = new ArrayList<String>();
		BookmarkValidator validator = new BookmarkValidator();
		
		if(validator.validateBookmark(bookmark, validateErrors)) {
			//insert the Bookmark to database
			BookmarkLocalServiceUtil.addBookmark(bookmark);
			//add success added message
			addActionMessage(MessageStore.BOOKMARK_ADDED_SUCCESSFUL);
		}
		else {
			//handle the error massage 
//			addActionError(MessageStore.BOOKMARK_ADDED_FAILED);
			addFieldError("failed", MessageStore.BOOKMARK_ADDED_FAILED);
			Iterator<String> errorIter = validateErrors.iterator();
			int count = 0;
			while (errorIter.hasNext()) {
				String error = errorIter.next();
				addFieldError("error" + count, error);
				count++;
			}
		}
		
		return validateErrors;
	}
	
	/**
	 * Create a new Bookmark Object from the view
	 * @return 
	 */
	private Bookmark newBookmark() {
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

	public List<String> getValidateErrors() {
		return validateErrors;
	}

	public void setValidateErrors(List<String> validateErrors) {
		this.validateErrors = validateErrors;
	}
	
}