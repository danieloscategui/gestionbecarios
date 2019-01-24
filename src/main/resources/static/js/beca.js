var app = new Vue({
	el: '#beca_mant',
	data: {
		becaId:"",
		becaNombre:"",
		institucion:{},
		beca:{},
		carrera:{},
		idBeca:"", 
		hideBecaList: false,
		hideBecaForm: true,
		hideCarreraList: true,
		hideCarreraForm: true,
		messageBecaError: "",
		messageCarreraError: ""
	},
	mounted(){
		this.loadBecas();
		$('#tbl-becas').DataTable();
		$('#tbl-carreras').DataTable();
		$('#inicio').datepicker().on(
				"changeDate", ()=>{this.beca.inicio = $('#inicio').val()}
			);
		$('#termino').datepicker().on(
				"changeDate", ()=>{this.beca.termino = $('#termino').val()}
			);
		
		
	},
	methods: {
		loadBecas: function(){
				var url = "api/beca";
				$('#tbl-becas').DataTable({
					"ajax": url,
					"type": "GET",
					"columns":[
							{"data":"convocatoria"},
							{"data":"modalidad"},
							{"data":"inicio"},
							{"data":"termino"},
							{"orderable":false, "defaultContent": "", "className":"text-center",
			                    "render": function(data, type, row, meta){
			                        if (type === 'display'){
			                        	data = '<a class="fa fa-edit text-green" title="Ver registro" onclick=app.showBeca($(this).data("id")) data-id='+ row.id +'></a>\t';
			                        	data += '<a class="fa fa-list-alt text-green" title="Ver carreras" onclick=app.showCarrerasPorBeca($(this).data("id")) data-id='+ row.id +'></a>'
			                        }
			                        return data;
			                    }
							}
					],
					"autoWidth": false
				});
		},
		showBeca: function(idBeca){
			this.resetBecaForm();
			this.resetCarreraForm();
		
			this.hideBecaList = true;
			this.hideBecaForm = false;
			this.hideCarreraList = true;
			this.hideCarreraForm = true;

			var url = "api/beca/" + idBeca;
			axios.get(url).then(response => {
				this.beca = response.data;
				$('#inicio').datepicker('setDate', this.beca.inicio);
				$('#termino').datepicker('setDate', this.beca.termino);
			});
		},
		showCarrerasPorBeca: function(idBeca){
			var urlCarrerasPorBeca = "api/carrera/beca/" + idBeca;
			var urlBeca = "api/beca/" + idBeca;
			
			axios.get(urlBeca).then(response => {
				this.becaNombre = response.data.convocatoria + ' '+ response.data.modalidad;
				this.becaId = response.data.id;
			});
			
			$('#tbl-carreras').DataTable().clear();
			$('#tbl-carreras').DataTable().destroy();

			this.hideBecaList = true;
			this.hideBecaForm = true;
			this.hideCarreraList = false;
			this.hideCarreraForm = true;

			$('#tbl-carreras').DataTable({
				"ajax": urlCarrerasPorBeca,
				"type": "GET",
				"columns":[
						{"data":"semestreEgreso"},
						{"data":"descripcion"},
						{"orderable":false, "defaultContent": "", "className":"text-center",
		                    "render": function(data, type, row, meta){
		                        if (type === 'display'){
		                        	data = "<a class='fa fa-edit text-green' title='Ver registro' onclick=app.showCarrera($(this).data('id')) data-id="+ row.id +"></a>   ";
		                        }
		                        return data;
		                    }
						}
				],
				"autoWidth": false
			});
		},
		showCarrera: function(idCarrera){
			this.resetBecaForm();
			this.resetCarreraForm();
		
			this.hideBecaList = true;
			this.hideBecaForm = true;''
			this.hideCarreraList = true;
			this.hideCarreraForm = false;
			
			var url = 'api/carrera/'+idCarrera;
			axios.get(url).then(response => {
				this.carrera = response.data;
			});
		},
		resetBecaForm: function(){
			this.beca = {};
			$('#form-beca').find("input[type=text], input[type=email]").val("");
		},
		resetCarreraForm: function(){
			this.carrera = {};
			$('#form-carrera').find("input[type=text], input[type=email]").val("");
		},
		showBecaList: function(){
			this.hideBecaList = false;
			this.hideBecaForm = true;
			this.hideCarreraList = true;
			this.hideCarreraForm = true;
			this.resetBecaForm();
			this.resetCarreraForm();
			$('#tbl-becas').DataTable().ajax.reload();
		},
		showCarreraList: function(){
			this.hideBecaList = true;
			this.hideBecaForm = true;
			this.hideCarreraList = false;
			this.hideCarreraForm = true;
			this.resetBecaForm();
			this.resetCarreraForm();
			$('#tbl-carreras').DataTable().ajax.reload();
		},
		saveBeca: function(){
			this.beca.id > 0 ? this.updateBeca() : this.createBeca();
		},
		createBeca:function(){
				var url="api/beca"; 
				axios.post(url, this.beca)
				.then(response => {
					if (response.data.success){
						alertify.success(response.data.message, 3, function(){
							app.showBecaList();
						});
					}
				})
				.catch(error => {
					messageBecaError = error.response.data;
					alert(messageBecaError);
				});
		},
		updateBeca:function(){
			var url="api/beca";
			axios.put(url, this.beca)
			.then(response => {
				if (response.data.success){
					alertify.success(response.data.message, 3, function(){
						app.showBecaList();
					});
				}
			})
			.catch(error => {
				messageBecaError = error.response.data;
				alert(messageBecaError);
			});
		},
		saveCarrera: function(){
			this.carrera.id > 0 ? this.updateCarrera() : this.createCarrera();
		},
		createCarrera: function(){
			var url="api/carrera";
			console.log(this.carrera)
			axios.post(url, this.carrera)
			.then(response => {
				if (response.data.success){
					alertify.success(response.data.message, 3, function(){
						app.showCarreraList();
					});
				}
			})
			.catch(error => {
				messageCarreraError = error.response.data;
				alert(messageCarreraError);
			});
		},
		updateCarrera: function(){
			var url="api/carrera";
			axios.put(url, this.carrera)
			.then(response => {
				if (response.data.success){
					alertify.success(response.data.message, 3, function(){
						app.showCarreraList();
					});
				}
			})
			.catch(error => {
				messageCarreraError = error.response.data;
				alert(messageCarreraError);
			});
		},
		newBeca: function(){
			this.hideBecaList = true;
			this.hideBecaForm = false;
			this.hideCarreraList = true;
			this.hideCarreraForm = true;
			this.resetBecaForm();
			this.resetCarreraForm();
			$('#inicio').datepicker('setDate', '');
			$('#termino').datepicker('setDate', '');
		},
		newCarrera: function(becaId){
			this.hideBecaList = true;
			this.hideBecaForm = true;
			this.hideCarreraList = true;
			this.hideCarreraForm = false;
			this.resetBecaForm();
			this.resetCarreraForm();
			this.carrera.idBeca = becaId;
		}
	}
});