// array4.js
// map,filter, find, indexOf, some, every

const str = '펭수, 라이언, 어피치, 콘, 브라운, 무지, 라이언, 어피치, 콘';
const strAry = []

str.split(', ').map((val,idx) => {
    let news = {}
    news.no = idx +1;
    news.name = val;
    return strAry.push(news);
})

// 문자 자르기
console.log(str.split(/,\s/g)) 
console.log(str.split(', '))

// 1. 콘이라는 이름이 몇번?
console.log(str.split(', ').reduce((acc,val) => {
    return val=='콘' ? acc+1 : acc; 
},0))

console.log(strAry.filter((val)=> {
    return val.name =='콘';
}).length);

// 2. 이름이 3자 이상이 몇명?
console.log(str.split(', ').reduce((acc,val) =>{
    return val.length >= 3 ? acc+1 : acc;
},0))

console.log(strAry.filter((val)=> {
    return val.name.length >=3;
}).length);

// 3. 2자인 이름이 있는지 여부?
console.log(str.split(', ').reduce((acc,val) => {
    return val.length ==2 ? acc=true : acc;
}, false))

console.log(strAry.filter((val)=> {
    return val.name.length ==2;
}).length > 0 ? true : false)

console.log(strAry.every((val)=>val.name.length!=2)) //false 가 2가 존재한다는 의미
console.log(strAry.some((val)=>val.name.length==2)) //true 가 2가 존재한다는 의미


// 4.{no: 1, name: '펭수'} 형태의 값을 가지는 배열을 생성. 결과값을 strAry에 대입

str.split(', ').map((val,idx) => {
    let news = {}
    news.no = idx +1;
    news.name = val;
    return strAry.push(news);
})
console.log(strAry)


