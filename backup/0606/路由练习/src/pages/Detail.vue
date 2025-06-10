<template>
  <ul class="new-list">
    <!--直接获取参数-->
    <li>编号:{{ id }}</li>
    <li>标题:{{ title }}</li>
    <li>内容:{{ content }}</li>
  </ul>
</template>

<script setup lang="ts" name="Detail">
import { useRoute } from "vue-router";
import { defineProps } from "vue";
let x = defineProps(["id", "title", "content"]);
console.log("x->", x);
// const route=useRoute()
// console.log("route----->",route)
</script>

<style scoped></style>
