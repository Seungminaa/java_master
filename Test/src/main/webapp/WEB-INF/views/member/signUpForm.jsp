<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<div id="signUpForm">
		<form action="signUp.do" method="post">
			<h3>회원가입</h3>
			<table class="table">
				<tr>
					<th>id</th>
				<c:choose>
				<c:when test="${!empty vo }">
					<td colspan="2"><input type="text" id="id" name="id"
						placeholder="4~15자리의 영문과 숫자로 입력" value="${vo.id}" required readonly></td>
				</c:when>
				<c:otherwise>
					<td colspan="2"><input type="text" id="id" name="id"
						placeholder="4~15자리의 영문과 숫자로 입력" required></td>
				</c:otherwise>
				</c:choose>
				</tr>
				<tr>
					<th>비밀번호</th>
				<c:choose>
				<c:when test="${!empty vo }">
					<td colspan="2"><input type="password" id="pass" name="pass"
						placeholder="8자리 이상" value="${vo.pw}" required readonly></td>
				</c:when>
				<c:otherwise>
				<td colspan="2"><input type="password" id="pass" name="pass"
						placeholder="8자리 이상" required></td>
				</c:otherwise>
				</c:choose>
				</tr>
				<tr>
					<th>비밀번호 확인</th>
				<c:choose>
				<c:when test="${!empty vo }">
				<td colspan="2"><input type="password" id="passCheck"
						name="passCheck" value="${vo.pw}" required readonly></td>
				</c:when>
				<c:otherwise>
				<td colspan="2"><input type="password" id="passCheck"
						name="passCheck" required></td>
				</c:otherwise>
				</c:choose>		
				</tr>
				<tr>
					<th>이름</th>
				<c:choose>
				<c:when test="${!empty vo }">
					<td colspan="2"><input type="text" id="name" name="name" value="${vo.name}"
						required readonly></td>
						</c:when>
				<c:otherwise>
				<td colspan="2"><input type="text" id="name" name="name"
						required></td>
				</c:otherwise>
				</c:choose>	
				</tr>
				<tr>
					<th>이메일</th>
					<c:choose>
				<c:when test="${!empty vo }">
					<td colspan="2"><input type="text" id="email" name="email" value="${vo.email}"
						required readonly></td>
						</c:when>
				<c:otherwise>
				<td colspan="2"><input type="text" id="email" name="email"
						required></td>
				</c:otherwise>
				</c:choose>
				</tr>
				<tr>
					<th>주소</th>
					<td colspan="2"><input type="text" id="addr" name="addr"
						required></td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td colspan="2"><input type="text" id="phone" name="phone"
						required></td>
				</tr>
				<tr>
					<th>성별</th>
					<c:choose>
					<c:when test="${!empty vo and vo.gender eq 'male' }">
					<td>
					<input type='radio' name='gender' value='female' />여성 <input type='radio' name='gender' value='male' checked />남성
					</td>
					</c:when>
					<c:when test="${!empty vo and vo.gender eq 'female' }">
					<td>
					<input type='radio' name='gender' value='female' checked />여성 <input type='radio' name='gender' value='male' />남성
					</td>
					</c:when>
				<c:otherwise>
				<td>
				<input type='radio' name='gender' value='female' />여성 <input type='radio' name='gender' value='male' />남성
				</td>
				</c:otherwise>
				</c:choose>
				</tr>
			</table>
			<button type="reset">취소</button>
			<button type="submit">다음</button>
		</form>
	</div>
</body>

<script>
	let pass = document.querySelector('#pass');
	let passCheck = document.querySelector('#passCheck');
	document.querySelector('#id').addEventListener('change', function() {
		if (this.value.length<4||this.value.length>15) {
			alert("4자리 이상 15자리 이하로 입력해주세요.");
			this.select();
		}
	});
	pass.addEventListener('change', function() {
		if (pass.value.length < 8) {
			alert("8자리 이상으로 입력해주세요.");
			pass.value = "";
			pass.focus();
		}
	});
	passCheck.addEventListener('change', function() {
		if (pass.value != passCheck.value) {
			alert("비밀번호가 일치하지 않습니다.");
			passCheck.value = "";
			passCheck.focus();
		}
	});
</script>
</html>