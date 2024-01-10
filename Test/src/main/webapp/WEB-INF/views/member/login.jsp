<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="signInForm">
		<form action="signIn.do" method="post">
			<h3>LogIn</h3>
			<table class="table">
				<tr>
					<th>ID</th>
					<td><input type="text" name="id" required></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="pass" required></td>
				</tr>
				<tr>
					<td colspan="2"><button type="submit">로그인</button></td>
				</tr>
			</table>
			<a id="naverIdLogin_loginButton" href="#" role="button">
			<img src="https://mall.hanssem.com/resources/images/common/easy-log-1.png" width=50 height=50></a>
			<a href="javascript:kakaoLogin()"> <img src="https://mall.hanssem.com/resources/images/common/easy-log-4.png"
			width=50 height=50 alt="카카오 로그인 버튼" /></a>
			<br>
		<a href="signUpCheck.do">회원가입</a> 
		<a href="searchId.do">ID 찾기</a> 
		<a href="searchPw.do">PW 찾기</a>
		</form>

	</div>

	<!-- 네이버 스크립트 -->
	<script src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.2.js" charset="utf-8"></script>

	<script>
		var naverLogin = new naver.LoginWithNaverId({
			clientId : "NoqCJJA8y8apy_2fhbFi", //내 애플리케이션 정보에 cliendId를 입력해줍니다.
			callbackUrl : "http://localhost:8081/MiddleProject/naverLogin.do", // 내 애플리케이션 API설정의 Callback URL 을 입력해줍니다.
			isPopup : false,
			callbackHandle : true
		});
		naverLogin.init();

		var testPopUp;
		function openPopUp() {
			testPopUp = window.open("https://nid.naver.com/nidlogin.logout", "_blank","toolbar=yes,scrollbars=yes,resizable=yes,width=1000,height=1000");
		}
		function closePopUp() {
			testPopUp.close();
		}

		function naverLogout() {
			openPopUp();
			closePopUp();
		}
	</script>


	<!-- 카카오톡 스크립트 -->
	<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
	<script>
		Kakao.init('3417f296b9ba3b697980f5786262df50'); //발급받은 키 중 javascript키를 사용해준다.
		console.log(Kakao.isInitialized()); // sdk초기화여부판단

		//카카오로그인	
		function kakaoLogin() {
			Kakao.Auth.login({
				success : function(response) {
					Kakao.API.request({
						url : '/v2/user/me',
						success : function(response) {
						console.log(response);
						console.log(response.kakao_account.profile.nickname);
						location.href = "otherLogin.do?name="
										+ response.kakao_account.profile.nickname
										+ "&id="
										+ response.id
										+ "&email="
										+ response.kakao_account.email
										+ "&gender="
										+ response.kakao_account.gender;
						},
						fail : function(error) {
							console.log(error)
						},
					})
				},
				fail : function(error) {
					console.log(error)
				},
			})
		}
		
		//카카오로그아웃  
		function kakaoLogout() {
			if (Kakao.Auth.getAccessToken()) {
				Kakao.API.request({
					url : '/v1/user/unlink',
					success : function(response) {
						console.log(response);
			Kakao.Auth.logout(
					function(obj) {
					if(obj==true){}else{}
					 location.href='main.do';
					 }
			);
						deleteCookie();
					},
					fail : function(error) {
						console.log(error)
					},
				})
				Kakao.Auth.setAccessToken(undefined);
			} 
		}
		function deleteCookie() {
		    document.cookie = 'authorize-access-token=; Path=/; Expires=Thu, 01 Jan 1970 00:00:01 GMT;';
		  }
	</script>
</body>
</html>