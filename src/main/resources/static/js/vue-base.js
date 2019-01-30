var BtnToggle = Vue.extend({
	template: '#btn-toggle',
	props: ['values', 'selected', 'default'],
	data: function(){
		return {
			isSelected: this.selected
		}
	},
	created: function () {
		this.isSelected = this.default;
		this.$emit('clicked', this.isSelected)
	},
	methods: {
		changeSelectVal: function(val) {
			this.isSelected = val
			this.$emit('clicked', this.isSelected)
    }
  }
});
Vue.component('btn-toggle', BtnToggle);
