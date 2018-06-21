<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="/WEB-INF/taglibs/customTaglib.tld" prefix="page" %>

<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
<!-- 
<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3">
 -->
<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center">
	<div>
		<p class="h6">Asesores: ${asesorCount} registros</p>
		<spring:url value="/asesor" var="uriAsesor"/>
		<page:paginate max="15" offset="${asesorOffset}" count="${asesorCount}" uri="${uriAsesor}" next="&raquo;" previous="&laquo;"/>
	</div>
	<div class="btn-toolbar">
		<div class="btn-group">
			<spring:url value="/asesor/add" var="urlAddAsesor"/>
			<button class="btn btn-sm btn-outline-secondary" onclick="location.href='${urlAddAsesor}'">Nuevo</button>
		</div>
	</div>
</div>

<div class="table-responsive">
	<table class="table table-striped table-sm">
		<thead class="thead-light">
			<tr>
				<th># ID</th>
				<th>Asesor</th>
				<th>Acciones</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="asesor" items="${asesorList}">
				<tr>
					<td>${asesor.idAsesor}</td>
					<td>${asesor.nombre}</td>
					<spring:url value="/asesor/${asesor.idAsesor}/update" var="urlUpdateAsesor"/>
					<td>
						<a href="${urlUpdateAsesor}"><span title="Editar" data-feather="edit"></span></a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

</main>