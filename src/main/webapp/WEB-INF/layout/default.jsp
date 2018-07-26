<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html>

<html lang="es">
<head>
	<tiles:insertAttribute name="head"/>
	<tiles:insertAttribute name="js-libraries"/>
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<header class="main-header">
			<tiles:insertAttribute name="header"/>
		</header>
		<aside class="main-sidebar">
			<tiles:insertAttribute name="sidebar"/>
		</aside>
		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<tiles:insertAttribute name="content"/>
		</div>
		<footer class="main-footer">
    	<div class="pull-right hidden-xs">
      		<b>Version</b> 2.4.0
    	</div>
    	<strong>Copyright &copy; 2014-2016 <a href="https://adminlte.io">Almsaeed Studio</a>.</strong> All rights reserved.
	  </footer>
	</div>
</body>
</html>