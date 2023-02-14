package edu.kh.oop.basic;

// 현실에서의 객체 : 속성(Data)과 기능(method)을 가지고 있는 식별 가능한 것

// 클래스 : 객체의 특성(속성, 기능)을 정의한 것
//		  일종의 설계도 -> 설계도 자체(클래스)는 객체가 아니다
//		  -> 하나의 설계도(클래스)로 여러 객체를 만들 수 있다
public class Nation {
	
	// 국민이라면 가지고 있어야 하는 공통된 속성(Data)
	
	
	private String pNo;  // 주민등록번호
	// [캡슐화] 두 번째 특징(원칙)
	// 멤버변수는 private으로 지정
	
	
	/*속성 <- 멤버 변수, instance변수*/ 
	String name; // 이름
	char gender; // 성별(남/여)
	String address; // 주소
	String phone;
	int age; // 나이
	
	// 추상화 과정을 거쳐 (공통점)만 추출, 붎필요한 요소는 제거)
	
	// 국민이라면 가지고 있어야 하는 공통된 기능(method)
	public void speakKorean () {
		System.out.println("가나다라 한국말 가능");		
	}
	
	public void medicalBenefits() {
		System.out.println("의료 혜택을 받을 수 있다");
	}
	
	// [캡슐화] 두 번째 특징(원칙)
	// private으로 지정된 멤버 변수에 대한
	// 간접 접근 방법(기능)을 작성
	public String getpNo() { //getter : 외부에서 내부 데이터를 얻어가는 방법
		return this.pNo;
	}
	
	public void setpNo(String pNo) { //setter : 외부에서 내부 데이터를 설정하는 방법
		this.pNo = pNo;
	}
	
	
	
} // 클래스 내에 객체의 속성, 기능을 묶어놓음 <- [캡슐화] 첫 번째 특징
// BasicRun파일에서 Nation에 있는 주민등록번호, 전화번호와 같은 개인정보를 무단으로 쓰고 있음 ->private을 통해 접근 제한 : [캡슐화] 두 번째 특징 




