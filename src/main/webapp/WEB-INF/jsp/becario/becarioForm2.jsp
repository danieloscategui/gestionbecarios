<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<main role="main" class="col-md-9 ml-md-auto col-lg-10 pt-3 px-4">

<div	class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">

<c:choose >
	<c:when test="${becarioForm['new'] }">
		<p class="h5">Nuevo Becario</p>
	</c:when>
	<c:otherwise>
		<p class="h5">Editar Becario</p>
	</c:otherwise>
</c:choose>
</div>

<spring:url value="/becario" var="becarioActionUrl"/>

<form:form class="form-horizontal-" method="post" modelAttribute="becarioForm" action="${becarioActionUrl}">
	
	<form:hidden path="idBecario"/>
	
	<div class="form-row">
		<spring:bind path="dni">
			<div class="form-group col-md-1">
				<label for="dni">DNI</label>
				<form:input path="dni" class="form-control form-control-sm only-number" id="dni" placeholder="DNI"  />
			</div>	
		</spring:bind>
		
		<spring:bind path="nombres">
			<div class="form-group col-md-3">
				<label for="nombres">Nombre</label>
				<form:input path="nombres" class="form-control form-control-sm" id="nombres" placeholder="Nombres"/>
			</div>
		</spring:bind>
		
		<spring:bind path="apellidos">
			<div class="form-group col-md-3">
				<label>Apellidos</label>
				<form:input path="apellidos" class="form-control form-control-sm" id="apellidos" placeholder="Apellidos"/>
			</div>
		</spring:bind>
		
		<spring:bind path="sexo">
			<div class="form-group col-md-2">
				<label for="sexo">Sexo</label>
				<form:select path="sexo" class="form-control form-control-sm" id="sexo" >
					<form:options items="${becarioSexo}"/>				
				</form:select>
			</div>
		</spring:bind>
		
		<spring:bind path="fechaNacimiento">
			<div class="form-group col-md-2">
				<label for="fechaNacimiento">Fecha Nacimiento</label>
				<form:input path="fechaNacimiento" class="form-control form-control-sm datepicker" id="fechaNacimiento"/>
			</div>
		</spring:bind>
		
		<spring:bind path="edad">
			<div class="form-group col-md-1">
				<label for="edad">Edad</label>
				<form:input path="edad" class="form-control form-control-sm only-number" id="edad"/>
			</div>
		</spring:bind>
		
	</div>
	
	<div class="form-row">
		<spring:bind path="direccion">
			<div class="form-group col-md-12">
				<label for="direccion">Direccion</label>
				<form:input path="direccion" class="form-control form-control-sm" id="direccion"/>
			</div>
		</spring:bind>
	</div>
	
	<div class="form-row">
		<spring:bind path="correoPersonal">
			<div class="form-group col-md-4">
				<label for="correoPersonal">Correo Personal</label>
				<form:input path="correoPersonal" class="form-control form-control-sm" id="correoPersonal"/>
			</div>
		</spring:bind>
		
		<spring:bind path="correoPronabec">
			<div class="form-group col-md-4">
				<label for="correoPronabec">Correo Pronabec</label>
				<form:input path="correoPronabec" class="form-control form-control-sm" id="correoPronabec"/>
			</div>
		</spring:bind>
		
		<spring:bind path="telefonos">
			<div class="form-group col-md-4">
				<label for="telefonos">Telefonos</label>
				<form:input path="telefonos" class="form-control form-control-sm" id="telefonos"/>
			</div>
		</spring:bind>
	</div>
	
	<div class="form-row">
		<spring:bind path="representanteDni">
			<div class="form-group col-md-2">
				<label for="representanteDni">Representante DNI</label>
				<form:input path="representanteDni" class="form-control form-control-sm" id="representanteDni"/>
			</div>
		</spring:bind>

		<spring:bind path="representante">
			<div class="form-group col-md-10">
				<label for="representante">Representante</label>
				<form:input path="representante" class="form-control form-control-sm" id="representante"/>
			</div>
		</spring:bind>
	</div>	
	
	<div class="form-row">
		<spring:bind path="numeroExpediente">
			<div class="form-group col-md-2">
				<label for="numeroExpediente">Numero Expediente</label>
				<form:input path="numeroExpediente" class="form-control form-control-sm" id="numeroExpediente"/>
			</div>
		</spring:bind>
		
		<spring:bind path="beca">
			<div class="form-group col-md-10">
				<label for="beca">Beca</label>
				<form:select path="beca" class="form-control form-control-sm" id="beca">
					<form:options items="${listaBecas}" itemLabel="shortName" itemValue="idBeca"/>
				</form:select>
			</div>
		</spring:bind>
	</div>
	
	<div class="form-row">
		<spring:bind path="resolucionAdjudicacionFecha">
			<div class="form-group col-md-2">
				<label for="resolucionAdjudicacionFecha">Fecha Resolucion Adjudicacion</label>
				<form:input path="resolucionAdjudicacionFecha" class="form-control form-control-sm datepicker" id="resolucionAdjudicacionFecha"/>
			</div>
		</spring:bind>
		
		<spring:bind path="resolucionAdjudicacion">
			<div class="form-group col-md-8">
				<label for="resolucionAdjudicacion">Resolucion Adjudicacion</label>
				<form:input path="resolucionAdjudicacion" class="form-control form-control-sm" id="resolucionAdjudicacion"/>
			</div>
		</spring:bind>
		
		<spring:bind path="estadoActual">
			<div class="form-group col-md-2">
				<label for="estadoActual">Estado Actual</label>
				<form:select path="estadoActual" class="form-control form-control-sm" id="estadoActual" >
					<form:options items="${becarioEstado }"/>				
				</form:select>
			</div>
		</spring:bind>
	</div>
	
	
	<div class="form-row">
		<spring:bind path="regionProcedencia">
			<div class="form-group col-md-4">
				<label for="regionProcedencia">Region Procedencia</label>
				<form:input path="regionProcedencia" class="form-control form-control-sm" id="regionProcedencia"/>
			</div>
		</spring:bind>
		
		<spring:bind path="provinciaProcedencia">
			<div class="form-group col-md-4">
				<label for="provinciaProcedencia">Provincia Procedencia</label>
				<form:input path="provinciaProcedencia" class="form-control form-control-sm" id="provinciaProcedencia"/>
			</div>
		</spring:bind>
		
		<spring:bind path="distritoProcedencia">
			<div class="form-group col-md-4">
				<label for="distritoProcedencia">Distrito Procedencia</label>
				<form:input path="distritoProcedencia" class="form-control form-control-sm" id="distritoProcedencia"/>
			</div>
		</spring:bind>
	</div>

	<div class="form-row">
		<spring:bind path="regionPostulacion">
			<div class="form-group col-md-4">
				<label for="regionPostulacion">Region Postulacion</label>
				<form:input path="regionPostulacion" class="form-control form-control-sm" id="regionPostulacion"/>
			</div>
		</spring:bind>
		
		<spring:bind path="provinciaPostulacion">
			<div class="form-group col-md-4">
				<label for="provinciaPostulacion">Provincia Postulacion</label>
				<form:input path="provinciaPostulacion" class="form-control form-control-sm" id="provinciaPostulacion"/>
			</div>
		</spring:bind>
		
		<spring:bind path="distritoPostulacion">
			<div class="form-group col-md-4">
				<label for="distritoPostulacion">Distrito Postulacion</label>
				<form:input path="distritoPostulacion" class="form-control form-control-sm" id="distritoPostulacion"/>
			</div>
		</spring:bind>
	</div>	


	<div class="form-row">
		<spring:bind path="observaciones">
			<div class="form-group col-md-12">
				<label for="observaciones">Observaciones</label>
				<form:input path="observaciones" class="form-control form-control-sm" id="observaciones"/>
			</div>
		</spring:bind>
	</div>
		
	<div class="form-row">
		<div class="form-group col-md-12">
			<c:choose>
				<c:when test="${becarioForm['new']}">
					<input type="submit"  class="btn-sm btn-primary pull-right" value="Agregar"/>
				</c:when>
				<c:otherwise>
					<input type="submit" class="btn-sm btn-primary pull-right" value="Actualizar" />
				</c:otherwise>
			</c:choose>
			
			<spring:url value="/becario/beca/${beca.idBeca}" var="urlCancelar"/>
			<button class="btn-sm btn-secondary pull-right" onclick="location.href='${urlCancelar}'" >Cancelar</button>
		</div>
	</div>
</form:form>

</main>