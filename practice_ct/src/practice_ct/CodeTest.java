package practice_ct;

public class CodeTest {
	// 2차원 정수 배열 score
    
    public int[] solution(int[][] score) {
        int[] answer = {};

        
        int[][] classScore = {{80, 70}, {90, 50}, {40, 70}, {50, 80}};
        int[] personScore = new int[classScore.length];
        
        
        // 각 항생의 평균값을 구해 personScore 배열에 입력
        for(int i=0; i<classScore.length; i++) {
           personScore[i] = (classScore[i][0] + classScore[i][1])/2;
        }
        
        // 평균값을 비교
        for(int j=1; j<personScore.length; j++) {
           if(personScore[j] == personScore[j-1]) {}
           else if(personScore[j] > personScore[j-1]) {}
           else //'personScore[j] < personScore[j-1]'인 경우 
        	   {}
        }
        
        return answer;
    }
}
