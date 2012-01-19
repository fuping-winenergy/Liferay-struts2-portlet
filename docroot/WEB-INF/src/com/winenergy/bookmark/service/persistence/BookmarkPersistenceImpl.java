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

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.winenergy.bookmark.NoSuchBookmarkException;
import com.winenergy.bookmark.model.Bookmark;
import com.winenergy.bookmark.model.impl.BookmarkImpl;
import com.winenergy.bookmark.model.impl.BookmarkModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the bookmark service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Fuping Ma
 * @see BookmarkPersistence
 * @see BookmarkUtil
 * @generated
 */
public class BookmarkPersistenceImpl extends BasePersistenceImpl<Bookmark>
	implements BookmarkPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BookmarkUtil} to access the bookmark persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BookmarkImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME = new FinderPath(BookmarkModelImpl.ENTITY_CACHE_ENABLED,
			BookmarkModelImpl.FINDER_CACHE_ENABLED, BookmarkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByname",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME = new FinderPath(BookmarkModelImpl.ENTITY_CACHE_ENABLED,
			BookmarkModelImpl.FINDER_CACHE_ENABLED, BookmarkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByname",
			new String[] { String.class.getName() },
			BookmarkModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(BookmarkModelImpl.ENTITY_CACHE_ENABLED,
			BookmarkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByname",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BookmarkModelImpl.ENTITY_CACHE_ENABLED,
			BookmarkModelImpl.FINDER_CACHE_ENABLED, BookmarkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BookmarkModelImpl.ENTITY_CACHE_ENABLED,
			BookmarkModelImpl.FINDER_CACHE_ENABLED, BookmarkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BookmarkModelImpl.ENTITY_CACHE_ENABLED,
			BookmarkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the bookmark in the entity cache if it is enabled.
	 *
	 * @param bookmark the bookmark
	 */
	public void cacheResult(Bookmark bookmark) {
		EntityCacheUtil.putResult(BookmarkModelImpl.ENTITY_CACHE_ENABLED,
			BookmarkImpl.class, bookmark.getPrimaryKey(), bookmark);

		bookmark.resetOriginalValues();
	}

	/**
	 * Caches the bookmarks in the entity cache if it is enabled.
	 *
	 * @param bookmarks the bookmarks
	 */
	public void cacheResult(List<Bookmark> bookmarks) {
		for (Bookmark bookmark : bookmarks) {
			if (EntityCacheUtil.getResult(
						BookmarkModelImpl.ENTITY_CACHE_ENABLED,
						BookmarkImpl.class, bookmark.getPrimaryKey()) == null) {
				cacheResult(bookmark);
			}
			else {
				bookmark.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all bookmarks.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BookmarkImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BookmarkImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the bookmark.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Bookmark bookmark) {
		EntityCacheUtil.removeResult(BookmarkModelImpl.ENTITY_CACHE_ENABLED,
			BookmarkImpl.class, bookmark.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Bookmark> bookmarks) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Bookmark bookmark : bookmarks) {
			EntityCacheUtil.removeResult(BookmarkModelImpl.ENTITY_CACHE_ENABLED,
				BookmarkImpl.class, bookmark.getPrimaryKey());
		}
	}

	/**
	 * Creates a new bookmark with the primary key. Does not add the bookmark to the database.
	 *
	 * @param bookmarkId the primary key for the new bookmark
	 * @return the new bookmark
	 */
	public Bookmark create(long bookmarkId) {
		Bookmark bookmark = new BookmarkImpl();

		bookmark.setNew(true);
		bookmark.setPrimaryKey(bookmarkId);

		return bookmark;
	}

	/**
	 * Removes the bookmark with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bookmarkId the primary key of the bookmark
	 * @return the bookmark that was removed
	 * @throws com.winenergy.bookmark.NoSuchBookmarkException if a bookmark with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Bookmark remove(long bookmarkId)
		throws NoSuchBookmarkException, SystemException {
		return remove(Long.valueOf(bookmarkId));
	}

	/**
	 * Removes the bookmark with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the bookmark
	 * @return the bookmark that was removed
	 * @throws com.winenergy.bookmark.NoSuchBookmarkException if a bookmark with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Bookmark remove(Serializable primaryKey)
		throws NoSuchBookmarkException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Bookmark bookmark = (Bookmark)session.get(BookmarkImpl.class,
					primaryKey);

			if (bookmark == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBookmarkException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(bookmark);
		}
		catch (NoSuchBookmarkException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Bookmark removeImpl(Bookmark bookmark) throws SystemException {
		bookmark = toUnwrappedModel(bookmark);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, bookmark);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(bookmark);

		return bookmark;
	}

	@Override
	public Bookmark updateImpl(com.winenergy.bookmark.model.Bookmark bookmark,
		boolean merge) throws SystemException {
		bookmark = toUnwrappedModel(bookmark);

		boolean isNew = bookmark.isNew();

		BookmarkModelImpl bookmarkModelImpl = (BookmarkModelImpl)bookmark;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, bookmark, merge);

			bookmark.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !BookmarkModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((bookmarkModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { bookmarkModelImpl.getOriginalName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
					args);

				args = new Object[] { bookmarkModelImpl.getName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
					args);
			}
		}

		EntityCacheUtil.putResult(BookmarkModelImpl.ENTITY_CACHE_ENABLED,
			BookmarkImpl.class, bookmark.getPrimaryKey(), bookmark);

		return bookmark;
	}

	protected Bookmark toUnwrappedModel(Bookmark bookmark) {
		if (bookmark instanceof BookmarkImpl) {
			return bookmark;
		}

		BookmarkImpl bookmarkImpl = new BookmarkImpl();

		bookmarkImpl.setNew(bookmark.isNew());
		bookmarkImpl.setPrimaryKey(bookmark.getPrimaryKey());

		bookmarkImpl.setBookmarkId(bookmark.getBookmarkId());
		bookmarkImpl.setName(bookmark.getName());
		bookmarkImpl.setUrl(bookmark.getUrl());

		return bookmarkImpl;
	}

	/**
	 * Returns the bookmark with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the bookmark
	 * @return the bookmark
	 * @throws com.liferay.portal.NoSuchModelException if a bookmark with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Bookmark findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the bookmark with the primary key or throws a {@link com.winenergy.bookmark.NoSuchBookmarkException} if it could not be found.
	 *
	 * @param bookmarkId the primary key of the bookmark
	 * @return the bookmark
	 * @throws com.winenergy.bookmark.NoSuchBookmarkException if a bookmark with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Bookmark findByPrimaryKey(long bookmarkId)
		throws NoSuchBookmarkException, SystemException {
		Bookmark bookmark = fetchByPrimaryKey(bookmarkId);

		if (bookmark == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + bookmarkId);
			}

			throw new NoSuchBookmarkException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				bookmarkId);
		}

		return bookmark;
	}

	/**
	 * Returns the bookmark with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the bookmark
	 * @return the bookmark, or <code>null</code> if a bookmark with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Bookmark fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the bookmark with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bookmarkId the primary key of the bookmark
	 * @return the bookmark, or <code>null</code> if a bookmark with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Bookmark fetchByPrimaryKey(long bookmarkId)
		throws SystemException {
		Bookmark bookmark = (Bookmark)EntityCacheUtil.getResult(BookmarkModelImpl.ENTITY_CACHE_ENABLED,
				BookmarkImpl.class, bookmarkId);

		if (bookmark == _nullBookmark) {
			return null;
		}

		if (bookmark == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				bookmark = (Bookmark)session.get(BookmarkImpl.class,
						Long.valueOf(bookmarkId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (bookmark != null) {
					cacheResult(bookmark);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(BookmarkModelImpl.ENTITY_CACHE_ENABLED,
						BookmarkImpl.class, bookmarkId, _nullBookmark);
				}

				closeSession(session);
			}
		}

		return bookmark;
	}

	/**
	 * Returns all the bookmarks where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching bookmarks
	 * @throws SystemException if a system exception occurred
	 */
	public List<Bookmark> findByname(String name) throws SystemException {
		return findByname(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Bookmark> findByname(String name, int start, int end)
		throws SystemException {
		return findByname(name, start, end, null);
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
	public List<Bookmark> findByname(String name, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME;
			finderArgs = new Object[] { name };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME;
			finderArgs = new Object[] { name, start, end, orderByComparator };
		}

		List<Bookmark> list = (List<Bookmark>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_BOOKMARK_WHERE);

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else {
				if (name.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_NAME_NAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_NAME_NAME_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(BookmarkModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (name != null) {
					qPos.add(name);
				}

				list = (List<Bookmark>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
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
	public Bookmark findByname_First(String name,
		OrderByComparator orderByComparator)
		throws NoSuchBookmarkException, SystemException {
		List<Bookmark> list = findByname(name, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("name=");
			msg.append(name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchBookmarkException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public Bookmark findByname_Last(String name,
		OrderByComparator orderByComparator)
		throws NoSuchBookmarkException, SystemException {
		int count = countByname(name);

		List<Bookmark> list = findByname(name, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("name=");
			msg.append(name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchBookmarkException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public Bookmark[] findByname_PrevAndNext(long bookmarkId, String name,
		OrderByComparator orderByComparator)
		throws NoSuchBookmarkException, SystemException {
		Bookmark bookmark = findByPrimaryKey(bookmarkId);

		Session session = null;

		try {
			session = openSession();

			Bookmark[] array = new BookmarkImpl[3];

			array[0] = getByname_PrevAndNext(session, bookmark, name,
					orderByComparator, true);

			array[1] = bookmark;

			array[2] = getByname_PrevAndNext(session, bookmark, name,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Bookmark getByname_PrevAndNext(Session session,
		Bookmark bookmark, String name, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BOOKMARK_WHERE);

		if (name == null) {
			query.append(_FINDER_COLUMN_NAME_NAME_1);
		}
		else {
			if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(BookmarkModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (name != null) {
			qPos.add(name);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(bookmark);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Bookmark> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the bookmarks.
	 *
	 * @return the bookmarks
	 * @throws SystemException if a system exception occurred
	 */
	public List<Bookmark> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Bookmark> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	public List<Bookmark> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Bookmark> list = (List<Bookmark>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BOOKMARK);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BOOKMARK.concat(BookmarkModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Bookmark>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Bookmark>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the bookmarks where name = &#63; from the database.
	 *
	 * @param name the name
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByname(String name) throws SystemException {
		for (Bookmark bookmark : findByname(name)) {
			remove(bookmark);
		}
	}

	/**
	 * Removes all the bookmarks from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Bookmark bookmark : findAll()) {
			remove(bookmark);
		}
	}

	/**
	 * Returns the number of bookmarks where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching bookmarks
	 * @throws SystemException if a system exception occurred
	 */
	public int countByname(String name) throws SystemException {
		Object[] finderArgs = new Object[] { name };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_NAME,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BOOKMARK_WHERE);

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else {
				if (name.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_NAME_NAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_NAME_NAME_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (name != null) {
					qPos.add(name);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of bookmarks.
	 *
	 * @return the number of bookmarks
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_BOOKMARK);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the bookmark persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.winenergy.bookmark.model.Bookmark")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Bookmark>> listenersList = new ArrayList<ModelListener<Bookmark>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Bookmark>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(BookmarkImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = BookmarkPersistence.class)
	protected BookmarkPersistence bookmarkPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_BOOKMARK = "SELECT bookmark FROM Bookmark bookmark";
	private static final String _SQL_SELECT_BOOKMARK_WHERE = "SELECT bookmark FROM Bookmark bookmark WHERE ";
	private static final String _SQL_COUNT_BOOKMARK = "SELECT COUNT(bookmark) FROM Bookmark bookmark";
	private static final String _SQL_COUNT_BOOKMARK_WHERE = "SELECT COUNT(bookmark) FROM Bookmark bookmark WHERE ";
	private static final String _FINDER_COLUMN_NAME_NAME_1 = "bookmark.name IS NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "bookmark.name = ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(bookmark.name IS NULL OR bookmark.name = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "bookmark.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Bookmark exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Bookmark exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BookmarkPersistenceImpl.class);
	private static Bookmark _nullBookmark = new BookmarkImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Bookmark> toCacheModel() {
				return _nullBookmarkCacheModel;
			}
		};

	private static CacheModel<Bookmark> _nullBookmarkCacheModel = new CacheModel<Bookmark>() {
			public Bookmark toEntityModel() {
				return _nullBookmark;
			}
		};
}