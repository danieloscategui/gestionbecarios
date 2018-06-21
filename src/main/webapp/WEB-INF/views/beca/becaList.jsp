<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">

<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3">
	<p class="h5">Becas: ${fn:length(becaList)} registros</p>
	<div class="btn-toolbar mb-2 mb-md-0">
		<div class="btn-group mr-2">
			<spring:url value="/beca/add" var="urlAddBeca"/>
			<spring:url value="/beca/reporteExcel" var="urlBecaReporteExcel"/>
			<!-- 
			<button class="btn btn-sm btn-outline-secondary" onclick="location.href='${urlAddBeca}'" >Nuevo</button>
			 -->
			<button class="btn btn-sm btn-outline-secondary" onclick="location.href='${urlBecaReporteExcel}'" >Excel</button>
		</div>
	</div>
</div>

<c:if test="${not empty msg}">
		<div class="alert alert-${css} alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<strong>${msg}</strong>
		</div>
</c:if>

<div class="table-responsive">
	<table class="table table-striped table-sm">
		<thead class="thead-light">
			<tr>
				<th>Convocatoria</th>
				<th>Modalidad</th>
				<th>IES</th>
				<th>Sede Estudio</th>
				<th>Carrera</th>
				<th>Inicio Beca</th>
				<th>Termino Beca</th>
				<th>Semestre Egreso</th>
				<th>Asesor</th>
				<th>Acciones</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="beca" items="${becaList}">
				<tr>
					<td>${beca.convocatoria}</td>
					<td>${beca.modalidad}</td>
					<td>${beca.ies.nombre}</td>
					<td>${beca.sedeEstudio }
					<td>${beca.carrera}</td>
					
					<fmt:formatDate var="inicioBeca" value="${beca.inicioBeca}" pattern="dd/MM/yyyy" />
					<fmt:formatDate var="terminoBeca" value="${beca.terminoBeca}" pattern="dd/MM/yyyy" />
					
					<td>${inicioBeca}</td>
					<td>${terminoBeca}</td>
					
					<td>${beca.semestreEgreso}</td>
					<td>${beca.asesor.nombre}</td>
					<!-- 
					<spring:url value="/ies/${ies.idIes}" var="iesUrl"/>
					 -->

					<spring:url value="/beca/${beca.idBeca}/update" var="urlUpdateBeca"/>
					<spring:url value="/becario/beca/${beca.idBeca}" var="urlBecariosPorBeca"/>
					<td>
						<!-- 
						<a href="${iesUrl}">Ver</a>
						 -->
						<a href="${urlUpdateBeca}" data-toggle="tooltip" title="Editar"><span data-feather="edit"></span></a>
						<a href="${urlBecariosPorBeca}" data-toggle="tooltip" title="Ver becarios"><span data-feather="list"></span></a>
					</td>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</main>