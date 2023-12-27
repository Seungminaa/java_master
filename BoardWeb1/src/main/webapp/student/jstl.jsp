<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>student/jstl.jsp</title>
</head>
<body>
	<!-- 자바코드 대체하기 -->
	<c:set var="name" value="홍길동" />
	<c:out value="${name }" />
	<c:set var="age" value="19" />

	<!-- true false 반환 -->
	<c:if test="${age >= 20 }">
		<p>성인입니다</p>
	</c:if>
	<c:choose>
		<c:when test="${age >= 20 }">
			<p>성인입니다</p>
		</c:when>
		<c:otherwise>
			<p>미성년입니다</p>
		</c:otherwise>
	</c:choose>
	
	<!-- 값을 포함하는 for문 -->
	<c:forEach begin="1" end="10" step="1" var="i">
		<p>3 * ${i } = ${3*i }</p>
	</c:forEach>
	
	<!-- 확장 for문(items) -->
	<c:set value="Hong,Hwang,Kim" var="names"/>
	<c:forEach items="${names }" var="n">
		<p>${n }</p>
	</c:forEach>

</body>
</html>