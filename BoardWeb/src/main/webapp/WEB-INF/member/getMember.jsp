<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	    <table class="table">
	        <tbody>
	            <tr>
	                <th>아이디</th>
	                <td colspan='3'>${vo.id}</td>
	            </tr>
	            <tr>
	                <th>비밀번호</th>
	                <td colspan="3">${vo.pw}</td>
	            </tr>
	            <tr>
	                <th>이름</th>
	                <td colspan="3">${vo.name}</td>
	            </tr>
	            <tr>
	                <th>권한</th>
	                <td colspan="3">${vo.responsibility}</td>
	            </tr>
	        </tbody>
	    </table>