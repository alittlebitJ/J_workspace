package edu.kh.operator.ex;
import java.util.Scanner;



public class OperatorEx4 {

	
	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("[홀짝 검사기]");
		System.out.print("정수 하나를 입력해주세요 : ");
		
		int input = sc.nextInt(); // 정수 입력 받기
		
		// 삼항 연산자
		// 조건식 ? true인 경우 : false인 경우;
		//String result = input % 2 == 1 ? "홀수 입니다" : "짝수 입니다.";
		
		//System.out.println(result);
		// 단 이 경우 -1을 넣어도 짝수가 나온다
		// Math.abs(숫자) -> 절대값
		//String result = Math.abs(input) % 2 == 1 ? "홀수 입니다" : "짝수 입니다.";
		//System.out.println(result); // -1을 넣어도 홀수가 나옴
		
		// 0은 짝수도 홀수도 아님, but 위의 수식으로 하는 경우 0이 짝수가 나옴
		
		String result = Math.abs(input) % 2 == 1 ? "홀수 입니다" : input == 0 ? "0 입니다" : "짝수 입니다";
		System.out.println(result); // 이제 0까지 걸러내는 홀짝검사기가 됨
		
		
		
		
		
		
		
	}
	
	
}
