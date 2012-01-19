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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.winenergy.bookmark.service.BookmarkLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author Fuping Ma
 */
public class BookmarkClp extends BaseModelImpl<Bookmark> implements Bookmark {
	public BookmarkClp() {
	}

	public Class<?> getModelClass() {
		return Bookmark.class;
	}

	public String getModelClassName() {
		return Bookmark.class.getName();
	}

	public long getPrimaryKey() {
		return _bookmarkId;
	}

	public void setPrimaryKey(long primaryKey) {
		setBookmarkId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_bookmarkId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getBookmarkId() {
		return _bookmarkId;
	}

	public void setBookmarkId(long bookmarkId) {
		_bookmarkId = bookmarkId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getUrl() {
		return _url;
	}

	public void setUrl(String url) {
		_url = url;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			BookmarkLocalServiceUtil.addBookmark(this);
		}
		else {
			BookmarkLocalServiceUtil.updateBookmark(this);
		}
	}

	@Override
	public Bookmark toEscapedModel() {
		return (Bookmark)Proxy.newProxyInstance(Bookmark.class.getClassLoader(),
			new Class[] { Bookmark.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		BookmarkClp clone = new BookmarkClp();

		clone.setBookmarkId(getBookmarkId());
		clone.setName(getName());
		clone.setUrl(getUrl());

		return clone;
	}

	public int compareTo(Bookmark bookmark) {
		int value = 0;

		if (getBookmarkId() < bookmark.getBookmarkId()) {
			value = -1;
		}
		else if (getBookmarkId() > bookmark.getBookmarkId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		BookmarkClp bookmark = null;

		try {
			bookmark = (BookmarkClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = bookmark.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{bookmarkId=");
		sb.append(getBookmarkId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", url=");
		sb.append(getUrl());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.winenergy.bookmark.model.Bookmark");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>bookmarkId</column-name><column-value><![CDATA[");
		sb.append(getBookmarkId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>url</column-name><column-value><![CDATA[");
		sb.append(getUrl());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _bookmarkId;
	private String _name;
	private String _url;
}