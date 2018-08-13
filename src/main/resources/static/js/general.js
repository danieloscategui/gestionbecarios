$(document).ready(function(){

	var protocol = window.location.protocol
	var hostname = window.location.hostname
	var port = window.location.port
	var url_base = protocol + '//' + hostname + ':' + port + '/jkbecarios'
	
	
	$('.only-number').on("keypress keyup blur", function(event){
		$(this).val($(this).val().replace(/[^\d].+/, ""));
	    if ((event.which < 48 || event.which > 57)) {
	        event.preventDefault();
	    }
	});
	
	 $(".only-number-decimal").on("keypress keyup blur",function (event) {
		 $(this).val($(this).val().replace(/[^0-9\.]/g,''));
         if ((event.which != 46 || $(this).val().indexOf('.') != -1) && (event.which < 48 || event.which > 57)) {
             event.preventDefault();
         }
     });
	
	
	$(function(){
		var dni;
		var url_get;
		
		$('#dniBecario').keypress(function(event){
			if(event.which == 13){ // Key Enter
				dni = $(this).val();
				url_get = url_base + '/becario/' + dni + '/buscar';
				window.location = url_get;
				$(this).text = '';
				return true;
			}
		});
	});
	
});