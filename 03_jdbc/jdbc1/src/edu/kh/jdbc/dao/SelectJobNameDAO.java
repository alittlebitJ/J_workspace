package edu.kh.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jdbc.dto.Employee2;

public class SelectJobNameDAO {
	// 조회된 사원 정보를 저장할 List
	List<Employee2> empList = new ArrayList<>();

	public List<Employee2> select(String input) {
		// JDBC 객체 정보 선언
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			// 드라이버 객체 메모리에 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// DB 연결 정보
			String type = "jdbc:oracle:thin:@";
			String ip = "115.90.212.22"; 
			String port = ":9000"; 
			String dbName = ":XE"; 
			String user = "kh_kjm";
			String pw = "oracle_kjm123A";
			
			// Connection 얻어오기
			conn = DriverManager.getConnection(type+ip+port+dbName, user, pw);
			
			String sql = "SELECT NVL(DEPT_TITLE, '부서없음'), JOB_NAME, EMP_NAME , EMAIL  "
					+ "FROM EMPLOYEE  "
					+ "LEFT JOIN DEPARTMENT ON (DEPT_ID = DEPT_CODE) "
					+ "LEFT JOIN JOB USING (JOB_CODE) "
					+ "WHERE JOB_NAME = '" + input  + "'"
					+ " ORDER BY EMP_NAME";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			// 1행씩 조회
			while (rs.next()) {
				
				String deptTitle = rs.getString(1); // 만약 컬럼명을 쓸거면 "NVL(DEPT_TITLE, '부서없음')" 그대로 적어줘야 함(별칭도 가능)
				String jobName = rs.getString(2);
				String empName = rs.getString(3);
				String email = rs.getString(4);
				// 얻어온 컬럼 값을 한번에 저장하여 전달할 Employee2 객체 생성
				Employee2 emp = new Employee2(deptTitle, jobName, empName, email);
				
				// Employee2 객체를 empList에 추가
				empList.add(emp);
				
			}
		
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return empList;
	}
	
}
