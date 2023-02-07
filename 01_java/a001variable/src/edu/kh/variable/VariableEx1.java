package edu.kh.variable;

public class VariableEx1 {

	public static void main(String[] args) {
		
		// ; (세미콜론)
		// 하나의 코드(명령어)의 끝을 의미
		
		/*
		System.out.println("[변수 사용 X인 경우]")
		
		System.out.println(2 * 3.141592653589793 * 10);
		System.out.println(3.141592653589793 * 10 * 10);
		System.out.println(3.141592653589793 * 10 * 10 * 20);
		System.out.println(4 * 3.141592653589793 * 10 * 10);
		
		System.out.println("---------------------")
		*/
		
		// 변수 사용
		double pi = 3.141592653589793;
		int r = 5;
		int h = 20;
		
		System.out.println("pi : " + pi);
		System.out.println("r : " + r);
		System.out.println("h : " + h);
		
		System.out.println("[변수 사용 O]");
		System.out.println(2 * pi * r);
		System.out.println(pi * r * r);
		System.out.println(pi * r * r * h);
		System.out.println(4 * pi * r * r);
		
		
		// 변수란?
		// - 메모리(RAM)에 값을 기록하는 공간(박스를 상상하면 됩니다.)
		// - 공간에 기록되는 값(Data)이 변할 수 있어서 변수라고 함.
		
		
		// 변수 사용의 장점
		// 1. 코드 작성 용이(쉽고 편리함, 코드 길이 감소)
		// 2. 가독성 향상
		// 3. 재사용성의 증가
		// 4. 유지보수 용이
		
	}
}
