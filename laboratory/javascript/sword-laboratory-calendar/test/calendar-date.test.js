const calendar = require("../src/calendar-date")

let s2lt = {
    lunarYear: 2020,
    lunarMonth: 3,
    lunarDay: 23,
    cYear: 2020,
    cMonth: 4,
    cDay: 15,
    isLeap: false
}

let s2l = calendar.solar2lunar(2020,4,15);
for (let variable in s2lt){
    if (s2lt[variable] !== s2l[variable]){
        console.error(`值不匹配 ${variable} ${s2lt[variable]} !== ${s2l[variable]}`)
    }
}

let l2st = {
    lunarYear: 2020,
    lunarMonth: 1,
    lunarDay: 1,
    cYear: 2020,
    cMonth: 1,
    cDay: 25,
    isLeap: false
}

let l2s = calendar.lunar2solar(2020,1,1);
for (let variable in l2st){
    if (l2st[variable] !== l2s[variable]){
        console.error(`值不匹配 ${variable} ${l2st[variable]} !== ${l2s[variable]}`)
    }
}