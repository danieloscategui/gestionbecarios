$(document).ready(function(){
	var root = '/EE-INEI/'
	var source = {
			datatype: 'json',
			datafields: [
			    {name: 'id', type: 'number'},
			    {name: 'nombre', type:'string'},
			    {name: 'direccion', type:'string'},
			    {name: 'puerta', type:'string'},
			    {name: 'piso', type:'number'},
			    {name: 'manzana', type:'string'}, 
			    {name: 'lote', type:'string'},
			    {name: 'interior', type:'string'},
			    {name: 'empresa', type:'string'},
			    {name: 'observaciones', type:'string'},
            ],
            id: 'id',
            url: root + 'getPersonasJson',
            asyn: true
	};
	
	var dataAdapter = new $.jqx.dataAdapter(source,{
		loadComplete: function(records){
			console.log(records.length);
		}
	});
	
	$('#dataTable').jqxDataTable({
		width: '100%',
		height: '100%',
		source: dataAdapter,
		pageable: true,
		pagerMode: 'advanced',
		altRows: true,
		theme: 'bootstrap',
		selectionMode: 'singleRow',
		showToolbar: true,
		columns:[
		         {text: 'ID', datafield: 'id', width: '3%', cellsalign: 'right'},
		         {text: 'Nombre', datafield: 'nombre', width: '30%'},
		         {text: 'Direccion', datafield: 'direccion', width: '20%'},
		         {text: 'PT', datafield: 'puerta', width: '3%', cellsalign: 'center'},
		         {text: 'PS', datafield: 'piso', width: '3%', cellsalign:'center'},
		         {text: 'MZ', datafield: 'manzana', width: '3%', cellsalign:'center'},
		         {text: 'LT', datafield: 'lote', width: '3%', cellsalign:'center'},
		         {text: 'INT', datafield: 'interior', width: '3%', cellsalign:'center'},
		         {text: 'Empresa', datafield: 'empresa', width: '20%'},
		         {text: 'Observaciones', datafield: 'observaciones', width: '20%'}
	    ]
	});
});


/*var root = '/EE-INEI/'
$(function(){
	$('#grid').w2grid({
		name: 'grid',
		show: {
			toolbar: true,
			toolbarDelete: true
		},
		url: root + 'getPersonasJson',
		method: 'GET',
		columns: [
		   {field: 'id', caption: 'ID', size: '10%'},
		   {field: 'nombre', caption: 'Nombre', size: '30%'},
		   {field: 'direccion', caption: 'Direccion', size: '30%'},
		   {field: 'puerta', caption: 'Puerta', size: '10%'},
		   {field: 'piso', caption: 'Piso', size: '10%'},
		   {field: 'manzana', caption: 'Mz.', size: '10%'},
		   {field: 'lote', caption: 'Lt.', size: '10%'},
		   {field: 'interior', caption: 'Int.', size: '10%'},
		   {field: 'empresa', caption: 'Empresa', size: '30%'},
		   {field: 'observaciones', caption: 'Observaciones', size: '30%'},
		],
		onSelect: function(){
			console.log(w2ui['grid'].getSelection());
		}
	});
	
	$('#form').w2form({
		name: 'form',
		header: 'Persona empadronada',
		url: '/EE-INEI/addPersona',
		fields: [
		     {field: 'id', type: 'text', required: false, html:{caption: 'ID:', attr: 'style="width: 30px"'}},
		     {field: 'nombre', type: 'text', required: true, html:{caption: 'Nombre:', attr: 'style="width: 200px"'}},
		     {field: 'direccion', type: 'text', required: true, html:{caption: 'Direccion:', attr: 'style="width: 200px"'}},
		     {field: 'empresa', type: 'text', required: true, html:{caption: 'Empresa', attr: 'style="width: 200px"'}},
		     {field: 'observaciones', type: 'text', required: false, html:{caption: 'Observaciones:', attr: 'style="width: 200px"'}}
		],
		actions:{}
	});
});
*/
function openPopup(){}