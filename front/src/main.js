import { createApp } from 'vue'
import './style.scss'
import App from './App.vue'
import router from "./router";
import store from "./store/index"
import '@/utils/flexible.js'


createApp(App).use(router).use(store).mount('#app')
