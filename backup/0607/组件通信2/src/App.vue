<template>
  <Father />
</template>

<script setup lang="ts">
import Father from "./components/Father.vue";
import Son from "./components/Son.vue";
import emitter from "./utils/emitter";

emitter.on("event1", () => {
  console.log("event1 has been triggered.");
});

emitter.on("event2", () => {
  console.log("event2 has been triggered.");
});

//使用定时器触发事件
setInterval(() => {
  //回调函数 触发的事件event1和event2
  emitter.emit("event1");
  emitter.emit("event2");
}, 2000);

//解绑事件
setTimeout(() => {
  // emitter.off('event1')
  // emitter.off('event2')
  emitter.all.clear(); //全部解绑事件
}, 5000); //定时5s结束触发事件
</script>

<style scoped></style>
