const zheo = {
  tooltip: {
    trigger: "axis",
  },
  xAxis: [
    {
      type: "category",
      data: [
        "1662606241000",
        "1663723995000",
        "1663724408000",
        "1663728542000",
        "1663729152000",
        "1662610594000",
      ],
      axisLine: {
        lineStyle: {
          color: "#999",
        },
      },
    },
  ],
  yAxis: [
    {
      type: "value",
      splitNumber: 4,
      splitLine: {
        lineStyle: {
          type: "dashed",
          color: "#DDD",
        },
      },
      axisLine: {
        show: false,
        lineStyle: {
          color: "#333",
        },
      },
      nameTextStyle: {
        color: "#999",
      },
      splitArea: {
        show: false,
      },
    },
  ],
  series: [
    {
      name: "price",
      type: "line",
      data: [995, 577.86, 982.69, 544.12, 707.45, 991.79],
      lineStyle: {
        normal: {
          width: 8,
          color: {
            type: "linear",

            colorStops: [
              {
                offset: 0,
                color: "#A9F387", // 0% 处的颜色
              },
              {
                offset: 1,
                color: "#48D8BF", // 100% 处的颜色
              },
            ],
            globalCoord: false, // 缺省为 false
          },
          shadowColor: "rgba(72,216,191, 0.3)",
          shadowBlur: 10,
          shadowOffsetY: 20,
        },
      },
      itemStyle: {
        normal: {
          color: "#fff",
          borderWidth: 10,
          /*shadowColor: 'rgba(72,216,191, 0.3)',
                shadowBlur: 100,*/
          borderColor: "#A9F387",
        },
      },
      smooth: true,
    },
  ],
};
export default zheo;
