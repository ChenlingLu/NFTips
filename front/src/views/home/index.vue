
<template>
  <section class="home">
    <Header />
    <div class="container">
      <div class="left">
        <p class="home_title">{{homeInfo.title}}</p>
        <el-input class="home_select" v-model="homeInfo.selectValue"
          placeholder="NFT id" 
          :suffix-icon="Search" :suffix-transition=false
          @change="handleEnter">
          <!-- <el-option v-for="item in homeInfo.options" :key="item.value" :label="item.label" :value="item.value" /> -->
        </el-input>

        <p class="home_drag">{{homeInfo.drag}}</p>

        <Upload class="home_upload" />
        <Footer />
      </div>
      <div class="right">
        <HomeRight />
      </div>
    </div>
  </section>
</template>

<script setup name="home">
import { useStore } from 'vuex'
import { Search } from '@element-plus/icons-vue'
import { reactive, onMounted } from "vue"
import { ElSelect } from 'element-plus'
import Footer from "@/components/footer.vue"

import router from '../../router';

import Upload from "@/components/upload.vue"
import Header from "@/components/header.vue"
import HomeRight from "@/components/homeRight.vue"
import tidb from "@/assets/tidb.png"
const store = useStore()
console.log('store', store.state.name)
const homeInfo = reactive({
  title: 'Search for the most valuable and investment-potential NFTs 💡',
  list: [],
  options: [],
  loading: false,
  selectValue: '',
  foot: "Made by 👨‍💻Joyven, 👩‍🎨Vita, ‍🧑‍💻Again, 🧑‍💻snail ",
  drag: "You can also drag an image directly or upload an image here",
  tidb: tidb,
})

onMounted(() => {
  homeInfo.list = states.map((item) => {
    return { value: `${item}`, label: `${item}` }
  })
})

const handleEnter = () => {
  router.push({
    path:'/detail',
    query:{
      id: homeInfo.selectValue
    }
  })
  
}

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
.home {

  .home_title {
    height: 29px;
    font-family: 'Inter';
    font-style: normal;
    font-weight: 500;
    font-size: 24px;
    line-height: 29px;
    /* identical to box height */
    color: #FFFFFF;
  }

  .home_select {
    width: 984px;
    height: 56px;

    :deep(.el-input__inner) {
      height: 56px;
    }
  }

  .home_drag {

    height: 29px;
    font-family: 'Inter';
    font-style: normal;
    font-weight: 500;
    font-size: 24px;
    line-height: 29px;
    /* identical to box height */
    color: #FFFFFF;
  }

  .home_upload {
    box-sizing: border-box;
    margin-right: 32px;
    background: rgba(194, 194, 194, 0.3);
    border: 1px dashed #848484;
    box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
    border-radius: 6px;
  }

  .home_foot {
    color: #7C7C7C;
    height: 15px;
    font-family: 'Inter';
    font-style: normal;
    font-weight: 400;
    font-size: 12px;
    line-height: 15px;
  }

  .home_pow {
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

