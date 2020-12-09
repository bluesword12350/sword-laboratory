let dayjs = require('dayjs')
let utc = require('dayjs/plugin/utc') // dependent on utc plugin
let timezone = require('dayjs/plugin/timezone')
dayjs.extend(utc)
dayjs.extend(timezone)

console.log(dayjs(Date.parse("1970-01-01 00:00:00 UTC")).format())
