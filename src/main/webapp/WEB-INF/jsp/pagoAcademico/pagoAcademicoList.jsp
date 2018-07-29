<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">

<div
	class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
	<h1 class="h2">Pago Academico</h1>
	<div class="btn-toolbar mb-2 mb-md-0">
		<div class="btn-group mr-2">
			<spring:url value="/pagoAcademico/add" var="urlAddPagoAcademico"/>
			<button class="btn btn-sm btn-outline-secondary" onclick="location.href='${urlAddPagoAcademico}'" >Nuevo</button>
			<!-- 
			<button class="btn btn-sm btn-outline-secondary">Export</button>
			 -->
		</div>
		<!-- 
		<button class="btn btn-sm btn-outline-secondary dropdown-toggle">
			<span data-feather="calendar"></span> This week
		</button>
		 -->
	</div>
</div>


<h2>Listado</h2>

<div class="table-responsive">
	<table class="table table-striped table-sm">
		<thead>
			<tr>
				<th># ID</th>
				<th># Convenio</th>
				<th>Mes</th>
				<th>Cuota</th>
				<th># Solicitud</th>
				<th>Fecha Solicitud</th>
				<th># Conformidad</th>
				<th>Cantidad</th>
				<th>Monto</th>
				<th>Pago Materiales</th>
				<th>Acciones</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="pagoAcademico" items="${pagoAcademicoList}">
				<tr>
					<td>${pagoAcademico.idPagoAcademico}</td>
					<td>${pagoAcademico.numeroConvenio}</td>
					<td>${pagoAcademico.mes}</td>
					<td>${pagoAcademico.numeroCuota}</td>
					<td>${pagoAcademico.numeroSolicitud}</td>
					<fmt:formatDate value="${pagoAcademico.fechaSolicitud}" pattern="dd-MM-yyyy" var="fechaSolicitud"/>
					<td>${fechaSolicitud}</td>
					<td>${pagoAcademico.numeroConformidad}</td>
					<td>${pagoAcademico.cantidadBecarios}</td>
					<td>${pagoAcademico.montoTotal}</td>
					<td>${pagoAcademico.pagoMateriales}</td>
					<!-- 
					<spring:url value="/ies/${ies.idIes}" var="iesUrl"/>
					 -->

					<spring:url value="/pagoAcademico/${pagoAcademico.idPagoAcademico}/update" var="urlUpdatePagoAcademico"/>
					<td>
						<!-- 
						<a href="${iesUrl}">Ver</a>
						 -->
						<a href="${urlUpdatePagoAcademico}"><span data-feather="edit"></span></a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</main>