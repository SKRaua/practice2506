<template>
  <div class="father">
    <h2>我是父亲</h2>
    <h3>我有一个大伊万:{{ rocket }}</h3>
    <h4>收到儿子的愿望:{{ wish }}</h4>

    <!-- 自定义事件绑定 将sendWish定义为事件  -->
    <Son :rocket1="rocket" @sendWish="getWish"></Son>
  </div>
</template>

<script setup lang="ts">
import Son from "./Son.vue";
import { ref } from "vue";
let rocket = ref("Boom!大伊万");
let wish = ref("");

function getWish(value: any) {
  console.log("print param:", value);
  wish.value = value;
}
</script>

<!--scope 只在本页面使用此样式-->
<style scope>
.father {
  background-color: greenyellow;
  padding: 20px;
  border-radius: 10px;
}
</style>
