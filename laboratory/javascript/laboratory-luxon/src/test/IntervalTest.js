const {DateTime, Interval} = require("luxon");
const now = DateTime.now();
let interval = Interval.fromDateTimes(DateTime.local(2022, 9, 28), now)
let intervalDays = interval.length('days')
console.log('intervalDays',intervalDays)
