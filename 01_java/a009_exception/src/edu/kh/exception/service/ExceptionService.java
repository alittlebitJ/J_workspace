package edu.kh.exception.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionService {

	
	public void ex1 () throws IOException  { // 해당 메서드 내에서 IOException이 발생할 것을 대비한 예외처리 코드
		// throws : 호출한 곳으로 떨린다
		
		// 예외(Exception) 확인 하기
		
		// 키보드 입력(System.in)을 효율적으로 읽어오는 객체
		// Scanner보다 기능은 부족하지만 속도는 빠름
		BufferedReader Br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("입력 :");
		String input = Br.readLine(); 
		// readLine() : 한 줄 읽어오기(엔터 까지)
		// 왜 빨간줄이 뜰까?? Unhandled exception type IOExceptio
		// -realLine() 메서드는 IOException이라고 하는 예외를 발생시킬(throw) 가능성이 있기 때문에,
		// 그 상황에 대한 대비책(예외처리)을 하라고 경고하는 것
		System.out.println("입력값 : " + input);
		
		
		// chekced Exception
		// 컴파일 단계에서 예외가 발생할 가능성이 있는지 반드시 확인해야 하는 예외
		// 무조건 예외가 날 것이라고 예상하고 코드를 짜야 한다
		// → 공식 API 문서의 설명에 throws 000Exception으로 작성되어 있는 메서드가 있으면, 
		// 해당 코드 사용 시 문제가 발생할 것이라고 생각하고 그 상황에 대한 예외 처리 코드를 꼭 작성해야 함
		
		
		// Unchecked Exception : 
		// 컴파일 단계에서 예외가 발생할 가능성이 있는지 확인하지 않는 예외
		// -> 개발자의 부주의로 나타나는 예외
		// --> 대부분 쉽게 해결 가능(ex. if문)
		// ---> 치명적인 문제가 아님
//		System.out.println(5/0);
//		
//		int[] arr = new int[4];
//		System.out.println(arr[10]);
//		
//		String s = null;
//		System.out.println(s.equals("bbb"));
		
		
	}
	
	public void ex2() {
		// 예외(Exception) : 코드 수정으로 해결 가능한 에러
		// 예외 처리 : 예외를 처리할 수 있는 구문 입력
		
		
		// [예외 처리 1 : try catch ~ finally]
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// try : {}내부에 예외가 발생할 것 같은 코드를 작성하고 실행을 시도 / 만약 예외 발생 시 새로 발생한 예외 객체(new IOException)가 던져짐
		try {
			
			System.out.print("입력 : ");
			String input = br.readLine();
			// public String readLine() throws IO Exception
			// -> IOException 이라는 checked Exception을 발생 시키는 메서드
			// 	-> Exception이 발생할 경우에 대비해서 예외처리 구문 작성(강제)
			
			/* 예외 강제 발생 */
			// -> 예외 객체를 새로 만들어서 던짐
			throw new IOException(); 
			
		} catch (IOException e) { 
			// catch : try 구문 내에서 던져진 예외가 있을 경우, 해당 예외 객체를 잡아채서 catch 구문을 수행해 처리. 
			// catch의 매개 변수에는 던져진 예외 객체를 저장할 수 있는 참조 변수를 작성
			System.out.println("키보드 문제로 입력을 진행할 수 없습니다.");
			
			// 발생된 예외가 처리된 후 프로그램이 종료되지 않고 다음 코드가 수행됨
		}
		
		System.out.println("try-catch가 수행되어도 프로그램이 종료 되지 않음");
	}
	
	
	
	
	public void ex3() {
		// 입력 받은 두 정수 나누기
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.print("정수1 : ");
			int num1 = sc.nextInt();
			System.out.print("정수2 : ");
			int num2 = sc.nextInt();
			
			System.out.printf("%d / %d = %d\n", num1, num2, num1 / num2);
			
//		} catch(Exception e) { // 산술적 예외
//			System.out.println("0으로 나눌 수 없습니다.");
			// 이러면 Unreachable catch block for ArithmeticException. It is already handled by the catch block for Exception 에러 메세지
			// 해결방법 : 상위 타입 catch를 뒤쪽에 배치해서 하위 타입 catch에 대한 검사가 먼저 진행되게 한다
			// 			굳이 상위 타입 catch를 쓸건데 하위 타입 catch를 앞에 쓰는 이유? 
			// 어떤 에러인지 구분하기 위해 하위 타입 catch를 먼저 처리해주고, 뭔지 모르겠는데 예외가 발생할 경우를 대비해 마지막에 상위 타입 catch를 써주는 편

		} catch(ArithmeticException e) { // 산술적 예외
			System.out.println("0으로 나눌 수 없습니다.");
			
		} catch(/*InputMismatch*/Exception e) {
			/* catch문 여러 개 작성 가능*/
			
			/* 다형성 적용 가능 (업캐스팅)*/
			// 상위 타입 예외를 매개변수로 작성하면, 하위 타입의 예외를 모두 처리할 수 있다.
			// !!!!!!!!!!!!!주의사항!!!!!!!!!!!!! 
			// - 상위 타입을 처리하는 catch문을, 하위 타입을 처리하는 catch문 보다 먼저 작성하면 오류 발생 (100번째 줄 참고)
			
			// 스캐너 사용 시 작성법이 잘못되거나 범위를 초과하면 발생하는 예외
			System.out.println("입력이 잘못되었습니다.");
			
		} finally { 
			// finally : 마지막으로
			// try~catch 구문이 끝난 후 마지막으로 수행
			// ** 예외가 발생 하든 말든 무조건 실행 **
			System.out.println("프로그램 종료");
		}
		
	}
	
	
}
