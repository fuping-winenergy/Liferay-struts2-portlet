<link href="/css/main.css" rel="stylesheet" type="text/css" />

<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<sj:head />
<script type="text/javascript">
	<%@ include file="/js/main.js" %>
</script>
 
<h2>Create bookmarks</h2>

<s:if test="hasActionMessages()">
   <div class="message">
      <s:actionmessage/>
   </div>
</s:if>
 
<s:form action="index" id="create_bookmark" theme="xhtml">
	<div id="validationErrors"></div>
	<table>
   		<sj:textfield id="name" name="name" label="Name" onblur="$.publish('nameCheck');"/>  
      	<s:textfield name="url" label="URL"/>
      
      	<s:submit value="Add"/>  
	</table>
	
    <s:url id="validateName" value="/edit/ajax/validateBookmark.action"/>
	<sj:submit targets="validationErrors"
				href="%{validateName}"
	           	value="AJAX Name Check" 
	           	button="true"
	            listenTopics="nameCheck"
            	cssStyle="display:none;"
            	dataType="json"                
            	onSuccessTopics="handleJsonResult"
           	/>
</s:form>

<p><a href="<s:url action='manageBookmarks'/>">Manage Bookmarks</a></p>