<template>
  <section class="three">
      <div class="echarts" ref="chart" id= "one" />
  </section>
  
</template>

<script >
import * as echarts from "echarts";
import threeo from '@/components/echart'
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
 
       var myChart = echarts.init(document.getElementById('one'));
      if (threeo) {
        myChart.setOption(threeo);
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
.three{
    .echarts {
        position: relative;
        width:650px        ;
        height: 150px;
  
}
}

</style>
