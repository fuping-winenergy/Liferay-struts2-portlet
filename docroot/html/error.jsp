<link href="/css/main.css" rel="stylesheet" type="text/css" />

<%@ taglib prefix="s" uri="/struts-tags" %>

<s:if test="hasActionErrors()">
   <div class="errors">
      <s:actionerror/>
   </div>
</s:if>

<p><a href="<s:url action='manageBookmarks'/>">Manage Bookmarks</a></p>