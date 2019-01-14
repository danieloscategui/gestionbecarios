<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<div style="margin-bottom:2px; margin-top: 5px;">
	<input id="cboBeca" class="easyui-combobox" name="beca" style="width:100%;" >
</div>

<table id="dgBecarios" title="Becarios" class="easyui-datagrid" style="width:100%; height: 550px;">
    <thead>
        <tr>
            <th data-options="field:'id', hidden:true">ID</th>
            <th data-options="field: 'dni'">DNI</th>
            <th data-options="field:'nombreCompleto', width:50">Becario</th>
            <th data-options="field:'sexo'">Sexo</th>
            <th data-options="field:'numeroExpediente'">Expediente</th>
            <th data-options="field:'beca'">Beca</th>
            <th data-options="field:'carrera'">Carrera</th>
            <th data-options="field:'estado'">Estado</th>
            <th data-options="field:'asesor'">Asesor</th>
        </tr>
    </thead>
</table>
<div id="buttons">
	<table style="border-spacing:0">
	    <tr>
	        <td>
	            <input id="sbDNI" class="easyui-searchbox" style="width:150px" max="8">
	        </td>
	        <td>
	            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()"></a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()"></a>
	        </td>
	    </tr>
	</table>
</div>



<script type="text/javascript">

function newUser(){
	alert('newUser');
}

function editUser(){
	var idBeca = $('#cboBeca').combobox('getValue');
	var row = $('#dgBecarios').datagrid('getSelected');
	if (idBeca != null && idBeca > 0 && row != null){
		//alert('editUser-row: '+row.id);	
		$(location).attr('href', row.id);
	}
	//window.location.href = "http://example.com/new_url";
}



$(function(){
	
	var cboBeca = $('#cboBeca').combobox({
		url: 'api/beca',
		method: 'get',
        valueField: 'id',
        textField: 'becaName',
        label: 'Beca',
        labelPosition: 'before',
        editable: false,
        onSelect: function(rec){
        	var dni = $('#sbDNI').searchbox('getValue');
        	var url;
        	if (dni.length == 8){
				url = 'api/becario/'+dni+'/beca/'+rec.id;	
        	} else {
	        	url = 'api/becario/beca/'+rec.id;
        	}
        	$('#dgBecarios').datagrid('reload', url);
        }
	});
	
    var dg = $('#dgBecarios').datagrid({
    	method: 'get',
    	idField: 'id',
    	loadMsg: 'Procesando, espere por favor ...',
    	emptyMsg: 'Seleccione un beca por favor.',
        pagination:true, pageSize:'10',
        rownumbers:true, fitColumns:true, singleSelect:true,
        pagePosition:'top',
        border:false,
        autoRowHeight: false
    });
    
    var pager = $('#dgBecarios').datagrid().datagrid('getPager');
    pager.pagination({
    	buttons: $('#buttons'),
    	beforePageText: 'Página',
    	afterPageText: 'de {pages}',
        displayMsg: 'Mostrando {from} al {to} de {total} registros'
    });
    
    //dg.datagrid('enableFilter');
    
    var sbDNI = $('#sbDNI').searchbox({
	    	searcher: function(value){
	    		var idBeca = $('#cboBeca').combobox('getValue');
	    		var dni = value;
	    		
	    		if (idBeca > 0 && dni.length == 8){
	    			var url = 'api/becario/'+dni+'/beca/'+idBeca;
	        		$('#dgBecarios').datagrid('reload', url);
	    		}
	    		if (idBeca > 0 && dni.length == 0){
	    			var url = 'api/becario/beca/'+idBeca;
	        		$('#dgBecarios').datagrid('reload', url);			
	    		}
	    		if (idBeca == 0){
	    			  $.messager.alert({
	    				  title: 'Gestión Becarios',
	    				  msg: 'Seleccione una beca por favor.',
	    				  icon: 'info',
	    			  });
	    		}
	    	},
	    	prompt: 'Ingrese DNI'
    });
    
    sbDNI.textbox('textbox').bind('keypress keyup blur', function(event){
    	$(this).val($(this).val().replace(/[^\d].+/, ""));
	    if ((event.which < 48 || event.which > 57)) {
	        event.preventDefault();
	    }
    }).attr('maxlength',8);

});
</script>
<!-- 
<script type="text/javascript" src="<c:url value='/js/asesor.js'/>" ></script>
 -->
