<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
<div
	class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
	<h1 class="h2">Tramite</h1>
	<!-- 
	<div class="btn-toolbar mb-2 mb-md-0">
		<div class="btn-group mr-2">
			<button class="btn btn-sm btn-outline-secondary">Share</button>
			<button class="btn btn-sm btn-outline-secondary">Export</button>
		</div>
		<button class="btn btn-sm btn-outline-secondary dropdown-toggle">
			<span data-feather="calendar"></span> This week
		</button>
	</div>
	 -->
</div>

<c:choose >
	<c:when test="${tramiteForm['new'] }">
		<h2>Nuevo Tramite</h2>
	</c:when>
	<c:otherwise>
		<h2>Editar Tramite</h2>
	</c:otherwise>
</c:choose>

<spring:url value="/tramite" var="tramiteActionUrl"/>

<form:form class="form-horizontal" method="post" modelAttribute="tramiteForm" action="${tramiteActionUrl}">

	<form:hidden path="idTramite"/>
	
	<spring:bind path="becario.dni">
		<div class="form-group">
			<label class="col-sm-2 control-label" >DNI Becario</label>
			<div class="col-sm-10">
				<form:input path="becario.dni" class="form-control" id="becario.dni" placeholder="DNI Becario"/>
			</div>
		</div>
	</spring:bind>
	
	<spring:bind path="numeroSigedo">
		<div class="form-group">
			<label class="col-sm-2 control-label">Numero Sigedo</label>
			<div class="col-sm-10">
				<form:input path="numeroSigedo" class="form-control" id="numeroSigedo"/>
			</div>
		</div>
	</spring:bind>
	
	<spring:bind path="motivo">
		<div class="form-group">
			<label class="col-sm-2 control-label">Motivo</label>
			<div class="col-sm-10">
				<form:input path="motivo" class="form-control" id="motivo"/>
			</div>
		</div>
	</spring:bind>
	
	<spring:bind path="oficinaDestino">
		<div class="form-group">
			<label class="col-sm-2 control-label">Oficina Destino</label>
			<div class="col-sm-10">
				<form:input path="oficinaDestino" class="form-control" id="oficinaDestino"/>
			</div>
		</div>
	</spring:bind>
	
	<spring:bind path="estado">
		<div class="form-group">
			<label class="col-sm-2 control-label">Estado</label>
			<div class="col-sm-10">
				<form:input path="estado" class="form-control" id="estado"/>
			</div>
		</div>
	</spring:bind>
	
	<spring:bind path="tipoDocumentoRespuesta">
		<div class="form-group">
			<label class="col-sm-2 control-label">Tipo Documento Respuesta</label>
			<div class="col-sm-10">
				<form:input path="tipoDocumentoRespuesta" class="form-control" id="tipoDocumentoRespuesta"/>
			</div>
		</div>
	</spring:bind>
	
	<spring:bind path="numeroDocumento">
		<div class="form-group">
			<label class="col-sm-2 control-label">Numero Documento</label>
			<div class="col-sm-10">
				<form:input path="numeroDocumento" class="form-control" id="numeroDocumento"/>
			</div>
		</div>
	</spring:bind>

	<spring:bind path="fechaDocumento">
		<div class="form-group">
			<label class="col-sm-2 control-label">Fecha Documento</label>
			<div class="col-sm-10">
				<form:input path="fechaDocumento" class="form-control" id="fechaDocumento"/>
			</div>
		</div>
	</spring:bind>
	
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<c:choose>
				<c:when test="${tramiteForm['new']}">
					<input type="submit"  class="btn-lg btn-primary pull-right" value="Agregar"/>
				</c:when>
				<c:otherwise>
					<input type="submit" class="btn-lg btn-primary pull-right" value="Actualizar" />
				</c:otherwise>
			</c:choose>
		</div> 
	</div>
</form:form>

</main>