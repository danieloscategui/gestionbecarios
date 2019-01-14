<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>
<head>
	<tiles:insertAttribute name="head"/>
</head>

<body class="hold-transition skin-blue-light sidebar-mini">
	<div class="wrapper">
		<!-- Main Header -->
		<header class="main-header">
			<tiles:insertAttribute name="header"/>
		</header>
		<!-- Left side column. contains the logo and sidebar -->
		<aside class="main-sidebar">
			<tiles:insertAttribute name="sidebar"/>
		</aside>
		<!-- Content Wrapper. Contains page content -->
  		<div class="content-wrapper">
  			<tiles:insertAttribute name="content"/>
  		</div>
		<!-- ./Content Wrapper -->

		<!-- Main Footer -->
		<footer class="main-footer">
		  <!-- To the right -->
		  <div class="pull-right hidden-xs">
		    Anything you want
		  </div>
		  <!-- Default to the left -->
		  <strong>Copyright &copy; 2018 <a href="#">dospe</a>.</strong> All rights reserved.
		</footer>
	</div>
</body>

<tiles:insertAttribute name="js-base"/>
<tiles:insertAttribute name="js-custom"/>
<script>
    $(function () {
    $('#example1').DataTable()
    $('#example2').DataTable({
      'paging'      : true,
      'lengthChange': false,
      'searching'   : false,
      'ordering'    : true,
      'info'        : true,
      'autoWidth'   : false
    })
  })
</script>
</html>