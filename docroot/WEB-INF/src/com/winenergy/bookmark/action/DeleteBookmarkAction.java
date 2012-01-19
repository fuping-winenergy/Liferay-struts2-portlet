package com.winenergy.bookmark.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.dispatcher.DefaultActionSupport;

import com.liferay.portal.kernel.exception.SystemException;
import com.winenergy.bookmark.model.Bookmark;
import com.winenergy.bookmark.service.BookmarkLocalServiceUtil;
import com.winenergy.bookmark.service.persistence.BookmarkUtil;
import com.winenergy.bookmark.validator.BookmarkValidator;

public class DeleteBookmarkAction extends DefaultActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5330200206258499927L;
	
	private String bookmarkName;

	@Override
	public String execute() throws Exception {
		Bookmark bookmark = retrieveBookmark();
		ArrayList<String> errors = new ArrayList<String>();
		BookmarkValidator validator = new BookmarkValidator();
		
		if(validator.validateBookmark(bookmark, errors)) {
			//delete the Bookmark from database
			BookmarkLocalServiceUtil.deleteBookmark(bookmark);
//			TODO: handle the success massage 
				
			return SUCCESS;
		}
		else {
//			TODO: handle the error massage 
			
			return ERROR;
		}
	}
	
	/**
	 * find the Bookmark Object from the view
	 * @return 
	 */
	public Bookmark retrieveBookmark() {
		List<Bookmark> bookmarks = new ArrayList<Bookmark>();
		
		try {
			bookmarks = BookmarkUtil.findByname(getBookmarkName());
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
	public String getBookmarkName() {
		return bookmarkName;
	}

	public void setBookmarkName(String bookmarkName) {
		this.bookmarkName = bookmarkName;
	}
		
}