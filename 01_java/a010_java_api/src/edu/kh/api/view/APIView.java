package edu.kh.api.view;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;


import edu.kh.api.dto.Student;
import edu.kh.api.service.APIService;

public class APIView {

	private Scanner sc = new Scanner(System.in);
	private APIService service = new APIService();

	public void displayMenu() {

		int input = 0;

		do {
			System.out.println("--- API 테스트 프로그램 ---");
			System.out.println("1. equals() + hashCode");
			System.out.println("2. String 클래스 제공 메서드1(split)"); // 김영희만 나옴
			System.out.println("3. String 클래스 제공 메서드2(join)");
			System.out.println("4. String 클래스 특징, 문제점");
			System.out.println("5. StringBuffer/Bilder");
			System.out.println("6. 문자열을 계속 입력 받아 한 번에 출력하기");
			System.out.println("7. Wrapper Class");
			System.out.println("8. Date 클래스");
			System.out.println("0. 프로그램 종료");
			System.out.print("메뉴 선택 : ");

			try {
				input = sc.nextInt(); // 잘못된 문자가 입력될 경우 : throw new InputMismatchException 발생
				sc.nextLine(); // 버퍼에 남은 개행문자 제거

				switch (input) {
				case 1:	ex1();break;
				case 2:	ex2();break;
				case 3:	ex3();break;
				case 4:	ex4();break;
				case 5:	ex5();break;
				case 6:	ex6();break;
				case 7:	ex7();break;
				case 8:	ex8();break;
				case 0:	break;
				default:
					System.out.println("메뉴에 존재하는 번호만 입력 해주세요.");
				}

			} catch (InputMismatchException e) { // InputMismatchException : Scanner 입력이 잘못된 경우
				System.out.println("잘못된 형식을 입력 하셨습니다. 다시 시도해주세요");
				sc.nextLine(); // 입력 버퍼에 남아있는 잘못 입력된 문자열을 읽어와 제거
				input = -1; // 오류가 나서 catch문을 실시한 경우, input값에 입력된 값이 들어가지 않아 input값은 그대로 0
							// -> input 값에 0이 아닌 값을 대입하여 while이 종료되지 않게 함
			}

		} while (input != 0);

	}

	// 1. equals() + hashCode
	private void ex1() {
		// 한 학생의 정보를 입력 받아, service의 학생 배열에 추가
		// 단, 중복된 학생은 제외
		System.out.println("\n--- 학생 정보 입력 ---\n");

		System.out.print("학년 : ");
		int grade = sc.nextInt(); // nextInt는 버퍼에 남은 \n에 영향이 없음

		System.out.print("반 : ");
		int classRoom = sc.nextInt();

		System.out.print("번호 : ");
		int number = sc.nextInt();
		sc.nextLine(); // 입력 버퍼에 남아있는 개행문자 제거

		System.out.print("이름 : ");
		String name = sc.nextLine();

		if (service.addStudent2(grade, classRoom, number, name)) { // true로 반환될 때
			System.out.println("[추가되었습니다]");
		} else {
			System.out.println("중복되는 학생이 존재하거나, 배열이 가득 찼습니다.");
		}
	}

	private void ex2() {

		// 여러명의 이름을 한 줄로 입력 받아 학생 배열에 같은 이름의 학생이 있다면 출력
		System.out.println("\n ---- 학생 검색 ----\n");
		System.out.print("검색할 이름(여러 명 검색 시 , 로 구분) : ");
		// 손흥민, 김영희, 박찬호

		Student[] result = service.selectName(sc.nextLine());
		if (result == null) {
			System.out.println("[검색 결과가 없습니다.]");
		} else {
			for (Student s : result) {
				if (s == null)
					break;
				System.out.println(s.toString());
			}
		}

	}

	private void ex3() {
		System.out.println("\n===모든 학생 이름 출력 ===\n");
		System.out.print(service.printName());

	}

