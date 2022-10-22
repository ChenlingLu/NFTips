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
const  threeo =  {
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
            value: 25,
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
            value: 75,
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
        center: ['50%', '50%'],
        data: [{
            value: 50,
            itemStyle: {
                normal: {
                    color: '#b697cd',
                    shadowColor: '#b697cd',
                    shadowBlur: 10
                }
            }
        }, {
            value: 50,
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
            value: 75,
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
            value: 25,
            name: 'invisible',
            itemStyle: placeHolderStyle,
        }]
    }, ]
}
export default threeo