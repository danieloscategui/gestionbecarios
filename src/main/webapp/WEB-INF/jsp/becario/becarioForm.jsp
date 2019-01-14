<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!-- Page Heading/Breadcrumbs -->
<h5 class="mte-2 mb-2 mt-5">Becarios
  <small>Edición </small>
</h5>



 <div id="panel-form" class="easyui-panel" title="Becario"  data-options="border:'thin'">
	<div class="form-row col-md-12"  >
		<div class="form-group col-md-1 mb-0">
		   <input class="easyui-maskedbox" name="dni" mask="99999999" style="width: 100%" data-options="label:'DNI:', labelPosition:'top' ">
		</div>
		<div class="form-group col-md-3 mb-0">
		   <input class="easyui-textbox" name="nombre" style="width: 100%" data-options="label:'Nombre:', labelPosition:'top' ">
		</div>
		<div class="form-group col-md-3 mb-0">
		   <input class="easyui-textbox" name="apellido" style="width: 100%" data-options="label:'Apellidos:', labelPosition:'top' ">
		</div>
		<div class="form-group col-md-1 mb-0">
		    <input class="easyui-numberbox" name="edad" style="width:100%" data-options="label:'Edad:', labelPosition:'top', min:18, max:35">
		</div>
		<div class="form-group col-md-2 mb-0">
		    <input class="easyui-datebox" name="fechaNacimiento" style="width:100%" data-options="label:'F. Nac.:', labelPosition:'top' ">
		</div>
	    <div class="form-group col-md-2 mb-0">
		    <select class="easyui-combobox" name="sexo" style="width:100%;" data-options="label:'Sexo:', labelPosition:'top' ">
		    	<option value="0">Seleccione</option>
		    	<option value="F">Femenino</option>
		    	<option value="M">Masculino</option>
		    </select>
	    </div>
	</div>
	<div class="form-row col-md-12">
		<div class="form-group col-md-4 mb-0">
			<input class="easyui-textbox" name="direccion" style="width:100%" data-options="label:'Direccion:', labelPosition:'top'">
		</div>
		<div class="form-group col-md-3 mb-0">
			<input class="easyui-textbox" name="correoPersonal" style="width:100%" data-options="label:'Correo Personal:', labelPosition:'top'">
		</div>
		<div class="form-group col-md-3 mb-0">
			<input class="easyui-textbox" name="correoPronabec" style="width:100%" data-options="label:'Correo Pronabec:', labelPosition:'top'">
		</div>
		<div class="form-group col-md-2 mb-0">
			<input class="easyui-textbox" name="telefonos" style="width:100%" data-options="label:'Telefonos:', labelPosition:'top'">
		</div>
	</div>
	<div class="form-row col-md-12">
		<div class="form-group col-md-1 mb-0">
			<input class="easyui-maskedbox" name="representanteDni" mask="99999999" style="width:100%" data-options="label:'Rep. DNI:', labelPosition:'top'">
		</div>
		<div class="form-group col-md-3 mb-0">
			<input class="easyui-textbox" name="representante" style="width:100%" data-options="label:'Representante:', labelPosition:'top'">
		</div>
		<div class="form-group col-md-3 mb-0">
			<input class="easyui-textbox" name="idAsesor" style="width:100%" data-options="label:'Asesor:', labelPosition:'top'">
		</div>
		<div class="form-group col-md-2 mb-0">
		    <input class="easyui-textbox" name="numeroExpediente" style="width:100%" data-options="label:'Expediente:', labelPosition:'top'">
		</div>
		<div class="form-group col-md-2 mb-0">
		    <input class="easyui-textbox" name="resolucionAdjudicacion" style="width:100%" data-options="label:'Resolucion:', labelPosition:'top'">
		</div>		
	</div>
	<div class="form-row col-md-12" >
		<div class="form-group col-md-4 mb-0">
			<input class="easyui-textbox" name="idBeca" style="width:100%" data-options="label:'Beca:', labelPosition:'top'">
		</div>
		<div class="form-group col-md-3 mb-0">
			<input class="easyui-textbox" name="idCarrera" style="width:100%" data-options="label:'Carrera:', labelPosition:'top'">
		</div>
		<div class="form-group col-md-2 mb-0">
		    <input class="easyui-textbox" name="estado" style="width:100%" data-options="label:'Estado:', labelPosition:'top'">
		</div>
		<div class="from-group col-md-2 mb-0">
		    <input class="easyui-textbox" name="resolucionAdjudicacionFecha" style="width:100%" data-options="label:'F. Res.:', labelPosition:'top'">
		</div>
	</div>
	<div class="form-row col-md-12">
		<div class="form-group col-md-4 mb-0">
			<input class="easyui-textbox" name="idIes" style="width:100%" data-options="label:'Ies:', labelPosition:'top'">
		</div>
		<div class="form-group col-md-3 mb-0">
			<input class="easyui-textbox" name="idSedeEstudio" style="width:100%" data-options="label:'Sede:', labelPosition:'top'">
		</div>
		<div class="form-group col-md-2 mb-0">
		    <input class="easyui-textbox" name="condicion" style="width:100%" data-options="label:'Condicion:', labelPosition:'top'">
		</div>
	</div>
	
	<div class="form-row col-md-12">
		<div class="form-group col-md-2 mb-0">
			<input class="easyui-textbox" name="regionProcedencia" style="width:100%" data-options="label:'Region Procedencia:', labelPosition:'top'">
		</div>
		<div class="form-group col-md-2 mb-0">
			<input class="easyui-textbox" name="provinciaProcedencia" style="width:100%" data-options="label:'Provincia Procedencia:', labelPosition:'top'">
		</div>
		<div class="form-group col-md-2 mb-0">
			<input class="easyui-textbox" name="distritoProcedencia" style="width:100%" data-options="label:'Distrito Procedencia:', labelPosition:'top'">
		</div>
		<!-- 
	</div>
	<div class="form-row col-md-12">
		 -->
		<div class="form-group col-md-2 mb-0">
			<input class="easyui-textbox" name="regionPostulacion" style="width:100%" data-options="label:'Region Postulacion:', labelPosition:'top'">
		</div>
		<div class="form-group col-md-2 mb-0">
			<input class="easyui-textbox" name="provinciaPostulacion" style="width:100%" data-options="label:'Provincia Postulacion:', labelPosition:'top'">
		</div>
		<div class="form-group col-md-2 mb-0">
			<input class="easyui-textbox" name="distritoPostulacion" style="width:100%" data-options="label:'Distrito Postulacion:', labelPosition:'top'">
		</div>
	</div>
	<div class="form-row col-md-12">
		<div class="form-group col-md-10 mb-0">
			<input class="easyui-textbox" name="observaciones" style="width:100%" data-options="label:'Observaciones:', labelPosition:'top'">
		</div>
	</div>
	<div class="form-row col-md-12">
		<div class="form-group col-md-10 mb-2 mt-2">
		    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveBecario()" style="width:80px">Guardar</a>
		    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="clearForm()" style="width:80px">Cancelar</a>
		</div>
	</div>
</div>

<script>
	$(function(){
		var data = eval('('+'${becario}'+')');
		alert(data.fullName)
	});
</script>