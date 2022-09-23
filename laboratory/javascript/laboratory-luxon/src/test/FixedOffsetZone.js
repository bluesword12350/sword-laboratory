let { DateTime,FixedOffsetZone } = require('luxon');

let date = DateTime.fromMillis(Date.now())
date = date.setZone(FixedOffsetZone.parseSpecifier("UTC+06:00"))
console.log(date.toISO())
