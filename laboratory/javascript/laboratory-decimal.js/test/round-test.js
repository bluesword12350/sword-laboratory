const Decimal = require('decimal.js');

let roundResult = new Decimal(12.67432).toDecimalPlaces(2)
console.log('roundResult',roundResult)