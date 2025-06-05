<template>
  <div class="Student">
    <h2>姓名:{{ st.name }}</h2>
    <h2>年龄:{{ st.age }}</h2>
    <h2>学号:{{ st.num }}</h2>
    <h2>数据:{{ a.b.c }}</h2>

    <button @click="changeAge">年龄+1</button>
    <button @click="changeNum">学号+1</button>
    <button @click="changeName">名字加 =</button>
    <button @click="changeData">+10</button>

    <ul>
      <li v-for="b in book" :key="b.id">{{ b.name }}</li>
    </ul>
    <button @click="changeFirstBookName">修改第一本书的名字</button>
  </div>
</template>

<script setup lang="ts" name="Student123">
import { reactive, ref } from "vue";

let st = reactive({
  //响应式数据
  name: "名字",
  age: 18,
  num: 100,
});

// console.log("st===========", st);

let a = ref({
  b: {
    c: 666,
  },
});

console.log("a=============", a);

let book = reactive([
  { id: "abc111", name: "计算机组成原理" },
  { id: "abc222", name: "数据结构" },
  { id: "abc333", name: "计算机网络" },
  { id: "abc444", name: "操作系统" },
]);

function changeAge() {
  st.age += 1;
  console.log(st.age);
}

function changeNum() {
  st.num += 1;
  console.log(st.num);
}

function changeName() {
  st.name += "=";
  console.log(st.name);
}

function changeFirstBookName() {
  book[0].name = "超级计算机组成原理";
}

function changeData() {
  a.value.b.c += 10;
}
</script>

<style scoped>
.Student {
  background-color: rgb(249, 198, 237);
  align-items: center;
  font-size: 2em;
  text-align: center;
  box-shadow: 0 0 10px;
  border-radius: 10px;
  padding: 25px;
  margin: 20px;
}
button {
  margin: 10px;
}
li {
  font-size: 20px;
}
</style>
