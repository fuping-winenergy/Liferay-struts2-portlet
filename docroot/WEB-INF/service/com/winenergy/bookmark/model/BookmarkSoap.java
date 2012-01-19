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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    Fuping Ma
 * @generated
 */
public class BookmarkSoap implements Serializable {
	public static BookmarkSoap toSoapModel(Bookmark model) {
		BookmarkSoap soapModel = new BookmarkSoap();

		soapModel.setBookmarkId(model.getBookmarkId());
		soapModel.setName(model.getName());
		soapModel.setUrl(model.getUrl());

		return soapModel;
	}

	public static BookmarkSoap[] toSoapModels(Bookmark[] models) {
		BookmarkSoap[] soapModels = new BookmarkSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BookmarkSoap[][] toSoapModels(Bookmark[][] models) {
		BookmarkSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BookmarkSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BookmarkSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BookmarkSoap[] toSoapModels(List<Bookmark> models) {
		List<BookmarkSoap> soapModels = new ArrayList<BookmarkSoap>(models.size());

		for (Bookmark model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BookmarkSoap[soapModels.size()]);
	}

	public BookmarkSoap() {
	}

	public long getPrimaryKey() {
		return _bookmarkId;
	}

	public void setPrimaryKey(long pk) {
		setBookmarkId(pk);
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

	private long _bookmarkId;
	private String _name;
	private String _url;
}