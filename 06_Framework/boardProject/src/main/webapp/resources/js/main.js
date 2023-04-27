
const loginFrm = document.getElementById("loginFrm");
const memberEmail = document.querySelector("#loginFrm input[name='memberEmail']");
const memberPw = document.querySelector("#loginFrm input[name='memberPw']");


// 로그인 시도를 할 때
loginFrm.addEventListener("submit", e => {

    // 이메일이 입력되지 않은 경우
    // 문자열.trim() : 문자열 좌우 공백 제거
    if(memberEmail.value.trim().length == 0) { // 입력한 값의 길이가 0일 경우 (입력을 안 했을 경우)
        alert("이메일을 입력해주세요.");

        memberEmail.value =""; // 잘못 입력된 값(공백) 제거
        memberEmail.focus(); // 이메일 input태그에 커서가 깜빡이게 초점을 맞춤
        
        // form태그 기본 이벤트 제거
        e.preventDefault(); // 제출 못 하게 하기
        return;
    }
    
    // 비밀번호가 입력되지 않은 경우
    if(memberPw.value.trim().length == 0) { 
        alert("비밀번호를 입력해주세요.");
        memberPw.value =""; // 잘못 입력된 값(공백) 제거
        memberPw.focus(); // 이메일 input태그에 커서가 깜빡이게 초점을 맞춤
        e.preventDefault(); 
        return;
    }
});
