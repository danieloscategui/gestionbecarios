<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
<c:choose >
	<c:when test="${iesForm['new'] }">
		<p class="h5">Nuevo IES</p>
	</c:when>
	<c:otherwise>
		<p class="h5">Editar IES</p>
	</c:otherwise>
</c:choose>
</div>

<spring:url value="/ies" var="iesActionUrl"/>

<form:form class="form-horizontal" method="post" modelAttribute="iesForm" action="${iesActionUrl}">

	<form:hidden path="idIes"/>

	<div class="form-row">
		<spring:bind path="nombre">
			<div class="form-group col-sm-12">
				<label for="nombre" >Nombre</label>
				<form:input path="nombre" class="form-control form-control-sm" id="nombre" placeholder="Nombre"/>
			</div>
		</spring:bind>
	</div>
	
	<div class="form-row">
		<spring:bind path="tipoIes">
			<div class="form-group col-md-6">
				<label for="tipoIes">Tipo</label>
				<form:select path="tipoIes" class="form-control form-control-sm" id="tipoIes">
					<form:options items="${opcionesTipoIes}" />
				</form:select>
			</div>
		</spring:bind>
		
		<spring:bind path="tipoGestion">
			<div class="form-group col-md-6">
				<label for="tipoGestion">Gestion</label>
				<form:select path="tipoGestion" class="form-control form-control-sm" id="tipoGestion">
					<form:options items="${opcionesTipoGestion}" />
				</form:select>
			</div>
		</spring:bind>
	</div>
	
	<div class="form-row">
		<div class="form-group col-md-12">
			<c:choose>
				<c:when test="${iesForm['new']}">
					<input type="submit"  class="btn-sm btn-primary pull-right" value="Agregar"/>
				</c:when>
				<c:otherwise>
					<input type="submit" class="btn-sm btn-primary pull-right" value="Actualizar" />
				</c:otherwise>
			</c:choose>
			<spring:url value="/ies" var="urlCancelar"/>
			<button class="btn-sm btn-secondary pull-right" onclick="location.href='${urlCancelar}'" >Cancelar</button>
		</div>
	</div>
</form:form>

</main>