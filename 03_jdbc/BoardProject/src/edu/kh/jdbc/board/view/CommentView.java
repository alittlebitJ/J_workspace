package edu.kh.jdbc.board.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import edu.kh.jdbc.board.model.dto.Board;
import edu.kh.jdbc.board.model.dto.Comment;
import edu.kh.jdbc.board.model.service.commentService;
import edu.kh.jdbc.common.Session;

public class CommentView {
	
	
	   private Scanner sc = new Scanner(System.in);
	   private commentService commentService = new commentService();
	   
	   /** 댓글 메뉴
	    * @param boardNo(상세 조회 중인 게시글 번호)
	    */
	   public void commentMenu(int boardNo) {
	      
	      int input = -1;
	      
	         try {
	            System.out.println("\n=== 댓글 기능 ===\n");
	            System.out.println("1) 댓글 등록");
	            System.out.println("2) 댓글 수정");
	            System.out.println("3) 댓글 삭제");
	            
	            System.out.println("0. 댓글 기능 종료");
	            
	            System.out.print("\n선택 : ");
	            input = sc.nextInt();
	            sc.nextLine(); 
	            
	            switch(input) {
		            case 1: insertComment(boardNo);  break; // 댓글 등록
		            case 2: updateComment(boardNo); break; // 댓글 수정
		            case 3: deleteComment(boardNo); break; // 댓글 삭제
		            case 0: return;
		            default: System.out.println("\n*** 메뉴 번호만 입력 해주세요 ***\n");  
	            }
	            
	         }catch (InputMismatchException e) {
	            System.out.println("\n*** 입력 형식이 올바르지 않습니다***\n");
	            sc.nextLine(); 
	         }
	   }// commentMenu 메서드 종료

	private void insertComment(int boardNo) {
		// !wq가 입력 될 때 까지 댓글 내용을 입력 받고
		// 내용, 게시글 번호, 로그인 회원 번호를 이용해
		// 댓글 삽입 서비스 호출
//	           		
		
		// 내용 입력
		StringBuffer sb = new StringBuffer();
        
        System.out.println("\n=== 댓글 입력 ===\n");
        System.out.println("<!wq 입력 시 종료>");
        while(true) {
        	String str = sc.nextLine(); 
        	if(str.equals("!wq")) break;
        	
        	sb.append(str); 
        	sb.append("\n");
        } // while문 종료
        
        try {
        	int result = commentService.insertComment(sb.toString(), Session.loginMember.getMemberNo(), boardNo);

        	String scr = "";
        	if(result>0) 		scr = "입력 완료";	
        	else 				scr = "입력 실패";
        	System.out.println(scr);
        } catch (Exception e) {
        	System.out.println("\n*** 댓글 입력 중 예외 발생 ***\n");
        	e.printStackTrace();
        }
        
        
	}
	
	
	public void updateComment(int boardNo) {
		// 댓글 번호를 입력 받아서
        // 1) 해당 댓글이 현재 게시글의 댓글이며 로그인 한 회원이 쓴 댓글이 맞는지 확인하는 서비스 호출
        // 2-1 ) 1번 결과가 맞지 않으면 "작성한 댓글만 수정할 수 있습니다" 출력
        // 2-2 ) 1번 결과가 맞으면 !wq가 입력될 대 가지 내용을 입력 후 댓글 번호, 내용을 이용해 댓글을 수정하는 서비스 호출
		System.out.println("\n===== 댓글 수정 =====\n");
		  System.out.print("댓글 번호 입력 : ");
	      int input = sc.nextInt();
	      sc.nextLine();
	        
	      // 일단 댓글 번호에 해당하는 코멘트를 찾아, 댓글 멤버를 찾아야 
		try {
			Comment comment = commentService.selectComment(input);
			if(Session.loginMember.getMemberNo() != comment.getMemberNo() & boardNo == comment.getBoardNo()) {
				System.out.println("작성한 댓글만 수정할 수 있습니다.");
				return;
			}
			
			// 내용 입력
			StringBuffer sb = new StringBuffer();
			
			System.out.println("<!wq 입력 시 종료>");
			while(true) {
				String str = sc.nextLine(); 
				if(str.equals("!wq")) break;
				
				sb.append(str); 
				sb.append("\n");
			} // while문 종료
			
			int result = commentService.updateComment(input, sb.toString());
        	String scr = "";
        	if(result>0) 		scr = "수정 완료";	
        	else 				scr = "수정 실패";
        	System.out.println(scr);
		} catch (Exception e) {
        	System.out.println("\n*** 댓글 수정 중 예외 발생 ***\n");
			e.printStackTrace();
		}
	      
	} // updateComment 함수 끝
	
	
	
	public void deleteComment(int boardNo) {
        // CASE2의 1번을 수행
        // 2-1) 도 동일
        // 2-2) 맞으면 "정말로 삭제하시겠습니까?(y/n) :" 출력 후
        // Y 입력 시 : 삭제 서비스 호출(댓글번호)
        // n 입력 시 : "취소되었습니다."

		
		
		System.out.println("\n===== 댓글 삭제 =====\n");
		System.out.print("댓글 번호 입력 : ");
		int input = sc.nextInt();
		sc.nextLine();
		
		// 일단 댓글 번호에 해당하는 코멘트를 찾아, 댓글 멤버를 찾아야 
	
			Comment comment;
			try {
				comment = commentService.selectComment(input);
				if(Session.loginMember.getMemberNo() != comment.getMemberNo() & boardNo == comment.getBoardNo()) {
					System.out.println("작성한 댓글만 수정할 수 있습니다.");
					return;
				}
		        
		        while(true) {
		        	
		        	System.out.println("정말 삭제 하시겠습니까?(Y/N)");
		        	char check = sc.nextLine().toUpperCase().charAt(0);
		        	
		        	if(check == 'N') {
		        		System.out.println("[삭제 취소]");
		        		return;
		        	}
		        	if (check != 'Y') {
		        		System.out.println("[잘못 입력 하셨습니다.]");
		        		continue; // 다음 반복 수행(while문 처음으로)
		        	}
		        	break; // check가 Y인 경우
		        } // while문 끝
		        
		        	int result = commentService.deleteComment(input);
		        	String scr = "";
		        	if(result>0) 		scr = "삭제 완료";	
		        	else 				scr = "삭제 실패";
		        	System.out.println(scr);
			} catch (Exception e) {
	        	System.out.println("\n*** 댓글 삭제 중 예외 발생 ***\n");
				e.printStackTrace();
			}
		

        
	}
	
	

}
