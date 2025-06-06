<template>
  <div class="Student">
    <h2>姓名:{{ st.name }}</h2>
    <h2>年龄:{{ st.age }}</h2>
    <button @click="changeAge">年龄+1</button>
    <button @click="changeNum">修改数字</button>
    <h2>b={{ a.b }}</h2>
    <h2>c={{ a.c }}</h2>
    <button @click="changeName">修改名字</button>
  </div>
</template>

<script setup lang="ts">
import { reactive, ref, toRef, toRefs } from "vue";
let st = reactive({
  //响应式数据
  name: "你的名字",
  age: 18,
});

let a = ref({
  b: 10,
  c: 20,
});

let { name, age } = toRefs(st);

let n1 = toRef(st, "name");

function changeAge() {
  st.age += 1;
  console.log(st.age);
}

function changeNum() {
  a.value = { b: 100, c: 200 };
  console.log("ref对象修改后");
}

function changeName() {
  n1.value += "??";
  age.value += 1;
  console.log("reactive对象修改后", st);
}
</script>

<style scoped>
.Student {
  background-color: #66ccff;
  align-items: center;
  font-size: 2em;
  text-align: center;
  box-shadow: 0 4px 24px rgba(0, 0, 0, 0.12), 0 1.5px 3px rgba(0, 0, 0, 0.08);
  border-radius: 16px;
  padding: 32px 24px;
  margin: 32px auto;
  max-width: 400px;
  transition: box-shadow 0.3s;
}
.Student:hover {
  box-shadow: 0 8px 32px rgba(0, 0, 0, 0.18), 0 3px 6px rgba(0, 0, 0, 0.12);
}
button {
  margin: 12px 8px;
  padding: 10px 24px;
  font-size: 1em;
  border: none;
  border-radius: 8px;
  background: #fff;
  color: #2196f3;
  cursor: pointer;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.08);
  transition: background 0.2s, color 0.2s, box-shadow 0.2s;
}
button:hover {
  background: #2196f3;
  color: #fff;
  box-shadow: 0 4px 16px rgba(33, 150, 243, 0.15);
}
h2 {
  margin: 16px 0 8px 0;
  font-weight: 500;
  letter-spacing: 1px;
}
@media (max-width: 500px) {
  .Student {
    padding: 16px 8px;
    font-size: 1.2em;
    max-width: 95vw;
  }
  button {
    width: 100%;
    margin: 8px 0;
  }
}
</style>
