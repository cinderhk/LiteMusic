import { createRouter, createWebHashHistory } from "vue-router";
import HomeView from "../views/HomeView.vue";
import TopicView from "../views/TopicView.vue";
import MineView from "../views/MineView.vue";
import SearchView from "../views/SearchView.vue";
import LayoutView from "../views/LayoutView.vue";

const routes = [
  {
    path: "/",
    name: "LayoutView",
    component: LayoutView,
    children: [
      {
        path: "/",
        name: "home",
        component: HomeView,
      },
      {
        path: "/topic",
        name: "TopicView",
        component: TopicView,
      },
      {
        path: "/mine",
        name: "MineView",
        component: MineView,
      },
      {
        path: "/search",
        name: "SearchView",
        component: SearchView,
      },
    ],
  },
];

const router = createRouter({
  history: createWebHashHistory(),
  routes,
});

export default router;
