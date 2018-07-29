<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">

<div
	class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
	<h1 class="h2">Tramite</h1>
	<div class="btn-toolbar mb-2 mb-md-0">
		<div class="btn-group mr-2">
			<spring:url value="/tramite/add" var="urlAddTramite"/>
			<button class="btn btn-sm btn-outline-secondary" onclick="location.href='${urlAddTramite}'" >Nuevo</button>
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
				<th>Becario</th>
				<th>Sigedo</th>
				<th>Motivo</th>
				<th>Oficina Destino</th>
				<th>Estado</th>
				<th>Doc. Respuesta</th>
				<th>Numero Doc.</th>
				<th>Fecha Doc.</th>
				<th>Acciones</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="tramite" items="${tramiteList}">
				<tr>
					<td>${tramite.idTramite}</td>
					<td>${tramite.becario.fullName}</td>
					<td>${tramite.numeroSigedo}</td>
					<td>${tramite.motivo}</td>
					<td>${tramite.oficinaDestino}</td>
					<td>${tramite.estado}</td>
					<td>${tramite.tipoDocumentoRespuesta}</td>
					<td>${tramite.numeroDocumento}</td>
					
					<fmt:formatDate value="${tramite.fechaDocumento}" pattern="dd-MM-yyyy" var="fechaDocumento"/>
					<td>${fechaDocumento}</td>
					<!-- 
					<spring:url value="/ies/${ies.idIes}" var="iesUrl"/>
					 -->

					<spring:url value="/tramite/${tramite.idTramite}/update" var="urlUpdateTramite"/>
					<td>
						<!-- 
						<a href="${iesUrl}">Ver</a>
						 -->
						<a href="${urlUpdateTramite}"><span data-feather="edit"></span></a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</main>