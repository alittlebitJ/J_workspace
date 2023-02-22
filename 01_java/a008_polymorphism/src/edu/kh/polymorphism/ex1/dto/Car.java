package edu.kh.polymorphism.ex1.dto;

public class Car extends Object {
	
	private String fuel; //연료

	private int seat;  // 좌석의 수
	// 필드
	private int wheel; // 바퀴 개수
	
	// 생성자
	public Car() {}

	public Car(int wheel, int seat, String fuel) {
		super();
		this.wheel = wheel;
		this.fuel = fuel;
		this.seat = seat;
	}
	
	// alt + shift + s
	// alt + shift s
	// 생성자 단축키


	// atl + shift + r
	// getter setter 단축키

	public String getFuel() {
		return fuel;
	}
	
	public void setFuel(String fuel) {
		this.fuel = fuel;
	}
	
	public int getSeat() {
		return seat;
	}
	
	public void setSeat(int seat) {
		this.seat = seat;
	}
	
	public int getWheel() {
		return wheel;
	}
	
	public void setWheel(int wheel) {
		this.wheel = wheel;
	}
	
	// Object.toString() 오버라이딩
	@Override
	public String toString() {
		return String.format("%d / %d / %s", wheel, seat, fuel);
	}


}
