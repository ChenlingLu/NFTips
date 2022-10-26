<template>
  <section class="yibiao">
    <div class="yibiao_title">Buying Index</div>
    <div class="echarts" ref="chart" id="yibiao" />
    <p class="small">
      Buying Index = transaction times * 30% + avg transaction time * 20% + avg price increase/decrease * 50%
    </p>
  </section>

</template>

<script setup name="yibao">
import { reactive, defineProps, onMounted, watch, ref } from 'vue'
import * as echarts from "echarts";

const props = defineProps({
  data: Number
});

onMounted(() => {

  initEchart(props.data);
})

const initEchart = (data) => {
  const myChart = echarts.init(document.getElementById('yibiao'));
  var colorSet = {
    color: '#468EFD'
  };
  const dataArr = data || 0;
  myChart.setOption(
    {
      series: [
        {
          type: 'gauge',
          progress: {
            show: true,
            width: 8
          },
          axisLine: {
            lineStyle: {
              width: 8
            }
          },
          axisTick: {
            show: false,
          },
          splitLine: {
            length: 6,
            distance: 4,
            lineStyle: {
              width: 1,
              color: '#999'
            }
          },
          axisLabel: {
            distance: 12,
            color: '#999',
            fontSize: 10
          },
          anchor: {
            show: true,
            showAbove: true,
            size: 10,
            itemStyle: {
              borderWidth: 4
            }
          },
          pointer: {
            width: 2,
            length: '50%',
          },
          title: {
            show: false
          },
          detail: {
            valueAnimation: true,
            fontSize: 24,
            offsetCenter: [0, '70%']
          },
          data: [
            {
              value: 70
            }
          ]
        }
      ]
    }
  );
}

watch(() => props.data, (newValue, oldValue) => {
  console.log(newValue, oldValue);
  if (newValue !== oldValue) {
    initEchart(newValue);
  }
})

</script>
<!-- <script >
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

  props: ['data'],

  methods: {
    // 初始化
    init() {

      var myChart = echarts.init(document.getElementById('yibiao'));
      var colorSet = {
        color: '#468EFD'
      };
      const dataArr = this.props.data||0;
      myChart.setOption({
        backgroundColor: '#0E132700',
        tooltip: {
          formatter: "{a} <br/>{b} : {c}%"
        },

        series: [{
          name: "内部进度条",
          type: "gauge",
          // center: ['20%', '50%'],
          radius: '40%',

          splitNumber: 10,
          axisLine: {
            lineStyle: {
              color: [
                [dataArr / 100, colorSet.color],
                [1, "#111F42"]
              ],
              width: 8
            }
          },
          axisLabel: {
            show: false,
          },
          axisTick: {
            show: false,

          },
          splitLine: {
            show: false,
          },
          itemStyle: {
            show: false,
          },
          detail: {
            formatter: function (value) {
              if (value !== 0) {
                var num = Math.round(value);
                return parseInt(num).toFixed(0) + "%";
              } else {
                return 0;
              }
            },
            offsetCenter: [0, 82],
            textStyle: {
              padding: [0, 0, 0, 0],
              fontSize: 18,
              fontWeight: '700',
              color: colorSet.color
            }
          },
          title: { //标题
            show: true,
            offsetCenter: [0, 46], // x, y，单位px
            textStyle: {
              color: "#fff",
              fontSize: 14, //表盘上的标题文字大小
              fontWeight: 400,
              fontFamily: 'PingFangSC'
            }
          },
          data: [{
            name: "title",
            value: dataArr,
          }],
          pointer: {
            show: true,
            length: '75%',
            radius: '20%',
            width: 10, //指针粗细
          },
          animationDuration: 4000,
        },
        {
          name: '外部刻度',
          type: 'gauge',
          //  center: ['20%', '50%'],
          radius: '50%',
          min: 0, //最小刻度
          max: 100, //最大刻度
          splitNumber: 10, //刻度数量
          startAngle: 225,
          endAngle: -45,
          axisLine: {
            show: true,
            lineStyle: {
              width: 1,
              color: [
                [1, 'rgba(0,0,0,0)']
              ]
            }
          }, //仪表盘轴线
          axisLabel: {
            show: true,
            color: '#4d5bd1',
            distance: 25,
            formatter: function (v) {
              switch (v + '') {
                case '0':
                  return '0';
                case '10':
                  return '10';
                case '20':
                  return '20';
                case '30':
                  return '30';
                case '40':
                  return '40';
                case '50':
                  return '50';
                case '60':
                  return '60';
                case '70':
                  return '70';
                case '80':
                  return '80';
                case '90':
                  return '90';
                case '100':
                  return '100';
              }
            }
          }, //刻度标签。
          axisTick: {
            show: true,
            splitNumber: 7,
            lineStyle: {
              color: colorSet.color, //用颜色渐变函数不起作用
              width: 1,
            },
            length: -8
          }, //刻度样式
          splitLine: {
            show: true,
            length: -20,
            lineStyle: {
              color: colorSet.color, //用颜色渐变函数不起作用
            }
          }, //分隔线样式
          detail: {
            show: false
          },
          pointer: {
            show: false
          }
        },
        ]
      });
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
.yibiao {
  border-bottom: 1px solid #797979;

  .small {
    font-weight: 400;
    font-size: 12px;
    line-height: 15px;
    color: #7C7C7C;
    margin: 20px 0 16px;
  }

  .yibiao_title {
    font-weight: 500;
    line-height: 29px;
    color: #FFFFFF;
    font-size: 24px;
    color: #FFFFFF;
    margin-bottom: 10px;
  }

  .echarts {
    width: 250px;
    height: 200px;
    background: #fff;
    border-radius: 6px;
  }
}
</style>
