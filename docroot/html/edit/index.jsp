<link href="/css/main.css" rel="stylesheet" type="text/css" />

<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<sj:head />

<h2>Create bookmarks</h2>

<s:if test="hasActionMessages()">
   <div class="message">
      <s:actionmessage/>
   </div>
</s:if>
 
<s:form action="index" id="create_bookmark">
	<table>
   		<sj:textfield id="name" name="name" label="Name" onblur="$.publish('nameCheck');" />  
      	<s:textfield name="url" label="URL"/>
      
      	<s:submit value="Add"/>
      
	</table>
	
	<div id="div1">Div 1</div>
    <s:url id="ajaxTest" value="/html/edit/html.jsp"/>
	<sj:submit targets="div1" 
				href="%{ajaxTest}"
	           	value="AJAX Name Check" 
	           	indicator="indicator"
	           	button="true"
	            listenTopics="nameCheck"
            	cssStyle="display:none;"
           	/>
	
</s:form>

<p><a href="<s:url action='manageBookmarks'/>">Manage Bookmarks</a></p>