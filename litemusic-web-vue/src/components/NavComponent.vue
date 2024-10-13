<template>
    <header class="wrapper">
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

<script setup lang="ts">
    import SearchBar from "@/components/SearchBarComponent.vue"
    

</script>
<style lang="scss" scoped>
.wrapper {
  width: 100%;
  position: sticky;
  top: 0;
  left: 0;
  z-index: 999;
  display: flex;
  align-items: center;
  height: 67px;
  border-bottom: 1px solid #f0f0f0;
  background: #fff;

  nav {
    display: flex;
    align-items: center;
    justify-content: space-between;
    width: 100%;

    .left {
      display: flex;

      .logo {
        display: flex;
        align-items: center;
        margin-right: 39px;
        font-size: 0;

        img {
          width: 139px;
          object-fit: cover;
        }
      }

      .links {
        display: flex;
        gap: 4px;

        a {
          padding: 0 14px;
          font-size: 16px;
          font-weight: 300;
          line-height: 67px;
          color: #333;
          text-decoration: none;

          &.active {
            font-weight: 600;
          }
        }
      }
    }

    .right {
      display: flex;
      align-items: center;

      .login {
        font-size: 14px;
        line-height: 67px;
        color: #333;
        text-decoration: none;
      }
    }
  }
}


</style>