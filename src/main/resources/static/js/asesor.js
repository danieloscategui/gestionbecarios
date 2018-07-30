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
                                 '<td>  <a data-toggle="modal" onclick="asesor.view('+ asesor.id + ' )" class="btn btn-info btn-xs"><span class="glyphicon glyphicon-pencil" aria-hidden="true" data-toggle="tooltip" title="Editar"></span></a>'+
                           '</tr>';
                     
                 $('#tbl_asesor tbody').append(row);
            });
            $('#tbl_asesor').dataTable();
        })
        .catch(function (error) {
            console.log(error);
        });  
    },
    
    add: function(){
    	this.showModal('A', 'Agregar Asesor')
    },
    
    view: function(id){
    	this.showModal('E', 'Editar Asesor');

    	axios.get("api/asesor/"+id)
    	.then(response => {
    		var asesor = response.data
    		$('#id').val(asesor.id);
    		$('#nombre').val(asesor.nombre);
    	})
    	.catch(response => {
    		console.log(response)
    	});

    },
    
    save: function(){
    	if ($('#action').val() == 'A') {
    		
    		var options = {
				url: 'api/asesor/',
				method: 'post',
				headers: {'content-type':'application/json'},
				data: this.getParams()
    		};
    		
    		axios(options)
    		.then(response => {
    			this.closeModal();
    			this.list();
    		})
    		.catch(error => {
    			if (error.response.status == 422){
    				var data = error.response.data;
    				console.log(data.fieldErrors);
    				$.each(data.fieldErrors, function(i, fieldError){
    					console.log('message: '+ fieldError.field + ':' + fieldError.message);
    				});
    			}
    			
    			if (error.response.status == 409){
    				alert(error.response.data);
    			}
    		});
    	}//.action-A
    	
    	if ($('#action').val() == 'E') {
    		var id = $('#id').val();
    		var options = {
    				url: 'api/asesor/'+id,
    				method: 'put',
    				headers: {'content-type':'application/json'},
    				data: this.getParams()
        		};
        		
        		axios(options)
        		.then(response => {
        			this.closeModal();
        			this.list();
        		})
        		.catch(response => {
        			if (error.response.status == 422){
        				var data = error.response.data;
        				console.log(data.fieldErrors);
        				$.each(data.fieldErrors, function(i, fieldError){
        					console.log('message: '+ fieldError.field + ':' + fieldError.rejectedValue);
        				});
        			}
        		});
    	}//.action-E
    	
    },
    
    getParams : function(){
    	var params = new Object();
    	params['id'] = ($('#action').val() == 'A')? null:$('#id').val();
    	params['nombre'] = $('#nombre').val();
    	return JSON.stringify(params);
    },
    
    showModal: function(action, title){
    	$('#modal_asesor').modal('show');
    	$('#titulo_asesor').html(title);
    	$('#form_asesor')[0].reset();
    	$('#action').val(action);
    },
    
    closeModal: function(){
    	$('#modal_asesor').modal('hide');
    	$('#form_asesor')[0].reset();
    	$('#action').val('A');
    }
     
};
