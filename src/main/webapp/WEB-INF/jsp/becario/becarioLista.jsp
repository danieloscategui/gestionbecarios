<!-- Main content -->
<section id="app" class="content container-fluid">

  <!--------------------------
    | Your Page Content Here |
    -------------------------->
    
    <!-- Listado -->
    <div class="panel panel-primary" v-bind:class="{ ocultar: ocultarLista }">
    	<div class="panel-heading">Becas</div>
    	<div class="panel-body">
    		<div>
    			<select id="cboBecas" class="col-md-12 form-control input-sm select2"
							@change="loadBecarios()"
							v-model="idBeca">
							<option value="0">[ SELECCIONE UNA BECA ]</option>
							<option v-for="beca in becas"
									v-bind:value="beca.id">{{beca.convocatoria}} - {{beca.modalidad}}</option>
					</select>
    		</div>
    		<br/><br/>
    		<div>
    			<table id="tbl-becarios" class="display compact table table-bordered table-hover">
    					<thead>
							<tr class="bg-primary">
								<th class="col-sm-1">DNI</th>
								<th class="col-sm-4">Becario</th>
								<th class="col-sm-4">Carrera</th>
								<th class="col-sm-1">Estado</th>
								<th class="col-sm-1">Asesor</th>
								<th class="col-sm-1">Opciones</th>
							</tr>
						</thead>
						<tbody></tbody>
    			</table>
    		</div>
    	</div>
    </div>
    
    <!-- /.Listado -->
    
    <!-- Formulario -->
	<form class="form-horizontal" v-bind:class="{ ocultar: ocultarFormulario }" autocomplete="off" id="form-becario" role="form" method="post">
    	<div class="panel panel-primary">
    		<div class="panel-heading">Becario</div>
    		<input type="hidden" v-model="becario.id">
    		<div class="panel-body">
    			<div class="row">
    				<div class="col-sm-6">
						<span>Asesor</span>
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-user text-info"></span></span>
							<!-- <input type="text" class="form-control input-sm text-uppercase letter" id="asesor" name="asesor" placeholder="Asesor"/> -->
							<select class="col-md-12 form-control input-sm select2"
								v-model="becario.idAsesor">
								<option disabled value="0">[ SELECCIONE ASESOR ]</option>
								<option v-for="asesor in asesores"
										v-bind:value="asesor.id">{{asesor.nombre}}</option>
							</select>
						</div>
					</div>
					<div class="col-sm-6">
						<span>Beca</span>
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-book text-info"></span></span>
							<!-- <input type="text" class="form-control input-sm" id="beca" name="beca" placeholder="Beca"/>  -->
							<select class="form-control input-sm" id="idBeca"
								@change="loadCarrerasPorBeca()"
								v-model="becario.idBeca">
								<option disabled value="">[SELECCIONE BECA]</option>
								<option v-for="beca in becas"
										v-bind:value="beca.id">{{beca.convocatoria}} - {{beca.modalidad}}</option>
							</select>
						</div>
						
					</div>
    			</div>
				<!-- /.row -->
				<div class="row">
					<div class="col-sm-6">
						<span>IES</span>
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-home text-info"></span></span>
							<!-- 
							<input type="text" class="form-control input-sm" id="ies" name="ies" placeholder="Ies"/>
							 -->
							<select class="form-control input-sm" id="idIes"
								@change="loadSedesPorIes()"
								v-model="becario.idIes">
								<option disabled value="0">[SELECCIONE INSTITUCIÓN]</option>
								<option v-for="ie in ies"
										v-bind:value="ie.id">{{ie.nombre}}</option>
							</select>
						</div>
					</div>
					<div class="col-sm-6">
						<span>Carrera</span>
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-education text-info"></span></span>
							<select class="form-control input-sm" id="idCarrera"
								v-model="becario.idCarrera">
								<option disabled value="0">[SELECCIONE CARRERA]</option>
								<option v-for="carrera in carreras"
										v-bind:value="carrera.id">{{carrera.descripcion}}</option>
							</select>
						</div>
					</div>
				</div>
				<!-- /.row -->
				
				<div class="row">
					<div class="col-sm-3">
						<span>Sede</span>
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-th text-info"></span></span>
							<select class="form-control input-sm" id="idSedeEstudio"
								v-model="becario.idSedeEstudio">
								<option disabled value="0">[SELECCIONE SEDE]</option>
								<option v-for="sede in sedes"
										v-bind:value="sede.id">{{sede.region}} - {{sede.sede}}</option>
							</select>
						</div>
					</div>
					<div class="col-sm-3">
						<span>Expediente</span>
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-paperclip text-info"></span></span>
							<input type="text" class="form-control input-sm text-uppercase input-text" v-model="becario.numeroExpediente" id="expendiente" name="expendiente" placeholder="Expediente"/>
						</div>
					</div>
					<div class="col-sm-3">
						<span>Resolución Adj.</span>
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-file text-info"></span></span>
							<input type="text" class="form-control input-sm text-uppercase input-text" v-model="becario.resolucionAdjudicacion" id="resolucion" name="resolucion" placeholder="Resolución"/>
						</div>
					</div>
					<div class="col-sm-3">
						<span>F. Resolución</span>
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-calendar text-info"></span></span>
							<input type="text" class="form-control input-sm" v-model="becario.resolucionAdjudicacionFecha" id="fechaResolucion" name="fechaResolucion" placeholder="dd/mm/yyyy"/>
						</div>
					</div>
    			</div>
    			<!-- /.row -->
    			
    			<div class="row">
    				<div class="col-sm-3">
						<span>Región Procedencia</span>
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-chevron-right text-info"></span></span>
							<input type="text" class="form-control input-sm text-uppercase input-text" v-model="becario.regionProcedencia" id="regionProcedencia" name="regionProcedencia" placeholder="Región Procedencia"/>
						</div>
					</div>
					<div class="col-sm-3">
						<span>Provincia Procedencia</span>
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-chevron-right text-info"></span></span>
							<input type="text" class="form-control input-sm text-uppercase input-text" v-model="becario.provinciaProcedencia" id="provinciaProcedencia" name="provinciaProcedencia" placeholder="Provincia Procedencia"/>
						</div>
					</div>
					<div class="col-sm-3">
						<span>Distrito Procedencia</span>
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-chevron-right text-info"></span></span>
							<input type="text" class="form-control input-sm text-uppercase input-text" v-model="becario.distritoProcedencia" id="distritoProcedencia" name="distritoProcedencia" placeholder="Distrito Procedencia"/>
						</div>
					</div>
    			</div>
    			<!-- /.row -->
    			
				<div class="row">
					<div class="col-sm-3">
						<span>DNI</span>
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-credit-card text-info"></span></span>
							<input type="text" class="form-control input-sm input-number" v-model="becario.dni" id="dni" name="dni" placeholder="DNI" maxlength="8"/>
						</div>
					</div>
					<div class="col-sm-3">
						<span>Nombre</span>
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-user text-info"></span></span>
							<input type="text" class="form-control input-sm text-uppercase input-text" v-model="becario.nombres" id="nombre" name="nombre" placeholder="Nombre" maxlength="50"/>
						</div>
					</div>
					<div class="col-sm-3">
						<span>Apellidos</span>
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-user text-info"></span></span>
							<input type="text" class="form-control input-sm text-uppercase input-text" v-model="becario.apellidos" id="apellidos" name="apellidos" placeholder="Apellidos" maxlength="50"/>
						</div>
					</div>
					<div class="col-sm-3">
						<span>F. Nac</span>
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-calendar text-info"></span></span>
							<input type="text" class="form-control input-sm" v-model="becario.fechaNacimiento" placeholder="dd/mm/yyyy" id="fechaNacimiento" name="fechaNacimiento" maxlength="50"/>
						</div>
					</div>
				</div>
    			<!-- /.row -->
    			<div class="row">
    				<div class="col-sm-3">
						<span>Edad</span>
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-time text-info"></span></span>
							<input type="text" class="form-control input-sm input-number" v-model="becario.edad" name="edad" placeholder="Edad" maxlength="2"/>
						</div>
					</div>
					<div class="col-sm-3">
						<span>Sexo</span>
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-th-list text-info"></span></span>
							<select v-model="becario.sexo" class="form-control input-sm select2">
								<option value="0" label="Seleccione"/>
								<option value="F" label="FEMENINO"/>
								<option value="M" label="MASCULINO"/>
							</select> 
						</div>
					</div>
					<div class="col-sm-3">
						<span>Correo Personal</span>
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-envelope text-info"></span></span>
							<input type="email" class="form-control input-sm text-uppercase input-text" v-model="becario.correoPersonal" id="correoPersonal" name="correoPersonal" placeholder="Correo Personal"/>
						</div>
					</div>
					<div class="col-sm-3">
						<span>Teléfonos</span>
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-earphone text-info"></span></span>
							<input type="text" class="form-control input-sm text-uppercase input-text" v-model="becario.telefonos" id="telefonos" name="telefonos" placeholder="Teléfonos"/>
						</div>
					</div>
    			</div>
    			<!-- /.row -->
    			<div class="row">
    				<div class="col-sm-6">
						<span>Dirección</span>
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-home text-info"></span></span>
							<input type="text" class="form-control input-sm text-uppercase input-text" v-model="becario.direccion" id="direccion" name="direccion" placeholder="Dirección"/>
						</div>
					</div>
    				<div class="col-sm-3">
						<span>Persona Contacto</span>
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-credit-card text-info"></span></span>
							<input type="text" class="form-control input-sm text-uppercase input-text" v-model="becario.contacto" id="dniRep" name="dniRep" placeholder="Persona Contacto"/>
						</div>
					</div>
					<div class="col-sm-3">
						<span>Teléfono Contacto</span>
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-user text-info"></span></span>
							<input type="text" class="form-control input-sm text-uppercase input-text" v-model="becario.contactoTelefono" id="nombreRep" name="nombreRep" placeholder="Telefóno Contacto"/>
						</div>
					</div>
					
    			</div>
    			<!-- /.row -->
    			
    			<div class="row">
    				<div class="col-sm-3">
						<span>Estado</span>
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-flag text-info"></span></span>
							<!-- 
							<input type="text" class="form-control input-sm" v-model="becario.idEstado" id="estado" name="estado" placeholder="Estado"/>
							 -->
							<select class="form-control input-sm text-uppercase" id="idEstado"
								@change="loadCondicionPorEstado()"
								v-model="becario.idEstado">
								<option v-for="estado in estados"
										v-bind:value="estado.id">{{estado.descripcion}}</option>
							</select>
						</div>
					</div>
					<div class="col-sm-3">
						<span>Condición</span>
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-menu-right text-info"></span></span>
							<select class="form-control input-sm" id="idCondicion"
								v-model="becario.idCondicion">
								<option disabled value="0">[SELECCIONE CONDICIÓN]</option>
								<option v-for="condicion in condiciones"
										v-bind:value="condicion.id">{{condicion.descripcion}}</option>
							</select>
						</div>
					</div>
    				<div class="col-sm-3">
						<span>Documento culminación</span>
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-file text-info"></span></span>
							<input type="text" class="form-control input-sm text-uppercase input-text" v-model="becario.documentoCulminacion" id="resolucionEstado" name="resolucionEstado" placeholder="Documento culminación"/>
						</div>
					</div>
					<div class="col-sm-3">
						<span>Res. Perdida Beca</span>
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-file text-info"></span></span>
							<input type="text" class="form-control input-sm text-uppercase input-text" v-model="becario.resolucionPerdidaBeca" id="resolucionEstado" name="resolucionEstado" placeholder="Res. Perdida Beca"/>
						</div>
					</div>
    			</div>
    			<!-- /.row -->
    			<div class="row">
    				<div class="col-sm-12">
						<span>Observaciones</span>
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-comment text-info"></span></span>
							<input type="text" class="form-control input-sm text-uppercase input-text" v-model="becario.observaciones" id="observaciones" name="observaciones" placeholder="Observaciones"/>
						</div>
					</div>
    			</div>
    			<!-- /.row -->
    		</div>
    		<!-- /.panel-body -->
    		<div class="panel-footer clearfix">
    			<div class="pull-right">
					<span class="btn btn-sm bg-olive" v-on:click="guardar()">Guardar</span>
					<span class="btn btn-sm bg-maroon" v-on:click="verListado()">Cancelar</span>
    			</div>
    		</div>
    	</div>
	</form>
    <!-- /Formulario -->
    
</section>
<!-- /.content -->