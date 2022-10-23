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
#app{
   width: 100vw;
  height: 100vh;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  transform-origin: left top;
  overflow: hidden;
  background:linear-gradient(259.11deg, #002072 -20.07%, #07303D 17.37%, #031329 81.21%, #1B0030 116%);
}
</style>
