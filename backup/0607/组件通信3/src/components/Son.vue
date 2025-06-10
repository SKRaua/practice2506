<template>
    <div class="son">
        <h2>我是儿子</h2>
        <GrandSon/>
    </div>
  
</template>

<script setup lang="ts">
    import GrandSon from './GrandSon.vue';
</script>

<style scoped>
    .son {
        background-color: yellow;
        padding: 10px;
        box-shadow: 0 0 10px black;
        border-radius: 10px;
    }

</style>