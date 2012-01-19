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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.winenergy.bookmark.model.Bookmark;

import java.util.List;

/**
 * The persistence utility for the bookmark service. This utility wraps {@link BookmarkPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Fuping Ma
 * @see BookmarkPersistence
 * @see BookmarkPersistenceImpl
 * @generated
 */
public class BookmarkUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Bookmark bookmark) {
		getPersistence().clearCache(bookmark);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Bookmark> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Bookmark> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Bookmark> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Bookmark update(Bookmark bookmark, boolean merge)
		throws SystemException {
		return getPersistence().update(bookmark, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Bookmark update(Bookmark bookmark, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(bookmark, merge, serviceContext);
	}

	/**
	* Caches the bookmark in the entity cache if it is enabled.
	*
	* @param bookmark the bookmark
	*/
	public static void cacheResult(
		com.winenergy.bookmark.model.Bookmark bookmark) {
		getPersistence().cacheResult(bookmark);
	}

	/**
	* Caches the bookmarks in the entity cache if it is enabled.
	*
	* @param bookmarks the bookmarks
	*/
	public static void cacheResult(
		java.util.List<com.winenergy.bookmark.model.Bookmark> bookmarks) {
		getPersistence().cacheResult(bookmarks);
	}

	/**
	* Creates a new bookmark with the primary key. Does not add the bookmark to the database.
	*
	* @param bookmarkId the primary key for the new bookmark
	* @return the new bookmark
	*/
	public static com.winenergy.bookmark.model.Bookmark create(long bookmarkId) {
		return getPersistence().create(bookmarkId);
	}

	/**
	* Removes the bookmark with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bookmarkId the primary key of the bookmark
	* @return the bookmark that was removed
	* @throws com.winenergy.bookmark.NoSuchBookmarkException if a bookmark with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.winenergy.bookmark.model.Bookmark remove(long bookmarkId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.winenergy.bookmark.NoSuchBookmarkException {
		return getPersistence().remove(bookmarkId);
	}

	public static com.winenergy.bookmark.model.Bookmark updateImpl(
		com.winenergy.bookmark.model.Bookmark bookmark, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(bookmark, merge);
	}

	/**
	* Returns the bookmark with the primary key or throws a {@link com.winenergy.bookmark.NoSuchBookmarkException} if it could not be found.
	*
	* @param bookmarkId the primary key of the bookmark
	* @return the bookmark
	* @throws com.winenergy.bookmark.NoSuchBookmarkException if a bookmark with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.winenergy.bookmark.model.Bookmark findByPrimaryKey(
		long bookmarkId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.winenergy.bookmark.NoSuchBookmarkException {
		return getPersistence().findByPrimaryKey(bookmarkId);
	}

	/**
	* Returns the bookmark with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param bookmarkId the primary key of the bookmark
	* @return the bookmark, or <code>null</code> if a bookmark with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.winenergy.bookmark.model.Bookmark fetchByPrimaryKey(
		long bookmarkId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(bookmarkId);
	}

	/**
	* Returns all the bookmarks where name = &#63;.
	*
	* @param name the name
	* @return the matching bookmarks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.winenergy.bookmark.model.Bookmark> findByname(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByname(name);
	}

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
	public static java.util.List<com.winenergy.bookmark.model.Bookmark> findByname(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByname(name, start, end);
	}

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
	public static java.util.List<com.winenergy.bookmark.model.Bookmark> findByname(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByname(name, start, end, orderByComparator);
	}

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
	public static com.winenergy.bookmark.model.Bookmark findByname_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.winenergy.bookmark.NoSuchBookmarkException {
		return getPersistence().findByname_First(name, orderByComparator);
	}

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
	public static com.winenergy.bookmark.model.Bookmark findByname_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.winenergy.bookmark.NoSuchBookmarkException {
		return getPersistence().findByname_Last(name, orderByComparator);
	}

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
	public static com.winenergy.bookmark.model.Bookmark[] findByname_PrevAndNext(
		long bookmarkId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.winenergy.bookmark.NoSuchBookmarkException {
		return getPersistence()
				   .findByname_PrevAndNext(bookmarkId, name, orderByComparator);
	}

	/**
	* Returns all the bookmarks.
	*
	* @return the bookmarks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.winenergy.bookmark.model.Bookmark> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.winenergy.bookmark.model.Bookmark> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.winenergy.bookmark.model.Bookmark> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the bookmarks where name = &#63; from the database.
	*
	* @param name the name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByname(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByname(name);
	}

	/**
	* Removes all the bookmarks from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of bookmarks where name = &#63;.
	*
	* @param name the name
	* @return the number of matching bookmarks
	* @throws SystemException if a system exception occurred
	*/
	public static int countByname(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByname(name);
	}

	/**
	* Returns the number of bookmarks.
	*
	* @return the number of bookmarks
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static BookmarkPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (BookmarkPersistence)PortletBeanLocatorUtil.locate(com.winenergy.bookmark.service.ClpSerializer.getServletContextName(),
					BookmarkPersistence.class.getName());

			ReferenceRegistry.registerReference(BookmarkUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(BookmarkPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(BookmarkUtil.class, "_persistence");
	}

	private static BookmarkPersistence _persistence;
}