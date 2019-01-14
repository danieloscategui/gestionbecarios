<!-- Main content -->
<section id="app" class="content container-fluid">

  <!--------------------------
    | Your Page Content Here |
    -------------------------->
    
    <!-- Listado IES -->
    <div class="panel panel-primary" v-bind:class="{ ocultar: ocultarListaIes }">
    	<div class="panel-heading">Instituciones Educativas</div>
    	<div class="panel-body">
    		
   			<table id="tbl-instituciones" class="display compact table table-bordered table-hover ">
   					<thead>
						<tr class="bg-primary">
							<th class="col-md-4">Institución</th>
							<th class="col-md-2">Tipo Ies</th>
							<th class="col-md-2">Tipo Gestión</th>
							<th class="col-md-1">Opciones</th>
						</tr>
					</thead>
					<tbody></tbody>
   			</table>
    	</div>
		<div class="panel-footer clearfix">
   			<div class="pull-left">
				<span class="btn btn-sm bg-olive" v-on:click="nuevoIES()">Crear IES</span>
   			</div>
    	</div>
    </div>
    <!-- /.Listado IES -->
    
    <!-- Formulario IES -->
	<form class="form-horizontal" v-bind:class="{ ocultar: ocultarFormulario }" autocomplete="off" id="form-ies" role="form" method="post">
		<div class="panel panel-primary">
			<div class="panel-heading">Institución</div>
			<input type="hidden" v-model="institucion.id">
			<div class="panel-body">
				<div class="row">
					<div class="col-sm-6">
						<span>Institución</span>
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-paperclip text-info"></span></span>
							<input type="text" class="form-control input-sm text-uppercase input-text" v-model="institucion.nombre" id="nombre" name="nombre" placeholder="Nombre"/>
						</div>
					</div>
					<div class="col-sm-3">
						<span>Tipo IES</span>
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-paperclip text-info"></span></span>
							<select class="form-control input-sm"
								v-model="institucion.idTipoIes">
								<option disabled value="0">[ SELECCIONE TIPO IES ]</option>
								<option v-for="ies in tipoIes"
										v-bind:value="ies.id">{{ies.descripcion}}</option>
							</select>
						</div>
					</div>
					<div class="col-sm-3">
						<span>Tipo Gestión</span>
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-paperclip text-info"></span></span>
							<select class="form-control input-sm"
								v-model="institucion.idTipoGestion">
								<option disabled value="0">[ SELECCIONE TIPO GESTION ]</option>
								<option v-for="gestion in tipoGestion"
										v-bind:value="gestion.id">{{gestion.descripcion}}</option>
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
							<input type="text" class="form-control input-sm text-uppercase input-text" v-model="institucion.contacto" id="contacto" name="contacto" placeholder="Contacto"/>
						</div>
					</div>
					<div class="col-sm-3">
						<span>Telefono</span>
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-paperclip text-info"></span></span>
							<input type="text" class="form-control input-sm text-uppercase input-text" v-model="institucion.telefono" id="telefono" name="telefono" placeholder="Teléfono"/>
						</div>
					</div>
					<div class="col-sm-3">
						<span>Correo</span>
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-paperclip text-info"></span></span>
							<input type="text" class="form-control input-sm text-uppercase input-text" v-model="institucion.correo" id="correo" name="correo" placeholder="Correo"/>
						</div>
					</div>
				</div>
				<!-- /.row -->
			</div>
			<!-- /.panel head-->
			<!-- panel footer -->
			<div class="panel-footer clearfix">
    			<div class="pull-right">
					<span class="btn btn-sm bg-olive" v-on:click="guardarIes()">Guardar</span>
					<span class="btn btn-sm bg-maroon" v-on:click="verListado()">Cancelar</span>
    			</div>
	    	</div>
	    	<!-- /.panel footer -->
		</div>
	</form>
    <!-- /.Formulario IES -->
    
    <!-- Listado Sedes -->
    <div class="panel panel-primary" v-bind:class="{ ocultar: ocultarListaSedes }">
    	<div class="panel-heading">Sedes de {{iesNombre}}</div>
    	<div class="panel-body">
   			<table id="tbl-sedes" class="display compact table table-bordered table-hover ">
   					<thead>
						<tr class="bg-primary">
							<th class="col-md-2">Región</th>
							<th class="col-md-4">Sede</th>
							<th class="col-md-1">Opciones</th>
						</tr>
					</thead>
					<tbody></tbody>
   			</table>
    	</div>
		<div class="panel-footer clearfix">
   			<div class="pull-left">
				<span class="btn btn-sm bg-olive" v-on:click="nuevaSede()">Crear Sede</span>
   			</div>
    	</div>
    </div>
    <!-- /.Listado Sedes -->
</section>
<!-- /.content -->