<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<title>Becarios</title>

<meta charset="utf-8" >

<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, shrink-to-fit=no" />

<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
<script src="<c:url value="/resources/jqwidgets/jqxcore.js" />"></script>
<script src="<c:url value="/resources/jqwidgets/jqxdata.js" />"></script>
<script src="<c:url value="/resources/jqwidgets/jqxbuttons.js" />"></script>
<script src="<c:url value="/resources/jqwidgets/jqxscrollbar.js" />"></script>
<script src="<c:url value="/resources/jqwidgets/jqxlistbox.js" />"></script>
<script src="<c:url value="/resources/jqwidgets/jqxdropdownlist.js" />"></script>
<script src="<c:url value="/resources/jqwidgets/jqxdatatable.js" />"></script>
<script src="<c:url value="/resources/jqwidgets/jqxpanel.js" />"></script>
<script src="<c:url value="/resources/jqwidgets/jqxradiobutton.js" />"></script>
<script src="<c:url value="/resources/jqwidgets/jqxinput.js" />"></script>
<script src="<c:url value="/resources/js/demo.js" />"></script>

<script src="<c:url value="/resources/dist/js/bootstrap.min.js" />"></script>

<link href="<c:url value="/resources/jqwidgets/styles/jqx.base.css" />" rel="stylesheet" type="text/css"/>
<link href="<c:url value="/resources/jqwidgets/styles/jqx.bootstrap.css" />" rel="stylesheet" type="text/css"/>
<link href="<c:url value="/resources/css/reset.css" />" rel="stylesheet" type="text/css"/>
<link href="<c:url value="/resources/dist/css/bootstrap.css" />" rel="stylesheet" type="text/css"/>
<link href="<c:url value="/resources/css/dashboard.css" />" rel="stylesheet" type="text/css"/>

<!-- 
<script type="text/javascript" src="http://rawgit.com/vitmalina/w2ui/master/dist/w2ui.min.js"></script>
<link rel="stylesheet" type="text/css" href="http://rawgit.com/vitmalina/w2ui/master/dist/w2ui.min.css" />
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jqgrid/4.6.0/js/jquery.jqGrid.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3b.4/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
 -->
 
    
