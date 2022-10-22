import { createRouter, createWebHashHistory  } from "vue-router";
const history = createWebHashHistory()
const home = () => import("../views/home/index.vue")
const detail = () => import("../views/detail/index.vue")
const routes = [
  {
    path: "/",
    redirect: "/home",
  },
  {
    path: "/home",
    name: "home",
    component: home,
  },
  {
    path: "/detail",
    name: "detail",
    component:detail,
  },
];
const router = createRouter({
      history,
      routes
})
export default router