package edu.kh.oop.method.run;

import edu.kh.oop.method.view.MethodExView;

public class MethodExRun {
	
	public static void main(String[] args) {
		
		// view 객체를 만들어 해당 화면을 보여달라고 호출할 것
		
		// MethodExView 객체를 생성(new연산자를 통해 메모리에 할당하라)해라
		//new MethodExView(); // <-자동 완성을 통해 import 됨
		// ()안에 아무것도 없는 생성자 : 기본 생성자
		// MethodExView 기본생성자를 작성한 적이 없는데 어떻게?
		// 생성자 미작성 시 컴파일러가 자동으로 기본 생성자를 추가하기 때문
		
		MethodExView view = new MethodExView();
		
		view.displayMenu();
		// 이게 무슨 의미인가
		// view가 참조하는 객체
		// '.'(점 연산자) : 하위 접근, 참조, view가 가지고 있는 기능이나 필드에 접근
		//참조하는 객체의 필드/메서드에 접근
		
		// view가 참조하는 객체의 기능 중 displayMenu() 메서드를 호출하겠다
		
		
		
		
		
		
	}

}
