package com.winenergy.bookmark.action;

import javax.portlet.PortletPreferences;

import org.apache.struts2.dispatcher.DefaultActionSupport;
import org.apache.struts2.portlet.interceptor.PortletPreferencesAware;

public class AddBookmarkAction extends DefaultActionSupport implements PortletPreferencesAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4587665276501838677L;
	
	private String name;
	private String url;

	private PortletPreferences portletPreferences;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public PortletPreferences getPortletPreferences() {
		return portletPreferences;
	}

	@Override
	public void setPortletPreferences(PortletPreferences portletPreferences) {
		 this.portletPreferences = portletPreferences;
	}

	@Override
	public String execute() throws Exception {
		if(name != null && url != null) {
			portletPreferences.setValue(name, url);
		    portletPreferences.store();
		}
		
		return SUCCESS;
	}
	
}