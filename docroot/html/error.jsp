<link href="/css/main.css" rel="stylesheet" type="text/css" />

<%@ taglib prefix="s" uri="/struts-tags" %>

<s:if test="hasFieldErrors()">
   <div class="errors">
      <s:fielderror />
   </div>
</s:if>

<p><a href="<s:url action='manageBookmarks'/>">Manage Bookmarks</a></p>