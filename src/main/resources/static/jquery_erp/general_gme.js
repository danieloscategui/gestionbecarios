	//RESET FORMULARIO
	function resetForm(form){
		$('#frm'+form)[0].reset();
	}
	//***************
	
	<!-- ************************************************************************************************************** -->
	<!-- Jquery para edicion DE OBJETOS DATATABLE -->
	<!-- ************************************************************************************************************** -->
	
	function btnAdd(dato,ventana,titulo){
		$(ventana).modal('show');
		$('#titulo_'+titulo).html('<strong>'+dato+'</strong>');
		$('#frm'+titulo)[0].reset();
		$("#ctrl"+titulo).val("A");
		$('#usuariofecha').hide();
		$('#estado').hide();
		
		
	}
	
	<!-- ************************************************************************************************************** -->
	<!-- Jquery para carga DE OBJETOS DATATABLE -->
	<!-- ************************************************************************************************************** -->
	//LISTAR DATATABLE DE PARAMETROS
	function listarParametro(){ 
		$.ajax({
			type : "GET",
			url : "http://erpge.getsandbox.com/api/parametro",
			success: function(result){
				var count = 1;
				$.each(result.parametro, function(i, parametro){
					if(parametro.activo == 1){
						var estado = 'ACTIVO';
					}else{
						var estado = 'INACTIVO';
					}
	
					var customerRow = '<tr>' +
							'<td>' + (count++) + '</td>' +
							'<td>' + parametro.tipoParametro + '</td>' +
							'<td>' + parametro.nomParametro + '</td>' +
							'<td>' + parametro.valorParametro + '</td>' +
							'<td>' + estado + '</td>' +
							'<td>  <a data-toggle="modal" href="#modal_parametro" onclick="viewParametro('+ parametro.idParametro + ' )" class="btn btn-info btn-xs"><span class="glyphicon glyphicon-pencil" aria-hidden="true" data-toggle="tooltip" title="Editar"></span></a>'+
									'<a href="javascript: deleteParametro('+ parametro.idParametro + ')" class="btn btn-danger btn-xs" onclick="" style="margin-left:10px"><span class="glyphicon glyphicon-trash" aria-hidden="true" data-toggle="tooltip" title="Eliminar"></span></a></td>' +
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
	//LISTAR DATATABLE DE TIPO DE PARAMETROS
	function listarTipoParametro(){ 
		$.ajax({
			type : "GET",
			url : "http://erpge.getsandbox.com/api/tipoparametro",
			success: function(result){
				var count = 1;
				$.each(result.tipoparametro, function(i, tipoparametro){
					if(tipoparametro.activo == 1){
						var estado = 'ACTIVO';
					}else{
						var estado = 'INACTIVO';
					}
						
					var customerRow = '<tr>' +
							'<td>' + (count++) + '</td>' +
							'<td>' + tipoparametro.tipoParametro + '</td>' +
							'<td>' + tipoparametro.descripcionTipoParam + '</td>' +
							'<td>' + estado + '</td>' +
							'<td>  <a data-toggle="modal" href="#modal_tipoparametro" onclick="viewTipoParametro('+"'"+tipoparametro.tipoParametro+"'"+')" class="btn btn-info btn-xs"><span class="glyphicon glyphicon-pencil" aria-hidden="true" data-toggle="tooltip" title="Editar"></span></a>'+
									'<a href="javascript: deleteParametro('+"'"+tipoparametro.tipoParametro+"'"+')" class="btn btn-danger btn-xs" onclick="" style="margin-left:10px"><span class="glyphicon glyphicon-trash" aria-hidden="true" data-toggle="tooltip" title="Eliminar"></span></a></td>' +
							'</tr>';
						
					$('#tbl_tipoparametro tbody').append(customerRow);
			    });
					$('#tbl_tipoparametro').dataTable();
				},
				
			error : function(e){

					alert("ERROR: ", e);
					console.log("ERROR: ", e);
			}
		});
	}
	
	//LISTAR DATATABLE PROCESO ELECTORAL
	function listarProcesoElectoral(){ 
		$.ajax({
			type : "GET",
			url : "http://erpge.getsandbox.com/api/procesoelectoral",
			success: function(result){
				var count = 1;
				$.each(result.procesoelectoral, function(i, procesoelectoral){
					if(procesoelectoral.activo == 1){
						var estado = 'ACTIVO';
					}else{
						var estado = 'INACTIVO';
					}
						
					var customerRow = '<tr>' +
							'<td>' + (count++) + '</td>' +
							'<td>' + procesoelectoral.nombreProceso + '</td>' +
							'<td>' + procesoelectoral.descripcionProceso + '</td>' +
							'<td>' + procesoelectoral.fasesProceso + '</td>' +
							'<td>' + procesoelectoral.inicioProceso + '</td>' +
							'<td>' + procesoelectoral.finProceso + '</td>' +
							'<td>' + estado + '</td>' +
							'<td>  <a data-toggle="modal" href="#modal_proceso" onclick="viewProcesoElectoral('+ procesoelectoral.idProceso +')" class="btn btn-info btn-xs"><span class="glyphicon glyphicon-pencil" aria-hidden="true" data-toggle="tooltip" title="Editar"></span></a>'+
									'<a href="javascript: deleteProceso('+ procesoelectoral.idProceso + ')" class="btn btn-danger btn-xs" onclick="" style="margin-left:10px"><span class="glyphicon glyphicon-trash" aria-hidden="true" data-toggle="tooltip" title="Eliminar"></span></a></td>' +
							'</tr>';
						
					$('#tbl_proceso tbody').append(customerRow);
			    });
					$('#tbl_proceso').dataTable();
				},
				
			error : function(e){

					alert("ERROR: ", e);
					console.log("ERROR: ", e);
			}
		});
	}
	
	//LISTAR FASES
	function listarFase(){ 
		$.ajax({
			type : "GET",
			url : "http://erpge.getsandbox.com/api/fase",
			success: function(result){
				
				var count = 1;
				$.each(result.fase, function(i, fase){
					if(fase.activo == 1){
						var estado = 'ACTIVO';
					}else{
						var estado = 'INACTIVO';
					}
						
					var customerRow = '<tr>' +
							'<td>' + (count++) + '</td>' +
							'<td>' + fase.nombreFase + '</td>' +
							'<td>' + estado + '</td>' +
							'<td>  <a data-toggle="modal" href="#modal_fase" onclick="viewFase('+ fase.idFase +')" class="btn btn-info btn-xs"><span class="glyphicon glyphicon-pencil" aria-hidden="true" data-toggle="tooltip" title="Editar"></span></a>'+
									'<a href="javascript: deleteFase('+ fase.idFase + ')" class="btn btn-danger btn-xs" onclick="" style="margin-left:10px"><span class="glyphicon glyphicon-trash" aria-hidden="true" data-toggle="tooltip" title="Eliminar"></span></a></td>' +
							'</tr>';
						
					$('#tbl_fase tbody').append(customerRow);
			    });
					$('#tbl_fase').dataTable();
				},
				
			error : function(e){

					alert("ERROR fase: ", e);
					console.log("ERROR: ", e);
			}
		});
	}
	
	//LISTAR DATATABLE DE RESPONSABLE POR CONSUMO
	function listarResponsable(){ 
		$.ajax({
			type : "GET",
			url : "http://erpge.getsandbox.com/api/centroresponsable",
			success: function(result){
				var count = 1;
				$.each(result.centroresponsable, function(i, centroresponsable){
					
					var customerRow = '<tr>' +
							'<td>' + (count++) + '</td>' +
							'<td>' + centroresponsable.idProceso + '</td>' +
							'<td>' + centroresponsable.idCentroConsumo + '</td>' +
							'<td>' + centroresponsable.idPersonal + '</td>' +
							'<td>' + centroresponsable.idCargo + '</td>' +
							'<td>  <a data-toggle="modal" href="#modal_responsable" onclick="viewResponsable('+ centroresponsable.idCentroResponsable + ' )" class="btn btn-info btn-xs"><span class="glyphicon glyphicon-pencil" aria-hidden="true" data-toggle="tooltip" title="Editar"></span></a>'+
									'<a href="javascript: deleteResponsable('+ centroresponsable.idCentroResponsable + ')" class="btn btn-danger btn-xs" onclick="" style="margin-left:10px"><span class="glyphicon glyphicon-trash" aria-hidden="true" data-toggle="tooltip" title="Eliminar"></span></a></td>' +
							'</tr>';
						
					$('#tbl_responsable tbody').append(customerRow);
			    });
					$('#tbl_responsable').dataTable();
				},
				
			error : function(e){

					alert("ERROR: respo ", e);

					console.log("ERROR: ", e);
			}
		});
	}
	
	//*************************************************************************************************************************************
	<!-- ************************************************************************************************************** -->
	<!-- JQUERY INSERT Y UPDATE  -->
	<!-- ************************************************************************************************************** -->
	
	function addParametro(){
		if($("#ctrlParametro").val() == 'A'){
			//$('#msj_material').html('AGREGAR');
			var requestParametro = new Object();
			requestParametro["idParametro"] = $("#idParam").val();
			requestParametro["tipoParametro"] = $("#tipoParam").val();
			requestParametro["nomParametro"] = $("#nombreParam").val();
			requestParametro["valorParametro"] = $("#valorParam").val();
			requestParametro["activo"] = "1";
			
			
			var total = $("#idParam").val().length * $("#tipoParam").val().length * $("#nombreParam").val().length * $("#valorParam").val().length;
			
			if(total > 0){
				$.ajax({
				    url: "http://erpge.getsandbox.com/api/parametro/add",
				    type: "POST",
				    dataType: 'json',
				    data: JSON.stringify(requestParametro),
				    contentType : "application/json",
				    success: function(data) {
						console.log("Success = " + JSON.stringify(data) );
						$('#tbl_parametro tbody').empty();
						listarParametro();
						$('#frmParametro')[0].reset();
				    },
				    error: function() { 
				    		//alert('Failed!'); 
				    }
				});
			}else{
				
				$("#idParam").val().length * $("#tipoParam").val().length * $("#nombreParam").val().length * $("#valorParam").val().length;
			}
			
		}else{
			//$('#msj_material').html('EDITAR');
			var requestParametro = new Object();
			requestParametro["idParametro"] = $("#idParam").val();
			requestParametro["tipoParametro"] = $("#tipoParam").val();
			requestParametro["nomParametro"] = $("#nombreParam").val();
			requestParametro["valorParametro"] = $("#valorParam").val();
			requestParametro["activo"] = $("#estadoParam").val();
				
			if($("#estadoParam").is(":checked")){
				requestParametro["activo"] = '1';
            }else{
            	requestParametro["activo"] = '0';
            }
			
			var total = $("#idParam").val().length * $("#tipoParam").val().length * $("#nombreParam").val().length * $("#valorParam").val().length;
			
			if(total > 0){
				$.ajax({
				    url: "http://erpge.getsandbox.com/api/parametro/upd",
				    type: "POST",
				    dataType: 'json',
				    data: JSON.stringify(requestParametro),
				    contentType : "application/json",
				    success: function(data) {
						console.log("Success = " + JSON.stringify(data) );
						$('#tbl_parametro tbody').empty();
						listarParametro();
						$('#frmParametro')[0].reset();
				    },
				    error: function() { 
				    		//alert('Failed!'); 
				    	}
				});
			}else{
				$('#msj_parametro').addClass('alert alert-danger text-center').html('<strong>Error!</strong> <strong>Complete los Datos</strong>').show(10).delay(3500).hide(10);
			}
		}
	}
	
	//AGREGAR TIPO DE PARAMETRO 
	
	function addTipoParametro(){
		if($("#ctrlTipoParametro").val() == 'A'){
			var requestTipoParametro = new Object();
			requestTipoParametro["tipoParametro"] = $("#tipoParametro").val();
			requestTipoParametro["descripcionTipoParam"] = $("#descripcionTipoParam").val();
			requestTipoParametro["activo"] = "1";
			
			var total = $("#tipoParametro").val().length * $("#descripcionTipoParam").val().length;
			
			if(total > 0){
				$.ajax({
				    url: "http://erpge.getsandbox.com/api/tipoparametro/add",
				    type: "POST",
				    dataType: 'json',
				    data: JSON.stringify(requestTipoParametro),
				    contentType : "application/json",
				    success: function(data) {
						console.log("Success = " + JSON.stringify(data) );
						$('#tbl_tipoparametro tbody').empty();
						listarTipoParametro();
						$('#frmTipoParametro')[0].reset();
				    },
				    error: function() { 
				    		//alert('Failed!'); 
				    }
				});
			}else{
				$('#msj_tipoparametro').addClass('alert alert-danger text-center').html('<strong>Error!</strong> <strong>Complete los Datos</strong>').show(10).delay(3500).hide(10);
			}
			
		}else{
			//$('#msj_material').html('EDITAR');
			var requestTipoParametro = new Object();
			requestTipoParametro["tipoParametro"] = $("#tipoParametro").val();
			requestTipoParametro["descripcionTipoParam"] = $("#descripcionTipoParam").val();
			
			if($("#estadoTipoParam").is(":checked")){
				requestParametro["activo"] = '1';
            }else{
            	requestParametro["activo"] = '0';
            }
			
			var total = $("#tipoParametro").val().length * $("#descripcionTipoParam").val().length;
			
			if(total > 0){
				$.ajax({
				    url: "http://erpge.getsandbox.com/api/tipoparametro/upd",
				    type: "POST",
				    dataType: 'json',
				    data: JSON.stringify(requestTipoParametro),
				    contentType : "application/json",
				    success: function(data) {
						console.log("Success = " + JSON.stringify(data) );
						$('#tbl_tipoparametro tbody').empty();
						listarTipoParametro();
						$('#frmTipoParametro')[0].reset();
				    },
				    error: function() { 
				    		//alert('Failed!'); 
				    	}
				});
			}else{
				$('#msj_tipoparametro').addClass('alert alert-danger text-center').html('<strong>Error!</strong> <strong>Complete los Datos</strong>').show(10).delay(3500).hide(10);
			}
		}
	}
	
	//AGREGAR PROCESO ELECTORAL
	
	function addProcesoElectoral(){
		if($("#ctrlProceso").val() == 'A'){
			var requestProceso = new Object();
			requestProceso["nombreProceso"] = $("#nombreProceso").val();
			requestProceso["descripcionProceso"] = $("#descripcionProceso").val();
			requestProceso["fasesProceso"] = $("#fasesProceso").val();
			requestProceso["inicioProceso"] = $("#inicioProceso").val();
			requestProceso["finProceso"] = $("#finProceso").val();
			requestProceso["activo"] = "1";
			requestProceso["abiertoProceso"] = "1";
			
			
			var total = $("#nombreProceso").val().length * $("#descripcionProceso").val().length * $("#fasesProceso").val().length * $("#inicioProceso").val().length *  $("#finProceso").val().length;
			
			if(total > 0){
				$.ajax({
				    url: "http://erpge.getsandbox.com/api/procesoelectoral/add",
				    type: "POST",
				    dataType: 'json',
				    data: JSON.stringify(requestProceso),
				    contentType : "application/json",
				    success: function(data) {
						console.log("Success = " + JSON.stringify(data) );
						$('#tbl_proceso tbody').empty();
						listarTipoParametro();
						$('#frmProceso')[0].reset();
				    },
				    error: function() { 
				    		//alert('Failed!'); 
				    }
				});
			}else{
				$('#msj_proceso').addClass('alert alert-danger text-center').html('<strong>Error!</strong> <strong>Complete los Datos</strong>').show(10).delay(3500).hide(10);
			}
			
		}else{
			//$('#msj_material').html('EDITAR');
			var requestProceso = new Object();
			requestProceso["nombreProceso"] = $("#nombreProceso").val();
			requestProceso["descripcionProceso"] = $("#descripcionProceso").val();
			requestProceso["fasesProceso"] = $("#fasesProceso").val();
			requestProceso["inicioProceso"] = $("#inicioProceso").val();
			requestProceso["finProceso"] = $("#finProceso").val();
			if($("#estadoProceso").is(":checked")){
				requestParametro["activo"] = '1';
            }else{
            	requestParametro["activo"] = '0';
            }
			if($("#abiertoProceso").is(":abiertoProceso")){
				requestParametro["abiertoProceso"] = '1';
            }else{
            	requestParametro["abiertoProceso"] = '0';
            }
			
			
			var total = $("#nombreProceso").val().length * $("#descripcionProceso").val().length * $("#fasesProceso").val().length * $("#inicioProceso").val().length * $("#finProceso").val().length;
			
			if(total > 0){
				$.ajax({
				    url: "http://erpge.getsandbox.com/api/procesoelectoral/upd",
				    type: "POST",
				    dataType: 'json',
				    data: JSON.stringify(requestProceso),
				    contentType : "application/json",
				    success: function(data) {
						console.log("Success = " + JSON.stringify(data) );
						$('#tbl_proceso tbody').empty();
						listarTipoParametro();
						$('#frmProceso')[0].reset();
				    },
				    error: function() { 
				    		//alert('Failed!'); 
				    	}
				});
			}else{
				$('#msj_proceso').addClass('alert alert-danger text-center').html('<strong>Error!</strong> <strong>Complete los Datos</strong>').show(10).delay(3500).hide(10);
			}
		}
	}
	
	
//AGREGAR TIPO DE PARAMETRO 
	
	function addFase(){
		if($("#ctrlFase").val() == 'A'){
			var requestFase = new Object();
			requestFase["nombreFase"] = $("#nombreFase").val();
			requestFase["activo"] = "1";
			
			var total = $("#nombreFase").val().length;
			
			if(total > 0){
				$.ajax({
				    url: "http://erpge.getsandbox.com/api/fase/add",
				    type: "POST",
				    dataType: 'json',
				    data: JSON.stringify(requestFase),
				    contentType : "application/json",
				    success: function(data) {
						console.log("Success = " + JSON.stringify(data) );
						$('#tbl_fase tbody').empty();
						listarTipoParametro();
						$('#frmFase')[0].reset();
				    },
				    error: function() { 
				    		//alert('Failed!'); 
				    }
				});
			}else{
				$('#msj_fase').addClass('alert alert-danger text-center').html('<strong>Error!</strong> <strong>Complete los Datos</strong>').show(10).delay(3500).hide(10);
			}
			
		}else{
			//$('#').html('EDITAR');
			var requestFase = new Object();
			requestFase["nombreFase"] = $("#nombreFase").val();
						
			if($("#estadoFase").is(":checked")){
				requestFase["activo"] = '1';
            }else{
            	requestFase["activo"] = '0';
            }
			
			var total = $("#nombreFase").val().length;
			
			if(total > 0){
				$.ajax({
				    url: "http://erpge.getsandbox.com/api/fase/upd",
				    type: "POST",
				    dataType: 'json',
				    data: JSON.stringify(requestFase),
				    contentType : "application/json",
				    success: function(data) {
						console.log("Success = " + JSON.stringify(data) );
						$('#tbl_fase tbody').empty();
						listarTipoParametro();
						$('#frmFase')[0].reset();
				    },
				    error: function() { 
				    		//alert('Failed!'); 
				    	}
				});
			}else{
				$('#msj_fase').addClass('alert alert-danger text-center').html('<strong>Error!</strong> <strong>Complete los Datos</strong>').show(10).delay(3500).hide(10);
			}
		}
	}
	
	// TABLA CENTRO RESPONSABLE
	
	function addResponsable(){
		if($("#ctrlParametro").val() == 'A'){
			//$('#msj_material').html('AGREGAR');
			var requestResponsable = new Object();
			requestResponsable["idProceso"] = $("#idProceso").val();
			requestResponsable["idCentroConsumo"] = $("#idCentroConsumo").val();
			requestResponsable["idPersonal"] = $("#idPersonal").val();
			requestResponsable["idCargo"] = $("#idCargo").val();
					
			var total = $("#idProceso").val().length * $("#idCentroConsumo").val().length * $("#idPersonal").val().length * $("#idCargo").val().length;
			
			if(total > 0){
				$.ajax({
				    url: "http://erpge.getsandbox.com/api/centroresponsable/add",
				    type: "POST",
				    dataType: 'json',
				    data: JSON.stringify(requestResponsable),
				    contentType : "application/json",
				    success: function(data) {
						console.log("Success = " + JSON.stringify(data) );
						$('#tbl_responsable tbody').empty();
						listarResponsable();
						$('#frmResponsable')[0].reset();
				    },
				    error: function() { 
				    		//alert('Failed!'); 
				    }
				});
			}else{
				
				$("#idProceso").val().length * $("#idCentroConsumo").val().length * $("#idPersonal").val().length * $("#idCargo").val().length;
			}
			
		}else{
			//$('#msj_material').html('EDITAR');
			var requestResponsable = new Object();
			requestResponsable["idProceso"] = $("#idProceso").val();
			requestResponsable["idCentroConsumo"] = $("#idCentroConsumo").val();
			requestResponsable["idPersonal"] = $("#idPersonal").val();
			requestResponsable["idCargo"] = $("#idCargo").val();
				
			var total = $("#idProceso").val().length * $("#idCentroConsumo").val().length * $("#idPersonal").val().length * $("#idCargo").val().length;
			
			if(total > 0){
				$.ajax({
				    url: "http://erpge.getsandbox.com/api/centroresponsable/upd",
				    type: "POST",
				    dataType: 'json',
				    data: JSON.stringify(requestResponsable),
				    contentType : "application/json",
				    success: function(data) {
						console.log("Success = " + JSON.stringify(data) );
						$('#tbl_responsable tbody').empty();
						listarParametro();
						$('#frmResponsable')[0].reset();
				    },
				    error: function() { 
				    		//alert('Failed!'); 
				    	}
				});
			}else{
				$('#msj_responsable').addClass('alert alert-danger text-center').html('<strong>Error!</strong> <strong>Complete los Datos</strong>').show(10).delay(3500).hide(10);
			}
		}
	}
	
	//*************************************************************************************************************************************
	<!-- ************************************************************************************************************** -->
	<!-- JQUERY VIEW UPDATE  -->
	<!-- ************************************************************************************************************** -->
	
	// TABLA PARAMETROS GENERAL
	
	function viewParametro(id){
		$('#idParametro').val(id);
		$('#ctrlParametro').val('E');
		$('#titulo_Parametro').html('<strong>EDITAR PARAMETRO</strong>');
		$('#usuariofecha').show();
		$('#estado').show();
		
		var requestParametro = new Object();
		requestParametro["idParametro"] = id;
		
		$.ajax({
			
		    url: "http://erpge.getsandbox.com/api/parametro/view",
		    type: "POST",
		    dataType: 'json',
		    data: JSON.stringify(requestParametro),
		    contentType : "application/json",
		    success: function(data) {
				console.log("Success = " + JSON.stringify(data) );
				$.each(data.parametro, function(i, parametro){
					$('#codigoParam').val(parametro.codParametro);
					$('#TipoParametro').val(parametro.tipoParametro);
					$('#nombreParam').val(parametro.nomParametro);
					$('#valorParam').val(parametro.valorParametro);
					$('#usuarioMod').val(parametro.usuarioModificacion);
					$('#fechaMod').innerHTML(parametro.fechaModificacion);
					
					if (parametro.activo == 1){
                        $('#estadoParam').attr('checked',true);
                    }else{
                        $('#estadoParam').attr('checked',false);
                    }
		        });
		    },
		    error: function() { 
		    		//alert('Failed!'); 
		    	}
		});
	}
	
	// TABLA TIPO DE PARAMETROS GENERAL	
	function viewTipoParametro(id){
		$('#idTipoParametro').val(id);
		$('#ctrlTipoParametro').val('E');
		$('#titulo_TipoParametro').html('<strong>EDITAR PARAMETRO</strong>');
		$('#usuariofecha').show();
		$('#estado').show();
		
		var requestTipoParametro = new Object();
		requestTipoParametro["idTipoParametro"] = id;
		
		$.ajax({
		    url: "http://erpge.getsandbox.com/api/tipoparametro/view",
		    type: "POST",
		    dataType: 'json',
		    data: JSON.stringify(requestTipoParametro),
		    contentType : "application/json",
		    success: function(data) {
				console.log("Success = " + JSON.stringify(data) );
				$.each(data.tipoparametro, function(i, tipoparametro){
					$('#tipoParametro').val(tipoparametro.tipoParametro);
					$('#descripcionTipoParam').val(tipoparametro.descripcionTipoParam);
					$('#usuarioMod').val(tipoparametro.usuarioModificacion);
					$('#fechaMod').innerHTML(tipoparametro.fechaModificacion);
					
					if (tipoparametro.activo == 1){
                        $('#estadoTipParam').attr('checked',true);
                    }else{
                        $('#estadoTipParam').attr('checked',false);
                    }
		        });
		    },
		    error: function() { 
		    		//alert('Failed!'); 
		    	}
		});
	}
	
	
	// TABLA TIPO PROCESO ELECTORAL
	function viewProcesoElectoral(id){
		$('#idProceso').val(id);
		$('#ctrlProceso').val('E');
		$('#titulo_Parametro').html('<strong>EDITAR PROCESO ELECTORAL</strong>');
		$('#usuariofecha').show();
		$('#estado').show();
		
		var requestProceso = new Object();
		requestProceso["idProceso"] = id;
		
		$.ajax({
		    url: "http://erpge.getsandbox.com/api/procesoelectoral/view",
		    type: "POST",
		    dataType: 'json',
		    data: JSON.stringify(requestProceso),
		    contentType : "application/json",
		    success: function(data) {
				console.log("Success = " + JSON.stringify(data) );
				$.each(data.procesoelectoral, function(i, procesoelectoral){
					$('#nombreProceso').val(procesoelectoral.nombreProceso);
					$('#descripcionProceso').val(procesoelectoral.descripcionProceso);
					$('#fasesProceso').val(procesoelectoral.fasesProceso);
					$('#inicioProceso').innerHTML(procesoelectoral.inicioProceso);
					$('#finProceso').innerHTML(procesoelectoral.finProceso);
					$('#abiertoProceso').val(procesoelectoral.abiertoProceso);
					$('#estadoProceso').val(procesoelectoral.activo);
					$('#usuarioMod').val(procesoelectoral.usuarioModificacion);
					$('#fechaMod').innerHTML(procesoelectoral.fechaModificacion);
					
					if (procesoelectoral.abiertoProceso == 1){
                        $('#abiertoProceso').attr('checked',true);
                    }else{
                        $('#abiertoProceso').attr('checked',false);
                    }
					
					if (procesoelectoral.activo == 1){
                        $('#estadoProceso').attr('checked',true);
                    }else{
                        $('#estadoProceso').attr('checked',false);
                    }
		        });
		    },
		    error: function() { 
		    		//alert('Failed!'); 
		    	}
		});
	}
	
	
	// TABLA FASES
	function viewFase(id){
		$('#idFase').val(id);
		$('#ctrlFase').val('E');
		$('#titulo_Fase').html('<strong>EDITAR FASE</strong>');
		$('#usuariofecha').show();
		$('#estadoFase').show();
		
		var requestFase = new Object();
		requestFase["idFase"] = id;
		
		$.ajax({
		    url: "http://erpge.getsandbox.com/api/fase/view",
		    type: "POST",
		    dataType: 'json',
		    data: JSON.stringify(requestFase),
		    contentType : "application/json",
		    success: function(data) {
				console.log("Success = " + JSON.stringify(data) );
				$.each(data.fase, function(i, fase){
					$('#nombreFase').val(fase.nombreFase);
					$('#usuarioMod').val(fase.usuarioModificacion);
					$('#fechaMod').innerHTML(fase.fechaModificacion);

					if (fase.activo == 1){
                        $('#estadoFase').attr('checked',true);
                    }else{
                        $('#estadoFase').attr('checked',false);
                    }
		        });
		    },
		    error: function() { 
		    		//alert('Failed!'); 
		    	}
		});
	}
	
	
	
// TABLA COENTRO DE CONSUMO RESPONSABLE
	
	function viewParametro(id){
		$('#idResponsable').val(id);
		$('#ctrlResponsable').val('E');
		$('#titulo_Responsable').html('<strong>EDITAR RESPONSABLE DE CENTRO DE C.</strong>');
		$('#usuariofecha').show();
		
		var requestResponsable = new Object();
		requestResponsable["idCentroResponsable"] = id;
		
		$.ajax({
			
		    url: "http://erpge.getsandbox.com/api/centroresponsable/view",
		    type: "POST",
		    dataType: 'json',
		    data: JSON.stringify(requestResponsable),
		    contentType : "application/json",
		    success: function(data) {
				console.log("Success = " + JSON.stringify(data) );
				$.each(data.centroresponsable, function(i, centroresponsable){
					$('#idProceso').val(centroresponsable.idProceso);
					$('#idCentroConsumo').val(centroresponsable.idCentroConsumo);
					$('#idPersonal').val(centroresponsable.idPersonal);
					$('#idCargo').val(centroresponsable.idCargo);
					$('#usuarioMod').val(centroresponsable.usuarioModificacion);
					$('#fechaMod').innerHTML(centroresponsable.fechaModificacion);
		        });
		    },
		    error: function() { 
		    		//alert('Failed!'); 
		    	}
		});
	}
	<!-- ************************************************************************************************************** -->
	<!-- JQUERY DELETE  -->
	<!-- ************************************************************************************************************** -->
	
	function deleteParametro(id){
		var requestParametro = new Object();
		requestParametro["codParametro"] = id;
		
			$.ajax({
			    url: "http://erpge.getsandbox.com/api/parametro/del",
			    type: "POST",
			    dataType: 'json',
			    data: JSON.stringify(requestParametro),
			    contentType : "application/json",
			    success: function(data) {
					console.log("Success = " + JSON.stringify(data) );
					$('#tbl_parametro tbody').empty();
					listarParametro();
			    },
			    error: function() { 
			    		//alert('Failed!'); 
			    	}
			});
		
	 }
	
	//TABLA TIPO PROCESO ELECTORAL
	function deleteProceso(id){
		var requestProceso = new Object();
		requestProceso["codParametro"] = id;
		
			$.ajax({
			    url: "http://erpge.getsandbox.com/api/procesoelectotal/del",
			    type: "POST",
			    dataType: 'json',
			    data: JSON.stringify(requestProceso),
			    contentType : "application/json",
			    success: function(data) {
					console.log("Success = " + JSON.stringify(data) );
					$('#tbl_proceso tbody').empty();
					listarProcesoElectoral();
			    },
			    error: function() { 
			    		//alert('Failed!'); 
			    	}
			});
		
	 }
	
	//TABLA TIPO PROCESO ELECTORAL
	function deleteFase(id){
		var requestFase = new Object();
		requestFase["idFase"] = id;
		
			$.ajax({
			    url: "http://erpge.getsandbox.com/api/fase/del",
			    type: "POST",
			    dataType: 'json',
			    data: JSON.stringify(requestFase),
			    contentType : "application/json",
			    success: function(data) {
					console.log("Success = " + JSON.stringify(data) );
					$('#tbl_fase tbody').empty();
					listarFase();
			    },
			    error: function() { 
			    		//alert('Failed!'); 
			    	}
			});
		
	 }
	
	//TABLA TIPO PROCESO ELECTORAL
	function deleteResponsable(id){
		var requestResponsable = new Object();
		requestResponsable["idCentroResponsable"] = id;
		
			$.ajax({
			    url: "http://erpge.getsandbox.com/api/centroresponsable/del",
			    type: "POST",
			    dataType: 'json',
			    data: JSON.stringify(requestResponsable),
			    contentType : "application/json",
			    success: function(data) {
					console.log("Success = " + JSON.stringify(data) );
					$('#tbl_responsable tbody').empty();
					listarResponsable();
			    },
			    error: function() { 
			    		//alert('Failed!'); 
			    	}
			});
		
	 }
	
	<!-- ************************************************************************************************************** -->
	<!-- JQUERY PARA OBJETOS SELECT -->
	<!-- ************************************************************************************************************** -->	
	
	//COMBO TIPO DE PARAMETROS.
	function cboTipoParametro(){
		$.ajax({
			type: "GET",
		    url: 'http://erpge.getsandbox.com/api/tipoparametro', 
		    success: function(result){
		      $.each(result.tipoparametro,function(i, tipoparametro) {
		        $('#tipoParam').append('<option value='+ tipoparametro.tipoParametro +'>'+ tipoparametro.descripcionTipoParam +'</option>');
		        
		      });        
		    },
		    error: function(data) {
		    	alert("ERROR: ", e);
				console.log("ERROR: ", e);
		    }
		  });
	}
	//************************