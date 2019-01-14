<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!-- Menu Url Definitions -->
<spring:url value="/home" var="homeUrl"/>

<spring:url value="/dashboard" var="dashboardMenuUrl"/>
<spring:url value="/becarios" var="becariosMenuUrl"/>
<spring:url value="/ies" var="iesMenuUrl"/>
<spring:url value="/asesor" var="asesorMenuUrl"/>
<spring:url value="/beca" var="becaMenuUrl"/>
<spring:url value="/tramite" var="tramiteMenuUrl"/>
<spring:url value="/pagoAcademico" var="pagoAcademicoMenuUrl"/>


    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">


      <!-- search form (Optional) -->
      <form action="#" method="get" class="sidebar-form">
        <div class="input-group">
          <input type="text" name="q" class="form-control" placeholder="Search...">
          <span class="input-group-btn">
              <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
              </button>
            </span>
        </div>
      </form>
      <!-- /.search form -->

      <!-- Sidebar Menu -->
      <ul class="sidebar-menu" data-widget="tree">
        <li class="header">Menu</li>
        <!-- Optionally, you can add icons to the links -->
        <li><a href="${becariosMenuUrl}"><i class="fa fa-users text-blue"></i> <span>Becarios por Beca</span></a></li>
        <li><a href="${iesMenuUrl}"><i class="fa fa-university text-blue"></i> <span>IES</span></a></li>
        <li><a href="#"><i class="fa fa-link"></i> <span>Another Link</span></a></li>
        <li class="treeview">
          <a href="#"><i class="fa fa-link"></i> <span>Multilevel</span>
            <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="#">Link in level 2</a></li>
            <li><a href="#">Link in level 2</a></li>
          </ul>
        </li>
      </ul>
      <!-- /.sidebar-menu -->
    </section>
    <!-- /.sidebar -->
