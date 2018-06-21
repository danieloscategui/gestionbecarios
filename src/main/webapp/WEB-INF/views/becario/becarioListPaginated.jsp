<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="/WEB-INF/taglibs/customTaglib.tld" prefix="page" %>

<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">

<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center">	
	<div>
		<!-- https://getbootstrap.com/docs/4.0/getting-started/introduction/ -->
		<ul class="list-unstyled ">
			<li class="font-weight-bold">Asesor: ${beca.asesor.nombre }</li>
			<li class="font-weight-bold">${beca.convocatoria} - ${beca.modalidad}</li> 
			<li class="font-weight-bold">${beca.ies.nombre } - ${beca.regionEstudio} - ${beca.sedeEstudio } - ${beca.carrera}</li>
			<li class="font-weight-bold">${becarioCount} Becarios</p>
		</ul>
		<spring:url value="/becario/beca/${beca.idBeca}" var="uriBecario"/>
		<page:paginate max="15" offset="${becarioOffset}" count="${becarioCount}" uri="${uriBecario}" next="&raquo;" previous="&laquo;"/>
	</div>
	
	<div class="btn-toolbar">
		<div class="btn-group">
			<spring:url value="/becario/add" var="urlAddBecario"/>
			<spring:url value="/beca" var="urlBecas" />
			<button class="btn btn-sm btn-outline-secondary" onclick="location.href='${urlBecas}'" >Inicio</button>
			<!-- 
			<button class="btn btn-sm btn-outline-secondary" onclick="location.href='${urlAddBecario}'" >Nuevo</button>
			 -->
		</div>
	</div>
</div>

<div class="table-responsive">
	<table class="table table-striped table-sm">
		<thead>
			<tr>
				<th>DNI</th>
				<th>Becario</th>
				<th>Estado Actual</th>
				<th>Acciones</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="becario" items="${becarioList}">
				<tr>
					<td>${becario.dni}</td>
					<td>${becario.fullName}</td>
					<td>${becario.estadoUno.descripcion}</td>

					<spring:url value="/becario/${becario.idBecario}/updateEstado" var="urlUpdateEstadoBecario"/>
					<spring:url value="/becario/${becario.idBecario}/show" var="urlVerBecario"/>
					
					<td>
						<a href="${urlVerBecario}" data-toggle="tooltip" title="Ver detalle" ><span data-feather="user"></span></a>
						<a href="${urlUpdateEstadoBecario}" data-toggle="tooltip" title="Cambiar estado" ><span data-feather="flag"></span></a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>


</main>

