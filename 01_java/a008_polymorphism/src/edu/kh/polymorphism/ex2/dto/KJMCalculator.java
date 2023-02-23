package edu.kh.polymorphism.ex2.dto;

// 각자 계산기 구현하기
public class KJMCalculator /*extends Person도 implements랑 같이 넣는거 가능*/ implements Calculator, Kh{ 
	// 인터페이스는 다중 상속이 가능
	// 만약 Calculator와 Kh둘 다 a라는 메서드를 가지고 있다면, a를 오버라이딩 할 수 없다(누구의 a인지 알 수 없기 때문에)

	@Override
	public int plus(int a, int b) {
		return a + b;
	}

	@Override
	public int minus(int a, int b) {
		return a - b;
	}

	@Override
	public int multiple(int a, int b) {
		return a * b;
	}

	@Override
	public int divide(int a, int b) {
		return a / b;
	}

	@Override
	public double divide2(int a, int b) {
		return (double)a / b;
	}

	@Override
	public double areaOfCircle(double r) {
		return Calculator.PI*r*r; // 상속받은 PI를 자식이 자기것처럼 사용 가능하기 때문에, calculator생략 가능
	}

	@Override
	public int square(int a, int x) {
		int J = 1;
		for(int i=1; i<=x; i++) {
			J *= a;
		}
		return J;
	}

	@Override
	public void lesson() { // Kh의 메소드
		// TODO Auto-generated method stub
		
	}
	
	
	

}
