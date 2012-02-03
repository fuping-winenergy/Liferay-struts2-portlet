<%@ taglib prefix="s" uri="/struts-tags" %>

<s:debug />


<h2>Edit bookmark</h2>

<s:form action="editBookmark">
   <input type="hidden" name="oldName" value="<s:property value="%{oldName}"/>"/>
   <table>
      <s:textfield name="name" label="Name" value="%{#session.bookmark.name}"/>
      <s:textfield name="url" label="URL" value="%{#session.bookmark.url}"/>
      <s:submit value="Update"/>
   </table>
</s:form>

<br />