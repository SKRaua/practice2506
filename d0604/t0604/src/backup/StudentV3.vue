<template>
  <div class="Student">
    <h2>姓名: {{ name }}</h2>
    <h2>年龄: {{ age }}</h2>
    <h2>学号: {{ num }}</h2>

    <button @click="ageAdd1">年龄+1</button>
    <button @click="numAdd1">学号+1</button>
    <button @click="nameAdd6">名字+6</button>
  </div>
</template>

<script setup lang="ts" name="Student">
import { ref } from "vue";

let name = ref("周昕阳");
let age = ref(18);
let num = ref(100);
function ageAdd1() {
  age.value += 1;
  console.log(age.value);
}
function numAdd1() {
  num.value += 1;
  console.log(num.value);
}
function nameAdd6() {
  name.value += "6";
  console.log(name.value);
}
</script>

<style scoped>
.Student {
  background-color: rgb(244, 189, 231);
  align-items: center;
  font-size: 2em;
  text-align: center;
  box-shadow: 0 0 10px;
  border-radius: 10px;
  padding: 25px;
  margin: 20px;
}
button {
  margin: 5px;
}
</style>
