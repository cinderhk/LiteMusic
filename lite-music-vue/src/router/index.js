import { createRouter, createWebHashHistory } from "vue-router";
import HomeView from "../views/HomeView.vue";
import TopicView from "../views/TopicView.vue";
import MineView from "../views/MineView.vue";
import MusicianView from "../views/MusicianView.vue";
import LayoutView from "../views/LayoutView.vue";
import LoginView from  "../views/LoginView.vue";

const routes = [
  {
    path: "/",
    name: "LayoutView",
    component: LayoutView,
    children: [
      {
        path: "/home",
        name: "home",
        component: HomeView,
      },
      {
        path: "/topic",
        name: "TopicView",
        component: TopicView,
      },
      {
        path: "/musician",
        name: "MusicianView",
        component: MusicianView,
      },
      {
        path: "/mine",
        name: "MineView",
        component: MineView,
      },

      {
        path: "/login",
        name: "LoginView",
        component: LoginView,
      },
    ],
    
  },
];

const router = createRouter({
  history: createWebHashHistory(),
  routes,
  linkActiveClass:"active"
});

export default router;
