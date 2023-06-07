// 회원 가입 JS

/*
    정규 표현식 (Regular Expression)
    https://regexper.com/
    https://regexr.com/
    https://developer.mozilla.org/ko/docs/Web/JavaScript/Guide/%EC%A0%95%EA%B7%9C%EC%8B%9D


    - 특정한 규칙을 가진 문자열 집합을 포현하는데 사용하는 형식 언어
    - 문자열에 대한 검색, 일치 여부, 치환 등을 수행할 수 있음

    ** JS 정규표현식 객체 생성 방법 **
    1. const regEx = new RegExp(”정규표현식”);
    2. const regEx = /정규표현식/;

    ** 정규표현식 객체가 제공하는 메서드(함수) **
    1. regEx.test(문자열) : 문자열이 정규표현식 패턴에 부합하면 true / 아니면 false 반환
    2. regEx.exec(문자열) : 문자열이 정규표현식 패턴에 부합하면 첫 번째 매칭되는 문자열을 반환
                            없으면 null 반환


    *** 정규 표현식의 메타 문자***
        
    문자열의 패턴을 나타내는 문자.
    문자마다 지정된 특별한 뜻이 담겨있다.

    
    a (일반문자열) : 문자열 내에 a라는 문자열이 존재하는 검색 
    [abcd] : 문자열 내에 a,b,c,d 중 하나라도 일치하는 문자가 있는지 검색
    ^(캐럿) : 문자열의 시작을 의미
    $(달러) : 문자열의 끝을 의미

    \w (word, 단어) : 아무 글자(단, 띄어쓰기, 특수문자, 한글 X)
    \d (digit, 숫자) : 아무 숫자(0~9 중 하나)
    \s (space, 공간) : 아무 공백 문자(띄어쓰기, 엔터, 탭 등)

    [0-9]  : 0부터 9까지 모든 숫자
    [ㄱ-힣] : ㄱ부터 힣까지  모든 한글
    [가-힣] : 가부터 힣까지  모든 한글(자음만, 모음만 있는 경우 제외)
    [a-z] : 모든 영어 소문자
    [A-Z] : 모든 영어 대문자

    * 특수문자의 경우 각각을 입력하는 방법밖엔 없음
    단, 메타문자와 중복되는 특수문자는 
    앞에 \(백슬래시)를 추가하여 탈출 문자(Escape)로 만들어 사용


    * 수량 관련 메타 문자
    a{5} : a문자가 5개 존재 == aaaaa
    a{2,5} : a가 2개 이상 5개 이하 ==  aa, aaa, aaaa, aaaaa
    a{2,} : a가 2개 이상
    a{,5} : a가 5개 이하


    * : 0개 이상 == 0번 이상 반복 == 있어도되고, 없어도 되고
    + : 1개 이상 == 1번 이상 반복
    ? : 0개 또는 1개
    . : 1칸 (개행문자를 제외한 문자 하나)
*/

// JS 객체 : {"K" : V, "K" : V, "K" : V ....} (Map 형식)
// 특징 1. 원하는 V를 얻어오는 방법
//         - 객체명.key
//         - 객체명["key"]
// 특징 2. 객체에 특정 k가 존재하지 않으면, 추가 가능
//         ex) const obj = {"a" : 1, "b" : 2}
//             obj.c = 3 // -> {"a" : 1, "b" : 2, "c" : 3}
// 특징 3. 객체에 특정 k를 삭제할 수 있다 (delete 연산자)
//         ex) const obj = {"a" : 1, "b" : 2}
//             delete obj.b; // {"A" : 1}

/* 유효성 검사 진행 여부 확인용 객체 */
/* 모든 value가 true인 경우에만 회원 가입 진행 */
const checkObj = {
    "memberEmail" : false,
    "memberPw" : false,
    "memberPwConfirm" : false,
    "memberNickname" : false,
    "memberTel" : false,
    "authKey" : false
};


// 이메일 유효성 검사
const memberEmail = document.getElementById("memberEmail");
const emailMessage = document.getElementById("emailMessage");

