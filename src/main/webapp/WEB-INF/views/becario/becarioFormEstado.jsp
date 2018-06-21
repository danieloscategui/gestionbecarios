<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">

<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
	<p class="h6">Becario - Cambio de estado</p>
	
</div>

<spring:url value="/becario/updateEstado" var="becarioActionUrl"/>

<form:form class="form-horizontal"  method="post" modelAttribute="becarioForm" action="${becarioActionUrl}">
		
	<form:hidden path="idBecario"/>
	
	<div class="form-row">
		<div class="form-group col-md-2">
			<label for="dni">DNI</label>
			<form:input path="dni" class="form-control form-control-sm" id="dni" readonly="true"/>
		</div>	
		
		<div class="form-group col-md-5">
			<label for="nombres">Nombre</label>
			<form:input path="nombres" class="form-control form-control-sm" id="nombres" readonly="true"/>
		</div>
	
		<div class="form-group col-md-5">
			<label for="apellidos">Apellidos</label>
			<form:input path="apellidos" class="form-control form-control-sm" id="apellidos" readonly="true"/>
		</div>
	</div>
	
	<div class="form-row">
		<div class="form-group col-md-4">
			<label for="estadoUno">Estado Uno</label>
			<form:select path="estadoUno.idEstadoUno" class="form-control form-control-sm" id="estadoUno">
				<form:options items="${listEstadoUno}" itemValue="idEstadoUno" itemLabel="descripcion"/>
			</form:select>
		</div>
		<div class="form-group col-md-4">
			<label for="estadoDos">Estado Dos</label>
			<form:select path="estadoDos" class="form-control form-control-sm" id="estadoDos">
			</form:select>
		</div>
		<div class="form-group col-md-4">
			<label for="estadoTres">Estado Tres</label>
			<form:select path="estadoTres" class="form-control form-control-sm" id="estadoTres">
			</form:select>
		</div>
	</div>
	
	<div class="form-row">	
		<div class="form-group col-md-12">
			<label for="observaciones">Observaciones</label>
			<form:input path="observaciones" class="form-control form-control-sm" id="observaciones"/>
		</div>
	</div>

	<form:hidden path="beca.idBeca"/>
	
	<div class="form-row">
		<div class="form-group col-md-12">
			<input type="submit" class="btn-sm btn-primary pull-right" value="Actualizar" />
			
			<spring:url value="/becario/beca/${beca.idBeca}" var="urlCancelar"/>
			<button class="btn-sm btn-secondary pull-right" onclick="location.href='${urlCancelar}'" >Cancelar</button>
		</div>
	</div>
	
</form:form>

</main>


<spring:url value="/becario/estadoUno" var="buscarEstadoUnoURL"/>
<spring:url value="/becario/estadoDos" var="buscarEstadoDosURL"/>
<spring:url value="/becario/estadoTres" var="buscarEstadoTresURL"/>

<script type="text/javascript">
	$(document).ready(function(){
		/*
		$.getJSON('${buscarEstadoUnoURL}', function(data){
			var html = '<option value="0">Seleccione</option>';
			var len = data.length;
			for(var i = 0; i < len; i++){
				html += '<option value="' + data[i].idEstadoUno + '">' + data[i].descripcion + '</option>';
			}
			html += '</option>';
			$('#estadoUno').html(html);
		}); 
		*/
		
		$('#estadoUno').change(function(){
			if($(this).val()=='0') return;
			$('#estadoTres').empty();
			$.getJSON('${buscarEstadoDosURL}',{
				idEstadoUno: $(this).val()
			} ,function(data){
				var html = '<option value="0">Seleccione</option>';
				var len = data.length;
				for(var i = 0; i < len; i++){
					html += '<option value="' + data[i].idEstadoDos + '">' + data[i].descripcion + '</option>';
				}
				html += '</option>';
				$('#estadoDos').html(html);
			});
			
		});
		
		$('#estadoDos').change(function(){
			if($(this).val()=='0') return;
			$.getJSON('${buscarEstadoTresURL}',{
				idEstadoDos: $(this).val()
			} ,function(data){
				var html = '<option value="0">Seleccione</option>';
				var len = data.length;
				for(var i = 0; i < len; i++){
					html += '<option value="' + data[i].idEstadoTres + '">' + data[i].descripcion + '</option>';
				}
				html += '</option>';
				$('#estadoTres').html(html);
			});
			
		});
		
	});
</script>