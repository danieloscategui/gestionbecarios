<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!-- BOTON AGREGAR BECA-->
<div class="row">
	<div class="col-sm-6">
		<a data-toggle="modal" href="" class="btn btn-primary btn-sm" onclick="btnAddOrEdit('#modal_beca', 'beca', 'Agregar Beca');">
		<span class="glyphicon glyphicon-plus"></span>&nbsp;&nbsp;Agregar Beca</a>
		<a data-toggle="modal" href="" class="btn btn-primary btn-sm" onclick="descargarFormato();">
		<span class="glyphicon glyphicon-cloud-download"></span>&nbsp;&nbsp;Descargar Excel</a><br><br>
	</div>
</div>
<!-- FIN BOTON AGREGAR BECA  -->
<!-- PANEL DE RESULTADO -->
<div class="panel panel-primary">
  <div class="panel-heading">Becas Registradas</div>
      <div class="panel-body">
		   <div class="table table-responsive small">
				<table id="tbl_becas_registradas" class="display table table-striped table-sm" >
					<thead>
						<tr class="bg-primary">
							<td class="col-md-1">Item</td>
							<td class="col-md-1">Convocatoria</td>
							<td class="col-md-4">Modalidad</td>
							<td class="col-md-1">Accion</td>
						</tr>
					</thead>
					<tbody>
						<!-- 
						<tr>
							<td>01</td>
							<td>2017</td>
							<td>Modalidad Nueva</td>
							<td>
								<a data-toggle="modal" href="" class="btn btn-info btn-xs" onclick="btnAddOrEdit('#modal_beca', 'beca', 'Editar Beca');">
								<span class="glyphicon glyphicon-pencil" aria-hidden="true" data-toggle="tooltip" title="Editar"></span></a>
								<a href="" class="btn btn-danger btn-xs" onclick="" style="margin-left:10px">
								<span class="glyphicon glyphicon-trash" aria-hidden="true" data-toggle="tooltip" title="Eliminar"></span></a>
							</td>
						</tr>
						 -->
					</tbody>
				</table>		
			</div>
	</div>
</div>
<!-- FIN PANEL DE RESULTADO -->



<!-- MODAL BECA -->
<div class="modal fade" id="modal_beca" role="dialog" data-keyboard="false" data-backdrop="static" tabindex="-1">
	<div class="modal-dialog">
		<div class="panel panel-primary">
			<div class="panel-heading ">
			    <span class="panel-title" id="titulo_beca">Editar Beca</span>
			</div>
		    <div class="panel-body">
				<form class="form-horizontal" autocomplete="off" id="form_beca">
					<input type="hidden" class="form-control" id="idBeca"/>
					<div class="form-group">
						<div class="col-sm-12">
							<div class="input-group">
					        	<span class="input-group-addon"><span class="glyphicon glyphicon-road"></span></span>
								<input type="text" class="form-control" id="convocatoria" placeholder="Convocatoria"/>
					        </div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-12">
							<div class="input-group">
					        	<span class="input-group-addon"><span class="glyphicon glyphicon-barcode"></span></span>
								<input type="text" class="form-control" id="modalidad" placeholder="Modalidad"/>
					        </div>
					    </div>
					</div>
			        <div class="form-group">	
			        	<div class="col-sm-12">
							<div class="input-group">
			              		<span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
								<input type="text" class="form-control" id="inicio" placeholder="Fecha Inicio"/>
			             	</div>
			        	</div>
			        </div>
			        <div class="form-group">	
			        	<div class="col-sm-12">
							<div class="input-group">
			              		<span class="input-group-addon"><span class="glyphicon glyphicon-barcode"></span></span>
								<input type="text" class="form-control" id="termino" placeholder="Fecha Termino"/>
			             	</div>
			        	</div>
			 		</div>						        
				</form>
			</div>
			<div class="panel-footer">
				<button class="btn btn-orange pull-left" type="button" id="addBeca" onclick ="guardarBeca()"> <span class="glyphicon glyphicon-floppy-disk"></span> &nbsp;Guardar</button>
				<a class="btn btn-danger pull-right" style="margin-left:10px" data-dismiss="modal"><span class="glyphicon glyphicon-log-in"></span> &nbsp;Cerrar</a>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
</div>
<!-- FIN MODAL BECA -->

