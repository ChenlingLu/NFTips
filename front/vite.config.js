import { defineConfig } from "vite";
import vue from "@vitejs/plugin-vue";
import { resolve } from "path";
import postcsspxtorem from "postcss-pxtorem";
import ElementPlus from "unplugin-element-plus/vite";
import postcsspxtoviewport from "postcss-px-to-viewport";
import { ElementPlusResolver } from "unplugin-vue-components/resolvers";
import AutoImport from "unplugin-auto-import/vite";
import Components from "unplugin-vue-components/vite";
// https://vitejs.dev/config/
export default defineConfig({
  server: {
    proxy: {
      "/query": {
        target: "http://nftips.io/",
        changeOrigin: true,
      },
    },
  },
  plugins: [
    vue(),
    ElementPlus({
      importStyle: "scss",
      useSource: true,
    }),
    AutoImport({
      resolvers: [ElementPlusResolver()],
    }),
    Components({
      resolvers: [ElementPlusResolver()],
    }),
  ],
  base: "./", // 添加这个属性
  css: {
    loaderOptions: {
      scss: {
        prependData: `
           @use "./src/style.scss" as *;
        `,
      },
    },
    postcss: {
      plugins: [
        // postcsspxtoviewport({
        //   unitToConvert: 'px', // 要转化的单位
        //   viewportWidth: 1512, // UI设计稿的宽度
        //   unitPrecision: 6, // 转换后的精度，即小数点位数
        //   propList: ['*'], // 指定转换的css属性的单位，*代表全部css属性的单位都进行转换
        //   viewportUnit: 'vw', // 指定需要转换成的视窗单位，默认vw
        //   fontViewportUnit: 'vw', // 指定字体需要转换成的视窗单位，默认vw
        //   selectorBlackList: ['ignore-'], // 指定不转换为视窗单位的类名，
        //   minPixelValue: 1, // 默认值1，小于或等于1px则不进行转换
        //   mediaQuery: true, // 是否在媒体查询的css代码中也进行转换，默认false
        //   replace: true, // 是否转换后直接更换属性值
        //   exclude: [/node_modules/], // 设置忽略文件，用正则做目录名匹配
        //   landscape: false // 是否处理横屏情况
        // })
        postcsspxtorem({
          rootValue: 100, //根节点字体大小，以100px为例，可根据自己需求修改
          propList: ["*"],
          selectorBlackList: [".px"],
          // 过滤掉.px-开头的class，不进行rem转换
        }),
      ],
    },
  },
  // 分割打包
  build: {
    sourcemap: false, // 开启 CSS source maps
    // assetsDir: './base/',
    chunkSizeWarningLimit: 1500,

    // Paths

    assetsSubDirectory: "static",
    assetsPublicPath: "./", //此处为修改的地方，这里加.
  },
  resolve: {
    // 新增
    //设置别名
    alias: {
      "@": resolve(__dirname, "./src"),
    },
  },
});
