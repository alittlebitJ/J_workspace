package edu.kh.project.member.model.service;

import java.util.List;

import edu.kh.project.member.model.dto.Member;

public interface AjaxService {

	/** nickName 선택
	 * @param email
	 * @return nickName
	 */
	String selectNickname(String email);

	/** memberTel 선택
	 * @param nickname
	 * @return tel
	 */
	String selectMemberTel(String nickname);

	/** email 중복 검사
	 * @param email
	 * @return count
	 */
	int checkEmail(String email);

	/** nickname 중복 검사
	 * @param nickname
	 * @return count
	 */
	int checkNickname(String nickname);

	/** 이메일로 회원 정보 조회
	 * @param email
	 * @return member
	 */
	Member selectMember(String email);

	/** 이메일이 일부라도 일치하는 모든 회원 조회
	 * @param input
	 * @return memberList
	 */
	List<Member> selectMemberList(String input);

}
