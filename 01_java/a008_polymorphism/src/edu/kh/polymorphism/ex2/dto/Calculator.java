package edu.kh.polymorphism.ex2.dto;


// 계산기 인터페이스
// -> 모든 계산기에 대한 공통 필드 ,기능명을 제공하는 용도
// -> 공통 규약(이름만) 설정
public interface Calculator {

	public static final double PI = 3.14;
	final int MAX_NUM = 100_100_100; // 1억, public static이 생략
	int MIN_NUM = -100_000_000; // public static이 생략 (글씨가 기울면 static이라는 표시)
	
	/** */ // 단축키 : alt + shift + j
	/** 두 정수의 합 반환
	 * @param a
	 * @param b
	 * @return a + b
	 */
	public abstract int plus(int a, int b); // 더하기
	
	
	/** 두 정수의 차 반환
	 * @param a
	 * @param b
	 * @return a - b
	 */
	int minus(int a, int b); // 빼기, public abstract를 생략해도 가능
	

	/** 두 정수의 곱 반환
	 * @param a
	 * @param b
	 * @return a * b
	 */
	int multiple(int a, int b); // 곱하기, public abstract를 생략해도 가능
	
	
	/** 두 정수를 나눈 결과 반환
	 * @param a
	 * @param b
	 * @return a / b
	 */
	int divide(int a, int b); // 나누기, public abstract를 생략해도 가능
	
	
	/** 두 정수를 나눈 결과 반환(소수점까지 연산)
	 * @param a
	 * @param b
	 * @return 실수값
	 */
	double divide2(int a, int b); // 나누기, public abstract를 생략해도 가능
	
	
	/** 원의 넓이 반환
	 * @param r
	 * @return 원의 넓이
	 */
	double areaOfCircle(double r); // 원의 넓이 
	
	
	/** a의 x거듭 제곱 (a^x)
	 * @param a
	 * @param x
	 * @return 
	 */
	int square(int a, int x);
	

}
