
        //var : 함수레벨, let, const : block 레벨(괄호안에서 선언시 괄호 내에서만 처리됨)
        var name = "Hwang";
        function myfunc()
        {
            var name = 'Hong';
            console.log(name);
            console.log(this);

        }
        myfunc();
        console.log(name);
        
        let age = 20;
        // function myfunc2() 
        {
            let age = 22;
            console.log(age);            
        }
        // myfunc2();
        console.log(age);
        let obj ={
            id:'Hong',
            age:20,
            show:function(){
                console.log(this);
            }
        }
        obj.show();
        document.body.addEventListener('click',function(){
            console.log(this);
        })
        // this 객체의 정의
        // 1. 전역영역 : window 객체
        // 2. 함수 : window 객체
        // 3. 객체 : object(자기자신)
        // 4. 이벤트 : 이벤트 실행 대상
        console.log(this);

        //변수로 선언한 변수명은 함수로 사용못함
        // let show = 'Hello';
        // function show(){
        //     console.log('show');
        // }
        
        // () 실행
        let show = function(){
            console.log('show');
            // return 값이 없으면 undefined로 정의 되있음
            // return undefined;
            return '반환값';
        }
        console.log(show());

        //함수정의 구문을 괄호로 묶으면 실행가능
        //()가 있으면 실행하겠다는 의미
        (function(){
            console.log('익명함수');
        })();

        // 함수명명 규칙, 카멜케이스
        function showMyName(){
            console.log('홍길동');
        }

        // 상수선언
        const height = 167.9;
        // height = 169;

        //타입은 상관없음
        const friend = {
            name:'홍길동',
            phone:'010-1111'
        }

        friend.phone = '010-2222';

        // friend = {}
