package edu.kh.variable;

public class Practice {

	public static void main (String[] srgs) {
		
		
		/* [기본 자료형 8가지]
		 * 정수형 : byte(1), short(2), int(4), long(8, L/l)
		 * 실수형 : float(4, F/f), double(8)
		 * 문자형 : char(2)
		 * 논리형 : boolean(1, true/false)
		 */
		
		
		/* [컴퓨터 값 처리 원칙]
		 * 같은 자료형 끼리만 연산 가능, 결과도 같은 자료형
		 * 
		 * [자동 형변환]
		 * 값은 범위가 다른 자료형끼리의 연산 시, 범위가 작은 자료형을 큰 자료형으로 컴파일러가 자동으로 변환하는 것
		 * [강제 형변환]
		 * 특정한 자료형을 원하는 자료형으로 강제로 변환하는 것(명시적)
		 * 단 데이터 손실이 발생할 수 있다
		 */
		
		//문제
		
		int iNum1 = 10;
		int iNum2 = 4;		
		float fNum = 3.0f;
		double dNum = 2.5;
		char ch = 'A';
		
		
		System.out.println(iNum1 / iNum2); // iNum1, iNum2 를 이용하여 2가 나오게 하라
		System.out.println((int)dNum); // dNum을 이용하여 2가 나오게 하라
		System.out.println(iNum2 * dNum); //10.0(double)
		System.out.println((double)iNum1); //iNum1을 10.0으로 표현되게 만들어라
		System.out.println((double)iNum1/iNum2); //iNum1, iNum2를 활용해서 2.5를 만들어보라
		// 최종 결과로 3이라는 결과가 나오게 하라
		System.out.println((int)fNum); 
		System.out.println((int)(iNum1/fNum));
		
		System.out.println(iNum1/fNum); // 3.333333가 나오게
		System.out.println((double)iNum1/fNum); // 3.33333333333335가 나오게
		
		System.out.println((int)ch); //65
		System.out.println(iNum1 + ch); //75 (값의 범위가 낮은 ch가 int로 자동 형변환)
		
		System.out.println((char)(ch + iNum1));
		
		
	}
	
	
}
