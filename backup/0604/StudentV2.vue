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

<script lang="ts">
export default {
  name: "Student",
  setup() {
    let name = "周昕阳";
    let age = 18;
    let num = 100;
    function ageAdd1() {
      age += 1;
      console.log(age);
    }
    function numAdd1() {
      num += 1;
      console.log(num);
    }
    function nameAdd6() {
      name += "6";
      console.log(name);
    }
    return { name, age, num, ageAdd1, numAdd1, nameAdd6 };
  },
};
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
