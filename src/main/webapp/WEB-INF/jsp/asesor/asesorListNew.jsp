<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<table id="dg" title="Asesores" class="easyui-datagrid" style="width:800px;height:455px">
	           <!--  url="api/asesor/page"
	            method="get"
	            loadMsg="Procesando, espere por favor ..."
	            toolbar="#toolbar" pagination="true" pageSize="10"
	            rownumbers="true" fitColumns="true" singleSelect="true"
	            pagePosition="bottom"
	            border="false" fit="true"
	            > -->
    <thead>
        <tr>
            <th data-options="field:'id', width:10, hidden:true">ID</th>
            <th data-options="field:'nombre', width:50, sortable:true">Nombre</th>
        </tr>
    </thead>
</table>
<div id="toolbar">
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">Nuevo Asesor</a>
  	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">Editar Asesor</a>
  	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyUser()">Remover Asesor</a>
</div>



<script type="text/javascript">
$(function(){
    var dg = $('#dg').datagrid({
    	url:'api/asesor/page',
    	method: 'get',
    	loadMsg: 'Procesando, espere por favor ...',
        toolbar: '#toolbar', pagination:true, pageSize:'10',
        rownumbers:true, fitColumns:true, singleSelect:true,
        pagePosition:'bottom',
        border:false, fit:true
    });
    
    dg.datagrid('enableFilter')

});
</script>
<script type="text/javascript" src="<c:url value='/js/asesor.js'/>" ></script>
