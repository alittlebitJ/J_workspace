package edu.kh.array.ex;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayEx1 {
	
	
	/*
	 * 배열
	 * - 같은 자료형의 변수를 하나의 묶음으로 다루는 것.
	 * - 묶여진 변수들은 하나의 이름(배열명)으로 불려지고
	 *   각각의 변수는 index를 이용해서 구분함
	 * - index는 0부터 시작
	 */
	
	
	// 배열 기본 사용법 1
	public void ex1() {
		
		// 배열 선언
		int[] arr; //또는 int arr[];
		// - int 배열을 '참조'할 공간을 할당하고 이를 arr이라고 부르겠다.		
		//	 * 기본 자료형 8개를 제외한 나머지는 "참조형" 이라고 한다.
		
		// 배열 할당
		arr = new int[4];
		// - 새롭게 int형 변수 4개짜리 배열을 생성하고
		// - 이를 arr에 대입
		//		-> arr이 해당 배열을 참조
		// 		-> 해당 배열을 부를 대 arr 이라고 부르면 됨
		
		// 배열 이용
		// 1) 배열 각 요소에 값 대입
		arr[0] = 10;
		arr[1] = 30;
		arr[2] = 20;
		arr[3] = 4;
		
		// 2) 배열 각 요소의 값 얻어오기
		System.out.println("arr[0] : " + arr[0]); // 10
		System.out.println("arr[1] : " + arr[1]); // 30
		System.out.println("arr[2] : " + arr[2]); // 20
		System.out.println("arr[3] : " + arr[3]); // 4
		// 0부터 3까지 1씩증가<for문으로 반복문 만들기 가능
		
		// 3) for문 + 배열
		System.out.println("-------------------------------");
		int sum = 0;
		for(int i=0; i<4; i++) { // for문의 i = index의 i, for문이랑 배열은 상당히 상관관계가 높다. 배열을 하려면 for문이 꼭 필요
			System.out.printf("arr[%d] : %d \n", i, arr[i]);
			sum += arr[i];
		}
		
		System.out.println("sum = " + sum);
		
	
		
	}
	
	
	// 배열 기본 사용법 2 : 초기화
	public void ex2() {
		
		// 배열 : 같은 자료형의 변수를 하나의 묶음으로 다루는 것
		
		// 1)		  3) 2)
		int[] numbers = new int[4];
//		 1) Stack 영역에 int 배열을 참조하기 위한 변수 numbers를 선언
//		 2) Heap 영역에 새롭게 int 4칸짜리 배열을 할당
//				-> index 번호 추가, 기본값(0)으로 자동초기화, 시작주소 부여 (ex.0x5123)
//		 3) Heap 영역에 생성된 배열의 시작 주소 (0x5123)를 Stack 영역 참조 변수 numbers에 대입한다.
//		 		-> numbers가 배열을 참조함
		
		// 1. 정말 numbers에 주소가 저장 되었을까??
		System.out.println(numbers); // [I@6f2b958e <-주소? 정확히 말하면 주소는 아님, 주소를 가지고 만든 숫자(hash code). 지금은 주소로 봐도 무방
		
		// 2. 정말 기본값(0)으로 초기화 되었을가?
		System.out.println(numbers[0]); // 0
		System.out.println(numbers[1]); // 0
		System.out.println(numbers[2]); // 0
		System.out.println(numbers[3]); // 0
		// 컴파일러가 0으로 초기화 하였음을 확인
		
		System.out.println("==========================");
		
		// 배열 초기화
		// 1) 인덱스를 이용한 초기화
		numbers[0] = 100;
		numbers[1] = 5;
		numbers[2] = 300;
		numbers[3] = 99;
		
		// breakpoint : debug모드로 실행 시 해당 줄의 코드가 수행되기 전 멈춤
		// 디버그 단축키 : f11
		
		System.out.println("==========================");
		
		// for 문을 이용한 초기화
		// ** 배열명.length : 배열의 길이(칸 수)를 반환
		for (int i=0; i<numbers.length; i++) {
			numbers[i] = i * 10 + 1;
		}
		
		
		System.out.println("==========================");

		
		// 선언과 동시에 초기화
		int[] numbers2 = {100, 200, 300, 400, 500, 600};
						// new 구문 생략
		
		
		System.out.println("==========================");
		
	}
	
	
	// 배열 기본 사용법 3
	public void ex3() {
		// 3명의 키를 입력 받아 평균 구하기
		
		// 1번 키 입력 : 170.5
		// 2번 키 입력 : 165.7
		// 3번 키 입력 : 180.4
		
		// 입력 받은 키 : 170.5  165.7  180.4
		// 평균 키 : 177.20cm
		
		Scanner sc = new Scanner(System.in);

		double[] heightArray = new double[3]; // 0.0  0.0  0.0
		double sum = 0.0;
		
		for(int i=0; i<heightArray.length; i++) {
			
			System.out.printf("%d번 키 입력 : ", i+1);
			heightArray[i] = sc.nextDouble();
			// 0 1 2
			sum += heightArray[i];
		}
		
		System.out.println(); // 개행
		System.out.print("입력 받은 키 : ");
		for(int i=0; i<heightArray.length; i++) {
			System.out.print(heightArray[i] + " ");
		}
		System.out.printf("\n평균 키 : %.2fcm", sum / 3);
		
		
	}
	
	
	
	
	// 배열 기본 사용법 4
	public void ex4() {
		// 오늘의 점심 메뉴 뽑기
		
		// String[] menuArr = new String[10];
		String[] menuArr = {"서브웨이", "KFC", "맘스터치", "순대국", "뼈해장국", "닭갈비", "마라탕","우육면", "파스타", "샐러드"};
		
		// 0부터 배열 길이의 범위 내에서 난수 발생
		int index = (int)(Math.random() * menuArr.length);
		System.out.println("오늘의 점심 메뉴!! : " + menuArr[index]);


	}
	
	
	// 배열 사용 시 주의사항!!!
	public void ex5() {
		
		
		// 배열의 범위를 넘어선 index를 참조하는 경우
		
		int[] arr = {10, 30, 50, 70, 90};
		// arr에 저장된 값 모두 출력
		for(int i=0; i<=arr.length; i++) { // i = 0, 1, 2, 3, 4, 5  
			// ArrayIndexOutOfBoundsException :  배열 인덱스 범위 초과 예외(에러)
			// Index 5 out of bounds for length 5 :  인덱스 5번은 길이 5자리 배열의 범위를 초과했다.
			System.out.println(arr[i]);
			
			// 문제점 : for문의 조건식에서 i의 범위가 arr 배열의 인덱스 범위를 초과하는 값까지 증가하도록 작성되어
			//		  실행 시 for문 내 출력 구문에서 ArrayIndexOutofBoundsException이 발생함.
			
			// 해결 방법 : 조건식을 i< arr.length로 수정하여 i가 배열의 인덱스 범위를 초과하지 않도록 함.
			
		}
		
	}
	
	
	// 배열 사용법 6
	public void ex6() {
		// 인원 수를 입력 받아 그 크기만큼의 정수 배열을 선언 및 할당하고
		// 각 배열 요소에 점수를 입력받아 저장
		// 입력이 완료되면 합계, 평균, 최고점, 최저점을 출력
		
		//[출력화면]
		// 입력 받을 인원 수 : 4
		// 1번 점수 입력 : 
		// 2번 점수 입력 : 
		// 3번 점수 입력 : 
		// 4번 점수 입력 : 
		
		// 합계 : 
		// 평균 : 
		// 최고점 : 
		// 최저점 : 
		
		Scanner sc = new Scanner(System.in);
		System.out.print("입력 받을 인원 수 : ");
		int size = sc.nextInt();
		
		int[] scoreArr = new int[size]; // 입력 받은 정수의 길이를 갖는 배열 생성
		
		int sum = 0;
		 
		
		for(int i=0; i<scoreArr.length; i++) {
			System.out.print((i+1) + "번 점수 입력 : ");
			scoreArr[i] = sc.nextInt();
			sum += scoreArr[i];		
		}
		System.out.println(); // 개행
		
		// 최대/최소 구하기
		int max = scoreArr[0]; 
		// 처음부터 너무 큰 값을 넣으면 문제가 생길 수 있음
		// max의 초기값 : 1) 매우 작은 수 2) 배열의 0번 인덱스 값
		int min = scoreArr[0];
		// min의 초기값 : 1) 매우 큰 수 2) 배열의 0번 인덱스 값

		int maxIndex = 0; // 최고/최저점 인덱스 저쟝용 변수
		int minIndex = 0; // 0번 인덱스
		
		for(int i=0; i<scoreArr.length; i++) {
			if(scoreArr[i] > max) {
				// 기존(최대값)보다 현재 배열 요소의 값이 더 큰 경우
				max = scoreArr[i];
				maxIndex = i;
			}
			if(scoreArr[i] < min) {
				// 기존(최소값)보다 현재 배열 요소의 값이 더 작은 경우
				min = scoreArr[i];
				minIndex = i;
			}
		}
		
		
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + (sum/(double)size)); // 핵은 scoreArr.length
		System.out.printf("최고점 ㅣ %d (%d번 학생) \n", max, maxIndex+1);
		System.out.printf("최저점 ㅣ %d (%d번 학생) \n", min, minIndex+1);
		
		
		
	}
	
	
	
	
	// 배열 내 데이터 검색
	public void ex7() {
	
		// 입력 받은 정수가 배열에 존재하면 몇 번 인덱스에 있는지 출력
		// 없으면 "존재하지 않습니다" 출력
		
		int[] arr = {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000};
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
//		int index = -1;
//		// 1) 초기값을 index범위에 포함되지 않는 값을 작성
//		
//		for (int i=0; i<arr.length; i++) {
//			// 입력값과 현재 인덱스 값이 같으면
//			if (input == arr[i]) {
//				index = i;
//			}
//			}
//		if (index < 0) { // 일치하는 결과가 없음
//			System.out.println("존재하지 않습니다.");
//		}
//		else {
//			System.out.println(index + "번 인덱스에 있습니다.");
//		}
		
		// 2) flag 변수를 이용하는 방법
		int index = 0;
		boolean flag = true; // 신호 용도의 변수
		// 검색 for문 종료 후
		// flag[true] : 검색 결과 없음
		// flag[false]: 검색 결과 존재
		
		for(int i=0; i<arr.length; i++) {
			if (input == arr[i]) { // 입력 값과 일치하는 값이 존재하는 경우
				index = i;
				flag = false;
				break; // 일치하는 값을 찾은 경우 더 이상 반복하지 않음(성능 개선)
			}
		}
		if (flag) { // true 일 때
			System.out.println("존재하지 않습니다.");
		}
		else {
			System.out.println(index);
		}
		
	}
	
	
	
	// 얕은 복사 / 깊은 복사
	public void ex8() {
		// 얕은 복사 
		// - 참조 하는 배열/객체의 주소만을 복사하여
		// 서로 다른 참조 변수가 하나의 배열/객체를 참조함(공유하는 개념)
		
		// 깊은 복사
		// - 원본과 같은 자료형, 크기는 같거나 더 큰 배열을 만들어
		//   원본의 데이터를 모두 복사하는 방법(복제의 개념)
		
		
		// 얕은 복사 확인
		int[] arr1 = {10, 20, 30, 40, 50};
		
		int[] copyArr1 = arr1; // 얕은 복사(arr1에 저장된 배열 주소값 복사)->arr1, copyArr1이 같은 배열 참조
		
		
		
		// 1) 참조하는 주소가 같은가?
		System.out.println("arr 1 : " + arr1);
		System.out.println("copyArr 1 : " + copyArr1);
		
		/* 
		 * arr 1 : [I@6f2b958e
		 * copyArr 1 : [I@6f2b958e
		 */
		
		
		// 2) 복사본의 값을 변경할 경우 원본이 변하는가?
		copyArr1[0] = 9999;
		System.out.println("copyArr1 : " + Arrays.toString(copyArr1)); 
		
		/*
		 * arr1 : [9999, 20, 30, 40, 50]
		 * copyArr1 : [9999, 20, 30, 40, 50]
		 */
		
		
		System.out.println("=================================================");
		
		
		// 깊은 복사 확인
		int[] arr2 = {5, 6, 7, 8};
		int[] copyArr2 = new int[arr2.length];
		// 깊은 복사를 진행할 arr2 배열과 같은 크기의 배열을 준비
		
//		// for문을 이용해서 깊은 복사
//		for(int i=0; i<arr2.length; i++) {
//			copyArr2[i] = arr2[i];
//		}
//		
		
		// System.arraycopy()를 이용한 깊은 복사
		System.arraycopy(arr2, 0, copyArr2, 0, arr2.length);
		// shift + f2 <- 자바 공식 문서
		// (원본 배열명, 원본 배열 복사 시작 인덱스, 복사 배열명, 복사 배열의 삽입 시작 인덱스, 복사 길이)
		
		
		// 1) 참조하는 주소가 같은가?
		System.out.println("arr2 : " + arr2);
		System.out.println("copyArr2 : " + copyArr2);
		/*
		 * arr2 : [I@5e91993f
		 * copyArr2 : [I@1c4af82c
		 */
		
		
		// 2) 복사본의 값을 변경할 경우 원본이 변하는가?
		copyArr2[0] = 9999;
		
		System.out.println("arr2 : " + Arrays.toString(arr2));
		System.out.println("copyArr2 : " + Arrays.toString(copyArr2));
		/*
		 * arr2 : [5, 6, 7, 8]
		 * copyArr2 : [9999, 6, 7, 8]
		 */
		
		
		
			
	}
	
	
	
	
	
	
}
