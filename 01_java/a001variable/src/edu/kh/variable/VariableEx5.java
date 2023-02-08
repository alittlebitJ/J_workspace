package edu.kh.variable;

public class VariableEx5 {

	
	public static void main (String[] srgs) {
		
		
		/*
		 * 형변환 (casting) : 값의 자료형을 변환하는 것
		 * 형변환은 왜 필요한가?
		 * -> 컴퓨터의 값 처리 원칙(같은 자료형끼리 연산, 결과도 같은 자료형)을 위배하는 경우를 해결하기 위해
		 * 
		 * [자동 형변환]
		 * -'값의 범위'가 서로 다른 두 값의 연산 시 '컴파일러'가 자동으로 '값의 범위'가 작은 자료형을 큰 자료형으로 변환시켜주는 것
		 */
		
		
		
		// 자동 형변환 확인 1
		int num1 = 10;
		long num2 = 100L;
		
		System.out.println("num1 + num2 = " + (num1 + num2)); // num1 = 10L 이 됨 (long 형으로 바뀜)
				
		
		// 자동 형변환 확인 2
		int num3 = 300;
		double num4 = 12.3;
		
		double result1 = num3 + num4;
		// 300(int) + 12.3(double)
		// 300.0(double)
		// 312.3(double)
		// 연산 결과를 예상해서 저장할 변수의 자료형을 선택할 줄 알아야
		
		System.out.println(num3 + " + " + num4 + " = " + result1);
		System.out.println(((Object)result1).getClass().getSimpleName()); // Double
		

		// 자동 형변환 확인 3
		// char -> int 자동형변환
		
		char ch5 = 'ㄱ';
		int num5 = ch5; // int = char 
		// '='기호도 연산기호, 대입연산자
		// 고로 int랑 char의 연산이 이루어지고 있음
		// -> int = int로 자동 형변환
		// A 는 65, a 는 97
		
		System.out.println(ch5 + " Unicode Number : " + num5);
		
		System.out.println("-----------------------------");
		
		
		/*
		 * 강제 형변환
		 * -값의 범위가 큰 자료형을 작은 자료형으로 강제로 변환 (변수나 값을 원하는 형태의 자료형으로 강제 변환, 값의 범위 상관 x)
		 */
		
		// 강제 형변환 확인 1 : 데이터 손실 확인
		int test1 = 290;
		//byte test2 = test1; Type mismatch: cannot convert from int to byte
		byte test2 = (byte)test1; // 변환 시키고자 하는 자료형을 명시해서 강제로 변환
		System.out.println("test1 : " + test1);
		System.out.println("test2 : " + test2);
		
		// ctrl + alt + 방향키 위/아래 : 라인복사 ( 만약 화면이 뒤집힐 시 시작칸 intel HD 그래픽-그래픽 옵션-바로가기 키-사용 안 함)
		
		
		// 강제 형변환 확인 2 : 소수 버림
		double test3 = -1.3;
		int test4 = (int)test3;
		System.out.println("test3 : " + test3);
		System.out.println("test4 : " + test4);
		
			
		// 강제 형변환 확인 3 : 값의 범위와 관계없이 변환
		int test5 = 1;
		int test6 = 2;
		System.out.println(test5 / test6); // 1/2 = 0.5이나, int는 정수만 나와야 함으로 컴파일러가 0.5(double)을 int로 강제 형변환시킴. 결과값 0
		
		// 자동 형변환 + 강제 형변환
		System.out.println((double)test5 / test6); 
		// test5를 double로 강제 형변환 -> double(1.0)/int(2) -> double(1.0)/double(2.0)자동형변환 = double(0.5)
		
				
		// 강제 형변환 기타
		// - 강제 형변완의 대상이 변수에 국한되는것은 아니다
		System.out.println((double)65); // 65.0 (변수 뿐만 아니라 literal 자체에도 사용 가능)
		System.out.println((char)65); // A (int에서 값의 범위가 더 좁은 char로 표현, 유니코드에 해당되는 영문자가 출력)
		System.out.println((int)'B'); // 66
		
		
		
		
		// 데이터 오버플로우
		byte bNum = 126;
		System.out.println(bNum); // 126
		
		//bNum = bNum + (byte)1; // Type mismatch: cannot convert from int to byte 최종 결과가 127이 나와서 int가 됨
		bNum = (byte)(bNum + 1); // (byte)((int)127)
		System.out.println(bNum); // 127
		
		bNum = (byte)(bNum + 1); // (byte)((int)128)
		System.out.println(bNum); // -128 (128은 byte의 제일 큰 128을 초과, 오버플로우 발생)
		
		// 오버플로우 확인
		int iNum1 = 1000000000; // 10억
		int iNum2 = 2000000000; // 20억
		int iNum3 = iNum1 + iNum2; // 30억이 나와야
		System.out.println(iNum3); // 데이터 오버플로우로 인해 -1294967296이 나옴
		// 값의 범위를 잘못 예측한 경우 오버플로우가 발생함
		
		// 고치려면?
		//long iNum3 = (long)iNum1 + iNum2;
		//System.out.println(iNum3); // 3000000000
		
		//주석주석주석
		
	}
}
