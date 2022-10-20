<template>
  <div>
   <input type="text" v-model="msg" />
   {{ this.$store.state.name }}
  </div>
 </template>
 
<script>
import { useStore } from 'vuex'
import { ref } from 'vue'
import { HomeApi } from '@/api'
export default {
 setup() {
  const store = useStore()
  const msg = ref('前端人，前端魂1')
  store.commit('changeName', '我11是前端人')

  const init  = async() =>{
    const {data} = await HomeApi.fetchAll()
    console.log('data: ', data);
  }
  init()
  return {
   msg,
  }
 }
}
</script>