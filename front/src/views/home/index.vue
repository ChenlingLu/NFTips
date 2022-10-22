
<template>
  <section class="home">
    <Header />
    <!-- {{store.state}} -->
    <p class="home_title">{{homeInfo.title}}</p>
    <el-select
      class="home_select"
      v-model="homeInfo.selectValue" 
      filterable
      remote
      reserve-keyword
      placeholder="NFT name / Denom name"
      remote-show-suffix
      :remote-method="remoteMethod"
      :loading="loading"
      :suffix-icon="Search"
      :suffix-transition = false
    >
      <el-option
        v-for="item in homeInfo.options"
        :key="item.value"
        :label="item.label"
        :value="item.value"
      />
    </el-select>
    
    <p class="home_drag">{{homeInfo.drag}}</p>

    <Upload class="home_upload" />
    <Footer />
    
  </section>
  <HomeRight />
 </template>

<script setup name="home">
import { useStore } from 'vuex'
import { Search } from '@element-plus/icons-vue'
import {reactive,onMounted} from "vue"
import { ElSelect } from 'element-plus'
import Footer from "@/components/footer.vue"

import Upload from "@/components/upload.vue"
import Header from "@/components/header.vue"
import HomeRight from "@/components/homeRight.vue"
import tidb from "@/assets/tidb.png"
  const store = useStore()
  console.log('store', store.state.name)
  const homeInfo = reactive({
    title:'Search for the most valuable and investment-potential NFTs 💡',
    list:[],
    options:[],
    loading:false,
    selectValue:'',
    foot:"Made by 👨‍💻Joyven, 👩‍🎨Vita, ‍🧑‍💻Again, 🧑‍💻snail ",
    drag:"You can also drag an image directly or upload an image here",
    tidb:tidb,
 })
  
  onMounted(() => {
    homeInfo.list = states.map((item) => {
      return { value: `${item}`, label: `${item}` }
    })
  })

  const remoteMethod = (query) => {
    if (query) {
      homeInfo.loading = true
      setTimeout(() => {
        homeInfo.loading = false
        homeInfo.options = homeInfo.list.filter((item) => {
          return item.label.toLowerCase().includes(query.toLowerCase())
        })
      }, 200)
    } else {
      homeInfo.options = []
    }
  }

  
  const states = [
  'Alabama',
  'Alaska',
  'Arizona',
  'Arkansas',
  'California',
  'Colorado',
  'Connecticut']
</script>


<style lang="scss" scoped>
.home{
  .home_title{
    margin: 0;
    position: absolute;
    height: 29px;
    left: 85px;
    top: 13vh;
    font-family: 'Inter';
    font-style: normal;
    font-weight: 500;
    font-size: 24px;
    line-height: 29px;
    /* identical to box height */
    color: #FFFFFF;
  }
   .home_select{
    position: absolute;
    width: 984px;
    height: 56px;
    left: 85px;
    top: 21vh;
    :deep(.el-input__inner){
      height: 56px;
    }
  }
  .home_drag{
    position: absolute;
   
    height: 29px;
    left: 85px;
    top: 30vh;
    font-family: 'Inter';
    font-style: normal;
    font-weight: 500;
    font-size: 24px;
    line-height: 29px;
    /* identical to box height */
    color: #FFFFFF;
  }
  .home_upload{
    box-sizing: border-box;

    position: absolute;
    width: 984px;
    height: 48vh;
    left: 93px;
    top: 40vh;

    background: rgba(194, 194, 194, 0.3);
    border: 1px dashed #848484;
    box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
    border-radius: 6px;
  }
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
}
</style>

