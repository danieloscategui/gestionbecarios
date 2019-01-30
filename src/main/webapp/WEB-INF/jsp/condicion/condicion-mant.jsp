<!-- Main content -->
<section id="condicion_mant" class="content container-fluid">
    
    <!-- Listado Condicion -->
    <div class="panel panel-primary">
    	<div class="panel-heading">Condiciones</div>
    	<div class="panel-body">
    		<btn-toggle :values="estados" :default=1 @clicked="estadoSelected"></btn-toggle>
    		<br>
    		<div class="col-md-6" style="padding-left: 0px;">
   			<table id="tbl-condiciones" class="display compact table table-bordered table-hover">
   					<thead>
						<tr class="bg-primary">
							<th class="col-md-2">Condici&oacute;n</th>
							<th class="col-md-1">Opciones</th>
						</tr>
					</thead>
					<tbody></tbody>
   			</table>
    		</div>
    	</div>
		<div class="panel-footer clearfix">
   			<div class="pull-left">
				<span class="btn btn-sm bg-olive">Crear Condici&oacute;n</span>
   			</div>
    	</div>
    </div>
    <!-- /.Listado Condicion -->
    
    <!-- Formulario Condicion -->
	<form class="form-horizontal" autocomplete="off" id="form-condicion" role="form" method="post">
		<div class="panel panel-primary">
			<div class="panel-heading">Instituci&oacute;n</div>
			<input type="hidden">
			<div class="panel-body">
				<div class="row">
					<div class="col-sm-6">
						<span>Instituci&oacute;n</span>
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-paperclip text-info"></span></span>
							<input type="text" class="form-control input-sm text-uppercase input-text" id="nombre" name="nombre" placeholder="Nombre"/>
						</div>
					</div>
					<div class="col-sm-3">
						<span>Tipo IES</span>
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-paperclip text-info"></span></span>
							<select class="form-control input-sm">
								<option disabled value="0">[ SELECCIONE TIPO IES ]</option>
							</select>
						</div>
					</div>
					<div class="col-sm-3">
						<span>Tipo Gesti&oacute;n</span>
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-paperclip text-info"></span></span>
							<select class="form-control input-sm">
								<option disabled value="0">[ SELECCIONE TIPO GESTI&Oacute;N ]</option>
							</select>
						</div>
					</div>
				</div>
				<!-- /.row -->
				<div class="row">
					<div class="col-sm-6">
						<span>Contacto</span>
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-paperclip text-info"></span></span>
							<input type="text" class="form-control input-sm text-uppercase input-text" id="contacto" name="contacto" placeholder="Contacto"/>
						</div>
					</div>
					<div class="col-sm-3">
						<span>Tel&eacute;fono</span>
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-paperclip text-info"></span></span>
							<input type="text" class="form-control input-sm text-uppercase input-text" id="telefono" name="telefono" placeholder="Tel&eacute;fono"/>
						</div>
					</div>
					<div class="col-sm-3">
						<span>Correo</span>
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-paperclip text-info"></span></span>
							<input type="text" class="form-control input-sm text-uppercase input-text" id="correo" name="correo" placeholder="Correo"/>
						</div>
					</div>
				</div>
				<!-- /.row -->
			</div>
			<!-- /.panel head-->
			<!-- panel footer -->
			<div class="panel-footer clearfix">
				<div class="pull-left">
					<span class="btn btn-sm bg-olive">Guardar</span>
				</div>
    			<div class="pull-right">
					<span class="btn btn-sm bg-maroon">Cancelar</span>
    			</div>
	    	</div>
	    	<!-- /.panel footer -->
		</div>
	</form>
    <!-- /.Formulario Condicion -->
    
</section>
<!-- /.content -->
