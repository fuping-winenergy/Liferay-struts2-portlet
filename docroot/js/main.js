
$(document).ready( function() {  
	$.subscribe('handleJsonResult', function(event, data) { 
		var errorMessages = event.originalEvent.data.validateErrors;
		
		if(errorMessages.length > 0) {
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