$(document).ready(function(){

	var protocol = window.location.protocol
	var hostname = window.location.hostname
	var port = window.location.port
	var url_base = protocol + '//' + hostname + ':' + port + '/jkbecarios'
	
	
	$(function($) {
		$.datepicker.regional['es'] = {
			closeText : 'Cerrar',
			prevText : '&#x3c;Ant',
			nextText : 'Sig&#x3e;',
			currentText : 'Hoy',
			monthNames : ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
			monthNamesShort : ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun', 'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'],
			dayNames : ['Domingo', 'Lunes', 'Martes', 'Miercoles', 'Jueves', 'Viernes', 'Sabado'],
			dayNamesShort : ['Dom', 'Lun', 'Mar', 'Mie;', 'Juv', 'Vie', 'Sab'],
			dayNamesMin : ['Do', 'Lu', 'Ma', 'Mi', 'Ju', 'Vi', 'Sa'],
			weekHeader : 'Sm',
			dateFormat : 'dd/mm/yy',
			firstDay : 1,
			isRTL : false,
			showMonthAfterYear : false,
			yearSuffix : ''
		};
		$.datepicker.setDefaults($.datepicker.regional['es']);
	}); 
	
	$(".datepicker").datepicker({
      	dateFormat: "dd/mm/yy",
	});

	
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