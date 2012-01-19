package com.winenergy.bookmark.validator;

import java.util.List;

import com.liferay.portal.kernel.util.Validator;
import com.winenergy.bookmark.model.Bookmark;

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

//		TODO: need to validate both name and url are unique
		
		return valid;
	}
}
