const calendar = require("../src/calendar-all")

let s2lt = {
    date: '2020-4-15',
    lunarDate: '2020-3-23',
    festival: null,
    lunarFestival: null,
    lunarYear: 2020,
    lunarMonth: 3,
    lunarDay: 23,
    IMonthCn: '三月',
    IDayCn: '廿三',
    cYear: 2020,
    cMonth: 4,
    cDay: 15,
    gzYear: '庚子',
    gzMonth: '庚辰',
    gzDay: '戊子',
    isLeap: false,
    nWeek: 3,
    ncWeek: '星期三',
    isTerm: false,
    Term: null
}

let s2l = calendar.solar2lunar(2020,4,15);
for (let variable in s2lt){
    if (s2lt[variable] !== s2l[variable]){
        console.error(`值不匹配 ${variable} ${s2lt[variable]} !== ${s2l[variable]}`)
    }
}

let l2st = {
    date: '2020-1-25',
    lunarDate: '2020-1-1',
    festival: null,
    lunarFestival: '春节',
    lunarYear: 2020,
    lunarMonth: 1,
    lunarDay: 1,
    IMonthCn: '正月',
    IDayCn: '初一',
    cYear: 2020,
    cMonth: 1,
    cDay: 25,
    gzYear: '庚子',
    gzMonth: '丁丑',
    gzDay: '丁卯',
    isLeap: false,
    nWeek: 6,
    ncWeek: '星期六',
    isTerm: false,
    Term: null
}

let l2s = calendar.lunar2solar(2020,1,1);
for (let variable in l2st){
    if (l2st[variable] !== l2s[variable]){
        console.error(`值不匹配 ${variable} ${l2st[variable]} !== ${l2s[variable]}`)
    }
}