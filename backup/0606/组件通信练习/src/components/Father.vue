<template>
    <div class="father">
        <h2>我是你的爸</h2>
        <h3>我有一个火箭:{{rocket}}</h3>
        <h4>收到儿子的愿望:{{wish}}</h4>
        <!--Son注册在Father中,作为Father的子组件-->
        <Son :rocket="rocket" :sendWish="getWish"></Son>  <!--父组件传给子组件 使用双向绑定的方式-->
    </div>
  
</template>

<script setup lang="ts">
    import {ref} from 'vue'
    import Son from './Son.vue'
    let rocket=ref('spaceX')
    let wish=ref('')
    
    function getWish(value:string){
        wish.value=value
    }
</script>

<!--scope 只在本页面使用此样式-->
<style scope>
    .father{
        background-color:greenyellow;
        padding: 20px;
        border-radius: 10px;
    }
</style>