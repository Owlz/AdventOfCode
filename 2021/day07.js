const fs = require('fs');
 
var contents = fs.readFileSync("input07.txt", "utf8")

let input = contents.trim().split(",").map(x => parseInt(x))

let triangularNumber = (x) => (x !== 0) ? x + triangularNumber(x - 1) : 0

let pt1 = input.sort((x, y) => x > y).map((x, index, arr) => Math.abs(arr[arr.length / 2] - x)).reduce((prev, curr) => prev + curr, 0)
let pt2 = input.map((x, i, arr) => Math.abs(Math.round(arr.reduce((a, b) => a + b, -1) / arr.length) - 1 - x)).map(x => triangularNumber(x)).reduce((a, b) => a + b)

console.log("#1: ", pt1)
console.log("#2: ", pt2)