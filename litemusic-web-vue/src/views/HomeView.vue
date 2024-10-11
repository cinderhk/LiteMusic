<template>
  <BannerComponent></BannerComponent>
  <RecommendComponent></RecommendComponent>
  <PlayListCardComponent></PlayListCardComponent>
  <router-view></router-view>
</template>

<script>
import BannerComponent from '@/components/BannerComponent.vue';
import RecommendComponent from '@/components/RecommendComponent.vue';
import PlayListCardComponent from '@/components/PlayListCardComponent.vue';
export default {
  components: {
    BannerComponent,
    RecommendComponent,
    PlayListCardComponent
  },
};
</script>
<style lang="scss" scoped>

</style>