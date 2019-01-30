var app = new Vue({
	el: '#condicion_mant',
	data: {
		estado: '',
		estados: {}
	},
	mounted(){
		this.loadEstados();
//		this.loadTipoIes();
//		this.loadTipoGestion();
//		this.loadInstituciones();
//		$('#tbl-instituciones').DataTable();
//		$('#tbl-sedes').DataTable();
	},
	methods: {
		loadEstados: function(){
			var url = "api/estado/list";
			axios.get(url).then(response => {
				var array = new Array();
				$.each(response.data, function(i, data){
					var d = new Object();
					d['key'] = data.id;
					d['val'] = data.descripcion;
					array.push(d);
				})
				this.estados = array;
			});
		},
		estadoSelected: function(val){
			this.estado = val;
		}
	}
	
});