</head>
<body>

	<nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0">
		<a class="navbar-brand col-sm-3 col-md-2 mr-0" href="#">Becarios JK</a>
		<input class="form-control form-control-dark w-100" type="text" placeholder="Buscar" aria-label="Buscar">
		<ul class="navbar-nav px-3">
			<li class="nav-item text-nowrap">
				<a class="nav-link" href="#">Sign out</a>
			</li>
		</ul>
	</nav>
	
	<div class="container-fluid">
		<div class="row">
			<nav class="col-md-2 d-none d-md-block bg-light sidebar">
				<div class="sidebar-sticky">
					<ul class="nav flex-column">
						<li class="nav-item">
							<a class="nav-link active" href="#">
								<span data-feather="home"></span>
								Dashboard <span class="sr-only">(current)</span>
							</a>
						</li>
						<li class="nav-item">
			                <a class="nav-link" href="#">
			                 	<span data-feather="file"></span>
			                  	Orders
			                </a>
			             </li>
			             <li class="nav-item">
			                <a class="nav-link" href="#">
			                  <span data-feather="shopping-cart"></span>
			                  Products
			                </a>
			             </li>
			             <li class="nav-item">
			                <a class="nav-link" href="#">
			                  <span data-feather="users"></span>
			                  Customers
			                </a>
			              </li>
			              <li class="nav-item">
			                <a class="nav-link" href="#">
			                  <span data-feather="bar-chart-2"></span>
			                  Reports
			                </a>
			              </li>
			              <li class="nav-item">
			                <a class="nav-link" href="#">
			                  <span data-feather="layers"></span>
			                  Integrations
			                </a>
			              </li>
					</ul>
					
				</div>
			</nav>
			
			<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
				<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
					<h1 class="h2">Dashboard</h1>
					<div class="btn-toolbar mb-2 mb-md-0">
						<div class="btn-group mr-2">
							<button class="btn btn-sm btn-outline-secondary">Share</button>
							<button class="btn btn-sm btn-outline-secondary">Export</button>
						</div>
						<button class="btn btn-sm btn-outline-secondary dropdown-toggle">
							<span data-feather="calendar"></span>
							This week
						</button>
					</div>
				</div>
				
				<canvas class="my-4" id="myChart" width="900" height="380"></canvas>
				
				 <h2>Section title</h2>
		          <div class="table-responsive">
		            <table class="table table-striped table-sm">
		              <thead>
		                <tr>
		                  <th>#</th>
		                  <th>Header</th>
		                  <th>Header</th>
		                  <th>Header</th>
		                  <th>Header</th>
		                </tr>
		              </thead>
		              <tbody>
		                <tr>
		                  <td>1,001</td>
		                  <td>Lorem</td>
		                  <td>ipsum</td>
		                  <td>dolor</td>
		                  <td>sit</td>
		                </tr>
		                <tr>
		                  <td>1,002</td>
		                  <td>amet</td>
		                  <td>consectetur</td>
		                  <td>adipiscing</td>
		                  <td>elit</td>
		                </tr>
		                <tr>
		                  <td>1,003</td>
		                  <td>Integer</td>
		                  <td>nec</td>
		                  <td>odio</td>
		                  <td>Praesent</td>
		                </tr>
		                <tr>
		                  <td>1,003</td>
		                  <td>libero</td>
		                  <td>Sed</td>
		                  <td>cursus</td>
		                  <td>ante</td>
		                </tr>
		                <tr>
		                  <td>1,004</td>
		                  <td>dapibus</td>
		                  <td>diam</td>
		                  <td>Sed</td>
		                  <td>nisi</td>
		                </tr>
		                <tr>
		                  <td>1,005</td>
		                  <td>Nulla</td>
		                  <td>quis</td>
		                  <td>sem</td>
		                  <td>at</td>
		                </tr>
		                <tr>
		                  <td>1,006</td>
		                  <td>nibh</td>
		                  <td>elementum</td>
		                  <td>imperdiet</td>
		                  <td>Duis</td>
		                </tr>
		                <tr>
		                  <td>1,007</td>
		                  <td>sagittis</td>
		                  <td>ipsum</td>
		                  <td>Praesent</td>
		                  <td>mauris</td>
		                </tr>
		                <tr>
		                  <td>1,008</td>
		                  <td>Fusce</td>
		                  <td>nec</td>
		                  <td>tellus</td>
		                  <td>sed</td>
		                </tr>
		                <tr>
		                  <td>1,009</td>
		                  <td>augue</td>
		                  <td>semper</td>
		                  <td>porta</td>
		                  <td>Mauris</td>
		                </tr>
		                <tr>
		                  <td>1,010</td>
		                  <td>massa</td>
		                  <td>Vestibulum</td>
		                  <td>lacinia</td>
		                  <td>arcu</td>
		                </tr>
		                <tr>
		                  <td>1,011</td>
		                  <td>eget</td>
		                  <td>nulla</td>
		                  <td>Class</td>
		                  <td>aptent</td>
		                </tr>
		                <tr>
		                  <td>1,012</td>
		                  <td>taciti</td>
		                  <td>sociosqu</td>
		                  <td>ad</td>
		                  <td>litora</td>
		                </tr>
		                <tr>
		                  <td>1,013</td>
		                  <td>torquent</td>
		                  <td>per</td>
		                  <td>conubia</td>
		                  <td>nostra</td>
		                </tr>
		                <tr>
		                  <td>1,014</td>
		                  <td>per</td>
		                  <td>inceptos</td>
		                  <td>himenaeos</td>
		                  <td>Curabitur</td>
		                </tr>
		                <tr>
		                  <td>1,015</td>
		                  <td>sodales</td>
		                  <td>ligula</td>
		                  <td>in</td>
		                  <td>libero</td>
		                </tr>
		              </tbody>
		            </table>
		          </div>
			</main>
		</div>
	</div>
	
</body>

<!--
<script type="text/javascript" src="<c:url value="/resources/js/empadronamiento-ui.js"/>"></script>
  -->
<!-- Icons -->
<script src="https://unpkg.com/feather-icons/dist/feather.min.js"></script>
<script>
	feather.replace()
</script>

<!-- Graphs -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.min.js"></script>
<script>
     var ctx = document.getElementById("myChart");
     var myChart = new Chart(ctx, {
       type: 'line',
       data: {
         labels: ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"],
         datasets: [{
           data: [15339, 21345, 18483, 24003, 23489, 24092, 12034],
           lineTension: 0,
           backgroundColor: 'transparent',
           borderColor: '#007bff',
           borderWidth: 4,
           pointBackgroundColor: '#007bff'
         }]
       },
       options: {
         scales: {
           yAxes: [{
             ticks: {
               beginAtZero: false
             }
           }]
         },
         legend: {
           display: false,
         }
       }
     });
    </script>
</html>