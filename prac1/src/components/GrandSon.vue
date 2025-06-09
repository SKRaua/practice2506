<template>
  <div class="grandSon">
    <h2>我是孙子</h2>
    <h3>得到爷爷的财产:{{ money }}万元</h3>
    <h3>得到爷爷的车:{{ car.name }},价值{{ car.price }}万元</h3>
    <button @click="updateMoney(2)">开始花爷爷的钱了</button>
  </div>
</template>

<script setup lang="ts">
import { inject } from "vue";
let { money, car, updateMoney } = inject("FatherContent", {
  money: 0,
  car: { name: "共享单车", price: 0 },
  updateMoney: (value: number) => {},
});
</script>

<style scoped>
.grandSon {
  background-color: #66ccff;
  padding: 10px;
  box-shadow: 0 0 10px black;
  border-radius: 10px;
}
</style>
