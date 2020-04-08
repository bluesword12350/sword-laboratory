<template>
  <div id="app">
    <h1 class="center-text">{{title}}</h1>
    <a-progress :percent="percent" :strokeWidth="20" :showInfo="false" strokeColor="red"/>
    <h2 class="center-text">{{konwTimeText}}</h2>
  </div>
</template>

<script>
import Vue from 'vue';
import { Progress } from 'ant-design-vue';
import dayjs from 'dayjs'

Vue.use(Progress);

let lastSpringFestival = new Date(2020, 0, 25).getTime();
let nextSpringFestival = new Date(2021, 1, 12).getTime();
let percent = ((Date.now() - lastSpringFestival) / (nextSpringFestival - lastSpringFestival)) * 100;
let knowDate = new Date(2020,0,23);
let dateTime = 24*60*60*1000;
let knowDateToNow = `${Math.trunc((Date.now()-knowDate.getTime())/dateTime)}天`

export default {
  name: "App",
  data() {
    return {
      title: `2020农历年进度:${percent}%`,
      percent : percent,
      konwTimeText : `与君宝宝结识于 ${dayjs(knowDate).format("YYYY-MM-DD")} ,过去了 ${knowDateToNow}`
    };
  }
};
</script>

<style>
  .center-text{
    text-align:center;
  }
</style>
