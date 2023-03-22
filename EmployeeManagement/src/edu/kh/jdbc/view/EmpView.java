package edu.kh.jdbc.view;

import java.sql.Date;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import edu.kh.jdbc.model.dto.Emp;
import edu.kh.jdbc.model.service.EmpService;

public class EmpView {
  
	private Scanner sc = new Scanner(System.in);
	private EmpService service = new EmpService();
	
	//** 모든 기능에는 예외상황에 따른 출력 구문 필수 작성 **
	//** 필요에 따라 DTO에 생성자 추가 **
	//** 메서드명, 출력 화면은 자유롭게 작성 **
	
	public void displayMenu() {
		
		int input = 0;
		
		do {
			
			try {
				System.out.println("\n*****************************\n");
				System.out.println("***** 사원 관리 프로그램*****");
				
				System.out.println("1. 재직중인 사원 전체 조회"); 
				// 현재 재직중인 사원의
				// 사번, 이름, 부서명, 직급명, 급여, 전화번호, 이메일
				// 직급코드 오름차순으로 조회
				
				
				System.out.println("2. 퇴직한 사원 전체 조회"); 
				// 현재 퇴직한 사원의
				// 사번, 이름, 전화번호, 이메일, 퇴사일을
				// 퇴사일 오름차순으로 조회
				
				
				System.out.println("3. 사번이 일치하는 사원 조회"); 
				// 사번을 입력 받아 일치하는 사원의  
				// 사번, 이름, 부서명, 직급명, 급여, 전화번호, 이메일, 입사일, 퇴직여부 조회
				// 단, 사번이 일치하는 사원이 없으면
				// "사번이 일치하는 사원이 없습니다" 출력
				
				
				System.out.println("4. 사원 정보 추가(INSERT)");
				// 사번(EMP_ID) -> SEQ_EMP_ID SEQUENCE 사용
				
				
				System.out.println("5. 사번으로 사원 정보 수정(UPDATE)");
				// 이메일, 전화번호, 급여, 보너스 수정
				// 단, 사번이 일치하는 사원이 없으면
				// "사번이 일치하는 사원이 없습니다" 출력

				
				System.out.println("6. 사번으로 사원 정보 삭제(DELETE)");
				// 사번을 입력 받아 일치하는 사원 삭제
				// - 사번을 입력 받은 후 정말 삭제할 것인지 Y/N을 입력 받아 
				//   Y인 경우에만 삭제, N인 경우 취소
				// - 사번이 일치하는 사원이 없으면
				//   "사번이 일치하는 사원이 없습니다" 출력
				
				
				System.out.println("7. 사번이 일치하는 사원 퇴직 처리");
				// - ENT_YN -> 'Y' , ENT_DATE -> SYSDATE로 수정
				
				// - 사번을 입력 받은 후 정말 퇴직 처리할 것인지 Y/N을 입력 받아 
				//   Y인 경우에만 퇴직 처리, N인 경우 취소
				
				// - 사번이 일치하지 않거나 이미 퇴직 처리된 사원이면
				//   "사번이 일치하는 않거나, 이미 퇴직된 사원입니다." 출력
				
				System.out.println("8. 가장 최근 입사한 사원 5명 조회");
				
				// 가장 최근(입사일이 늦은) 사원 5명의
				// 사번, 이름, 부서명, 입사일을
				// 입사일 내림차순으로 조회
				// 서브쿼리
				
				
				System.out.println("9. 부서별 통계 조회"); 
				// 각 부서별
				// 부서명, 인원 수, 급여 평균
				// 부서코드 오름차순 조회
				// group by
				
				// HINT.
				// - 별도의 DTO 작성 또는 
				//   Map(LinkedHashMap : key 순서가 유지되는 Map) 이용
				
				
				System.out.println("0. 프로그램 종료");
				
				
				System.out.print("메뉴 선택 >> ");
				input = sc.nextInt();
				sc.nextLine(); // 입력 버퍼 개행문자 제거
				
				
				switch(input) {
				case 1:  selectEmp(); break;
				case 2:  selectEmpEnt(); break;
				case 3:  selectEmpId(); break;
				case 4:  insertEmp(); break;
				case 5:  updateEmp(); break;
				case 6:  deleteEmp(); break;
				case 7:  updateEmpEnt(); break;
				case 8:  rankEmp(); break;
				case 9:  deptStatistic(); break;
				case 0: System.out.println("\n[프로그램을 종료합니다...]\n"); break;
				
				default: System.out.println("\n[메뉴에 존재하는 번호를 입력하세요.]\n");
				}
				
				
			}catch (InputMismatchException e) {
				System.out.println("\n[잘못된 입력입니다.]\n");
				sc.nextLine(); // 입력 버퍼에 남아있는 문자열 제거
				input = -1; // while문이 종료되지 않게하기 위한 값 대입
			}
			
		}while(input != 0);
		
	}