	private void ex4() {
		// String 특징, 문제점
		// 1. String 객체 생성 방법
		String s1 = new String("abc"); // Heap 메모리 영역에 String 객체 생성
		String s2 = "abc"; // String은 사용 빈도가 높기 때문에 별도의 리터럴 표기법을 부여하여 쉽게 객체 생성
							// -> Heap 영역 중 String Pool에 객체 생성
		String s3 = "abc";

		// hashCode() 필드값이 같으면 같은 수(객체 필드를 보고 만든 숫자)
//		System.out.println(s1.hashCode());
//		System.out.println(s2.hashCode());

		// System.identityHashCode(객체주소)
		// -> 객체주소를 이용해서 만든 정수를 반환
		System.out.println("s1 : " + System.identityHashCode(s1)); // 1374677625
		System.out.println("s2 : " + System.identityHashCode(s2)); // 1345636186 <-s2, s3 주소가 같음. 그럼 객체가 같나?
		System.out.println("s3 : " + System.identityHashCode(s3)); // 1345636186

		// s3가 참조하는 String 객체의 값을 변경
		// "abc"
		s3 += "def"; // "abcdef"
		System.out.println("==========================");
		System.out.println("s2 : " + System.identityHashCode(s2)); // 1345636186
		System.out.println("s3 : " + System.identityHashCode(s3)); // 963269035 <-주소가 달라짐. 새로운 객체가 만들어진 것
		// 왜 값이 달라졌을까?
		// String은 불변성(한 번 저장된 값은 변할 수 없음) 특징 때문에
		// String 값을 변경할 경우 기존 객체가 변경되는 것이 아닌, 새 객체를 생성해서 참조하게 된다.
		// > String 수정 시 매번 새 객체를 생성해야 하기 때문에 많은 메모리가 소요됨
		// -> 개선된 String 클래스(StringBuffer, StringBuilder 클래스를 쓰는게 권장됨)

	}

	private void ex5() {
		System.out.println("\n--- StringBuffer/Builder ---\n");

		// StringBuffer, StringBuilder 두 클래스는 제공하는 메서드가 동일하다
		// StringBuffer sb = new StringBuffer();
		StringBuilder sb = new StringBuilder();

		// StringBuffer.capacity() : 현재 버퍼의 크기
		System.out.println(sb.capacity());

		System.out.println("현재 주소 : " + System.identityHashCode(sb));

		// StringBuffer.append(문자열)
		// - StringBuffer 객체에 문자열을 기존 데이터 뒤에 붙임
		sb.append("abc");

		// StringBuffer.toString()
		// - StringBuffer에 저장된 문자열을 String 형태로 반환
		System.out.println("sb에 저장된 문자열 : " + sb.toString());

		System.out.println("abc 추가 후 주소 : " + System.identityHashCode(sb));

		sb.append("def");
		System.out.println("sb에 저장된 문자열 : " + sb.toString());
		System.out.println("def 추가 후 주소 : " + System.identityHashCode(sb));

		// 새로운 문자열이 추가되어도
		// 객체의 주소는 변하지 않음 == 가변성(mutable)
		// -> 문자열 수정 시 새로운 객체를 생성하지 않아
		// 메모리 소비를 절약할 수 있다.

		// insert(인덱스, 문자열) : 중간 삽입

		sb.insert(2, "@");
		System.out.println(sb.toString());

		// delete(int start, int end) : 삭제(start이상 end 미만)
		sb.delete(3, 5); // ab@cdef
		System.out.println(sb.toString()); // ab@ef

		System.out.println(sb.length());

		// replace(int start, int end, String str)
		// - start 이상 end 미만을 str로 변경
		sb.replace(0, 2, "AB");
		System.out.println(sb.toString());

	}

	private void ex6() {

		System.out.println("\n--- 문자열을 계속 입력 받아 한 번에 출력하기 ---\n");
		StringBuffer sb = new StringBuffer();
		Scanner sc = new Scanner(System.in);

		System.out.println("문자열 입력 (종료를 원할 경우 !wq 입력)"); // !wq 리눅스 메모장에서 사용하는 저장 후 종료

		String str = null;

		while (true) {
			// sc.nextLine(); : 한 줄을 입력 받아 String 반환
			// sb.append(String str) : append(마지막으로 붙여 놓는다) -> 기존 문자열 뒤에 추가
			str = sc.nextLine();

			// 입력 종료를 원하는 경우
			if (str.equals("!wq"))
				break;

			sb.append(str);
			sb.append("\n"); // \n : 개행문자 (new line)

		}

		// delete()를 이용해 마지막 문자열 제거
		sb.delete(sb.length() - 1, sb.length());

		System.out.println("===== 입력 받은 내용 =====");
		System.out.println(sb.toString());

	}

