var app = new Vue({
	el: '#app',
	data: {
		idBeca:"0",
		becas: [],
		asesores: [],
		estados:[],
		condiciones:[],
		carreras:[],
		ies:[],
		sedes:[],
		becario: [],
		idBecario: "",
		tabla:"",
		ocultarLista: false,
		ocultarFormulario: true
	},
	mounted(){
		this.loadBecas();
		this.loadAsesores();
		this.loadEstados();
		this.loadIes();
		$('#tbl-becarios').DataTable();
		$('#fechaNacimiento').datepicker().on(
			"changeDate", ()=>{this.becario.fechaNacimiento = $('#fechaNacimiento').val()}
		);
		$('#fechaResolucion').datepicker().on(
			"changeDate", ()=>{this.becario.resolucionAdjudicacionFecha = $('#fechaResolucion').val()}
		);
		$('#idIes').on(
			"change", ()=>{ this.becario.idSedeEstudio = 0}
		);
		$('#idBeca').on(
			"change", ()=>{this.becario.idCarrera = 0}
		);
		$('#idEstado').on(
			"change", ()=>{this.becario.idCondicion = 0}
		);
	},
	methods: {
		loadAsesores: function(){
			axios.get("api/asesor").then(response => {
				this.asesores = response.data;
			});
		},
		loadEstados: function(){
			axios.get("api/estado").then(response => {
				this.estados = response.data;
			});
		},
		loadIes: function(){
			axios.get("api/ies").then(response => {
				this.ies = response.data;
			});
		},
		loadBecas: function(){
			axios.get("api/beca").then(response => {
				this.becas = response.data;
			});
		},
		loadCarrerasPorBeca: function(){
			if (this.becario.idBeca != null){
				axios.get("api/carrera/beca/"+this.becario.idBeca).then(response => {
					this.carreras = response.data;
				});
			}
		},
		loadSedesPorIes: function(){
			if (this.becario.idIes != null) {
				axios.get("api/sedeEstudio/ies/"+this.becario.idIes).then(response => {
					this.sedes = response.data;
				});
			}
		},
		loadCondicionPorEstado: function(){
			if (this.becario.idEstado != null ){
				axios.get("api/estado/condicion/"+this.becario.idEstado).then(response =>{
					this.condiciones = response.data;
				});
			}
		},
		loadBecarios: function(){
			if (this.idBeca == 0) {
				$('#tbl-becarios').DataTable().destroy();
				$('#tbl-becarios').DataTable().clear();
			} else {
				var url = "api/becario/beca/" + this.idBeca;
				$('#tbl-becarios').DataTable().destroy();
				$('#tbl-becarios').DataTable({
					"ajax": url,
					"type": "GET",
					"columns":[
							{"data":"dni"},
							{"data":"nombreCompleto"},
							{"data":"carrera"},
							{"data":"estado"},
							{"data":"asesor"},
							{"orderable":false, "defaultContent": "", "className":"text-center",
			                    "render": function(data, type, row, meta){
			                        if (type === 'display'){
			                        	data = "<a class='glyphicon glyphicon-edit text-green' title='Ver detalle' onclick=app.verRegistro($(this).data('id')) data-id="+ row.id +"></a>";
			                        }
			                        return data;
			                    }
							}
					],
					"autoWidth": false
				});
			}
		},
		verRegistro: function(idBecario){
			this.ocultarLista = true;
			this.ocultarFormulario = false;
			var url = "api/becario/" + idBecario;

			axios.get(url).then(response => {
				this.becario = response.data;
				this.loadCarrerasPorBeca();
				this.loadSedesPorIes();
				this.loadCondicionPorEstado();
				$('#fechaNacimiento').datepicker('setDate', this.becario.fechaNacimiento);
				$('#fechaResolucion').datepicker('setDate', this.becario.resolucionAdjudicacionFecha);
			});
			
		},
		verListado: function(){
			this.ocultarLista = false;
			this.ocultarFormulario = true;
			this.resetFormulario();
		},
		guardar: function(){
			var url = "api/becario/";
			axios.post(url, this.becario)
			.then(response => {
				if (response.data.success){
					this.idBeca = response.data.idBeca;
					this.loadBecarios();
					this.verListado();
				}
			})
			.catch(error => {
				alert('error')
			});
			
		}, 	
		resetFormulario: function(){
			this.becario = [];
			$('#form-becario').find("input[type=text], input[type=email], textarea").val("");
		}
	}
});