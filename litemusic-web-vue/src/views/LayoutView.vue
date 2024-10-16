<template>
    <NavComponent></NavComponent>
    <main class="container">
        <RouterView></RouterView>
          
    </main>

    <FooterComponent></FooterComponent>
    <PlayComponent></PlayComponent>
    
      
    
</template>

<script setup>
    import PlayComponent from "@/components/PlayComponent.vue";
    import NavComponent from "../components/NavComponent.vue";
    import FooterComponent from "@/components/FooterComponent.vue";
    
</script>

<style lang="scss" scoped>

</style>
