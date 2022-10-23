<template>
  <section class="yibiao">
      <div class="yibiao_title">Buying Index</div>
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
  border-bottom: 1px solid #797979;
    .small{
        font-size: 12px;
        line-height: 15px;
        width: 80%;
        color: #7C7C7C;
    }
    .yibiao_title{
        font-size: 24px;
        color: #FFFFFF;
        margin-bottom: 10px;
    }
    
    .echarts {
        width:250px;
        height: 200px;
        background: #fff;
        border-radius: 6px;
}
}

</style>
