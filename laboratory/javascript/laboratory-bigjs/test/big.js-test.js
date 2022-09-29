const Big = require('big.js');

let x = new Big(123.4567)
let y = Big('123456.7e-3')
let z = new Big(x)

//eq
console.log(x.eq(y) && x.eq(z) && y.eq(z))
//plus +
//minus -
console.log(x.minus(y).toString())
//times *
//div /
