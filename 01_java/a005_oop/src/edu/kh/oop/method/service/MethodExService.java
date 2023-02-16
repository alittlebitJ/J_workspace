package edu.kh.oop.method.service;

// service : 제공, 주문하면 원하는 것을 만들어서 제공
// 실질적인 로직이 작성되는 코드


// 기능 제공용 객체를 만들기 위한 클래스
// -> 비즈니스 로직 작성 (실질적인 업무처리 로직)
public class MethodExService {

	// 2. 매개 변수 (), 반환 값 x
	// 매개 변수 : 전달 받은 값을 저장할 변수
	public void threeNumbersSumAndAverage(int a, int b, int c) {
		// 세 숫자의 합과 평균
		
		// 전달 받은 세 정수의 합
		int sum = a + b + c;
		
		// 전달 받은 세 정수의 평균
		double avg = sum / 3.0;
		
		System.out.println("a : " + a);
		System.out.println("b : " + b);
		System.out.println("c : " + c);
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + avg);
	}
	
	
	// 3. 매개 변수 x, 반환 값 o
	// [1부터 10사이의 난수 5개를 저장한 배열을 반환 받아 출력]
	public int[] fiveRandomNumbers() {
		// -> 반환하는 자료형을 반환값으로 적으면 됨
		
		int[] arr = new int [5];
		for(int i=0; i<arr.length; i++) {
			// 생성된 난수를 배열 요소에 저장
			arr[i] = (int)(Math.random()*10+1); // 1~10 난수
		}
		
		// return : 반환, 돌아가다
		return arr;
				// 돌아갈 때 가져갈 값이 있으면 return 옆에다 작성
				
			// 1. view에서 호출
			// 2. service에서 로직 처리 완료
			// 4. return 다시 호출한 위치로 돌아감
				
		
	}
	
	
	// 4. 매개 변수 o, 반환 값 o
	public String calculate(int num1, int num2, String op) { //view에서 선언한 변수들이랑 이름이 똑같아도 됨(메서드가 다르기 때문), 매개 변수 순서를 view에서 선언한 순서대로 안 해도 됨
		// 이해도 향상을 위해 매개변수 명을 view에서 선언한 변수와 일치시킴
		// (단, 변수 명이 같다고 해서 같은 변수는 아니다)
		
		// +, -, * : 문제 없음
		// /, % : 0으로 나눌 경우 오류가 발생
		
		// 정상 계산 : 5 + 10 = 15 
		// 오류 발생 : "0으로 나눌 수 없습니다."
		// 최종 결과가 문자열이 나왔으면 좋겠다->String 으로 반환값 설정
		
		String result = null; // 결과를 저장할 문자열 변수
		// String은 참조형 == 주소를 저장
		// null : 참조하는 것이 없다(주소를 저장하고 있지 않다)
		// null != 비어있다 
		
		// ==, != : 비교 연산자 
		// 참조형을 비교할 때 값이 아닌 주소를 비교한다
		// -> 대부분 같지 않다(false) 발생
		
		// 해결방법 : 참조형의 값 자체를 비교하는 equals()사용
		// boolean a.equals(b)
		// -> a와 b가 참조하는 객체의 값이 같다면 true, 아니면 false를 반환하는 메서드

		
		// 만약 두 번째 숫자가 0이고 연산 기호가 / 또는 % 인 경우
		if(num2 == 0 && (op.equals("/") || op.equals("%"))) {
			result = "0으로 나눌 수 없습니다.";
			// *******************************
			//  코드 수행 중 return 구문을 만나면, 그 즉시 메서드를 종료하고 호출한 곳으로 돌아감
			// *******************************
			return result;
		}
		
		switch(op) {
		
		case "+" : result = String.format("%d %s %d = %d", num1, op, num2, num1+num2);break;
		case "-" : result = String.format("%d %s %d = %d", num1, op, num2, num1-num2);break;
		case "*" : result = String.format("%d %s %d = %d", num1, op, num2, num1*num2);break;
		case "/" : result = String.format("%d %s %d = %d", num1, op, num2, num1/num2);break;
		case "%" : result = String.format("%d %s %d = %d", num1, op, num2, num1%num2);break;
		default : result = "연산 기호가 잘못 입력되었습니다.";
		}
		
		// String.format("패턴", 변수);
		// ->패턴 형태의 문자열(String)을 반환
		
		
		
		return result; // 문자열 결과가 들어있는 result 반환
		
	}
	
	

}
