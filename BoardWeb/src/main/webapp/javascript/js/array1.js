// array1.js
// ary = []
const ary = [1,2,'3',new Date()];

const numAry = [10,20,30,40]
numAry.push(30); //맨 뒤에 추가
numAry.unshift(40); //맨 앞에 추가
numAry.pop(); //마지막 값 삭제
numAry.shift(); //첫번째 요소 삭제
// numAry.splice(1,1,50,60); // n번째 위치,지울 갯수,대체할 숫자들

numAry.length = 10; //배열의 크기 조절이 마음대로 가능

const numAry2 = [50,60];
const numAry3 = numAry.concat(numAry2);
console.log(numAry.concat(numAry2))
console.log(numAry3);
numAry2.forEach(n => {
    numAry.push(n);
})
console.log(numAry);