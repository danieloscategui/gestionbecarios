/**
 * 
 */

// $(document).ready(function() {
//    console.log('Entre');
// });

//

var viewModelLogin = new Vue({
	el : '#app-login',
	data:{
		user:{
			usuario:'',
			clave:''
		}
	},
	mixins: [GLOBAL],
	methods:{
		accederSistema: function(){
			axios.post('api/v1/login/', {
			    usuario: this.user.usuario,
			    clave: this.user.clave
			  })
			  .then(function (response) {
			    console.log(response);
			  })
			  .catch(function (error) {
			    console.log(error);
			  });			
		}
	}
});