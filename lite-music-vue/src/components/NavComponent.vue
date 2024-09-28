<template>
  <header class="wrapper">
    <nav className="container">
        <div class="left">
          <h1 class="logo">
            <img src="../assets/logo.png" alt="" />
            酷我音乐
          </h1>
          <div class="links">

            <NavLink><router-link exact to="/">首页</router-link></NavLink>
            <NavLink><router-link exact to="/topic">排行榜</router-link></NavLink>
            <NavLink><router-link exact to="/mine">我的</router-link></NavLink>
            <NavLink><router-link exact to="/search">搜索</router-link></NavLink>
          
          </div>
        </div>
      <div class="right">
              <SearchBar />
      </div>
    </Nav>
  </header>

</template>

<script>
import SearchBar from './SearchComponent.vue';
export default {
  components: {
    SearchBar,
  }
}
</script>
<style scoped>
.wrapper {
  display: flex;
  align-items: center;
  height: 67px;
  border-bottom: 1px solid #f0f0f0;

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
            background: #ffe443;
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

