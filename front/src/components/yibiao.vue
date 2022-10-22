<template>
  <section class="yibiao">
      <p class="yibiao_title">Buying Index</p>
      <div class="echarts" ref="chart" id= "yibiao" />
     <p class="small">
         Buying Index = transaction times * 30% + avg transaction time * 20% + avg price increase/decrease * 50% 
    </p>
  </section>
  
</template>

<script >
import * as echarts from "echarts";
import yibiaoo from '@/components/yibiaoo'
let chart = {};

export default {
  name: "chart",
  data() {
    return {
      resizeTimer: null,
      version: "1.0",
      chartTemp: null,
    };
  },

  props: {
    // 图表参数
  
  },


  methods: {
    // 初始化
    init() {
 
       var myChart = echarts.init(document.getElementById('yibiao'));
      if (yibiaoo) {
        myChart.setOption(yibiaoo);
      }
    },

    // 调整尺寸
    resize(options = {}) {
      this.resizeTimer = clearTimeout(this.resizeTimer);
      this.resizeTimer = setTimeout(() => {
      this.init()
      }, 300);
    },
  },
  mounted() {
    this.chartTemp = Math.random();
    this.$nextTick(() => {
      this.init();
    });
    window.addEventListener("resize", this.resize);
  },
  beforeUnmount() {
    if (chart[this.chartTemp]) {
      window.removeEventListener("resize", this.resize);
      this.resizeTimer = clearTimeout(this.resizeTimer);
      chart[this.chartTemp].dispose();
      chart[this.chartTemp] = null;
    }
  },
};
</script>

<style scoped lang="scss">
.yibiao{
    .small{
        font-size: 12px;
        line-height: 15px;
        position: absolute;
        top: 250px;
        width: 80%;
        transform: translate(-50%);
        left: 50%;
        color: #7C7C7C;
    }
    .yibiao_title{
        font-size: 24px;
        line-height: 29px;
        color: #FFFFFF;
        top: 18px;
        position: absolute;
        left: 20px;
    }
    
    .echarts {
        position: absolute;
        width:250px;
        height: 250px;
        top: 32px;
        position: absolute;
        left: 50%;
        top: 32px;
        transform: translate(-50%);
}
}

</style>
