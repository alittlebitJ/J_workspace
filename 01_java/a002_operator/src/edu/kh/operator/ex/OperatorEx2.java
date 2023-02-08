// 

package edu.kh.operator.ex;

public class OperatorEx2 {

	
	public static void main(String[] args) {
	
	/*
	 * 빨리 main 만드는 법
	 * 1) 클래스 생성시 체크박스 main 클릭 
	 * 2) main - ctrl + spacebar - enter
	 */	
		
		
		
	/* 증감 연산자 : ++, --
	 * -피연산자를 1씩 증가 또는 감소시키는 연산자
	 * 
	 * 전위 연산 : ++a, --a (피연산자보다 앞에 증감연산자가 있음)
	 * - 다른 연산자보다 먼저 a를 증가 또는 감소 시킴 (최우선)
	 * 
	 * 후위 연산 : a++, a-- (피연산자보다 뒤에 증감연산자가 있음)
	 * - 다른 연산을 모두 수행한 후 a를 증가 또는 감소 시킴 (마지막)
	 * 
	 */
		
		
	// 증감 연산 확인
	int num1 = 10;
	int num2 = 10;
	
	System.out.printf("[연산 전] num1 : %d / num2 : %d \n", num1, num2);
	
	num1++; // 11
	// num1++는 num1 = num1 + 1 과 같음
	num2--; // 9
	// num2--는 num2 = num2 - 1 과 같음
	
	num1++;
	num1++;
	num2--;
	
	System.out.printf("[연산 후] num1 : %d / num2 : %d \n", num1, num2);	
	
	
	System.out.println("-----------------------------");
	
	
	// 전위 연산
	int num3 = 5;
	System.out.println("++num3 : " + (++num3));  //6으로 증가 한 후 "++num3 : "와 결합
	System.out.println("num 3 : " + num3);// num3 = 6 (증감연산자는 증가하거나 감소한 값이 그대로 변수에 저장되어 있다)
	System.out.println("--num3 + 10 : " + (--num3 + 10)); // num3 = 15
	
	
	// 후위 연산
	int num4 = 1;
	System.out.println("num4-- : " + (num4--)); // num4-- : 1 -> num4 = 0
	System.out.println("연산 후 num4-- : " + num4); // num4 = 0
	System.out.println("num4++ -3 : " + (num4++ -3)); // -3
	System.out.println("연산 후 num4++ : " + num4); // num4 = 1
	
	// ---------------------------------------
	
	int a = 3;
	int b = 5;
	int c = a++ + --b;
	
	// 최종적으로 a, b, c는 각각 얼마인가
	// a=4 b=4 c=7
	
	
	System.out.printf("a = %d , b = %d , c = %d \n", a,b,c);
	// c = 3++(a) + --5(b)
	// c = 3++(a) + 4(b)  -> b = 4
	// c = 7
	// a = 3++ -> a = 4
	
	
	
	System.out.println("-----------------------------------------");
	
	/* 
	 * 비교 연산자 : == != > < >= <=
	 * - 복합 기호에서 등호(=)는 항상 오른쪽
	 * - 비교 연산의 결과는 항상 논리형(true/false)
	 */
	
	int num5 = 100;
	int num6 = 200;
	
	
	System.out.println(num5 == num6); // false
	System.out.println(num5 != num6); // true
	System.out.println(num5 > num6); // false
	System.out.println(num5 < num6); // true
	System.out.println(num5 >= num6 - num5); // true 
	System.out.println((num6 <= num5+num5) == false); // false
	
	
	// 짝수 검출 == 2의 배수(2로 나눴을 때 나머지가 0)
	// 방법 1)
	System.out.println(4 % 2 == 0); // T
	System.out.println(5 % 2 == 0); // F
	System.out.println(6 % 2 == 0); // T
	System.out.println(7 % 2 == 0); // F
	// 방법 2)
	System.out.println(8 % 2 != 1); // T

	
	// 홀수 검출
	// 방법 1)
	System.out.println(4 % 2 == 1); // F
	System.out.println(5 % 2 == 1); // T
	// 방법 2)
	System.out.println(6 % 2 != 0); // F
	System.out.println(7 % 2 != 0); // T
	
	
	
	
	System.out.println("463984는 3의 배수인가? : " + (463984 % 3 == 0));
	System.out.println("463984는 4의 배수인가? : " + (463984 % 4 == 0));
	
	
	
	
	
	
	
	
		
	}
	
	
}
