package edu.kh.jdbc.main.model.dao;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import edu.kh.jdbc.member.model.dto.Member;

public class MainDAO {
	
	// 필드
	// JDBC 객체 참조 변수
	
	private Statement stmt; // SQL 수행, 결과 반환
	private PreparedStatement pstmt; // placeholder를 포함한 SQL 세팅/수행 
	private ResultSet rs; // SELECT 수행 결과를 저장
	private Properties prop;
	// Properties : Map<String, String> 형태
	// 				XML 파일 입/출력 메서드 제공
	
	
	public MainDAO() { // 기본생성자
		// DAO 객체가 생성될 때 XML 파일을 읽어와 Properties 객체에 저장
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream("main-sql.xml"));
			// Properties 객체에 key:value 형식으로 작성된 xml내용이 저장됨
			// --> prop.getProperty("key") 호출 시 value(SQL)이 반환
			// properties는 key도 value도 String으로 제한되어 있으 sql문도 String으로 받아 올 것
			
		} catch(Exception e) {
			
		}
	
	}
	
	
	

	/**회원제 게시판 프로그램 메인 
	 * 1. 로그인 
	 * 아이디, 비밀번호 일치 회원 조회 SQL문 실행 후 결과 반환 
	 * @param conn
	 * @param memberId
	 * @param memberPw
	 * @return
	 * @throws Exception
	 */
	public Member login(Connection conn, String memberId, String memberPw) throws Exception {
		// 1. 결과 저장용 변수 선언/객체 생성
		Member member = null;
		
		try {
			String sql = prop.getProperty("login");
			
			// PreparedStatement 객체를 생성하고 SQL를 담아둠
			pstmt = conn.prepareStatement(sql);
			
			// plcaeholder에 알맞은 값 대입
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPw);
			
			// SELECT 수행 후 결과 반환 받기
			rs = pstmt.executeQuery();
			
			// 3. 조회 결과를 1행씩 접근해서 얻어오기
			
			if(rs.next()) {
				
				int memberNo = rs.getInt("MEMBER_NO");
				// String memberId = rs.getString("MEMBER_ID"); 
				// 입력 받은 아이디 == 조회한 아이디
				// 따로 DB에서 얻어올 필요가 없음 (사실 sql에서도 조회 안 해도 됨 혹시 모르니 그냥 둘 것)
				String memberName = rs.getString("MEMBER_NM");
				String memberGender = rs.getString("MEMBER_GENDER");
				String EnrollDate = rs.getString("ENROLL_DT");
				
				// Member 객체 생성 후 값 셋팅
				member = new Member();
				
				member.setMemberNo(memberNo);
				member.setMemberId(memberId);
				member.setMemberName(memberName);
				member.setMemberGender(memberGender);
				member.setEnrollDate(EnrollDate);
				
			}
			
		}finally {
			// 4. 사용한 JDBC 객체 자원 반환
			close(rs);
			close(pstmt);
		}
		return member;
	}




	/**회원제 게시판 프로그램 메인 
	 * 2. 회원 가입
	 * ID 중복 확인 검사 SELECT문 실행 후 결과 반환
	 * @param conn
	 * @param memberId
	 * @return result 
	 * @throws Exception
	 */
	public int idDuplicationCheck(Connection conn, String memberId) throws Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("idDuplicationCheck");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}




	/**회원제 게시판 프로그램 메인 
	 * 2. 회원 가입
	 * 회원 정보 삽입 SQL(INSERT) 수행 후 결과 반환
	 * @param conn
	 * @param member
	 * @return result
	 * @throws Exception
	 */
	public int signUp(Connection conn, Member member) throws Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("signUp");
			
			// placeholder에 값 세팅
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getMemberGender());
			
			// 수행 후 결과 반환
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		return result;
	}
}
