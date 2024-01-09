<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>webapp/javascript/promise.jsp</title>
</head>
<body>
	<div id="show"></div>


	<script> //resolve : 성공했을때 함수, reject:실패했을때 함수 / Promise : 매개변수 2개 받음
		// setInterval 은 여러번 지연시킴
		let show = document.getElementById('show'); // id값으로 요소를 선택
		let cnt = 0;
		let interval = setInterval(() => {
			const today = new Date();
			let hh = today.getHours();
			let mm = today.getMinutes();
			let ss = today.getSeconds();
			cnt++;
			
			if(cnt >= 20){
				// Interval 종료
				clearInterval(interval);
			}
			show.innerHTML = hh + "시" + mm + "분" + ss + "초 <br>";
		},1000);
		
		/////////////////////////////////////////////////////////
		const promise = new Promise(function (resolve, reject) {
			setTimeout(function () {
				reject('Fail');
			}, 3000); //3초후에 실행
			//setTimeout 은 1번만 지연시킴
		}); //pending(초기화) -> fullfilled(정상처리) -> rejected(비정장처리);
		
		promise.then(function(result) {
			console.log('then=> ',result);
			return 'ok';
		})
		.then(function(result){
			console.log('second then=> ',result);
		})
		.catch(function(err) {
			console.error('error=> ',err);
		});
	</script>
</body>
</html>