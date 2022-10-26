<template>
  <section class="three">
    <div class="echarts" ref="chartRef" id="one" />
  </section>

</template>

<script setup name="three">
import { defineProps, onMounted, watch, ref, reactive } from 'vue'
import * as echarts from "echarts";
import { reactiveComputed } from '@vueuse/shared';

const props = defineProps({
  data: Number
});

let chartRef = ref(null);

let myChart = null;

onMounted(() => {
  initEchart(props.data);
})

const initEchart = ((data) => {

  myChart = echarts.init(chartRef.value);

  var dataStyle = {
    normal: {
      label: {
        show: false
      },
      labelLine: {
        show: false
      },
    }
  };
  var placeHolderStyle = {
    normal: {
      color: 'rgba(44,59,70,1)',
    },
  };
  myChart.setOption(
    {
      title: {
        show: true,
        text: '实际交易数，在 7 天内 /28 天内 /356 天内交易次数',
        bottom: 0,
        textStyle: {
          fontSize: 12,
          color: '#FFFFFF',
        },
        left: '20%',
      },
      series: [{
        name: 'Pie1',
        type: 'pie',
        clockWise: false,
        radius: [60, 68],
        itemStyle: dataStyle,
        hoverAnimation: false,
        center: ['15%', '50%'],
        data: [{
          value: parseInt(data.small?.radio) || 0,
          label: {
            normal: {
              formatter: [
                `{a|${data.small?.radio || 0}}`,
                `{b|${data.small?.tip || ''}}`
              ].join('\n'),
              show: true,
              position: 'center',
              textStyle: {
                rich: {
                  a: {
                    color: '#fff',
                    fontSize: '16px',
                    fontWeight: 600,
                    lineHeight: '20'
                  },
                  b: {
                    color: '#7C7C7C',
                    fontSize: '12px',
                    lineHeight: '16'
                  },
                },
              }
            }
          },
          itemStyle: {
            normal: {
              color: '#F6AF87',
            }
          }
        }, {
          value: 100 - (parseInt(data.small?.radio) || 0),
          name: 'invisible',
          itemStyle: placeHolderStyle,
        }]
      }, {
        name: 'Pie2',
        type: 'pie',
        clockWise: false,
        radius: [60, 68],
        itemStyle: dataStyle,
        hoverAnimation: false,
        center: ['45%', '50%'],
        data: [{
          value: parseInt(data.middle?.radio) || 0,
          label: {
            normal: {
              formatter: [
                `{a|${data.middle?.radio || 0}}`,
                `{b|${data.middle?.tip || ''} }`
              ].join('\n'),
              show: true,
              position: 'center',
              textStyle: {
                rich: {
                  a: {
                    color: '#fff',
                    fontSize: '16px',
                    fontWeight: 600,
                    lineHeight: '20'
                  },
                  b: {
                    color: '#7C7C7C',
                    fontSize: '12px',
                    lineHeight: '16'
                  },
                },
              }
            }
          },
          itemStyle: {
            normal: {
              color: '#FF8B4A',
            }
          }
        }, {
          value: 100 - (parseInt(data.middle?.radio) || 0),
          name: 'invisible',
          itemStyle: placeHolderStyle,
        }]
      }, {
        name: 'Pie3',
        type: 'pie',
        clockWise: false,
        radius: [60, 68],
        itemStyle: dataStyle,
        hoverAnimation: false,
        center: ['75%', '50%'],
        data: [{
          value: parseInt(data.lager?.radio) || 0,
          label: {
            normal: {
              formatter: [
                `{a|${data.lager?.radio || 0}}`,
                `{b|${data.lager?.tip || ''} }`
              ].join('\n'),
              show: true,
              position: 'center',
              textStyle: {
                rich: {
                  a: {
                    color: '#fff',
                    fontSize: '16px',
                    fontWeight: 600,
                    lineHeight: '20'
                  },
                  b: {
                    color: '#7C7C7C',
                    fontSize: '12px',
                    lineHeight: '16'
                  },
                },
              }
            }
          },
          itemStyle: {
            normal: {
              color: '#FF5C00',
            }
          }
        }, {
          value: 100 - (parseInt(data.lager?.radio) || 0),
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

<style scoped lang="scss">
.three {
  .echarts {
    position: relative;
    width: 100%;
    height: 200px;

  }
}
</style>
