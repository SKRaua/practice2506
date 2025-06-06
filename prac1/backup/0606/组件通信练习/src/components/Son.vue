<template>
  <div class="son">
    <h2>我是你的儿</h2>
    <h3>我有一个愿望:{{ wish }}</h3>
    <h4>收到了父亲给的火箭:{{ rocket }}</h4>
    <button @click="sendWish(wish)">点我把愿望告诉父亲</button>
  </div>
</template>

<script setup lang="ts">
import { ref } from "vue";
let wish = ref("我想上天!");
defineProps(["rocket", "sendWish"]);
</script>

<style scoped>
.son {
  background-color: yellow;
  padding: 10px;
  box-shadow: 0 0 10px black;
  border-radius: 10px;
}
</style>
