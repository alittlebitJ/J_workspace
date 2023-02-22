package edu.kh.inheratance.dto;

public class Child1 extends Parent{ // (Parent의 코드를 상속 받아 child1 확장)
	
	public String car;

	// 기본 생성자
	public Child1() {
		super(); // super() 생성자 -> Parent 기본 생성자로 감
		// 생성자 : 객체를 만드는 기능 , Parent : 부모
		// -> 부모를 만드는 기능(직접 생성자를 사용해 부모를 생성할 수 없으니, 부모 생성자를 호출)
		// sper생성자의 경우 컴파일러가 자동적으로 추가->자식 객체 생성 시 부모 객체를 먼저 생성하게 함
		
		System.out.println("Child1() 기본 생성자");
	}
	
	// 매개 변수 생성자
	public Child1(String car) {
		//super(); // super() 생성자 -> Parent 기본 생성자로 감
		
		// 부모로 부터 상속받은 setter를 이용해서 부모 필드 초기화
//		setMoney(100_000_000); // 부모로 부터 상속받은 것을 수정하고 싶을 때
//		setLastName("김");
		
		// 부모의 필드를 초기화 하는 방법이 부모 매개변수 생성자에 존재
		// -> 이를 호출해서 사용 (코드길이 감소, 재사용성 증가)
		super(200_000_000, "백");
		// 부모부분을 만들 때 부터 1억에 김이라는 매개변수를 미리 집어넣자 <-코드 길이 감소, 중복제거에 용이
		
		
		this.car = car;
		System.out.println("Childe1(STring) 매개변수 생성자");
	}

	// getter / setter
	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}
	
	public String toString() {
		// 기본에 하던 방법
		// Parent p1 = new Parent();
		// p1.getMoney();
		
		// 자신의(같은 클래스) 메서드 호출 시 이름만 부르면 된다
 		// + 상속 특징(부모 필드/메서드를 상속 받아 자식 것 처럼 사용
		
//		System.out.println(getCar());
//		System.out.println(getMoney());
//		System.out.println(getLastName());
		
		// 부모의 필드 값을 간접 접근 방법으로 얻어와 하나의 문자열로 만들어 반환
		//return car + " / " + getMoney() + " / " + getLastName();
		
		//return car + " / " + toString(); <-child1의 toString으로 넘어감
		// 동명의 메서드 호출 시 자식 메서드에 우선순위가 가서 재귀호출이 일어남 -> 스택오버플로우 발생
		// 문제점 : StackOverflowError 발생
		// 원인 : child1의 toString() 호출 시 같은 toString()은 계속 반복해서 호출(==재귀 호출) / 재귀호출이 for문보다 성능이 더 좋음
		// 해결방법 : 부모의 toString() 호출을 명시 ->super.참조변수 이용
		
		return car + " / " + super.toString(); // <- parent의 toString 으로 넘어감
	}
	
	

}
