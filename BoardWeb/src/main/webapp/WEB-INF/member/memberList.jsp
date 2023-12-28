<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- member/memberList.jsp -->
<table class="table">
	<thead>
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>회원이름</th>
			<th>회원권한</th>
		</tr>
	</thead>
	<c:forEach var="vo" items="${memberList }">
		<tr>
			<td>${vo.id }</td>
			<td>${vo.pw }</td>
			<td>${vo.name }</td>
			<td>${vo.responsibility }</td>
		</tr>
	</c:forEach>
	</tbody>
</table>