	private void ex7() {
			System.out.println("\n --- Wrapper Class ---\n");
			/*
			 * Wrapper Class
			 * -기본 자료형을 객체로 다룰 수 있도록 포장하는 클래스
			 * 왜 포장이 필요한가?
			 * 1) 기본 자료형이 제공하지 않는 추가 필드, 메서드 제공하기 위해
			 * 2) 기본 자료형을 객체로 다뤄야 하는 경우가 있기 때문(컬렉션)
			 */
			
			// Integer(+ boolean을 제외한 모든 wrapper class) 제공 상수 필드
			System.out.println(Integer.BYTES); // byte 단위 크기
			System.out.println(Integer.SIZE); // bit 단위 크기
			System.out.println(Integer.MAX_VALUE); // 자료형 최대값
			System.out.println(Integer.MIN_VALUE); // 자료형 최소값
			System.out.println(Integer.TYPE); // Wrapper 클래스 대상 타입
			
			// String을 기본자료형으로 변환
			int i = Integer.parseInt("100") + 50;
			System.out.println("i : " + i);
			long l = Long.parseLong("12345678900") + 10000000000L;
			System.out.println("l : " + l);
			double d = Double.parseDouble("3.123456789") + 10.0;
			System.out.println("d : " + d);
		
			
			
			// 기본 자료형 -> String 변환
			String str1 = Integer.valueOf(999).toString();
			String str2 = 999 + ""; // int + string => String
			// "" : 빈 문자열 (내용은 없는 길이 0짜리 String)
			
			
			// Wrapper Class를 이용하여 객체 생성
			Integer iNum1 = new Integer(10);
			
			int iNum2 = iNum1; 
			//  (int)   (Integer)->(int) : AutoUnboxing
			// 컴퓨터 내부적으로 컴파일러가 알아서 해줌
			System.out.println("iNum2 : " + iNum2);
			Integer iNum3 = 50;
			//     (Integer) (int)->(Integer) : AutoBoxing
			
			
			/* Boxing / Unboxing
			 * Boxing : 기본 자료형 -> Wrapper Class의 객체
			 * Unboxing : Wrapper Class의 객체 -> 기본 자료형
			 * -> 너무 비효율적
			 * 
			 * AutoBoxing / AutoUnboxing
			 * - 사용자가 신경쓰지 않아도 상황에따라 기본 자료형 <-> Wrapper Class 객체로 자동으로 변하는 기술 
			 */
			
			
		}
	
	private void ex8() {
		System.out.println("\n--- Date Class ---\n");
		
		// java.util.Date
		Date d1 = new Date(); // 기본 생성자로 생성시, 객체를 생성한 시점의 시간이 저장됨
		System.out.println(d1.toString()); //Mon Feb 27 11:25:48 KST 2023
		
		Date d2 = new Date(0L); // Date(long date) : Date 기준 시간으로 부터 ms(1/1000초) 단위로 지난 시간을 계산해 저장
		System.out.println(d2.toString()); // Thu Jan 01 09:00:00 KST 1970
		
		Date d3 = new Date(1000L); 
		System.out.println(d3.toString()); // Thu Jan 01 09:00:01 KST 1970
		
		// System.currentTimeMillis() : 기준 시간으로 부터 지난 시간(ms)을 나타냄
		System.out.println("현재시간 - 기준시간 (ms) : "
				+ System.currentTimeMillis()); // 1677465124244
		
		// 현재 시간으로부터 1시간 후를 저장
		long temp = 60 * 60 * 1000; // 3600000 ms == 1시간
		Date d4 = new Date(System.currentTimeMillis() + temp);
		System.out.println(d4.toString()); 
		// Mon Feb 27 12:34:57 KST 2023
		// 원하는 시간을 만들 수 있음
		
		
		// SimpleDateFormat : 간단하게 날짜 형식을 지정하는 객체
		// java.text 패키지에서 제공
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("G yyyy년 MM월 dd일 E요일 a HH시 mm분 ss초");
		
		System.out.println(sdf1.format(d4, null, null));
		
	}

}
