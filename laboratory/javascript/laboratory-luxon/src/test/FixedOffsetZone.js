let { DateTime,FixedOffsetZone } = require('luxon');
let date = DateTime.fromMillis(0)
date = date.setZone(FixedOffsetZone.parseSpecifier("UTC+6"))
console.log(date.toISO())
