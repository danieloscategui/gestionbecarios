<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html >
<html>
<head>
	<title>GB</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/bootstrap/easyui.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/color.css">
    <link rel="stylesheet" type="text/css" href="_easyui/demo/demo.css">
    <link rel="stylesheet" type="text/css" href="jqTree/jqtree.css">
    <link rel="stylesheet" href="components/font-awesome/css/font-awesome.min.css">
    
    <script type="text/javascript" src="https://www.jeasyui.com/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="https://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="jqTree/tree.jquery.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="plugins/axios/axios.min.js"></script>

<body>
		<div class="easyui-layout" style="width:100%; height: 700px;">
			<div data-options="region:'north'" style="height:40px; background-color: #034f84;">
					<span class="h6 text-light lead" style="color: #fff;">Gestión Becarios</span>
			</div>
			<div data-options="region:'west',split:true" title="Menu" style="width:15%;padding:10px;">
				<tiles:insertAttribute name="sidebar"/>
			</div>
			<div data-options="region:'center',title:'',iconCls:'icon-ok'" style="width:75%; ">
				<tiles:insertAttribute name="content"/>
			</div>
		</div>

</body>
</html>