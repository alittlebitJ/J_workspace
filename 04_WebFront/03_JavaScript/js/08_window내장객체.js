// window.setTimeout(함수, 지연시간(ms));
document.getElementById("testBtn").addEventListener("click", () => {
    console.log("0초");
    window.setTimeout( () => {
        console.log("1초");
    }, 1000);
    window.setTimeout( () => {
        console.log("2초");
    }, 2000);
    // setTimeout() 같은 시간 관련 함수들은 여러 번 작성된 경우 앞에 코드가 실행되길 기다리지 않음
    // 비동기로 동작
});


// window.setInterval(함수, 지연시간(ms))
const loadingTime = document.getElementById("loadingTime");
window.setInterval(()=>{
    loadingTime.innerText = Number(loadingTime.innerText) + 1;
}, 1000);

// 시계만들기
const clock = document.getElementById("clock");
// 현재 시간을 #clock에 출력
function currentTime(){ 
    const now = new Date(); // 현재 시간을 저장한 Date 객체 생성

    // 시, 분, 초 저장
    let hour = now.getHours();
    let min = now.getMinutes();
    let sec = now.getSeconds();

    // 12 : 23 : 20
    //let str = hour + ":" + min + ":" + sec;

    // 시/분/초가 10미만(두 자리가 아닐 경우)인 경우 앞에 0 추가
    if(hour < 10) hour = "0" + hour;
    if(min < 10) min = "0" + min;
    if(sec < 10) sec = "0" + sec;

    // 백틱(`)을 이용한 문자열 조합 ex.`${a}/${b}`
    let str = `${hour} : ${min} : ${sec}`;
    clock.innerText = str;
}

// setInterval을 이용하여 currentTime 함수를 1초마다 수행
// setInterval(() => {
//     currentTime();
// }, 1000);

let time = setInterval(currentTime, 1000); // currentTime자체가 함수코드니까 이렇게 넣어도 됨

// window.clearInterval(setInterval이 저장된 변수)
document.getElementById("stop").addEventListener("click", () => {
    clearInterval(time);
});

// 팝업창 열기
const openPopup1 = document.getElementById("openPopup1");
const openPopup2 = document.getElementById("openPopup2");
const openPopup3 = document.getElementById("openPopup3");

openPopup1.addEventListener("click", () => {
    /* window.open(url); */
    /* 새 탭에서 열기 */
    window.open("07_함수.html"); // JS 경로(파일 경로) x , 브라우저에 보이는 주소를 경로로 작성 
    //                              => 같은 폴더에 있어서 경로를 안 적어도 나옴
});

openPopup2.addEventListener("click", () => {
    // 새창에서 최소한의 팝업창 요건을 가진 상태로 열기
    // window.open("url", "_blank", "popup");
    window.open("07_함수.html", "_blank", "popup");
});

openPopup3.addEventListener("click", () => {
    // 새 창의 크기를 너비 400px, 높이 600px로 지정, 열리는 위치는 위에서 100px, 왼쪽쪽에서 100px
    window.open("07_함수.html", "_blank", "width=400, height=600, top=100, left=100");// 기본이 픽셀단위
});

// 팝업창으로 값 전달하기(팝업창이 가져오기)
document.getElementById("sendPopup").addEventListener("click", () => {
    window.open("09_팝업.html", "popupWindow", "width=500, height=300")
});