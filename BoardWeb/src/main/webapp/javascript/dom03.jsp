<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>272p~273p</title>
</head>
<body>
<!-- 캡처링 상위에서 하위요소로 내려가는 방식/버블링 하위요소에서 상위요소로 올라가는 방식/ ex) 이벤트를 하위요소로 전달 -->
    <p>실습</p>
    <ul id="friends">
        <li class="animal">라이언</li>
        <li class="fruit">어파치</li>
        <li class="animal">프로도</li>
        <li class="alien">콘
        	<ul class="keyword">
            	<li>3세</li>
            	<li>숏다리</li>
            	<li>초록괴수</li>
        	</ul>
        </li>
    </ul>
    <ul class="icons">
        <li>
            <span>스몰</span>
            <span>미디엄</span>
            <span>빅</span>
        </li>
    </ul>
    <ul id="newfriends">
    </ul>
</body>
    <script>
        
        let li = document.createElement('li');
        let litext = document.createTextNode('무지');
        li.appendChild(litext);

        let targettul = document.getElementById('friends');
        targettul.appendChild(li);

        let sourceli = document.querySelector('ul#friends li:first-child');
        let targetli = document.querySelector('ul#friends li:last-child');
        targetli.after(sourceli);

        var appendli = document.createElement('li');
        appendli.append("왕눈이");
        document.querySelector('ul li ul').append(appendli);

        let selected = document.querySelector('.icons li span:last-child');
        let newspan = document.createElement('span');
        let newspantext = document.createTextNode("빅");
        newspan.appendChild(newspantext);
        selected.parentNode.insertBefore(newspan,selected);

        let items = document.querySelectorAll('.animal');
        document.querySelector('#newfriends').prepend(...items);

        let p = document.createElement('p');
        p.setAttribute('id','paragraphid');
        document.querySelector('body').appendChild(p);
        let ptext = document.createTextNode('문단 텍스트 내용');
        p.appendChild(ptext);
        
        let originalp = document.getElementById('paragraphid');
        let oldp = originalp.parentNode.replaceChild(p,originalp);
    </script>
</html>