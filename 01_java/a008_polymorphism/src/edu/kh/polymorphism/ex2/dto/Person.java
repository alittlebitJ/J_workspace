package edu.kh.polymorphism.ex2.dto;

public class Person extends Animal{ 
	// 'Person'에서 에러 : 추상클래스 상속 시 abstract 메서드도 상속됨. 그러나 이 메서드는 미완성 상태임으로 빨리 이 메서드를 구현(오버라이딩)하라고 에러 발생
	// The type Person must implement the inherited abstract method Animal.breath() 
	
	private String name;
	private int age;
	
	
	public Person () { // 기본 생성자

	}
	
	public Person(String type, String eatType, String name, int age) { // 매개변수 생성자
		super(type, eatType); // 부모의 매개 변수 생성자 호출
		this.name = name;
		this.age = age;
	}

	
	// getter/setter 단축키 alt + [shift] + s + r
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
	// toString alt + [shift] + s + s
	@Override
	public String toString() {
		// super : 부모 참조 변수
		return super.toString() + " / " + name + " / " + age;
	}
	
	
	// 상속 받은 추상 메서드 강제 구현(오버라이딩)
	@Override
	public void breath() {
		System.out.println("코와 입으로 숨을 쉰다.");
	}
	

}
