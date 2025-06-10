<template>
    <div class="son">
        <h2>我是儿</h2>
        <h3>我有一个愿望:{{wish}}</h3>
        <button @click="emitter.emit('goToSpace',wish)">送弟弟上天</button>
    </div>
  
</template>

<script setup lang="ts">
    import {ref} from 'vue'
    import emitter from '@/utils/emitter';

    let wish=ref('我想上天!')
   

</script>

<!--scope 只在本页面使用此样式-->
<style scoped>
    .son{
        background-color:yellow;
        padding:10px;
        box-shadow: 0 0 10px black;
        border-radius: 10px;
    }

</style>