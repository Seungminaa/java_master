<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav
	class="custom-navbar navbar navbar navbar-expand-md navbar-dark bg-dark"
	arial-label="Furni navigation bar">

	<div class="container" style="margin-left:1px; margin-right:0;">
		<a class="navbar-brand" href="main.do"><img src="images/img.png" width=40px height=40px>로고 및 제목<span>.</span></a>
		<c:choose>
		<c:when test="${id!=null }">
		<p style="color:white;">[${name }]님 환영합니다.</p>
		</c:when>
		</c:choose>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarsFurni" aria-controls="navbarsFurni"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarsFurni">
			<ul id="menu" class="custom-navbar-nav navbar-nav ms-auto mb-2 mb-md-0">
				<li class="nav-item"><a class="nav-link" href="main.do">Home</a></li>
				<li class="nav-item"><a class="nav-link" href="#">shop</a></li>
				<c:choose>
					<c:when test="${id == null }">
						<li class="nav-item"><a class="nav-link" href="signIn.do">로그인</a></li>
						<li class="nav-item"><a class="nav-link" href="signUp.do">회원가입</a></li>
					</c:when>
					<c:when test="${id == 'admin' }">
						<li class="nav-item"><a class="nav-link" href="#">회원탈퇴</a></li>
						<li class="nav-item"><a class="nav-link" href="#">회원관리</a></li>
					</c:when>
					<c:otherwise>
						<li class="nav-item"><a class="nav-link" href="#">로그아웃</a></li>
						<li class="nav-item"><a class="nav-link" href="#">MyPage</a></li>
					</c:otherwise>
				</c:choose>
				<li class="nav-item"><a class="nav-link" href="#">목록</a></li>
			</ul>
		</div>
	</div>

</nav>

