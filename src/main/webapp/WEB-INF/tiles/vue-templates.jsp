<template id="btn-toggle">
  <div class="btn-group">
    <button type="button" 
      v-for="obj in values"
      @click="changeSelectVal(obj.key)"
      :class="['btn', { 'btn-danger': isSelected === obj.key, 'btn-default': isSelected !== obj.key }]"
      >{{ obj.val }}</button>
  </div>
</template>