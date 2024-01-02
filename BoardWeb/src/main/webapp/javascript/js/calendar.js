// calendar.js

let days = ['Sun','Mon','Tue','Wed','Thr','Fri','Sat'];

// let lastDate = getLastDate(2);
// let firstDate = getFirstDay(2);
// console.log(lastDate,firstDate);

makeCalendar(1);
//달력생성
function makeCalendar(month) {
    makeTitle(days,document.getElementById('theader'));
    makeBody(month,document.getElementById('tbody'));
}


function getLastDate(month) {
    //월 입력 => 마지막날을 반환
    return new Date(2024,month,0).getDate();
}

function getFirstDay(month) {
    //월입력 => 1일의 위치(공백이 몇개 반환)
    return new Date(2024,month,1).getDay();
}

function makeTitle(dayAry = [],pos={}) {
    let tr = document.createElement('tr');
    dayAry.forEach(function (field) {
        let th = document.createElement('th');
        th.innerText = field;
        tr.appendChild(th);
    })
    pos.appendChild(tr);
}

//날짜 생성
function makeBody(month=1,pos={}) {
    let tr = document.createElement('tr');
    //공백
    let firstDay = getFirstDay(month);
    for (let i=0;i<firstDay;i++) {
        let td = document.createElement('td');
        td.innerText = "";
        tr.appendChild(td);
    }
    //날짜
    let lastDate = getLastDate(month);
    for (let i=1;i<=lastDate;i++) {
        //토욜 : pink, 일욜 :aqua
        if((firstDay+i)%7 ==1){
            tr.setAttribute('style','background-color:aqua');
        }
        if((firstDay+i)%7 ==0){
            tr.setAttribute('style','background-color:pink');
        }
        let td = document.createElement('td');
        td.innerText = i;
        tr.appendChild(td);

        if((firstDay+i)%7 ==0){
            pos.appendChild(tr);
            tr = document.createElement('tr');
        }
    }
    pos.appendChild(tr);
}