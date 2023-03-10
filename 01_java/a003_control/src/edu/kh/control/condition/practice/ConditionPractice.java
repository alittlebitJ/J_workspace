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
		
		/*
		 * 키, 몸무게를 double로 입력 받고 BMI지수를 계산하여 계산 결과에 따라
저체중/정상체중/과체중/비만을 출력하세요.
BMI = 몸무게 / (키(m) * 키(m))
BMI가 18.5미만일 경우 저체중 / 18.5이상 23미만일 경우 정상체중
BMI가 23이상 25미만일 경우 과체중 / 25이상 30미만일 경우 비만
BMI가 30이상일 경우 고도 비만
[실행 화면]
키(m)를 입력해 주세요 : 1.65
몸무게(kg)를 입력해 주세요 : 58.4
BMI 지수 : 21.45087235996327
정상체중
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("키(m)를 입력해 주세요 : ");
		double height = sc.nextDouble();
		
		System.out.print("몸무게(kg)를 입력해 주세요 : ");
		double weight = sc.nextDouble();
		
		double bmi = weight / (height * height);
		String bmiIndex;
		
		if (bmi < 18.5) {
			bmiIndex = "저체중";
		}
		else if (bmi < 23){
			bmiIndex = "정상체중";
		}
		else if (bmi <25) {
			bmiIndex = "과체중";
		}
		else if (bmi <30) {
			bmiIndex = "비만";
		}
		else {
			bmiIndex = "고도 비만";
		}
		
		System.out.println(bmi);
		System.out.println(bmiIndex);
		
		
	}
	
	public void practice5() {
		
		/*
		 * 중간고사, 기말고사, 과제점수, 출석횟수를 입력하고 Pass 또는 Fail을 출력하세요.
평가 비율은 중간고사 20%, 기말고사 30%, 과제 30%, 출석 20%로 이루어져 있고
이 때, 출석 횟수는 총 강의 횟수 20회 중에서 출석한 날만 따진 값으로 계산하세요.
70점 이상일 경우 Pass, 70점 미만이거나 전체 강의에 30% 이상 결석 시 Fail을 출력하세요.

[실행 화면 1]
중간 고사 점수 : 80
기말 고사 점수 : 30
과제
점수 : 60
출석 횟수 : 18
================= 결과 =================
중간 고사 점수(20) : 16.0
기말 고사 점수(30) : 9.0
과제 점수
(30) : 18.0
출석 점수
(20) : 18.0
총점 : 61.0
Fail [점수 미달]
▶ 실습문제5
[실행 화면 2]
중간 고사 점수 : 80
기말 고사 점수 : 90
과제
점수 : 50
출석 횟수 : 15
================= 결과 =================
중간 고사 점수(20) : 16.0
기말 고사 점수(30) : 27.0
과제 점수
(30) : 15.0
출석 점수
(20) : 15.0
총점 : 73.0
PASS
▶ 실습문제5
[실행 화면 3]
중간 고사 점수 : 100
기말 고사 점수 : 80
과제
점수 : 40
출석 횟수 : 10
================= 결과 =================
Fail [출석 횟수 부족 (10/20)]
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.print("중간 고사 점수 : ");
		int mid = sc.nextInt();
		System.out.print("기말 고사 점수 : ");
		int last = sc.nextInt();
		System.out.print("과제 점수 : ");
		int hw = sc.nextInt();
		System.out.print("출석 횟수 : ");
		int pr = sc.nextInt();
		
		double midScore = mid * 0.2;
		double lastScore = last * 0.3;
		double hwScore = hw * 0.3;
		double prScore = pr;
		
		double sum = midScore + lastScore + hwScore + prScore;
		
		int flag = 0;
		/*flag 가 0인 경우 - pass 
		 *flag 가 1인 경우 - 점수 미달
		 *flag 가 2인 경우 - 출석 횟수 부족
		 */
		
		if (prScore <= 20 * 0.7  ) {
			flag = 2;
		}
		else if  (sum < 70) {
			flag = 1;
		}
	
		
		System.out.printf("==============결과==============");

		if (flag == 2) {
			System.out.printf("\nFail [출석 횟수 부족 (%d/20)]", pr);
		}
		else {
			System.out.printf("\n중간 고사 점수(20) : %.1f", midScore);
			System.out.printf("\n기말 고사 점수(30) : %.1f", lastScore);
			System.out.printf("\n과제 점수     (30): %.1f", hwScore);
			System.out.printf("\n출석 점수     (20): %.1f", prScore);
			System.out.printf("\n총점 : %.1f", sum);
			if (flag == 1) {
				System.out.print("\nFail [점수 미달]");

		}
			else {
				System.out.print("\nPASS");
			}
			
		}

	}

	
	public void ex6() {
		

	
			// 산술 연산 계산기 만들기 ver.2
			
			Scanner sc = new Scanner(System.in);
			
			System.out.print("정수1 입력 : ");
			int num1 = sc.nextInt();
			
			System.out.print("연산자 입력 : ");
			String op = sc.next();
			
			System.out.print("정수2 입력 : ");
			int num2 = sc.nextInt();
			
			int result = 0; // 연산 결과 저장용 변수
			
			/* 임의의 변수를 하나 생성하여 저장되는 값에 의미를 부여*/
			int flag = 0; 
			// 정상적인 연산인 경우 0 
			// 연산자가 잘못된 경우 -1
			// 0으로 나눈 경우 -2 라고 의미 부여
			
			switch(op) {
			case "+" : result = num1 + num2; break;
			case "-" : result = num1 - num2; break;
			case "*" : result = num1 * num2; break;
			
			case "/" : 
				if(num2 == 0) { // 나누는 값이 0인 경우
					flag = -2; // flag 변수의 값을 -2로 변경
				}else {
					result = num1 / num2;
				}
				break;
				
			case "%" : 
				if(num2 == 0) { // 나누는 값이 0인 경우
					flag = -2; // flag 변수의 값을 -2로 변경
				}else {
					result = num1 % num2;
				}
				break;
			
			default : flag = -1; // 연산자가 잘못된 경우 flag 변수의 값을 -1로 변경
			}
			
			
			if(flag == 0) {
				System.out.printf("%d %s %d = %d \n",num1, op ,num2, result);
			} else if(flag == -1) {
				System.out.println("존재하지 않는 연산자 입니다.");
			} else {
				System.out.println("0으로 나눌 수 없습니다.");
			}
				
		
		
		
		
		
		
		// switch 예시 5 : break의 역할
		
		
		
	}
	
	
	// 계절 판별(switch version)
			public void ex7() {
				Scanner sc = new Scanner(System.in);
				
				System.out.print("달(월) 입력 : ");
				int month = sc.nextInt();
				
				String result;
				
				// break : 멈추다
				// -> 해당 case를 수행한 후 멈춰라!
				// -> break 미작성 시 다음 case가 연달아 수행된다!
				
				// * case 마다 꼭 코드가 작성될 필요는 없다@!
				switch(month) {
				case 12 : 	case 1 : 	case 2 : result = "겨울"; break;
				case 3 : 	case 4 : 	case 5 : result = "봄"; break;
				case 6 : 	case 7 : 	case 8 : result = "여름"; break;
				case 9 : 	case 10 :	case 11 : result = "가을"; break;
				default : result = "잘못 입력 하셨습니다.";
				}
				
				System.out.println(result);
				
				
			}

}
