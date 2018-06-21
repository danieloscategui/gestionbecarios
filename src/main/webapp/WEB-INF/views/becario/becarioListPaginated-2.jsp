<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="/WEB-INF/taglibs/customTaglib.tld" prefix="page" %>

<!-- SELECCIONAR BECA-->
<div class="row" style="margin-left: 1px;">
	<form class="form-horizontal" autocomplete="off" id="form_select_becas">
		<div class="form-group">
			<div class="col-sm-6">
				<div class="input-group">
		        	<span class="input-group-addon"><span class="glyphicon glyphicon-list"></span></span>
				    <select class="form-control input-sm" id="cboBeca">
						<option value="0">[Seleccione Beca]</option>
						<c:forEach var="beca" items="${becas}">
							<option value="${beca.idBeca}">${beca.shortName}</option>
						</c:forEach>
					</select>
		        </div>
			</div>
		</div>
	</form>
</div>
<!-- FIN SELECCIONAR BECA -->
<!-- PANEL DE RESULTADO -->
<div class="panel panel-primary">
  <div class="panel-heading">Becarios</div>
      <div class="panel-body">
		   <div class="table table-responsive small">
				<table id="tbl_becarios" class="display table table table-striped table-sm" >
					<thead>
						<tr class="bg-primary">
							<td class="col-sm-1">Item</td>
							<td class="col-sm-3">Becario</td>
							<td class="col-sm-2">Carrera</td>
							<td class="col-sm-2">IES</td>
							<td class="col-sm-2">Sede</td>
							<td class="col-sm-1">Estado</td>
							<td class="col-sm-2">Accion</td>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>		
			</div>
	</div>
</div>
<!-- FIN PANEL DE RESULTADO -->

