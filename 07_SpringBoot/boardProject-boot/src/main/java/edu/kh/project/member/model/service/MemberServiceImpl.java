package edu.kh.project.member.model.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.project.member.model.dao.MemberDAO;
import edu.kh.project.member.model.dto.Member;

@Service // Service Layer
		// 비즈니스 로직(데이터 가공, DAO호출, 트랜잭션 제어)처리하는 클래스라 명시
		// + Bean 등록하는 어노테이션
public class MemberServiceImpl implements MemberService{
	
	private Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	@Autowired
	private MemberDAO dao;
	
	
	@Autowired // bean으로 등록된 객체 중 타입이 일치하는 객체를 DI
	private BCryptPasswordEncoder bcrypt;
	
	

	@Override
	public Member login(Member inputMember) {
		
		// 로그 출력
		logger.info("MemberService.login() 실행");// 정보 출력
		logger.debug("memberEmail : " + inputMember.getMemberEmail());
		logger.warn("이건 경고 용도");
		logger.error("이건 오류 발생 시");
		

		Member loginMember = dao.login(inputMember);
		
		if(loginMember != null) { // 아이디가 일치하는 회원이 조회된 경우

			if(bcrypt.matches(inputMember.getMemberPw(),
							  loginMember.getMemberPw())) {
				
				loginMember.setMemberPw(null);
				
			} else { // 다를 경우
				loginMember = null; // 로그인 실패처럼 만듦
			}
			
		}
		
		return loginMember;
	}

	
	// 회원 가입 서비스
	@Transactional(rollbackFor = {Exception.class}) 
	@Override
	public int signUp(Member inputMember) {
		
		// 비밀번호를 BCrypt를 이용하여 암호화 후 다시 inputMember에 세팅
		String encPw = bcrypt.encode(inputMember.getMemberPw());
		inputMember.setMemberPw(encPw);
		
		// DAO 호출
		int result = dao.signUp(inputMember);
		
		return result;
	}
	
	
	
	
	
	
	
	
	
}