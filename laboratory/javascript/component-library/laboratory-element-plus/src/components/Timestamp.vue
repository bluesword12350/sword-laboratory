<script setup>
import { ref } from 'vue'
const now = ref(Date.now());
setInterval(() => now.value = Date.now(),1);
</script>

<template>
    <h1 class="center-text">{{`${now} 毫秒`}}</h1>
</template>

<style scoped>
    .center-text{
        text-align:center;
    }
</style>