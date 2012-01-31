package com.winenergy.bookmark.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.dispatcher.DefaultActionSupport;

import com.liferay.portal.kernel.exception.SystemException;
import com.winenergy.bookmark.MessageStore;
import com.winenergy.bookmark.model.Bookmark;
import com.winenergy.bookmark.service.BookmarkLocalServiceUtil;

public class DeleteBookmarkAction extends DefaultActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5330200206258499927L;
	
	private String bookmarkName;

	@Override
	public String execute() throws Exception {
		Bookmark bookmark = retrieveBookmark();

		try {
			BookmarkLocalServiceUtil.deleteBookmark(bookmark);
			//add success remove message
			addActionMessage(MessageStore.BOOKMARK_REMOVED_SUCCESSFUL);
				
			return SUCCESS;
		}
		catch (SystemException e) {
			//handle the error massage 
//			addActionError(MessageStore.BOOKMARK_REMOVED_FAILED);
			addFieldError("failed", MessageStore.BOOKMARK_REMOVED_FAILED);
			
			addFieldError("System Exception", e.toString());
			
			
			return ERROR;
		}
	}
	
	/**
	 * find the Bookmark Object from the view
	 * @return 
	 */
	private Bookmark retrieveBookmark() {
		List<Bookmark> bookmarks = new ArrayList<Bookmark>();
		
		try {
			bookmarks = BookmarkLocalServiceUtil.getBookmarkByName(getBookmarkName());
		} catch (SystemException e) {
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