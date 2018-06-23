	//RESET FORMULARIO
	function resetForm(form){
		$('#frm'+form)[0].reset();
	}
	//***************
	
	
	<!-- ************************************************************************************************************** -->
	<!-- Jquery para carga DE OBJETOS DATATABLE -->
	<!-- ************************************************************************************************************** -->
	
	//LISTAR PRODUCTOS
	function listarMaterial(){ 
		$.ajax({
			type : "GET",
			url : "http://erpge.getsandbox.com/gme/api/material/",
			success: function(result){
				var count = 1;
				$.each(result.material, function(i, material){
					if(material.activoMaterial == 1){
						var estado = 'ACTIVO';
					}else{
						var estado = 'INACTIVO';
					}
					
					if(material.tipoMaterial == 'A'){
						var tipo = 'AGRUPADOS';
					}else{
						var tipo = 'GENERICOS';
					}
	
					var customerRow = '<tr>' +
							'<td>' + (count++) + '</td>' +
							'<td>' + material.codigoMaterial + '</td>' +
							'<td>' + material.nombreMaterial + '</td>' +
							'<td>' + material.familiaMaterial + '</td>' +
							'<td>' + material.claseMaterial + '</td>' +
							'<td>' + tipo + '</td>' +
							'<td>' + estado + '</td>' +
							'<td>  <a data-toggle="modal" href="#modal_material" onclick="viewMaterial('+ material.idMaterial + ' )" class="btn btn-info btn-xs"><span class="glyphicon glyphicon-pencil" aria-hidden="true" data-toggle="tooltip" title="Editar"></span></a>'+
									'<a href="javascript: deleteMaterial('+ material.idMaterial + ')" class="btn btn-danger btn-xs" onclick="" style="margin-left:10px"><span class="glyphicon glyphicon-trash" aria-hidden="true" data-toggle="tooltip" title="Eliminar"></span></a></td>' +
							'</tr>';
						
					$('#tbl_material tbody').append(customerRow);
			    });
					$('#tbl_material').dataTable();
				},
				
			error : function(e){
					alert("ERROR: ", e);
					console.log("ERROR: ", e);
			}
		});
	}
	//***************
	
	//LISTAR FAMILIA
	function listarFamilia(){ 
		$.ajax({
			type : "GET",
			url : "http://erpge.getsandbox.com/gme/api/familia/",
			success: function(result){
				var count = 1;
				$.each(result.familia, function(i, familia){
					if(familia.activoFamilia == 1){
						var estado = 'ACTIVO';
					}else{
						var estado = 'INACTIVO';
					}
					
					var customerRow = '<tr>' +
							'<td>' + (count++) + '</td>' +
							'<td>' + familia.codigoFamilia + '</td>' +
							'<td>' + familia.nombreFamilia + '</td>' +
							'<td>' + familia.descripcionFamilia + '</td>' +
							'<td>' + estado + '</td>' +
							'<td>  <a data-toggle="modal" href="#modal_familia" onclick="viewFamilia('+ familia.idFamilia + ' )" class="btn btn-info btn-xs"><span class="glyphicon glyphicon-pencil" aria-hidden="true" data-toggle="tooltip" title="Editar"></span></a>'+
									'<a href="javascript: deleteFamilia('+ familia.idFamilia + ')" class="btn btn-danger btn-xs" onclick="" style="margin-left:10px"><span class="glyphicon glyphicon-trash" aria-hidden="true" data-toggle="tooltip" title="Eliminar"></span></a></td>' +
							'</tr>';
						
					$('#tbl_familia tbody').append(customerRow);
			    });
					$('#tbl_familia').dataTable();
				},
				
			error : function(e){
					alert("ERROR: ", e);
					console.log("ERROR: ", e);
			}
		});
	}
	//***************
	
	//LISTAR CLASE
	function listarClase(){ 
		$.ajax({
			type : "GET",
			url : "http://erpge.getsandbox.com/gme/api/clase/",
			success: function(result){
				var count = 1;
				$.each(result.clase, function(i, clase){
					if(clase.activoClase == 1){
						var estado = 'ACTIVO';
					}else{
						var estado = 'INACTIVO';
					}
					var customerRow = '<tr>' +
							'<td>' + (count++) + '</td>' +
							'<td>' + clase.codigoClase + '</td>' +
							'<td>' + clase.nombreClase + '</td>' +
							'<td>' + clase.familiaClase + '</td>' +
							'<td>' + clase.descripcionClase + '</td>' +
							'<td>' + estado + '</td>' +
							'<td>  <a data-toggle="modal" href="#modal_clase" onclick="viewClase('+ clase.idClase + ' )" class="btn btn-info btn-xs"><span class="glyphicon glyphicon-pencil" aria-hidden="true" data-toggle="tooltip" title="Editar"></span></a>'+
									'<a href="javascript: deleteClase('+ clase.idClase + ')" class="btn btn-danger btn-xs" onclick="" style="margin-left:10px"><span class="glyphicon glyphicon-trash" aria-hidden="true" data-toggle="tooltip" title="Eliminar"></span></a></td>' +
							'</tr>';
						
					$('#tbl_clase tbody').append(customerRow);
			    });
					$('#tbl_clase').dataTable();
				},
				
			error : function(e){
					alert("ERROR: ", e);
					console.log("ERROR: ", e);
			}
		});
	}
	//***************
	
	//LISTAR ALMACEN
	function listarAlmacen(){ 
		$.ajax({
			type : "GET",
			url : "http://erpge.getsandbox.com/gme/api/almacen/",
			success: function(result){
				var count = 1;
				$.each(result.almacen, function(i, almacen){
					if(almacen.activoAlmacen == 1){
						var estado = 'ACTIVO';
					}else{
						var estado = 'INACTIVO';
					}
					var customerRow = '<tr>' +
							'<td>' + (count++) + '</td>' +
							'<td>' + almacen.codigoAlmacen + '</td>' +
							'<td>' + almacen.nombreAlmacen + '</td>' +
							'<td>' + almacen.ubicacionAlmacen + '</td>' +
							'<td>' + almacen.responsableAlmacen + '</td>' +
							'<td>' + estado + '</td>' +
							'<td>  <a data-toggle="modal" href="#modal_almacen" onclick="viewAlmacen('+ almacen.idAlmacen + ' )" class="btn btn-info btn-xs"><span class="glyphicon glyphicon-pencil" aria-hidden="true" data-toggle="tooltip" title="Editar"></span></a>'+
									'<a href="javascript: deleteAlmacen('+ almacen.idAlmacen + ')" class="btn btn-danger btn-xs" onclick="" style="margin-left:10px"><span class="glyphicon glyphicon-trash" aria-hidden="true" data-toggle="tooltip" title="Eliminar"></span></a></td>' +
							'</tr>';
						
					$('#tbl_almacen tbody').append(customerRow);
			    });
					$('#tbl_almacen').dataTable();
				},
				
			error : function(e){
					alert("ERROR: ", e);
					console.log("ERROR: ", e);
			}
		});
	}
	//***************
	
	//LISTAR ALMACEN
	function listarProveedor(){ 
		$.ajax({
			type : "GET",
			url : "http://erpge.getsandbox.com/gme/api/proveedor/",
			success: function(result){
				var count = 1;
				$.each(result.proveedor, function(i, proveedor){
					if(proveedor.activoProveedor == 1){
						var estado = 'ACTIVO';
					}else{
						var estado = 'INACTIVO';
					}
					var customerRow = '<tr>' +
							'<td>' + (count++) + '</td>' +
							'<td>' + proveedor.origenProveedor + '</td>' +
							'<td>' + proveedor.rucProveedor + '</td>' +
							'<td>' + proveedor.nombreProveedor + '</td>' +
							'<td>' + proveedor.direccionProveedor + '</td>' +
							'<td>' + proveedor.telefonoProveedor + '</td>' +
							'<td>' + estado + '</td>' +
							'<td>  <a data-toggle="modal" href="#modal_proveedor" onclick="viewProveedor('+ proveedor.idProveedor + ' )" class="btn btn-info btn-xs"><span class="glyphicon glyphicon-pencil" aria-hidden="true" data-toggle="tooltip" title="Editar"></span></a>'+
									'<a href="javascript: deleteProveedor('+ proveedor.idProveedor + ')" class="btn btn-danger btn-xs" onclick="" style="margin-left:10px"><span class="glyphicon glyphicon-trash" aria-hidden="true" data-toggle="tooltip" title="Eliminar"></span></a></td>' +
							'</tr>';
						
					$('#tbl_proveedor tbody').append(customerRow);
			    });
					$('#tbl_proveedor').dataTable();
				},
				
			error : function(e){
					alert("ERROR: ", e);
					console.log("ERROR: ", e);
			}
		});
	}
	//***************
	
	//LISTAR ALMACEN
	function listarPersonal(){ 
		$.ajax({
			type : "GET",
			url : "http://erpge.getsandbox.com/gme/api/personal/",
			success: function(result){
				var count = 1;
				$.each(result.personal, function(i, personal){
					if(personal.activoPersonal == 1){
						var estado = 'ACTIVO';
					}else{
						var estado = 'INACTIVO';
					}
					
					var customerRow = '<tr>' +
							'<td>' + (count++) + '</td>' +
							'<td>' + personal.dniPersonal + '</td>' +
							'<td>' + personal.nombrePersonal + '</td>' +
							'<td>' + personal.areaPersonal + '</td>' +
							'<td>' + personal.cargoPersonal + '</td>' +
							'<td>' + estado + '</td>' +
							'<td>  <a data-toggle="modal" href="#modal_personal" onclick="viewPersonal('+ personal.idPersonal + ' )" class="btn btn-info btn-xs"><span class="glyphicon glyphicon-pencil" aria-hidden="true" data-toggle="tooltip" title="Editar"></span></a>'+
									'<a href="javascript: deletePersonal('+ personal.idPersonal + ')" class="btn btn-danger btn-xs" onclick="" style="margin-left:10px"><span class="glyphicon glyphicon-trash" aria-hidden="true" data-toggle="tooltip" title="Eliminar"></span></a></td>' +
							'</tr>';
						
					$('#tbl_personal tbody').append(customerRow);
			    });
					$('#tbl_personal').dataTable();
				},
				
			error : function(e){
					alert("ERROR: ", e);
					console.log("ERROR: ", e);
			}
		});
	}
	//***************
	
	//LISTAR CENTROS DE CONSUMO gcp
	function listarCentroConsumo(){
		$.ajax({
			type : "GET",
			url : "http://erpge.getsandbox.com/gme/api/centroconsumo/",
			
			success: function(result){
				var count = 1;
				$.each(result.centroconsumo, function(i, centroconsumo){
					if(centroconsumo.activoCentroConsumo == 1){
						var estadoCentroConsumo = 'ACTIVO';
					}else{
						var estadoCentroConsumo = 'INACTIVO';
					}
					var customerRow = '<tr>' +
										'<td>' + (count++) + '</td>' +
										'<td>' + centroconsumo.nombreCentroConsumo + '</td>' +
										'<td>' + centroconsumo.ubicacionCentroConsumo + '</td>' +
										'<td>' + centroconsumo.responsableCentroConsumo	 + '</td>' +
										'<td>' + estadoCentroConsumo + '</td>' +
										'<td>  <a data-toggle="modal" href="#modal_centroconsumo" onclick="viewCentroConsumo('+ centroconsumo.idcentroconsumo + ' )" class="btn btn-info btn-xs" ><span class="glyphicon glyphicon-pencil" aria-hidden="true" data-toggle="tooltip" title="Editar"></span></a>'+
											  '<a class="btn btn-danger btn-xs" onclick="javascript: deleteCentroConsumo('+ centroconsumo.idcentroconsumo + ' )" style="margin-left:10px"><span class="glyphicon glyphicon-trash" aria-hidden="true" data-toggle="tooltip" title="Eliminar"></span></a></td>' +
									  '</tr>';
					
					$('#tbl_centroconsumo tbody').append(customerRow);
		        });
				$('#tbl_centroconsumo').dataTable();
			},
			error : function(e) {
				alert("ERROR: ", e);
			}
		});
	}
	//***************
	
	//LISTAR ACCIONES DE INCIDENCIA gcp
	function listarSolucionDeIncidencia(){
		$.ajax({
			type : "GET",
			url : "http://erpge.getsandbox.com/gme/api/soluciondeincidencia/",
			success: function(result){
				var count=1;
				$.each(result.soluciondeincidencia, function(i, soluciondeincidencia){
					if(soluciondeincidencia.activoSolucionDeIncidencia == 1){
						var estadoSolucionDeIncidencia = 'ACTIVO';
					}else{
						var estadoSolucionDeIncidencia = 'INACTIVO';
					}
					var customerRow = '<tr>' +
										'<td>' + (count++) + '</td>' +
										'<td>' + soluciondeincidencia.codigoSolucionDeIncidencia + '</td>' +
										'<td>' + soluciondeincidencia.etapaSolucionDeIncidencia + '</td>' +
										'<td>' + soluciondeincidencia.accionSolucionDeIncidencia + '</td>' +
										'<td>' + estadoSolucionDeIncidencia + '</td>' +
										'<td>  <a data-toggle="modal" href="#modal_soluciondeincidencia" onclick="viewSolucionDeIncidencia('+ soluciondeincidencia.idSolucionDeIncidencia + ' )" class="btn btn-info btn-xs" ><span class="glyphicon glyphicon-pencil" aria-hidden="true" data-toggle="tooltip" title="Editar"></span></a>'+
											  '<a class="btn btn-danger btn-xs" onclick="javascript: deletePersonal('+ soluciondeincidencia.idSolucionDeIncidencia + ' )" style="margin-left:10px"><span class="glyphicon glyphicon-trash" aria-hidden="true" data-toggle="tooltip" title="Eliminar"></span></a></td>' +
									  '</tr>';
					
					$('#tbl_soluciondeincidencia tbody').append(customerRow);
		        });
				$('#tbl_soluciondeincidencia').dataTable();
			},
			error : function(e) {
				alert("ERROR: ", e);
			}
		});
	}
	//***************
			
	//LISTAR PARAMETROS DE CALIDAD gcp
	function listarParametroCalidad(){
		$.ajax({
			type : "GET",
			url : "http://erpge.getsandbox.com/gme/api/parametrocalidad/",
			success: function(result){
				var count=1;
				$.each(result.parametrocalidad, function(i, parametrocalidad){
					if(parametrocalidad.activoParametroCalidad == 1){
						var estado = 'ACTIVO';
					}else{
						var estado = 'INACTIVO';
					}
					var customerRow = '<tr>' +
										'<td>' + (count++) + '</td>' +
										'<td>' + parametrocalidad.codigoParametroCalidad + '</td>' +
										'<td>' + parametrocalidad.etapaParametroCalidad + '</td>' +
										'<td>' + parametrocalidad.descripcionParametroCalidad + '</td>' +
										'<td>' + estado + '</td>' +
										'<td>  <a data-toggle="modal" href="#modal_parametrocalidad" onclick="viewParametroCalidad('+ parametrocalidad.idParametroCalidad + ' )" class="btn btn-info btn-xs" ><span class="glyphicon glyphicon-pencil" aria-hidden="true" data-toggle="tooltip" title="Editar"></span></a>'+
											  '<a class="btn btn-danger btn-xs" onclick="javascript: deleteParametroCalidad('+ parametrocalidad	.idParametroCalidad + ' )" style="margin-left:10px"><span class="glyphicon glyphicon-trash" aria-hidden="true" data-toggle="tooltip" title="Eliminar"></span></a></td>' +
									  '</tr>';
					
					$('#tbl_parametrocalidad tbody').append(customerRow);
		        });
				$('#tbl_parametrocalidad').dataTable();
			},
			error : function(e) {
				alert("ERROR: ", e);
			}
		});
	}
	//***************************************************************************************************************************
	
	//LISTAR ETAPAS DE CONTROL DE CALIDAD gcp
	function listarEtapaControl(){
		
		$.ajax({
			type : "GET",
			url : "http://erpge.getsandbox.com/gme/api/etapacontrol/",
			success: function(result){
				var count=1;
				$.each(result.etapacontrol, function(i, etapacontrol){
					if(etapacontrol.activoEtapaControl == 1){
						var estadoEtapaControl = 'ACTIVO';
					}else{
						var estadoEtapaControl = 'INACTIVO';
					}
					var customerRow = '<tr>' +
										'<td>' + (count++) + '</td>' +
										'<td>' + etapacontrol.nombreEtapaControl + '</td>' +
										'<td>' + estadoEtapaControl + '</td>' +
										'<td>  <a data-toggle="modal" href="#modal_etapacontrol" onclick="viewEtapaControl('+ etapacontrol.idEtapaControl + ' )" class="btn btn-info btn-xs" ><span class="glyphicon glyphicon-pencil" aria-hidden="true" data-toggle="tooltip" title="Editar"></span></a>'+
											  '<a class="btn btn-danger btn-xs" onclick="javascript: deletepEtapaControl('+ etapacontrol.idEtapaControl + ' )" style="margin-left:10px"><span class="glyphicon glyphicon-trash" aria-hidden="true" data-toggle="tooltip" title="Eliminar"></span></a></td>' +
									  '</tr>';
					$('#tbl_etapacontrol tbody').append(customerRow);
		        });
				$('#tbl_etapacontrol').dataTable();
			},
			error : function(e) {
				alert("ERROR: ", e);
			}
		});
	}
	
	//***************************************************************************************************************************
	
	//LISTAR CARGOS   gcp
	function listarCargo(){
		
		$.ajax({
			type : "GET",
			url : "http://erpge.getsandbox.com/gme/api/cargo/",
			success: function(result){
				var count=1;
				$.each(result.cargo, function(i, cargo){
					if(cargo.activoCargo == 1){
						var estadoCargo = 'ACTIVO';
					}else{
						var estadoCargo = 'INACTIVO';
					}
					var customerRow = '<tr>' +
										'<td>' + (count++) + '</td>' +
										'<td>' + cargo.nombreCargo + '</td>' +
										'<td>' + estadoCargo + '</td>' +
										'<td>  <a data-toggle="modal" href="#modal_cargo" onclick="viewCargo('+ cargo.idCargo + ' )" class="btn btn-info btn-xs" ><span class="glyphicon glyphicon-pencil" aria-hidden="true" data-toggle="tooltip" title="Editar"></span></a>'+
											  '<a class="btn btn-danger btn-xs" onclick="javascript: deleteCargo('+ cargo.idCargo + ' )" style="margin-left:10px"><span class="glyphicon glyphicon-trash" aria-hidden="true" data-toggle="tooltip" title="Eliminar"></span></a></td>' +
									  '</tr>';
					
					$('#tbl_cargo tbody').append(customerRow);
		        });
				$('#tbl_cargo').dataTable();
			},
			error : function(e) {
				alert("ERROR: ", e);
			}
		});
	}
	