// 이메일이 입력될 때 마다
memberEmail.addEventListener("input", () => {
    // 정규 표현식을 이용해서 유효한 형식인지 판별

    // 입력된 이메일이 없을 경우
    if(memberEmail.value.trim().length == 0) {
        memberEmail.value = "";

        // confirm, error 클래스를 삭제해 검정 글씨로 만들기
        emailMessage.innerText = "메일을 받을 수 있는 이메일을 입력해주세요."
        emailMessage.classList.remove("conform", "error");
        
        checkObj.memberEmail = false; // 빈칸 == 유효 x
        return;
    }

    // 1) 정규표현식 객체 생성
    const regEx = /^[A-Za-z\d\-\_]{4,}@[가-힣\w\-\_]+(\.\w+){1,3}$/;

    // 2) 입력 받은 이메일과 정규식 일치 여부 판별
    if(regEx.test(memberEmail.value)) { // 유효한 경우

        
        /* ------------------------------------------------------- */
        /* fetch() API를 이용한 ajax(비동기 통신) */
        // GET방식 ajax 요청 (파라미터는 쿼리스트링으로 전달)
        fetch('/dupCheck/email?email=' + memberEmail.value)
        .then(response => response.text()) // 응답객체 -> 파싱(parsing, 데이터 형태 변환)
        .then( count => { // 파싱한 데이터를 이용해서 수행할 코드 작성
            // count : DB에서 중복되는 이메일이 있을 경우 1, 중복이 아니면 0
            if (count == 0) {
                emailMessage.innerText = "사용 가능한 이메일 입니다.";
                emailMessage.classList.add("confirm"); // css의 .confirm 스타일 적용
                emailMessage.classList.remove("error"); 
                checkObj.memberEmail = true; // 유효
            } else {
                emailMessage.innerText = "이미 사용 중인 이메일 입니다."
                emailMessage.classList.add("error"); 
                emailMessage.classList.remove("confirm"); 
                checkObj.memberEmail = false; // 유효 x
            }

        }) 
        .catch( err => console.log(err)) // 예외 처리
        /* ------------------------------------------------------- */
        


    } else { // 유효하지 않은 경우
        emailMessage.innerText = "이메일 형식이 유효하지 않습니다."
        emailMessage.classList.add("error"); 
        emailMessage.classList.remove("confirm"); 
        checkObj.memberEmail = false; // 유효 x
    }


});




// 비밀번호, 비밀번호 확인 유효성 검사

const memberPw = document.getElementById("memberPw");
const memberPwConfirm = document.getElementById("memberPwConfirm");
const pwMessage = document.getElementById("pwMessage");

