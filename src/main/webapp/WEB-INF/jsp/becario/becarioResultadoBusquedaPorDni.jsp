<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">

<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2- mb-3">	
	<div>
		<!-- https://getbootstrap.com/docs/4.0/getting-started/introduction/ -->
		<ul class="list-unstyled ">
			<li class="font-weight-bold">${fn:length(becariosEncontrados)} Becarios Encontrados</p>
		</ul>
	</div>
	
	<div class="btn-toolbar mb-2 mb-md-0">
		<div class="btn-group mr-2">
			<spring:url value="/beca" var="urlBecas" />
			<button class="btn btn-sm btn-outline-secondary" onclick="location.href='${urlBecas}'" >Inicio</button>
		</div>
	</div>
</div>

<div class="table-responsive">
	<table class="table table-striped table-sm">
		<thead>
			<tr>
				<th>DNI</th>
				<th>Becario</th>
				<th>Beca</th>
				<th>Estado Actual</th>
				<th>Ver</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="becario" items="${becariosEncontrados}">
				<tr>
					<td>${becario.dni}</td>
					<td>${becario.fullName}</td>
					<td>${becario.beca.shortName}</td>
					<td>${becario.estadoUno.descripcion}</td>
					<spring:url value="/becario/${becario.idBecario}/show" var="urlVerBecario"/>
					<td>
						<a href="${urlVerBecario}" data-toggle="tooltip" title="Ver detalle" ><span data-feather="user"></span></a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>


</main>

