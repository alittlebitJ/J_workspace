package edu.kh.control.condition.practice;

import java.util.Scanner;

// 실습문제 작성 클래스
public class ConditionPractice {
	
	public void practice1() {
		
		Scanner sc = new Scanner(System.in);
		/*
		 * 메소드 명 : public void practice1(){}
키보드로 입력 받은 정수가 양수이면서 짝수일 때만 “짝수입니다.”를 출력하고
짝수가 아니면 “홀수입니다.“를 출력하세요.
양수가 아니면 “양수만 입력해주세요.”를 출력하세요.
[실행 화면 1]
숫자를 한 개 입력하세요 : 8
짝수입니다.
[실행 화면 2]
숫자를 한 개 입력하세요 : 17
홀수입니다.
[실행 화면 3]
숫자를 한 개 입력하세요 : -3
양수만 입력해주세요
		 */
		
		System.out.print("숫자를 한 개 입력하세요 : ");
		int num = sc.nextInt();
		
		String result;
		if (num <= 0) {
			result = "양수만 입력해주세요.";
		}
		else if (num % 2 == 1){
			result = "홀수입니다.";
		}
		else {
			result = "짝수입니다.";
		}
		System.out.println(result);
	}
	
	public void practice2() {
		
		/*
		 * 국어, 영어, 수학 세 과목의 점수를 키보드로 입력 받고 합계와 평균을 계산하고
합계와 평균을 이용하여 합격 / 불합격 처리하는 기능을 구현하세요.
(합격 조건 : 세 과목의 점수가 각각 40점 이상이면서 평균이 60점 이상일 경우)
합격 했을 경우 과목 별 점수와 합계, 평균, “축하합니다, 합격입니다!”를 출력하고
불합격인 경우에는 “불합격입니다.”를 출력하세요.

[실행화면 1] [실행화면 2]
국어점수 : 88 국어점수 : 88
수학점수 : 50 수학점수 : 50
영어점수 : 40 영어점수 : 45
불합격입니다. 국어 : 88
수학 : 50
영어 : 45
합계 : 183
평균 : 61.0
축하합니다, 합격입니다!
		 */
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어점수 : ");
		int kor = sc.nextInt();
		
		System.out.print("수학점수 : ");
		int math = sc.nextInt();
		
		System.out.print("영여점수 : ");
		int eng = sc.nextInt();
		
		int sum = kor + math + eng;
		double avg = sum / 3.0;
		
		if ((kor >= 40 && math >= 40 && eng >= 40) && avg >=60 ) {
			System.out.printf("국어 : %d \n수학 : %d \n영어 : %d \n합계 : %d \n평균 : %.1f \n축하합니다, 합격입니다!", kor, math, eng, sum, avg);
		}
		else {
			System.out.println("불합격입니다.");
		}
		
		
		
		
	}
		
	public void practice3() {
		
		/*
		 * 1~12 사이의 수를 입력 받아 해당 달의 일수를 출력하세요.(2월 윤달은 생각하지 않습니다.)
잘못 입력한 경우 “OO월은 잘못 입력된 달입니다.”를 출력하세요. (switch문 사용)
[실행화면 1]
1~12 사이의 정수 입력 : 8
8월은 31일까지 있습니다.
[실행화면 2]
1~12 사이의 정수 입력 : 99
99월은 잘못 입력된 달입니다.
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.print("1~12 사이의 정수 입력 : ");
		int month = sc.nextInt();
		
		String result;
		switch (month) {
		case 1: case 3: case 5: case 7: case 8: case 10: case 12: 
			result = "31";
			System.out.printf("%d월은 %s일까지 있습니다.", month, result);
			break;
		case 4: case 6: case 9: case 11:
			result = "30";
			System.out.printf("%d월은 %s일까지 있습니다.", month, result);
			break;
		case 2 : 
			result = "28";
			System.out.printf("%d월은 %s일까지 있습니다.", month, result);
			break;
		default : 
			System.out.printf("%d월은 잘못 입력된 달입니다.", month);
			}
		
		
		
	}
	
	public void practice4() {
		
	}
	
	public void practice5() {
		
	}

}
