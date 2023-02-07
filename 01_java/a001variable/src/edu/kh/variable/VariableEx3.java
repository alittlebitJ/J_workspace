// 세미콜론 잘 찍었는지
// 오타는 없는지

package edu.kh.variable;

public class VariableEx3 {
	
	public static void main(String[] srgs) {
		
		// 변수 : 메모리에 값을 저장할 수 있는 공간, 저장된 값은 변할 수 있다
		// 상수 : 메모리에 값을 저장할 수 있는 공간, 저장된 값은 변할 수 없다
		// 상수 예약어 : final
		
		// 변수 값 변경 확인
		int num1 = 100;
		System.out.println(num1);
		num1 = 200;
		System.out.println(num1);
		
		// 상수 값 변경 확인
		final int num2 = 99;
		System.out.println(num2);
		// num2 = 999; 에러뜸
		// 에러 안내 메세지 : The final local variable num2 cannot be assigned. It must be blank and not using a compound assignment
		// 한 번 값이 저장된 상수 num2에 다른 값을 저장하지 못 함
		
		// 상수 명명 규칙 및 활용법
		// - 명명규칙 : 모두 대문자 표기, 단어 구분 시 '_(언더바)' 사용
		final int CONSTANT_NUMBER = 100;
		
		// 활용법
		final double PI = 3.14;
		double result = PI * 10 * 10;
		System.out.println(result);
		
		
		// final 은 주로 청소기나 기계쪽 프로그래밍을 하는데 쓰인다
		final int UP = 5;
		final int DOWN = -5;
		final int INIT = 0; // 초기화(처음으로)
		
		System.out.println("--------------------");
		
		int result2 = INIT;
		System.out.println(result2); // 0
		
		result2 = result2 + UP;
		// 대입 연산자(=)는 기호를 기준으로 오른쪽부터 읽는다
		System.out.println(result2); // 5
		
		result2 = result2 + DOWN + DOWN;
		System.out.println(result2); // -5
		
		
		// 변수 명명 규칙 (반드시 지켜야 함)
		// 1. 대소문자 구분 가능, 길이제한 없음
		int apple;
		//int apple; Duplicate local variable apple 변수명 중복
		int applE; // 대소문자 구분이 가능, e가 대문자 E라 중복이 아니라고 판단
		
		int freeTradeAgreement;
		int sjkfdlkfsjeofjpejqpoeiotgipfdoipohipdofjhpwopifpqofipsdnfkljlqiueitlshdkgh;
		// 길이제한 없음
		
		// 2. 예약어 사용 금지 (예약어 : 보통 이클립스에서 색깔 바뀌는 애들)
		//int int;
		//double char;
		//boolean final;
		
		// 3. 숫자로 시작 금지
		//long 100number; <-에러 발생
		long number100;
		
		// 4. 특수문자는 $랑 _만 사용 가능 (근데 보통 안 쓴다고 봐야 함)
		float $number;
		float _number;
		//float @number; <-에러
		
		
		// 5. 카멜 표기법
		// 변수명 첫 글자는 소문자, 연결된 단어의 첫글자는 대문자
		// 오류는 아니나 java 개발자들 사이의 약속

		int studentAge;
		char helloWorld;
		
		// 참고) 변수명에 언어 제한이 없음
		int 정수1번;
		double 실수1번; //가능
		
		
			
		
		
	}

}
