<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!-- Menu Url Definitions -->
<spring:url value="/dashboard" var="dashboardMenuUrl"/>
<spring:url value="/becario" var="becarioMenuUrl"/>
<spring:url value="/ies" var="iesMenuUrl"/>
<spring:url value="/asesor" var="asesorMenuUrl"/>
<spring:url value="/beca" var="becaMenuUrl"/>
<spring:url value="/tramite" var="tramiteMenuUrl"/>
<spring:url value="/pagoAcademico" var="pagoAcademicoMenuUrl"/>

<nav class="col-md-2 d-none d-md-block bg-light sidebar">
	<div class="sidebar-sticky">
		<ul class="nav flex-column">
			<li class="nav-item"><a class="nav-link" href="${becaMenuUrl}">Becas
			</a></li>
			<li class="nav-item"><a class="nav-link" href="${iesMenuUrl}">IES
			</a></li>
			<li class="nav-item"><a class="nav-link" href="${asesorMenuUrl}">Asesores
			</a></li>
			<li class="nav-item"><a class="nav-link" href="${dashboardMenuUrl}">Dashboard 
			</a></li>
			<!-- 
			<li class="nav-item"><a class="nav-link" href="${becarioMenuUrl}"> <span
					data-feather="file"></span> Becarios
			</a></li>
			<li class="nav-item"><a class="nav-link" href="${tramiteMenuUrl}"> <span
					data-feather="layers"></span> Tramites
			</a></li>
			<li class="nav-item"><a class="nav-link" href="${pagoAcademicoMenuUrl}"> <span
					data-feather="layers"></span> Pago Academico
			</a></li>
			 -->
		</ul>

	</div>
</nav>