<template>
  <header class="header">
    <img :src="logo.url" :alt="logo.title">
  </header>
</template>

<script setup name="header">
import {reactive} from 'vue'
import logoimg from '../assets/logo.png'
    const logo = reactive({
        url:logoimg,
        title:'NFTips'
    })
</script>

<style lang="less" scoped>
.header{
    position: absolute;
    width: 100%;
    height: 64px;
    left: 0px;
    top: 0px;
    background: #031329;
    img{
      position: relative;
      width: 125.67px;
      height: 39.02px;
      left: 47px;
      top: 13px;
    }
}
</style>>
