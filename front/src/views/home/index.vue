
<template>
  <div>
   {{ this.$store.state.name }}
  </div>
 </template>
<script>
import { useStore } from 'vuex'
export default {
 setup() {
  const store = useStore()
  console.log('store', store.state.name)
 },
}
</script>