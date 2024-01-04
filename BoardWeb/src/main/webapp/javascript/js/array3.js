// array3.js

import {
    members,
    titles
} from './data.js';

console.log(members);
console.log(titles);

let str = titles.reduce((acc,title,idx) => {
    if(idx==0){
        acc += `<tr>`;
    }
    acc += `<th>${title}</th>`; 
    if(idx==title.length-1){
        acc += `</tr>`;
    }
    return acc;
}, '');
document.getElementById('theader').innerHTML = str;

const tbody = document.getElementById('tbody');
members.reduce((acc,member)=>{
    let tr = document.createElement('tr');
    for(let prop in member){
        let td = document.createElement('td');
        td.innerText = member[prop];
        tr.appendChild(td);
    }
    acc.appendChild(tr);
    return acc;
}, tbody);

//map(A -> A'), filter(A -> B)
// 기존 데이터를 잘 조합해서 새로운 데이터의 배열로 만듦
let result = members.map((item,idx) => {
    let obj = {}
    obj.id = item.id;
    obj.name = item.first_name + '-' + item.last_name;
    obj.email = item.email;
    return obj;
});

// 데이터는 동일한데 특정조건을 만족하는 경우의 데이터만 추려서 배열로 만듦
result = members.filter(item => item.gender == 'Female').map((item,idx) => { // 메소드 체인
    let obj = {}
    obj.id = item.id;
    obj.name = item.first_name + '-' + item.last_name;
    obj.email = item.email;
    return obj;
}).map(item => item.name);

result.push('charles')
result.push('Hong')
result.push('charles');
console.log(result);
//찾는 단어,해당 인덱스 값부터 찾기시작
console.log(result.indexOf('charles',6));

const str2 = 'abcdefghijk';
const str3 = Array.from(str2,(el,idx) => el + (idx<5?',':'')).join('');
console.log(Array.from(str2).join(','))
console.log(str3)
