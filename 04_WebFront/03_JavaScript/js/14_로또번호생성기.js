

document.getElementById("createBtn").addEventListener("click", () => {
    const arr = []; // 비어있는 배열 생성
    while(arr.length<6){ // arr에 저장된 값이 6개 미만인 경우 반복
        const random = Math.floor(Math.random()*45+1); // 난수 생성
        // arr 요소 중 중복되는 값 제거 -> arr 요소 중 중복되는 값이 있으면 push를 안 하겠다
        // 없으면 push를 하겠다
        // 배열명.indexOf(값) : 값이 일치하는 요소의 index 반환, 없으면 -1 반환
        if(arr.indexOf(random) == -1) {
            arr.push(random); // 배열 마지막 요소로 추가
        }
    }
    arr.sort((a,b) => a - b); // 내부 함수 결과가 양수면 오른쪽으로 이동
    const list = document.querySelector("#container").children;
    for(let j=0; j<arr.length; j++){
        list[j].innerText = arr[j];
    }
});

