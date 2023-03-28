package edu.kh.jdbc.member.model.dao;

import static edu.kh.jdbc.common.JDBCTemplate.*;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.jdbc.common.Session;
import edu.kh.jdbc.member.model.dto.Member;

public class MemberDAO {
	
	// JDBC 객체 참조 변수
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	// xml에 작성된 SQL을 읽어와 저장할 객체 참조 변수
	private Properties prop;
	
	public MemberDAO() { // 기본 생성자로 객체 생성 시 xml 읽어오기
		
		try {

			prop = new Properties();
			prop.loadFromXML(new FileInputStream("member-sql.xml"));
			
		} catch (Exception e) {
			
		}
	}
	
	
	
	
	/** 회원 기능 메뉴
	 * 2. 회원 목록 조회(아이디, 이름, 성별) SQL 수행 후 반환
	 * @param conn
	 * @return memberList
	 * @throws Exception
	 */
	public List<Member> selectMemberList(Connection conn) throws Exception{
		// 결과 저장용 변수 선언 / 객체 생성
		List<Member> memberList = new ArrayList<>();
		
		try {
			
			String sql = prop.getProperty("selectMemberList");
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			// 한 행씩 반복적으로 접근을 하면서 필요한 요소를 꺼내 리스트에 입력
			while(rs.next()) {
			
				String memberId = rs.getString("MEMBER_ID");
				String memberName = rs.getString("MEMBER_NM");
				String memberGender = rs.getString("MEMBER_GENDER");

				// 컬럼 값을 Member 객체에 저장
				Member member = new Member();
				
				member.setMemberId(memberId);
				member.setMemberName(memberName);
				member.setMemberGender(memberGender);
				
				// Member 객체를 List에 추가
				memberList.add(member);
			
			} // while문 종료
			
		} finally {
			close(rs);
			close(stmt);
		}
		return memberList;
	}






	/**회원 기능 메뉴
	 * 3. 회원 정보 수정 SQL 구문 실행 후 반환
	 * @param conn
	 * @param memberName
	 * @param memberGender
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int updateMember(Connection conn, String memberName, String memberGender, int memberNo)  throws Exception
	{	// 1. 결과 저장용 변수 선언
		int result = 0;
		
		try {
			String sql = prop.getProperty("updateMember"); // SQL 작성, 수행
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberName);
			pstmt.setString(2, memberGender);
			pstmt.setInt(3, Session.loginMember.getMemberNo());
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		return result;
	}




	/** 4. 비밀번호 변경(현재 비밀번호, 새 비밀번호, 새 비밀번호 확인) SQL 실행 후 반환
	 * @param conn
	 * @param presentMemberPw
	 * @param newMemberPw
	 * @param memberNo
	 * @return
	 * @throws Exception
	 */
	public int updatePassword(Connection conn, String presentMemberPw, String newMemberPw, int memberNo) throws Exception{
		int result = 0;
		try {
			String sql = prop.getProperty("updatePassword");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newMemberPw);
			pstmt.setString(2, presentMemberPw);
			pstmt.setInt(3, memberNo);
			
			result = pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
		return result;
	}




	public int unregisterMember(Connection conn, String memberPw, int memberNo) throws Exception{
		int result = 0;
		
		try {
			String sql = prop.getProperty("unregisterMember");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			pstmt.setString(2, memberPw);
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		return result;
	}

}
