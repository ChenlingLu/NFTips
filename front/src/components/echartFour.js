const  echartFour =   {
    backgroundColor: '#00265f00',
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    },
    xAxis: [{
        type: 'category',
        data: ['喀什市',
            '疏附县',
            '疏勒县',
            '英吉沙县',
            '泽普县',
            '岳普湖县',
            '巴楚县',
            '伽师县',
            '叶城县',
            '莎车县 ',
        ],
        axisLine: {
            show: false,
            lineStyle: {
                color: "#063374",
                width: 1,
                type: "solid"
            }
        },
        axisTick: {
            show: false
        },
        axisLabel: {
            show: false,
            textStyle: {
                color: "#00c7ff",
            }
        },
    }],
    yAxis: [{
        type: 'value',
         show: false,
        axisLabel: {
            formatter: '{value} %'
        },
        axisLine: {
            show: false,
            lineStyle: {
                color: "#00c7ff",
                width: 1,
                type: "solid"
            },
        },
        axisTick: {
            show: false
        },
        splitLine: {
             show: false,
            lineStyle: {
                 show: false,
                color: "#063374",
            }
        }
    }],
    series: [{
        type: 'bar',
        data: [20, 50, 80, 58, 83, 68, 57, 80, 42, 66],
        //barWidth: 50, //柱子宽度
        //barGap: 1, //柱子之间间距
        itemStyle: {
            normal: {
                color:'orange',
                opacity: 1,
            }
        }
    }]
};
export default echartFour