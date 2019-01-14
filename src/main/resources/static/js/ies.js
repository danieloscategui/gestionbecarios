var app = new Vue({
	el: '#app',
	data: {
		idIes:"",
		iesNombre:"",
		tipoIes: [],
		tipoGestion: [],
		instituciones:[],
		institucion:[],
		carreras: [],
		sedes:[],
		sede:[],
		idCarrera:"",
		ocultarListaIes: false,
		ocultarListaSedes: false,
		ocultarFormulario: true,
		editarSedeA: false
	},
	mounted(){
		this.loadTipoIes();
		this.loadTipoGestion();
		this.loadInstituciones();
		$('#tbl-instituciones').DataTable();
		$('#tbl-sedes').DataTable();
	},
	methods: {
		loadTipoIes: function(){
			axios.get("api/tipoIes").then(response => {
				this.tipoIes = response.data;
			});
		},
		loadTipoGestion: function(){
			axios.get("api/tipoGestion").then(response => {
				this.tipoGestion = response.data;
			});
		},
		loadInstituciones: function(){
				var url = "api/ies/map";
//				$('#tbl-instituciones').DataTable().clear();
//				$('#tbl-instituciones').DataTable().destroy();
			
				$('#tbl-instituciones').DataTable({
					"ajax": url,
					"type": "GET",
					"columns":[
							{"data":"nombre"},
							{"data":"tipoIes"},
							{"data":"tipoGestion"},
							{"orderable":false, "defaultContent": "", "className":"text-center",
			                    "render": function(data, type, row, meta){
			                        if (type === 'display'){
			                        	data = '<a class="fa fa-edit text-green" title="Ver registro" onclick=app.verInstitucion($(this).data("id")) data-id='+ row.id +'></a>\t';
			                        	data += '<a class="fa fa-list-alt text-green" title="Ver sedes" onclick=app.verSedesPorIes($(this).data("id")) data-id='+ row.id +'></a>'
			                        }
			                        return data;
			                    }
							}
					],
					"autoWidth": false
				});
		},
		verSedesPorIes: function(idIes){
			var urlSedesPorIes = "api/sedeEstudio/ies/" + idIes;
			var urlIes = "api/ies/" + idIes;
			
			axios.get(urlIes).then(response => {
				this.iesNombre = response.data.nombre;
			});
			
			
			$('#tbl-sedes').DataTable().clear();
			$('#tbl-sedes').DataTable().destroy();

			this.ocultarListaIes = true;
			this.ocultarFormulario = true;
			this.ocultarListaSedes = false;
			
			$('#tbl-sedes').DataTable({
				"ajax": urlSedesPorIes,
				"type": "GET",
				"columns":[
						{"data":"region"},
						{"data":"sede"},
						{"orderable":false, "defaultContent": "", "className":"text-center",
		                    "render": function(data, type, row, meta){
		                        if (type === 'display'){
		                        	data = "<a class='fa fa-edit text-green' title='Ver registro' onclick=app.verSede($(this).data('id')) data-id="+ row.id +"></a>   ";
		                        }
		                        return data;
		                    }
						}
				],
				"autoWidth": false
			});
		},
		verSede: function(idSede){
			var url = 'api/sedeEstudio/'+idSede;
			axios.get(url).then(response => {
				this.sede = response.data;
			});
			
//			this.sede = this.sedes[index]
			console.log(index)
			console.log(JSON.stringify(this.sedes[0]))
		},
		verInstitucion: function(idIes){
			this.resetIes();
			this.resetSede();
			
			this.ocultarListaIes = true;
			this.ocultarFormulario = false;
			this.ocultarListaSedes = true;
			/*
			var urlIes = "api/ies/" + idIes;
			axios.get(urlIes).then(response => {
				this.institucion = response.data;
				console.log(JSON.stringify(this.institucion.sedes))
				//sedes se muestra en el listado
				this.sedes = this.institucion.sedes;
			});
			*/
		},
		resetIes: function(){
			this.ies = [];
			$('#form-ies').find("input[type=text], input[type=email]").val("");
		},
		resetSede: function(){
			this.sede = [];
			$('#form-ies').find("input[type=text], input[type=email]").val("");
		},
		verListado: function(){
			this.ocultarListaIes = false;
			this.ocultarFormulario = true;
			this.resetIes();
			this.resetSede();
		},
		guardarIes:function(){
			var url="api/ies/" + this.institucion.id;
			this.institucion.sedes = this.sedes;
			axios.put(url, this.institucion)
			.then(response => {
				if (response.data.success){
					//this.institucion.id = response.data.idIes;
					this.verListado();
				}
			})
			.catch(error => {
				alert('error')
			});
		},
		agregarSede: function(){
			console.log(JSON.stringify(this.sedes))
			console.log(JSON.stringify(this.sede))
		},
		nuevoIES: function(){
			this.resetIes();
			this.resetSede();
			
			this.ocultarListaIes = true;
			this.ocultarFormulario = false;
			this.ocultarListaSedes = true;
		}
	}
});