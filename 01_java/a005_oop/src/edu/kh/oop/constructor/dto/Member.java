package edu.kh.oop.constructor.dto;

public class Member { //+기호(public)
	
	// 추상화를 통해
	// 필드(멤버 변수) 생성
	
	// 인스턴스 변수
	private String memberId; //-기호(private)
	private String memberPw;
	private String memberName;
	private int memberAge;

	
	/*
	 * 원래 null/null/null/0으로 초기화 되어짐(Heap영역엔 빈 값으로 있을 수 없기 때문에)
	 */
	
	// 초기화 블럭 : 필드를 초기화(값 대입)하는 목적의 블럭<- {}로 열고닫는 것을 블럭이라 칭한다
	

	// 인스턴스 초기화 블럭 : 인스턴스 변수를 초기화 하는 블럭
	{
		memberId = "mem1"; 
		memberPw = "1234";
		memberName = "고길동";
		memberAge = 40;
		//programName = "회원관리 프로그램"; 
		// 인스턴스 초기화 블럭인데, 클래스 변수를 초기화 시켜도 작동하긴 함
		// 그렇지만 실행시 비효율적인 과정이 추가됨
	}
	
	
	// 클래스 초기화 블럭 : 
	// - 프로그램 실행 시 static 변수를 초기화 하는 용도의 블럭
	// - 프로그램 실행 시 1회만 수행됨
	static {
		programName = "회원관리 프로그램"; 
	}
	
	
	
	// 클래스(static) 변수 <-이탤릭체로 변함
	public static String programName;
	
	
	
	// ----기능----
	// 생성자 : 객체를 생성하는 기능
	// 생성자 작성 규칙
	// 1. 반환형(void, int, String...)이 없다
	// 2. 생성자명은 클래스와 동일
	
	// 기본 생성자, ()안에 아무것도 없음
	public Member() { 
	
	
	/******************************************************************
	 * 클래스 내에 아무런 생성자도 작성되지 않은 경우 컴파일러가 자동으로 기본생성자를 추가해준다!
	 * 
	 * 단, 기본 생성자만 없고 다른 매개변수 생성자가 존재하면 컴파일러는 자동으로 기본 생성자를 추가하지 않는다!
	 * 
	 * public Member(){} <-이런 코드를 추가해붐
	******************************************************************/
//	
		// 객체 생성 시 특정 기능 수행
		System.out.println("기본 생성자로 생성됨.");
		// 객체 생성 시 필드 초기화
		memberId = "user1"; 
		memberPw = "1q2w3e4r";
		memberName = "홍길동";
		memberAge = 25; //우선순위가 생성자가 제일 높음
		
	}
	
	
	// 매개변수 생성자
	// - 객체 생성 시(생성자 호출 시) ()안에 객체의 필드를 초기화할 값을 전달 받는 생성자
	public Member(String memberId, String memberPw, String memberName, int memberAge) { // 네모박스 네 개를 만들었다고 생각
		
		// Member() 생성자를 호출하고 싶으면 ()안에 String String String int 네 개를 작성해라
		System.out.println("매개변수 생성자(String,String,String,int)로 생성");
		
		// 전달 받은 값을 필드에 대입
		// this.(this 참조 변수)
		// - 모든 인스턴스에 숨겨져있는 필드로 현재 인스턴스(객체)의 시작주소가 저장되어있어, 현재 인스턴스를 참조함(가리킴)
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberAge = memberAge;
	}
	// **오버로딩**
	// 클래스 내에 동일한 이름의 메서드를 여러 개 작성하는 기법
	// 오버로딩 조건
	// 1. 메서드(생성자) 이름이 같아야 한다
	// 2. 매개변수의 자료형||개수||순서 중 하나라도 달라야 한다
	
	//public Member(String memberId) {} // 오버로딩 성립
	public Member(String memberId, String memberPw) {} // 오버로딩 성립 (개수)
	public Member(String memberId, int memberAge) {} // 오버로딩 성립 (타입)
	public Member(int memberAge, String memberId) {} // 오버로딩 성립 (순서)
	//public Member(int memberAge, String memberName) {} // 개수, 타입, 순서가 같아서 오류. 변수명이 아닌 자료형을 신경써야 한ㄴ다
	
	public Member(String memberId) {
		
		this(); // 현재 클래스의 기본 생성자를 호출
		// -> this() 생성자
		// -> 중복 제거, 코드 길이 감소를 위해서 사용
		this.memberId = memberId;
	
		
	}
	
	
	
	// 일반 기능(메서드)
	public void ex1() {
		
	}
	
	public void ex1(String name) {
		
	}
	
	// 기능(메서드)에서만 이름의 중복을 허용
	// 매개변수의 개수 또는 타입, 순서가 달라야

	}
