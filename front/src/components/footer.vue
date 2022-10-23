<template>
  <div class="footer">
    <p class="home_foot">{{homeInfo.foot}}</p>
     <span class="home_pow">
       <img :src="tidb" alt="">
     </span>
  </div>
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
.footer{
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 20px 20px 20px 0;
}
  .home_foot{
    color: #7C7C7C;
    font-family: 'Inter';
    font-style: normal;
    font-weight: 400;
    font-size: 12px;
    margin: 0;
  }
  .home_pow{
     color: #7C7C7C;
    height: 24px;
    font-family: 'Inter';
    font-style: normal;
    font-weight: 400;
    font-size: 12px;
  }
</style>