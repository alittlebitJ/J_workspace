package edu.kh.jdbc.model.dao;
import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import edu.kh.jdbc.model.dto.Emp;

public class EmpDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	/**1. 재직중인 사원 전체 조회
	 * @param conn
	 * @return empList
	 * @throws SQLException
	 */
	public List<Emp> selectEmp(Connection conn) throws SQLException {
		// 결과를 받기 위한 변수 생성
		List<Emp> empList = new ArrayList<Emp>();
		
		try {
			// Statement 구문 입력
			String sql = "SELECT EMP_ID , EMP_NAME , DEPT_TITLE, JOB_NAME, SALARY , PHONE , EMAIL \r\n"
					+ "FROM EMPLOYEE \r\n"
					+ "NATURAL JOIN JOB \r\n"
					+ "LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)\r\n"
					+ "WHERE ENT_YN = 'N'\r\n"
					+ "ORDER BY JOB_CODE";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			// 결과값 list에 입력
			while(rs.next()) {
				
				int empId = rs.getInt(1);
				String empName = rs.getString(2);
				String deptTitle = rs.getString(3);
				String jobName = rs.getString(4);
				int salary = rs.getInt(5);
				String phone = rs.getString(6);
				String email = rs.getString(7);
				
				Emp emp = new Emp(empId, empName, deptTitle, jobName, salary, phone, email);
				empList.add(emp);
				
				}
			
		} finally { // rs, stmt 반환
			close(rs);
			close(stmt);
		}
		// 결과값 반환
		return empList;
	}


	/** 2. 퇴직한 사원 전체 조회
	 * @param conn
	 * @return empList
	 */
	public List<Emp> selectEmpEnt(Connection conn) throws SQLException {
		// 결과를 받기 위한 변수 생성
		List<Emp> empList = new ArrayList<Emp>();
		
		try {
			// Statement 구문 입력
			String sql = "SELECT EMP_ID , EMP_NAME , PHONE , EMAIL , ENT_DATE \r\n"
					+ "FROM EMPLOYEE \r\n"
					+ "WHERE ENT_YN = 'Y'\r\n"
					+ "ORDER BY ENT_DATE ";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			// 결과값 list에 입력
			while(rs.next()) {
				
				int empId = rs.getInt(1);
				String empName = rs.getString(2);
				String phone = rs.getString(3);
				String email = rs.getString(4);
				String entDate = rs.getString(5);
				
				Emp emp = new Emp();
					emp.setEmpId(empId);
					emp.setEmpName(empName);
					emp.setPhone(phone);
					emp.setEmail(email);
					emp.setEntDate(entDate);
					
				empList.add(emp);
				
				}
			
		} finally { // rs, stmt 반환
			close(rs);
			close(stmt);
		}
		// 결과값 반환
		return empList;
	}


	/**3. 사번이 일치하는 사원 조회
	 * @param input
	 * @return reuslt
	 */
	public Emp selectEmpId(Connection conn, int input) throws SQLException {
		Emp result = null; // 결과를 받아올 변수 선언
		
		try {
			// PreparedStatement
			String sql = "SELECT EMP_ID , EMP_NAME , DEPT_TITLE, JOB_NAME, SALARY , PHONE , EMAIL, HIRE_DATE , ENT_YN  \r\n"
					+ "FROM EMPLOYEE \r\n"
					+ "NATURAL JOIN JOB \r\n"
					+ "LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)\r\n"
					+ "WHERE EMP_ID = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, input);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				int empId = rs.getInt(1);
				String empName = rs.getString(2);
				String DepartmentTitle = rs.getString(3);
				String jobName = rs.getString(4);
				int salary = rs.getInt(5);
				String phone = rs.getString(6);
				String email = rs.getString(7);
				Date hireDate = rs.getDate(8);
				String entYN = rs.getString(9);

				result = new Emp(empId, empName, DepartmentTitle, jobName, salary, phone, email, hireDate, entYN);
			}
				
		} finally {
			close(pstmt);
		}
		return result;
	}


	public int insertEmp(Connection conn, String name, String no, String email, String phone, String deptcode,
			String jobcode, String sallevel, int salary, double bonus, String managerid) 
	throws SQLException {
		
		int result = 0;
		
		try {
			String sql = "INSERT INTO EMPLOYEE \r\n"
					+ "VALUES (SQ_INSERT_EMP.NEXTVAL, ?, ?, "
					+ "?, ?, ?, ?, ?, "
					+ "?, ?, ?, SYSDATE, NULL, 'N')";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, name);
			pstmt.setString(2, no);
			pstmt.setString(3, email);
			pstmt.setString(4, phone);
			pstmt.setString(5, deptcode);
			pstmt.setString(6, jobcode);
			pstmt.setString(7, sallevel);
			pstmt.setInt(8, salary);
			pstmt.setDouble(9, bonus);
			pstmt.setString(10, managerid);
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		return result;
	}


	public int updateEmp(Connection conn, String empId, String email, String phone, int salary, double bonus) throws SQLException{
		int result = 0;
		
		try {
			
			String sql = "UPDATE EMPLOYEE\r\n"
					+ "SET EMAIL = ?,\r\n"
					+ "	PHONE  = ?,\r\n"
					+ "	SALARY = ?,\r\n"
					+ "	BONUS = ?\r\n"
					+ "WHERE EMP_ID = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, email);
			pstmt.setString(2, phone);
			pstmt.setInt(3,  salary);
			pstmt.setDouble(4, bonus);
			pstmt.setString(5, empId);
			
			result = pstmt.executeUpdate();
			
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}


	public int updateEmp(Connection conn, String input) throws SQLException {
		int result = 0;
		try {
			String sql = "DELETE FROM EMPLOYEE \r\n"
					+ "WHERE EMP_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, input);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		return result;
	}


	public int updateEmpEnt(Connection conn, String input) throws SQLException {
		int result = 0;
		try {
			String sql = "UPDATE EMPLOYEE \r\n"
					+ "SET ENT_YN = 'Y',\r\n"
					+ "	ENT_DATE = SYSDATE \r\n"
					+ "WHERE EMP_ID = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, input);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		return result;
	}


	public List<Emp> rankEmp(Connection conn) throws SQLException{
		List<Emp> empList = new ArrayList<Emp>();
		
		try {
			// Statement 구문 입력
			String sql = "SELECT EMP_ID , EMP_NAME, DEPT_TITLE, HIRE_DATE FROM (\r\n"
					+ "SELECT EMP_ID, EMP_NAME, DEPT_TITLE, HIRE_DATE, RANK() OVER(ORDER BY HIRE_DATE DESC) 순위\r\n"
					+ "FROM EMPLOYEE LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID))\r\n"
					+ "WHERE 순위 <= 5";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			// 결과값 list에 입력
			while(rs.next()) {
				
				int empId = rs.getInt(1);
				String empName = rs.getString(2);
				String deptTitle = rs.getString(3);
				Date hireDate = rs.getDate(4);
				
				Emp emp = new Emp();
					
					emp.setEmpId(empId);
					emp.setEmpName(empName);
					emp.setDepartmentTitle(deptTitle);
					emp.setHireDate(hireDate);
				
				empList.add(emp);
				
				}
			
		} finally { // rs, stmt 반환
			close(rs);
			close(stmt);
		}
		// 결과값 반환
		return empList;
	}


	public Map<String, Object> deptStatistic(Connection conn) throws SQLException {
		Map<String, Object> empMap = new LinkedHashMap<>();
		Map<Integer, Double> statistic = new HashMap();
		try {
		// Statement 구문 입력
		String sql = "SELECT DEPT_TITLE, COUNT(*), AVG(SALARY)\r\n"
				+ "FROM EMPLOYEE \r\n"
				+ "LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)\r\n"
				+ "GROUP BY DEPT_TITLE, DEPT_CODE \r\n"
				+ "ORDER BY DEPT_CODE;";
		
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		
		// 결과값 list에 입력
		while(rs.next()) {
			
			String deptTitle = rs.getString(1);
			int count = rs.getInt(2);
			double avg = rs.getDouble(3);
			
			statistic.put(count, avg);
			empMap.put(deptTitle, statistic.keySet());
			}
		}finally { // rs, stmt 반환
		close(rs);
		close(stmt);
	}
	// 결과값 반환
	return empMap;	
	}
	



	
	
	}
	
	

