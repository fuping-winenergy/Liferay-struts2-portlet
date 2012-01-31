package com.winenergy.bookmark.validator;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.winenergy.bookmark.model.Bookmark;
import com.winenergy.bookmark.service.BookmarkLocalServiceUtil;

public class BookmarkValidator {
	/**
	 * Verify bookmark
	 * 
	 * @param bookmark
	 *            to be validated
	 * @param errors
	 *            to populate with any errors
	 */
	public boolean validateBookmark(Bookmark bookmark, List<String> errors) {
		//validate name
		errors.addAll(validateBookmarkName(bookmark.getName()));
		
		/*
		 * com.liferay.portal.kernel.util.Validator has lots of utilities
		 * isNull,
		 * isEmailAddress,
		 * isPhoneNumber,
		 * ...
		 */
		//check url
		if (Validator.isNull(bookmark.getUrl())) {
			errors.add("bookmark's Url is required.");
		}

		return errors.size() < 1;
	}
	
	public List<String> validateBookmarkName(String name) {
		List<String> validateErrors = new ArrayList<String>();
		
		if (Validator.isNull(name)) {
			validateErrors.add("bookmark's name is required.");
		}

		//validate whether the bookmark name is unique
		List<Bookmark> bookmarks = new ArrayList<Bookmark>();
		try {
			bookmarks = BookmarkLocalServiceUtil.getBookmarkByName(name);
		} catch (SystemException e) {
			validateErrors.add("an error occured when retrieving bookmark by name.");
			e.printStackTrace();
		}
		
		if(bookmarks.size() > 0) {
			validateErrors.add("The bookmark name " + name + " is ready in use, please modify the name.");
		}
		
		return validateErrors;
	}
}
