<template>
  <div class="father">
    <h2>我是爹</h2>
    <Son />
    <Son2 />
  </div>
</template>

<script setup lang="ts">
import Son from "./Son.vue";
import Son2 from "./Son2.vue";
import { ref, reactive, provide } from "vue";
</script>

<style scoped>
.father {
  background-color: greenyellow;
  padding: 20px;
  border-radius: 10px;
}
</style>
