<template>
  <div class="son">
    <h2>我是弟弟</h2>
    <h3>哥哥让我:{{ completeWish }}</h3>
  </div>
</template>

<script setup lang="ts">
import { ref } from "vue";
import emitter from "@/utils/emitter";

let completeWish = ref("");
emitter.on("goToSpace", (wish: any) => {
  completeWish.value = wish;
});
</script>

<style scoped>
.son {
  background-color: rgb(0, 238, 255);
  padding: 10px;
  box-shadow: 0 0 10px black;
  border-radius: 10px;
}
</style>
