<template>
  <div>
    <NavComponent></NavComponent>
    <router-view></router-view>
  </div>
</template>
<script>
import NavComponent from "../components/NavComponent.vue";
import SearchBar from "../components/SearchComponent.vue";

export default {
  components: {
    NavComponent,
    SearchBar,

  },
};
</script>
