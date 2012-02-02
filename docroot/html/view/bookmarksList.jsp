<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>

<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="com.winenergy.bookmark.model.Bookmark"%>
<%@ page import="com.winenergy.bookmark.service.BookmarkLocalServiceUtil"%>

<sj:head jqueryui="true" jquerytheme="flick" />

<portlet:defineObjects />

<!--table>
   <s:iterator value="%{bookmarks}" var="bookmark">
      <tr>
         <td width = "40%"><s:property value="%{name}"/></td>
         <td width = "60%">
         	<a href="<s:property value="%{url}"/>" target="_blank"><s:property value="%{url}"/></a>
         </td>
      </tr>
   </s:iterator>
</table-->

<s:url id="remoteurl" value="/view/ajax/bookmarkTable.action"/>
<sjg:grid id="gridtable"
    	caption="Bookmarks"
    	dataType="json"
    	href="%{remoteurl}"
    	pager="true"
    	gridModel="gridModel"
    	rowList="5,10,15,20"
    	rowNum="5"
    	rownumbers="true"
    >
	<sjg:gridColumn name="bookmarkId" title="ID" formatter="integer" sortable="false"/>
    <sjg:gridColumn name="name" index="name" title="Name" sortable="true"/>
    <sjg:gridColumn name="url" index="url" title="Url" sortable="false"/>
</sjg:grid>

<br />
<br />
<br />

<%
 PortletURL iteratorURL = renderResponse.createRenderURL();
 iteratorURL.setParameter("jspPage", "/html/view/bookmarksList.jsp");
 iteratorURL.setParameter("struts.portlet.action", "/view/viewBookmarks");
%>


<strong>Bookmarks (liferay-ui)</strong>
<liferay-ui:search-container delta="5" emptyResultsMessage="bookmark-empty-results-message" iteratorURL="<%= iteratorURL %>" >
	<liferay-ui:search-container-results
		results="<%= BookmarkLocalServiceUtil.getBookmarks(searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= BookmarkLocalServiceUtil.getBookmarksCount() %>"
	/>

	<liferay-ui:search-container-row
		className="com.winenergy.bookmark.model.Bookmark"
		keyProperty="bookmarkId"
		modelVar="bookmark"
	>
		<liferay-ui:search-container-column-text
			name="email-address"
			property="name"
		/>

		<liferay-ui:search-container-column-text
			name="phone-number"
			property="url"
			href="<%= bookmark.getUrl() %>" 
			target="_blank"
		/>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>

<p><a href="<s:url action='index'/>">back</a></p>