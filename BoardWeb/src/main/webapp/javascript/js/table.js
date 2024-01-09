let d = document.createElement('table');
d.setAttribute('border',1); //속성,값
d.setAttribute('id','list');
d.appendChild(makeHead());
d.appendChild(makeBody());
//실행부분
document.querySelector('body').appendChild(d);

    //thead 부분
    function makeHead() {
            
        let d1 = document.createElement('thead');
        let d2 = document.createElement('tr');
        
        d1.appendChild(d2);
        
        for(let k1 in obj1){ // in 객체내 값 / of 배열내 값
            let k2 = document.createElement('th');
            k2.innerHTML = k1.toUpperCase();
            d2.append(k2);
        }
        //삭제
            let k2 = document.createElement('th');
            k2.innerHTML = '삭제';
            d2.append(k2);

        //선택삭제
            let k3 = document.createElement('th');
            k3.innerHTML = '선택삭제';
            d2.append(k3);
        
        return d1;
    }
    //tbody 부분
    function makeBody() {
        let a = document.createElement('tbody');
        let c2 = Object.values(obj1); //객체 value 분리후 배열로 만듦
        
        for(let friend of friends){
            a.appendChild(makeTr(friend));
        }
        return a;
    }
    // for(let f in obj1){
        //     let k2 = document.createElement('td');
        //         k2.innerHTML = obj1[f]; 속성의 value값 가져오기
        //         a.appendChild(b).appendChild(k2);
        // }
    
        //추가 버튼
        document.getElementById('addBtn').addEventListener('click',function () {
            let id = document.getElementById('uid').value;
            let name = document.getElementById('uname').value;
            let phone = document.getElementById('uphone').value;
            //null값이 아닌 false로 나옴
            if(!id || !name || !phone){
                alert('값을 입력!');
                return ;
            }
            
            let obj = {id, name, phone};
            document.querySelector('#list>tbody').appendChild(makeTr(obj));
            
            document.getElementById('uid').value = '';
            document.getElementById('uname').value = '';
            document.getElementById('uphone').value = '';
            document.getElementById('uid').focus();
        });
        //변경 버튼 클릭 이벤트 등록
        document.getElementById('editBtn').addEventListener('click',function(){
            //찾을값:
            let findId = document.getElementById('uid').value;
            let name = document.getElementById('uname').value;
            let phone = document.getElementById('uphone').value;

            //찾을 대상:
            let target = document.querySelectorAll('#list>tbody>tr');
            
            target.forEach(function(item, idx ,ary){
                // console.log(item,idx,ary);
                let tr = item;
                if(tr.children[0].innerText == findId){
                    tr.children[1].innerText = name;
                    tr.children[2].innerText = phone;
                }
            })

        });


    function makeTr(friend){
        let b = document.createElement('tr');
        b.addEventListener('click',function(){
            document.getElementById('uid').setAttribute('value',this.children[0].innerText);
            document.getElementById('uname').setAttribute('value',this.children[1].innerText);
            document.getElementById('uphone').setAttribute('value',this.children[2].innerText);
            console.log(this.children[0].innerText);
        })
            for(let k1 in friend){ // in 객체내 값 / of 배열내 값
                let k2 = document.createElement('td');
                k2.innerHTML = friend[k1];
                b.appendChild(k2);
            }
            let td = document.createElement('td');
            let btn = document.createElement('button');
            // button 이벤트 등록
            btn.addEventListener('click',function (e) { //이벤트 핸들러
                console.log(this.parentElement.parentElement.remove());
                e.stopPropagation();
            });
            btn.innerText='삭제';
            td.appendChild(btn);
            b.appendChild(td);

            //선택삭제(체크박스)
            let td1 = document.createElement('td');
            let btn1 = document.createElement('input');
            btn1.setAttribute('type','checkbox');
            td1.setAttribute('align','center');
            // button 이벤트 등록
            td1.addEventListener('click',function (e) { //이벤트 핸들러
            	//e.evetPropagation();
                e.stopPropagation(); // 상위요소로 이벤트 전파 차단
            });
            btn1.innerText='선택삭제';
            td1.appendChild(btn1);
            b.appendChild(td1);

            return b;
    }

    //선택삭제 이벤트 시작
    document.querySelector('#delBtn').addEventListener('click',function(){
        document.querySelectorAll('#list>tbody>tr>td>input:checked').forEach(function(item){
            item.parentElement.parentElement.remove();
            // console.log(item);
        });


    })






    