package edu.kh.polymorphism.ex1.service;

import java.util.Scanner;

import edu.kh.polymorphism.ex1.dto.Car;
import edu.kh.polymorphism.ex1.dto.LightCar;
import edu.kh.polymorphism.ex1.dto.Truck;

public class CarService  {

	public void ex1() { // 클래스에선 함수호출이 불가능, 정의만 가능
		
	// 부모 참조 변수 = 부모 객체
	Car c1 = new Car();
	
	// [업캐스팅]
	// 자식 객체가 부모 객체로 변함(부모 참조 변수로 자식 객체 참조)
	// -> 자식객체 내부에 있는 부모객체를 참조하도록 변함
	Car c2 = new Truck(); // Truck 이 Car 가 되는 형식
	
	// 부모 참조 변수로 자식 객체 참조
	// LightCar의 주소를 c3에 넣겠다.
	// 근데 LightCar안에 Car가 있으니까, LightCar이자 Car가 됨. LightCar안에 있는 Car만 참조하겠다는 것. 문제x
	Car c3 = new LightCar(); // 
	
	// Truck 객체가 Car로 부터 상속받은 메서드 사용
	
	
	c2.setWheel(10);
	c2.setSeat(3);
	c2.setFuel("경유");
	
	// c2의 자료형이 Truck 내부의 Car 부분을 참조
	// -> Truck 객체를 통해 참조하더라도 Car 부분만 볼 수 있음
	//c2.getWeight(2.5); <-에러 (Car클래스가 아니라 Truck의 필드에 있어서 c2로 접근 불가능
	
	
	
	}
	
	
	
	
	public void ex2() {
		
		// [다운캐스팅]
		// 부모객체가 자식객체로 변함
		
		
		// 부모 참조 변수 = 자식 객체(업캐스팅)
		Car c1 = new LightCar();
		
		/*
		c1.print();
		c.getDiscountOffer();
		부모 클래스엔 이 함수가 없으니까 안 됨
		*/
		
		
		// LightCar로 c1을 강제 형변환
		// -> c1이 LightCar 객체를 모두 참조 가능
		// -> 다운 캐스팅
		((LightCar)c1).pirnt(); // <- 참조하고 있던게 부모에서 자식으로 바뀜
		
		((LightCar)c1).setDiscountOffer(0.7);
		System.out.println(((LightCar)c1).getDiscountOffer() );

		
		// 다운 캐스팅의 다른 사용법
		// 다운 캐스팅 + 얕은 복사(주소만 복사) 
		LightCar light1 = (LightCar)c1; // LightCar을 참조하는 c1의 주소를 light1에 입력
		
		light1.pirnt(); // 좀 더 쉽게 작성 가능
		
	}
	
	
	
	public void ex3() {
		// 다형성(업캐스팅, 다운캐스팅) + 객체 배열
		
		
		// Car 1차원 배열 = Car 참조변수의 묶음
		Car[] carList = new Car[3];
		
		// carList[i] = Car 참조변수
		carList[0] = new Truck(6, 4, "경유", 1); // 업캐스팅
		carList[1] = new LightCar(4, 4, "휘발유", 0.3);
		carList[2] = new Car(4, 2, "전기차");
		
		// 향상된 for문 (배열 요소 순차 접근)
		for(Car c : carList) {
			System.out.println("바퀴 수 : " + c.getWheel());
			System.out.println("좌석 수 : " + c.getSeat());
			System.out.println("연료 형식 : " + c.getFuel());
			
			// Truck일 경우 -> 최대 적재 하중 : 2.5 t
			// LightCar일 경우 -> 할인율 : 30%
			// Car일 경우 -> 차종이 등록되어있지 않습니다.
			
			
			/* instanceof 연산자 */
			// - 참조하는 객체의 타입을 검사하는 연산자
			// - ex) 참조변수 a instanceof 클래스명 → 참조변수가 참조하는 객체 타입과 클래스의 타입이 일치하면  true
			
			if( c instanceof Truck) {
				// c가 참조하는 객체가 truck 객체인 경우?
				System.out.println("최대 적제 하중 : " + ((Truck)c).getWeight());
				// 만약 다운 캐스팅이 잘못될 경우 ClassCastException이 발생한다
				// ex) LightCar 객체가 상속관계가 아닌 Truck 참조변수를 참조하려고 할 때
				// 해결 방법 : instanceof를 통해 참조하는 객체의 자료형을 판단하여 적절한 형식으로 다운캐스팅 진행
				
			} else if ( c instanceof LightCar) {
				System.out.println("할인율 : " + ((LightCar)c).getDiscountOffer()*100 + "%");
			}
				// c가 참조하는 객체가 truck, LightCar가 아닐 때
			else System.out.println("차종이 등록되어있지 않습니다.");
			
			System.out.println("======================================");
			
			
		}
		
	}

	
	
	
	public void ex4() {
		// 객체배열 + 다형성(업캐스팅/다운캐스팅) + instanceof 
		// + 매개변수 다형성 + 바인딩(정적/동적)
		
		// Car 1차원 배열 = Car 참조변수의 묶음
		Car[] carList = new Car[3];
		
		// carList[i] = Car 참조변수
		carList[0] = new Truck(6, 4, "경유", 1); // 업캐스팅
		carList[1] = new LightCar(4, 4, "휘발유", 0.3); // 업캐스팅
		carList[2] = new Car(4, 2, "전기차");
		
		//printCar(new Truck()); // 부모타입의 참조변수(아래 Car c/printCar의 매개변수)에 Truck의 주소가 저장이 된다. 
		
		
		for(Car c : carList) {
			// printCar(Car 객체 주소 또는 Car를 상속받은 객체 주소)
			printCar(c);
		}
		
	}
	
	
	
