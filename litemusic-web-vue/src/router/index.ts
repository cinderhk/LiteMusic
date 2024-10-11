import { createRouter, createWebHistory } from 'vue-router'
import LayoutView from '@/views/LayoutView.vue';
import HomeView from '@/views/HomeView.vue';
import TopicView from "@/views/TopicView.vue";
import MineView from "@/views/MineView.vue";
import MusicianView from "@/views/MusicianView.vue";
import LoginView from  "@/views/LoginView.vue";
import PlayListInfoView from '@/views/PlayListInfoView.vue';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "LayoutView",
      component: LayoutView,
      redirect: "/home",
      children: [
        {
        path: "/home",
        name: "home",
        component: HomeView,
        },
        
        {
          path: "topic",
          name: "TopicView",
          component: TopicView,
        },
        {
          path: "musician",
          name: "MusicianView",
          component: MusicianView,
        },
        {
          path: "mine",
          name: "MineView",
          component: MineView,
        },
        {
          path: "playlistinfo",
          name: "PlayListInfo",
          component: PlayListInfoView,
        },
        
      ],
    },
    {
      path: "/login",
      name: "LoginView",
      component: LoginView,
    },
    
  ],
})

export default router
