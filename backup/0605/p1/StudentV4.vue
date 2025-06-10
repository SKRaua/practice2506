<template>
  <div class="Student">
    <h2>身高:{{ height }} cm</h2>
    <h2>体重:{{ weight }} kg</h2>
    <button @click="changeHeight">点一下长高5cm</button>
    <button @click="changeWeight">点一下长胖5kg</button>
  </div>
</template>

<script setup lang="ts" ,name="Student">
import { ref, watch, watchEffect } from "vue";
let height = ref(150);
let weight = ref(60);

function changeHeight() {
  height.value += 5;
}

function changeWeight() {
  weight.value += 5;
}

// const stopWatch=watch([height,weight],(newValue,oldValue)=>{
//     console.log("成长了",newValue,oldValue)
//     if(newValue[0]>200){
//         alert("太高了!")
//         stopWatch()
//     }

//     if(newValue[1]>200){
//         alert("太胖了!")
//         stopWatch()
//     }
// })

const stopWatch = watchEffect(() => {
  console.log("成长了!");
  if (height.value > 200) {
    //比较的是对象的数值
    alert("太高了!");
    stopWatch(); //在身高超过200时停止所有监视
  }

  if (weight.value > 200) {
    alert("太胖了!");
    stopWatch(); //在体重超过200时停止所有监视
  }
});

//分别监视身高和体重,仅展示新数据
// const stopWatchHeight=watch(height,(value)=>{
//     console.log("长高了!",value)
//     if(value>200){
//         alert("太高了!")
//         stopWatchHeight()
//     }
// })

// const stopWatchWeight=watch(weight,(value)=>{
//     console.log("长胖了!",value)
//     if(value>200){
//         alert("太胖了!")
//         stopWatchWeight()
//     }
// })
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
