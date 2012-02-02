function newBookmark() {
	AUI().use('liferay-portlet-url', 'aui-dialog', 'aui-io', 'event', 'event-custom', function(A) {
		//generate struts action url
		var addBookmarkAction = Liferay.PortletURL.createActionURL();
		addBookmarkAction.setWindowState("exclusive");
		addBookmarkAction.setPortletId("strutsPortlet_WAR_Liferaystruts2portlet");
		addBookmarkAction.setParameter("struts.portlet.action", "/edit/index!input");
		
	    var dialog = new A.Dialog({
		    	title: 'New Bookmark', 
		        centered: true, 
		        modal: true, 
		        width: 400, 
	        }).plug(A.Plugin.IO, {
	        		uri: addBookmarkAction.toString()
	        	}).render();
       
        dialog.show();
       
	});
}

function editBookmark(old_name) {
	AUI().use('liferay-portlet-url', 'aui-dialog', 'aui-io', 'event', 'event-custom', function(A) {
		//generate struts action url
		var editBookmarkAction = Liferay.PortletURL.createActionURL();
		editBookmarkAction.setWindowState("exclusive");
		editBookmarkAction.setPortletId("strutsPortlet_WAR_Liferaystruts2portlet");
		editBookmarkAction.setParameter("struts.portlet.action", "/edit/editBookmark!input");
		editBookmarkAction.setParameter("oldName", old_name);
		
		var dialog = new A.Dialog({
				title: 'Edit Bookmark', 
		        centered: true, 
		        modal: true, 
		        width: 400, 
	        }).plug(A.Plugin.IO, {
	        		uri: editBookmarkAction.toString()
	        	}).render();
	       
		dialog.show();
	       
	 });

}