<template>
  <div class="Student">
    <!--v-bind:value是单向绑定 v-model是双向绑定-->
    姓:<input type="text" v-model="firstName" />
    <br />
    名:<input type="text" v-model="lastName" />
    <br />
    全名:<span
      >{{ firstName.slice(0, 1).toUpperCase() + firstName.slice(1) }}-{{
        lastName
      }}</span
    >
    <!--首字母大写-->
    <br />
    全名:<span>{{ fullName }}</span>
    <!--通过计算属性实现首字母大写，精简代码-->
    <br />
    <button @click="changeName">恢复默认值</button>
  </div>
</template>

<script setup lang="ts" name="Student123">
import { computed, ref } from "vue";

let firstName = ref("zhang");
let lastName = ref("san");

// let fullName=computed(function(){
//     console.log(1)
//     return firstName.value.slice(0,1).toUpperCase()+'-'+lastName.value
// })

// let fullName=computed(() =>{
//     console.log(1)
//     return firstName.value.slice(0,1).toUpperCase()+'-'+lastName.value
// })

//可修改的计算属性
let fullName = computed({
  //读取
  get() {
    return firstName.value + "-" + lastName.value;
  },

  //修改
  set(val) {
    console.log("修改后----------", val);
    const [fn, ln] = val.split("-");
    firstName.value = fn;
    lastName.value = ln;
  },
});

function changeName() {
  fullName.value = "zhang-san";
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
