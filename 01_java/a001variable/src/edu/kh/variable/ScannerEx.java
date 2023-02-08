package edu.kh.variable;

import java.util.Scanner; //1)

public class ScannerEx {
	
	
	public static void main(String[] srgs) {
		
		
		/* Scanner : 프로그램 실행 중 입력을 받는 객체
		 * 사용 단계
		 * 1) class 선언부 위쪽에 import java.util.Scanner; 구문을 추가
		 * 2) Scanner 객체를 생성해 쓸 수 있는 형태로 만들기
		 * 3) Scanner를 이용해서 키보드 입력 값 얻어오기
		 */
		
		Scanner sc = new Scanner(System.in); //2) System.in : 키보드로부터 입력을 받겠다
		System.out.print("정수 입력 1: "); // 3)
		int input1 = sc.nextInt();
		// sc.nextInt() : 다음 입력되는 정수를 얻어옴
		//System.out.println(input1);
		
		System.out.print("정수 입력 2: ");
		int input2 = sc.nextInt();
		System.out.printf("%d + %d = %d", input1, input2, input1+input2);
		
	}
	

}
