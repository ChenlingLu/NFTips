<template>
    <div ref="chartRef" :style="{ height, width }"></div>
</template>

<script setup>
import { onMounted, ref, watch } from 'vue';
import * as echarts from "echarts";

const props = defineProps({
    data: {
        type: Array,
        default: []
    },
    type: {
        type: String,
        default: 'revenue',
    },
    width: {
        type: String,
        default: '200px'
    },
    height: {
        type: String,
        default: '80px'
    }
});
const chartRef = ref(null);

onMounted(() => {
    initEchart(props.data, props.type);
})

const styleMap = {
    revenue: '#FFF500',
    tradingNum: '#0286FF',
}

const initEchart = ((data, type) => {
    console.log(data, '11111');
    const myChart = echarts.init(chartRef.value);
    const xData = data.map(item => item.time);
    const yData = data.map(item => item[type]);

    myChart.setOption(
        {
            tooltip: {
                trigger: 'axis'
            },
            xAxis: {
                type: 'category',
                data: xData,
                axisLabel: {
                    show: false
                },
            },
            yAxis: {
                type: 'value',
                axisLabel: {
                    show: false
                },
                splitLine: {
                    show: false,
                }
            },
            series: [
                {
                    data: yData,
                    type: 'bar',
                    itemStyle: {
                        color: styleMap[type]
                    }
                }
            ]
        }
    );
})

watch(() => props.data, (newValue, oldValue) => {
    initEchart(newValue, props.type);
})

</script>