//class3.js
// 1. 객체:this는 객체자신
// 2. function() this는 전역객체(window)

function myfunc(){
    console.log(this);
}
myfunc();

let obj = {}
obj.act = function(){
    this.value = 'default value';

    function innerAct(){
        this.value = 'innerAct value';
        console.log(this.value);
    }
    function innerReact(caller){
        caller.value = 'innerReact value';
        console.log(this.value); //innerAct value
        console.log(caller.value);
    }
    innerAct();
    console.log(this.value);
    
    innerReact(this);
    console.log(this.value);
}
obj.act();

// window.location.href = "https://www.naver.com"
//클로저

function outerFunc(name){
    let saying = name + `안녕`;
    return function(){
        return function(){
            return saying;
        }
    }
}
//함수안에 함수를 구현
const closure1 = outerFunc(`라이언`);
const closure2 = outerFunc(`콘`);
console.log(closure1()());
console.log(closure2()());

//변수를 숨겨서 함수 내부에서 컨트롤할 때 사용할때 사용함(클로저)
function increseCounter(){
    let cnt = 1;
    
    return function (){
        cnt++;
        console.log(cnt);
    }
    // increseCounter();
}
const clo1 = increseCounter();
clo1();
clo1();
clo1();
clo1();


//find() : 배열에 그 값이 있을경우 그 값을 반환(첫번째 요소만 반환)
class Estimate{
    constructor(param){
        this.unit = param;
    }
    getEstimate(unittype,width,height){
        let priceinfo = this.unit.find(item=>item.type == unittype);
        return priceinfo.price * width * height;
    }
    addUnit(unit){
        unit.push(unit);
    }
}
let unitinfo = [{type:"wood",price:100},{type:"iron",price:300},{type:"plastic",price:200}];
const estimator = new Estimate(unitinfo);
let result = estimator.getEstimate('wood',20,20);
console.log(result);

