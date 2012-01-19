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

package com.winenergy.bookmark.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link Bookmark}.
 * </p>
 *
 * @author    Fuping Ma
 * @see       Bookmark
 * @generated
 */
public class BookmarkWrapper implements Bookmark, ModelWrapper<Bookmark> {
	public BookmarkWrapper(Bookmark bookmark) {
		_bookmark = bookmark;
	}

	public Class<?> getModelClass() {
		return Bookmark.class;
	}

	public String getModelClassName() {
		return Bookmark.class.getName();
	}

	/**
	* Returns the primary key of this bookmark.
	*
	* @return the primary key of this bookmark
	*/
	public long getPrimaryKey() {
		return _bookmark.getPrimaryKey();
	}

	/**
	* Sets the primary key of this bookmark.
	*
	* @param primaryKey the primary key of this bookmark
	*/
	public void setPrimaryKey(long primaryKey) {
		_bookmark.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the bookmark ID of this bookmark.
	*
	* @return the bookmark ID of this bookmark
	*/
	public long getBookmarkId() {
		return _bookmark.getBookmarkId();
	}

	/**
	* Sets the bookmark ID of this bookmark.
	*
	* @param bookmarkId the bookmark ID of this bookmark
	*/
	public void setBookmarkId(long bookmarkId) {
		_bookmark.setBookmarkId(bookmarkId);
	}

	/**
	* Returns the name of this bookmark.
	*
	* @return the name of this bookmark
	*/
	public java.lang.String getName() {
		return _bookmark.getName();
	}

	/**
	* Sets the name of this bookmark.
	*
	* @param name the name of this bookmark
	*/
	public void setName(java.lang.String name) {
		_bookmark.setName(name);
	}

	/**
	* Returns the url of this bookmark.
	*
	* @return the url of this bookmark
	*/
	public java.lang.String getUrl() {
		return _bookmark.getUrl();
	}

	/**
	* Sets the url of this bookmark.
	*
	* @param url the url of this bookmark
	*/
	public void setUrl(java.lang.String url) {
		_bookmark.setUrl(url);
	}

	public boolean isNew() {
		return _bookmark.isNew();
	}

	public void setNew(boolean n) {
		_bookmark.setNew(n);
	}

	public boolean isCachedModel() {
		return _bookmark.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_bookmark.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _bookmark.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _bookmark.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_bookmark.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _bookmark.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_bookmark.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BookmarkWrapper((Bookmark)_bookmark.clone());
	}

	public int compareTo(com.winenergy.bookmark.model.Bookmark bookmark) {
		return _bookmark.compareTo(bookmark);
	}

	@Override
	public int hashCode() {
		return _bookmark.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.winenergy.bookmark.model.Bookmark> toCacheModel() {
		return _bookmark.toCacheModel();
	}

	public com.winenergy.bookmark.model.Bookmark toEscapedModel() {
		return new BookmarkWrapper(_bookmark.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _bookmark.toString();
	}

	public java.lang.String toXmlString() {
		return _bookmark.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_bookmark.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Bookmark getWrappedBookmark() {
		return _bookmark;
	}

	public Bookmark getWrappedModel() {
		return _bookmark;
	}

	public void resetOriginalValues() {
		_bookmark.resetOriginalValues();
	}

	private Bookmark _bookmark;
}