package edu.kh.jdbc.member.main.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.jdbc.common.Session;
import edu.kh.jdbc.member.model.dto.Member;
import edu.kh.jdbc.member.model.service.MemberService;

/** 회원 전용 화면
 * @autho 김자민 (grainbite@gmail.com)
 */
public class MemberView {
	
	private Scanner sc = new Scanner(System.in);
	private MemberService service = new MemberService();
	
	/**
	 * 회원 기능 메뉴
	 */
	public void memberMenu() {
		
		int input = 0;
		
		do {
			try {
				System.out.println("\n===== 회원 기능 =====\n");
				System.out.println("1. 내 정보 조회");
				System.out.println("2. 회원 목록 조회(아이디, 이름, 성별)");
				System.out.println("3. 내 정보 수정(이름, 성별)");
				System.out.println("4. 비밀번호 변경(현재 비밀번호, 새 비밀번호, 새 비밀번호 확인)");
				System.out.println("5. 회원 탈퇴(보안코드, 비밀번호, 삭제 여부 컬럼 update)");
				
				System.out.println("9. 메인 메뉴로 돌아가기");
				System.out.println("0. 프로그램 종료");
				
				System.out.print("\n메뉴 선택 : ");
				input = sc.nextInt();
				sc.nextLine(); // 입력 버퍼 개행 문자 제거
				
				switch(input) {
				case 1 : selectMyInfo(); break;
				case 2 : selectMemberList(); break;
				case 3 : break;
				case 4 : break;
				case 5 : break;
				case 9 : 
					break;
				case 0 : 
					System.out.println("\n===== 프로그램 종료 =====\n");
					// JVL 강제 종료 구문. 매개변수는 기본 (0)
					// 만약 다른 숫자를 넣을 시 오류를 의미
					System.exit(0);
					// Terminates the currently running Java Virtual Machine.
					
				default : System.out.println("\n*** 메뉴 번호만 입력 해주세요 ***\n");
				}
				
			}catch (InputMismatchException e) {
				System.out.println("*** 입력 형식이 올바르지 않습니다. ***");
				sc.nextLine(); // 입력 버퍼에 잘못된 문자열 제거
				input = -1; // while문 종료 방지
			}
		} while (input != 9);
		
	}
	
	
	
	
	
	
	/** 회원 기능 메뉴
	 * 1. 내 정보 조회
	 */
	private void selectMyInfo() {
		
		System.out.println("\n===== 내 정보 조회 =====\n");
		// 회원 번호, 아이디, 이름, 성별(남/여), 가입일
		// Session.loginMember 이용
		System.out.println("회원 번호 : " + Session.loginMember.getMemberNo());
		System.out.println("회원 아이디 : " + Session.loginMember.getMemberId());
		System.out.println("회원 이름 : " + Session.loginMember.getMemberName());
		
		if(Session.loginMember.getMemberGender().equals("M")) {
			System.out.println("성별 : 남");
		} else {
			System.out.println("성별 : 여");
		}
		
		System.out.println("가입일 : " + Session.loginMember.getEnrollDate());
		
		}
	
	
	
	
	/** 회원 기능 메뉴
	 * 2. 회원 목록 조회(아이디, 이름, 성별)
	 */
	private void selectMemberList() {
		System.out.println("\n===== 회원 목록 조회 =====\n");
		
		try {
			// 회원 목록 조회 서비스 호출 후 결과 반환 받기
			List<Member> memberList = service.selectMemberList();
			
			if(memberList.isEmpty()) {
				System.out.println("\n***조회 결과가 없습니다.***\n");
				return; // 로그인을 해서 들어오는게 전제이니 무조건 실행 안 됨
			}
			
			
			int number = 0;
			for(Member member : memberList) {
				
				String memberId = member.getMemberId();
				String memberName = member.getMemberName();
				String memberGender = member.getMemberGender();
				number++;
				
				System.out.printf("%d\t\t%s\t\t%s\t\t%s \n", 
						number, memberId, memberName, memberGender );
				
			}
			
		} catch(Exception e) {
			System.out.println("\n***회원 목록 조회 중 예외 발생***\n");
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	
	

}
