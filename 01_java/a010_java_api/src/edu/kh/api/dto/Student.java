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
	
	// Object.hashCode();
	// -두 객체의 필드 ㄱ값이 같다면 hashCode()도 똑같은 정수 값을 반환해야 한다.
	// -hash 함수 : 입력 받은 문자열/숫자를 특정한 길이의 문자열/숫자로 변환
	// -> 최대한 중복되지 않는 숫자를 만들어 냄
	// -hashCode() : 객체의 필득 ㅏㅄ을 이용해서 일정한 길이의 숫자를 만드는 함수
	// 왜 필요한가? Java 실행 시 내부에서 객체 검색하는 속도를 증가
	// 어떻게 작성하는가?
	// 필드 값이 같으면 항상 같은 수가 나올 수 있도록 구현 + equals() 오버라이딩 시 필수적으로 같이 오버라이징
	
	@Override
	public int hashCode() {
		int result = 1; // 곱할때 아무 영향 없는 1로 초기화
		final int PRIME = 31; // 소수 (곱연산 시 속도가 빠름)
		
		result = result * PRIME + grade;
		result = result * PRIME + classRoom;
		result = result * PRIME + number;
		result = result * PRIME 
				+ (name == null ? 0 : name.hashCode()); 
		//name은 string이라 null이 될 수도 있음. null이면 null point error
		
		return result;
	}
	
	


}

