<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html >
<html lang="es">
<head>
	<tiles:insertAttribute name="head"/>
</head>

<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<header class="main-header">
			<tiles:insertAttribute name="header"/>
	  	</header>
		<aside class="main-sidebar">
			<tiles:insertAttribute name="sidebar"/>
	  	</aside>
		<div class="content-wrapper">
		    <section class="content">
				<tiles:insertAttribute name="body"/>
		    </section>
		</div>
	  	<footer>
			<tiles:insertAttribute name="footer"/>
	  	</footer>
	</div>
</body>

<!-- Icons -->
<script src="https://unpkg.com/feather-icons/dist/feather.min.js"></script>
<script>
	feather.replace()
</script>
<script type="text/javascript" src="<c:url value='/resources/jquery_gestion/gestion_becario.js'/>" ></script>

</html>