package edu.kh.polymorphism.ex2.dto;


// 추상 클래스
// - 추상 메서드가 포함된 클래스
// 단, 추상 메서드가 없어도 추상 클래스가 될 수 있다 (이 클래스를 객체로 만들고 싶지 않을 때 사용 : 의미적으로 객체가 될 수 있는지 개발자가 판별해야 한다)
public abstract class Animal extends Object { // 'extends Object' 미작성시 컴파일러가 자동으로 추가
	// 추상화, 캡슐화 필요
	
	
	
	// 필드
	private String type; // 종(양서류, 포유류, 파충류 등등)
	private String eatType; // 식성(초식,육식,잡식)
		
	
	// 생성자
	public Animal () { // 기본 생성자 (다른 생성자가 존재하지 않는다면, 컴파일러가 기본 생성자를 자동적으로 입력)
	super(); // 부모 생성자 호출. 미작성시 컴파일러가 자동으로 추가
	}
	
	
	public Animal (String type, String eatType) { // 매개변수 생성자 (전달받은 매개변수로 필드 초기화를 하는데 자주 사용)

		this.type = type;
		this.eatType = eatType;
		
	}
	
	
	// 메서드
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getEatType() {
		return eatType;
	}
	
	public void setEatType(String eatType) {
		this.eatType = eatType;
	}
	
	
	// String Object.toString()
	// - 객체가 가지고 있는 필드를 하나의 문자열로 반환하는 용도의 메서드
	// 	 (자식이 오버라이딩해서 사용하길 권장)
	// - 오버라이딩을 하지 않을 시 -> '패키지명+클래스명@해시코드' 문자열 반환
	
	public String toString() {
		return type + " / " + eatType;
	}

	// 추상 메서드 (미완성된 메서드)
	// -> 상속받은 자식 클래스에서 반드시 오버라이딩을 해야 한다(오버라이딩 강제화)
	// --> 추상 메서드를 포함한 클래스는 반드시 abstract class 여야만 한다
	public abstract void breath(); { // 에러 : abstract class가 아니기 때문, 위의 class를 abstract로 바꿔주면 해결
		
	}


	
	
}
	
