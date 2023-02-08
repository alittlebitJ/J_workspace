package edu.kh.operator.practice;
import java.util.Scanner;


public class OperatorPractice4 {

	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		
		/*
		 * 국어, 영어, 수학에 대한 점수를 키보드를 이용해 정수로 입력 받고,
세 과목에 대한 합계(국어+영어+수학)와 평균(합계/3.0)을 구하세요.
세 과목의 점수와 평균을 가지고 합격 여부를 처리하는데
세 과목 점수가 각각 40점 이상이면서 평균이 60점 이상일 때 합격, 아니라면 불합격을 출력하세요.
ex.
국어 : 60
영어 : 80
수학 : 40
합계 : 180
평균 : 60.0
합격		 * 
		 */
		
		System.out.print("국어 : ");
		int inputKor = sc.nextInt();
		
		System.out.print("영어 : ");
		int inputEng = sc.nextInt();
		
		System.out.print("수학 : ");
		int inputMath = sc.nextInt();
		
		int sum = inputKor + inputEng + inputMath;
		System.out.println("합계 : " + sum);
		double eve = (double)sum / 3;
		System.out.println("평균 : " + eve);
		
		boolean score = (inputKor >= 40 && inputEng >= 40) && inputMath >= 40;
		String result = score == true && eve >= 60 ? "합격" : "불합격";
		
		System.out.println(result);
		
		
	}
	
	
}
