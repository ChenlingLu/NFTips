<template>
  <section class="h_right">
      <Yibiao v-if="showYB" />
      <span class="h_line"></span>
      <div class="home_info" :class="{'detail_info':showYB}">
      <p class="h_title">Ranking with Buying Index</p>

      <div class="h_item" >
          
        <p style="position:relative" v-for="(item,index) in hItem.item" :key=item.name+index> 
         <span class="name">{{item.name}}</span>
          <span class="price">Price:{{item.price}}</span>
          <span class="num">{{item.num}}</span>
        </p>
          
      </div>
      </div>
  </section>
</template>

<script setup>
import {reactive,onMounted ,ref} from "vue"
import Yibiao from "@/components/yibiao.vue"
import { useRouter } from "vue-router";
const showYB = ref(false)
  onMounted(() => {
       const router = useRouter();
       console.log(router.currentRoute.value.name)
    showYB.value = (router.currentRoute.value.name === 'detail')
  })
const hItem = reactive({
    item:[
        {
            name:"To The Moon",
            price:'80 USD',
            num:97
        },
        {
            name:"To The Moon",
            price:'80 USD',
            num:97
        },
        {
            name:"To The Moon",
            price:'80 USD',
            num:97
        },
        {
            name:"To The Moon",
            price:'80 USD',
            num:97
        }
    ]
})
</script>

<style lang="scss" scoped>
.h_right{
    position: absolute;
    left: 1142px;
    width: 25vw;
    height: 100vh;
    top: 0;
    .detail_info{
        top: 200px;
        position: absolute;
        width: 100%;
    }
    .h_line{
        position: absolute;
        height: 870px;
        width: 0px;
        border: 1px solid #797979;
        top: 100px;
        left: 0;
    }
    .h_title{
        position: absolute;
        
        height: 24px;
        left: 20px;
        top: 100px;

        font-family: 'Inter';
        font-style: normal;
        font-weight: 500;
        font-size: 20px;
        line-height: 24px;

        color: #FFFFFF;
    }
    .h_item{
        position: absolute;
        top: 155px;
        left: 18px;
        .name{
            position: absolute;
            
            height: 19px;
            left: 7px;
            font-family: "Inter";
            font-style: normal;
            font-weight: 500;
            font-size: 16px;
            line-height: 19px;
            color: #FFFFFF;
            top: 7px;
        }
        .price{
            
            color: #7C7C7C;
            position: absolute;
           
            height: 19px;
            left: 7px;
            font-family: "Inter";
            font-style: normal;
            font-weight: 500;
            font-size: 16px;
            line-height: 19px;
            top: 37px;
        }
        .num{
                width: 50px;
                height: 50px;
                margin-left: 251px;
                top: 155px;
                display: inline-block;
                color: #fff;
                font-size: 31px;
                line-height: 50px;
                text-align: center;
                border: 1px solid #FFFEFE;
                border-radius: 6px;
                vertical-align: middle;
        }
    }
}
</style>