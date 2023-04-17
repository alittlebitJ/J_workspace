const lottoBoard = document.getElementById("lottoBoard");
const btn = document.getElementById("createBtn");

btn.addEventListener("click", () => {
    lottoBoard.innerHTML = ""; // 이전에 생성된 내용을 모두 삭제
    // lottoBoard내부에 div를 생성해 그 안에 45까지의 숫자와 number 클래스를 삽입
    for(let i=1; i<=45; i++){
        // 로또판에 들어갈 div 요소 생성
        const div = document.createElement("div");
        div.innerText = i;
        div.classList.add("number")


        // number 클래스가 클릭 될 때 active 클래스를 삽입,제거하는 클래스 삽입
        div.addEventListener("click", e => {
            // number라는 클래스를 가진 요소 중에 클래스명이 active를 가진 요소(true)가 6개이면
            // if(e.target.classList.contains("active")){
            //     e.e.target.classList.toggle("active")
            // }else {
                    //active 클래스를 가진 요소가 6개 이상인 경우
            //      if(document.getElementsbyClassName("active").length>=6); {
            //      alert("6개 까지만 선택할 수 있습니다.");
            //      return;    
            //      }               
            //     e.target.classList.toggle("active")
            // }

            const list = document.querySelectorAll(".number");
            let count = 0;
            for ( let number of list ){
                if(number.classList.contains("active"))
                count++;
            }
            if(count>=6){
                alert("6개 이하만 선택할 수 있습니다.")
            } else e.target.classList.toggle("active")
        });


        lottoBoard.append(div);
    }
});



