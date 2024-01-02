//function.js
//초기값 설정
// 받아온 매개변수 전부 저장 arguments

//함수 선언문
function sum(num1 = 0, num2 = 0) {
    let result = 0;
    result = num1+num2;
    // console.log(result);
    console.log(arguments);
    if (arguments.length > 2) {
        for (let arg=2;arg< arguments.length;arg++) {
            result += arguments[arg];
        }
    }
    return result;
}

let result = sum(11, 22, 33);
console.log(result);

//함수 표현식
let sum2 = function(num1 = 0,num2 = 0){
    let result = num1 + num2;
    return result;
}

console.log(sum2(11,33,55));

let obj1 = {
    name:"홍",
    point: 100
}
let obj2 = {
    name:"황",
    point: 80
}

let average =  function(obj1 = {},obj2 = {}){
    let result = 0;
    result = (obj1.point + obj2.point) / 2;
    return result;
}
console.log(average(obj1,obj2));
let ary1 = [10, 20]
let ary2 = [30, 40]

let sum3 = function(ary1 = [],ary2=[]){
    let result = 0;
    ary1.concat(ary2).forEach(function(val){
        result += val;
    })
    return result;
}

console.log("배열의 총합 : "+sum3(ary1,ary2));

let myfunc = function(callback){
    let result = 0;
    let num1 = 10, num2 = 5;
    result = callback(num1,num2);
    return result;
}

let sumfunc = function(n1,n2){
    return n1 + n2;
}
let minusfunc = function(n1,n2){
    return n1 - n2;
}

console.log("함수의 결과 : "+myfunc(minusfunc));