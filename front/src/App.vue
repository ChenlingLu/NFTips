<script >
import drawMixin from "@/utils/drawMix" // 大屏适配
export default {
   // mixins:[drawMixin]
   setup() {
      return {
        drawMixin
      }
    }
}


</script>

<template>
   <router-view />
</template>

<style lang="less">
body{
   margin: 0;
}
#app{
  background:linear-gradient(259.11deg, #002072 -20.07%, #07303D 17.37%, #031329 81.21%, #1B0030 116%);
}
</style>
