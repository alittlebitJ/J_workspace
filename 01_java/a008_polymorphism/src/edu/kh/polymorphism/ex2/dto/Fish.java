package edu.kh.polymorphism.ex2.dto;

public class Fish extends Animal {

	
	private int fin; // 지느러미 개수
		
	public Fish() {}

	// 매개변수 생성자 alt + [shift] + s + o + select box에서 원하는 생성자 선택 ( 부모필드까지 초기화 가능)
	public Fish(String type, String eatType, int fin) {
		super(type, eatType);
		this.fin = fin;
	}

	// getter/setter
	public int getFin() {
		return fin;
	}

	public void setFin(int fin) {
		this.fin = fin;
	}

	// toString Overriding alt + [shift] + s + s
	@Override
	public String toString() {
		return "Fish [fin=" + fin + "]";
	}
	
	@Override
	public void breath() {
		System.out.println("아가미 호흡을 한다.");
	}
	
	
	
	
	
	
	
	
	
	
	
}
