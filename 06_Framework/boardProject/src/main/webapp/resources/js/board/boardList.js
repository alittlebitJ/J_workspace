const insertBtn = document.querySelector("#insertBtn");

insertBtn.addEventListener("click", () => {

    // JS BOM(Browser Object Model)객체 중 location 사용
    // location.href = "주소" : 해당 주소 요청(GET방시)

                    // ex. board2/1/insert
    location.href = `/board2/${location.pathname.split("/")[2]}/insert`;


});