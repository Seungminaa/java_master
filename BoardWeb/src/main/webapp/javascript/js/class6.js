// class6.js

function sum(num1,num2){
    return num1 + num2;
}

function getMax(num1,num2){
    return num1 > num2 ? num1 : num2;
}

const friend = {
    name : "hong",
    age : 20,
    showInfo(){
        return `이름은 ${this.name}, 나이는 ${this.age} 입니다`;
    }
}
//특별한 대상만 반환하겠음
// html의 script type을 module로 설정필요
export {friend,sum,getMax};
