
// 배열 생성 확인하기
document.getElementById("btn1").addEventListener("click", () => {
    const arr1 = new Array(); //비어있는 배열
    const arr2 = new Array(3); // 3칸짜리 배열
    const arr3 = []; //비어있는 배열
    const arr4 = ['ㅁ', 'ㅂ', 'ㄱ']; // 생성 및 초기화

    console.log(arr1);
    console.log(arr2);
    console.log(arr3);
    console.log(arr4);
    
    // 자료형 제한 없음을 확인
    // 길이 제한 없음 확인
    
    // - 배열에 지정된 인덱스가 없으면 자동으로 추가
    // - 중간에 인덱스를 건너 뛰면 건너 뒨 자리를 비워둠
    arr1[0] = '가나다'; // string
    arr1[2] = 100;      // number
    arr1[4] = true;     // boolean
    arr1[5] = {"id":"user01", "pw":"pass01"};     // boolean
    console.log(arr1);
});


document.getElementById("btn2").addEventListener("click", () => {
    // 비어있는 배열 생성
    const arr = [];

    // push() : 마지막 자식 요소로 추가
    arr.push('김밥');
    arr.push('삼겹살');
    arr.push('갈비');
    arr.push('냉면');

    // unshit() : 첫 번째 자식 요소로 추가
    arr.unshift("샌드위치");
    arr.unshift("햄버거");

    console.log(arr);
    
    // pop() : 마지막 요소 꺼내기
    console.log(arr.pop());
    console.log(arr);
    
    // shift() : 첫 번째 요소 꺼내기
    console.log(arr.shift());
    console.log(arr);
    
    // sort() : 정렬(오름차순)
    console.log(arr.sort());
    
    const arr2 = [5, 3, 2, 10, 1];
    console.log(arr2.sort()); // 숫자 배열 정렬 시도 [1, 10, 2, 3, 5] 1로 시작하는 애들 먼저 정렬됨
    // 정렬기준함수 추가 (오름차순)
    console.log(arr2.sort( (a, b) => a-b )); // a - b 가 양수면 자리 바꾸기
    // 정렬기준함수 추가 (내림차순)
    console.log(arr2.sort( (a, b) => b-a )); // b - a 가 양수면 자리 바꾸기
    
    // indexOf("값") : 값이 배열에 있으면 index번호, 없으면 -1
    console.log(arr.indexOf("갈비")); // 0
    console.log(arr.indexOf("꽃등심")); // -1

    console.log(arr.toString());
    console.log(arr.join("/"));

    arr.forEach(value => {
        console.log("값 : " + value);
    });
});
