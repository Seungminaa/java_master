// function4.js

// 달력을 생성하는 객체
const cal = {
    days: ['Sun', 'Mon', 'Tue', 'Wed', 'Thr', 'Fri', 'Sat']
    , makeCalendar: function (month) {
        this.makeTitle(this.days, document.getElementById('theader'));
        this.makeBody(month, document.getElementById('tbody'));
    }, makeTitle: function (fields, pos) {
        let tr = document.createElement('tr');
        fields.forEach(function (field) {
            let th = document.createElement('th');
            th.innerText = field;
            tr.appendChild(th);
        })
        pos.appendChild(tr);
    }, makeBody: function (month, pos) {
        let tr = document.createElement('tr');
        //공백
        let firstDay = this.getFirstDay(month);
        for (let i = 0; i < firstDay; i++) {
            let td = document.createElement('td');
            td.innerText = "";
            tr.appendChild(td);
        }
        //날짜
        let lastDate = this.getLastDate(month);
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
    }, getFirstDay(month) {
        //월입력 => 1일의 위치(공백이 몇개 반환)
        return new Date(2024, month-1, 1).getDay();
    }, getLastDate(month) {
        //월 입력 => 마지막날을 반환
        return new Date(2024, month, 0).getDate();
    }
}
cal.makeCalendar(12);