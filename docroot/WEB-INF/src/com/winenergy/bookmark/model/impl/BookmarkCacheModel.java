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

package com.winenergy.bookmark.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.winenergy.bookmark.model.Bookmark;

import java.io.Serializable;

/**
 * The cache model class for representing Bookmark in entity cache.
 *
 * @author Fuping Ma
 * @see Bookmark
 * @generated
 */
public class BookmarkCacheModel implements CacheModel<Bookmark>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{bookmarkId=");
		sb.append(bookmarkId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", url=");
		sb.append(url);
		sb.append("}");

		return sb.toString();
	}

	public Bookmark toEntityModel() {
		BookmarkImpl bookmarkImpl = new BookmarkImpl();

		bookmarkImpl.setBookmarkId(bookmarkId);

		if (name == null) {
			bookmarkImpl.setName(StringPool.BLANK);
		}
		else {
			bookmarkImpl.setName(name);
		}

		if (url == null) {
			bookmarkImpl.setUrl(StringPool.BLANK);
		}
		else {
			bookmarkImpl.setUrl(url);
		}

		bookmarkImpl.resetOriginalValues();

		return bookmarkImpl;
	}

	public long bookmarkId;
	public String name;
	public String url;
}