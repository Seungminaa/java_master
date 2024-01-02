//function2.js
let members = `[{"id":1,"first_name":"Ola","last_name":"Antonellini","email":"oantonellini0@bing.com","gender":"Female","salary":807},
{"id":2,"first_name":"Gavan","last_name":"Scrinage","email":"gscrinage1@kickstarter.com","gender":"Male","salary":9644},
{"id":3,"first_name":"Charla","last_name":"Hartas","email":"chartas2@github.io","gender":"Female","salary":5846},
{"id":4,"first_name":"Lambert","last_name":"Managh","email":"lmanagh3@devhub.com","gender":"Male","salary":9606},
{"id":5,"first_name":"Reina","last_name":"Gollard","email":"rgollard4@un.org","gender":"Female","salary":6179},
{"id":6,"first_name":"Darbee","last_name":"Nise","email":"dnise5@wikimedia.org","gender":"Male","salary":6404},
{"id":7,"first_name":"Franky","last_name":"Aubry","email":"faubry6@sfgate.com","gender":"Female","salary":1144},
{"id":8,"first_name":"Merralee","last_name":"Francom","email":"mfrancom7@gov.uk","gender":"Female","salary":1911},
{"id":9,"first_name":"Wylie","last_name":"Wingeatt","email":"wwingeatt8@google.com","gender":"Male","salary":5686},
{"id":10,"first_name":"Benny","last_name":"Gornal","email":"bgornal9@wordpress.com","gender":"Female","salary":7510},
{"id":11,"first_name":"Kristal","last_name":"Buckhurst","email":"kbuckhursta@symantec.com","gender":"Female","salary":862},
{"id":12,"first_name":"Jeno","last_name":"Barreau","email":"jbarreaub@jigsy.com","gender":"Male","salary":2270},
{"id":13,"first_name":"Nyssa","last_name":"Michal","email":"nmichalc@ask.com","gender":"Female","salary":8032},
{"id":14,"first_name":"Elinore","last_name":"Cowland","email":"ecowlandd@xinhuanet.com","gender":"Female","salary":8812},
{"id":15,"first_name":"Jackie","last_name":"Kamen","email":"jkamene@usgs.gov","gender":"Male","salary":8072}]`;

let memberAry = JSON.parse(members); //문자열 -> 객체변환
console.log(memberAry[14]);

let titles = ['아이디', '이름', , '성씨', '이메일', '성별', '급여'];

//pos는 위치값
function makeHeader(fields = [], pos = {}) {
    let tr = document.createElement('tr');
    fields.forEach(function (field) {
        let th = document.createElement('th');
        th.innerText = field;
        tr.appendChild(th);
    })
    pos.appendChild(tr);

}
makeHeader(titles, document.getElementById('theader'));

function makeBody(data = [], pos = {}) {
        // for (let members of data) {
        //     let tr = document.createElement('tr');
        //     for (let member in members) {
        //         let td = document.createElement('td');
        //         td.innerText = members[member];
        //         tr.appendChild(td);
        //     }
        //     pos.appendChild(tr);
        // }
        data.forEach(function (members) {
            let tr = document.createElement('tr');
            if(members.gender == 'Female'){
                tr.setAttribute('style','background-color:pink');
            }else if(members.gender == 'Male'){
                tr.setAttribute('style','background-color:aqua');
            }
            for (let member in members) {
                    let td = document.createElement('td');
                    td.innerText = members[member];
                    tr.appendChild(td);
                }
                pos.appendChild(tr);
        })
}

makeBody(memberAry, document.getElementById('tbody'));
