<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/taglibs/customTaglib.tld" prefix="page" %>

<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">

<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center">
	<div>
		<p class="h6">Becas: ${becaCount} registros</p>	
		<spring:url value="/beca" var="uriBeca"/>
		<page:paginate max="15" offset="${becaOffset}" count="${becaCount}" uri="${uriBeca}" next="&raquo;" previous="&laquo;"/>	
	</div>
	<div class="btn-toolbar">
		<div class="btn-group">
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
				<!-- 
				<th>IES</th>
				<th>Sede Estudio</th>
				<th>Carrera</th>
				 -->
				<th>Fechas</th>
				<!-- 
				<th>Semestre Egreso</th>
				<th>Asesor</th>
				 -->
				<th>Acciones</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="beca" items="${becaList}">
				<tr>
					<td>${beca.convocatoria}</td>
					<td>${beca.modalidad}</td>
					
					<fmt:formatDate var="inicioBeca" value="${beca.inicio}" pattern="dd/MM/yyyy" />
					<fmt:formatDate var="terminoBeca" value="${beca.termino}" pattern="dd/MM/yyyy" />
					
					<td>${inicioBeca} <br>${terminoBeca}</td>

					<spring:url value="/beca/${beca.idBeca}/update" var="urlUpdateBeca"/>
					<spring:url value="/becario/beca/${beca.idBeca}" var="urlBecariosPorBeca"/>
					<td>
						<!-- 
						<a href="${iesUrl}">Ver</a>
						 -->
						<a href="#" data-toggle="modal" data-target="#editarBeca">Edit</a>
						<a href="#" data-toggle="tooltip" title="Ver becarios"><span data-feather="list"></span></a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</div>

<div class="modal" id="editarBeca" tabindex="-1" role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="editarBecaLabel">Editar Beca</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<div class="form-group">
					<div class="input-group">
						<div class="input-group-addon">@</div>
						<input class="form-control" id="email" name="email" type="text"/>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary" data-dismiss="modal">Save</button>
			</div>
		</div>
	</div>
</div>


</main>
<!-- 
<script>

$(document).ready(function(){
	$('#example').DataTable();
	
});
</script>
 -->