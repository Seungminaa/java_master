<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Insert title here</title>
    </head>

    <body>
        <div id="show">
            <table class="table">
                <thead>
                    <tr>
                        <th>센터id</th>
                        <th>센터명</th>
                        <th>연락처</th>
                        <th>시도</th>
                    </tr>
                </thead>
                <tbody id="list"></tbody>
            </table>
        </div>
        <script>
            const url = 'https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&serviceKey=nDVR%2Bem9C1f3sP6MKdklq7d8rymZF07je2Jl4eDdLW74Cy2S6ejM8ffHYnUgb0kMqEzDe7SLgohWQdlMmQgxKg%3D%3D';
            const fields =['id','centerName','phoneNumber','sido'] // 화면에 보여줄 항목 설정
            const tbody = document.getElementById('list');
            const xhtp = new XMLHttpRequest();
            xhtp.open('get', url);
            xhtp.send();
            xhtp.onload = function () {
                console.log(JSON.parse(xhtp.responseText));
                let result = JSON.parse(xhtp.responseText);
                result.data.forEach(datas => {
                    let tr = document.createElement('tr');
                    tr.addEventListener('click',function(){
                    	//location.href = 'map.do?x='+datas.lat + '&y='+datas.lng;
                    	window.open("map.do?x=" + datas.lat + "&y=" + datas.lng + "&org=" + encodeURI(datas.org));
                    })
                    fields.forEach(field => {
                        let td = document.createElement('td');
                        td.innerText = datas[field];
                        tr.appendChild(td);
                    })
                    tbody.appendChild(tr);
                })
            }
        </script>
    </body>

    </html>