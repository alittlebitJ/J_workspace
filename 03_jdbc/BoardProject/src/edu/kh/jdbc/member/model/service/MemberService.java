package edu.kh.jdbc.member.model.service;
import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import edu.kh.jdbc.member.model.dao.MemberDAO;
import edu.kh.jdbc.member.model.dto.Member;


public class MemberService {
	
	private MemberDAO dao = new MemberDAO();
	
	/** 회원 기능 메뉴
	 * 2. 회원 목록 조회(아이디, 이름, 성별) 서비스
	 * @return memberList
	 * @throws Exception
	 */
	public List<Member> selectMemberList() throws Exception {
		Connection conn = getConnection(); 
		List<Member> memberList = dao.selectMemberList(conn);
		close(conn);
		return memberList;
	}
	

}
