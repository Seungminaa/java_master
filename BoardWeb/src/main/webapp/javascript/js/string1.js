// string1.js

let str1 = "Hello";
console.log(str1,typeof str1);
let str2 = new String("Hello");
console.log(str2,typeof str2);

console.log(str1===str2);

console.log(str2.substring(1,3));

let word = "   Hello, World   ";
console.log(word.trim());

console.log(word.trimStart());
console.log(word.trimEnd());

console.log(word.replace('H','h'));
// const obj = new Object(); {}
// const reg = new RegExp(); /값/
// g (글로벌) : / 사이의 문자를 전체구문에서 바꿈
// i (대소문자구분) : / 사이의 문자를 대소문자 구분안함
console.log(word.replace(/l/g,'L'));
// \s는 공백을 의미
console.log(word.replace(/\s/g,''));

word = '  how are you   to day everyone.   ';
//filter : 값이 있는 것만 담아준다. 값이 true인 값만 담음
//join : 배열값 사이사이에 join 값을 담아 return 해줌
console.log(word.split(' ').filter(val => val).join(' '));
word = 'how are you   to day everyone.';
console.log(word.slice(6,-5)) // 음수값일때 뒤에서 위치 계산
console.log(word.substring(6,-5)) // 음수값일때 0
console.log(word.substr(1,2)) // (시작 문자위치, 문자 갯수)
console.log(word.toString()) // toString() 값 반환, 개체로 묶여진 배열시 Object 반환
console.log(word.indexOf('you')) // 문자의 시작점 위치
console.log(word.charAt(9)) // 해당 위치에 있는 문자1개 반환
console.log(word.includes('you')) // 해당 문자가 존재하면 true반환 = contain
console.log(word.search('you')) // 해당 문자의 첫글자 위치값 반환, /값/i 사용시 대소문자 구분안함
// toLowerCase(), toUpperCase() 대소문자 바꾸기
console.log(word.match('you')) // 해당 문자의 위치,찾는문자값,전체문자를 배열로 묶어서 반환
console.log(word.matchAll('you')) // 찾는 문자를 match 배열로 묶어서 반환
// concat(?,?) / ?.concat(?) / ?.concat(...배열) => 문자열 합치기




