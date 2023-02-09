package edu.kh.control.condition.ex;
import java.util.Scanner;

public class SwitchEx {
	
	/* switch문(switch-case문)
	 * - 식 하나의 결과로 많은 경우의 수를 처리할 때 사용하는 조건문
	 *  -> 식의 결과에 맞는 case문이 수행됨
	 * 
	 * [작성법]
	 * switch(식) { //식 수행 결과는 true/false가 아닌 값-정수,실수,문자열-이 나옴
	 * case 결과값1 : 수행코드1; break;
	 * case 결과값2 : 수행코드2; break;
	 * case 결과값3 : 수행코드3; break;
	 * default : 모든 case가 만족하지 않을 경우 수행하는 코드;
	 * }
	 */
	
	
	// switch 예시 1
	// 키보드로 정수를 입력 받아
	// 1이면 "RED"
	// 2이면 "ORANGE"
	// 3이면 "YELLOW"
	// 4이면 "GREEN"
	// 1~4가 아니면 "BLUE"
	public void ex1() {
		// Scanner 자동 입력 하는 방법 -> sc + ctrl + spacebar (문구 완성, import 추가)
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		String res; //결과를 저장할 변수
		
		// 1) if - els if - else 버전
//		if (input == 1) {
//			res = "RED";
//		}
//		else if (input == 2) {
//			res = "ORANGE";
//		}
//
//		else if (input == 3) {
//			res = "YELLOW";
//		}
//
//		else if (input == 4) {
//			res = "GREEN";
//		}
//		else {
//			res = "BLUE";
//		}
//		System.out.println(res);
//		구간을 주석처리 하는 단축키 : 블록지정 후 ctrl + /
		
		// 2) switch - case 버전
		switch (input) {
		case 1 : res = "RED"; break;
		case 2 : res = "ORANGE"; break;
		case 3 : res = "YELLOW"; break;
		case 4 : res = "GREEN"; break;
		default : res = "BLUE";
		}
		System.out.println(res);
		
		// switch문은 무조건 if문으로 바꾸는게 가능
	
		
		
	}
	
