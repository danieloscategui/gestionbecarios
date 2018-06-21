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

<section class="sidebar">
	<!-- MENU PRINCIPAL -->
	<ul class="sidebar-menu">
		<li class="treeview">
          <a href="${becaMenuUrl}">
            <i class="fa fa-edit"></i> <span>Becas</span>
          </a>
        </li>
        <li class="treeview">
          <a href="${becarioMenuUrl}">
            <i class="fa fa-edit"></i> <span>Becarios</span>
          </a>
        </li> 
        <li class="treeview">
          <a href="${iesMenuUrl}">
            <i class="fa fa-edit"></i> <span>IES</span>
          </a>
        </li>
        <li class="treeview">
          <a href="${asesorMenuUrl}">
            <i class="fa fa-edit"></i> <span>Asesor</span>
          </a>
        </li>
        
        
		<!-- 
        <li class="treeview">
          <a href="#">
            <i class="fa fa-edit"></i> <span>Estadisticos</span>
          </a>
        </li>
        <li class="treeview">
          <a href="#">
            <i class="fa fa-table"></i> <span>Mantenimientos</span>
         </a>
        </li>
        <li>
        	<a href="#"><i class="fa fa-book"></i> <span>Documentacion</span></a>
        </li>
        <li>
          <a href="#">
            <i class="fa fa-check-square"></i> <span>Rotulos</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
            <ul class="treeview-menu">
	            <li><a href="#"><i class="fa fa-circle-o"></i>Reserva / Sufragio</a></li>
	            <li><a href="#"><i class="fa fa-circle-o"></i>Capacitacion / Simulacro</a></li>
	            <li><a href="#"><i class="fa fa-circle-o"></i>Sufragio Nacional / Extranjero</a></li>
  			</ul>
          </a>
        </li>
		 -->
       
        <!-- 
        <li class="header">SESION</li>
        <li><a href="#"><i class="fa fa-home text-blue"></i> <span>Menu Principal</span></a></li>
        <li><a href="#"><i class="fa fa-key text-red"></i> <span>Cerrar Sesion</span></a></li>
         -->
        
	</ul>
</section>