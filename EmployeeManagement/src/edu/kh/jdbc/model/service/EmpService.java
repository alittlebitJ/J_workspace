package edu.kh.jdbc.model.service;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import edu.kh.jdbc.model.dao.EmpDAO;
import edu.kh.jdbc.model.dto.Emp;

public class EmpService {

	private EmpDAO dao = new EmpDAO();

	/** 1. 재직중인 사원 전체 조회
	 * @return empList
	 * @throws SQLException
	 */
	public List<Emp> selectEmp() throws SQLException {
		
		Connection conn = getConnection(); // 커넥션 연결
		List<Emp> empList = dao.selectEmp(conn); // dao return값을 담음
		close(conn); // 커넥션 반환
		
		return empList; // 결과 반환
	}

	/**2. 퇴직한 사원 전체 조회
	 * @return empList
	 * @throws SQLException
	 */
	public List<Emp> selectEmpEnt() throws SQLException {
		
		Connection conn = getConnection();
		List<Emp> empList = dao.selectEmpEnt(conn);
		close(conn);
		
		return empList;
	}

	/**3. 사번이 일치하는 사원 조회
	 * @param input
	 * @return result
	 * @throws SQLException
	 */
	public Emp selectEmpId(int input) throws SQLException {
		Connection conn = getConnection(); // 커넥션 연결
		Emp result = dao.selectEmpId(conn, input); // dao return값을 받음
		close(conn); // 커넥션 반환
		return result; // 결과값 반환
	}

	public int insertEmp(String name, String no, String email, String phone, String deptcode, String jobcode,
			String sallevel, int salary, double bonus, String managerid) throws SQLException {
		Connection conn = getConnection();
		int result = dao.insertEmp(conn, name, no, email, phone, deptcode, 
				jobcode, sallevel, salary, bonus, managerid);
		if (result > 0) commit(conn);
		else rollback(conn);
		return result;
	}

	/** 5. 사번으로 사원 정보 수정(UPDATE)
	 * @param empId
	 * @param email
	 * @param phone
	 * @param salary
	 * @param bonus
	 * @return
	 * @throws SQLExcpetion
	 */
	public int updateEmp(String empId, String email, String phone, int salary, double bonus) throws SQLException {
		Connection conn = getConnection();
		int result = dao.updateEmp(conn, empId, email, phone, salary, bonus);
		if (result > 0) commit(conn);
		else rollback(conn);
		return result;
	}

	/**6. 사번으로 사원 정보 삭제
	 * @param input
	 * @return result
	 * @throws SQLException
	 */
	public int deleteEmp(String input) throws SQLException {
		Connection conn = getConnection();
		int result = dao.updateEmp(conn, input);
		if (result > 0) commit(conn);
		else rollback(conn);
		return result;
	}

	/** 7. 사번이 일치하는 사원 퇴직 처리
	 * @param input
	 * @return result
	 * @throws SQLException
	 */
	public int updateEmpEnt(String input) throws SQLException {
		Connection conn = getConnection();
		int result = dao.updateEmpEnt(conn, input);
		if (result > 0) commit(conn);
		else rollback(conn);
		return result;
	}

	/** 8. 가장 최근 입사한 사원 5명 조회
	 * @return empList
	 * @throws SQLException
	 */
	public List<Emp> rankEmp() throws SQLException {
		Connection conn = getConnection(); // 커넥션 연결
		List<Emp> empList = dao.rankEmp(conn); // dao return값을 담음
		close(conn); // 커넥션 반환
		return empList; // 결과 반환
	}

	public Map<String, Object> deptStatistic() throws SQLException {
		Connection conn = getConnection(); // 커넥션 연결
		Map<String, Object> empMap = dao.deptStatistic(conn); // dao return값을 담음
		close(conn); // 커넥션 반환
		return empMap; // 결과 반환
	}





}
