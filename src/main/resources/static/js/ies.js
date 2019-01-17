var app = new Vue({
	el: '#app',
	data: {
		iesId:"",
		iesNombre:"",
		tipoIes: [],
		tipoGestion: [],
		instituciones:[],
		institucion:{},
		//carreras: [],
		//sedes:[],
		sede:{},
		idCarrera:"", 
		hideIesList: false,
		hideIesForm: true,
		hideSedeList: true,
		hideSedeForm: true,
		messageIesError: "",
		messageSedeError: ""
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
				var url = "api/ies/";
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
			                        	data = '<a class="fa fa-edit text-green" title="Ver registro" onclick=app.showInstitucion($(this).data("id")) data-id='+ row.id +'></a>\t';
			                        	data += '<a class="fa fa-list-alt text-green" title="Ver sedes" onclick=app.showSedesPorIes($(this).data("id")) data-id='+ row.id +'></a>'
			                        }
			                        return data;
			                    }
							}
					],
					"autoWidth": false
				});
		},
		showInstitucion: function(idIes){
			this.resetIesForm();
			this.resetSedeForm();
		
			this.hideIesList = true;
			this.hideIesForm = false;
			this.hideSedeList = true;
			this.hideSedeForm = true;

			var urlIes = "api/ies/" + idIes;
			axios.get(urlIes).then(response => {
				this.institucion = response.data;
			});
		},
		showSedesPorIes: function(idIes){
			var urlSedesPorIes = "api/sedeEstudio/ies/" + idIes;
			var urlIes = "api/ies/" + idIes;
			
			axios.get(urlIes).then(response => {
				this.iesNombre = response.data.nombre;
				this.iesId = response.data.id;
			});
			
			$('#tbl-sedes').DataTable().clear();
			$('#tbl-sedes').DataTable().destroy();

			this.hideIesList = true;
			this.hideIesForm = true;
			this.hideSedeList = false;
			this.hideSedeForm = true;

			$('#tbl-sedes').DataTable({
				"ajax": urlSedesPorIes,
				"type": "GET",
				"columns":[
						{"data":"region"},
						{"data":"sede"},
						{"orderable":false, "defaultContent": "", "className":"text-center",
		                    "render": function(data, type, row, meta){
		                        if (type === 'display'){
		                        	data = "<a class='fa fa-edit text-green' title='Ver registro' onclick=app.showSede($(this).data('id')) data-id="+ row.id +"></a>   ";
		                        }
		                        return data;
		                    }
						}
				],
				"autoWidth": false
			});
		},
		showSede: function(idSede){
			this.resetIesForm();
			this.resetSedeForm();
		
			this.hideIesList = true;
			this.hideIesForm = true;
			this.hideSedeList = true;
			this.hideSedeForm = false;
			
			var url = 'api/sedeEstudio/'+idSede;
			axios.get(url).then(response => {
				this.sede = response.data;
			});
		},
		resetIesForm: function(){
			this.institucion = {};
			$('#form-ies').find("input[type=text], input[type=email]").val("");
		},
		resetSedeForm: function(){
			this.sede = {};
			$('#form-ies').find("input[type=text], input[type=email]").val("");
		},
		showIesList: function(){
			this.hideIesList = false;
			this.hideIesForm = true;
			this.hideSedeList = true;
			this.hideSedeForm = true;
			this.resetIesForm();
			this.resetSedeForm();
			$('#tbl-instituciones').DataTable().ajax.reload();
		},
		showSedeList: function(){
			this.hideIesList = true;
			this.hideIesForm = true;
			this.hideSedeList = false;
			this.hideSedeForm = true;
			this.resetIesForm();
			this.resetSedeForm();
			$('#tbl-sedes').DataTable().ajax.reload();
		},
		saveIes: function(){
			this.institucion.id > 0 ? this.updateIes() : this.createIes();
		},
		createIes:function(){
				var url="api/ies/"; 
				axios.post(url, this.institucion)
				.then(response => {
					if (response.data.success){
						alert("Institución creada");
						this.showIesList();
					}
				})
				.catch(error => {
					messageIesError = error.response.data;
					alert(messageIesError);
				});
		},
		updateIes:function(){
			var url="api/ies/" + this.institucion.id;
			axios.put(url, this.institucion)
			.then(response => {
				if (response.data.success){
					alert("Datos actualizados");
					this.showIesList();
				}
			})
			.catch(error => {
				messageIesError = error.response.data;
				alert(messageIesError);
			});
		},
		saveSede: function(){
			this.sede.id > 0 ? this.updateSede() : this.createSede();
		},
		createSede: function(){
			var url="api/sedeEstudio";
			
			axios.post(url, this.sede)
			.then(response => {
				if (response.data.success){
					alert("Sede Educativa creada");
					this.showSedeList();
				}
			})
			.catch(error => {
				messageSedeError = error.response.data;
				alert(messageSedeError);
			});
		},
		updateSede: function(){
			var url="api/sedeEstudio";
			axios.put(url, this.sede)
			.then(response => {
				if (response.data.success){
					alert("Sede Educativa actualizada");
					this.showSedeList();
				}
			})
			.catch(error => {
				messageSedeError = error.response.data;
				alert(messageSedeError);
			});
		},
		newIes: function(){
			this.hideIesList = true;
			this.hideIesForm = false;
			this.hideSedeList = true;
			this.hideSedeForm = true;
			this.resetIesForm();
			this.resetSedeForm();
		},
		newSede: function(iesId){
			this.hideIesList = true;
			this.hideIesForm = true;
			this.hideSedeList = true;
			this.hideSedeForm = false;
			this.resetIesForm();
			this.resetSedeForm();
			this.sede.idIes = iesId;
		}
	}
});