<template>
  <section class="four">
      <div class="echarts" ref="chart" id="fourO" />
      <div class="echarts" ref="chart" id="fourT" />
      <div class="echarts" ref="chart" id="fourTh" />
      <div class="echarts" ref="chart" id="fourF" />
  </section>
  
</template>

<script >
import * as echarts from "echarts";
import echartFour from '@/components/echartFour'
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
 
       var myCharto = echarts.init(document.getElementById('fourO'));
       var myChartt = echarts.init(document.getElementById('fourT'));
       var myChartth = echarts.init(document.getElementById('fourTh'));
       var myChartf = echarts.init(document.getElementById('fourF'));
      if (echartFour) {
        echartFour.series[0].itemStyle.normal.color = '#FFF500'
        myCharto.setOption(echartFour);
        echartFour.series[0].itemStyle.normal.color = '#0286FF'
        myChartt.setOption(echartFour);
         echartFour.series[0].itemStyle.normal.color = '#04CCC0'
        myChartth.setOption(echartFour);
         echartFour.series[0].itemStyle.normal.color = '#CC6404'
        myChartf.setOption(echartFour);
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
.four{

    .echarts {
        position: relative;
        width:250px;
        height: 150px;
        display: inline-block;
  
}
}

</style>
