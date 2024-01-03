// string2.js

const keyword = '홍';
const wordAry = ['사과','홍씨','홍장군','김시홍','감자']
// 1.배열에서 '홍'이 들어간 단어의 갯수를 구하기
console.log(wordAry.filter(val => val.indexOf(keyword) != -1).length);

let a =0;
wordAry.forEach((word) => {
    if(word.includes(keyword)){
        a++;
    };
});
console.log(a);

const url = 'http://localhost/BoardWeb/index.jsp?x=12?y=23';
// 2.url에서 파라미터(x,y)의 값을 찾기
console.log(url.match(/\d+/g)[0],url.match(/\d+/g)[1]);

console.log(url.substr(url.indexOf('=')+1,2),url.substr(url.lastIndexOf('=')+1,2));

const word = '안녕하세요xx만나서xx반갑습x니x다.';
// 3."안녕하세요 만나서 반갑습니다." 문장으로 변환하기
console.log(word.replace(/xx/g,' ').replace(/x/g,''));

const b = word.split(/x/g).filter((val) => val.length>0)[0].concat(' ', word.split(/x/g).filter((val) => val.length>0)[1], ' ',word.split(/x/g).filter((val) => val.length>0)[2],word.split(/x/g).filter((val) => val.length>0)[3],word.split(/x/g).filter((val) => val.length>0)[4]);
console.log(b)

console.log(word.split(/x/g).join('').replace(/(.{5})/,"$1 ").replace(/(.{9})/,"$1 "));