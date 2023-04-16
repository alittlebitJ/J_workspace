package practice_ct;


public class CodeTest {
	// 2차원 정수 배열 score
    
	public static void main(String[] args) {
		
		int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
		int answer = 0;

		int[] check = {1, 2, 3, 1};
		int count = 0;
		
		/*
		 * ingredient를 훑으며 check의 0번 인덱스와 같은지 찾아보고
		 * 0번 인덱스와 같으면 2,3,4번 인덱스도 다음 숫자와 같은지 확인해보기
		 * 단 훑는 과정에서 ingredient의 숫자가 check의 개수만큼 남아있어야 함
		 * */
		
		for(int i=0; i<=ingredient.length-check.length; i++) {
			// 만약 check의 0번 인덱스와 같으면 다음, 다다음, 다다다음 숫자도 check와 같은지 확인해보기
			count=0;
			if(ingredient[i]==check[0]) {
				for(int j=0; j<check.length; j++) {
					if(ingredient[i+j]==check[j])	{
						count++;
						continue;
					}
					else 				break;
				}
				if(count==check.length) answer++;
			}
		}
		System.out.println(answer);
		
	} // main 끝
	
	 
}    
