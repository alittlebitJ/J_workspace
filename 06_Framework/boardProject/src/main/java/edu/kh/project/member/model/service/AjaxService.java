package edu.kh.project.member.model.service;

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

}
