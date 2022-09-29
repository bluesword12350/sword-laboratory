let Decimal = require('decimal.js-light');

let log10result = new Decimal(27.256714).log(10);
console.log(log10result.toNumber());
