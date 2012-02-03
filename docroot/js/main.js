
$(document).ready( function() {  
	$.subscribe('handleJsonResult', function(event, data) { 
		var errorMessages = event.originalEvent.data.validateErrors;
		
		if(errorMessages.length > 0) {
			$('#add_button').attr("disabled", true); 
			
			$('#validationErrors').addClass('errors');
			$('#validationErrors').html("<ul id='jsonMessage'></ul>");  
			var list = $('#jsonMessage');
			$.each(errorMessages, function(index, value) {                         
				list.append('<li>'+value+'</li>\n');    
//				console.log("value " + value); 
			});  
		}
		else {
			$('#validationErrors').removeClass('errors');
			$('#validationErrors').html(""); 
			
			$('#add_button').attr("disabled", false); 
		}
		
		return false;
	});
});    

$(document).ready( function() {  
	$.subscribe('bookmark_added', function(event, data) { 
		var errorMessages = event.originalEvent.data.validateErrors;
		
		if(errorMessages.length > 0) {
			$('#success_message').addClass('errors');
			$('#success_message').html("<ul id='jsonMessage'></ul>");  
			var list = $('#jsonMessage');
			$.each(errorMessages, function(index, value) {                         
				list.append('<li>'+value+'</li>\n');    
			});  
		}
		else {
			$('#success_message').addClass('message');
			$('#success_message').html("Bookmark Added Successfully"); 
		}
		
		return false;
	});
});    

$(document).ready( function() {  
	$.subscribe('edit_bookmark', function(event, data) { 
		
		editBookmark(data.old_name);
		
		return false;
	});
});   