package edu.kh.oop.method.dto;

// DTO (Data Transfer Object) : 값 전달용 객체
// 마트의 카트같은 역할


public class User {

	// 필드
	// 아이디, 비밀번호, 이름, 성별(M/F)
	
	// private : 외부 접근 차단 (캡슐화 원칙 적용)
	private String userId;
	private String userPw;
	private String userName;
	private char userGender;
	
	
	// 생성자
	// 기본 생성자
	public User() {}
	
	// 매개 변수 생성자(오버로딩 적용)
	// 주된 목적 = 전달 받은 매개 변수로 필드를 초기화 하기 위해
	public User(String userId, String userPw, String userName, char userGender) {
		
		// this 참조변수 : 생성되는 객체(자기 자신)를 참조
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userGender = userGender;
				
	}
	
	
	
	// 메서드
	
	// toString : 객체가 가지고 있는 모든 필드값을 하나의 문자열로 표기하여 반환
	// Arrays.toString(arr) <- 배열이 가지고 있는 값을 하나의 문자열로 표기하여 반환
	public String toString() { 
		return String.format("%s / %s / %s / %c", userId, userPw, userName, userGender);
	}
	
	
	// getter / setter 작성
	// -> 캡슐화 원칙에 의해 직접 접근이 차단된 필드와, 데이터 교환을 할 수 있는 기능(간접 접근 방법)
	
	// getter 작성법 (외부에서 필드값을 얻어 갈 수 있게 하는 방법)
	/*public 반환형 get필드명() {}
		return 필드명; */
	
	public String getUserId() { // <- 카멜 표기법으로 인해 U를 대문자로 적어줌
		return userId;
	}
	public String getUserPw() { 
		return userPw;
	}
	public String getUserName() { 
		return userName;
	}
	public char getUserGender() { 
		return userGender;
	}
	
	
	// setter 작성법 (외부에서 값을 전달해 필드 값을 설정할 수 있게)
	/* public void set필드명(자료형 필드명) { <-매개변수 생성자와 유사한데 하나씩 가져옴
		this.set필드명 = 필드명;
	} */
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void setUserGender(char userGender) {
		this.userGender = userGender;
	}
	
}
