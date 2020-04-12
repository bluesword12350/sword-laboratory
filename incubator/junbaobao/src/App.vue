<template>
  <div id="app">
    <h1 class="center-text">{{`2020农历年进度:${percent}%`}}</h1>
    <a-progress :percent="percentNum" :strokeWidth="20" :showInfo="false" strokeColor="red"/>
    <h2 class="center-text">与君宝宝结识于 {{knowDateTxt}} ,过去了 {{knowDateToNow}} 天</h2>
  </div>
</template>

<script>
import Vue from 'vue';
import { Progress } from 'ant-design-vue';
import dayjs from 'dayjs'

Vue.use(Progress);

let lastSpringFestival = new Date(2020, 0, 25).getTime();
let nextSpringFestival = new Date(2021, 1, 12).getTime();
let knowDate = new Date(2020,0,23);
let dateTime = 24*60*60*1000;

export default {
  name: "App",
  data() {
    return {
      percent : 0,
      percentNum : 0,
      knowDateToNow : Math.trunc((Date.now()-knowDate.getTime()) / dateTime),
      knowDateTxt : dayjs(knowDate).format("YYYY-MM-DD")
    };
  },
  methods:{
    pushPercent(){
      let percent = ((Date.now() - lastSpringFestival) / (nextSpringFestival - lastSpringFestival));
      this.percent =  (percent * 100).toFixed(6);
      this.percentNum = Number(this.percent)
    }
  },
  mounted(){
    setInterval(this.pushPercent,100);
  }
};
</script>

<style>
  .center-text{
    text-align:center;
  }
</style>
