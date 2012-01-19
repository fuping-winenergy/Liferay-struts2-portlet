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

package com.winenergy.bookmark.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.winenergy.bookmark.model.Bookmark;

/**
 * The persistence interface for the bookmark service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Fuping Ma
 * @see BookmarkPersistenceImpl
 * @see BookmarkUtil
 * @generated
 */
public interface BookmarkPersistence extends BasePersistence<Bookmark> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BookmarkUtil} to access the bookmark persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the bookmark in the entity cache if it is enabled.
	*
	* @param bookmark the bookmark
	*/
	public void cacheResult(com.winenergy.bookmark.model.Bookmark bookmark);

	/**
	* Caches the bookmarks in the entity cache if it is enabled.
	*
	* @param bookmarks the bookmarks
	*/
	public void cacheResult(
		java.util.List<com.winenergy.bookmark.model.Bookmark> bookmarks);

	/**
	* Creates a new bookmark with the primary key. Does not add the bookmark to the database.
	*
	* @param bookmarkId the primary key for the new bookmark
	* @return the new bookmark
	*/
	public com.winenergy.bookmark.model.Bookmark create(long bookmarkId);

	/**
	* Removes the bookmark with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bookmarkId the primary key of the bookmark
	* @return the bookmark that was removed
	* @throws com.winenergy.bookmark.NoSuchBookmarkException if a bookmark with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.winenergy.bookmark.model.Bookmark remove(long bookmarkId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.winenergy.bookmark.NoSuchBookmarkException;

	public com.winenergy.bookmark.model.Bookmark updateImpl(
		com.winenergy.bookmark.model.Bookmark bookmark, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bookmark with the primary key or throws a {@link com.winenergy.bookmark.NoSuchBookmarkException} if it could not be found.
	*
	* @param bookmarkId the primary key of the bookmark
	* @return the bookmark
	* @throws com.winenergy.bookmark.NoSuchBookmarkException if a bookmark with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.winenergy.bookmark.model.Bookmark findByPrimaryKey(
		long bookmarkId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.winenergy.bookmark.NoSuchBookmarkException;

	/**
	* Returns the bookmark with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param bookmarkId the primary key of the bookmark
	* @return the bookmark, or <code>null</code> if a bookmark with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.winenergy.bookmark.model.Bookmark fetchByPrimaryKey(
		long bookmarkId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the bookmarks where name = &#63;.
	*
	* @param name the name
	* @return the matching bookmarks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.winenergy.bookmark.model.Bookmark> findByname(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the bookmarks where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of bookmarks
	* @param end the upper bound of the range of bookmarks (not inclusive)
	* @return the range of matching bookmarks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.winenergy.bookmark.model.Bookmark> findByname(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the bookmarks where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of bookmarks
	* @param end the upper bound of the range of bookmarks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bookmarks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.winenergy.bookmark.model.Bookmark> findByname(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first bookmark in the ordered set where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bookmark
	* @throws com.winenergy.bookmark.NoSuchBookmarkException if a matching bookmark could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.winenergy.bookmark.model.Bookmark findByname_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.winenergy.bookmark.NoSuchBookmarkException;

	/**
	* Returns the last bookmark in the ordered set where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bookmark
	* @throws com.winenergy.bookmark.NoSuchBookmarkException if a matching bookmark could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.winenergy.bookmark.model.Bookmark findByname_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.winenergy.bookmark.NoSuchBookmarkException;

	/**
	* Returns the bookmarks before and after the current bookmark in the ordered set where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param bookmarkId the primary key of the current bookmark
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bookmark
	* @throws com.winenergy.bookmark.NoSuchBookmarkException if a bookmark with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.winenergy.bookmark.model.Bookmark[] findByname_PrevAndNext(
		long bookmarkId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.winenergy.bookmark.NoSuchBookmarkException;

	/**
	* Returns all the bookmarks.
	*
	* @return the bookmarks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.winenergy.bookmark.model.Bookmark> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the bookmarks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of bookmarks
	* @param end the upper bound of the range of bookmarks (not inclusive)
	* @return the range of bookmarks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.winenergy.bookmark.model.Bookmark> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the bookmarks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of bookmarks
	* @param end the upper bound of the range of bookmarks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of bookmarks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.winenergy.bookmark.model.Bookmark> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the bookmarks where name = &#63; from the database.
	*
	* @param name the name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByname(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the bookmarks from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bookmarks where name = &#63;.
	*
	* @param name the name
	* @return the number of matching bookmarks
	* @throws SystemException if a system exception occurred
	*/
	public int countByname(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bookmarks.
	*
	* @return the number of bookmarks
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}