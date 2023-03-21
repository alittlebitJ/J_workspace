package edu.kh.jdbc.model.dao;


import static edu.kh.jdbc.common.JDBCTemplate.*;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jdbc.common.JDBCTemplate;
import edu.kh.jdbc.model.dto.Employee;

// DAO (Data Access Object) : DB 접근용 객체
public class EmployeeDAO {

	
	// JDBC 구문이 여러 번 작성 될 예정
	// JDBC 객체 참조 변수가 계속 작성될 예정(필드로 작성하여 재사용)
	
	
	private Statement stmt;
	private ResultSet rs;

	/** 전체 사원 조회 SQL 수행 후 결과 반환 메서드
	 * @param conn
	 * @return empList
	 * @throws SQLException
	 */
	public List<Employee> selectAll(Connection conn) throws SQLException {
		
		// 1. 결과 저장을 위한 변수/객체 준비
		List<Employee> empList = new ArrayList<>();
		
		try {
			// 2. Statement, ResultSet에 객체 대입
			// 1) SQL 작성 사번, 이름, 부서명, 직급명, 전화번호
			 String sql = "SELECT EMP_ID , EMP_NAME , NVL(DEPT_TITLE, '없음'), JOB_NAME, NVL(PHONE, '없음')\r\n"
			 		+ "FROM EMPLOYEE \r\n"
			 		+ "NATURAL JOIN JOB LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)\r\n"
			 		+ "ORDER BY JOB_CODE ";
			 stmt = conn.createStatement(); // Statement 객체 생성
			 rs = stmt.executeQuery(sql);
			 
			 // 3. 조회 결과 1행씩 접근하여 컬럼 값을 얻어와 List에 담기
			 while (rs.next()) {
				 
				 String empId = rs.getString("EMP_ID");
				 String empName = rs.getString("EMP_NAME");
				 String departmentName = rs.getString(3);
				 String jobName = rs.getString("JOB_NAME");
				 String phone = rs.getString(5);
				 
				 Employee emp = new Employee(Integer.parseInt(empId), empName, phone, departmentName, jobName);
				empList.add(emp);
			 }
			 
	} finally {
		// catch 문 대신 throws 구문으로 예외 처리 ( throws SQLException )
		// 4. JDBC 객체 자원 반환 (단, conn 빼고)
//		JDBCTemplate.close(rs);
		close(rs);
		close(stmt);
	}
		return empList;
	}

	
	
	/** 사원 1명 정보 조회 SQL 수행 후 결과 반환 메서드
	 * @param conn
	 * @param input
	 * @return
	 */
	public Employee selectOne(Connection conn, int input) throws SQLException {
		// 1. 결과 저장을 위한 변수/객체 준비
		Employee emp = null;
		// -> 조회 결과가 있을 경우에 객체 생성
		
		try {
			// 2. sql 작성 후 수행
			String sql = "SELECT EMP_ID , EMP_NAME , NVL(DEPT_TITLE, '없음'), JOB_NAME, NVL(PHONE, '없음')\r\n"
					+ "FROM EMPLOYEE \r\n"
					+ "NATURAL JOIN JOB LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)\r\n"
					+ "WHERE EMP_ID = " + input;

			 stmt = conn.createStatement(); // Statement 객체 생성
			 rs = stmt.executeQuery(sql);
			
			 
			 // 3. 조회 결과가 있는지 확인 후 있으면 Employee 객체 생성 후 emp에 대입
			 // (결과가 있다 = 1행이 있다)
			 
			// if(조건식) true 이면 수행 --> 1번 수행
			// while(조건식) true 이면 수행 + 반복 -->1행만 조회 되면 1번 수행
			// => 불필요한 검사를 진행할 수 있다 : 1행 조회에서는 if문 권장
			 
			if(rs.next()) {
				int empId = rs.getInt(1);
				// DB에서 값을 얻어 올 때, "숫자"(문자열로 된 숫자) 형태일 경우, getInt()를 작성하면 자동으로 int 형변환 진행 
				 String empName = rs.getString(2);
				 String departmentName = rs.getString(3);
				 String jobName = rs.getString(4);
				 String phone = rs.getString(5);
				 
				 
				 // 객체 생성해서 emp에 대입
				 emp = new Employee(empId, empName, phone, departmentName, jobName);
			}
			 
		} finally {
			// 4. JDBC 객체 자원 반환 (conn 빼고)
			close(rs);
			close(stmt);
		}
		// 5. 결과 반환
		return emp;
	}



	/** 글자 포함 이름 조회 SQL 수행 후 결과 반환 메서드
	 * @param conn
	 * @param input
	 * @return empList
	 * @throws SQLException
	 */
	public List<Employee> selectName(Connection conn, String input) throws SQLException {
		
		// 1. 결과 저장을 위한 변수 선언
		List<Employee> empList = new ArrayList<>();
		
		// 2. sql 작성 후 수행
		
		try {
		String sql = "SELECT EMP_ID , EMP_NAME , DEPT_TITLE, JOB_NAME, PHONE\r\n"
				+ "FROM EMPLOYEE \r\n"
				+ "NATURAL JOIN JOB \r\n"
				+ "LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)\r\n"
				+ "WHERE EMP_NAME LIKE '%"+ input +"%' "
				+ "ORDER BY EMP_ID ";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				int empId = rs.getInt(1);
				String empName = rs.getString(2);
				String departmentName = rs.getString(3);
				String jobName = rs.getString(4);
				String phone = rs.getString(5);
				
				empList.add(new Employee(empId, empName, phone, departmentName, jobName));
				
			}
			
			
		
		} finally {
			// 4. JDBC 객체 자원 반환 (conn 빼고)
			close(rs);
			close(stmt);
		}
		
		// 5. 결과 반환
		return empList;
	}



	public List<Employee> selectSalary(Connection conn, int input1, int input2) throws SQLException {
		
		List<Employee> empList = new ArrayList<>();
		
		try {
		String sql = "SELECT EMP_ID , EMP_NAME , DEPT_TITLE, JOB_NAME, SALARY \r\n"
				+ "	FROM EMPLOYEE \r\n"
				+ "	NATURAL JOIN JOB \r\n"
				+ "	LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)\r\n"
				+ "	WHERE SALARY BETWEEN "+ input1 +" AND "+ input2+ "\r\n"
				+ "	ORDER BY SALARY";
		
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		
		
		while(rs.next()) {
			
			
			int empId = rs.getInt(1);
			String empName = rs.getString(2);
			String departmentName = rs.getString(3);
			String jobName = rs.getString(4);
			int salary = rs.getInt("SALARY");
			
			Employee emp = new Employee(empId, empName, departmentName, jobName, salary);
			empList.add(emp);
			
		}
		} finally {
			close(rs);
			close(stmt);
		}
		
		return empList;
	}
	
	
}
	
	
	
	

