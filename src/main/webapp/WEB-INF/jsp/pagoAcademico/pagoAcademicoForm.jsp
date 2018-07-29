<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
<div
	class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
	<h1 class="h2">Pago Academico</h1>
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
	<c:when test="${pagoAcademicoForm['new'] }">
		<h2>Nuevo Pago Academico</h2>
	</c:when>
	<c:otherwise>
		<h2>Editar Pago Academico</h2>
	</c:otherwise>
</c:choose>

<spring:url value="/pagoAcademico" var="pagoAcademicoActionUrl"/>

<form:form class="form-horizontal" method="post" modelAttribute="pagoAcademicoForm" action="${pagoAcademicoActionUrl}">

	<form:hidden path="idPagoAcademico"/>

	<spring:bind path="numeroConvenio">
		<div class="form-group">
			<label class="col-sm-2 control-label" >Numero Convenio</label>
			<div class="col-sm-10">
				<form:input path="numeroConvenio" class="form-control" id="nombre" placeholder="numeroConvenio"/>
			</div>
		</div>
	</spring:bind>

	<spring:bind path="mes">
		<div class="form-group">
			<label class="col-sm-2 control-label">Mes</label>
			<div class="col-sm-10">
				<form:input path="mes" class="form-control" id="mes"/>
			</div>
		</div>
	</spring:bind>
	
	<spring:bind path="numeroCuota">
		<div class="form-group">
			<label class="col-sm-2 control-label">Numero Cuota</label>
			<div class="col-sm-10">
				<form:input path="numeroCuota" class="form-control" id="numeroCuota"/>
			</div>
		</div>
	</spring:bind>
	
	<spring:bind path="numeroSolicitud">
		<div class="form-group">
			<label class="col-sm-2 control-label">Numero Solicitud</label>
			<div class="col-sm-10">
				<form:input path="numeroSolicitud" class="form-control" id="numeroSolicitud"/>
			</div>
		</div>
	</spring:bind>
	
	<spring:bind path="fechaSolicitud">
		<div class="form-group">
			<label class="col-sm-2 control-label">Fecha Solicitud</label>
			<div class="col-sm-10">
				<form:input path="fechaSolicitud" class="form-control" id="fechaSolicitud"/>
			</div>
		</div>
	</spring:bind>
	
	<spring:bind path="numeroConformidad">
		<div class="form-group">
			<label class="col-sm-2 control-label">Numero Conformidad</label>
			<div class="col-sm-10">
				<form:input path="numeroConformidad" class="form-control" id="numeroConformidad"/>
			</div>
		</div>
	</spring:bind>
	
	<spring:bind path="cantidadBecarios">
		<div class="form-group">
			<label class="col-sm-2 control-label">Cantidad Becarios</label>
			<div class="col-sm-10">
				<form:input path="cantidadBecarios" class="form-control" id="cantidadBecarios"/>
			</div>
		</div>
	</spring:bind>
	
	<spring:bind path="montoTotal">
		<div class="form-group">
			<label class="col-sm-2 control-label">Monto total</label>
			<div class="col-sm-10">
				<form:input path="montoTotal" class="form-control" id="montoTotal"/>
			</div>
		</div>
	</spring:bind>
	
	<spring:bind path="pagoMateriales">
		<div class="form-group">
			<label class="col-sm-2 control-label">Pago Materiales</label>
			<div class="col-sm-10">
				<form:input path="pagoMateriales" class="form-control" id="pagoMateriales"/>
			</div>
		</div>
	</spring:bind>
	
	
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<c:choose>
				<c:when test="${pagoAcademicoForm['new']}">
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