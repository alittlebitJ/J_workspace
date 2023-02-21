package edu.kh.inheratance.run;

import edu.kh.inheratance.dto.Child1;
import edu.kh.inheratance.dto.Child2;
import edu.kh.inheratance.dto.Parent;

public class TestRun {
	
	public static void main(String[] args) {
		
		// 부모, 자식 1, 2 객체 생성
		Parent p = new Parent(1000_000_000, "");
		
		Child1 c1 = new Child1("아반떼");
		Child2 c2 = new Child2("시그니엘");
		
		// 상속(extends) : 
		// - 부모 클래스가 가지고 있는 필드, 메서드를 
		// - 자식 클래스가 자신의 것 처럼 사용 가능하게 하는 기술
		
		
		System.out.println(c1.getMoney());
		System.out.println(c1.getLastName());
		
		System.out.println(c2.getMoney());
		System.out.println(c2.getLastName());
		// -> 부모의 메서드 상속 확인
		
		// System.out.println(c1.Money());
		// -> 부모의 private 접근 제한자는 상속을 받아도 직접 접근 불가능
		// -> 그래도 상속은 되어있는 상태 , private필드/메서드는 상속이 되어 있음/ 단, 자식도 접근만 못할 뿐이다 (private은 같은 클래스만 접근 가능)
		
		
		// 부모 클래스의 코드를 수정하면
		// 자식 모두에게 적용된다(공통적인 규약, 유지보수성 향상)
		
		
	}

}
