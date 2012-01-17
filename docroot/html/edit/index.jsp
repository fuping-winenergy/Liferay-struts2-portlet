<%@ taglib prefix="s" uri="/struts-tags" %>

<h2>Create bookmarks</h2>

<s:form action="index">
   <table>
      <s:textfield name="name" label="Name"/>
      <s:textfield name="url" label="URL"/>
      <s:submit value="Add"/>
   </table>
</s:form>

<p><a href="<s:url action='manageBookmarks'/>">Manage Bookmarks</a></p>