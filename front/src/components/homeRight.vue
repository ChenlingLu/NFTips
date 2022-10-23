<template>
    <section class="h_right">
        <Yibiao :data="echartData" v-if="showYB" />
        <div class="home_info" :class="{'detail_info':showYB}">
            <p class="h_title">Ranking with Buying Index</p>

            <div class="h_item">

                <div class="item" v-for="(item,index) in data.list" :key=item.categoryId+index>
                    <div class="text">
                        <p class="name">{{item.categoryName}}</p>
                        <p class="price">Price:{{item.worth}}</p>
                    </div>
                    <span class="num">{{item.buyingIndex}}</span>
                </div>

            </div>
        </div>
    </section>
</template>

<script setup>
import { reactive, onMounted, ref, defineProps } from "vue"
import Yibiao from "@/components/yibiao.vue"
import { useRouter } from "vue-router";
import service from '../utils/request';

defineProps({
    echartData: Number
});

const data = reactive({
    list: []
})

service({
    url: '/query/top10/v1',
    method: 'get',
}).then(res => {
    if (res.data.length) {
        data.list = res.data;
    }
})

const showYB = ref(false)
onMounted(() => {
    const router = useRouter();
    console.log(router.currentRoute.value.name)
    showYB.value = (router.currentRoute.value.name === 'detail')
})
const hItem = reactive({
    item: [
        {
            name: "To The Moon",
            price: '80 USD',
            num: 97
        },
        {
            name: "To The Moon",
            price: '80 USD',
            num: 97
        },
        {
            name: "To The Moon",
            price: '80 USD',
            num: 97
        },
        {
            name: "To The Moon",
            price: '80 USD',
            num: 97
        }
    ]
})
</script>

<style lang="scss" scoped>
.h_right {
    .h_title {

        height: 24px;

        font-family: 'Inter';
        font-style: normal;
        font-weight: 500;
        font-size: 20px;
        line-height: 24px;

        color: #FFFFFF;
    }

    .h_item {
        .item {
            display: flex;
            align-items: center;
            justify-content: space-between;
        }

        .text {
            flex: 1;
        }


        .name {

            font-family: "Inter";
            font-style: normal;
            font-weight: 500;
            font-size: 16px;
            line-height: 19px;
            color: #FFFFFF;
        }

        .price {

            color: #7C7C7C;

            font-family: "Inter";
            font-style: normal;
            font-weight: 500;
            font-size: 16px;
        }

        .num {
            width: 50px;
            height: 50px;
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