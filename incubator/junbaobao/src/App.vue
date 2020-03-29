<template>
  <div id="app">
    <h1 style="text-align:center;">{{title}}</h1>
    <a-progress :percent="percent" :strokeWidth="20" :showInfo="false" :strokeColor="red"/>
  </div>
</template>

<script>
let lastSpringFestival = new Date(2020, 0, 25).getTime();
let nextSpringFestival = new Date(2021, 1, 12).getTime();
let percent = ((Date.now() - lastSpringFestival) / (nextSpringFestival - lastSpringFestival)) * 100;
export default {
  name: "App",
  data() {
    return {
      title: "2020农历年进度:"+percent+"%",
      percent: percent
    };
  }
};
</script>

<style>
</style>
