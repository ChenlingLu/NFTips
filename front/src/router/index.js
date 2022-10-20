import { createRouter, createWebHistory } from "vue-router";
const history = createWebHistory()
const routes = [
  {
    path: "/",
    redirect: "/home",
  },
  {
    path: "/home",
    name: "home",
    component: () => import("../views/home/index.vue"),
  },
  {
    path: "/detail",
    name: "detail",
    component: () => import("../views/detail/index.vue"),
  },
];
const router = createRouter({
      history,
      routes
})
export default router