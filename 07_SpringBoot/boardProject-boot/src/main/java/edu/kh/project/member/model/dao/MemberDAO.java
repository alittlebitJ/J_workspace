package edu.kh.project.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.member.model.dto.Member;

@Repository
public class MemberDAO {
	
	@Autowired
	private MemberMapper memberMapper; // 인터페이스를 상속 받은 자식 객체 (자식 객체가 SqlSessionTemplate을 이용)
	
	/** 로그인
	 * @param inputMember
	 * @return loginMember
	 */
	public Member login(Member inputMember) {
		// 이전 : sqlSession.selectOne("memberMapper.login", inputMember);
		// 지금
		return memberMapper.login(inputMember); 
	}

	public int signUp(Member inputMember) {
		return memberMapper.signUp(inputMember);
	}
	
	
	
}