<%@page import="com.yedam.board.vo.BoardVO" %>
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
			<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<style>
.pagination {
  display: inline-block;
}

.pagination a {
  color: black;
  float: left;
  padding: 8px 16px;
  text-decoration: none;
}

.pagination a.active {
  background-color: #4CAF50;
  color: white;
  border-radius: 5px;
}

.pagination a:hover:not(.active) {
  background-color: #ddd;
  border-radius: 5px;
}
</style>
				<h3>상세화면</h3>
				<form name="myForm" action="modifyForm.do">
					<input type="hidden" name="bno" value="${vo.boardNo}">
					<table class="table">
						<tbody>
							<tr>
								<th>글번호</th>
								<td colspan='3'>${vo.boardNo}</td>
							</tr>
							<tr>
								<th>제목</th>
								<td colspan="3">${vo.title}</td>
							</tr>
							<tr>
								<th>내용</th>
								<td colspan="3">${vo.content}</td>
							</tr>
							<tr>
								<th>작성자</th>
								<td colspan="3">${vo.writer}</td>
							</tr>
							<tr>
								<th>작성일</th>
								<td>
									<fmt:formatDate value="${vo.writeDate}" pattern="yyyy-MM-dd" />
								</td>
								<td>조회수</td>
								<td>${vo.clickCnt}</td>
							</tr>
							<tr>
								<th>이미지</th>
								<td colspan="3">
									<c:if test="${!empty vo.image }">
										<img width="150px" src="images/${vo.image }">
									</c:if>
								</td>
							</tr>
							<tr>
								<td colspan="4" align="center">
									<c:choose>
										<c:when test="${logName eq vo.writer }">
											<input type="submit" value="수정">
											<input type="button" onclick="deleteFunc()" value="삭제">
										</c:when>
										<c:otherwise>
											<input type="submit" disabled value="수정">
											<input type="button" disabled onclick="deleteFunc()" value="삭제">
										</c:otherwise>
									</c:choose>
								</td>
							</tr>
						</tbody>
					</table>
				</form>
				<br>
				<p>댓글내용: <input type="text" id="content"><button id="addReply">등록</button></p>
				<p>댓글목록</p>
				<div id="show">
					<ul id="list">
					</ul>
				</div>
				<!-- 페이징 처리 -->
				<div id="paging" class="pagination">

				</div>
				<a href="boardList.do">글목록으로</a>
				<script src="js/service.js"></script>
				<script>
					function deleteFunc() {
						console.log(window);
						document.forms.myForm.action = "removeForm.do";
						document.forms.myForm.submit();
					}
					let ul = document.querySelector('#list');
					const bno = '${vo.boardNo}';

					// document.querySelectorAll('#paging a').forEach(item => {
					// 	console.log(item);
					// 	item.addEventListener('click', (e) => {
					// 		e.preventDefault(); // 기능차단

					// 		let pageInfo = item.getAttribute("paging");
					// 		const pageAjax = new XMLHttpRequest();
					// 		pageAjax.open('get', 'replyListJson.do?bno=' + bno + "&page=" + pageInfo);
					// 		pageAjax.send();
					// 		pageAjax.onload = function () {
					// 			let data = JSON.parse(pageAjax.responseText); //json문자열 -> 객체
					// 			ul.innerHTML = '';
					// 			data.forEach(reply => {
					// 				let li = makeLi(reply); //li 부분(service.js)
					// 				ul.appendChild(li);
					// 			})
					// 			console.log(pageAjax.responseText);

					// 		}

					// 	})
					// })


					let pageInfo = 1;
					// 페이지 클릭하면 페이지의 데이터를 보여주도록
					
					function pageList(e) {
						e.preventDefault(); // 기능차단
						pageInfo = this.getAttribute("href");

						const pageAjax = new XMLHttpRequest();
						pageAjax.open('get', 'replyListJson.do?bno=' + bno + "&page=" + pageInfo);
						pageAjax.send();
						pageAjax.onload = function () {
							let data = JSON.parse(pageAjax.responseText); //json문자열 -> 객체
							ul.innerHTML = '';
							data.forEach(reply => {
								let li = makeLi(reply); //li 부분(service.js)
								ul.appendChild(li);
							})
							console.log(pageAjax.responseText);
						}
						//페이지를 생성하는 함수를 호출
						pagingList(pageInfo);
					}//pageList

					//Ajax 호출
					//페이지 5건씩 그려주는 부분(댓글 목록)
					function showList(pageInfo) {
						const xhtp = new XMLHttpRequest();
						xhtp.open('get', 'replyListJson.do?bno=' + bno + "&page=" + pageInfo);
						xhtp.send();
						xhtp.onload = function () {
							let data = JSON.parse(xhtp.responseText); //json문자열 -> 객체
							data.forEach(reply => {
	
								let li = makeLi(reply); //li 부분(service.js)
	
								ul.appendChild(li);
							})
							console.log(xhtp.responseText);
						}
					} //showList
					showInfo(pageInfo);

					//페이지 생성
					let paging = document.querySelector('#paging');
					pagingList();

					function pagingList(page = 1) {
						// 다음 페이지를 기중으로 페이지 목록 생성
						paging.innerHTML = '';

						let pagingAjax = new XMLHttpRequest();
						pagingAjax.open('get', 'pageListJson.do?bno=' + bno + '&page=' + page);
						pagingAjax.send();
						pagingAjax.onload = function () {
							let result = JSON.parse(pagingAjax.responseText);
							console.log(result);
							//이전
							if (result.prev) {
								let aTag = document.createElement('a');
								aTag.href = result.startPage - 1;
								aTag.innerText = '이전';
								aTag.addEventListener('click', pageList);
								paging.appendChild(aTag);
							}
							// 페이지 목록
							for (let p = result.startPage; p <= result.lastPage; p++) {
								let aTag = document.createElement('a');
								if(p == page){
									aTag.setAttribute('class','active');
								}
								aTag.href = p;
								aTag.innerText = p;
								aTag.addEventListener('click', pageList); //이벤트는 함수 뒤에 매개변수 없이 사용가능
								paging.appendChild(aTag);
							}
							//다음
							if (result.next) {
								let aTag = document.createElement('a');
								aTag.href = result.lastPage + 1;
								aTag.innerText = '다음';
								aTag.addEventListener('click', pageList);
								paging.appendChild(aTag);
							}
						}
					}//pagingList





					// 등록버튼 클릭 이벤트 생성
					document.querySelector('#addReply').addEventListener('click', function () {
						let reply = document.querySelector('#content').value;
						let replyer = '${logId}';
						console.log(replyer);

						const addAjax = new XMLHttpRequest();
						addAjax.open('get', 'addReplyJson.do?reply=' + reply + '&replyer=' + replyer + '&bno=' + bno);
						addAjax.send();
						addAjax.onload = function () {
							console.log(addAjax.responseText);
							let result = JSON.parse(addAjax.responseText);
							//if문 시작
							if (result.retCode == 'OK') {
								let reply = result.vo;

								let li = makeLi(reply); // li 부분(service.js)

								ul.appendChild(li);

								document.querySelector('#content').value = '';
							} else if (result.retCode == 'NG') {
								alert('처리중 애러');
							}
						}
					});

				</script>