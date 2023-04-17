const cont = document.getElementById("content")
const count = document.getElementById("count")

cont.addEventListener("input", () => {
    // input 이벤트 : 입력과 관련된 모든 행동(input, textarea등 입력 가능한 요소에 값이 입력되면 인식)
    count.innerText = cont.value.length;
    if(count.innerText>100)         count.classList.add("error");
    else                            count.classList.remove("error");
    // 요소.classList.toggle('클래스명') : 요소에 클래스가 없으면 추가(true 반환)
                                        // 요소에 클래스가 있으면 제거(false 반환)
});