memberPw.addEventListener("input", () => {

    // 비밀번호가 입력되지 않은 경우
    if(memberPw.value.trim().length == 0) {
        memberPw.value = ""; // 띄어쓰기 못 넣게 하기
        pwMessage.innerText=""
        pwMessage.classList.remove("confirm", "error"); // 검정 글씨로 바꾼다
        checkObj.memberPw = false; // 빈칸 == 유효하지 않다
        return;
    }
    
    // 정규 표현식을 이용한 비밀번호 유효성 검사
    // 영어,숫자,특수문자(!,@,#,-,_) 6~20글자 사이
const regEx = /^[a-zA-Z0-9\!\Q\#\-\_]{6,20}$/;

    // 입력한 비밀번호가 유효한 경우
    if(regEx.test(memberPw.value))  {
        checkObj.memberPw = true;


        // 비밀번호가 유효하게 작성된 상태에서 비밀번호 확인이 입력되지 않았을 때
        if(memberPwConfirm.value.trim().length == 0) {
            pwMessage.innerText = "유효한 비밀번호 형식입니다.";
            pwMessage.classList.add("confirm");
            pwMessage.classList.remove("error");
        } else { // 비밀번호가 유효하게 작성된 상태에서 비밀번호 확인이 입력되어 있을 때
                    // 비밀번호 == 비밀번호 확인 (같을 경우)
            if(memberPw.value == memberPwConfirm.value){
                pwMessage.innerText = "비밀번호가 일치합니다";
                pwMessage.classList.add("confirm");
                pwMessage.classList.remove("error");
                checkObj.memberPwConfirm = true;
            } else { // 다를 경우
                pwMessage.innerText = "비밀번호가 일치하지 않습니다";
                pwMessage.classList.add("error");
                pwMessage.classList.remove("confirm");
                checkObj.memberPwConfirm = false;

            }
        }


    } else { // 유효하지 않은 경우
        pwMessage.innerText = "유효하지 않은 비밀번호 형식입니다.";
        pwMessage.classList.add("error");
        pwMessage.classList.remove("confirm");
        checkObj.memberPw = false;
    }

});



// 비밀번호 확인 유효성 검사
memberPwConfirm.addEventListener("input", () => {

    if(checkObj.memberPw){ // 비밀번호가 유효하게 작성된 경우에
        

        // 비밀번호 == 비밀번호 확인 (같을 경우)
        if(memberPw.value == memberPwConfirm.value){
            pwMessage.innerText = "비밀번호가 일치합니다";
            pwMessage.classList.add("confirm");
            pwMessage.classList.remove("error");
            checkObj.memberPwConfirm = true;
        } else { // 다를 경우
            pwMessage.innerText = "비밀번호가 일치하지 않습니다";
            pwMessage.classList.add("error");
            pwMessage.classList.remove("confirm");
            checkObj.memberPwConfirm = false;

        }


    } else { // 비밀번호가 유효하지 않은 경우
        checkObj.memberPwConfirm = false;
    }


});




// 닉네임 유효성 검사
const memberNickname = document.getElementById("memberNickname");
const nickMessage = document.getElementById("nickMessage");

// 닉네임이 입력이 되었을 때
memberNickname.addEventListener("input", () => {

    // 닉네임에 아무것도 입력이 되지 않은 경우
    if(memberNickname.value.trim() == '') {
        nickMessage.innerText = "한글,영어,숫자로만 2~10글자";
        nickMessage.classList.remove("confirm", "error");
        checkObj.memberNickname = false;
        memberNickname.value = ""; // 빈칸을 입력하지 못하도록 막는 코드
        return;
    } 
    
    // 정규표현식으로 유효성 검사
    const regEx = /^[가-힣\w\d]{2,10}$/;
    if(regEx.test(memberNickname.value)) { // 유효


        fetch("/dupCheck/nickame?nickname=" + memberNickname.value)
        .then( response => response.text() )  // 응답 객체를 text로 파싱(변환)
        .then( count => {
            if(count == 0) { // 중복이 아닌 경우
                nickMessage.innerText = "사용 가능한 닉네임 입니다.";
                nickMessage.classList.add("confirm");
                nickMessage.classList.remove("error");
                checkObj.memberNickname = true;
        
            } else { // 중복인 경우
                nickMessage.innerText = "이미 사용중인 닉네임 입니다.";
                nickMessage.classList.add("error");
                nickMessage.classList.remove("confirm");
                checkObj.memberNickname = false;
            }
        })
        .catch(err => console.log(err));

    } else { // 무효
        nickMessage.innerText = "닉네임 형식이 유효하지 않습니다.";
        nickMessage.classList.add("error");
        nickMessage.classList.remove("confirm");
        checkObj.memberNickname = false;

    }

});



// 전화번호 윺효성 검사
const memberTel = document.getElementById("memberTel");
const telMessage = document.getElementById("telMessage");

// 전화번호가 입력되었을 때
memberTel.addEventListener("input", () => {

    if(memberTel.value.trim() == '') {
        telMessage.innerText = "전화번호를 입력해주세요.(- 제외)";
        telMessage.classList.remove("confirm", "error");
        checkObj.memberTel = false;
        memberTel.value = ""; // 빈칸을 입력하지 못하도록 막는 코드
        return;
    }

        // 정규표현식으로 유효성 검사
        const regEx = /^0(1[01679]|2|[3-6][1-5]|70)[1-9]\d{2,3}\d{4}$/;
        if(regEx.test(memberTel.value)) { // 유효
            telMessage.innerText = "유효한 전화번호 형식입니다.";
            telMessage.classList.add("confirm");
            telMessage.classList.remove("error");
            checkObj.memberNickname = true;
        } else { // 무효
            telMessage.innerText = "전화번호 형식이 유효하지 않습니다.";
            telMessage.classList.add("error");
            telMessage.classList.remove("confirm");
            checkObj.memberNickname = false;
        }


});





// ---------------------------- [이메일 인증] ----------------------------

// 인증번호 발송
const sendAuthKeyBtn = document.getElementById("sendAuthKeyBtn");
const authKeyMessage = document.getElementById("authKeyMessage");
let authTimer;
let authMin = 4;
let authSec = 59;

// 인증번호를 발송한 이메일 저장
let tempEmail;

sendAuthKeyBtn.addEventListener("click", function(){
    authMin = 4;
    authSec = 59;

    checkObj.authKey = false;

    if(checkObj.memberEmail){ // 중복이 아닌 이메일인 경우


        /* fetch() API 방식 ajax */
        fetch("/sendEmail/signUp?email="+memberEmail.value)
        .then(resp => resp.text())
        .then(result => {
            if(result > 0){
                console.log("인증 번호가 발송되었습니다.")
                tempEmail = memberEmail.value;
            }else{
                console.log("인증번호 발송 실패")
            }
        })
        .catch(err => {
            console.log("이메일 발송 중 에러 발생");
            console.log(err);
        });
        

        alert("인증번호가 발송 되었습니다.");

        
        authKeyMessage.innerText = "05:00";
        authKeyMessage.classList.remove("confirm");

        authTimer = window.setInterval(()=>{

            authKeyMessage.innerText = "0" + authMin + ":" + (authSec<10 ? "0" + authSec : authSec);
            
            // 남은 시간이 0분 0초인 경우
            if(authMin == 0 && authSec == 0){
                checkObj.authKey = false;
                clearInterval(authTimer); // 시간 멈춤
                return;
            }

            // 0초인 경우
            if(authSec == 0){
                authSec = 60;
                authMin--;
            }


            authSec--; // 1초 감소

        }, 1000)

    } else{
        alert("중복되지 않은 이메일을 작성해주세요.");
        memberEmail.focus();
    }

});


// 인증 확인
const authKey = document.getElementById("authKey");
const checkAuthKeyBtn = document.getElementById("checkAuthKeyBtn");

checkAuthKeyBtn.addEventListener("click", function(){

    if(authMin > 0 || authSec > 0){ // 시간 제한이 지나지 않은 경우에만 인증번호 검사 진행
        /* fetch API */
        const obj = {"inputKey":authKey.value, "email":tempEmail}
        const query = new URLSearchParams(obj).toString() // url을 'inputKye=123456$email=user01'이런 형태로 만들어 주는 코드
        fetch("/sendEmail/checkAuthKey?" + query)
        .then(resp => resp.text())
        .then(result => {
            if(result > 0){
                clearInterval(authTimer);
                authKeyMessage.innerText = "인증되었습니다.";
                authKeyMessage.classList.add("confirm");
                checkObj.authKey = true;

            } else{
                alert("인증번호가 일치하지 않습니다.")
                checkObj.authKey = false;
            }
        })
        .catch(err => console.log(err));


    } else{
        alert("인증 시간이 만료되었습니다. 다시 시도해주세요.")
    }

});



// ---------------------------- [이메일 인증] ----------------------------



















// 회원 가입 form태그가 제출 되었을 때
document.getElementById("signUpFrm").addEventListener("submit", e => {

    // checkObj에 모든 value가 true인지 검사

    // for ~ of : 향상된 for문 (배열용)
    //            iterator(반복자) 속성을 지닌 배열, 유사 배열에서 사용 가능

    // for ~ in 구문 : JS 객체가 가지고 있는 Key를 순서대로 하나씩 꺼내는 반복문 (객체용)

    for(let key in checkObj) {
        if(!checkObj[key]) { // 각 key에 대한 value(true/false)를 얻어와 
                             //  false인 경우 == 유효하지 않다
            switch(key){
                case "memberEmail" : alert("이메일이 유효하지 않습니다."); break;
                case "memberPw" : alert("비밀번호가 유효하지 않습니다."); break;
                case "memberPwConfirm" : alert("비밀번호가 확인되지 않습니다."); break;
                case "memberNickname" : alert("닉네임이 유효하지 않습니다."); break;
                case "memberTel" : alert("전화번호가 유효하지 않습니다."); break;
            } 
            
            // 유효하지 않은 input 태그로 focus 이동
            // kye == input의 id 로 설정

            document.getElementById(key).focus();
            e.preventDefault(); // form태그 기본 이벤트 제거
            return; // 함수 종료

        }
    }    

});