<!-- Main content -->
<section id="beca_mant" class="content container-fluid">
    
    <!-- Listado Becas -->
    <div class="panel panel-primary" v-bind:class="{ ocultar: hideBecaList }">
    	<div class="panel-heading">Becas</div>
    	<div class="panel-body">
   			<table id="tbl-becas" class="display compact table table-bordered table-hover ">
   					<thead>
						<tr class="bg-primary">
							<th class="col-md-1">Convocatoria</th>
							<th class="col-md-5">Modalidad</th>
							<th class="col-md-1">Inicio</th>
							<th class="col-md-1">T&eacute;rmino</th>
							<th class="col-md-1">Opciones</th>
						</tr>
					</thead>
					<tbody></tbody>
   			</table>
    	</div>
		<div class="panel-footer clearfix">
   			<div class="pull-left">
				<span class="btn btn-sm bg-olive" v-on:click="newBeca()">Crear Beca</span>
   			</div>
    	</div>
    </div>
    <!-- /.Listado Becas -->
    
    <!-- Formulario Beca -->
	<form class="form-horizontal" v-bind:class="{ ocultar: hideBecaForm }" autocomplete="off" id="form-beca" role="form" method="post">
		<div class="panel panel-primary">
			<div class="panel-heading">Beca</div>
			<input type="hidden" v-model="beca.id">
			<div class="panel-body">
				<div class="row">
					<div class="col-sm-4">
						<span>Convocatoria</span>
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-paperclip text-info"></span></span>
							<input type="text" class="form-control input-sm text-uppercase input-text" v-model="beca.convocatoria" id="convocatoria" name="convocatoria" placeholder="Convocatoria"/>
						</div>
					</div>
					<div class="col-sm-4">
						<span>Inicio</span>
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-calendar text-info"></span></span>
							<input type="text" class="form-control input-sm text-uppercase input-text" v-model="beca.inicio" id="inicio" name="inicio" placeholder="dd/mm/yyyy" readonly="readonly"/>
						</div>
					</div>
					<div class="col-sm-4">
						<span>T&eacute;rmino</span>
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-calendar text-info"></span></span>
							<input type="text" class="form-control input-sm text-uppercase input-text" v-model="beca.termino" id="termino" name="termino" placeholder="dd/mm/yyyy" readonly="readonly"/>
						</div>
					</div>
				</div>
				<!-- /.row -->
				<div class="row">
					<div class="col-sm-12">
						<span>Modalidad</span>
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-paperclip text-info"></span></span>
							<input type="text" class="form-control input-sm text-uppercase input-text" v-model="beca.modalidad" id="modalidad" name="modalidad" placeholder="Modalidad"/>
						</div>
					</div>
				</div>
				<!-- /.row -->
			</div>
			<!-- /.panel head-->
			<!-- panel footer -->
			<div class="panel-footer clearfix">
				<div class="pull-left">
					<span class="btn btn-sm bg-olive" v-on:click="saveBeca()">Guardar</span>
				</div>
    			<div class="pull-right">
					<span class="btn btn-sm bg-maroon" v-on:click="showBecaList()">Cancelar</span>
    			</div>
	    	</div>
	    	<!-- /.panel footer -->
		</div>
	</form>
    <!-- /.Formulario Beca -->
    
    <!-- Listado Carreras -->
    <div class="panel panel-primary" v-bind:class="{ ocultar: hideCarreraList }">
    	<div class="panel-heading">Carreras de {{becaNombre}}</div>
    	<div class="panel-body">
   			<table id="tbl-carreras" class="display compact table table-bordered table-hover ">
   					<thead>
						<tr class="bg-primary">
							<th class="col-md-1">Sem. Egreso</th>
							<th class="col-md-4">Carrera</th>
							<th class="col-md-1">Opciones</th>
						</tr>
					</thead>
					<tbody></tbody>
   			</table>
    	</div>
		<div class="panel-footer clearfix">
   			<div class="pull-left">
				<span class="btn btn-sm bg-olive" v-on:click='newCarrera(becaId)'>Crear carrera</span>
			</div>
			<div class="pull-right"> 
				<span class="btn btn-sm bg-maroon" v-on:click="showBecaList()">Volver al listado de Becas</span>
			</div>
    	</div>
    </div>
	<!-- /.Listado Carreras-->
	
	<!-- Formulario Carrera -->
	<form class="form-horizontal" v-bind:class="{ ocultar: hideCarreraForm }" autocomplete="off" id="form-carrera" role="form" method="post">
		<div class="panel panel-primary">
			<div class="panel-heading">Carrera</div>
			<input type="hidden" v-model="carrera.id">
			<input type="hidden" v-model="carrera.idBeca">
			<div class="panel-body">
				<div class="row">
					<div class="col-sm-4">
						<span>Semestre de Egreso</span>
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-paperclip text-info"></span></span>
							<input type="text" class="form-control input-sm text-uppercase input-text" v-model="carrera.semestreEgreso" id="semestreEgreso" name="semestreEgreso" placeholder="Semestre Egreso"/>
						</div>
					</div>
					<div class="col-sm-8">
						<span>Carrera</span>
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-paperclip text-info"></span></span>
							<input type="text" class="form-control input-sm text-uppercase input-text" v-model="carrera.descripcion" id="descripcion" name="descripcion" placeholder="Carrera"/>
						</div>
					</div>
				</div>
				<!-- /.row -->
			</div>
			<!-- /.panel head-->
			<!-- panel footer -->
			<div class="panel-footer clearfix">
				<div class="pull-left">
					<span class="btn btn-sm bg-olive" v-on:click="saveCarrera()">Guardar</span>
				</div>
    			<div class="pull-right">
					<span class="btn btn-sm bg-maroon" v-on:click="showCarreraList()">Cancelar</span>
    			</div>
	    	</div>
	    	<!-- /.panel footer -->
		</div>
	</form>
	<!-- /. Formulario Carrera-->
</section>
<!-- /.content -->