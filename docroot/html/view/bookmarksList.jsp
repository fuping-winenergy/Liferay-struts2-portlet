<%@ taglib prefix="s" uri="/struts-tags" %>

<strong>Bookmarks</strong>

<table>
   <s:iterator value="%{bookmarks}" var="bookmark">
      <tr>
         <td width = "40%"><s:property value="%{name}"/></td>
         <td width = "60%">
         	<a href="<s:property value="%{url}"/>" target="_blank"><s:property value="%{url}"/></a>
         </td>
      </tr>
   </s:iterator>
</table>

<p><a href="<s:url action='index'/>">back</a></p>