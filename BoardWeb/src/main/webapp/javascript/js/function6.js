// function6.js

const args = [4,5,6];

function sum(num1=0,num2=0, ...args){
    let result = 0;
    result = num1 + num2;
    if(args.length >0){
        args.forEach(val => {
            result += val;
        })
    }
    return result;
}
//... (나머지 파라미터): 배열에 맞게 펼침
console.log(sum(10,20, ...args));

const ary1 = [10,20];

const ary2 = ary1.concat(args);
console.log(ary2);

const ary3 = [...ary1, ...args];
console.log(ary3);

const obj1 = {name:"hong",age:20}
const obj2 = {name:"hang",height:170}

// ...으로 펼쳐서 중복된 속성은 변경되고 다른 속성은 추가가 됨
const obj3 = {...obj1,...obj2}
console.log(obj3);

//reduce
//acc: 이전 순번의 값을 저장
let result = [4,5,6].reduce((acc,curItem,idx,ary) => {
    console.log(acc,curItem,idx);
    return acc + curItem; //누적값합
},0);

console.log(result);

// map 메소드(forEach와 다르게 반환값이 존재)
result = [1,2,3,4].map((item,idx,ary) => {
    console.log(item,idx,ary);
    return item * 2;
});
console.log('결과값 : ',result);

//변수의 스코프(let : 블럭단위,var : 함수단위)
var name = '어피치'; //전역변수

function run(){
    if(true){
        let name = '라이언';
    }
    console.log(name);
    return name;
}
run();
console.log(name);

//스코프 체인
var a = 1;
var b = 5;
function outerFunc(){
    var b; //undefined(변수 호이스팅)
    //outerFunc 안에서만 메소드 사용가능
    function innerFunc(){
        a=b;
    }
    console.log(a); //1
    a=3;
    b=4;
    innerFunc(); //4
    console.log(a);
    var b = 2; //b의 변수호이스팅 생성
}
outerFunc();

const c = 10;

try {
    c=20;
} catch (e) {
    console.log(e.message);
}finally{
    console.log(c);
}

