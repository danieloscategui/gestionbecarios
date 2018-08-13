<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!-- Menu Url Definitions -->
<spring:url value="/home" var="homeUrl"/>

<spring:url value="/dashboard" var="dashboardMenuUrl"/>
<spring:url value="/becario" var="becarioMenuUrl"/>
<spring:url value="/ies" var="iesMenuUrl"/>
<spring:url value="/asesor" var="asesorMenuUrl"/>
<spring:url value="/beca" var="becaMenuUrl"/>
<spring:url value="/tramite" var="tramiteMenuUrl"/>
<spring:url value="/pagoAcademico" var="pagoAcademicoMenuUrl"/>

<div id="menu_tree">
	
</div>

<script type="text/javascript">
	var data = [
		{
			name: 'Dashboard',
			children: [
				{name:'child1'},
				{name:'child2'}
			]
		},{
			name:'Mantenimientos',
			children: [
				'<a href="${asesorMenuUrl}">Asesor</a>',
				'<a href="${becarioMenuUrl}">Becario</a>'
			]
		}
	];
	
	$(function(){
		$('#menu_tree').tree({
			data: data,
			closedIcon: $('<i class="fa fa-arrow-circle-right"></i>'),
		    openedIcon: $('<i class="fa fa-arrow-circle-down"></i>'),
		    autoEscape: false,
		    autoOpen: true
		});
	});
</script>