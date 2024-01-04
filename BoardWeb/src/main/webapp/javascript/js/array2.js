// array2.js

const numAry = [23,10,17,35,9];

let result = numAry.reduce((acc,num) => {
    console.log(acc,num);
    return acc + num;
},0);

result = numAry.reduce((acc,num) => {
    console.log(acc,num);
    return acc > num ? acc : num;
},0);

// 1. 최소값
result = numAry.reduce((acc,num) => {
    return acc < num ? acc : num;
});

console.log(`결과 : ${result}`);

// 2. 평균구하기
result = numAry.reduce((acc,num,idx) => {
    return idx == numAry.length-1 ? (acc + num) / numAry.length : (acc + num);
});

// 3. 10보다 큰 값을 새로운 배열
result = numAry.reduce((acc,num) => {
    if(num>10){
        acc.push(num);
    }
    return acc;
},[]);

// 4.

// \<'v'>/  \<'v'>/ \<'v'>/ \<'v'>/ \<'v'>/ \<'v'>/ \<'v'>/ \<'v'>/ \<'v'>/ \<'v'>/
// \<'v'>/  \<'v'>/ \<'v'>/ \<'v'>/ \<'v'>/ \<'v'>/ \<'v'>/ \<'v'>/ \<'v'>/ \<'v'>/
// \<'v'>/  \<'v'>/ \<'v'>/ \<'v'>/ \<'v'>/ \<'v'>/ \<'v'>/ \<'v'>/ \<'v'>/ \<'v'>/
// \<'v'>/  \<'v'>/ \<'v'>/ \<'v'>/ \<'v'>/ \<'v'>/ \<'v'>/ \<'v'>/ \<'v'>/ \<'v'>/
// \<'v'>/  \<'v'>/ \<'v'>/ \<'v'>/ \<'v'>/ \<'v'>/ \<'v'>/ \<'v'>/ \<'v'>/ \<'v'>/
// \<'v'>/  \<'v'>/ \<'v'>/ \<'v'>/ \<'v'>/ \<'v'>/ \<'v'>/ \<'v'>/ \<'v'>/ \<'v'>/
// \<'v'>/  \<'v'>/ \<'v'>/ \<'v'>/ \<'v'>/ \<'v'>/ \<'v'>/ \<'v'>/ \<'v'>/ \<'v'>/

          //                최승민  /<'v'>\
console.log(`\\<'v'>/ : ${result}`);