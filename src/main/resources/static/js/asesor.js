asesor = {
    init: function(){
    	this.list();
    },
    list: function(){
        axios.get("api/asesor")
        .then(function (response) {
        	$('#tbl_asesor tbody').empty();
        	$('#tbl_asesor').dataTable().fnClearTable();
        	$('#tbl_asesor').dataTable().fnDestroy();
        	$.each(response.data, function(i, asesor){
                 var row = '<tr>' +
                                 '<td>' + asesor.nombre + '</td>' +
                                 '<td>  <a data-toggle="modal" href="#modal_asesor" onclick="asesor.view('+ asesor.id + ' )" class="btn btn-info btn-xs"><span class="glyphicon glyphicon-pencil" aria-hidden="true" data-toggle="tooltip" title="Editar"></span></a>'+
                           '</tr>';
                     
                 $('#tbl_asesor tbody').append(row);
            });
            $('#tbl_asesor').DataTable();
        })
        .catch(function (error) {
            console.log(error);
        });  
    },
    add: function(modal){
    	$('#modal_asesor').modal('show');
		$('#titulo_asesor').html('Agregar Asesor');
		$('#form_asesor')[0].reset();
		$('#action').val('A');
    },
    view: function(id){
    	$('#modal_asesor').modal('show');
		$('#titulo_asesor').html('Editar Asesor');
		$('#form_asesor')[0].reset();
		$('#action').val('E');
		
		axios.get("api/asesor/"+id)
			.then(function(response){
				var asesor = response.data
				$('#id').val(asesor.id);
				$('#nombre').val(asesor.nombre);
			})
			.catch(function(response){
				console.log(response)
			});
    },
    save: function(){
    	if ($('#action').val() == 'A') {
    		
    		$.ajax({
    			url:'api/asesor/',
    			method: 'POST',
    			dataType: 'json',
    			data: this.getParams(),
    			contentType: 'application/json',
    			success: function(data){
    				alert('success');
    				this.list();
    			},
    			error: function(){
    				
    			}
    		});
    		
    	}
    	
    	if ($('#action').val() == 'E') {
    		var id = $('#id').val();
//    		axios.put("api/asesor/"+id, this.getParams())
    	}
    },
    getParams : function(){
    	var params = new Object();
    	if ($('#action').val() == 'A'){
    		params['nombre'] = $('#nombre').val();
    	} else {
    		params['id'] = $('#id').val();
    		params['nombre'] = $('#nombre').val();
    	}
    	return JSON.stringify(params);
    }
     
};
