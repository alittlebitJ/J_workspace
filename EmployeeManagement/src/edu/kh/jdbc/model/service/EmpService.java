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

	/** 1. 재직중인 사원 정보 반환 서비스
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

	/**4. 사원 정보 추가(INSERT)
	 * @param name
	 * @param no
	 * @param email
	 * @param phone
	 * @param deptcode
	 * @param jobcode
	 * @param sallevel
	 * @param salary
	 * @param bonus
	 * @param managerid
	 * @return reuslt
	 * @throws SQLException
	 */
	public int insertEmp(String name, String no, String email, String phone, String deptcode, String jobcode,
			String sallevel, int salary, double bonus, String managerid) throws SQLException {
		Connection conn = getConnection();
		int result = dao.insertEmp(conn, name, no, email, phone, deptcode, 
				jobcode, sallevel, salary, bonus, managerid);
		if (result > 0) commit(conn);
		else rollback(conn);
		return result;
	}

	/** 5. 사번으로 사원 정보 수정(UPDATE) 서비스
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
		// DML 수행 -> 트랜잭션 처리
		if (result > 0) commit(conn); 
		else rollback(conn);
		return result;
		
		// 반환형이 int인 이유 : DML 수행 결과는 반영된(성공) 행의 개수를 반환. 행의 개수는 정수형이라 int 사용
		
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
	 * @throws SQLException
	 */
	public void updateEmpEnt(String input) throws SQLException {
		Connection conn = getConnection();
		dao.updateEmpEnt(conn, input); // 무조건 성공 또는 예외만 발생하기 때문에 반환 할 필요 없음
		commit(conn); // 성공할 경우만 시행되기 때문에 그냥 commit, DB 예외 발생 시 SQL 수행이 정상적으로 진행되지 않음
		close(conn);
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

	public List<Map> deptStatistic() throws SQLException {
		Connection conn = getConnection(); // 커넥션 연결
		List<Map> empList = dao.deptStatistic(conn); // dao return값을 담음
		close(conn); // 커넥션 반환
		return empList; // 결과 반환
	}

	/** 7. 사번이 일치하는 사원 퇴직 처리에서 사원이 존재하는지, 존재하지만 퇴직한 사원인지 체크
	 * @param input
	 * @return check(0:없는 사원/1:퇴직한 사원/2:재직중인 사원)
	 * @throws SQLException 
	 */
	public int checkEmployee(String input) throws SQLException{
		Connection conn = getConnection();
		int check = dao.checkEmployee(conn, input);
		close(conn);
		return check;
	}





}
