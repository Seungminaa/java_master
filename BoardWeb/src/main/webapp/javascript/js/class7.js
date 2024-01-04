// class7.js
// from 절에 있는 위치의 export된 객체나 메소드를 사용하겠음
// html의 script type을 module로 설정필요
import { friend,sum,getMax} from "./class6.js";

let n1 = 10,n2 = 20;
console.log(sum(n1,n2));
console.log(getMax(n1,n2));
console.log(friend.showInfo());

let day = new Date(2020,9,20,10,10,10);
Date.prototype.dateFormat = function(){
    console.log(this); //yyyy-MM-dd HH:mm:ss
    let yyyy = this.getFullYear();
    let MM = ('0'+ (this.getMonth()+1)).slice(-2);
    let dd = ('0'+ this.getDate()).slice(-2);
    let HH = ('0'+ this.getHours()).slice(-2);
    let mm = ('0'+ this.getMinutes()).slice(-2);
    let ss = ('0'+ this.getSeconds()).slice(-2);

    return yyyy + '-' + MM + '-' + dd + ' ' + HH + ':' + mm + ':' +ss;
}
console.log(day.dateFormat())
// \<'v'>/