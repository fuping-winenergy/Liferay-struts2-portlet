package com.winenergy.bookmark.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.dispatcher.DefaultActionSupport;
import org.apache.struts2.portlet.interceptor.PortletPreferencesAware;

import javax.portlet.PortletPreferences;
import com.winenergy.bookmark.model.Bookmark;

public class ListBookmarksAction extends DefaultActionSupport implements PortletPreferencesAware {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7456296059114455080L;
	
	private List<Bookmark> bookmarks = new ArrayList<Bookmark>();
	private PortletPreferences portletPreferences;
	
	public List<Bookmark> getBookmarks() {
		return bookmarks;
	}

	public void setPortletPreferences(PortletPreferences portletPreferences) {
		this.portletPreferences = portletPreferences;
	}

	@Override
	public String execute() throws Exception {
		// For simplicity, we'll assume that only bookmarks are stored in the preferences.
		Map<String, String[]> preferencesMap = portletPreferences.getMap();
		for(Map.Entry<String, String[]> entry : preferencesMap.entrySet()) {
			bookmarks.add(new Bookmark(entry.getKey(), entry.getValue()[0]));
		}
      
		return SUCCESS;
	}
	
}