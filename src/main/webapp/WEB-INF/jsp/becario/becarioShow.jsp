<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">

<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">

	<h5 class="h5">Becario encontrado</h5>
	
	<div class="btn-toolbar mb-2 mb-md-0">
		<div class="btn-group mr-2">
			<spring:url value="/becario/returnBeca" var="urlBecarioReturnBeca"/>
			<spring:url value="/becario/${becario.idBecario}/update" var="urlUpdateBecario"/>
			<button class="btn btn-sm btn-outline-secondary" onclick="location.href='${urlUpdateBecario}'" >Actualizar Becario</button>
			<button class="btn btn-sm btn-outline-secondary" onclick="location.href='${urlBecarioReturnBeca}'" >Inicio</button>
		</div>
		
	</div>
</div>


<form class="form-horizontal-">
	
	<div class="form-row">
			<div class="form-group col-sm-1">
				<label for="dni">DNI</label>
				<input class="form-control form-control-sm only-number" value="${becario.dni}" id="dni" readonly="readonly"  />
			</div>	
		
			<div class="form-group col-sm-3">
				<label for="nombres">Nombre</label>
				<input class="form-control form-control-sm" value="${becario.nombres}" id="nombres" readonly="readonly"/>
			</div>
		
			<div class="form-group col-sm-3">
				<label>Apellidos</label>
				<input class="form-control form-control-sm" value="${becario.apellidos}" id="apellidos" readonly="readonly"/>
			</div>
		
			<div class="form-group col-sm-2">
				<label for="sexo">Sexo</label>
				<input class="form-control form-control-sm" value="${becario.sexo.value}" id="sexo" readonly="readonly"/>
			</div>
		
			<div class="form-group col-sm-2">
				<label for="fechaNacimiento">Fecha Nacimiento</label>
				<fmt:formatDate value="${becario.fechaNacimiento}" pattern="dd/MM/yyyy" var="fechaNacimiento"/>
				<input class="form-control form-control-sm" value="${fechaNacimiento}" id="fechaNacimiento" readonly="readonly"/>
			</div>
		
			<div class="form-group col-sm-1">
				<label for="edad">Edad</label>
				<input class="form-control form-control-sm only-number" value="${becario.edad}" id="edad" readonly="readonly"/>
			</div>
		
	</div>
	
	<div class="form-row">
		<div class="form-group col-sm-12">
			<label for="direccion">Direccion</label>
			<input class="form-control form-control-sm" value="${becario.direccion}" id="direccion" readonly="readonly"/>
		</div>
	</div>
	
	<div class="form-row">
			<div class="form-group col-sm-4">
				<label for="correoPersonal">Correo Personal</label>
				<input class="form-control form-control-sm" value="${becario.correoPersonal}" id="correoPersonal" readonly="readonly"/>
			</div>
		
			<div class="form-group col-sm-4">
				<label for="correoPronabec">Correo Pronabec</label>
				<input class="form-control form-control-sm" value="${becario.correoPronabec}" id="correoPronabec" readonly="readonly"/>
			</div>
		
			<div class="form-group col-sm-4">
				<label for="telefonos">Telefonos</label>
				<input class="form-control form-control-sm" value="${becario.telefonos}" id="telefonos" readonly="readonly"/>
			</div>
	</div>
	
	<div class="form-row">
		<div class="form-group col-sm-2">
			<label for="representanteDni">Representante DNI</label>
			<input class="form-control form-control-sm" value="${becario.representanteDni}" id="representanteDni" readonly="readonly"/>
		</div>

		<div class="form-group col-sm-10">
			<label for="representante">Representante</label>
			<input class="form-control form-control-sm" value="${becario.representante}" id="representante" readonly="readonly"/>
		</div>
	</div>	
	
	<div class="form-row">
		<div class="form-group col-sm-2">
			<label for="numeroExpediente">Numero Expediente</label>
			<input class="form-control form-control-sm" value="${becario.numeroExpediente}" id="numeroExpediente" readonly="readonly"/>
		</div>
	
		<div class="form-group col-sm-10">
			<label for="beca">Beca</label>
			<input class="form-control form-control-sm" value="${becario.beca.shortName}" id="beca" readonly="readonly"/>
		</div>
	</div>
	
	<div class="form-row">
		<div class="form-group col-sm-2">
			<label for="resolucionAdjudicacionFecha">Fecha Resolucion Adjudicacion</label>
			<fmt:formatDate value="${becario.resolucionAdjudicacionFecha}" pattern="dd/MM/yyyy" var="fechaResolucion"/>
			<input class="form-control form-control-sm" value="${fechaResolucion}" id="resolucionAdjudicacionFecha" readonly="readonly"/>
		</div>
	
		<div class="form-group col-sm-8">
			<label for="resolucionAdjudicacion">Resolucion Adjudicacion</label>
			<input class="form-control form-control-sm" value="${becario.resolucionAdjudicacion}" id="resolucionAdjudicacion" readonly="readonly"/>
		</div>
	
		<div class="form-group col-sm-2">
			<label for="estadoActual">Estado Actual</label>
			<input class="form-control form-control-sm" value="${becario.estadoActual.value}" id="estadoActual" readonly="readonly"/>
		</div>
	</div>
	
	
	<div class="form-row">
		<div class="form-group col-sm-4">
			<label for="regionProcedencia">Region Procedencia</label>
			<input class="form-control form-control-sm" value="${becario.regionProcedencia}" id="regionProcedencia" readonly="readonly"/>
		</div>
	
		<div class="form-group col-sm-4">
			<label for="provinciaProcedencia">Provincia Procedencia</label>
			<input class="form-control form-control-sm" value="${becario.provinciaProcedencia}" id="provinciaProcedencia" readonly="readonly"/>
		</div>
	
		<div class="form-group col-sm-4">
			<label for="distritoProcedencia">Distrito Procedencia</label>
			<input class="form-control form-control-sm" value="${becario.distritoProcedencia}" id="distritoProcedencia" readonly="readonly"/>
		</div>
	</div>

	<div class="form-row">
		<div class="form-group col-sm-4">
			<label for="regionPostulacion">Region Postulacion</label>
			<input class="form-control form-control-sm" value="${becario.regionPostulacion}" id="regionPostulacion" readonly="readonly"/>
		</div>
	
		<div class="form-group col-sm-4">
			<label for="provinciaPostulacion">Provincia Postulacion</label>
			<input class="form-control form-control-sm" value="${becario.provinciaPostulacion}" id="provinciaPostulacion" readonly="readonly"/>
		</div>
	
		<div class="form-group col-sm-4">
			<label for="distritoPostulacion">Distrito Postulacion</label>
			<input class="form-control form-control-sm" value="${becario.distritoPostulacion}" id="distritoPostulacion" readonly="readonly"/>
		</div>
	</div>	


	<div class="form-row">
		<div class="form-group col-sm-12">
			<label for="observaciones">Observaciones</label>
			<input class="form-control form-control-sm" value="${becario.observaciones}" id="observaciones" readonly="readonly"/>
		</div>
	</div>
</form>


</main>