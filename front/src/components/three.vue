<template>
  <section class="three">
    <div class="echarts" ref="chart" id="one" />
  </section>

</template>

<script setup name="three">
import { reactive, defineProps, onMounted, watch } from 'vue'
import * as echarts from "echarts";

const props = defineProps({
  data: Number
});


onMounted(() => {

  initEchart(props.data);
})

const initEchart = ((data) => {

  const myChart = echarts.init(document.getElementById('one'));

  var dataStyle = {
    normal: {
      label: {
        show: false
      },
      labelLine: {
        show: false
      },
      shadowBlur: 40,
      shadowColor: 'rgba(40, 40, 40, 0.5)',
    }
  };
  var placeHolderStyle = {
    normal: {
      color: 'rgba(44,59,70,1)', // 未完成的圆环的颜色
      label: {
        show: false
      },
      labelLine: {
        show: false
      }
    },
    emphasis: {
      color: 'rgba(44,59,70,1)' // 未完成的圆环的颜色
    }
  };
  myChart.setOption(
    {
      title: {
        text: '50%',
        x: 'center',
        y: 'center',
        textStyle: {
          fontWeight: 'normal',
          color: '#b697cd',
          fontSize: 35
        }
      },
      tooltip: {
        show: false,
      },
      toolbox: {
        show: false,
      },
      // color : ['#3dd4de','#b697cd','#a6f08f'],
      backgroundColor: 'rgba(0,0,0,0)',
      series: [{
        name: 'Pie1',
        type: 'pie',
        clockWise: false,
        radius: [60, 65],
        itemStyle: dataStyle,
        hoverAnimation: false,
        center: ['25%', '50%'],
        data: [{
          value: data.lager?.radio || 0,
          label: {
            normal: {
              formatter: '{d}%',
              position: 'center',
              show: true,
              textStyle: {
                fontSize: '35',
                fontWeight: 'normal',
                color: '#3dd4de'
              }
            }
          },
          itemStyle: {
            normal: {
              color: '#3dd4de',
              shadowColor: '#3dd4de',
              shadowBlur: 10
            }
          }
        }, {
          value: 100 - (data.lager?.radio || 0),
          name: 'invisible',
          itemStyle: placeHolderStyle,
        }]
      }, {
        name: 'Pie2',
        type: 'pie',
        clockWise: false,
        radius: [60, 65],
        itemStyle: dataStyle,
        hoverAnimation: false,
        center: [`data.middle?.radio || 0%`, `100 - (data.middle?.radio || 0)%`],
        data: [{
          value: data.middle?.radio || 0,
          itemStyle: {
            normal: {
              color: '#b697cd',
              shadowColor: '#b697cd',
              shadowBlur: 10
            }
          }
        }, {
          value: 100 - (data.middle?.radio || 0),
          name: 'invisible',
          itemStyle: placeHolderStyle,
        }]
      }, {
        name: 'Pie3',
        type: 'pie',
        clockWise: false,
        radius: [60, 65],
        itemStyle: dataStyle,
        hoverAnimation: false,
        center: ['75%', '50%'],
        data: [{
          value: data.small?.radio || 0,
          label: {
            normal: {
              formatter: '{d}%',
              position: 'center',
              show: true,
              textStyle: {
                fontSize: '35',
                fontWeight: 'normal',
                color: '#a6f08f'
              }
            }
          },
          itemStyle: {
            normal: {
              color: '#a6f08f',
              shadowColor: '#a6f08f',
              shadowBlur: 10
            }
          }
        }, {
          value: 100 - (data.small?.radio || 0),
          name: 'invisible',
          itemStyle: placeHolderStyle,
        }]
      },]
    }
  );
})

watch(() => props.data, (newValue, oldValue) => {
  initEchart(newValue);
})

</script>

<!-- <script >
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
</script> -->

<style scoped lang="scss">
.three {
  .echarts {
    position: relative;
    width: 500px;
    height: 150px;

  }
}
</style>
