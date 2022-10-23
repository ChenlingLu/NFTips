<template>
   <p class="home_foot">{{homeInfo.foot}}</p>
    <span class="home_pow">
      <img :src="tidb" alt="">
    </span>
</template>

<script setup>
import {reactive,onMounted} from "vue"
import tidb from "@/assets/tidb.png"

const homeInfo = reactive({
    foot:"Made by 👨‍💻Joyven, 👩‍🎨Vita, ‍🧑‍💻Again, 🧑‍💻snail ",
    tidb:tidb,
})
</script>

<style scoped lang="scss">
  .home_foot{
    position: absolute;
    color: #7C7C7C;
    height: 15px;
    left: 85px;
       bottom: 24px;
    font-family: 'Inter';
    font-style: normal;
    font-weight: 400;
    font-size: 12px;
    line-height: 15px;
  }
  .home_pow{
    position: absolute;
     color: #7C7C7C;
    height: 24px;
    left: 899px;
       bottom: 30px;
    font-family: 'Inter';
    font-style: normal;
    font-weight: 400;
    font-size: 12px;
    line-height: 15px;
  }
</style>