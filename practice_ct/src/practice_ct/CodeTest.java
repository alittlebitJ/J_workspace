package practice_ct;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CodeTest {
	
   public static void main(String[] args) {
      String[][] name = {
            {"may", "kein", "kain", "radi"},
            {"kali", "mari", "don"},
            {"may", "kein", "kain", "radi"}
      };
      int[][] yearning = {
            {5, 10, 1, 3},
            {11, 1, 55},
            {5, 10, 1, 3}
      };
      String[][][] photo = {
            {{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"},{"kon", "kain", "may", "coni"}},
            {{"kali", "mari", "don"},{"pony", "tom", "teddy"},{"con", "mona", "don"}},
            {{"may"},{"kein", "deny", "may"},{"kon", "coni"}}
      };
      
        // 예상답안
      // 19, 15, 6
      // 67, 0, 55
      // 5, 15, 0
      for(int i=0; i<3; i++) {
         for(int j : solution(name[i], yearning[i], photo[i]))
            System.out.print(j + " ");
         System.out.println();
      }
   }
   
   public static int[] solution(String[] name, int[] yearning, String[][] photo) {
	   
	   	int[] answer = new int [photo[0].length];
	   	int count = 0;
	   	
	   	// photo에 배열을 하나씩 거냄
	   	for(String[] pt : photo) {
	   		int sum = 0;
	   		// name에서 하나씩 꺼내서 photo에 있는 사람을 훑고
	   		for(int i=0; i<name.length; i++) {
	   			for(int j=0; j<pt.length; j++) {
	   				if(name[i].equals(pt[j])) {
	   					sum += yearning[i];
	   				}
	   			}
	   		}
	   		answer[count++] = sum;
	   	}
		
		
//		System.out.println(missing.keySet().contains(photo[0][0]));
		
		
		// photo에 name이 있는지 확인 후 answer에 해당 name의 value값인 yearning을 더해줌
		// photo에서 하나를 꺼내서
//		for(String[] pt : photo) {
//			int sum = 0;
//			// missing
//			for(int i=0; i<pt.length; i++) {
//				sum += pt[0].indexOf("kein");
//				for( String key : missing.keySet()) {
//					if(pt[i].indexOf(key)>-4) sum += missing.get(key);
//				}
//			}
//			answer[index++] = sum;
//		}
		return answer;
   }
   
   
}
