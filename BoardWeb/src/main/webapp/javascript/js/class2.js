//class2.js
let year = 2023;
let month = 5;
const days = ['Sun', 'Mon', 'Tue', 'Wed', 'Thr', 'Fri', 'Sat']

// let today = new Date(year,month,0); // {} new Object() month-1월의 마지막날
// today = new Date(year,month-1,1); // month-1월의 첫째날
// console.log(today.getFullYear());
// console.log(today.getMonth()); //1월 = 0
// console.log(today.getDate()); //날짜
// console.log(today.getDay()); //요일 일요일 = 0


class Calendar{
    constructor(year,month,days){
        this.year = year;
        this.month = month;
        this.days = days;
    }
    makeCalendar(){
        console.log("달력생성");
        this.makeTitle(document.getElementById('theader'));
        this.makeBody(document.getElementById('tbody'));
    }

    makeTitle(pos={}) {
        let tr = document.createElement('tr');
        this.days.forEach(function (field) {
            let th = document.createElement('th');
            th.innerText = field;
            tr.appendChild(th);
        })
        pos.appendChild(tr);
    }
    makeBody (pos={}) {
        let tr = document.createElement('tr');
        //공백
        let firstDay = this.getFirstDay(this.year,this.month);
        for (let i = 0; i < firstDay; i++) {
            let td = document.createElement('td');
            td.innerText = "";
            tr.appendChild(td);
        }
        //날짜
        let lastDate = this.getLastDate(this.year,this.month);
        for (let i = 1; i <= lastDate; i++) {
            let td = document.createElement('td');
            td.innerText = i;
            tr.appendChild(td);
            
            //토욜 : pink, 일욜 :aqua
            if ((firstDay + i) % 7 == 1) {
                td.setAttribute('style', 'background-color:aqua');
            }else if ((firstDay + i) % 7 == 0) {
                td.setAttribute('style', 'background-color:pink');
            }
            if ((firstDay + i) % 7 == 0) {
                pos.appendChild(tr);
                tr = document.createElement('tr');
            }
        }
        pos.appendChild(tr);
    }
    getFirstDay(year,month) {
        //월입력 => 1일의 위치(공백이 몇개 반환)
        return new Date(year, month-1, 1).getDay();
    }
    getLastDate(year,month) {
        //월 입력 => 마지막날을 반환
        return new Date(year, month, 0).getDate();
    }
}
const cal = new Calendar(year,month,days);
cal.makeCalendar();