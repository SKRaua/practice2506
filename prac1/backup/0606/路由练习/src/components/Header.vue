<template>
  <div>
    <h2 class="title">路由测试{{ msg }}{{ a }}</h2>
  </div>
</template>

<script setup lang="ts">
//props组件间通信
import { defineProps } from "vue";
let x = defineProps(["msg", "a"]); //参数必须式是数组的形式
console.log("=>", x);
</script>

<style scoped>
.title {
  text-align: center;
  margin: 10px, 50px;
  background-image: linear-gradient(45deg, green, white);
  height: 70px;
  line-height: 70px;
  border-radius: 10px;
  font-size: 35px;
  box-shadow: 0 0 5px;
}
</style>
