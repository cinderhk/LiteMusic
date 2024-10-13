<template>
    <NavComponent></NavComponent>
    <main class="container">
        <RouterView></RouterView>
        
    </main>
    <FooterComponent></FooterComponent>
    
      
    
</template>

<script setup>
    import NavComponent from "../components/NavComponent.vue";
    import FooterComponent from "@/components/FooterComponent.vue";
    
</script>

<style lang="scss" scoped>
    @import url(../assets/common.scss);


</style>
