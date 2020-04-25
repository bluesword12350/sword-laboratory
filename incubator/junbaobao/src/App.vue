<template>
  <div id="app">
    <h1 class="center-text">与君宝宝结识于 {{knowDateTxt}} ,过去了 {{knowDateToNow}} 天</h1>
    <a-divider />
    <h2 class="center-text">农历年进度: {{percent}}% (春节 {{springFestival}})</h2>
    <a-progress :percent="percentNum" :strokeWidth="20" :showInfo="false" strokeColor="red"/>
    <a-divider />
    <h2 class="center-text">距离中秋节 {{midAutumnFestival}}</h2>
    <a-statistic-countdown class="center-text" :value="deadline" format="D 天 HH 时 mm 分 ss 秒 SSS" />
  </div>
</template>

<script>
import Vue from 'vue';
import { Progress,Statistic,Divider } from 'ant-design-vue';
import dayjs from 'dayjs'
import calendar from "./util/calendar"
import { knowDate } from "./standard/LiHongJun"

Vue.use(Progress);
Vue.use(Statistic);
Vue.use(Divider);

let dateFormat = "YYYY-MM-DD";
let now = new Date();
let nowCalendar = calendar.solar2lunar(now.getFullYear(),now.getMonth()+1,now.getDate())
let lastSpringFestivalCalendar = calendar.lunar2solar(nowCalendar.lunarYear,1,1)
let nextSpringFestivalCalendar = calendar.lunar2solar(nowCalendar.lunarYear+1,1,1)
let lastSpringFestivalTime = lastSpringFestivalCalendar.date.getTime();
let nextSpringFestivalTime = nextSpringFestivalCalendar.date.getTime();
let nextMidAutumnFestivalCalendar = calendar.lunar2solar(nowCalendar.lunarYear,8,15);

let dateTime = 24*60*60*1000;

export default {
  name: "App",
  data() {
    return {
      percent : 0,
      percentNum : 0,
      knowDateToNow : Math.trunc((Date.now()-knowDate.getTime()) / dateTime),
      knowDateTxt : dayjs(knowDate).format(dateFormat),
      deadline : nextMidAutumnFestivalCalendar.date.getTime(),
      springFestival : dayjs(nextSpringFestivalCalendar.date).format(dateFormat),
      midAutumnFestival : dayjs(nextMidAutumnFestivalCalendar.date).format(dateFormat)
    };
  },
  methods:{
    pushPercent(){
      let percent = ((Date.now() - lastSpringFestivalTime) / (nextSpringFestivalTime - lastSpringFestivalTime));
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