//***************************************************************************************************************************
	
	//LISTAR REQUERIMIENTOS A ALMACEN
	
	function listarRequerimientos(){
		
		$.ajax({
			type : "GET",
			url : "http://erpge.getsandbox.com/gme/api/requerimientos/",
			success: function(result){
				var count=1;
				$.each(result.requerimientos, function(i, requerimientos){
					if(requerimientos.activoRequerimiento == 1){
						var estadoRequerimiento = 'ACTIVO';
					}else{
						var estadoRequerimiento = 'INACTIVO';
					}
					var customerRow = '<tr>' +
										'<td>' + (count++) + '</td>' +
										'<td>' + requerimientos.nroPedido + '</td>' +
										'<td>' + requerimientos.tipoRequerimiento + '</td>' +
										'<td>' + requerimientos.centroConsumo + '</td>' +
										'<td>' + requerimientos.solicitante + '</td>' +
										'<td>' + requerimientos.tipoMovimiento + '</td>' +
										'<td>' + requerimientos.prioridad + '</td>' +
										'<td>' + requerimientos.fechaRequerimiento + '</td>' +
										'<td>' + requerimientos.estadoRequerimiento + '</td>' +
										'<td>  <a data-toggle="modal" href="#modal_requerimiento" onclick="viewRequerimiento('+ requerimientos.nroPedido + ' )" class="btn btn-info btn-xs" ><span class="glyphicon glyphicon-pencil" aria-hidden="true" data-toggle="tooltip" title="Editar"></span></a>'+
											   '<a data-toggle="modal" href="#modal_requerimiento" onclick="viewRequerimiento('+ requerimientos.nroPedido + ' )" class="btn btn-info btn-xs" style="margin-left:5px"; ><span class="glyphicon glyphicon-eye-open" aria-hidden="true" data-toggle="tooltip" title="Ver"></span></a>'+
											   '<a data-toggle="modal" href="#modal_requerimiento" onclick="viewRequerimiento('+ requerimientos.nroPedido + ' )" class="btn btn-info btn-xs" style="margin-left:5px"; ><span class="glyphicon glyphicon-saved" aria-hidden="true" data-toggle="tooltip" title="Aprobar"></span></a>'+
											   '<a data-toggle="modal" href="#modal_requerimiento" onclick="viewRequerimiento('+ requerimientos.nroPedido + ' )" class="btn btn-info btn-xs" style="margin-left:5px"; ><span class="glyphicon glyphicon-saved" aria-hidden="true" data-toggle="tooltip" title="Editar"></span></a>'+
										'</td>'+
									  '</tr>';
					
					$('#tbl_requerimientos tbody').append(customerRow);
		        });
				$('#tbl_requerimientos').dataTable();
			},
			error : function(e) {
				alert("ERROR: ", e);
			}
		});
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

	
	<!-- ************************************************************************************************************** -->
	<!-- JQUERY VIEW UPDATE  -->
	<!-- ************************************************************************************************************** -->
	
	
	function viewMaterial(id){
		$('#idMaterial').val(id);
		$('#ctrlMaterial').val('E');
		$('#titulo_Material').html('<strong>EDITAR BIEN Y/O MATERIAL</strong>');
		
		var requestMaterial = new Object();
		requestMaterial["idMaterial"] = id;
		
		$.ajax({
		    url: "http://erpge.getsandbox.com/gme/api/material/view",
		    type: "POST",
		    dataType: 'json',
		    data: JSON.stringify(requestMaterial),
		    contentType : "application/json",
		    success: function(data) {
				console.log("Success = " + JSON.stringify(data) );
				$.each(data.material, function(i, material){
					$('#codigoMaterial').val(material.codigoMaterial);
					$('#familiaMaterial').val(material.familiaMaterial);
					$('#claseMaterial').val(material.claseMaterial);
					$('#tipoMaterial').val(material.tipoMaterial);
					$('#nombreMaterial').val(material.nombreMaterial);
					$('#unidadMaterial').val(material.unidadMedidaMaterial);
					$('#stockMaterial').val(material.stockMaterial);
					$('#estadoMaterial').val(material.activoMaterial);
		        });
		    },
		    error: function() { 
		    		//alert('Failed!'); 
		    	}
		});
		
	}
	
	
	function viewFamilia(id){
		$('#idFamilia').val(id);
		$("#ctrlFamilia").val("E");
		$('#titulo_Familia').html('<strong>EDITAR FAMILIA DE MATERIAL</strong>');
		
		var requestFamilia = new Object();
		requestFamilia["idFamilia"] = id;
		
		$.ajax({
		    url: "http://erpge.getsandbox.com/gme/api/familia/view",
		    type: "POST",
		    dataType: 'json',
		    data: JSON.stringify(requestFamilia),
		    contentType : "application/json",
		    success: function(data) {
				console.log("Success = " + JSON.stringify(data) );
				$.each(data.familia, function(i, familia){
					$('#codigoFamilia').val(familia.codigoFamilia);
					$('#nombreFamilia').val(familia.nombreFamilia);
					$('#descripcionFamilia').val(familia.descripcionFamilia);
					$('#estadoFamilia').val(familia.activoFamilia);
		        });
		    },
		    error: function() { 
		    		//alert('Failed!'); 
		    	}
		});
		
	}
	
	
	function viewClase(id){
		$('#idClase').val(id);
		$('#ctrlClase').val('E');
		$('#titulo_Clase').html('<strong>EDITAR CLASE DE MATERIAL</strong>');
		
		var requestClase = new Object();
		requestClase["idClase"] = id;
		
		$.ajax({
		    url: "http://erpge.getsandbox.com/gme/api/clase/view",
		    type: "POST",
		    dataType: 'json',
		    data: JSON.stringify(requestClase),
		    contentType : "application/json",
		    success: function(data) {
				console.log("Success = " + JSON.stringify(data) );
				$.each(data.clase, function(i, clase){
					$('#codigoClase').val(clase.codigoClase);
					$('#familiaClase').val(clase.familiaClase);
					$('#nombreClase').val(clase.nombreClase);
					$('#descripcionClase').val(clase.descripcionClase);
					$('#estadoClase').val(clase.activoClase);
		        });
		    },
		    error: function() { 
		    		//alert('Failed!'); 
		    	}
		});
		
	}
	
	
	function viewAlmacen(id){
		$('#idAlmacen').val(id);
		$('#ctrlAlmacen').val('E');
		$('#titulo_Almacen').html('<strong>EDITAR ALMACEN</strong>');
		
		var requestAlmacen = new Object();
		requestAlmacen["idAlmacen"] = id;
		
		$.ajax({
		    url: "http://erpge.getsandbox.com/gme/api/almacen/view",
		    type: "POST",
		    dataType: 'json',
		    data: JSON.stringify(requestAlmacen),
		    contentType : "application/json",
		    success: function(data) {
				console.log("Success = " + JSON.stringify(data) );
				$.each(data.almacen, function(i, almacen){
					$('#codigoAlmacen').val(almacen.codigoAlmacen);
					$('#nombreAlmacen').val(almacen.nombreAlmacen);
					$('#ubicacionAlmacen').val(almacen.ubicacionAlmacen);
					$('#responsableAlmacen').val(almacen.responsableAlmacen);
					$('#estadoAlmacen').val(almacen.activoAlmacen);
		        });
		    },
		    error: function() { 
		    		//alert('Failed!'); 
		    	}
		});
		
	}
	
	
	function viewProveedor(id){
		$('#idProveedor').val(id);
		$('#ctrlProveedor').val('E');
		$('#titulo_Proveedor').html('<strong>EDITAR PROVEEDOR</strong>');
		
		var requestProveedor = new Object();
		requestProveedor["idProveedor"] = id;
		
		$.ajax({
		    url: "http://erpge.getsandbox.com/gme/api/proveedor/view",
		    type: "POST",
		    dataType: 'json',
		    data: JSON.stringify(requestProveedor),
		    contentType : "application/json",
		    success: function(data) {
				console.log("Success = " + JSON.stringify(data) );
				$.each(data.proveedor, function(i, proveedor){
					$('#origenProveedor').val(proveedor.origenProveedor);
					$('#rucProveedor').val(proveedor.rucProveedor);
					$('#nombreProveedor').val(proveedor.nombreProveedor);
					$('#direccionProveedor').val(proveedor.direccionProveedor);
					$('#telefonoProveedor').val(proveedor.teefonoProveedor);
					$('#estadoAlmacen').val(proveedor.activoProveedor);
		        });
		    },
		    error: function() { 
		    		//alert('Failed!'); 
		    	}
		});
		
	}
	
	
	function viewPersonal(id){
		$('#idPersonal').val(id);
		$('#ctrlPersonal').val('E');
		$('#titulo_Personal').html('<strong>EDITAR PERSONAL</strong>');
		
		var requestPersonal = new Object();
		requestPersonal["idPersonal"] = id;
		
		$.ajax({
		    url: "http://erpge.getsandbox.com/gme/api/personal/view",
		    type: "POST",
		    dataType: 'json',
		    data: JSON.stringify(requestPersonal),
		    contentType : "application/json",
		    success: function(data) {
				console.log("Success = " + JSON.stringify(data) );
				$.each(data.personal, function(i, personal){
					$('#dniPersonal').val(personal.dniPersonal);
					$('#nombrePersonal').val(personal.nombrePersonal);
					$('#areaPersonal').val(personal.areaPersonal);
					$('#cargoPersonal').val(personal.cargoPersonal);
					$('#estadoAlmacen').val(personal.activoPersonal);
		        });
		    },
		    error: function() { 
		    		//alert('Failed!'); 
		    	}
		});
		
	}
	
	
	function viewCentroConsumo(id){
		$('#idCentroConsumo').val(id);
		$("#ctrlCentroConsumo").val("E");
		$('#titulo_CentroConsumo').html('<strong>EDITAR CENTRO DE CONSUMO</strong>');
		
		var requestCentroConsumo = new Object();
		requestCentroConsumo["idCentroConsumo"] = id;
		
		$.ajax({
		    url: "http://erpge.getsandbox.com/gme/api/centroconsumo/view",
		    type: "POST",
		    dataType: 'json',
		    data: JSON.stringify(requestCentroConsumo),
		    contentType : "application/json",
		    success: function(data) {
				console.log("Success = " + JSON.stringify(data) );
				$.each(data.centroconsumo, function(i, centroconsumo){
					$('#codigocentroconsumo').val(centroconsumo.codigocentroconsumo);
					$('#nombrecentroconsumo').val(centroconsumo.nombrecentroconsumo);
					$('#ubicacioncentroconsumo').val(centroconsumo.ubicacioncentroconsumo);
					$('#responsablecentroconsumo').val(centroconsumo.responsablecentroconsumo);
					$('#activocentroconsumo').val(centroconsumo.activocentroconsumo);
		        });
		    },
		    error: function() { 
		    		//alert('Failed!'); 
		    	}
		});
		
	}
	
	
	function viewSolucionDeIncidencia(id){
		$('#idSolucionDeIncidencia').val(id);
		$("#ctrlSolucionDeIncidencia").val("E");
		$('#titulo_SolucionDeIncidencia').html('<strong>EDITAR SOLUCION DE INCIDENCIA</strong>');
		
		var requestSolucionDeIncidencia = new Object();
		requestSolucionDeIncidencia["idSolucionDeIncidencia"] = id;
		
		$.ajax({
		    url: "http://erpge.getsandbox.com/gme/api/soluciondeincidencia/view",
		    type: "POST",
		    dataType: 'json',
		    data: JSON.stringify(requestSolucionDeIncidencia),
		    contentType : "application/json",
		    success: function(data) {
				console.log("Success = " + JSON.stringify(data) );
				$.each(data.soluciondeincidencia, function(i, soluciondeincidencia){
					$('#codigoSolucionDeIncidencia').val(soluciondeincidencia.codigoSolucionDeIncidencia);
					$('#etapaSolucionDeIncidencia').val(soluciondeincidencia.etapaSolucionDeIncidencia);
					$('#accionSolucionDeIncidencia').val(soluciondeincidencia.accionSolucionDeIncidencia);
					$('#activoSolucionDeIncidencia').val(soluciondeincidencia.activoSolucionDeIncidencia);
		        });
		    },
		    error: function() { 
		    		//alert('Failed!'); 
		    	}
		});
	}
	
	
	function viewParametroCalidad(id){
		$('#idParametroCalidad').val(id);
		$("#ctrlParametroCalidad").val("E");
		$('#titulo_ParametroCalidad').html('<strong>EDITAR PARAMETROS DE CALIDAD</strong>');
		
		var requestParametroCalidad = new Object();
		requestParametroCalidad["idParametroCalidad"] = id;
		
		$.ajax({
		    url: "http://erpge.getsandbox.com/gme/api/parametrocalidad/view",
		    type: "POST",
		    dataType: 'json',
		    data: JSON.stringify(requestParametroCalidad),
		    contentType : "application/json",
		    success: function(data) {
				console.log("Success = " + JSON.stringify(data) );
				$.each(data.parametrocalidad, function(i, parametrocalidad){
					$('#codigoParametroCalidad').val(parametrocalidad.codigoParametroCalidad);
					$('#etapaParametroCalidad').val(parametrocalidad.etapaParametroCalidad);
					$('#descripcionParametroCalidad').val(parametrocalidad.descripcionParametroCalidad);
					$('#activoParametroCalidad').val(parametrocalidad.activoParametroCalidad);
		        });
		    },
		    error: function() { 
		    		//alert('Failed!'); 
		    	}
		});
		
	}
	
	
	function viewEtapaControl(id){
		$('#idEtapaControl').val(id);
		$("#ctrlEtapaControl").val("E");
		$('#titulo_EtapaControl').html('<strong>EDITAR ETAPA DE CONTROL</strong>');
		
		var requestEtapaControl = new Object();
		requestEtapaControl["idEtapaControl"] = id;
		
		$.ajax({
		    url: "http://erpge.getsandbox.com/gme/api/etapacontrol/view",
		    type: "POST",
		    dataType: 'json',
		    data: JSON.stringify(requestEtapaControl),
		    contentType : "application/json",
		    success: function(data) {
				console.log("Success = " + JSON.stringify(data) );
				$.each(data.etapacontrol, function(i, etapacontrol){
					$('#idEtapaControl').val(etapacontrol.idEtapaControl);
					$('#etapaEtapaControl').val(etapacontrol.nombreEtapaControl);
					$('#descripcionEtapaControl').val(etapacontrol.activoEtapaControl);
		        });
		    },
		    error: function() { 
		    		//alert('Failed!'); 
		    	}
		});
		
	}
	
	function viewCargo(id){
		$('#idCargo').val(id);
		$('#ctrlCargo').val('E');
		$('#titulo_Cargo').html('<strong>EDITAR CARGO</strong>');
		
		var requestCargo = new Object();
		requestCargo["idCargo"] = id;
		
		$.ajax({
		    url: "http://erpge.getsandbox.com/gme/api/cargo/view",
		    type: "POST",
		    dataType: 'json',
		    data: JSON.stringify(requestCargo),
		    contentType : "application/json",
		    success: function(data) {
				console.log("Success = " + JSON.stringify(data) );
				$.each(data.cargo, function(i, cargo){
					$('#idCargo').val(material.idCargo);
					$('#nombreCargo').val(cargo.nombreCargo);
					$('#estadoCargo').val(cargo.estadoCargo);
		        });
		    },
		    error: function() { 
		    		//alert('Failed!'); 
		    	}
		});
	}
	
	// VISTA DE TABLA REQUERIMIENTOS 
	
	function viewRequerimientos(id){
		$('#idCargo').val(id);
		$('#ctrlCargo').val('E');
		$('#titulo_Cargo').html('<strong>EDITAR CARGO</strong>');
		
		var requestCargo = new Object();
		requestCargo["idCargo"] = id;
		
		$.ajax({
		    url: "http://erpge.getsandbox.com/gme/api/cargo/view",
		    type: "POST",
		    dataType: 'json',
		    data: JSON.stringify(requestCargo),
		    contentType : "application/json",
		    success: function(data) {
				console.log("Success = " + JSON.stringify(data) );
				$.each(data.cargo, function(i, cargo){
					$('#idCargo').val(material.idCargo);
					$('#nombreCargo').val(cargo.nombreCargo);
					$('#estadoCargo').val(cargo.estadoCargo);
		        });
		    },
		    error: function() { 
		    		//alert('Failed!'); 
		    	}
		});
		
	}
	
	<!-- ************************************************************************************************************** -->
	<!-- JQUERY INSERT Y UPDATE  -->
	<!-- ************************************************************************************************************** -->
	
	function addMaterial(){
		if($("#ctrlMaterial").val() == 'A'){
			//$('#msj_material').html('AGREGAR');
			var requestMaterial = new Object();
			requestMaterial["codigoMaterial"] = $("#codigoMaterial").val();
			requestMaterial["familiaMaterial"] = $("#familiaMaterial").val();
			requestMaterial["claseMaterial"] = $("#claseMaterial").val();
			requestMaterial["tipoMaterial"] = $("#tipoMaterial").val();
			requestMaterial["nombreMaterial"] = $("#nombreMaterial").val();
			requestMaterial["unidadMedidaMaterial"] = $("#unidadMaterial").val();
			requestMaterial["stockMaterial"] = $("#stockMaterial").val();
			requestMaterial["activoMaterial"] = $("#estadomaterial").val();
			
			var total = $("#familiaMaterial").val().length * $("#claseMaterial").val().length * $("#tipoMaterial").val().length * $("#nombreMaterial").val().length * $("#unidadMaterial").val().length * $("#stockMaterial").val().length * $("#estadoMaterial").val().length;
			
			if(total > 0){
				$.ajax({
				    url: "http://erpge.getsandbox.com/gme/api/material/add",
				    type: "POST",
				    dataType: 'json',
				    data: JSON.stringify(requestMaterial),
				    contentType : "application/json",
				    success: function(data) {
						console.log("Success = " + JSON.stringify(data) );
						$('#tbl_material tbody').empty();
						listarMaterial();
						$('#frmMaterial')[0].reset();
				    },
				    error: function() { 
				    		//alert('Failed!'); 
				    }
				});
			}else{
				$('#msj_material').addClass('alert alert-danger text-center').html('<strong>Error!</strong> <strong>Complete los Datos</strong>').show(10).delay(3500).hide(10);
			}
			
		}else{
			//$('#msj_material').html('EDITAR');
			var requestMaterial = new Object();
			requestMaterial["idMaterial"] = $("#idMaterial").val();
			requestMaterial["familiaMaterial"] = $("#familiaMaterial").val();
			requestMaterial["claseMaterial"] = $("#claseMaterial").val();
			requestMaterial["nombreMaterial"] = $("#nombreMaterial").val();
			requestMaterial["unidadMedidaMaterial"] = $("#unidadMaterial").val();
			requestMaterial["stockMaterial"] = $("#stockMaterial").val();
			requestMaterial["activoMaterial"] = $("#estadomaterial").val();
			
			var total = $("#familiaMaterial").val().length * $("#claseMaterial").val().length * $("#nombreMaterial").val().length * $("#unidadMaterial").val().length * $("#stockMaterial").val().length * $("#estadomaterial").val().length;			
			
			if(total > 0){
				$.ajax({
				    url: "http://erpge.getsandbox.com/gme/api/material/upd",
				    type: "POST",
				    dataType: 'json',
				    data: JSON.stringify(requestMaterial),
				    contentType : "application/json",
				    success: function(data) {
						console.log("Success = " + JSON.stringify(data) );
						$('#tbl_material tbody').empty();
						listarMaterial();
						$('#frmMaterial')[0].reset();
				    },
				    error: function() { 
				    		//alert('Failed!'); 
				    	}
				});
			}else{
				$('#msj_material').addClass('alert alert-danger text-center').html('<strong>Error!</strong> <strong>Complete los Datos</strong>').show(10).delay(3500).hide(10);
			}
		}
	}
 	
	
	function addFamilia(){
		if($("#ctrlFamilia").val() == 'A'){
			//$('#msj_material').html('AGREGAR');
			var requestFamilia = new Object();
			requestFamilia["codigoFamilia"] = $("#codigoFamilia").val();
			requestFamilia["nombreFamilia"] = $("#nombreFamilia").val();
			requestFamilia["descripcionFamilia"] = $("#descripcionFamilia").val();
			requestFamilia["activoFamilia"] = $("#estadoFamilia").val();
			
			var total = $("#nombreFamilia").val().length * $("#descripcionFamilia").val().length * $("#estadoFamilia").val().length;
			
			if(total > 0){
				$.ajax({
				    url: "http://erpge.getsandbox.com/gme/api/familia/add",
				    type: "POST",
				    dataType: 'json',
				    data: JSON.stringify(requestFamilia),
				    contentType : "application/json",
				    success: function(data) {
						console.log("Success = " + JSON.stringify(data) );
						$('#tbl_familia tbody').empty();
						listarFamilia();
						$('#frmFamilia')[0].reset();
				    },
				    error: function() { 
				    		//alert('Failed!'); 
				    }
				});
			}else{
				$('#msj_familia').addClass('alert alert-danger text-center').html('<strong>Error!</strong> <strong>Complete los Datos</strong>').show(10).delay(3500).hide(10);
			}
			
		}else{
			//$('#msj_material').html('EDITAR');
			var requestFamilia = new Object();
			requestFamilia["idFamilia"] = $("#idFamilia").val();
			requestFamilia["nombreFamilia"] = $("#nombreFamilia").val();
			requestFamilia["descripcionFamilia"] = $("#descripcionFamilia").val();
			requestFamilia["activoFamilia"] = $("#estadoFamilia").val();
			
			var total = $("#nombreFamilia").val().length * $("#descripcionFamilia").val().length * $("#estadoFamilia").val().length;
			
			if(total > 0){
				$.ajax({
				    url: "http://erpge.getsandbox.com/gme/api/familia/upd",
				    type: "POST",
				    dataType: 'json',
				    data: JSON.stringify(requestFamilia),
				    contentType : "application/json",
				    success: function(data) {
						console.log("Success = " + JSON.stringify(data) );
						$('#tbl_familia tbody').empty();
						listarFamilia();
						$('#frm_familia')[0].reset();
				    },
				    error: function() { 
				    		//alert('Failed!'); 
				    	}
				});
			}else{
				$('#msj_familia').addClass('alert alert-danger text-center').html('<strong>Error!</strong> <strong>Complete los Datos</strong>').show(10).delay(3500).hide(10);
			}
		}
	}
	
	
	function addClase(){
		if($("#ctrlClase").val() == 'A'){
			//$('#msj_material').html('AGREGAR');
			var requestClase = new Object();
			requestClase["codigoClase"] = $("#codigoClase").val();
			requestClase["familiaClase"] = $("#familiaClase").val();
			requestClase["nombreClase"] = $("#nombreClase").val();
			requestClase["descripcionClase"] = $("#descripcionClase").val();
			requestClase["activoClase"] = $("#estadoClase").val();
			
			var total = $("#familiaClase").val().length * $("#nombreClase").val().length * $("#descripcionClase").val().length * $("#estadoClase").val().length;
			
			if(total > 0){
				$.ajax({
				    url: "http://erpge.getsandbox.com/gme/api/clase/add",
				    type: "POST",
				    dataType: 'json',
				    data: JSON.stringify(requestClase),
				    contentType : "application/json",
				    success: function(data) {
						console.log("Success = " + JSON.stringify(data) );
						$('#tbl_clase tbody').empty();
						listarClase();
						$('#frmClase')[0].reset();
				    },
				    error: function() { 
				    		//alert('Failed!'); 
				    }
				});
			}else{
				$('#msj_clase').addClass('alert alert-danger text-center').html('<strong>Error!</strong> <strong>Complete los Datos</strong>').show(10).delay(3500).hide(10);
			}
			
		}else{
			//$('#msj_material').html('EDITAR');
			var requestClase = new Object();
			requestClase["idClase"] = $("#idClase").val();
			requestClase["familiaClase"] = $("#familiaClase").val();
			requestClase["nombreClase"] = $("#nombreClase").val();
			requestClase["descripcionClase"] = $("#descripcionClase").val();
			requestClase["activoClase"] = $("#estadoClase").val();
			
			var total = $("#familiaClase").val().length * $("#nombreClase").val().length * $("#descripcionClase").val().length * $("#estadoClase").val().length;
			
			if(total > 0){
				$.ajax({
				    url: "http://erpge.getsandbox.com/gme/api/clase/upd",
				    type: "POST",
				    dataType: 'json',
				    data: JSON.stringify(requestClase),
				    contentType : "application/json",
				    success: function(data) {
						console.log("Success = " + JSON.stringify(data) );
						$('#tbl_clase tbody').empty();
						listarClase();
						$('#frmClase')[0].reset();
				    },
				    error: function() { 
				    		//alert('Failed!'); 
				    	}
				});
			}else{
				$('#msj_clase').addClass('alert alert-danger text-center').html('<strong>Error!</strong> <strong>Complete los Datos</strong>').show(10).delay(3500).hide(10);
			}
		}
	}
	
	
	function addAlmacen(){
		if($("#ctrlAlmacen").val() == 'A'){
			//$('#msj_material').html('AGREGAR');
			var requestAlmacen = new Object();
			requestAlmacen["codigoAlmacen"] = $("#codigoAlmacen").val();
			requestAlmacen["nombreAlmacen"] = $("#nombreAlmacen").val();
			requestAlmacen["ubicacionAlmacen"] = $("#ubicacionAlmacen").val();
			requestAlmacen["responsableAlmacen"] = $("#responsableAlmacen").val();
			requestAlmacen["activoAlmacen"] = $("#estadoAlmacen").val();
			
			var total = $("#nombreAlmacen").val().length * $("#ubicacionAlmacen").val().length * $("#responsableAlmacen").val().length * $("#estadoAlmacen").val().length;
			
			if(total > 0){
				$.ajax({
				    url: "http://erpge.getsandbox.com/gme/api/almacen/add",
				    type: "POST",
				    dataType: 'json',
				    data: JSON.stringify(requestAlmacen),
				    contentType : "application/json",
				    success: function(data) {
						console.log("Success = " + JSON.stringify(data) );
						$('#tbl_almacen tbody').empty();
						listarAlmacen();
						$('#frmAlmacen')[0].reset();
				    },
				    error: function() { 
				    		//alert('Failed!'); 
				    }
				});
			}else{
				$('#msj_almacen').addClass('alert alert-danger text-center').html('<strong>Error!</strong> <strong>Complete los Datos</strong>').show(10).delay(3500).hide(10);
			}
			
		}else{
			//$('#msj_material').html('EDITAR');
			var requestAlmacen = new Object();
			requestAlmacen["idAlmacen"] = $("#idAlmacen").val();
			requestAlmacen["nombreAlmacen"] = $("#nombreAlmacen").val();
			requestAlmacen["ubicacionAlmacen"] = $("#ubicacionAlmacen").val();
			requestAlmacen["responsableAlmacen"] = $("#responsableAlmacen").val();
			requestAlmacen["activoAlmacen"] = $("#estadoAlmacen").val();
			
			var total = $("#nombreAlmacen").val().length * $("#ubicacionAlmacen").val().length * $("#responsableAlmacen").val().length * $("#estadoAlmacen").val().length;
			
			if(total > 0){
				$.ajax({
				    url: "http://erpge.getsandbox.com/gme/api/almacen/upd",
				    type: "POST",
				    dataType: 'json',
				    data: JSON.stringify(requestAlmacen),
				    contentType : "application/json",
				    success: function(data) {
						console.log("Success = " + JSON.stringify(data) );
						$('#tbl_almacen tbody').empty();
						listarAlmacen();
						$('#frmAlmacen')[0].reset();
				    },
				    error: function() { 
				    		//alert('Failed!'); 
				    	}
				});
			}else{
				$('#msj_almacen').addClass('alert alert-danger text-center').html('<strong>Error!</strong> <strong>Complete los Datos</strong>').show(10).delay(3500).hide(10);
			}
		}
	}
	
	
	function addProveedor(){
		if($("#ctrlProveedor").val() == 'A'){
			//$('#msj_material').html('AGREGAR');
			var requestProveedor = new Object();
			requestProveedor["origenProveedor"] = $("#origenProveedor").val();
			requestProveedor["rucProveedor"] = $("#rucProveedor").val();
			requestProveedor["nombreProveedor"] = $("#nombreProveedor").val();
			requestProveedor["direccionProveedor"] = $("#direccionProveedor").val();
			requestProveedor["teefonoProveedor"] = $("#telefonoProveedor").val();
			requestProveedor["activoProveedor"] = $("#estadoProveedor").val();
			
			var total = $("#origenProveedor").val().length * $("#rucProveedor").val().length * $("#nombreProveedor").val().length * $("#direccionProveedor").val().length * $("#telefonoProveedor").val().length * $("#estadoProveedor").val().length;
			
			if(total > 0){
				$.ajax({
				    url: "http://erpge.getsandbox.com/gme/api/proveedor/add",
				    type: "POST",
				    dataType: 'json',
				    data: JSON.stringify(requestProveedor),
				    contentType : "application/json",
				    success: function(data) {
						console.log("Success = " + JSON.stringify(data) );
						$('#tbl_proveedor tbody').empty();
						listarProveedor();
						$('#frmProveedor')[0].reset();
				    },
				    error: function() { 
				    		//alert('Failed!'); 
				    }
				});
			}else{
				$('#msj_proveedor').addClass('alert alert-danger text-center').html('<strong>Error!</strong> <strong>Complete los Datos</strong>').show(10).delay(3500).hide(10);
			}
			
		}else{
			//$('#msj_material').html('EDITAR');
			var requestProveedor = new Object();
			requestProveedor["idProveedor"] = $("#id_proveedor").val();
			requestProveedor["origenProveedor"] = $("#origenProveedor").val();
			requestProveedor["rucProveedor"] = $("#rucProveedor").val();
			requestProveedor["nombreProveedor"] = $("#nombreProveedor").val();
			requestProveedor["direccionProveedor"] = $("#direccionProveedor").val();
			requestProveedor["teefonoProveedor"] = $("#telefonoProveedor").val();
			requestProveedor["activoProveedor"] = $("#estadoProveedor").val();
			
			var total = $("#origenProveedor").val().length * $("#rucProveedor").val().length * $("#nombreProveedor").val().length * $("#direccionProveedor").val().length * $("#telefonoProveedor").val().length * $("#estadoProveedor").val().length;
			
			if(total > 0){
				$.ajax({
				    url: "http://erpge.getsandbox.com/gme/api/proveedor/upd",
				    type: "POST",
				    dataType: 'json',
				    data: JSON.stringify(requestProveedor),
				    contentType : "application/json",
				    success: function(data) {
						console.log("Success = " + JSON.stringify(data) );
						$('#tbl_proveedor tbody').empty();
						listarProveedor();
						$('#frmProveedor')[0].reset();
				    },
				    error: function() { 
				    		//alert('Failed!'); 
				    	}
				});
			}else{
				$('#msj_proveedor').addClass('alert alert-danger text-center').html('<strong>Error!</strong> <strong>Complete los Datos</strong>').show(10).delay(3500).hide(10);
			}
		}
	}
	
	
	function addPersonal(){
		if($("#ctrlPersonal").val() == 'A'){
			//$('#msj_material').html('AGREGAR');
			var requestPersonal = new Object();
			requestPersonal["dniPersonal"] = $("#dniPersonal").val();
			requestPersonal["nombrePersonal"] = $("#nombrePersonal").val();
			requestPersonal["areaPersonal"] = $("#areaPersonal").val();
			requestPersonal["cargoPersonal"] = $("#cargoPersonal").val();
			requestPersonal["activoPersonal"] = $("#estadoPersonal").val();
			
			var total = $("#dniPersonal").val().length * $("#nombrePersonal").val().length * $("#areaPersonal").val().length * $("#cargoPersonal").val().length * $("#estadoPersonal").val().length;
			
			if(total > 0){
				$.ajax({
				    url: "http://erpge.getsandbox.com/gme/api/personal/add",
				    type: "POST",
				    dataType: 'json',
				    data: JSON.stringify(requestPersonal),
				    contentType : "application/json",
				    success: function(data) {
						console.log("Success = " + JSON.stringify(data) );
						$('#tbl_personal tbody').empty();
						listarPersonal();
						$('#frmPersonal')[0].reset();
				    },
				    error: function() { 
				    		//alert('Failed!'); 
				    }
				});
			}else{
				$('#msj_personal').addClass('alert alert-danger text-center').html('<strong>Error!</strong> <strong>Complete los Datos</strong>').show(10).delay(3500).hide(10);
			}
			
		}else{
			//$('#msj_material').html('EDITAR');
			var requestPersonal = new Object();
			requestPersonal["idPersonal"] = $("#id_personal").val();
			requestPersonal["dniPersonal"] = $("#dniPersonal").val();
			requestPersonal["nombrePersonal"] = $("#nombrePersonal").val();
			requestPersonal["areaPersonal"] = $("#areaPersonal").val();
			requestPersonal["cargoPersonal"] = $("#cargoPersonal").val();
			requestPersonal["activoPersonal"] = $("#estadoPersonal").val();
			
			var total = $("#dniPersonal").val().length * $("#nombrePersonal").val().length * $("#areaPersonal").val().length * $("#cargoPersonal").val().length * $("#estadoPersonal").val().length;
			
			if(total > 0){
				$.ajax({
				    url: "http://erpge.getsandbox.com/gme/api/personal/upd",
				    type: "POST",
				    dataType: 'json',
				    data: JSON.stringify(requestPersonal),
				    contentType : "application/json",
				    success: function(data) {
						console.log("Success = " + JSON.stringify(data) );
						$('#tbl_personal tbody').empty();
						listarPersonal();
						$('#frmPersonal')[0].reset();
				    },
				    error: function() { 
				    		//alert('Failed!'); 
				    	}
				});
			}else{
				$('#msj_personal').addClass('alert alert-danger text-center').html('<strong>Error!</strong> <strong>Complete los Datos</strong>').show(10).delay(3500).hide(10);
			}
		}
	}
	
	
	function addParametroCalidad(){
		if($("#crtlParametrocalidad").val() == 'A'){
			
			var requestParametrocalidad = new Object();
			requestParametrocalidad["codigoParametroCalidad"] = $("#codigoParametroCalidad").val();
			requestParametrocalidad["etapaParametroCalidad"] = $("#etapaParametroCalidad").val();
			requestParametrocalidad["descripcionParametroCalidad"] = $("#descripcionParametroCalidad").val();
			requestParametrocalidad["activoParametroCalidad"] = $("#activoParametroCalidad").val();
			
			var total = $("#etapaParametroCalidad").val().length * $("#descripcionParametroCalidad").val().length * $("#activoParametroCalidad").val().length;
			
			if(total > 0){
				$.ajax({
				    url: "http://erpge.getsandbox.com/gme/api/parametrocalidad/add",
				    type: "POST",
				    dataType: 'json',
				    data: JSON.stringify(requestParametrocalidad),
				    contentType : "application/json",
				    success: function(data) {
						console.log("Success = " + JSON.stringify(data) );
						$('#tbl_parametrocalidad tbody').empty();
						listarParametroCalidad();
						$('#frmParametroCalidad')[0].reset();
				    },
				    error: function() { 
				    		//alert('Failed!'); 
				    }
				});
			}else{
				$('#msj_parametrocalidad').addClass('alert alert-danger text-center').html('<strong>Error!</strong> <strong>Complete los Datos</strong>').show(10).delay(3500).hide(10);
			}
			
		}else{
			//$('#msj_material').html('EDITAR');
			var requestParametroCalidad = new Object();
			requestParametroCalidad["idParametroCalidad"] = $("#idParametroCalidad").val();
			requestParametroCalidad["etapaParametroCalidad"] = $("#etapaParametroCalidad").val();
			requestParametroCalidad["descripcionParametroCalidad"] = $("#descripcionParametroCalidad").val();
			requestParametroCalidad["activoParametroCalidad"] = $("#activoParametroCalidad").val();
			
			var total = $("#etapaParametroCalidad").val().length * $("#descripcionParametroCalidad").val().length * $("#activoParametroCalidad").val().length;
			
			if(total > 0){
				$.ajax({
				    url: "http://erpge.getsandbox.com/gme/api/parametrocalidad/upd",
				    type: "POST",
				    dataType: 'json',
				    data: JSON.stringify(requestParametrocalidad),
				    contentType : "application/json",
				    success: function(data) {
						console.log("Success = " + JSON.stringify(data) );
						$('#tbl_parametrocalidad tbody').empty();
						listarParametroCalidad();
						$('#frm_parametrocalidad')[0].reset();
				    },
				    error: function() { 
				    		//alert('Failed!'); 
				    	}
				});
			}else{
				$('#msj_parametrocalidad').addClass('alert alert-danger text-center').html('<strong>Error!</strong> <strong>Complete los Datos</strong>').show(10).delay(3500).hide(10);
			}
		}
	}
	
	
	function addSolucionDeIncidencia(){
		if($("#crtlSolucionDeincidencia").val() == 'A'){
			var requestSolucionDeincidencia = new Object();
			requestSolucionDeincidencia["codigoSolucionDeIncidencia"] = $("#codigoSolucionDeIncidencia").val();
			requestSolucionDeincidencia["etapaSolucionDeIncidencia"]  = $("#etapaSolucionDeIncidencia").val();
			requestSolucionDeincidencia["accionSolucionDeIncidencia"] = $("#accionSolucionDeIncidencia").val();
			requestSolucionDeincidencia["activoSolucionDeIncidencia"] = $("#activoSolucionDeIncidencia").val();
			
			var total = $("#etapaSolucionDeIncidencia").val().length * $("#accionSolucionDeIncidencia").val().length * $("#activoSolucionDeIncidencia").val().length;
			
			if(total > 0){
				$.ajax({
				    url: "http://erpge.getsandbox.com/gme/api/soluciondeincidencia/add",
				    type: "POST",
				    dataType: 'json',
				    data: JSON.stringify(requestSolucionDeincidencia),
				    contentType : "application/json",
				    success: function(data) {
						console.log("Success = " + JSON.stringify(data) );
						$('#tbl_soluciondeincidencia tbody').empty();
						listarSolucionDeIncidencia();
						$('#frm_soluciondeincidencia')[0].reset();
				    },
				    error: function() { 
				    		//alert('Failed!'); 
				    }
				});
			}else{
				$('#msj_soluciondeincidencia').addClass('alert alert-danger text-center').html('<strong>Error!</strong> <strong>Complete los Datos</strong>').show(10).delay(3500).hide(10);
			}
			
		}else{
			//$('#msj_material').html('EDITAR');
			var requestSolucionDeincidencia = new Object();
			requestSolucionDeincidencia["idSolucionDeIncidencia"] = $("#idSolucionDeIncidencia").val();
			requestSolucionDeincidencia["etapaSolucionDeIncidencia"]  = $("#etapaSolucionDeIncidencia").val();
			requestSolucionDeincidencia["accionSolucionDeIncidencia"] = $("#accionSolucionDeIncidencia").val();
			requestSolucionDeincidencia["activoSolucionDeIncidencia"] = $("#activoSolucionDeIncidencia").val();
			
			var total = $("#etapaSolucionDeIncidencia").val().length * $("#accionSolucionDeIncidencia").val().length * $("#activoSolucionDeIncidencia").val().length;
			
			if(total > 0){
				$.ajax({
				    url: "http://erpge.getsandbox.com/gme/api/soluciondeincidencia/upd",
				    type: "POST",
				    dataType: 'json',
				    data: JSON.stringify(requestSolucionDeincidencia),
				    contentType : "application/json",
				    success: function(data) {
						console.log("Success = " + JSON.stringify(data) );
						$('#tbl_soluciondeincidencia tbody').empty();
						listarParametroCalidad();
						$('#frmSolucionDeIncidencia')[0].reset();
				    },
				    error: function() { 
				    		//alert('Failed!'); 
				    	}
				});
			}else{
				$('#msj_soluciondeincidencia').addClass('alert alert-danger text-center').html('<strong>Error!</strong> <strong>Complete los Datos</strong>').show(10).delay(3500).hide(10);
			}
		}
	}
	
	
	function addcentroconsumo(){
		if($("#crtlcentroconsumo").val() == 'A'){
			
			var requestcentroconsumo = new Object();
			requestcentroconsumo["codigocentroconsumo"] = $("#codigocentroconsumo").val();
			requestcentroconsumo["nombrecentroconsumo"]  = $("#nombrecentroconsumo").val();
			requestcentroconsumo["ubicacioncentroconsumo"] = $("#ubicacioncentroconsumo").val();
			requestcentroconsumo["responsablecentroconsumo"] = $("#responsablecentroconsumo").val();
			requestcentroconsumo["activocentroconsumo"] = $("#activocentroconsumo").val();
			
			var total = $("#nombrecentroconsumo").val().length * $("#ubicacioncentroconsumo").val().length * $("#responsablecentroconsumo").val().length * $("#activocentroconsumo").val().length;
			
			if(total > 0){
				$.ajax({
				    url: "http://erpge.getsandbox.com/gme/api/centroconsumo/add",
				    type: "POST",
				    dataType: 'json',
				    data: JSON.stringify(requestcentroconsumo),
				    contentType : "application/json",
				    success: function(data) {
						console.log("Success = " + JSON.stringify(data) );
						$('#tbl_centroconsumo tbody').empty();
						listarSolucionDeIncidencia();
						$('#frmcentroconsumo')[0].reset();
				    },
				    error: function() { 
				    		//alert('Failed!'); 
				    }
				});
			}else{
				$('#msj_centroconsumo').addClass('alert alert-danger text-center').html('<strong>Error!</strong> <strong>Complete los Datos</strong>').show(10).delay(3500).hide(10);
			}
			
		}else{
			//$('#msj_material').html('EDITAR');
			var requestcentroconsumo = new Object();
			requestcentroconsumo["idcentroconsumo"] = $("#idcentroconsumo").val();
			requestcentroconsumo["nombrecentroconsumo"]  = $("#nombrecentroconsumo").val();
			requestcentroconsumo["ubicacioncentroconsumo"] = $("#ubicacioncentroconsumo").val();
			requestcentroconsumo["responsablecentroconsumo"] = $("#responsablecentroconsumo").val();
			requestcentroconsumo["activocentroconsumo"] = $("#activocentroconsumo").val();
			
			var total = $("#nombrecentroconsumo").val().length * $("#ubicacioncentroconsumo").val().length * $("#responsablecentroconsumo").val().length * $("#activocentroconsumo").val().length;
			
			if(total > 0){
				$.ajax({
				    url: "http://erpge.getsandbox.com/gme/api/centroconsumo/upd",
				    type: "POST",
				    dataType: 'json',
				    data: JSON.stringify(requestcentroconsumo),
				    contentType : "application/json",
				    success: function(data) {
						console.log("Success = " + JSON.stringify(data) );
						$('#tbl_centroconsumo tbody').empty();
						listarcentroconsumo();
						$('#frmcentroconsumo')[0].reset();
				    },
				    error: function() { 
				    		//alert('Failed!'); 
				    	}
				});
			}else{
				$('#msj_centroconsumo').addClass('alert alert-danger text-center').html('<strong>Error!</strong> <strong>Complete los Datos</strong>').show(10).delay(3500).hide(10);
			}
		}
	}
	
	
	function addEtapaControl(){
		if($("#crtlEtapaControl").val() == 'A'){
			var requestEtapaControl = new Object();
			requestEtapaControl["idEtapaControl"] = $("#idEtapaControl").val();
			requestEtapaControl["nombreEtapaControl"] = $("#nombreEtapaControl").val();
			requestEtapaControl["activoEtapaControl"] = $("#activoEtapaControl").val();
			
			var total = $("#nombreEtapaControl").val().length * $("#activoEtapaControl").val().length;
			
			if(total > 0){
				$.ajax({
				    url: "http://erpge.getsandbox.com/gme/api/etapacontrol/add",
				    type: "POST",
				    dataType: 'json',
				    data: JSON.stringify(requestEtapaControl),
				    contentType : "application/json",
				    success: function(data) {
						console.log("Success = " + JSON.stringify(data) );
						$('#tbl_etapacontrol tbody').empty();
						listarParametroCalidad();
						$('#frmEtapaControl')[0].reset();
				    },
				    error: function() { 
				    		//alert('Failed!'); 
				    }
				});
			}else{
				$('#msj_etapacontrol').addClass('alert alert-danger text-center').html('<strong>Error!</strong> <strong>Complete los Datos</strong>').show(10).delay(3500).hide(10);
			}
			
		}else{
			
			var requestEtapaControl = new Object();
			requestParametrocalidad["idEtapaControl"] = $("#idEtapaControl").val();
			requestEtapaControl["nombreEtapaControl"] = $("#nombreEtapaControl").val();
			requestEtapaControl["activoEtapaControl"] = $("#activoEtapaControl").val();
			
			var total = $("#nombreEtapaControl").val().length * $("#activoEtapaControl").val().length;
			
			if(total > 0){
				$.ajax({
				    url: "http://erpge.getsandbox.com/gme/api/etapacontrol/upd",
				    type: "POST",
				    dataType: 'json',
				    data: JSON.stringify(requestEtapaControl),
				    contentType : "application/json",
				    success: function(data) {
						console.log("Success = " + JSON.stringify(data) );
						$('#tbl_etapacontrol tbody').empty();
						listarParametroCalidad();
						$('#frmEtapaControl')[0].reset();
				    },
				    error: function() { 
				    		//alert('Failed!'); 
				    	}
				});
			}else{
				$('#msj_etapacontrol').addClass('alert alert-danger text-center').html('<strong>Error!</strong> <strong>Complete los Datos</strong>').show(10).delay(3500).hide(10);
			}
		}
	}
	
	
	function addCargo(){
		if($("#crtlCargo").val() == 'A'){
			var requestCargo = new Object();
			requestCargo["idCargo"] = $("#idCargo").val();
			requestCargo["nombreCargo"] = $("#nombreCargo").val();
			requestCargo["activoCargo"] = $("#estadoCargo").val();
			
			var total = $("#idCargo").val().length * $("#nombreCargo").val().length;
			
			if(total > 0){
				$.ajax({
				    url: "http://erpge.getsandbox.com/gme/api/cargo/add",
				    type: "POST",
				    dataType: 'json',
				    data: JSON.stringify(requestCargo),
				    contentType : "application/json",
				    success: function(data) {
						console.log("Success = " + JSON.stringify(data) );
						$('#tbl_cargo tbody').empty();
						listarCargo();
						$('#frmCargo')[0].reset();
				    },
				    error: function() { 
				    		//alert('Failed!'); 
				    }
				});
			}else{
				$('#msj_cargo').addClass('alert alert-danger text-center').html('<strong>Error!</strong> <strong>Complete los Datos</strong>').show(10).delay(3500).hide(10);
			}
			
		}else{
			//$('#msj_material').html('EDITAR');
			var requestCargo = new Object();
			requestCargo["idCargo"] = $("#idCargo").val();
			requestCargo["nombreCargo"] = $("#nombreCargo").val();
			requestCargo["activoCargo"] = $("#estadoCargo").val();
			
			var total = $("#nombreCargo").val().length * $("#estadoCargo").val().length;
			
			if(total > 0){
				$.ajax({
				    url: "http://erpge.getsandbox.com/gme/api/cargo/upd",
				    type: "POST",
				    dataType: 'json',
				    data: JSON.stringify(requestCargo),
				    contentType : "application/json",
				    success: function(data) {
						console.log("Success = " + JSON.stringify(data) );
						$('#tbl_cargo tbody').empty();
						listarParametroCalidad();
						$('#frmCargo')[0].reset();
				    },
				    error: function() { 
				    		//alert('Failed!'); 
				    	}
				});
			}else{
				$('#msj_cargo').addClass('alert alert-danger text-center').html('<strong>Error!</strong> <strong>Complete los Datos</strong>').show(10).delay(3500).hide(10);
			}
		}
	}
	
				function tipoMateriales(){
						
						if($("#tipoMaterial").val() == 'A'){
							$('#vistaAgrupados').attr('href','#modal_agrupados');
							var texto = $("#tipoMaterial :selected").text();
							$('#titulo_tipo').html('<b>'+texto+'</b>');
							$('#tbl_material_agrupados tbody').empty();
							$('#modal_agrupados').modal('show');
							$.ajax({
								type : "GET",
								url : "http://erpge.getsandbox.com/gme/api/material/",
								success: function(result){
									$.each(result.material, function(i, material){
										
										var customerRow = '<tr>' +
												'<td>  <input type="checkbox" id="material_'+material.idMaterial+'" class="" onclick="disableCheck('+material.idMaterial+');"></td>'+
												'<td>' + material.codigoMaterial + '</td>' +
												'<td>' + material.nombreMaterial + '</td>' +
												'<td>  <input type="text" id="cantidad_'+material.idMaterial+'" class="form-control form-control-sm" placeholder="Cantidad" disabled=""></td>'+
												'</tr>';
											
										$('#tbl_material_agrupados tbody').append(customerRow);
								    });
										$('#tbl_material_agrupados').dataTable();
									},
									
								error : function(e){
										alert("ERROR: ", e);
										console.log("ERROR: ", e);
								}
							});
						}else{
							$('#vistaAgrupados').removeAttr("href");
						}
					}
	<!-- ************************************************************************************************************** -->
	<!-- JQUERY DELETE  -->
	<!-- ************************************************************************************************************** -->
	
	function deleteMaterial(id){
		var requestMaterial = new Object();
		requestMaterial["idMaterial"] = id;
		
			$.ajax({
			    url: "http://erpge.getsandbox.com/gme/api/material/del",
			    type: "POST",
			    dataType: 'json',
			    data: JSON.stringify(requestMaterial),
			    contentType : "application/json",
			    success: function(data) {
					console.log("Success = " + JSON.stringify(data) );
					$('#tbl_material tbody').empty();
					listarMaterial();
			    },
			    error: function() { 
			    		//alert('Failed!'); 
			    	}
			});
		
	 }
	
	 
	function deleteFamilia(id){
		var requestFamilia = new Object();
		requestFamilia["idFamilia"] = id;
		
			$.ajax({
			    url: "http://erpge.getsandbox.com/gme/api/familia/del",
			    type: "POST",
			    dataType: 'json',
			    data: JSON.stringify(requestFamilia),
			    contentType : "application/json",
			    success: function(data) {
					console.log("Success = " + JSON.stringify(data) );
					$('#tbl_familia tbody').empty();
					listarFamilia();
			    },
			    error: function() { 
			    		//alert('Failed!'); 
			    	}
			});
		
	 }
	
	 
	function deleteClase(id){
		var requestClase = new Object();
		requestClase["idClase"] = id;
		
			$.ajax({
			    url: "http://erpge.getsandbox.com/gme/api/clase/del",
			    type: "POST",
			    dataType: 'json',
			    data: JSON.stringify(requestClase),
			    contentType : "application/json",
			    success: function(data) {
					console.log("Success = " + JSON.stringify(data) );
					$('#tbl_clase tbody').empty();
					listarClase();
			    },
			    error: function() { 
			    		//alert('Failed!'); 
			    	}
			});
		
	 }
	
	
	function deleteAlmacen(id){
		var requestAlmacen = new Object();
		requestAlmacen["idAlmacen"] = id;
		
			$.ajax({
			    url: "http://erpge.getsandbox.com/gme/api/almacen/del",
			    type: "POST",
			    dataType: 'json',
			    data: JSON.stringify(requestAlmacen),
			    contentType : "application/json",
			    success: function(data) {
					console.log("Success = " + JSON.stringify(data) );
					$('#tbl_almacen tbody').empty();
					listarAlmacen();
			    },
			    error: function() { 
			    		//alert('Failed!'); 
			    	}
			});
		
	 }
	
	
	function deleteProveedorn(id){
		var requestProveedor = new Object();
		requestProveedor["idProveedor"] = id;
		
			$.ajax({
			    url: "http://erpge.getsandbox.com/gme/api/proveedor/del",
			    type: "POST",
			    dataType: 'json',
			    data: JSON.stringify(requestProveedor),
			    contentType : "application/json",
			    success: function(data) {
					console.log("Success = " + JSON.stringify(data) );
					$('#tbl_proveedor tbody').empty();
					listarProveedor();
			    },
			    error: function() { 
			    		//alert('Failed!'); 
			    	}
			});
		
	 }
	
	
	function deletePersonal(id){
		var requestPersonal = new Object();
		requestPersonal["idPersonal"] = id;
		
			$.ajax({
			    url: "http://erpge.getsandbox.com/gme/api/personal/del",
			    type: "POST",
			    dataType: 'json',
			    data: JSON.stringify(requestPersonal),
			    contentType : "application/json",
			    success: function(data) {
					console.log("Success = " + JSON.stringify(data) );
					$('#tbl_personal tbody').empty();
					listarPersonal();
			    },
			    error: function() { 
			    		//alert('Failed!'); 
			    	}
			});
		
	 }
	
	
	function deleteParametroCalidad(id){
		var requestParametroCalidad = new Object();
		requestParametroCalidad["idParametroCalidad"] = id;
		
			$.ajax({
			    url: "http://erpge.getsandbox.com/gme/api/parametrocalidad/del",
			    type: "POST",
			    dataType: 'json',
			    data: JSON.stringify(requestParametroCalidad),
			    contentType : "application/json",
			    success: function(data) {
					console.log("Success = " + JSON.stringify(data) );
					$('#tbl_parametrocalidad tbody').empty();
					listarParametroCalidad();
			    },
			    error: function() { 
			    		//alert('Failed!'); 
			    	}
			});
		
	 }
	
	
	function deleteCentroConsumo(id){
		var requestCentroConsumo = new Object();
		requestCentroConsumo["idcentroconsumo"] = id;
		
			$.ajax({
			    url: "http://erpge.getsandbox.com/gme/api/centroconsumo/del",
			    type: "POST",
			    dataType: 'json',
			    data: JSON.stringify(requestCentroConsumo),
			    contentType : "application/json",
			    success: function(data) {
					console.log("Success = " + JSON.stringify(data) );
					$('#tbl_centroconsumo tbody').empty();
					listarcentroconsumo();
			    },
			    error: function() { 
			    		//alert('Failed!'); 
			    	}
			});
		
	 }
	
	
	function deleteSolucionDeIncidencia(id){
		var requestSolucionDeIncidencia = new Object();
		requestSolucionDeIncidencia["idSolucionDeIncidencia"] = id;
		
			$.ajax({
			    url: "http://erpge.getsandbox.com/gme/api/soluciondeincidencia/del",
			    type: "POST",
			    dataType: 'json',
			    data: JSON.stringify(requestSolucionDeIncidencia),
			    contentType : "application/json",
			    success: function(data) {
					console.log("Success = " + JSON.stringify(data) );
					$('#tbl_soluciondeincidencia tbody').empty();
					listarSolucionDeIncidencia();
			    },
			    error: function() { 
			    		//alert('Failed!'); 
			    	}
			});
		
	 }
	
	
	function deleteEtapaControl(id){
		var requestEtapaControl = new Object();
		requestEtapaControl["idEtapaControl"] = id;
	
			$.ajax({
			    url: "http://erpge.getsandbox.com/gme/api/etapacontrol/del",
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
	
	
	function deleteCargo(id){
		var requestCargo = new Object();
		requestCargo["idCargo"] = id;
	
			$.ajax({
			    url: "http://erpge.getsandbox.com/gme/api/cargo/del",
			    type: "POST",
			    dataType: 'json',
			    data: JSON.stringify(requestCargo),
			    contentType : "application/json",
			    success: function(data) {
					console.log("Success = " + JSON.stringify(data) );
					$('#tbl_cargo tbody').empty();
					listarCargo();
			    },
			    error: function() { 
			    		//alert('Failed!'); 
			    	}
			});
		
	 }
	
	
	<!-- ************************************************************************************************************** -->
	<!-- JQUERY PARA OBJETOS SELECT -->
	<!-- ************************************************************************************************************** -->	
	
	//COMBO FAMILIA DE MATERIAL.
	function cboFamilia(){
		$.ajax({
		    type: "GET",
		    url: 'http://erpge.getsandbox.com/gme/api/familia/', 
		    success: function(result){
		      $.each(result.familia,function(i, familia) {
		        $("#familiaMaterial").append('<option value='+ familia.idFamilia +'>'+ familia.nombreFamilia +'</option>');
		        $("#familiaClase").append('<option value='+ familia.idFamilia +'>'+ familia.nombreFamilia +'</option>');
		      });        
		    },
		    error: function(data) {
		    	alert("ERROR: ", e);
				console.log("ERROR: ", e);
		    }
		  });
	}
	//************************
	
	
	//COMBO CLASE DE MATERIAL.
	function cboClase(){
		$.ajax({
		    type: "GET",
		    url: 'http://erpge.getsandbox.com/gme/api/clase/', 
		    success: function(result){
		      $.each(result.clase,function(i, clase) {
		        $("#claseMaterial").append('<option value='+ clase.idClase +'>'+ clase.nombreClase +'</option>');
		      });        
		    },
		    error: function(data) {
		    	alert("ERROR: ", e);
				console.log("ERROR: ", e);
		    }
		  });
	}
	//************************
	

	
	//COMBO CENTRO DE CONSUMO.
	function cboCentroConsumo(){
		$.ajax({
		    type: "GET",
		    url: 'http://erpge.getsandbox.com/gme/api/centroconsumo/', 
		    success: function(result){
		      $.each(result.centroconsumo,function(i, centroconsumo) {
		        $("#centroConsumo").append('<option value='+ centroconsumo.idCentroConsumo +'>'+ centroconsumo.nombreCentroConsumo +'</option>');
		        $("#busquedaCentroConsumo").append('<option value='+ centroconsumo.idCentroConsumo +'>'+ centroconsumo.nombreCentroConsumo +'</option>');
		        $("#areaPersonal").append('<option value='+ centroconsumo.idCentroConsumo +'>'+ centroconsumo.nombreCentroConsumo +'</option>');
		      });        
		    },
		    error: function(data) {
		    	alert("ERROR: ", e);
				console.log("ERROR: ", e);
		    }
		  });
	}
	//************************
	
	//COMBO PERSONAL.
	function cboPersonal(){
		$.ajax({
		    type: "GET",
		    url: 'http://erpge.getsandbox.com/gme/api/personal/', 
		    success: function(result){
		      $.each(result.personal,function(i, personal) {
		        $("#solicitante").append('<option value='+ personal.idPersonal +'>'+ personal.nombrePersonal +'</option>');
		      });        
		    },
		    error: function(data) {
		    	alert("ERROR: ", e);
				console.log("ERROR: ", e);
		    }
		  });
	}
	
	//************************

	//COMBO ALMACEN.
	function cboAlmacen(){
		$.ajax({
		    type: "GET",
		    url: 'http://erpge.getsandbox.com/gme/api/almacen/', 
		    success: function(result){
		      $.each(result.almacen,function(i, almacen) {
		        $("#almacen").append('<option value='+ almacen.idAlmacen +'>'+ almacen.nombreAlmacen +'</option>');
		      });        
		    },
		    error: function(data) {
		    	alert("ERROR: ", e);
				console.log("ERROR: ", e);
		    }
		  });
	}
	//************************
	
	//COMBO CARGOS DE PERSONAL
	function cboCargo(){
		$.ajax({
		    type: "GET",
		    url: 'http://erpge.getsandbox.com/gme/api/cargo/', 
		    success: function(result){
		      $.each(result.cargo,function(i, cargo) {
		        $("#cargoPersonal").append('<option value='+ cargo.idCargo +'>'+ cargo.nombreCargo +'</option>');
		        });        
		    },
		    error: function(data) {
		    	alert("ERROR: ", e);
				console.log("ERROR: ", e);
		    }
		  });
	}
	//************************
	
	
	//COMBO ETAPAS DE CONTROL
	function cboEtapas(){
		$.ajax({
		    type: "GET",
		    url: 'http://erpge.getsandbox.com/gme/api/etapacontrol/', 
		    success: function(result){
		      $.each(result.etapacontrol,function(i, etapacontrol) {
		        $("#listaEtapaI").append('<option value='+ etapacontrol.idEtapaControl +'>'+ etapacontrol.nombreEtapaControl +'</option>');
		        $("#listaEtapaC").append('<option value='+ etapacontrol.idEtapaControl +'>'+ etapacontrol.nombreEtapaControl +'</option>');
		        });        
		    },
		    error: function(data) {
		    	alert("ERROR: ", e);
				console.log("ERROR: ", e);
		    }
		  });
	}
	//************************
	
	//************************
	
	function disableCheck(valor){
		if($("#material_"+valor).is(":checked")){
			$("#cantidad_"+valor).attr('disabled',false).focus();
	        	$("#cantidad_"+valor).val($(this).prop("id"));
		}else{
			$("#cantidad_"+valor).attr('disabled',true).val('');
		}
	}
	
	
	<!-- ************************************************************************************************************** -->
	<!-- JQUERY PARA VENTANA INCIDENCIAS -->
	<!-- ************************************************************************************************************** -->	

	function modalIncidencia(id){
		if(id == 1){
			$("#viewNroInc").hide();
			$("#titulo_incid").html('<strong>INCIDENCIA DE RECEPCION - C&Eacute;DULA</strong>');
			$("#ctrlIncidencia").val('RC');
			
		}else if(id == 2){
			$("#viewNroInc").show();
			$("#titulo_incid").html('<strong>INCIDENCIA DE CONTROL DE CALIDAD - C&Eacute;DULA</strong>');
			$("#ctrlIncidencia").val('CC');
			
		}else if(id == 3){
			$("#viewNroInc").hide();
			$("#titulo_incid").html('<strong>INCIDENCIA DE EMPAQUETADO - C&Eacute;DULA</strong>');
			$("#ctrlIncidencia").val('EC');
			
		}else if(id == 4){
			$("#titulo_incid").html('<strong>INCIDENCIA DE RECEPCION - ACTA PADRON</strong>');
			$("#ctrlIncidencia").val('RA');
		
		}else if(id == 5){
			$("#titulo_incid").html('<strong>INCIDENCIA DE EMPAREJAMIENTO - ACTA PADRON</strong>');
			$("#ctrlIncidencia").val('AE');
			
		}else if(id == 6){
			$("#titulo_incid").html('<strong>INCIDENCIA DE RECEPCION - TOKEN</strong>');
			$("#ctrlIncidencia").val('RT');
		
		}else if(id == 7){
			$("#titulo_incid").html('<strong>INCIDENCIA DE RECEPCION - CARTEL DE CANDIDATOS</strong>');
			$("#ctrlIncidencia").val('RU');
		
		}else if(id == 8){
			$("#titulo_incid").html('<strong>INCIDENCIA DE RECEPCION - CARTILLA BRAILLE</strong>');
			$("#ctrlIncidencia").val('RB');
			
		}
	}
	
	
	function addIncidenciaCed(){
		
			var requestIncidencia = new Object();
			requestIncidencia["mesaIncidencia"] = $("#mesaIncidencia").val();
			requestIncidencia["idParametroIncidencia"] = $("#tipoIncidencia").val();
			requestIncidencia["estadoIncidencia"] = '0'; //ESTADO NO RESUELTO
				if($("#ctrlIncidencia").val() == 'RC'){
					requestIncidencia["idEtapaIncidencia"] = '1';
				}else if($("#ctrlIncidencia").val() == 'CC'){
					requestIncidencia["idEtapaIncidencia"] = '2';
					requestIncidencia["cantidadIncidencia"] = $("#cantidadIncidencia").val();
				}else{
					requestIncidencia["idEtapaIncidencia"] = '3';
				}
				
			var total = $("#tipoIncidencia").val().length;
			
			if(total > 0){
				$.ajax({
				    url: "http://erpge.getsandbox.com/gme/api/incidencia/add",
				    type: "POST",
				    dataType: 'json',
				    data: JSON.stringify(requestIncidencia),
				    contentType : "application/json",
				    success: function(data) {
						console.log("Success = " + JSON.stringify(data) );
						$('#frmIncidencia')[0].reset();
				    },
				    error: function() { 
				    		//alert('Failed!'); 
				    }
				});
			}else{
				$('#msj_incidencia').addClass('alert alert-danger text-center').html('<strong>Error!</strong> <strong>Complete los Datos</strong>').show(10).delay(3500).hide(10);
			}
	}
	
	
	function addIncidenciaActa(){
		
			var requestIncidencia = new Object();
			requestIncidencia["mesaIncidencia"] = $("#mesaIncidencia").val();
			requestIncidencia["idParametroIncidencia"] = $("#tipoIncidencia").val();
			requestIncidencia["estadoIncidencia"] = '0'; //ESTADO NO RESUELTO
				if($("#ctrlIncidencia").val() == 'R'){
					requestIncidencia["idEtapaIncidencia"] = '1';
				}else if($("#ctrlIncidencia").val() == 'C'){
					requestIncidencia["idEtapaIncidencia"] = '2';
					requestIncidencia["cantidadIncidencia"] = $("#cantidadIncidencia").val();
				}else{
					requestIncidencia["idEtapaIncidencia"] = '3';
				}
				
			var total = $("#tipoIncidencia").val().length;
			
			if(total > 0){
				$.ajax({
				    url: "http://erpge.getsandbox.com/gme/api/incidencia/add",
				    type: "POST",
				    dataType: 'json',
				    data: JSON.stringify(requestIncidencia),
				    contentType : "application/json",
				    success: function(data) {
						console.log("Success = " + JSON.stringify(data) );
						$('#frmIncidencia')[0].reset();
				    },
				    error: function() { 
				    		//alert('Failed!'); 
				    }
				});
			}else{
				$('#msj_incidencia').addClass('alert alert-danger text-center').html('<strong>Error!</strong> <strong>Complete los Datos</strong>').show(10).delay(3500).hide(10);
			}
	}
	
	
	
	function modalAvance(mod,etapa,pref){
		
		var titulo = $("#titulo_etapa").html();
		$('#titulo_avance').html(titulo);
		$('#subtitulo_avance').html('<strong>'+pref+'</strong>');
		$(".avance").attr("id","tbl_avance_"+pref.toLowerCase());
		$('#tbl_avance_'+pref.toLowerCase()+' tbody').empty();
	
		
		$.ajax({
			type : "GET",
			url : "http://erpge.getsandbox.com/gme/api/materialescriticos/"+mod.toLowerCase()+"/"+etapa+"/"+pref.toLowerCase()+"/",
			success: function(result){
				var count = 1;
				$.each(result.avance, function(i, avance){
					var customerRow = '<tr>' +
							'<td>' + (count++) + '</td>' +
							'<td>' + avance.soltec + '</td>' +
							'<td>' + avance.departamento + '</td>' +
							'<td>' + avance.provincia + '</td>' +
							'<td>' + avance.distrito + '</td>' +
							'<td>' + avance.mesa + '</td>' +
							'<td>' + avance.nroElectores + '</tr>';
						
					$('#tbl_avance_'+pref.toLowerCase()+' tbody').append(customerRow);

			    });					
					$('#tbl_avance_'+pref.toLowerCase()).dataTable();
				},
				
			error : function(e){
					alert("ERROR: FALTANTE", e);
					console.log("ERROR: ", e);
			}
		});
	}
	
//---FUNCION MOSTRAR FORMULARIO FM04-----------GCP------------------------------------------
	
	function mostrarFm04(tipo){
		if (tipo==0){
			$('#FM04GGE').show();
			}
		 else {
			$('#FM04GGE').hide();
		 }
		
	}
	//----FUNCION SOLICITAR MATERIALES A - B - C----------GCP------------------------------------------	
	function solicitarMaterial(){

			$('#tbl_MatRegistrado tbody').empty();
			$('#modal_materiales').modal('show');
			$.ajax({
				type : "GET",
				url : "http://erpge.getsandbox.com/gme/api/stockmaterial/",
				success: function(result){
					$.each(result.stockmaterial, function(i, stockmaterial){
						
						var customerRow = '<tr>' +
								'<td>  <input type="checkbox" id="stockmaterial_'+stockmaterial.idMaterial+'" class="" onclick="activarCantProd('+stockmaterial.idMaterial+');"></td>'+
								'<td>' + stockmaterial.familiaMaterial + '</td>' +
								'<td>' + stockmaterial.claseMaterial + '</td>' +
								'<td>' + stockmaterial.nombreMaterial + '</td>' +
								'<td>' + stockmaterial.unidadMedidaMaterial + '</td>' +
								'<td>' + stockmaterial.stockA + '</td>' +
								'<td>' + stockmaterial.stockB + '</td>' +
								'<td>' + stockmaterial.stockC + '</td>' +
								'<td align="center">' + stockmaterial.stockC + '</td>' +
								'<td>  <input type="text" size="7" id="cantidadA_'+stockmaterial.idMaterial+'" class="form-control form-control-sm" placeholder="Cant. A" disabled=""></td>'+
								'<td>  <input type="text" size="7" id="cantidadB_'+stockmaterial.idMaterial+'" class="form-control form-control-sm" placeholder="Cant. B" disabled=""></td>'+
								'<td>  <input type="text" size="7" id="cantidadC_'+stockmaterial.idMaterial+'" class="form-control form-control-sm" placeholder="Cant. C" disabled=""></td>'+
								'</tr>';
							
						$('#tbl_MatRegistrado tbody').append(customerRow);
				    });
						$('#tbl_MatRegistrado').dataTable();
					},
					
				error : function(e){
						alert("ERROR: ", e);
						console.log("ERROR: ", e);
				}
			});
		
	}
	
	function activarCantProd(valor){
		if($("#stockmaterial_"+valor).is(":checked")){
			$("#cantidadA_"+valor).val($(this).prop("id"));
	        $("#cantidadB_"+valor).val($(this).prop("id"));
	        $("#cantidadC_"+valor).val($(this).prop("id"));
	        $("#cantidadC_"+valor).attr('disabled',false).focus();
	        $("#cantidadB_"+valor).attr('disabled',false).focus();
	        $("#cantidadA_"+valor).attr('disabled',false).focus();
		}else{
			$("#cantidadA_"+valor).attr('disabled',true).val('');
			$("#cantidadB_"+valor).attr('disabled',true).val('');
			$("#cantidadC_"+valor).attr('disabled',true).val('');
		}
	}