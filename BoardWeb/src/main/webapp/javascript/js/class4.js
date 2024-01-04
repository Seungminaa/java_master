// class4.js

const friend = {
    name: "홍길동",
    age: 20,
    hobbies: ['독서', '운동', '영화'],
    pets: [{ name: '야옹이', gender: 'M',friends:['검양이','빨양이'] }, { name: '멍멍이', gender: 'F' }],
    showHobby() {
        return `${this.hobbies[0]},${this.hobbies[1]},${this.hobbies[2]}`;
    }
}
console.log(friend.name);
friend['pets'][0].friends[2] = '노랑이';
console.log(friend['pets'][0].friends);
// delete friend.age;

//속성추가(defineProperty)
friend.ages = 20; 
friend.showFriends = function (){
    console.log(this);
};
console.log(friend);
//set 값이 자기자신과 같을시 재귀호출로 이뤄져 애러가남
Object.defineProperty(friend,'height',{
    get:function(){
        return this._height;
    },
    set:function(value){
        if(value<=0){
            alert('error');
        }else{
            this._height = value;
        }
    }
});
friend.height = 162;
console.log(friend.height);


// 참조값 변경시 원래값도 변경됨
const fcofy = friend;
fcofy.age = 22;
console.log(fcofy)

// 객체를 복사(assign {}내부엔 속성 및 값 추가)
const fcofy2 = Object.assign({bloodType:'O'},friend);
fcofy2.age = 24;
console.log(fcofy2)








