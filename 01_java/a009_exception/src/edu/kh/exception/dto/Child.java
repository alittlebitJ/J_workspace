package edu.kh.exception.dto;

import java.io.EOFException;
import java.io.IOException;

public class Child extends Parent {
	
	@Override
	public void test() throws EOFException{ 
		// 오버라이딩 시 예외처리는 같거나 좁은 범위
		// Exception(넓은 범위) : 에러 메세지 뜸 'Exception Exception is not compatible with throws clause in Parent.test()'
		// IOException(같은 범위) : 문제 없음
		// EOFEception(좁은 범위) : 문제 없음
		
		System.out.println("자식 test()");
	}

}
