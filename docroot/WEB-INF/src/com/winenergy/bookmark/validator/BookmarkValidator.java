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
		boolean valid = true;

		if (Validator.isNull(bookmark.getName())) {
			errors.add("bookmark's name is required.");
			valid = false;
		}

		if (Validator.isNull(bookmark.getUrl())) {
			errors.add("bookmark's Url is required.");
			valid = false;
		}

		//validate whether the bookmark name is unique
		List<Bookmark> bookmarks = new ArrayList<Bookmark>();
		try {
			bookmarks = BookmarkLocalServiceUtil.getBookmarkByName(bookmark.getName());
		} catch (SystemException e) {
			errors.add("an error occured when retrieving bookmark by name.");
			e.printStackTrace();
		}
		
		if(bookmarks.size() > 0) {
			errors.add("The bookmark name " + bookmark.getName() + " is ready in use, please modify the name.");
			valid = false;
		}
		
		return valid;
	}
}
