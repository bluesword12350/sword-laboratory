import { knowDate } from "../../utils/standard/LiHongJun"
import { calendar } from "../../utils/calendar"
const dayjs = require('dayjs')

let dateFormat = "YYYY-MM-DD";
let dateTime = 24*60*60*1000;

let now = new Date();
let nowCalendar = calendar.solar2lunar(now.getFullYear(),now.getMonth()+1,now.getDate())
let lastSpringFestivalCalendar = calendar.lunar2solar(nowCalendar.lunarYear,1,1)
let nextSpringFestivalCalendar = calendar.lunar2solar(nowCalendar.lunarYear+1,1,1)
let lastSpringFestivalTime = lastSpringFestivalCalendar.date.getTime();
let nextSpringFestivalTime = nextSpringFestivalCalendar.date.getTime();
let nextMidAutumnFestivalCalendar = calendar.lunar2solar(nowCalendar.lunarYear,8,15);
if (nextMidAutumnFestivalCalendar.date.getTime()<now.getTime()){
    nextMidAutumnFestivalCalendar = calendar.lunar2solar(nowCalendar.lunarYear+1,8,15);
}
let matrimonyDate = new Date(2021,1,17);
let nowToMatrimony = Math.trunc((matrimonyDate.getTime()-Date.now()) / dateTime)
let nowToMatrimonyStr;
if (nowToMatrimony>0){
    nowToMatrimonyStr = `还有${nowToMatrimony}天`
} else {
    nowToMatrimonyStr = `过去了${-nowToMatrimony}天`
}

Page({
    data:{
        knowDateTxt:dayjs(knowDate).format(dateFormat),
        knowDateToNow:Math.trunc((Date.now()-knowDate.getTime()) / dateTime),
        percent:0,
        springFestival:dayjs(nextSpringFestivalCalendar.date).format(dateFormat),
        midAutumnFestival:dayjs(nextMidAutumnFestivalCalendar.date).format(dateFormat),
        nowToMidAutumn:Math.trunc((nextMidAutumnFestivalCalendar.date.getTime()-Date.now()) / dateTime),
        matrimony:dayjs(matrimonyDate).format(dateFormat),
        nowToMatrimonyStr:nowToMatrimonyStr
    },
    onLoad: function () {
        setInterval(this.pushPercent,100);
    },
    pushPercent(){
        let percent = ((Date.now() - lastSpringFestivalTime) / (nextSpringFestivalTime - lastSpringFestivalTime));
        this.setData({
            percent: (percent * 100).toFixed(6),
            percentNum : Number(this.percent)
        })
    }
})