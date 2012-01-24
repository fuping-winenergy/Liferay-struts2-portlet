
$(document).ready( function() {  
	$.subscribe('handleJsonResult', function(event, data) { 
		var errorMessages = event.originalEvent.data.validateErrors;
		
		if(errorMessages.length > 0) {
			$('#validationErrors').addClass('errors', 1000);
			$('#validationErrors').html("<ul id='jsonMessage'></ul>");  
			var list = $('#jsonMessage');
			$.each(errorMessages, function(index, value) {                         
				list.append('<li>'+value+'</li>\n');    
				console.log("value " + value); 
			});  
		}
		else {
			$('#validationErrors').removeClass('errors', 1000);
			$('#validationErrors').html(""); 
		}
		
		return false;
	});
});    
     