	public void ex2() {
		// 랜덤 팀 배정 프로그램
		// (백팀, 청팀, 홍팀)
		// 백팀, 청팀, 홍팀에 각각 임의로 숫자를 부여. 백팀-0, 청팀-1, 홍팀 -2
		// [Java에서 랜덤한 수(난수) 발생시키는 방법]
		// Math.random(); : 난수 발생
		// 1) 난수의 발생 범위 : 0.0 <= random < 1.0
		// 2) 발생한 난수의 자료형 : double
		// + 실수 -> 정수 강제형변한 : 소수점 버림
		
		//Math.random(); // 0.0 <= random < 1.0
		//Math.random()*3; // 0.0. <= random*3 <3.0
		//(int)(Math.random.() * 3) // int로 강제형변환 -> 소수점 버림
		
		int random = (int)(Math.random() * 3);
		// 0, 1, 2 중 하나를 무작위 발생
		
		String result;
		switch(random) {
		case 0 : result = "백팀"; break;
		case 1 : result = "청팀"; break;
		default : result = "홍팀";
		}
		System.out.println(result);
			
	}
	
	
	// switch 예시 3 : 식의 결과가 "문자열" (String) 
	public void ex3() {
		
		Scanner sc = new Scanner(System.in);
		// scan -> ctrl + spacebar -> enter
		
		// 메뉴를 입력 받아서 가격이 얼마인지 출력하기
		// switch문이랑 if문을 연달아 사용할 것
		
		System.out.print("메뉴를 입력하세요 (김밥/라면/샌드위치/떡볶이) : ");
		String input = sc.next();
		
		int price; // 가격을 저장할 변수 선언
		switch(input) {
		case "김밥" : price = 4500; break;
		case "라면" : price = 3500; break;
		case "샌드위치" : price = 5800; break;
		case "떡볶이" : price = 4000; break;
		default : price = -1; // 잘못 입력한 경우에 사용하지 않는 숫자(-1)를 이용해서 표
		}
		
		if (price != -1) {
			System.out.printf("%s은(는) %d원 입니다.", input, price);
		}
		else { // price가 -1인 경우
			System.out.println("존재하지 않는 메뉴입니다.");
		}

	}
	
	
	// switch 예시 4
	public void ex4() {
		
		Scanner sc = new Scanner(System.in);
	      // 산술 연산 계산기 만들기
	      // 두 정수(int)와 1개의 연산자( + - * / % (String으로 입력받을 것-switch는 char를 못 받기 때문) )를 입력 받아서 
	      // 연산 결과를 출력
	      // 단, 나누기(/) 연산 시 0으로는 나눌 수 없도록 한다.
		
	      // [실행 화면]
	      // 정수1 입력 : 5
	      // 연산자 입력 : +
	      // 정수2 입력 : 4
	      // 5 + 4 = 9
	      
	      // [실행 화면]
	      // 정수1 입력 : 5
	      // 연산자 입력 : /
	      // 정수2 입력 : 0
	      // 0으로는 나눌 수 없습니다. (자바에선 0으로 나눌 시 오류로 처리)
	      
	      // [실행 화면]
	      // 정수1 입력 : 5
	      // 연산자 입력 : @
	      // 정수2 입력 : 3
	      // 존재하지 않는 연산자 입니다. 
		
		
		
		
		System.out.print("정수1 입력 : ");
		int num1 = sc.nextInt();
		
		System.out.print("연산자 입력 : ");
		String operator = sc.next();

		System.out.print("정수2 입력 : ");
		int num2 = sc.nextInt();
		
		
		switch(operator) {
		case "/" :
			if(num2 == 0) {
				System.out.println("0으로는 나눌 수 없습니다."); 
			}
			else {
				System.out.println(num1 + " / " + num2 + " = " + ((double)num1 / num2));
			}
		break;
		
		case "%" :
			if(num2 == 0) {
				System.out.println("0으로는 나눌 수 없습니다.");
			}
			else {
				System.out.println(num1 + " % " + num2 + " = " + (num1 % num2));
			}
			break;
			
		case "+" : 
			System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
			break;
		
		case "-" : 
			System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
			break;
			
		case "*" : 
			System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
			break;
		
		default : System.out.println("존재하지 않는 연산자 입니다. ");
			
		}
		
		/*
		 * 선생님 코드
		 * 
		 * System.out.print("정수 1 입력 : ");
		 * int a = sc.nextInt();
		 * 
		 * System.out.print("연산자 입력 : ");
		 * String op = sc.next();
		 * 
		 * System.out.print("정수 2 입력 : ");
		 * int b = sc.nextInt();
		 * 
		 * switch(op) {
		 * case "+" : 
		 * 		System.out.printf("%d %s %d = %d", a, op, b, a+b);
		 * 		break;
		 * case "-" : 
		 * 		System.out.printf("%d %s %d = %d", a, op, b, a-b);
		 * 		break;
		 * case "*" : 
		 * 		System.out.printf("%d %s %d = %d", a, op, b, a*b);
		 * 		break;
		 * case "/" : 
		 * 		if (b == 0) {
		 * 			System.out.println("0으로 나눌 수 없습니다.")
		 * 		}
		 * 		else {
		 * 		System.out.printf("%d %s %d = %.3f", a, op, b, (double)a/b);
		 * 		}
		 * 		break;
		 * case "%" :
		 * 		if (b == 0) {
		 * 			System.out.println("0으로 나눌 수 없습니다.")
		 * 		}
		 * 		else {
		 * 		System.out.printf("%d %s %d = %d", a, op, b, a%b);
		 * 		}
		 * 		break;
		 * default : System.out.println("존재하지 않는 연산자 입니다.");
		 * 
		 */
		
		
		
	}
	
	
	// switch 에시 5 : break의 역할
	// 계절 판별 (switch ver)
	
	public void ex5() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("달(월) 입력 : ");
		int month = sc.nextInt();
		
		String result;
		switch(month) {
		
		// break : 해당 case를 수행한 후 멈춰라
		// swtich 문의 특징 : 해당 case를 먼저 찾아간다. 만약 break가 없으면 다음 case로 넘어감(해당 case가 아니라도 무시하고 넘어감)
		// break 미작성 시 다음 case가 연달아 수행된다
		// *case 마다 꼭 코드가 작성될 필요는 없다
		case 12 : case 1 : case 2 : result = "겨울"; break;
		case 3 : case 4 : case 5 : result = "봄"; break;
		case 6 : case 7 : case 8 : result = "여름"; break;
		case 9 : case 10 : case 11 : result = "가을"; break;
		default : result = "잘못 입력 하셨습니다.";
		}
		
		System.out.println(result);
		
		
	}
	
	

}
