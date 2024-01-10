<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.table{
	background: yellow;
	border: 1px solid black;
	border-style: none;
	}
	th,td{
	border: 1px solid black;
	padding: 5px;
	}
</style>
</head>
<body>
	<h3>책목록</h3>
	<table class="table">
        <thead>
            <tr>
                <th><input type="checkbox" name="chk" id="chk"></th>
                <th>도서코드</th>
                <th>도서명</th>
                <th>저자</th>
                <th>출판사</th>
                <th>가격</th>
                <th>삭제</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="vo" items="${bookList }">
            <tr>
                <td><input type="checkbox" name="chkd" id="chkd"></td>
                <td>${vo.bookCode }</td>
                <td>${vo.bookName }</td>
                <td>${vo.bookAuthor }</td>
                <td>${vo.bookPress }</td>
                <td>${vo.bookPrice }원</td>
                <td><button>삭제</button></td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
	
</body>
</html>