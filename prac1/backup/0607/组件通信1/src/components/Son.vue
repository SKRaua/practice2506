<template>
  <div class="son">
    <h2>我是儿子</h2>
    <h3>我有一个愿望:{{ wish }}</h3>
    <h4>收到了父亲给的大伊万:{{ rocket1 }}</h4>

    <button @click="emit('sendWish', wish)">点我把愿望告诉父亲</button>
  </div>
</template>

<script setup lang="ts">
import { ref } from "vue";
let wish = ref("我想上天!");
defineProps(["rocket1", "sendWish"]);

//自定义事件绑定
const emit = defineEmits(["sendWish"]);
</script>

<style scope>
.son {
  background-color: yellow;
  padding: 10px;
  box-shadow: 0 0 10px black;
  border-radius: 10px;
}
</style>
