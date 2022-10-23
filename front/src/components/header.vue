<template>
  <header class="header">
    <img :src="logo.url" :alt="logo.title">
    <a href="/" class="button" v-if="showBack">&lt; Back</a>
  </header>
</template>

<script setup name="header">
import { reactive, defineProps } from 'vue'
import logoimg from '../assets/logo.png'
const logo = reactive({
  url: logoimg,
  title: 'NFTips',
})
defineProps({
  showBack: Boolean
});

</script>

<style lang="less" scoped>
.header {
  padding: 20px 30px 10px;
  background: #031329;
  display: flex;
  justify-content: space-between;
  align-items: center;

  img {
    width: 126px;
    // height: 39.02px;
  }
  .button{
    font-weight: 400;
font-size: 16px;
line-height: 19px;
padding: 10px 20px;
border-radius: 4px;
background: #004C93;
color: #FFFFFF;
text-decoration: none;
  }
}
</style>>
