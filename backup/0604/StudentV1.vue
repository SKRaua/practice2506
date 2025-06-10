<template>
  <div class="Student">
    <h2>姓名: {{ name }}</h2>
    <h2>年龄: {{ age }}</h2>
    <h2>学号: {{ num }}</h2>

    <button @click="changeAge">年龄+1</button>
    <button @click="changeNum">学号+1</button>
    <button @click="changeName">名字+6</button>
  </div>
</template>

<script lang="ts">
export default {
  name: "Student",
  data() {
    return {
      name: "周昕阳",
      age: 18,
      num: 100,
    };
  },
  methods: {
    changeAge() {
      this.age += 1;
    },
    changeNum() {
      this.num += 1;
    },
    changeName() {
      this.name += "6";
    },
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
