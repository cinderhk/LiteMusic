<template>
    <header class="wrapper_">
        <nav class="container">
            <div class="left">
            <h1 class="logo">
                <img src="../assets/logo.png" alt="" />
                酷我音乐
            </h1>
            <div class="links">
                <router-link exact to="/home" active-class="active">首页</router-link>
                <router-link exact to="/topic" active-class="active">排行榜</router-link>
                <router-link exact to="/musician" active-class="active">歌手</router-link>
                <router-link exact to="/mine"active-class="active">我的</router-link>            
            </div>
            </div>
        <div class="right">
                <SearchBar />
        </div>
        <!-- <div class="right">
            <a @click="login">登录</a>
        </div> -->
        </Nav>
    </header>
    
</template>

<script lang="ts" setup>
    import SearchBar from "@/components/SearchBarComponent.vue"
    

</script>
<style lang="scss">
@import url(./Nav.module.scss);
</style>