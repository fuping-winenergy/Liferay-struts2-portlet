<%@ taglib prefix="s" uri="/struts-tags" %>

<h2>Manage bookmarks</h2>

<s:if test="hasActionMessages()">
   <div class="message">
      <s:actionmessage/>
   </div>
</s:if>

<table>
   <s:iterator value="%{bookmarks}" var="bookmark">
      <s:url action="editBookmark!input" id="editUrl">
         <s:param name="oldName" value="%{name}"/>
      </s:url>
      <s:url action="deleteBookmark" portletUrlType="action" id="deleteUrl">
         <s:param name="bookmarkName" value="%{name}"/>
      </s:url>
      <tr>
         <td width = "30%"><s:property value="%{name}"/></td>
         <td width = "50%"><a href="<s:property value="%{url}"/>" target="_blank"><s:property value="%{url}"/></a></td>
         <td width = "10%"><a href="<s:property value="%{editUrl}"/>">Edit</a></td>
         <td width = "10%"><a href="<s:property value="%{deleteUrl}"/>">Delete</a></td>
      </tr>
   </s:iterator>
</table>


<p><a href="<s:url action='index!input'/>">Add Bookmarks</a></p>