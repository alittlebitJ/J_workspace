package edu.kh.jdbc.main.model.service;
import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;

import edu.kh.jdbc.main.model.dao.MainDAO;
import edu.kh.jdbc.member.model.dto.Member;

public class MainService {
	
	private MainDAO dao = new MainDAO();

	/**회원제 게시판 프로그램 메인 
	 * 1. 로그인 서비스
	 * @param memberId
	 * @param memberPw
	 * @return member
	 * @throws Exception
	 */
	public Member login(String memberId, String memberPw) throws Exception {
		Connection conn = getConnection(); // 1. Connection 생성
		Member member = dao.login(conn, memberId, memberPw); // 2. DAO 호출
		close(conn);// 3. Connection 반환	
		return member; // 4. 결과 반환
	}

	/**회원제 게시판 프로그램 메인 
	 * 2. 회원 가입
	 * ID 중복 확인 검사 서비스
	 * @return result
	 * @throws Exception
	 */
	public int idDuplicationCheck(String memberId) throws Exception {
		Connection conn = getConnection();
		int result = dao.idDuplicationCheck(conn, memberId);
		close(conn);
		return result;
	}

	/**회원제 게시판 프로그램 메인 
	 * 2. 회원 가입
	 * 회원 정보 삽입 서비스
	 * @param member
	 * @return result
	 * @throws Exception
	 */
	public int signUp(Member member) throws Exception{
		Connection conn = getConnection();
		// DAO 호출
		int result = dao.signUp(conn, member);
		// 트랜잭션 처리
		if(result>0) 	commit(conn);
		else 			rollback(conn);
		// 커낵션 반환
		close(conn);
		// 결과 반환
		return result;
	}

}
