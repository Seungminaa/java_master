/**
 * service.js 
 */
function makeLi(reply ={}){
		let li = document.createElement('li');
			for(let i in reply){
				if(i == 'name'){
					let span = document.createElement('span');
					span.innerText = " 이름 : "+ reply[i];
					li.appendChild(span);
				} else if(i != 'boardNo'){
					let span = document.createElement('span');
					span.innerText = i +" : "+ reply[i];
					li.appendChild(span);
				}
			}
			console.log(pageInfo);
			
			//삭제버튼
			let btn = document.createElement('button');
			btn.addEventListener('click',function(){
				// 댓글번호 삭제 후 화면에서 제거
				let delHtp = new XMLHttpRequest();
				delHtp.open('get','delReplyJson.do?rno=' + reply.replyNo);
				delHtp.send();
				delHtp.onload = function(){
					let result = JSON.parse(delHtp.responseText);
					if(result.retCode == 'OK'){
						alert('삭제됨');
						//btn.parentElement.remove();
						// bno, page => 페이지리스트, 페이징리스트
						showList(pageInfo);
						
					}else if(result.retCode == 'NG'){
						alert('삭제중 애러');
					}
				}

			})
			btn.innerText = '삭제';
			li.appendChild(btn);
			return li;
			}