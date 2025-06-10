<template>
  <div class="about">
    <div class="content">
      <h1>欢迎报考重庆邮电大学</h1>
      <h2><a href="http://www.cqupt.edu.cn">点击跳转首页</a></h2>
    </div>
  </div>
</template>

<script setup lang="ts" name="About"></script>

<style scoped>
.about {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100%;
  color: rgb(208, 25, 25);
}

.content {
  text-align: center;
}

h1,
h2 {
  margin: 0;
  padding: 10px 0;
}

a {
  text-decoration: none;
  color: cadetblue;
  display: inline-block;
}
</style>
