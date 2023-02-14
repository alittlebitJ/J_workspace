package edu.kh.oop.basic;

public class BasicRun {
	
	public static void main(String[] args) {
		// main method 또한 실행용 기능을 위한 method

		
		
		
		// Java에서의 Object : 클래스의 정의된 내용을 토대로 new 연산자를 통해 메모리에 생성되는 것
		
		
		// 국민 객체 생성
		Nation n1 = new Nation();
		Nation n2 = new Nation();
		Nation n3 = new Nation();
		// Nation class를 이용해서 만든 객체를 참조하겠다 (참조형)
		
		// 국민이 누군지 특정하기
		
		// n1.pNo = "990123-1234567"; 캡슐화 적용으로 대입, 꺼내지 못함
		n1.setpNo("9900123-1234567(간점 접근 이용)");
		n1.name = "홍길동";
		n1.gender = '남';
		n1.address = "서울시 중구 남대문로 120";
		n1.phone = "010-1234-1234";
		n1.age = 25;
		
		//System.out.println(n1.pNo);
		System.out.println(n1.getpNo());
		System.out.println(n1.name);
		System.out.println(n1.gender);
		System.out.println(n1.address);
		System.out.println(n1.phone);
		System.out.println(n1.age);
		// 자료형이 다 다른데도 바로 출력 가능
		// '.'연산자를 이제부터 자주 사용할 것
		
		
		// 객체의 기능 호출하기(부르면 실행된다)
		n1.medicalBenefits();
		n1.speakKorean();
		
		
		
	}

}
