package edu.kh.inheratance.dto;

public class Child2 extends Parent {

	private String house;
	
	public Child2() {
		System.out.println("Child2() 기본 생성자");
	}
	
	public Child2(String house) {
		this.house = house;
		System.out.println("Child2(String) 매개변수 생성자");
	}
	
	public String getHouse () {
		return house;
	}
	
	public void setHouse(String house) {
		this.house = house;
	}
	
//	public String toString() {
//		return house;
//	}
	
	// 부모의 getMoney() 존재
	/*
	 * 	public int getMoney() {
		return money;
		}
	 */
	
	
	
	
	// 자식이 상속 받은 getMoney()을 다시 작성(재정의)
	
	// 오버라이딩 성립 조건
	// - 메소드 이름 동일
	// - 매개변수의 개수, 타입, 순서 동일
	// - 리턴 타입 동일
	// - private 메소드 오버라이딩 불가
	// - 접근 제어자는 부모와 같거나 넓은 범위러 변경 가능
	// - 예외처리는 부모와 같거나 좁은 범위로 예외처리 변경 가능
	
	
	
	@Override // 컴파일러에게 해당 메서드는 재정의 되었다는 것을 알려주는 컴퓨터용 주석
	// 주석을 적으면 오버라이딩 형식이 맞는지 검사를 진행해 줌
	public int getMoney() {
		System.out.println("자식이 오버라이딩한 getMoney()");
		return super.getMoney() + 500;
		// 부모의 getMoney() 반환값에 500원 추가
	}
	// 메서드 오버라이딩 시 자식이 우선순위를 가지게 된다
	//int edu.kh.inheratance.dto.Child2.getMoney() 부모로부터 재정의하면 자식이 우선순위를 갖게 됨
	
	
	
	
	
}
