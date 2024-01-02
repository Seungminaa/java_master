// function5.js

//Array.prototype.forEach();
const ary = ['a','b','c']
//화살표 함수 : 매개값가지고 해당 함수를 간단하게 실행함
// 매개값이 한라인 이상이 되면 중괄호 필요함
ary.forEach((elem) => console.log(elem));
ary.forEach((elem,idx) => {
    if(idx > 0){
        console.log(elem);
    }
});

//프로토 타입 -> 배열내에 함수사용가능
Array.prototype.sum = function(){
    console.log(this);
    let result =0;
    this.forEach(function(val){
        result += val;
    })
    return result;
}
const numbers = [1,2,3,4];
console.log(numbers.sum());