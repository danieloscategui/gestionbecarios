<!-- jQuery 3 -->
<script src="adminlte/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="adminlte/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- DataTables -->
<script src="adminlte/bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="adminlte/bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
<!-- SlimScroll -->
<script src="adminlte/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="adminlte/bower_components/fastclick/lib/fastclick.js"></script>
<!-- Select2 -->
<script src="adminlte/bower_components/select2/dist/js/select2.full.min.js"></script>
<!-- bootstrap datepicker -->
<script src="adminlte/bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>
<script src="adminlte/bower_components/bootstrap-datepicker/dist/locales/bootstrap-datepicker.es.min.js" ></script>
<!-- AdminLTE App -->
<script src="adminlte/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="adminlte/dist/js/demo.js"></script>
<!-- Vue -->
<script src="adminlte/plugins/vue/vue.js"></script>
<!-- Axios -->
<script src="adminlte/plugins/axios/axios.min.js"></script>
<!-- Alertifyjs -->
<script src="adminlte/plugins/alertifyjs/alertify.min.js"></script>
<script>
$.extend( $.fn.dataTable.defaults, {
	"language": {
        "url": "https://cdn.datatables.net/plug-ins/1.10.19/i18n/Spanish.json"
    }
} );

$.extend($.fn.datepicker.defaults, {
	'language':'es',
    'autoclose': true,
    'format':'dd/mm/yyyy',
    //'orientation':'bottom left',
    'todayHighlight': true,
    'showOnFocus': true,
    'clearBtn': true
});

alertify.defaults.notifier.position = 'top-right';
alertify.defaults.notifier.delay = 3;

</script>

<!-- General JS -->
<script src="js/general.js"></script>

<!-- vue-base JS -->
<script src="js/vue-base.js"></script>
