package edu.kh.api.dto;

public class Student {
	
	
	private int grade;
	private int classRoom;
	private int number;
	private String name;
	
	// 기본 생성자
	public Student() {
		super();
	}
	
	// 매개변수 생성자
	public Student(int grade, int classRoom, int number, String name) {
		this.grade = grade;
		this.classRoom = classRoom;
		this.number = number;
		this.name = name;
	}
	
	// getter/setter
	public int getGrade() {
		return grade;
	}
	
	public int getClassRoom() {
		return classRoom;
	}
	
	public int getNumber() {
		return number;
	}
	
	public String getname() {
		return name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public void setClassRoom(int classRoom) {
		this.classRoom = classRoom;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	
	
	// toString overriding
	@Override
	public String toString() {
		return String.format("%d / %d / %d / %s", grade, classRoom, number, name);
	}
	
	
	// Object.equals() 오버라이딩 방법
	// 현재 객체와 다른 객체가 동등(필드 값이 같은지) 비교
	// 왜 오버라이딩 하느냐? Object는 필드값이 없기 때문. 필드를 가지고 있는 자식 클래스가 알맞은 형태로 재정의(오버라이딩)할 필요가 있다
	@Override
	public boolean equals(Object obj) {
		
		// 1. 같은 객체인가
		// 같은 객체(주소)를 참조하는 경우 확인 
		if(this == obj) return true;
		
		// 2. null값인가
		// null인 경우 비교 자체가 불필요
		if(obj == null) return false; 
		
		// 3. 객체가 같은 분류인가
		// 비교를 위해 전달 받은 객체가 Student가 맞는가?
		if (!(obj instanceof Student)) return false; // Student가 아닌 경우에 실행
		
		// 4. 필드값 비교
		// 필드 비교
		Student other = (Student)obj; //obj 다운 캐스팅. Object가 최상위 클래스라 필드값을 못 가져옴
		if(this.grade != other.grade) return false; // <-같은 class라 getGrade가 아닌 그냥 grade를 가져올 수 있음
		if(this.classRoom != other.classRoom) return false;
		if(this.number != other.number) return false;
		if(!(this.name.equals(other.name))) return false;
		
		// 5. 모든 필드가 같을 경우
		return true; // 모든 필드가 같을 경우
	}
	
	
	


}

