	//RESET FORMULARIO
	function resetForm(form){
		
		$('#frm'+form)[0].reset();
	}
	//***************
	
	
	
	function mostrarLimaProv(tipo,valor){
		
		if (tipo=="sufragio" && valor==0){
			$('#limaprovinciaSufragio').show();
			$('#extranjero').hide();
			
			}else{
			$('#limaprovinciaSufragio').hide();
			$('#extranjero').show();
		}
		if (tipo=="reserva" && valor==0){
			$('#limaprovinciaReserva').show();
			$('#extranjero').show();
			}else{
			$('#limaprovinciaReserva').hide();
		}
		
	}
	<!-- ************************************************************************************************************** -->
	<!-- Jquery para edicion DE OBJETOS DATATABLE -->
	<!-- ************************************************************************************************************** -->
	
	function btnAdd(dato,ventana,titulo){
		$(ventana).modal('show');
		$('#titulo_'+titulo).html('<strong>'+dato+'</strong>');
		$('#frm'+titulo)[0].reset();
		$("#ctrl"+titulo).val("A");
	}
	
	
	$(function () {
		function downloadLink(id) {
	    	var ajaxOptions = {
	    		url: 'http://erpge.getsandbox.com/dis/api/cargainfo/xls'
	        };
	        
	        var res = $.ajax(ajaxOptions);
	        
	        function onAjaxDone(data) {
	          
	        		location.href = 'http://erpge.getsandbox.com/dis/api/cargainfo/xls';
	        }
	        
	        function onAjaxFail() {
	        	alert('Error al Descargar');
	        }
	        
	        res
	        	.done(onAjaxDone)
	            .fail(onAjaxFail)
	        ;
	    }
	    
		function onDownloadLinkClick(e) {
	    	e.preventDefault();
	        var $this = $(this);
	        var id = $this.data('id');
	        downloadLink(id);
	    }
	    
		$('.download-link').on('click', onDownloadLinkClick);
	});
	
	<!-- ************************************************************************************************************** -->
	<!-- Jquery para carga DE OBJETOS DATATABLE -->
	<!-- ************************************************************************************************************** -->
	
	//LISTAR DATATABLE DE CARGA DE INFORMACION
	function listarParametro(){ 
		$.ajax({
			type : "GET",
			url : "http://erpge.getsandbox.com/dis/api/cargainfo/",
			success: function(result){
				var count = 1;
				$.each(result.cargainfo, function(i, cargainfo){
					if(cargainfo.activo == 1){
						var estado = 'ACTIVO';
					}else{
						var estado = 'INACTIVO';
					}
	
					var customerRow = '<tr>' +
							'<td>' + (count++) + '</td>' +
							'<td>' + cargainfo.tipoParametro + '</td>' +
							'<td>' + cargainfo.nomParametro + '</td>' +
							'<td>' + cargainfo.valorParametro + '</td>' +
							'<td>' + estado + '</td>' +
							'<td>  <a data-toggle="modal" href="#modal_parametro" onclick="viewParametro('+ cargainfo.idParametro + ' )" class="btn btn-info btn-xs"><span class="glyphicon glyphicon-pencil" aria-hidden="true" data-toggle="tooltip" title="Editar"></span></a>'+
									'<a href="javascript: deleteParametro('+ cargainfo.idParametro + ')" class="btn btn-danger btn-xs" onclick="" style="margin-left:10px"><span class="glyphicon glyphicon-trash" aria-hidden="true" data-toggle="tooltip" title="Eliminar"></span></a></td>' +
							'</tr>';
						
					$('#tbl_parametro tbody').append(customerRow);
			    });
					$('#tbl_parametro').dataTable();
				},
				
			error : function(e){

					alert("ERROR: ", e);

					console.log("ERROR: ", e);
			}
		});
	}
	<!-- ************************************************************************************************************** -->
	<!-- FIN Jquery listados-->
	<!-- ************************************************************************************************************** -->
	
	<!-- ************************************************************************************************************** -->
	<!-- PANTALLA CARGA DE INFO -->
	<!-- ************************************************************************************************************** -->
	
	function VerificarCarga(id){
		var requestVerificarCarga = new Object();
		requestVerificarCarga["idCarga"] = id;
	
			$.ajax({
			    url: "http://erpge.getsandbox.com/gme/api/cargacapacitacion/verifica",
			    type: "POST",
			    dataType: 'json',
			    data: JSON.stringify(requestEtapaControl),
			    contentType : "application/json",
			    success: function(data) {
					console.log("Success = " + JSON.stringify(data) );
					$('#tbl_etapacontrol tbody').empty();
					listarEtapaControl();
			    },
			    error: function() { 
			    		//alert('Failed!'); 
			    	}
			});
		
	 }
	
	function ReprocesarCarga(id){
		var requestVerificarCarga = new Object();
		requestVerificarCarga["idCarga"] = id;
	
			$.ajax({
			    url: "http://erpge.getsandbox.com/gme/api/etapacontrol/reprocesa",
			    type: "POST",
			    dataType: 'json',
			    data: JSON.stringify(requestEtapaControl),
			    contentType : "application/json",
			    success: function(data) {
					console.log("Success = " + JSON.stringify(data) );
					$('#tbl_etapacontrol tbody').empty();
					listarEtapaControl();
			    },
			    error: function() { 
			    		//alert('Failed!'); 
			    	}
			});
		
	 }
	
	
	function cargaCapacitacion(id){
		var requestVerificarCarga = new Object();
		requestVerificarCarga["idCarga"] = id;
	
			$.ajax({
			    url: "http://erpge.getsandbox.com/gme/api/etapacontrol/add",
			    type: "POST",
			    dataType: 'json',
			    data: JSON.stringify(requestEtapaControl),
			    contentType : "application/json",
			    success: function(data) {
					console.log("Success = " + JSON.stringify(data) );
					$('#tbl_etapacontrol tbody').empty();
					listarEtapaControl();
			    },
			    error: function() { 
			    		//alert('Failed!'); 
			    	}
			});
		
	 }