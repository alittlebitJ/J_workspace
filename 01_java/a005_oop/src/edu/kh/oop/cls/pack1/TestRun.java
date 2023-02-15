package edu.kh.oop.cls.pack1;
import edu.kh.oop.cls.pack2.Test2;


public class TestRun {

	
	public static void main(String[] args) {
	
		// Test1 클래스를 이용해서 객체 생성
		// new Test1(); <- 객체를 만든다 (Heap영역에서만 생김. 주소가 생김. 단 이를 참조받는 부분이 필요, 누가 얘를 참조 안 하면 3초뒤에 사라짐)
		// 그래서 new Test1을 참조하는 변수를 선언해주는 것
		Test1 t1 = new Test1();
		
		Test2 t2 = new Test2();
		// 에러 발생
		// Test2 접근제한자가 default이기 때문에(같은 패키지에서만 쓸 수 있기 때문에)
		// test2 클래스 앞에 public을 붙이고 import를 해주면 됨
		
		t1.testMethod1();
		t2.testMethod2();
	}
	
	
}

class Test3 {// 하나의 .java 파일에 여러 class 작성 가능 
	
	// 내부 클래스 (class 안에 class를 또 쓰는 것 가능)
	class Test4{
		// test3 안에서만 사용 가능
		// 안드로이드 개발시 주로 사용. 웹 개발때는 잘 사용 안 함
		
	}
	
	
}