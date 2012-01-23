package com.winenergy.bookmark.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.dispatcher.DefaultActionSupport;

import com.liferay.portal.kernel.exception.SystemException;
import com.winenergy.bookmark.MessageStore;
import com.winenergy.bookmark.model.Bookmark;
import com.winenergy.bookmark.service.BookmarkLocalServiceUtil;

public class ListBookmarksAction extends DefaultActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7456296059114455080L;
	
	private List<Bookmark> bookmarks = new ArrayList<Bookmark>();
	
	@Override
	public String execute() throws Exception {
		
		//retrieve all the bookmarks from the database
		try {
			setBookmarks(BookmarkLocalServiceUtil.getAllBookmarks());
		} catch (SystemException e) {
			e.printStackTrace();
			
			addFieldError("failed", MessageStore.BOOKMARK_RETRIEVE_FAILED);
			
			return ERROR;
		}
		
		return SUCCESS;
	}
	
	/*
	 * Getters and Setters start here
	 */
	public void setBookmarks(List<Bookmark> bookmarks) {
		this.bookmarks = bookmarks;
	}

	public List<Bookmark> getBookmarks() {
		return bookmarks;
	}
	
}