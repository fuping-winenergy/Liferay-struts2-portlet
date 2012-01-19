package com.winenergy.bookmark.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.dispatcher.DefaultActionSupport;

import com.liferay.portal.kernel.exception.SystemException;
import com.winenergy.bookmark.model.Bookmark;
import com.winenergy.bookmark.service.BookmarkLocalServiceUtil;
import com.winenergy.bookmark.validator.BookmarkValidator;

public class EditBookmarkAction extends DefaultActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1672869159642951666L;
	
	private String oldName;
	private String name;
	private String url;
	
   	@Override
   	public String execute() throws Exception {
   		Bookmark bookmark = retrieveBookmark();
		ArrayList<String> errors = new ArrayList<String>();
		BookmarkValidator validator = new BookmarkValidator();
		
		//assign new values to the bookmark
		bookmark.setName(getName());
		bookmark.setUrl(getUrl());
		
		if(validator.validateBookmark(bookmark, errors)) {
			//update the Bookmark in the database
			BookmarkLocalServiceUtil.updateBookmark(bookmark);
//			TODO: handle the success massage 
				
			return SUCCESS;
		}
		else {
//			TODO: handle the error massage 
			
			return ERROR;
		}
   	}
   	
   	/**
	 * find the Bookmark Object from the view with the old bookmark name
	 * @return 
	 */
	public Bookmark retrieveBookmark() {
		List<Bookmark> bookmarks = new ArrayList<Bookmark>();
		
		try {
			bookmarks = BookmarkLocalServiceUtil.getBookmarkByName(getName());
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
	
   	public String getUrl() {
   		return url;
   	}

   	public void setUrl(String url) {
   		this.url = url;
   	}

   	public String getName() {
		return name;
	}

	public void setName(String name) {
   		this.name = name;
   	}
   	
}