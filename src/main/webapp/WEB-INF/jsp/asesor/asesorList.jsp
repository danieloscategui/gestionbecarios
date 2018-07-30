<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<section class="content">

<!-- BOTON AGREGAR BECA-->
<div class="row">
	<div class="col-sm-6">
		<a data-toggle="modal" href="" class="btn btn-primary btn-sm" onclick="asesor.add();">
		<span class="glyphicon glyphicon-plus"></span>&nbsp;&nbsp;Agregar Beca</a>
	</div>
</div><br/>
<!--./BOTON AGREGAR BECA  -->

<!-- PANEL DE RESULTADO -->
<div class="panel panel-primary">
	<div class="panel-heading">Asesores registrados</div>
		<div class="panel-body">
			 <div class="table table-responsive small"> <!-- display strip compact hover row-border -->
				  <table id="tbl_asesor" class="table table-striped" >
					  <thead>
						  <tr class="bg-primary">
							  <td class="col-md-1">Asesor</td>
							  <td class="col-md-1">Acci&oacute;n</td>
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
<!-- ./PANEL DE RESULTADO -->


</section>

<!-- MODAL ASESOR -->
<div class="modal fade" id="modal_asesor" role="dialog" data-keyboard="false" data-backdrop="static" tabindex="-1">
	<div class="modal-dialog">
		<div class="panel panel-primary">
			<div class="panel-heading ">
			    <span class="panel-title" id="titulo_asesor">Editar Asesor</span>
			</div>
		    <div class="panel-body">
				<form class="form-horizontal" autocomplete="off" id="form_asesor">
					<ul class="errorMessages"></ul>
					<input type="hidden" id="action"/>
					<input type="hidden" id="id"/>
					<div class="form-group">
						<div class="col-sm-12">
							<div class="input-group">
					        	<span class="input-group-addon"><span class="glyphicon glyphicon-road"></span></span>
								<input type="text" class="form-control" id="nombre" placeholder="Nombre"/>
					        </div>
						</div>
					</div>
				</form>
			</div>
			<div class="panel-footer">
				<button class="btn btn-orange pull-left" type="button" id="addAsesor" onclick ="asesor.save()"> <span class="glyphicon glyphicon-floppy-disk"></span> &nbsp;Guardar</button>
				<a class="btn btn-danger pull-right" style="margin-left:10px" data-dismiss="modal"><span class="glyphicon glyphicon-log-in"></span> &nbsp;Cerrar</a>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
</div>
<!-- ./ MODAL ASESOR -->

<script type="text/javascript">
	$(document).ready(function() { 
		asesor.init();
	})
</script>
<script type="text/javascript" src="<c:url value='/js/asesor.js'/>" ></script>
