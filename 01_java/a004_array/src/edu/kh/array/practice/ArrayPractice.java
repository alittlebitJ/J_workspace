package edu.kh.array.practice;

import java.awt.print.Printable;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayPractice {

	

	public void practice1() {
		
		/*
		 * 길이가 9인 배열을 선언 및 할당하고, 1부터 9까지의 값을 반복문을 이용하여
순서대로 배열의 각 인덱스 요소에 대입하고 출력한 후
짝수 번째 인덱스 값의 합을 출력하세요. (0 번째 인덱스는 짝수로 취급)
[실행 화면]
1 2 3 4 5 6 7 8 9
짝수 번째 인덱스 합 : 25
		 */
		
		int sum = 0;
		int[] arr = new int[9];
		for (int i=0; i<arr.length; i++) {
			arr[i] = i+1;
			System.out.print(arr[i] + " ");
			if (i==0 || i%2==0) {
				sum += arr[i];
			}
		}
		System.out.println("\n짝수 번째 인덱스 합 : " + sum);
		
	}
	
	
	
	
	
	public void practice2() {
		
		/*
		길이가 9인 배열을 선언 및 할당하고, 9부터 1까지의 값을 반복문을 이용하여
		순서대로 배열의 각 인덱스 요소에 대입하고 출력한 후
		홀수 번째 인덱스 값의 합을 출력하세요. (0 번째 인덱스는 짝수로 취급)
		[실행 화면]
		9 8 7 6 5 4 3 2 1
		홀수 번째 인덱스 합 : 20
		*/
		
		int arr [] = new int[9];
		int sum = 0;
		for(int i=0; i<arr.length; i++) {
				arr[i] = 9-i;
				System.out.print(arr[i] + " ");
			if (i%2==1) {
				sum += arr[i];
			}
		}
		System.out.println("\n홀수 번째 인덱스 합 : " + sum);
		
	}
	
	
	public void practice3() {
		
		/*
		 * 사용자에게 입력 받은 양의 정수만큼 배열 크기를 할당하고
1부터 입력 받은 값까지 배열에 초기화한 후 출력하세요.
[실행 화면]
양의 정수 : 5
1 2 3 4 5
[실행 화면]
양의 정수 : 8
1 2 3 4 5 6 7 8
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.print("양의 정수 : ");
		int input = sc.nextInt();
		
		int arr[] = new int[input];
		for(int i=0; i<arr.length; i++) {
			arr[i] = i+1;
			System.out.print(arr[i] + " ");
		}

		
	}
	
	
	
	public void practice4() {  // 다시 깔끔하게 풀어보기
		
		/*
		 * 정수 5개를 입력 받아 배열을 초기화 하고
검색할 정수를 하나 입력 받아 배열에서 같은 수가 있는 인덱스를 찾아 출력.
배열에 같은 수가 없을 경우 “일치하는 값이 존재하지 않습니다“ 출력
[실행 화면 1]
입력 0 : 5
입력 1 : 8
입력 2 : 9
입력 3 : 10
입력 4 : 4
검색할 값 : 8
인덱스 : 1
[실행 화면 2]
입력 0 : 5
입력 1 : 8
입력 2 : 9
입력 3 : 10
입력 4 : 4
검색할 값 : 1
일치하는 값이 존재하지 않습니다.
		 */
		
	
		
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];
		
		for(int i=0; i<arr.length; i++) {
			System.out.print("입력 " + i + " : ");
			arr[i] = sc.nextInt();
		}
		System.out.print("검색할 값 : ");
		int input = sc.nextInt();
		
		int flag = -1;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == input) {
				System.out.println("인덱스 : " + i);
				flag = 1;
				break;
			}
		}
		if (flag < 0) {
			System.out.println("일치하는 값이 존재하지 않습니다");
		}
	}
	
	
	public void practice5() {  //** 다 못 풀었음
		
		
		/*
		 * 문자열을 입력 받아 문자 하나 하나를 char배열에 대입하고
검색할 문자가 문자열에 몇 개 들어가 있는지, 몇 번째 인덱스에 위치하는지 인덱스를 출력하세요.
[실행 화면]
문자열 : application
문자 : i
application에 i가 존재하는 위치(인덱스) : 4 8
i 개수 : 2
		 */
	
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열 : ");
		String input = sc.next();
		
		System.out.print("문자 : ");
		char search = sc.next().charAt(0);
		
		char[] inputArray = new char[input.length()];
		int[] index = new int[input.length()];
		int count = 0;
		
		for(int i=0; i<inputArray.length; i++) {
			inputArray[i] = input.charAt(i);
			if(inputArray[i] == search) {
				index[count] = i;
				count++;
			}
		}
		
		System.out.printf("%s에 %c가 존재하는 위치(인덱스) : ", input, search);
		for(int i=0; i<count; i++) {
			System.out.print(index[i] + " ");
		}
		System.out.printf("\n%c의 개수 : %d", search, count);
	}
	
	public void practice6() { // 다시 깔끔하게 풀어보기
		
		/*사용자가 배열의 길이를 직접 입력하여 그 값만큼 정수형 배열을 선언 및 할당하고
		 * 배열의 크기만큼 사용자가 직접 값을 입력하여 각각의 인덱스에 값을 초기화 하세요.
		 * 그리고 배열 전체 값을 나열하고 각 인덱스에 저장된 값들의 합을 출력하세요.
		 * 
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 : ");
		int num = sc.nextInt();
		
		
		int[] arr = new int[num];
		int sum = 0;
		for(int i=0; i<arr.length; i++) {
			System.out.printf("배열 %d번째 인덱스에 넣을 값 : ", i);
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		
		// System.out.println(Arrays.toString(arr)); [4, -4, 3, -3, 2]
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.err.println();
		System.out.println("총 합 : " + sum);
	
	}
	
	
	public void practice7() {
		
		
		/*
		 * 주민등록번호를 입력 받아 char 배열에 저장한 후 출력하세요. 
		 * 단, char 배열 저장 시 성별을 나타내는 숫자 이후부터 *로 저장하세요.
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.print("주민등록번호(-포함) : ");
		String pNum = sc.next();
		
		char[] arr = new char[pNum.length()];
		for(int i=0; i<arr.length; i++) {
			
			if (i>7) {
				arr[i] = '*';
			}
			else {
			arr[i] = pNum.charAt(i);
			}
			
			System.out.print(arr[i]);
		}
		
	}
	
	
	
	
	public void practice8() {   // ** 배열의 크기를 음수로 설정하면 에러가 남으로 조심
		
		/*3이상인 홀수를 입력 받아 배열의 중간까지는 1부터 1씩 증가하여 오름차순으로 값을 넣고,
중간 이후부터 끝까지는 1씩 감소하여 내림차순으로 값을 넣어 출력하세요.
단, 입력한 정수가 홀수가 아니거나 3 미만일 경우 “다시 입력하세요”를 출력하고
다시 정수를 받도록 하세요.*/
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			System.out.print("정수 : ");
			int num = sc.nextInt();

			
			if (num >= 3 && num % 2 == 1) {
				int arr[] = new int[num];
				for (int i=0; i<arr.length; i++) {
					if (i < num/2) { // 2.5
						arr[i] = i+1;
					}
					else {
						arr[i] = (num)-i;
					}
					System.out.print(arr[i] + " ");
				}
				break;
			}
			else {
				System.out.println("다시 입력하세요.");
			}
		}
		
	}
	
	
	
	public void practice9() {
		
		/*
		 * 10개의 값을 저장할 수 있는 정수형 배열을 선언 및 할당하고,
		 * 1~10 사이의 난수를 발생시켜 배열에 초기화한 후 출력하세요.
		 */
		
		int[] arr = new int[10];
		System.out.print("발생한 난수 : ");
		for(int i=0; i<arr.length; i++) {
			arr[i] = (int)(Math.random()*10+1);
			System.out.print(arr[i] + " ");
		}
	}
	
	
	
	
	public void practice10() {
		
		/*
		 * 10개의 값을 저장할 수 있는 정수형 배열을 선언 및 할당하고,
		 * 1~10 사이의 난수를 발생시켜 배열에 초기화 후
		 * 배열 전체 값과 그 값 중에서 최대값과 최소값을 출력하세요.
		 */
		
		int[] arr = new int[10];
		int max = Integer.MIN_VALUE; // int에서 가질 수 있는 최소값
		int min = Integer.MAX_VALUE;
		System.out.print("발생한 난수 : ");
		for (int i=0; i<arr.length; i++) {
			arr[i] = (int)(Math.random()*10+1);
			if (arr[i] > max) {
				max = arr[i];
			}
			if (arr[i] < min) {
				min = arr[i];
			}
			System.out.print(arr[i] + " ");
		}
		System.out.print("\n최대값 : " + max);
		System.out.print("\n최소값 : " + min);
		
	}
	
	
	public void practice11() { // ** 다시~
		
		
		/*
		 * 10개의 값을 저장할 수 있는 정수형 배열을 선언 및 할당하고
		 * 1~10 사이의 난수를 발생시켜 중복된 값이 없게 배열에 초기화한 후 출력하세요.
		 */
		
		int[] arr = new int[10];
		boolean[] check = new boolean[11];

		for(int i=0; i<arr.length; i++) {
			arr[i] = (int)(Math.random()*10+1);
			while (check[arr[i]]) {
				arr[i] = (int)(Math.random()*10+1);
			}
			check[arr[i]] = true;
			System.out.print(arr[i] + " ");
		}

	
	}
	
	public void practice11_1() { 
		
		int[] arr = new int[10];
		for(int i=0; i<arr.length; i++) {
			arr[i] = (int)(Math.random()*10+1);
			for(int j=0; j<i; j++) {
				if(arr[i] == arr[j]) {
					i--;
					break;
				}
			}
		}
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	
	}
	
	public void practice12() {

		
		/*
		 *  * 로또 번호 자동 생성기 프로그램을 만들기.
		 * (중복 값 없이 오름차순으로 정렬하여 출력하세요.)
		 */
		
		int[] arr = new int[10];
		int temp = 0;
		for(int i=0; i<arr.length; i++) {
			arr[i] = (int)(Math.random()*10+1);
			for(int j=0; j<i; j++) {
				if(arr[i] == arr[j]) {
					i--;
					break;
				}
			}
		}
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<i; j++) {
				if(arr[j] > arr[i]) {
					temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		}
	
		
		
		
		
	
	
	
	public void practice13() {
	
		/*
		 * 문자열을 입력 받아 문자열에 어떤 문자가 들어갔는지 배열에 저장하고
		 * 문자의 개수와 함께 출력하세요. (중복 제거)
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열 : ");
		String text = sc.next();
		
		char[] arr = new char[text.length()];
		int count = 0;
		
		for(int i=0; i<arr.length; i++) {
			if (count>=arr.length) {
				break;
			}
			else {
				arr[i] = text.charAt(count);
				for(int j=0; j<i; j++) {
					if (arr[i] == arr[j]) {
						i--;
						break;
					}
				}
				count++;
			}
			
		}
		System.out.print("문자열에 있는 문자 : ");
		for(int i=0; i<count-1; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("\n문자 개수 : " + count);
		
		
	}
	
	public void practice14(){ // scanner 다시 고치기
		
		/*
		 * 사용자가 입력한 배열의 길이만큼의 String 배열을 선언 및 할당하고
		 * 배열의 인덱스에 넣을 값 역시 사용자가 입력하여 초기화 하세요.
		 * 단, 사용자에게 배열에 값을 더 넣을지 물어보고 몇 개를 더 입력할 건지,
		 * 늘린 곳에 어떤 데이터를 넣을 것인지 받으세요.
		 * 사용자가 더 이상 입력하지 않겠다고 하면 배열 전체 값을 출력하세요.
		 * (배열의 얕은 복사, 깊은 복사를 이용하는 문제)
		 * 
		 */
		
		// 스캐너 사용법
		// 1) next() : 한 단어 (띄어쓰기, 엔터를 만나면 입력 종료)
		//    nexLine() : 한 문장 (엔터를 만나면 입력 종료)
		//    nextInt() : 다음 정수 
		
		// 2) 스캐너 입력 버퍼와 nextXXX의 의미
		//    키보드 입력 -> 입력 버퍼에 저장 -> nextXXX를 통해서 버퍼 내용을 읽어옴
		//    nextLine() : 입력버퍼-hello world(엔터) -> nextXXX()-hello world(엔터)로 읽음 -> 후처리-엔터 제거 (버퍼가 싹 비어있음)
		//    nextInt() : 입력버퍼-100(엔터) -> nextXXX()-100 -> 버퍼 안에 (엔터)가 남아있음 (next, nextdouble, nextint 등 모두 입력 버퍼에서 -엔터-를 제외 하고 내요안 읽어옴)
		
		//	  키보드 입력 -> 엔터를 누르는 순간 입력된 모든 내용이 통째로 String에 저장됨(한 글자 한 글자씩 읽어오는 것 x) -> 버퍼 : 바구니에 미리 저장시켜 놓고 한 번에 들고 오는 것
		// 	  입력 버퍼에 저장할 때 문제가 생김 : hello world(엔터) 로 저장됨 <-엔터까지 같이 저장됨
		// 	  nextLine의 경우 hello world에서 엔터 전까지만 얻어옴
		Scanner sc = new Scanner(System.in);
		
		System.out.print("nextInt() : "); // 입력 버퍼 : 100(엔터)
		int a = sc.nextInt(); // a = 100 / 입력버퍼 : (엔터)
		

		sc.nextLine(); // 문제 해결!
		
		System.out.print("nextLine() : "); // 입력버퍼 : a b c (엔터)
		String s = sc.nextLine(); // s = a b c / 입력버퍼 : -아무것도 없음_
		
		// nextInt : 100
		// nextLine :
		// 종료
		
		// 이렇게 됨

		// [문제점]
		// nextInt() 이후 입력 문자에 남아있는 (엔터) 때문에
		// 다음 nextLine() 수행 시, 버퍼에 남아 있는 (엔터)를 읽어버리기 때문에
		// 추가적인 입력을 시도하지 못하고 다음 코드로 넘어가버림
		
		// [해결방법]
		// 입력을 위한 nextLine() 수행 전, 입력버퍼에서 (엔터)를 제거
		// -> 빈 공간에 sc.nextLine() 구문을 한 번 작성하면 (엔터)가 제거됨
		
		System.out.println("종료");
		
		
		
		
		
		
		int count = 0;
		// 1. 첫 배열 크기 지정
		System.out.print("배열의 크기를 입력하세요 : ");
		int size = sc.nextInt(); // 입력 버퍼에 개행문자(엔터)가 남음
		sc.nextLine(); // 입력 버퍼에 남은 개행문자(엔터) 제거
		
		count += size;
		// 2. 첫 배열 생성
		String[] arr = new String[1000];
		
		for (int i=0; i<count; i++) {
			System.out.print((i + 1) + "번째 문자열 : ");
			arr[i] = sc.next();
		}
		
		
		while(true) {
			
		System.out.print("더 값을 입력하시겠습니까?(Y/N) : ");
		char more = sc.next().charAt(0);
		
		if (more == 'y') {
			System.out.print("더 입력하고 싶은 개수 : ");
			int moreSize = sc.nextInt();
			for(int i=count; i<count+moreSize; i++) {
				System.out.print((i + 1) + "번째 문자열 : ");
				arr[i] = sc.next();
			}
			count += moreSize;
		}
		else {
			break;
		}
		}
		
		String[] arr2 = new String[count];
		for(int i=0; i<arr2.length; i++) {
			arr2[i] = arr[i];
		}
		
		System.out.println(Arrays.toString(arr2));
		
		
		/*
		 * while(true){
		 * System.out.print("더 값을 입력하시겠습니까?(Y/N) : ");
		 * char ch = sc.nextLine().charAt(0);
		 * 
		 * if (ch == 'N') {
		 * break;
		 * }
		 * 
		 * 5. 더 입력 받을 개수 입력
		 * System.out.print("더 입력하고 싶은 개수 : "
		 * int addSize = sc.nextInt();
		 * sc.nextLine(); // 입력 버퍼 개행문자 제거
		 * 
		 * 6. 기존 배열보다 더 늘어난 개수만큼 큰 새 배열 생성
		 * String newBooks[] = new String[books.length + addSize];
		 * 
		 * 7. 깊은 복사를 통해 기존 배열 내용을 새 배열로 복사
		 * System.arraycopy(books, 0, newBooks, 0, books.length);
		 * 
		 * 8. 새 배열의 빈칸 부터 새로운 입력을 받아서 저장
		 * for(int i=books.length; i<newBooks.length){
		 * System.out.print((i+1) + "번째 문자열 : ");
		 * newBooks[i] = sc.nextLine();
		 * 
		 * 
		 * 9. 기존 참조배열 books에 newBooks의 주소를 얕은 복사
		 * books = newBooks; < 사이즈가 다른데 왜 가능하지?
		 * 
		 * } // while 종료
		 * 
		 * 
		 * 10. 배열에 저장된 모든 값 출력
		 * System.out.println(Arrays.toString(books);
		 * 
		 */
		
	}
	
	
	
	public void practice15() {
		
		/*
		 * 3행 3열짜리 문자열 배열을 선언 및 할당하고
		 * 인덱스 0행 0열부터 2행 2열까지 차례대로 접근하여 “(0, 0)”과 같은 형식으로 저장 후 출력하세요.
		 */
		
		String[][] arr = new String[3][3];
		for (int row=0; row<arr.length; row++) {
			for (int col=0; col<arr[row].length; col++) {
				arr[row][col] = "("+row+","+col+")";
				System.out.print(arr[row][col]);
			}
			System.out.println();
		}

	}
	
	public void practice16 () {
		
		/*
		 * 4행 4열짜리 정수형 배열을 선언 및 할당하고
		 * 1) 1 ~ 16까지 값을 차례대로 저장하세요.
		 * 2) 저장된 값들을 차례대로 출력하세요.
		 */
		
		int count = 1;
		int[][] arr = new int[4][4];
		for(int row=0; row<arr.length; row++) {
			for(int col=0; col<arr[row].length; col++) {
				arr[row][col] = count++;
				System.out.printf("%3d", arr[row][col]);
			}
			System.out.println();
		}
		
		
	}
	
	
	public void practice17() {
		
		/*
		 * 4행 4열짜리 정수형 배열을 선언 및 할당하고
		 * 1) 16 ~ 1과 같이 값을 거꾸로 저장하세요.
		 * 2) 저장된 값들을 차례대로 출력하세요.
		 */

		int count = 16;
		int[][] arr = new int[4][4];
		for(int row=0; row<arr.length; row++) {
			for(int col=0; col<arr[row].length; col++) {
				arr[row][col] = count--;
				System.out.printf("%3d", arr[row][col]);
			}
			System.out.println();
		}
		
		
	}
	
	
	public void practice18() {  
		
		//4행 4열 2차원 배열을 생성하여 0행 0열부터 2행 2열까지는 1~10까지의 임의의 정수 값 저장 후
		//아래의 내용처럼 처리하세요.
		
				
		int[][] arr = new int[4][4];
		int rowSum = 0;
		int colSum = 0;
	
		for (int row=0; row<arr.length; row++) {
			for(int col=0; col<arr[row].length; col++) {
				if (row < arr.length-1 && col < arr[row].length-1) {
					arr[row][col] = (int)(Math.random()*10+1);
					rowSum += arr[row][col];
				}
				else if (row < arr.length-1 && col == arr[row].length-1) {
					arr[row][col] = rowSum;
					rowSum = 0;
				}
	
			}
		}
		for (int col=0; col<arr.length; col++) {
			for(int row=0; row<arr.length; row++) {
				colSum += arr[row][col];
			}
			arr[arr.length-1][col] = colSum;
		}
		
		
		for (int row=0; row<arr.length; row++) {
			for (int col=0; col<arr[row].length; col++) {
				System.out.printf("%3d ", arr[row][col]);
			}
			System.out.println();
		}
		
	
		
		
		
	}
	
		/*
		for(int row=0; row<arr.length; row++) {
			
			for(int col=0; col<arr[row].length; col++) {
				
				if (row < arr.length-1 && col < arr[row].length-1) {
					arr[row][col] = (int)(Math.random()*10+1);
					System.out.printf("%3d ", arr[row][col]);
					rowSum += arr[row][col];
				}
				else if(col == arr.length-1) {
					arr[row][col] = rowSum;					
					System.out.printf("%3d ", arr[row][col]);
					rowSum = 0;
				}
				
			}
			System.out.println();
		}
		}
		
		for (int row1=0; row1<arr.length; row1++) {
			for(int col=0; col<arr.length; col++) {
				
				arr[row1][arr.length-1] += arr[row1][col];
				arr[arr.length-1][col] += arr[row1][col];
				arr[arr.length-1][arr.length-1] += arr[row1][col];
				
			}
		}
		
		
		for (int row1=0; row1<arr.length; row1++) {
			for (int col=0; col<arr.length; col++) {
				System.out.print(arr[row1][col] + "\t");
			}
			System.out.println();
		}
		
		
		
		
	

	
		
	}
		
	
	
	
	*/
	
	
	public void practice19() { 
		
		/*
		 * 2차원 배열의 행과 열의 크기를 사용자에게 직접 입력받되, 1~10사이 숫자가 아니면
		 * “반드시 1~10 사이의 정수를 입력해야 합니다.” 출력 후 다시 정수를 받게 하세요.
		 * 크기가 정해진 이차원 배열 안에는 영어 대문자가 랜덤으로 들어가게 한 뒤 출력하세요.
		 * (char형은 숫자를 더해서 문자를 표현할 수 있고 65는 A를 나타냄, 알파벳은 총 26글자)
		 */

		int rowNum;
		int colNum;
		
		do {
			
		Scanner sc = new Scanner(System.in);
		System.out.print("행 크기 : ");
		rowNum = sc.nextInt();
		
		System.out.print("열 크기 : ");
		colNum = sc.nextInt();
		
		boolean rowrange = rowNum < 1 || rowNum > 10;
		boolean colrange = colNum < 1 || colNum > 10;
		
		
		if (rowrange || colrange) {
			System.out.println("반드시 1~10 사이의 정수를 입력해야 합니다.");
		}
		else {
			break;
		}
		} while (true);
		
		
		char[][] arr = new char[rowNum][colNum];
		
		for (int row=0; row<arr.length; row++) {
			for (int col=0; col<arr[row].length; col++) {
				arr[row][col] = (char)(Math.random()*26+65);
				System.out.print(arr[row][col] + " ");
			}
			System.out.println();
		}
		
		
		
		
	}
	
	
	
	
	public void practice20() { 
		
		
		/*
		 * 사용자에게 행의 크기를 입력 받고 그 수만큼의 반복을 통해 열의 크기도 받아
		 * 문자형 가변 배열을 선언 및 할당하세요.
		 * 그리고 각 인덱스에 ‘a’부터 총 인덱스의 개수만큼 하나씩 늘려 저장하고 출력하세요.
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.print("행의 크기 : ");
		int rowNum = sc.nextInt();
		char[][] arr = new char[rowNum][];
		char count = 'a';
		
		for(int row=0; row<arr.length; row++) {
			System.out.print(row + "열의 크기 : ");
			arr[row] = new char[sc.nextInt()];
			}
		for(int row=0; row<arr.length; row++) {
			
			for(int col=0; col<arr[row].length; col++) {
			arr[row][col] = count++;
			System.out.print(arr[row][col] + " ");
			}
			System.out.println();
			}
			
	}
	
	
	public void practice21() {  
		
		/*
		 * 1차원 문자열 배열에 학생 이름 초기화되어 있다.
		 * 3행 2열 짜리 2차원 문자열 배열 2개를 새로 선언 및 할당하여
		 * 학생 이름을 2차원 배열에 순서대로 저장하고 아래와 같이 출력하시오.
		 * (첫 번째 2차원 배열이 모두 저장된 경우 두 번째 2차원 배열에 저장 진행)
		 */
		
		String[] students = {"강건강", "남나나", "도대담", "류라라", "문미미", "박보배",
				"송성실", "윤예의", "진재주", "차천축", "피풍표", "홍하하"};
		
		String[][] arr = new String[3][2];
		String[][] arr2 = new String[3][2];
		int count = 0;
		int num = 1;
		
		while(count != students.length)
		{
		System.out.printf("===%d분단===\n", num);
		for(int row=0; row<arr.length; row++) {
			for(int col=0; col<arr[row].length; col++) {
				if (arr[row][col] == null) {
					arr[row][col] = students[count];
					System.out.print(arr[row][col] + " ");
					count++;
					
				}
				else {
					arr2[row][col] = students[count];
					System.out.print(arr2[row][col] + " ");
					count++;
					}
				}
			System.out.println();
				}
			num++;
			System.out.println();
			}
		
	}
	
	
	
	public void practice22() { // 풀어야함
		
		
		/*
		 * 위 문제에서 자리 배치한 것을 가지고 학생 이름을 검색하여
해당 학생이 어느 자리에 앉았는지 출력하세요.
[실행 화면]
== 1분단 ==
강건강
남나나
도대담
류라라
문미미
박보배
== 2분단 ==
송성실
윤예의
진재주
차천축
피풍표
홍하하
============================
검색할 학생 이름을 입력하세요 : 차천축
검색하신 차천축 학생은 2분단 2번째 줄 오른쪽에 있습니다.
		 */
		Scanner sc = new Scanner(System.in);
		
		String[] students = {"강건강", "남나나", "도대담", "류라라", "문미미", "박보배",
				"송성실", "윤예의", "진재주", "차천축", "피풍표", "홍하하"};
		
		String[][] arr = new String[3][2];
		String[][] arr2 = new String[3][2];
		int count = 0;
		int num = 1;
		
		while(count != students.length)
		{
		System.out.printf("===%d분단===\n", num);
		for(int row=0; row<arr.length; row++) {
			for(int col=0; col<arr[row].length; col++) {
				if (arr[row][col] == null) {
					arr[row][col] = students[count];
					System.out.print(arr[row][col] + " ");
					count++;
					
				}
				else {
					arr2[row][col] = students[count];
					System.out.print(arr2[row][col] + " ");
					count++;
					}
				}
			System.out.println();
				}
			num++;
			System.out.println();
			}
		
		System.out.println("==================================");
		System.out.print("검색할 학생 이름을 입력하세요 : ");
		String input = sc.next();
		
		int bundan = 0;
		int jul = 0;
		String jjog = null;
		boolean flag = false;
		
		for (int row=0; row<arr.length; row++) {
			for (int col=0; col<arr[row].length; col++) {
				if (input.equals(arr[row][col])) {
					bundan = 1;
					jul = row+1;
					if(col == 0) jjog = "오른";
					else jjog = "왼";
					flag = true;
				}
				else if (input.equals(arr2[row][col])) {
					bundan = 2;
					jul = row+1;
					if(col == 1) jjog = "오른";
					else jjog = "왼";
					flag = true;
			}
		}
			
		}
		if (flag) System.out.printf("검색하신 %s 학생은 %d 분단 %d 번째 줄 %s쪽에 있습니다.", input, bundan, jul, jjog);
		else System.out.println("해당 학생이 존재하지 않습니다.");
		
	}
	
	
	public void practice23() {
		
		/*
		 * String 2차원 배열 6행 6열을 만들고 행의 맨 위와 제일 앞 열은 각 인덱스를 저장하세요.
		 * 그리고 사용자에게 행과 열을 입력 받아 해당 좌표의 값을 “X”로 변환해 2차원 배열을 출력하세요.
		 */
		Scanner sc = new Scanner(System.in);
		String arr[][] = new String[6][6];
		
		//do {
		
		System.out.print("행 인덱스 입력 : ");
		int rowInput = sc.nextInt();
		
		System.out.print("열 인덱스 입력 : ");
		int colInput = sc.nextInt();
		
		boolean rightrinput = rowInput > 6 || rowInput < 0;
		boolean rightcinput = colInput > 6 || colInput < 0;
		
	//	} while(rightcinput || rightrinput);
		
		for(int row=0; row<arr.length; row++) {
			for(int col=0; col<arr.length; col++) {
				if(row == rowInput-1 && col == colInput-1)
					System.out.print("x" + " ");
				else {
					System.out.print("_" + " ");
				}
			}
			System.out.println();
		}
		
		
		
	}
	
	public void practice24() {
		
		
		
		
	}
	
	public void practice25() { //** 중복제거 필요
		
		Scanner sc = new Scanner(System.in);
		System.out.print("빙고판 크기 지정 : ");
		int arrayNum = sc.nextInt();
		
		int[][] arr = new int[arrayNum][arrayNum];
		for(int row=0; row<arr.length; row++) {
			for(int col=0; col<arr[row].length; col++) {
				arr[row][col] = (int)(Math.random()*arrayNum*arrayNum+1);
				System.out.printf("%3d ", arr[row][col]);
			}
			System.out.println();
		}
		System.out.println("==========빙고게임 시작==========");
		
		
		while(true) {
		System.out.print("정수를 입력하시오 :");
		int input = sc.nextInt();
		
		
		
		}
	}
	
	
	
	
}