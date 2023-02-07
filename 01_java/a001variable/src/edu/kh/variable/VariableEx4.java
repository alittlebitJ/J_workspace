// 세미콜론 찍었는지
// 오타는 없는지

package edu.kh.variable;

public class VariableEx4 {

	
	public static void main (String[] args) {
		
		
		// String(문자열)
		// 문자열을 저장하는 자료형
		// 기본 자료형이 아니라 참조형
		
		// 문자열 리터럴 표기법 : "" (쌍따옴표)
		
		String str1 = "hello";
		System.out.println(str1);
		
		// 출력하고자 하는 값의 리터럴 표기법으로 직접 입력하면 출력가능
		System.out.println(10000000000L);
		System.out.println("안녕하세요?");
		
		System.out.println("------------------------------");
		
		String name = "김자민";
		int age = 30;
		char gender = '여';
		
		System.out.println(age + 1); // 정수 + 정수 = 두 수의 합
		System.out.println(name + "입니다"); // 문자열 + 문자열 = 이어쓰기
		System.out.println(name + age); // 문자열 + 정수 = 이어쓰기
		System.out.println(name + age + gender); // 문자열 + 정수 + 문자형 = 이어쓰기
		
		// 김자민님은 30세 여성입니다.
		System.out.println(name + "님은 " + age + "세 " + gender + "성입니다.");
		 
		
		System.out.println(100+ age + name); 
		// 정수 + 정수 + 문자열 = 130김자민 
		// 사칙연산 연산 순위 상 +는 왼쪽-> 오른쪽으로 적용, 따라서 100+30이 먼저 구해지고 이는 정수+정수라 계산이 됨
		// 이후 두 정수 합 + 문자열 = 이어쓰기가 됨
		
		
		
	}
	
	
}
