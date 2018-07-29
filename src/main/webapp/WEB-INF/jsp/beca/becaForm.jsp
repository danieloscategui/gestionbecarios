<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">

<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">


<c:choose >
	<c:when test="${becaForm['new']}">
		<p class="h6">Nueva Beca</p>
	</c:when>
	<c:otherwise>
		<p class="h6">Editar Beca</p>
	</c:otherwise>
</c:choose>

</div>

<spring:url value="/beca" var="becaActionUrl"/>

<form:form class="form-horizontal" method="post" modelAttribute="becaForm" action="${becaActionUrl}">
	
	<form:hidden path="idBeca"/>

	<div class="form-row">
		<spring:bind path="convocatoria">
			<div class="form-group col-md-3 ">
				<label for="convocatoria">Convocatoria</label>
				<form:input path="convocatoria" class="form-control form-control-sm" id="convocatoria" placeholder="Convocatoria" />
			</div>
		</spring:bind>
		
		<spring:bind path="modalidad">
			<div class="form-group col-md-9">
				<label for="modalidad">Modalidad</label>
				<form:input path="modalidad" class="form-control form-control-sm" id="modalidad" placeholder="Modalidad" />
			</div>
		</spring:bind>
	</div>
	
	<div class="form-row">	
		<spring:bind path="ies">
			<div class="form-group col-md-12">
				<label for="ies">IES</label>
				<form:select path="ies" class="form-control form-control-sm" id="ies" >
					<form:options items="${listaIes}" itemLabel="nombre" itemValue="idIes"/>
				</form:select>
			</div>
		</spring:bind>
	</div>
	
	<div class="form-row">
		<spring:bind path="regionEstudio">
			<div class="form-group col-md-6">
				<label for="regionEstudio">Region Estudio</label>
				<form:input path="regionEstudio" class="form-control form-control-sm" id="regionEstudio" />
			</div>
		</spring:bind>

		<spring:bind path="sedeEstudio">
			<div class="form-group col-md-6">
				<label for="sedeEstudio">Sede Estudio</label>
				<form:input path="sedeEstudio" class="form-control form-control-sm" id="sedeEstudio" />
			</div>
		</spring:bind>	
	</div>
	
	<div class="form-row">	
		<spring:bind path="carrera">
			<div class="form-group col-md-6">
				<label for="carrera">Carrera</label>
				<form:input path="carrera" class="form-control form-control-sm" id="carrera" />
			</div>
		</spring:bind>	

		<spring:bind path="inicioBeca">
			<div class="form-group col-md-2">
				<label for="inicioBeca">Inicio Beca</label>
				<form:input path="inicioBeca" class="form-control form-control-sm datepicker" id="inicioBeca"  />
			</div>
		</spring:bind>	

		<spring:bind path="terminoBeca">
			<div class="form-group col-md-2">
				<label for="terminoBeca">Termino Beca</label>
				<form:input path="terminoBeca" class="form-control form-control-sm datepicker" id="terminoBeca" />
			</div>
		</spring:bind>	

		<spring:bind path="semestreEgreso">
			<div class="form-group col-md-2">
				<label for="semestreEgreso">Semestre Egreso</label>
				<form:input path="semestreEgreso" class="form-control form-control-sm" id="semestreEgreso" />
			</div>
		</spring:bind>	
	</div>

	<div class="form-row">
		<spring:bind path="asesor">
			<div class="form-group col-md-12">
				<label for="asesor">Asesor</label>
				<form:select path="asesor" class="form-control form-control-sm" id="asesor">
					<form:options items="${listaAsesores}" itemLabel="nombre" itemValue="idAsesor" />
				</form:select>
			</div>
		</spring:bind>	
	</div>	
	
	<div class="form-row">
		<div class="form-group col-md-12">
			<c:choose>
				<c:when test="${becaForm['new']}">
					<input type="submit"  class="btn-sm btn-primary pull-right" value="Agregar"/>
				</c:when>
				<c:otherwise>
					<input type="submit" class="btn-sm btn-primary pull-right" value="Actualizar" />
				</c:otherwise>
			</c:choose>
			<spring:url value="/beca" var="urlCancelar"/>
			<button class="btn-sm btn-secondary pull-right" onclick="location.href='${urlCancelar}'" >Cancelar</button>
		</div>
	</div>
</form:form>

</main>