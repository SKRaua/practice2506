<template>
  <div class="Student">
    <h2>姓名:{{ st.name }}</h2>
    <h2>年龄:{{ st.age }}</h2>
    <h2>求和:{{ sum }}</h2>
    <h2>第一运动:{{ st.sport.a }}</h2>
    <h2>第二运动:{{ st.sport.b }}</h2>

    <button @click="changeName">修改名字</button>
    <button @click="changeAge">修改年龄</button>
    <button @click="changeSum">和加10</button>
    <button @click="changeDefualt">恢复默认</button>
    <button @click="changeFirst">修改第一运动</button>
    <button @click="changeSecond">修改第二运动</button>
    <hr />
    <!--加一条横线-->
    <h2>姓名:{{ person.name }}</h2>
    <h2>年龄:{{ person.age }}</h2>
    <button @click="changePersonName">修改名字</button>
    <button @click="changePersonAge">修改年龄</button>
    <button @click="changeAll">修改全部</button>
  </div>
</template>

<script setup lang="ts" name="Student123">
import { reactive, ref, toRefs, watch } from "vue";
//数据
let sum = ref(10);
let st = ref({
  name: "zhang",
  age: 18,
  sport: {
    a: "篮球",
    b: "足球",
  },
});

let person = reactive({
  name: "wang",
  age: 20,
});

function changeName() {
  st.value.name += "?";
}

function changeAge() {
  st.value.age += 1;
}

function changeSum() {
  sum.value += 10;
}

function changeDefualt() {
  st.value = { name: "wang", age: 18, sport: { a: "篮球", b: "足球" } };
}

function changeFirst() {
  st.value.sport.a += "太强了!";
}

function changeSecond() {
  st.value.sport.b += "太弱了!";
}

function changePersonName() {
  person.name += "!";
}

function changePersonAge() {
  person.age += 1;
}

function changeAll() {
  let { name, age } = toRefs(person);
  name.value = "wang";
  age.value = 18;
}

//监视ref基本数据类型
const stopWatch = watch(sum, (newValue, oldValue) => {
  console.log("发生了监视,修改 ", oldValue, "为 ", newValue);
  if (newValue >= 50) {
    console.log("停止监视", newValue);
    stopWatch();
  }
});

//监视ref对象的修改需要添加深度监视属性为true
watch(
  st,
  (newValue, oldValue) => {
    console.log("发生了监视,修改", oldValue, "为", newValue);
  },
  { deep: true }
);

//监视reactive对象，默认开启深度监视
watch(person, (newValue, oldValue) => {
  console.log("发生了监视,修改", oldValue, "为", newValue);
});

watch(
  () => st.value.sport,
  (newValue, oldValue) => {
    console.log("发生了监视,修改", oldValue, "为", newValue);
  },
  { deep: true }
);

watch(
  () => st.value.sport.a,
  (newValue, oldValue) => {
    console.log("发生了监视,修改", oldValue, "为", newValue);
  }
);
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
  max-width: 1200px;
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
