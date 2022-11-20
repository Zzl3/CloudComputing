<template>
  <div>
    <Navigation></Navigation>
    <div class="view-content">
      <div id="myChart" :style="{ width: '1200px', height: '600px' }"></div>
      <div
        id="myChart2"
        :style="{ width: '1200px', height: '550px', marginTop: '100px' }"
      ></div>
      <div
        id="myChart3"
        :style="{ width: '1200px', height: '550px', marginTop: '100px' }"
      ></div>
    </div>
  </div>
</template>

<script>
import Navigation from "@/components/Navigation";
export default {
  name: "Echarts",
  components: { Navigation },
  data() {
    return {};
  },
  mounted() {
    this.drawLine1();
    this.drawLine2();
    this.drawLine3();
  },
  methods: {
    drawLine1() {
      // 基于准备好的dom，初始化echarts实例
      let myChart = this.$echarts.init(document.getElementById("myChart"));
      const builderJson = {
        all: 548551,
        charts: {
          videogames: 1,
          babyproduct: 1,
          toy: 8,
          ce: 4,
          dvd: 19828,
          sports: 1,
          video: 26131,
          music: 103143,
          book: 393561,
          software: 5,
          nocategory: 5868,
        },
        components: {
          videogames: 3,
          babyproduct: 3,
          toy: 37,
          ce: 5,
          dvd: 5,
          sports: 5,
          video: 828410,
          music: 1411618,
          book: 4707583,
          software: 13,
        },
        ie: 9743,
      };
      const downloadJson = {
        videogames: 1,
        babyproduct: 1,
        toy: 8,
        ce: 4,
        dvd: 19828,
        sports: 1,
        video: 26131,
        music: 103143,
        book: 393561,
        software: 5,
        nocategory: 5868,
      };
      const themeJson = {
        videogames: 3,
        babyproduct: 3,
        toy: 37,
        ce: 5,
        dvd: 5,
        sports: 5,
        video: 828410,
        music: 1411618,
        book: 4707583,
        software: 13,
      };
      const canvas = document.createElement("canvas");
      const ctx = canvas.getContext("2d");
      canvas.width = canvas.height = 100;
      ctx.textAlign = "center";
      ctx.textBaseline = "middle";
      ctx.globalAlpha = 0.08;
      ctx.font = "20px Microsoft Yahei";
      ctx.translate(50, 50);
      ctx.rotate(-Math.PI / 4);

      // 绘制图表配置
      let option = {
        backgroundColor: {
          type: "pattern",
          image: canvas,
          repeat: "repeat",
        },
        tooltip: {},
        title: [
          {
            text: "在线构建",
            subtext: "总计 " + builderJson.all,
            left: "25%",
            textAlign: "center",
          },
          {
            text: "各类别商品数量",
            // subtext:
            //   "总计 " +
            //   Object.keys(downloadJson).reduce(function (all, key) {
            //     return all + downloadJson[key];
            //   }, 0),
            left: "75%",
            textAlign: "center",
          },
          {
            text: "各类别评论数量",
            subtext:
              "总计 " +
              Object.keys(themeJson).reduce(function (all, key) {
                return all + themeJson[key];
              }, 0),
            left: "75%",
            top: "50%",
            textAlign: "center",
          },
        ],
        grid: [
          {
            top: 50,
            width: "50%",
            bottom: "45%",
            left: 10,
            containLabel: true,
          },
          {
            top: "55%",
            width: "50%",
            bottom: 0,
            left: 10,
            containLabel: true,
          },
        ],
        xAxis: [
          {
            type: "value",
            max: builderJson.all,
            splitLine: {
              show: false,
            },
          },
          {
            type: "value",
            max: builderJson.all,
            gridIndex: 1,
            splitLine: {
              show: false,
            },
          },
        ],
        yAxis: [
          {
            type: "category",
            data: Object.keys(builderJson.charts),
            axisLabel: {
              interval: 0,
              rotate: 30,
            },
            splitLine: {
              show: false,
            },
          },
          {
            gridIndex: 1,
            type: "category",
            data: Object.keys(builderJson.components),
            axisLabel: {
              interval: 0,
              rotate: 30,
            },
            splitLine: {
              show: false,
            },
          },
        ],
        series: [
          {
            type: "bar",
            stack: "chart",
            z: 3,
            label: {
              position: "right",
              show: true,
            },
            data: Object.keys(builderJson.charts).map(function (key) {
              return builderJson.charts[key];
            }),
          },
          {
            type: "bar",
            stack: "chart",
            silent: true,
            itemStyle: {
              color: "#eee",
            },
            data: Object.keys(builderJson.charts).map(function (key) {
              return builderJson.all - builderJson.charts[key];
            }),
          },
          {
            type: "bar",
            stack: "component",
            xAxisIndex: 1,
            yAxisIndex: 1,
            z: 3,
            label: {
              position: "right",
              show: true,
            },
            data: Object.keys(builderJson.components).map(function (key) {
              return builderJson.components[key];
            }),
          },
          {
            type: "bar",
            stack: "component",
            silent: true,
            xAxisIndex: 1,
            yAxisIndex: 1,
            itemStyle: {
              color: "#eee",
            },
            data: Object.keys(builderJson.components).map(function (key) {
              return builderJson.all - builderJson.components[key];
            }),
          },
          {
            type: "pie",
            radius: [0, "30%"],
            center: ["75%", "25%"],
            data: Object.keys(downloadJson).map(function (key) {
              return {
                name: key.replace(".js", ""),
                value: downloadJson[key],
              };
            }),
          },
          {
            type: "pie",
            radius: [0, "30%"],
            center: ["75%", "75%"],
            data: Object.keys(themeJson).map(function (key) {
              return {
                name: key.replace(".js", ""),
                value: themeJson[key],
              };
            }),
          },
        ],
      };
      // 窗口大小自适应方案
      myChart.setOption(option);
      setTimeout(function () {
        window.onresize = function () {
          myChart.resize();
        };
      }, 800);
    },
    drawLine2() {
      const temdata = [
        "viedogame",
        "babyproduct",
        "toy",
        "ce",
        "dvd",
        "sports",
        "video",
        "music",
        "book",
        "software",
      ];
      let myChart = this.$echarts.init(document.getElementById("myChart2"));
      const yearCount = 10;
      const categoryCount = 10;
      const xAxisData = [];
      const customData = [];
      const legendData = [];
      const dataList = [];
      legendData.push("trend");
      const encodeY = [];
      for (var i = 0; i <= yearCount; i++) {
        legendData.push(1995 + i + "");
        dataList.push([]);
        encodeY.push(1 + i);
      }
      for (var i = 0; i < categoryCount; i++) {
        var val = Math.random() * 1000;
        xAxisData.push(temdata[i]);
        var customVal = [i];
        customData.push(customVal);
        for (var j = 0; j < dataList.length; j++) {
          var value =
            j === 0
              ? this.$echarts.number.round(val, 2)
              : this.$echarts.number.round(
                  Math.max(0, dataList[j - 1][i] + (Math.random() - 0.5) * 200),
                  2
                );
          dataList[j].push(value);
          customVal.push(value);
        }
      }
      let option = {
        tooltip: {
          trigger: "axis",
        },
        legend: {
          data: legendData,
        },
        dataZoom: [
          {
            type: "slider",
            start: 50,
            end: 70,
          },
          {
            type: "inside",
            start: 50,
            end: 70,
          },
        ],
        xAxis: {
          data: xAxisData,
        },
        yAxis: {},
        series: [
          {
            type: "custom",
            name: "trend",
            renderItem: function (params, api) {
              var xValue = api.value(0);
              var currentSeriesIndices = api.currentSeriesIndices();
              var barLayout = api.barLayout({
                barGap: "30%",
                barCategoryGap: "20%",
                count: currentSeriesIndices.length - 1,
              });
              var points = [];
              for (var i = 0; i < currentSeriesIndices.length; i++) {
                var seriesIndex = currentSeriesIndices[i];
                if (seriesIndex !== params.seriesIndex) {
                  var point = api.coord([xValue, api.value(seriesIndex)]);
                  point[0] += barLayout[i - 1].offsetCenter;
                  point[1] -= 20;
                  points.push(point);
                }
              }
              var style = api.style({
                stroke: api.visual("color"),
                fill: "none",
              });
              return {
                type: "polyline",
                shape: {
                  points: points,
                },
                style: style,
              };
            },
            itemStyle: {
              borderWidth: 2,
            },
            encode: {
              x: 0,
              y: encodeY,
            },
            data: customData,
            z: 100,
          },
          ...dataList.map(function (data, index) {
            return {
              type: "bar",
              animation: false,
              name: legendData[index + 1],
              itemStyle: {
                opacity: 0.5,
              },
              data: data,
            };
          }),
        ],
      };
      // 窗口大小自适应方案
      myChart.setOption(option);
      setTimeout(function () {
        window.onresize = function () {
          myChart.resize();
        };
      }, 800);
    },
    drawLine3() {
      let myChart = this.$echarts.init(document.getElementById("myChart3"));
      const data1 = [
        {
          name: "videogames",
          value: 1,
        },
        {
          name: "babyproduct",
          value: 2,
        },
        {
          name: "toy",
          value: 34,
        },
        {
          name: "ce",
          value: 2,
        },
        {
          name: "dvd",
          value: 4,
        },
        {
          name: "sports",
          value: 4,
        },
        {
          name: "video",
          value: 23546,
        },
        {
          name: "videogames",
          value: 45345,
        },
        {
          name: "music",
          value: 43654,
        },
        {
          name: "book",
          value: 532454,
        },
        {
          name: "software",
          value: 2,
        },
      ];
      const data2 = [
        {
          name: "videogames",
          value: 1,
        },
        {
          name: "babyproduct",
          value: 1,
        },
        {
          name: "toy",
          value: 12,
        },
        {
          name: "ce",
          value: 2,
        },
        {
          name: "dvd",
          value: 2,
        },
        {
          name: "sports",
          value: 1,
        },
        {
          name: "video",
          value: 23435,
        },
        {
          name: "videogames",
          value: 34543,
        },
        {
          name: "music",
          value: 23432,
        },
        {
          name: "book",
          value: 345344,
        },
        {
          name: "software",
          value: 4,
        },
      ];
      const data3 = [
        {
          name: "videogames",
          value: 0,
        },
        {
          name: "babyproduct",
          value: 0,
        },
        {
          name: "toy",
          value: 4,
        },
        {
          name: "ce",
          value: 0,
        },
        {
          name: "dvd",
          value: 0,
        },
        {
          name: "sports",
          value: 0,
        },
        {
          name: "video",
          value:23435,
        },
        {
          name: "videogames",
          value: 34545,
        },
        {
          name: "music",
          value: 25434,
        },
        {
          name: "book",
          value: 134654,
        },
        {
          name: "software",
          value: 2,
        },
      ];
      let option = {
        title: [
          {
            text: "各种类评分统计",
            left: "center",
          },
          {
            subtext: "4，5星级",
            left: "16.67%",
            top: "25%",
            textAlign: "center",
          },
          {
            subtext: "2，3星级",
            left: "50%",
            top: "25%",
            textAlign: "center",
          },
          {
            subtext: "1星级或无星级",
            left: "83.33%",
            top: "25%",
            textAlign: "center",
          },
        ],
        series: [
          {
            type: "pie",
            radius: "25%",
            center: ["50%", "50%"],
            data: data1,
            label: {
              position: "outer",
              alignTo: "none",
              bleedMargin: 5,
            },
            left: 0,
            right: "66.6667%",
            top: 0,
            bottom: 0,
          },
          {
            type: "pie",
            radius: "25%",
            center: ["50%", "50%"],
            data: data2,
            label: {
              position: "outer",
              alignTo: "labelLine",
              bleedMargin: 5,
            },
            left: "33.3333%",
            right: "33.3333%",
            top: 0,
            bottom: 0,
          },
          {
            type: "pie",
            radius: "25%",
            center: ["50%", "50%"],
            data: data3,
            label: {
              position: "outer",
              alignTo: "edge",
              margin: 20,
            },
            left: "66.6667%",
            right: 0,
            top: 0,
            bottom: 0,
          },
        ],
      };
      // 窗口大小自适应方案
      myChart.setOption(option);
      setTimeout(function () {
        window.onresize = function () {
          myChart.resize();
        };
      }, 800);
    },
  },
};
</script>

<style scoped></style>
