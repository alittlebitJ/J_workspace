// 세미콜론 잘 찍었는지
// 오타는 없는지

package edu.kh.variable;

// class 자바 코드 작성 영역
public class VariableEx2 {

	// main method : 자바 코드 실행을 위한 구문
	public static void main(String[] args) {

		// System.out.println("확인"); // 한 줄 출력
		// 실행 : 단축키 ctrl+f11 또는 위에 있는 >(run) 버튼

		// 변수 : 메모리에 값을 저장하기 위한 공간
		// 변수 선언 : 메모리에 값을 저장할 공간을 할당(이 변수를 위해 이만큼의 메모리를 소모하겠다)
		// 자료형 : 변수의 종류 지정(크지, 형식에 따라 다름)
		/* 기본 자료형 : 8가지
		 * 논리형 : boolean (1byte) 
		 * 정수형 : byte (1byte) short (2byte) int (4byte, 정수의 기본형) long (8byte) 
		 * 실수형 : float(4byte, 소수점 아래 8자리) double(8byte, 소수점 아래 10자리, 정확도가 더 높아 실수 기본형)
		 * 문자형 : char (2byte, 유니코드UTF-16)
		 */
		
		boolean booleanData;
		// 앞쪽이 자료형, 뒤쪽이 변수명
		// 논리형 데이터(true/false)를 저장할 공간 1byte를 메모리에 할당하고
		// 그 공간을 booleanData라고 부르겠다
		
		int number1;
		// 정수형 데이터를 저장할 공간 4byte를 메모리에 할당하고
		// 그 공간을 number1라고 부르겠다
		
		double number2;
		// 실수형 데이터를 저장할 공간 8byte를 메모리에 할당하고
		// 그 공간을 number2라고 부르겠다
		
		char ch;
		// 문자형 데이터를 저장할 공간 2byte를 메모리에 할당하고
		// 그 공간을 ch라고 부르겠다
		
		
		
		
		// 변수에 값 대입하기 : 생성한 변수에 값을 저장(대입)하는 것
		// 작성법 : 변수명 = 값;
		// = 기호 : 대입 연산자(오른쪽 값을 왼쪽 변수에 저장)
		
		booleanData = true;
		//number1 = 123456.789; <-에러남. int형 변수 number1에 실수를 저장할 수 없기 때문
		number1 = 123456789;
		number2 = 9.8765454321;
		// ch = 'aa'; <-에러남. char형 변수 ch에 문자를 하나 이상 저장할 수 없기 때문
		ch = 'A';
		
		
		System.out.println("[값 대입 결과 확인]");
		System.out.println(booleanData);
		System.out.println(number1);
		System.out.println(number2);
		System.out.println(ch);
		
		// 변수에 대입된 값 변경
		ch = '하';
	
		
		System.out.println("[ch 값 변경]");
		System.out.println(ch);
		
		
		
		// 리터럴 : 직접 작성한 값 또는 변수에 대입되는 값
		
		// **자료형별로 리터럴을 표기하는 방법이 별도로 존재 **
		// int : 10, -50, 0 (기본 정수 표기법)
		// long : 2147483648L, 0L, -10L (l or L을 붙여야)
		// double : 3.14, -123.456, 0.0 (기본 실수 표기법, 무조건 실수형태로)
		// float : 3.14f, -123.456f, 0.0f (f or F 를 붙여야)
		// boolean : true, false (이 두 개가 아니면 무조건 에러)
		// char : '가', Z' (홑따옴표)
		//         또는 0 ~ 65535 사이 정수로도 표현 가능
		// byte, short : 10, 0, -312 (int와 동일)
		// 왜? byte, short는 옛날 코드와의 호환을 위해 만들어진 자료형. 사용 빈도가 몹시 낮아 별도의 리터럴 표기법을 제작하지 않음. 임시로 int 표기법 사용
		
		
		
		long number3 = 10000000000L; //100억 int는 21억 정도밖에 표기 못 함
		// L을 붙이지 않으면 int 표기법으로 인식되어
		// 100억이 int로 해석되어짐 -> int의 범위 약 21억을 초과하여 오류 발생
		
		float number4 = 1.23f; // 1.23은 double의 표기법으로 인식되어, float형 변수에 저장할 수 없어서 오류 발생 -> f를 붙여서 해결
		
		byte number5 = 100;
		short number6 = 200;
		// byte, short는 int표기법 사용
		
		System.out.println("[리터럴 확인]");
		System.out.println(number3);
		System.out.println(number4);
		System.out.println(number5);
		System.out.println(number6);
		// 출력 시 리터럴 표기법은 생략됨
		
		
		// 컴퓨터는 0과 1로만 저장을 하기 때문에, 문자표를 인위적으로 만들어서 숫자를 문자형으로 바꾸는 약속을 한다.
		// ex) char 자료형 0 -> A로 표현이 됨
		// char 자료형은 정확히는 정수를 저장하는 정수형
		// 다만, 정수를 저장하고 있다가
		// 화면에 출력 시 문자표에 대응되는 문자가 출력된다(이 과정을 인코딩이라 한다. 반대의 과정은 디코딩이라고 함)
		// 교재 52p 'char 자료형 특징' 참고
		
		char test1 = 'A';
		char test2 = 65;
		// char 변수를 선언과 동시에 초기화
		
		System.out.println("[char 특징 확인]");
		System.out.println(test1);
		System.out.println(test2);
		
		
		
		
		
		
		
		
	}

}
