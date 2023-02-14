package edu.kh.array.ex;

public class ArrayEx2 {
	
	
	// 2차원 배열 사용법 1
	public void ex1() {
		// 2차원 배열 선언 및 할당
		int[][] arr = new int[2][3]; // 2행 3열
		
		System.out.println("행의 길이 : " + arr.length);
		System.out.println("열의 길이 : " + arr[0].length);
		
		// 2차원 배열 초기화
		// 1) 인덱스를 이용한 초기화
		arr[0][0] = 7;
		arr[0][1] = 14;
		arr[0][2] = 21;
		
		arr[1][0] = 28;
		arr[1][1] = 35;
		arr[1][2] = 42;
		
		System.out.println("=======================================");
		
		
		// 2) 2중 for문을 이용한 초기화
		
		int number = 0;
		for(int row=0; row<arr.length; row++) { // 행 반복
			for(int col=0; col<arr[0].length; col++) { // 열 반복
				arr[row][col] = number*5;
				number++;
			}
			System.out.println("=======================================");
		}
		
		// 3) 선언 및 초기화
		
		int[][] arr2 = {
				{1,2,3,4,5},
				{60,70,80,90,100},
				{11,22,33,44,55}
				};
		System.out.println(arr2[1][3]); // 90
		
		// 화면에 행열모양 그대로 출력하고 싶을 시
		// 0행 : 1 2 3 4 5
		// 1행 : 60 70 80 90 100
		// 1행 : 11 22 33 44 55
		
		System.out.println("============================");

		
		for(int row=0; row<arr2.length; row++) {
			System.out.print(row + "행 : ");
			for(int col=0; col<arr2[row].length; col++) {
				System.out.print(arr2[row][col] + " ");
			}
			System.out.println(); //개행
		}
		
		
		
		
		
		
	}
	
	
	// 2차원 배열 응용 1
	public void ex2() {
		
		// 3행 3열 짜리 int 2차원 배열에 난수(0~9)를 대입한 후
		// 각 행의 합과 전체 합을 출력
		
		int[][] arr = new int [3][3];
		
		
		/* [실행 화면]
		 * 
		 * 0행의 합 : 10
		 * 1행의 합 : 18
		 * 2행의 합 : 6
		 * 3행의 합 : 34
		 */
		
		// 난수 대입 및 출력
		for (int row=0; row<arr.length; row++) {
			for (int col=0; col<arr[row].length; col++) {
				// 배열 요소에 난수 대입
				arr[row][col] = (int)(Math.random()*10); // 0.0 <= random(x) < 1.0
				System.out.printf("%3d", arr[row][col]); // %d (10진 정수), %3d (3칸을 만든 다음 오른쪽 정렬)
			}
			System.out.println();
		}
		
		
		// 합계 계산 및 출력
		int sum = 0; // 전체 합(모든 요소 합)
		for(int row=0; row<arr.length; row++) {

			int rowsum = 0; // 행의 합
			for(int col=0; col<arr[row].length; col++) {
				rowsum += arr[row][col];
			}
			System.out.println(row + "행의 합 : " + rowsum);
			sum += rowsum;
		}
		System.out.println("전체 합 : " + sum);
	}
	
	
	// 가변 배열
	public void ex3() {
		
		// 2차원 배열 할당 시 마지막 차수(열)의 크기를 지정하지 않고
		// 추후에 각행에 새로운 1차원 배열의 주소를 대입하는 배열
		
		char[][] arr = new char[4][];
		arr[0] = new char [3];
		arr[1] = new char [4];
		arr[2] = new char [5];
		arr[3] = new char [2];
		
		// 배열의 모든 요소에 a부터 시작하여 하나씩 증가하는 알파벳 대입
		
		char ch = 'a';
		for (int row=0; row<arr.length; row++) {
			// 각 행의 열의 길이가 다르기 때문에 조건식의 값이 행별로 변할 수 있도록
			// arr[row].length를 사용
			for(int col=0; col<arr[row].length; col++) {
				arr[row][col] = ch; // 요소에 문자 대입
				ch++; // 다음 문자로 증가
				System.out.print(arr[row][col] + " ");
			}
			System.out.println();
			
		}
	}
	
	
	
	
	
	
	
	
	
	
}

		
		
		

	


