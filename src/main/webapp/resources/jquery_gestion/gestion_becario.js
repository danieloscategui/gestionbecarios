$(document).ready(function(){
	listarBecas();
	
	$('#tbl_becarios').dataTable();
	$('#tbl_becas_registradas').dataTable();
	
	
	$('#cboBeca').change(function(){
		console.log('cboBeca.change');
		var idBeca;
		idBeca = $(this).val();
		if (idBeca > 0) {
			console.log(idBeca);
			listarBecariosPorBeca(idBeca);
		}
	});
	
});

function resetForm(form){
	$('#form_'+form)[0].reset();
}

<!-- ************************************************************************************************************** -->
<!-- Jquery para edicion DE OBJETOS DATATABLE -->
<!-- ************************************************************************************************************** -->
function btnAddOrEdit(ventana, titulo, dato, idBeca){
	resetForm('beca');
	$(ventana).modal('show');
	$('#titulo_'+titulo).html(dato);
	if(idBeca != null){
		$.ajax({
			type: 'GET',
			url: "http://localhost:8082/gestionbecarios/beca/api/get/"+idBeca,
			dataType: 'json',
			success: function(result){
				$('#idBeca').val(idBeca);
				$('#convocatoria').val(result.convocatoria);
				$('#modalidad').val(result.modalidad);
				$('#inicio').val(result.inicio);
				$('#termino').val(result.termino);
			}
		});
	}
}
	
function guardarBeca(){
	var data = {};
	data["idBeca"] = $('#idBeca').val();
	data["convocatoria"] = $('#convocatoria').val();
	data["modalidad"] = $('#modalidad').val();
	data["inicio"] = $('#inicio').val();
	data["termino"] = $('#termino').val();
	
	$.ajax({
		type: 'POST',
		contentType: 'application/json',
		url: "http://localhost:8082/gestionbecarios/beca/api/guardar",
		data: JSON.stringify(data),
		dataType: 'json',
		success: function(data){
			alert(data.msg);
			$('#modal_beca').modal('hide');
			listarBecas();
		}
	});
}
	
<!-- ************************************************************************************************************** -->
<!-- Jquery para carga DE OBJETOS DATATABLE -->
<!-- ************************************************************************************************************** -->
	
//LISTAR DATATABLE DE CARGA DE INFORMACION
function listarBecas(){
	$.ajax({
		type : "GET",
		url : "http://localhost:8082/gestionbecarios/beca/api/cargar_becas",
		success: function(result){
			$('#tbl_becas_registradas tbody').empty();
			$('#tbl_becas_registradas').dataTable().fnClearTable();
			$('#tbl_becas_registradas').dataTable().fnDestroy();
			var count = 1;
			$.each(result, function(i, data){
				var becaRow = '<tr>' +
						'<td>' + (count++) + '</td>' +
						'<td>' + data.convocatoria + '</td>' +
						'<td>' + data.modalidad + '</td>' +
						'<td>' +
							'<a data-toggle="modal" href="" class="btn btn-info btn-xs" onclick="btnAddOrEdit(\'#modal_beca\', \'beca\', \'Editar Beca\', '+ data.idBeca +');" style="margin-left:10px">' +
							'<span class="glyphicon glyphicon-pencil" aria-hidden="true" data-toggle="tooltip" title="Editar"></span></a>' +
							'<a href="" class="btn btn-danger btn-xs" onclick="javascript: deleteBeca('+ data.idBeca +')" style="margin-left:10px">' +
							'<span class="glyphicon glyphicon-trash" aria-hidden="true" data-toggle="tooltip" title="Eliminar"></span></a>' +
						'</td>';
				$('#tbl_becas_registradas tbody').append(becaRow);
		    });
				$('#tbl_becas_registradas').dataTable();
			},
			
		error : function(e){
			alert("ERROR: ", e);
			console.log("ERROR: ", e);
		}
	});
}


function listarBecariosPorBeca(idBeca){
	$.ajax({
		type : "GET",
		url : "http://localhost:8082/gestionbecarios/becario/api/beca/"+idBeca,
		success: function(result){
			$('#tbl_becarios tbody').empty();
			$('#tbl_becarios').dataTable().fnClearTable();
			$('#tbl_becarios').dataTable().fnDestroy();		
			var count = 1;
			$.each(result, function(i, data){
				var becaRow = '<tr>' +
						'<td>' + (count++) + '</td>' +
						'<td>' + data.nombres +' '+ data.apellidos + '</td>' +
						'<td>' + data.carrera + '</td>' +
						'<td>' + data.ies + '</td>' +
						'<td>' + data.sede + '</td>' +
						'<td>' + data.estado + '</td>' +
						'<td>' +
							'<a data-toggle="modal" href="" class="btn btn-info btn-xs" onclick="" style="margin-left:10px">' +
							'<span class="glyphicon glyphicon-pencil" aria-hidden="true" data-toggle="tooltip" title="Editar"></span></a>' +
							'<a href="" class="btn btn-danger btn-xs" onclick="" style="margin-left:10px">' +
							'<span class="glyphicon glyphicon-trash" aria-hidden="true" data-toggle="tooltip" title="Eliminar"></span></a>' +
						'</td>';
				$('#tbl_becarios tbody').append(becaRow);
		    });
				$('#tbl_becarios').dataTable();
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
