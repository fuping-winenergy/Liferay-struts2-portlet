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
 
<s:form action="index" id="create_bookmark" theme="simple">
	<div id="success_message"></div>
	<table>
		<tr>
			<td>
   				<sj:textfield id="name" name="name" label="Name"  onblur="$.publish('nameCheck');" />
   			</td>
   			<td>
   				<div id="validationErrors"></div>
   			</td>
		</tr>
   		<tr>  
   			<td colspan="2">
      			<s:textfield name="url" label="URL" />
      		</td>
      	</tr>
      	<tr>
      		<td colspan="2">
      			<s:submit value="Add" id="add_button" disabled="true"/>  
      		</td>
      	</tr>
      	<tr>
      		<td colspan="2">
      			<s:url id="insert_action" value="/edit/ajax/insertBookmark.action"/>
				<sj:submit targets="success_message"
							href="%{insert_action}"
				           	value="Insert via Ajax" 
				           	button="true"
			            	dataType="json"                
			            	onSuccessTopics="bookmark_added"
			           	/>
      		</td>
      	</tr>
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