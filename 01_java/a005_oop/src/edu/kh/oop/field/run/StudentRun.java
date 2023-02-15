package edu.kh.oop.field.run;
import edu.kh.oop.field.dto.Student;

/*
 * Java 실행 단계
 * 0. 코드 훑어 보기 -> static 키워드 찾음 -> 찾은 static 키워드가 포함된 필드/변수/메서드를 static 메모리 영역(정적 메모리 영역)에 생성/추가 함
 * 		-> static 영역에 추가시
 * 클래스명.필드명
 * 클래스명.메서드명 으로 기록된다
 * 
 * 1. main 실행
 */


public class StudentRun {
	
	public static void main(String[] args) {
		
		
		// Student 객체 생성
		Student s1 = new Student();
		// 패키지가 달라 접근 불가능 import가 필요
		
		s1.name = "김삼순";
		s1.grade = 5;
		
		Student s2 = new Student();
		
		s2.name = "박철수";
		s2.grade = 2;
		
		System.out.println("s1 학생 정보");
		System.out.println(s1.name);
		System.out.println(s1.grade);
		System.out.println(s1.schoolName);
		System.out.println("=========================");
		System.out.println("s2 학생 정보");
		System.out.println(s2.name);
		System.out.println(s2.grade);
		System.out.println(s2.schoolName);
		
		// 학교 이름 변경
		//s1.schoolName = "KH국민학고"; 
		//The static field Student.schoolName should be accessed in a static way
		//s2.schoolName = "KH국민학고";
		
		// 참조 변수를 이용해서 static으로 지정된 필드 값을 바꿀 수 있지만
		// <클래스명.필드명>을 이용해서 다루는 것을 권장
		Student.schoolName = "KH중학교";
		
		System.out.println("=================");
		System.out.println("s1 학교명 : " + s1.schoolName);
		System.out.println("s1 학교명 : " + s2.schoolName);
		
		
		// public static final
		// 어디서든 공유할 수 있는 상수
		System.out.println(Math.PI);
		// public static final double PI = 3.14159265358979323846; 이렇게 쓰여있음
		System.out.println(Integer.MAX_VALUE);
		// 정수의 최대값
		// public static final int   MAX_VALUE = 0x7fffffff;
		
		
	}

}
