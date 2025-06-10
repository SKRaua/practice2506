<template>
  <div class="app">
    <Header msg="消息1" a="消息2" />

    <!-- 导航区-->
    <div class="navigate">
      <RouterLink to="/home" active-class="activated">首页</RouterLink>
      <!-- <RouterLink to="/news" active-class="activated">新闻</RouterLink> -->
      <RouterLink :to="{ name: 'two' }" active-class="activated"
        >新闻</RouterLink
      >
      <!-- <RouterLink to="/about" active-class="activated">关于</RouterLink> -->
      <RouterLink :to="{ path: '/about' }" active-class="activated"
        >关于</RouterLink
      >
    </div>

    <!--展示区-->
    <div class="main-content">
      <!--路由器视图-->
      <RouterView></RouterView>
    </div>
  </div>
</template>

<script lang="ts" setup name="App">
import { RouterView, RouterLink } from "vue-router";
import Header from "./components/Header.vue";
</script>

<style scoped>
.navigate {
  /* 设置整体的样式 */
  display: flex;
  justify-content: space-around;
  margin: 0, 100px;
}

.navigate a {
  /* 设置单体的样式 */
  display: block;
  text-align: center;
  width: 90px;
  height: 40px;
  line-height: 40px;
  border-radius: 10px;
  background-color: green;
  text-decoration: none;
  color: aliceblue;
  font-size: 20px;
  letter-spacing: 5px;
}

.navigate a.activated {
  /* 设置激活后的样式 */
  background-color: green;
  color: yellow;
  font-weight: 900;
  text-shadow: 0, 0, 1px black;
  font-family: 微软雅黑;
}

.main-content {
  /*调整展示区内容样式*/
  border: 1px solid;
  margin: 0 auto;
  margin-top: 30px;
  border-radius: 10px;
  width: 90%;
  height: 400px;
}
</style>
