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
    width: {
        type: String,
        default: '100%'
    },
    height: {
        type: String,
        default: '400px'
    }
});
const chartRef = ref(null);

onMounted(() => {
    initEchart(props.data);
})

const initEchart = ((data) => {

    const myChart = echarts.init(chartRef.value);
    const xData = data.map(item => item.time);
    const price = data.map(item => item.price);

    myChart.setOption(
        {
            tooltip: {
                trigger: 'axis'
            },
            xAxis: {
                type: 'category',
                data: xData
            },
            yAxis: {
                type: 'value'
            },
            series: [
                {
                    data: price,
                    type: 'line',
                    symbolSize: 12,
                    lineStyle: {
                        color: '#fff',
                    },
                    itemStyle: {
                        color: '#743799',
                        borderColor: '#fff',
                        borderWidth: 4
                    }
                }
            ]
        }
    );
})

watch(() => props.data, (newValue, oldValue) => {
    initEchart(newValue);
})

</script>