	// 차량 정보를 출력하는 메서드
	public void printCar(Car c) { // 부모 타입의 참조형 변수 
		String type = null;
		
		// 매개변수로 전달 받은 c가 참조하는 객체에 따라서 type의 값을 지정
		if (c instanceof Truck) type = "[Truck]";
		else if (c instanceof LightCar) type = "[LightCar]";
		else type = "[Car]";
		
		System.out.println(type + "에 대한 정보입니다.");
		System.out.println(c.toString());
		// 셋 다 ToString을 오버라이딩해서 가지고 있는 상태. 그러면 어느 toString이 호출될까? 
		//-> Car의 toString이라고 마우스를 데면 뜨는데(String edu.kh.polymorphism.ex1.dto.Car.toString()) <-정적 바인딩
		// 각자의 toString이 실행된다. 왜? 바인딩 때문에
		// car에서 실행해서 car타입 자료형을 쫓아가봤더니 사실 Truck이었다. 여기서 Truck내부의 car에 들어가지 않아도 truck 내부에 toString이 있으니 truck의 toString을 참조
		// overriding에서 자식오버라이딩이 우선적인것은 동적바인딩 때문
		
		/* [바인딩]
		 * 메서드 호출 구문과 수행될 메서드를 연결하는 것 (묶는 것)
		 * 
		 * [정적 바인딩]
		 * - "프로그램 실행 전" 컴파일 단계에서 매서드 호출부와 수행될 메서드를 묶는 것
		 * - 참조변수의 자료형(type)을 기준으로 연결함
		 * 
		 * [동적 바인딩]
		 * - "프로그램 실행 중" 실행 할 당시 객체의 자료형(type)을 기준으로 메서드 호출부와 수행될 메서드를 묶는 것
		 * - 참조하는 객체의 자료형을 기준으로 연결함
		 */
		// 동적바인딩은 코드에서 티(에러표시)가 안 남, 예측을 잘 해야 함
		
		
		// 출력 화면 예상
		/* [Truck]에 대한 정보입니다.
		 * [LightCar]에 대한 정보입니다.
		 * [Car]에 대한 정보입니다.
		 */
		
		// 만약 car에 있는 toString만 나오게 하고 싶다면?
	
	}
	
	
	public void ex5() {
		// 반환형의 다형성
		Scanner sc = new Scanner(System.in);
		
		System.out.println("생성할 자동차 종류를 선택하세요");
		System.out.println("1. 트럭");
		System.out.println("2. 경차");
		System.out.println("3. 자동차");
		
		Car c = createCar(sc.nextInt());
		
		System.out.println("차가 생성되었습니다.");
		
	}
	
	// 반환형에 다형성(업캐스팅) 적용
	public Car createCar(int num) {
		
		switch(num) {
		
		case 1 : return new Truck();
		case 2 : return new LightCar();
		case 3 : return new Car();
		}
		
		return null;
	}

	
	
	
}
