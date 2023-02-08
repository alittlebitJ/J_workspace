// 세미콜론 찍었나요
// 오타는 없나요


package edu.kh.variable;
import java.util.Scanner;

public class ScannerEx2 {

	
	public static void main(String[] srgs) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름 : ");
		String inputName = sc.next();
		// sc.next()    : 다음 입력되는 한 단어(띄어쓰기가 나오기 전까지)를 얻어옴
		// sc.nextInt() : 다음 입력되는 정수를 얻어옴
		
		System.out.print("나이 : ");
		int inputAge = sc.nextInt();
		
		System.out.print("키 : ");
		double inputHeight = sc.nextDouble();
		
		
		// 홍길동님은 25세, 키 174.5cm 입니다/
		
		System.out.printf("%s님은 %d세, 키 %.1fcm 입니다.", inputName, inputAge, inputHeight);
		
	}
	
	
	
}
