//class5.js
// Map, Set
const map = new Map();
map.set('홍길동',20);
map.set('김민수',22);
map.set('최성우',25);
map.set('홍길동',21);

console.log(map.get('김민수'));
console.log(map.keys());

for(let key of map.keys()){
    console.log(`key는 ${key}, value는 ${map.get(key)}`);
}
console.log(map.values());
console.log(map.entries());
map.delete('최성우');
// map.clear();
for(let [item,value] of map.entries()){
    console.log(item,value);
};
//첫번째 매개값이 value , 두번째 매개값이 key
map.forEach((val,key) => console.log(key,val));

//set
const set = new Set();
set.add('홍길동');
set.add('김민수');
set.add('최성우');
set.add('홍길동');

set.delete('김민수');
console.clear();
console.log(set.size);
set.forEach(name => console.log(name));

const numAry = [10,14,12,10]
const num = new Set(numAry); // 배열 -> set

num.forEach(number => console.log(number));
map.clear();

map.set('김명철',80);
map.set('김익수',70);
map.set('이명철',80);
map.set('이익수',85);
map.set('홍길동',80);

//김씨 점수의 합계
let count = 0;
map.forEach((val,key) => {
    if(key.indexOf('김') == 0){
        count += val;
    }
})
console.log(count)

console.log(map.entries())

