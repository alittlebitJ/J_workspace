package practice_ct;

import java.lang.reflect.Array;
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
	   
	   	int[] answer = {};
	   	Map<String, Integer> missing = new HashMap<>();
	   	int index = 0;
	   	
		// name값과 yearning 값을 map으로 mapping (중복되지 않는 name이 key값)
		for(int i=0; i<name.length; i++) {
			missing.put(name[i], yearning[i]);
		}
		
		
		for(String[] pt : photo) {
			System.out.println();
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
