<template>
  <div id="app">
    <h1 class="center-text">{{`2020农历年进度:${percent}%`}}</h1>
    <a-progress :percent="percentNum" :strokeWidth="20" :showInfo="false" strokeColor="red"/>
    <h2 class="center-text">与君宝宝结识于 {{knowDateTxt}} ,过去了 {{knowDateToNow}} 天</h2>
    <h3 class="center-text">今天的进度</h3>
    <a-progress :percent="dayPercent" :strokeWidth="10" :showInfo="false" strokeColor="blue"/>
    <h3 class="center-text">小时</h3>
    <a-progress :percent="hourPercent" :strokeWidth="10" :showInfo="false" strokeColor="blue"/>
    <h3 class="center-text">分钟</h3>
    <a-progress :percent="minutePercent" :strokeWidth="10" :showInfo="false" strokeColor="blue"/>
  </div>
</template>

<script>
import Vue from 'vue';
import { Progress } from 'ant-design-vue';
import dayjs from 'dayjs'
import "./javascript/DateEnhance"

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
      dayPercent : 0,
      hourPercent : 0,
      minutePercent : 0,
      knowDateToNow : Math.trunc((Date.now()-knowDate.getTime()) / dateTime),
      knowDateTxt : dayjs(knowDate).format("YYYY-MM-DD")
    };
  },
  methods:{
    pushPercent(){
      let percent = ((Date.now() - lastSpringFestival) / (nextSpringFestival - lastSpringFestival));
      this.percent =  (percent * 100).toFixed(6);
      this.percentNum = Number(this.percent)
    },
    pushDayPercent(){
      this.dayPercent = new Date().getMillisecondsOfDay()/(24*60*60*1000/100);
    },
    pushHoursPercent(){
      this.hourPercent = new Date().getMillisecondsOfHour()/(60*60*1000/100);
    },
    pushMinutePercent(){
      this.minutePercent = new Date().getMillisecondsOfMinute()/(60*1000/100);
    }
  },
  mounted(){
    setInterval(this.pushPercent,100);
    setInterval(this.pushDayPercent,100);
    setInterval(this.pushHoursPercent,100);
    setInterval(this.pushMinutePercent,100);
  }
};
</script>

<style>
  .center-text{
    text-align:center;
  }
</style>