	/**
	 * 1. 재직중인 사원 전체 조회
	 */
	private void selectEmp() {
		System.out.println("***** 재직중인 사원 전체 조회 *****");
		
		try {
			List<Emp> empList = service.selectEmp();
			
			if (empList.isEmpty()) {
				System.out.println("사원이 존재하지 않습니다.");
				return;
			} else {
				for (Emp emp : empList) {
					
					int empId = emp.getEmpId();
					String empName = emp.getEmpName();
					String deptTitle = emp.getDepartmentTitle();
					String jobName = emp.getJobName();
					int salary = emp.getSalary();
					String phone = emp.getPhone();
					String email = emp.getEmail();
					
					System.out.printf("%d / %s / %s / %s / %d / %s / %s\n",
							empId, empName, deptTitle, jobName, salary, phone, email);
				}
			}
		} catch (SQLException e) {
			System.out.println("재직중인 사원 전체 조회 중 오류가 발생했습니다.");
			e.printStackTrace();
		}
	}
	

	
	/**
	 * 2. 퇴직한 사원 전체 조회
	 */
	private void selectEmpEnt() {
		System.out.println("*****  퇴직한 사원 전체 조회 *****");
		
		try {
			List<Emp> empList = service.selectEmpEnt();
			
			if (empList.isEmpty()) {
				System.out.println("퇴직한 사원이 존재하지 않습니다.");
				return;
			} else {
				for (Emp emp : empList) {
					
					int empId = emp.getEmpId();
					String empName = emp.getEmpName();
					String phone = emp.getPhone();
					String email = emp.getEmail();
					String entDate = emp.getEntDate();
					
					System.out.printf("%d / %s / %s / %s / %s\n",
							empId, empName, phone, email, entDate);
				}
			}
		} catch (SQLException e) {
			System.out.println("퇴직한 사원 전체 조회 중 오류가 발생했습니다.");
			e.printStackTrace();
		}
	}
		
	
	
	
	/**
	 * 3. 사번이 일치하는 사원 조회
	 */
	private void selectEmpId() {
		System.out.println("*****  3. 사번이 일치하는 사원 조회 *****");
		
		System.out.print("사원 번호 입력 : ");
		int input = sc.nextInt();
		sc.nextLine();
		
		try {
			Emp result = service.selectEmpId(input);
			if (result == null) {
				System.out.println("사번이 일치하는 사원이 존재하지 않습니다.");
				return;
			}
			System.out.printf("%d / %s / %s / %s / %d / %s / %s / %s / %s \n",
					result.getEmpId(), result.getEmpName(), result.getDepartmentTitle(),
					result.getJobName(), result.getSalary(), result.getPhone(),
					result.getEmail(), result.getHireDate(), result.getEntYN());
		
		} catch (SQLException e) {
			System.out.println("사번이 일치하는 사원 조회 중 오류가 발생했습니다.");
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * 4. 사원 정보 추가(INSERT)
	 */
	private void insertEmp() {
		System.out.println("*****  4. 사원 정보 추가 *****");
		
		System.out.print("입력할 사원의 이름 : ");
		String name = sc.nextLine();
		
		System.out.print("입력할 사원의 주민등록번호 : ");
		String no = sc.nextLine();
		
		System.out.print("입력할 사원의 이메일 : ");
		String email = sc.nextLine();
		
		System.out.print("입력할 사원의 전화번호 : ");
		String phone = sc.nextLine();
		
		System.out.print("입력할 사원의 부서코드 : ");
		String deptcode = sc.nextLine();
		
		System.out.print("입력할 사원의 잡코드 : ");
		String jobcode = sc.nextLine();
		
		System.out.print("입력할 사원의 급여 레벨 : ");
		String sallevel = sc.nextLine();
		
		System.out.print("입력할 사원의 급여 : ");
		int salary = sc.nextInt();
		sc.nextLine();
		
		System.out.print("입력할 사원의 보너스 : ");
		double bonus = sc.nextDouble();
		sc.nextLine();
		
		System.out.print("입력할 사원의 사수 : ");
		String managerid = sc.nextLine();
		
		
		try {
			int result = service.insertEmp(name, no, email, phone, deptcode, 
					jobcode, sallevel, salary, bonus, managerid);
			
			String src = "";
			if (result>0) 	src = "사원 정보 추가 성공!";
			else 			src = "사원 정보 추가 실패";
			
			System.out.println(src);
			
			
		} catch (SQLException e) {
			System.out.println("사원 정보 추가 중 오류가 발생했습니다.");
			e.printStackTrace();
		}
		
		
		
		
		
	}
	

	
	/**
	 * 5. 사번으로 사원 정보 수정(UPDATE)
	 */
	private void updateEmp() {
	System.out.println("*****  5. 사번으로 사원 정보 수정 *****");
		
		System.out.print("수정할 사원 번호 : ");
		String empId = sc.nextLine();
		
		System.out.print("수정할 이메일 : ");
		String email = sc.nextLine();
		
		System.out.print("수정할 전화번호 : ");
		String phone = sc.nextLine();
		
		System.out.print("수정할 급여 : ");
		int salary = sc.nextInt();
		sc.nextLine();
		
		System.out.print("수정할 보너스 : ");
		double bonus = sc.nextDouble();
		sc.nextLine();
		
		
		try {
			int result = service.updateEmp(empId, email, phone, salary, bonus);
			
			String src = "";
			if (result>0) 	src = "사원 정보 수정 성공!";
			else 			src = "사원 정보 수정 실패";
			
			System.out.println(src);
			
		} catch (SQLException e) {
			System.out.println("사번으로 사원 정보 수정 중 오류가 발생했습니다.");
			e.printStackTrace();
		}		
	}
	

	
	/**
	 * 6. 사번으로 사원 정보 삭제
	 */
	private void deleteEmp() {
	System.out.println("*****  6. 사번으로 사원 정보 삭제 *****");
		
		System.out.print("삭제할 사원 번호 : ");
		String input = sc.nextLine();
		
		System.out.println("정말 삭제하시겠습니까? (Y/N) : ");
		char check = sc.nextLine().toUpperCase().charAt(0);
		
		if(check == 'N') {
			System.out.println("처음으로 돌아갑니다.");
			return;
		}
		if(check != 'Y') {
			System.out.println("Y 또는 N 을 입력해 주세요"); 
			return;
		}
		try {
			int result = service.deleteEmp(input);
			String src = "";
			if (result>0) 	src = "사원 정보 삭제 성공!";
			else 			src = "사원 정보 삭제 실패";
			
			System.out.println(src);
		} catch (SQLException e) {
			System.out.println("사번으로 사원 정보 삭제 중 오류가 발생했습니다.");
			e.printStackTrace();
		}
	}
	
	
	

	/**
	 * 7. 사번이 일치하는 사원 퇴직 처리
	 */
	private void updateEmpEnt() {

		System.out.println("***** 7. 사번이 일치하는 사원 퇴직 처리 *****");
		
		System.out.print("퇴직 처리 할 사원 번호 : ");
		String input = sc.nextLine();
		
		System.out.println("정말 퇴직 처리 하시겠습니까? (Y/N) : ");
		char check = sc.nextLine().toUpperCase().charAt(0);
		if(check == 'N') {
			System.out.println("처음으로 돌아갑니다.");
			return;
		}
		if(check != 'Y') {
			System.out.println("Y 또는 N 을 입력해 주세요"); 
			return;
		}
		
		try {
			int result = service.updateEmpEnt(input);
			String src = "";
			if (result>0) 	src = "퇴직 처리 성공!";
			else 			src = "사번이 일치하지 않거나, 이미 퇴직된 사원입니다";
			System.out.println(src);
		} catch (SQLException e) {
			System.out.println("사번으로 사원 정보 삭제 중 오류가 발생했습니다.");
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * 8. 가장 최근 입사한 사원 5명 조회
	 */
	private void rankEmp() {
		System.out.println("***** 가장 최근 입사한 사원 5명 조회  *****");
	
		
		try {
			List<Emp> empList = service.rankEmp();
			
	
			for (Emp emp : empList) {
					
					int empId = emp.getEmpId();
					String empName = emp.getEmpName();
					String deptTitle = emp.getDepartmentTitle();
					Date hireDate = emp.getHireDate();
					
					System.out.printf("%d / %s / %s / %s \n",
							empId, empName, deptTitle, hireDate.toString());
				}
			
		} catch (SQLException e) {
			System.out.println("가장 최근 입사한 사원 5명 조회 중 오류가 발생했습니다.");
			e.printStackTrace();
		}
	}
		
	
	private void deptStatistic() {
		
		try {
			
			Map<String, Object> empMap = service.deptStatistic();
	
			for (Emp emp : empMap) {
					
					int empId = emp.getEmpId();
					String empName = emp.getEmpName();
					String deptTitle = emp.getDepartmentTitle();
					Date hireDate = emp.getHireDate();
					
					System.out.printf("%d / %s / %s / %s \n",
							empId, empName, deptTitle, hireDate.toString());
				}
			
		} catch (SQLException e) {
			System.out.println("가장 최근 입사한 사원 5명 조회 중 오류가 발생했습니다.");
			e.printStackTrace();
		}
		
		
	}
		
	
	
	
	
	
	
}
