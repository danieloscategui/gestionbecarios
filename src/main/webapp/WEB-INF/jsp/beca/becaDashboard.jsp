<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center">
	<p class="h6">Dashboard</p>
</div>

<form class="form-horizontal col-md-10" id="search-form">
	<div class="form-row">
		<div class="form-group col-md-2">
				<label for="convocatoria">Convocatoria</label>
				<select class="form-control form-control-sm" id="convocatoria">
				</select>
		</div>
		<div class="form-group col-md-2">
				<label for="modalidad">Modalidad</label>
				<select class="form-control form-control-sm" id="modalidad">
				</select>
		</div>
		<div class="form-group col-md-2">
				<label for="ies">IES</label>
				<select class="form-control form-control-sm" id="ies">
				</select>
		</div>
		<div class="form-group col-md-2">
				<label for="carrera">Carrera</label>
				<select class="form-control form-control-sm" id="carrera">
				</select>
		</div>
		<div class="form-group col-md-2">
			<br/>
			<button type="submit" class="btn-sm btn-primary pull-right" id="btn-search">Query</button>
		</div>
	</div>
</form>

<c:if test="${not empty params}">
	<c:out value="${params}"/>
</c:if>

<c:if test="${not empty iesValue}">
	<c:out value="${iesValue}"/>
</c:if>

<canvas class="my-4" id="myChart" width="900" height="380"></canvas>

</main>

<spring:url value="/dashboard/convocatorias" var="buscarConvocatoriasURL"/>
<spring:url value="/dashboard/modalidades" var="buscarModalidadesURL"/>
<spring:url value="/dashboard/ies" var="buscarIesURL"/>
<spring:url value="/dashboard/carreras" var="buscarCarrerasURL"/>
<spring:url value="/dashboard/query" var="actionURL"/>

<script type="text/javascript">
	$(document).ready(function(){
		
		function getData(){
			var search = {};
			search["convocatoria"] = $('#convocatoria').val() == '0' ? null : $('#convocatoria').val();
			search["modalidad"] = $('#modalidad').val() == '0' ? null : $('#modalidad').val();
			search["ies"] = $('#ies').val() == '0' ? null : $('#ies').val();
			search["carrera"] = $('#carrera').val() == '0' ? null : $('#carrera').val();
			return search;
		}
		
		function constructHtml(data){
			var html = '<option value="0">Seleccione</option>';
			var len = data.length;
			for(var i = 0; i < len; i++){
				html += '<option value="'+ data[i]+ '">' + data[i] + '</option>'
			}
			html += '</option>';
			return html;
		}
		
		function loadData(url, destino){
			var dataToLoad;
			$.ajax({
				type: 'POST',
				contentType: 'application/json',
				url: url,
				data: JSON.stringify(getData()),
				dataType: 'json',
				success: function(data){
					destino.html(constructHtml(data));
				}
			});
		}
		
		$('#search-form').submit(function(event){
			event.preventDefault();
			//fire_ajax_submit();
		});
		
		
		$.getJSON('${buscarConvocatoriasURL}', function(data){
			$('#convocatoria').html(constructHtml(data));
		});
		
		$('#convocatoria').change(function(){
			console.log(getData());
			if($(this).val()=='0') return;
			$('#ies').html("")
			$('#carrera').html("")
			loadData('${buscarModalidadesURL}', $('#modalidad'));
		});
		
		$('#modalidad').change(function(){
			console.log(getData());
			if($(this).val()=='0') return;
			$('#carrera').html("")
			loadData('${buscarIesURL}', $('#ies'));
		});
		
		$('#ies').change(function(){
			console.log(getData());
			if($(this).val()=='0') return;
			loadData('${buscarCarrerasURL}', $('#carrera'));
		});
		
		$('#carrera').change(function(){
			console.log(getData());
			if($(this).val()=='0') return;
			
		});
	});
</script>
