<template>
  <div class="father">
    <h2>我是父亲</h2>
    <h3>我的财产:{{ money }}万元</h3>
    <h3>我的车:{{ car.name }},价值{{ car.price }}万元</h3>
    <Son />
  </div>
</template>

<script setup lang="ts">
import Son from "./Son.vue";
import { ref, reactive, provide } from "vue";

let money = ref(100);
let car = reactive({
  name: "BMW",
  price: 5000,
});

function updateMoney(value: number) {
  money.value -= value;
}

provide("FatherContent", { money, car, updateMoney });
</script>

<style scoped>
.father {
  background-color: greenyellow;
  padding: 20px;
  border-radius: 10px;
}
</style>
