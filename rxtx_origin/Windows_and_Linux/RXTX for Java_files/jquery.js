(function($) {

	/**
	 * Serialize any JS object into JSON.
	 */
	$.fn.serializeObject = function() {
		var o = {};
		var a = this.serializeArray();
		$.each(a, function() {
			if (o[this.name] !== undefined) {
				if (!o[this.name].push) {
					o[this.name] = [ o[this.name] ];
				}
				o[this.name].push(this.value || '');
			} else {
				o[this.name] = this.value || '';
			}
		});
		return o;
	};

	$.fn.ajaxForm = function(options) {
	    options = $.extend({
	        //message: 'Hello world',
	        //css: {
	        //    color: 'red'
	        //}
	    }, options);
	    
	    return this.each(function() {
	    	var container = $(this);
	    	
	    	// override submit function for the child form
	    	$(this).find("form").submit(function(event) {
		    	// prevent submit from actually being sent to server normally
		    	event.preventDefault();
	    	
		    	var form = $(this);
	    	
		    	// reset form as if no errors ever occurred
		    	$(form).find("div.control-group").removeClass("error");
		    	$(form).find("div.control-group span.help-inline").text("");
		    	$(container).find(".ajaxform-error-container").hide();
		    	$(container).find(".ajaxform-success-container").hide();
		    	
		    	// let user know form is being processed/submitted
		    	var submitButton = $(form).find("button[type=submit]");
		    	var submitHtml = submitButton.html();
		    	submitButton.prop('disabled', true);
	    	
		    	// delay adding the "spinner" to the submit button if the form is processed quickly
		    	var submitSpinnerTimeoutId = window.setTimeout(function() {
		    		console.log("delay reached - adding spinner to submit button");
		    		submitButton.html("<i class=\"icon-spinner icon-spin\"></i> " + submitHtml);
		    	}, 400);
		    	
			    var formObj = $(form).serializeObject();
			    var formAsJson = JSON.stringify(formObj);
			    
			    $.ajax({
			    	url: $(form).attr("action"),
					type: "POST",
					data: formAsJson,
					dataType: "json",
					contentType: "application/json"
			    }).always(function(data) {
			    	// cancel the spinner timeout
			    	console.log("clearing spinner timeout");
			    	window.clearTimeout(submitSpinnerTimeoutId);
			    }).done(function(data) {
		    		var errorCount = 0;
		    		
		    		// failed form submit (something went wrong)
		    		if (data != null) {
						// some sort of error occurred
						$.each(data, function(key, value) {
							if (key != "") {
								// field error
								var item = $(form).find("#" + key);
								//alert("adding error class to " + item);
								$(item).closest(".control-group").addClass("error");
								$(item).siblings("span.help-inline").text(value);
								errorCount++;
							} else {
								// global error
								errorCount++;
								$(container).find(".ajaxform-error-container .ajaxform-error-message").text(value);
								$(container).find(".ajaxform-error-container").show();
							}
						});
		    		}
			    	
		    		// successful form submit
		    		if (errorCount <= 0) {
		    			$(form).hide();
		    			$(container).find(".ajaxform-success-container").fadeIn('slow', function() {});
			    	}
			    }).fail(function(result) {
			    	// something unexpected happened on submit (maybe server went away; internet down, etc.)
			    	$(container).find(".ajaxform-error-container .ajaxform-error-message").text("Unexpected failure while processing submit (try again later)");
					$(container).find(".ajaxform-error-container").show();
			    }).always(function(data) {
			    	// always restore submit button back to original value
			    	submitButton.html(submitHtml).prop('disabled', false);
				});
	    	});
	    });
	};

})(jQuery);