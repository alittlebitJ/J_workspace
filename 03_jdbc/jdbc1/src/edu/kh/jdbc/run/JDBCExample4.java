package edu.kh.jdbc.run;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.kh.jdbc.dao.SelectJobNameDAO;
import edu.kh.jdbc.dto.Employee2;

public class JDBCExample4 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("직급명 입력 : ");
		String input = sc.nextLine();
		
		// DAO 생성 후 메서드 호출
		List<Employee2> empList = new ArrayList<>();
		SelectJobNameDAO sjd = new SelectJobNameDAO();
		
		empList = sjd.select(input);
		
		if(empList.isEmpty()) {
			System.out.println("입력된 직급명과 일치하는 사원이 없습니다.");
		}
		for (Employee2 emp : empList) {
				System.out.printf("%s / %s / %s / %s \n", 
								   emp.getDeptTitle(),
								   emp.getJobName(), 
								   emp.getEmpName(),
								   emp.getEmail());
		} // toString으로 오버라이딩 하면 더 쉬움
	}

}
