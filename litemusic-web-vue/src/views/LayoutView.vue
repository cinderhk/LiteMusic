<template>
    <div>
      <NavComponent></NavComponent>
      <router-view></router-view>
    </div>
</template>
<script>
    import NavComponent from "@/components/NavComponent.vue";
    export default {
    components: {
        NavComponent,
    },
    };
</script>
