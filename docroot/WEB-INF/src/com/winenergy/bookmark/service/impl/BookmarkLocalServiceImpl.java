/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.winenergy.bookmark.service.impl;

import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.winenergy.bookmark.model.Bookmark;
import com.winenergy.bookmark.service.base.BookmarkLocalServiceBaseImpl;
import com.winenergy.bookmark.service.persistence.BookmarkUtil;

/**
 * The implementation of the bookmark local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.winenergy.bookmark.service.BookmarkLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Fuping Ma
 * @see com.winenergy.bookmark.service.base.BookmarkLocalServiceBaseImpl
 * @see com.winenergy.bookmark.service.BookmarkLocalServiceUtil
 */
public class BookmarkLocalServiceImpl extends BookmarkLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.winenergy.bookmark.service.BookmarkLocalServiceUtil} to access the bookmark local service.
	 */
	
	/**
	 * Adds the Bookmark to the database incrementing the primary key
	 *
	 */
	public Bookmark addBookmark(Bookmark newBookmark) throws SystemException {

		long bookmarkId = CounterLocalServiceUtil.increment(Bookmark.class.getName());

		Bookmark bookmark = bookmarkPersistence.create(bookmarkId);
		bookmark.setName(newBookmark.getName());
		bookmark.setUrl(newBookmark.getUrl());
		
		bookmarkPersistence.update(bookmark, false);

		return bookmark;
	}


	/**
	 * Deletes a Bookmark from the database using the Bookmark object.
	 */
	public void deleteBookmark (Bookmark bookmark) throws PortalException, SystemException {

//		resourceLocalService.deleteResource(
//				bookmark.getCompanyId(), Bookmark.class.getName(),
//				ResourceConstants.SCOPE_INDIVIDUAL, bookmark.getPrimaryKey());

		super.deleteBookmark(bookmark);
	}

	/**
	 * Deletes a bookmark from the database using a bookmark ID.
	 */
	public void deleteBookmark (long bookmarkId) throws PortalException, SystemException {

		Bookmark bookmark = getBookmark(bookmarkId);

		deleteBookmark(bookmark);
	}

	/**
	 * retrieve all the bookmarks from the database
	 * @return List<Bookmark>
	 */
	public List<Bookmark> getAllBookmarks() throws SystemException {
		
		return BookmarkUtil.findAll();
	}
	
	/**
	 * retrieve the bookmark by bookmark name from the database
	 * @return
	 */
	public List<Bookmark> getBookmarkByName(String name) throws SystemException {
		
		return BookmarkUtil.findByname(name);
	}
}