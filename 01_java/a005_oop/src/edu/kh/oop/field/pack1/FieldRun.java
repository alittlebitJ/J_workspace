package edu.kh.oop.field.pack1;
import edu.kh.oop.field.pack2.FieldTest2;
import edu.kh.oop.field.pack2.FieldTest3;

public class FieldRun extends FieldTest3{ // extends 구문 추가(상속 구문)

	public static void main(String[] args) {
		
		// 클래스를 이용해서 객체(인스턴스) 생성
		FieldTest1 f1 = new FieldTest1();
		FieldTest2 f2 = new FieldTest2();
		// FieldTest1/2는 FeildRun과 같은 패키지 -> import 없이 사용 가능
		
		FieldTest3 f3 = new FieldTest3();
		// FieldTest3는 다른 페키지에 있어서 에러->import 필요
	
		// 접근제한자 확인
		System.out.println(f1.v1); // public
		System.out.println(f1.v2); // protected 같은 패키지나 상속
		System.out.println(f1.v3); // (default) 같은 패키지
		//System.out.println(f1.v4); // private 다른 클래스
		// (The field FieldTest1.v4 is not visible) -> private은 다른 클래스에서 보이지 않음!/
	
		System.out.println(f2.v1);
		//System.out.println(f2.v2); // The field FieldTest2.v2 is not visible
		//System.out.println(f2.v3);
		//System.out.println(f2.v4);
		// 패키지가 다른 FeildTest2는 public만 접근 가능하고 나머지는 불가능
		
	}
	
	public void ex() { // 아직 fieldRun class 안에 있는데
		FieldTest3 t3 = new FieldTest3();
		System.out.println(t3.v1);
		//System.out.println(t3.v2); // he field FieldTest3.v2 is not visible
		// 상속은 했으나 사용법이 잘못됨
		System.out.println(v2); // 이렇게 사용해야 함
		// FeildRun이 FieldTest3를 상속 받음
		// ->상속을 받으면 FieldTest3의 필드를 FieldRun이 자기것처럼 사용 가능
		// private랑 default는 상속받아도 다른 패키지라 사용 불가, 그러나 protected는 다른 패키지라도 상속하면 사용 가능
	}
	
	
}
