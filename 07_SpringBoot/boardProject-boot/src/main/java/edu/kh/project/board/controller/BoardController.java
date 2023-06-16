package edu.kh.project.board.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.board.model.dto.Board;
import edu.kh.project.board.model.dto.BoardImage;
import edu.kh.project.board.model.service.BoardService;
import edu.kh.project.member.model.dto.Member;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * @author user1
 *
 */

@SessionAttributes({"loginMember"})
@RequestMapping("/board")
@Controller
public class BoardController {
   
   @Autowired
   private BoardService service;
   
   /* 목록 조회 : /board/1?cp=1 (cp : current page(현재 페이지))
    * 상세 조회 : /board/1/1500?cp=1
    * 
    * ** 컨트롤러 따로 생성 예정 **
    * 삽입 : /board2/1/insert
    * 수정 : /board2/1/update
    * 삭제 : /board2/1/delete?&no=1500
    * */
   
   
   // @PathVariable
   // URL 경로에 있는 값을 매개 변수로 이용할 수 있게하는 어노테이션
   // + request scope에 세팅
   
   // @PathVariable을 사용하는 경우
   // - 자원(resource) 구분/식별
   // ex) github.com/testUser
   // ex) github.com/wod24
   // ex) /board/1 -> 1번(공지사항) 게시판
   // ex) /board/2 -> 2번(자유 게시판) 게시판
   
   // Query String 을 사용하는 경우
   // - 정렬, 필터링
   // ex) search.naver.com?query=날씨
   // ex) search.naver.com?query=점심
   // ex) /board2/insert/1
   // ex) /board2/insert/2
   //    -> 삽입이라는 공통된 동작 수행 / 단,code에 따라 어디에 삽입할지 지정(필터링)
   // /board/list?order=recent (최신순)
   // /board/list?order=most   (인기순)
   
   // ********* @PathVariable 사용시 문제점과 해결 방법
   // 문제점 : 요청 주소와 @PathVariable로 가져다 쓸 주소의 레벨이 같다면
   //         구분하지 않고 모두 맵핑되는 문제가 발생
   //         -> 요청을 했는데 원하는 메서드가 실행안됨
   
   // 해결 방법 : @PathVariable 지정시 정규표현식 사용
   // {키:정규표현식}
   
   
   
   // 게시글 목록 조회
   @GetMapping("/{boardCode:[0-9]+}")
   public String selectBoardList(
              @PathVariable("boardCode") int boardCode
            , @RequestParam(value="cp", required = false, defaultValue="1") int cp
            , Model model
            , @RequestParam Map<String, Object> paramMap // 파라미터 전부 다 담겨있음
            ) {
      
      // boardCode 확인
      //System.out.println("boardCode : " + boardCode);
      
      if(paramMap.get("key") == null) { // 검색어가 없을 때(검색x)
         
         // 게시글 목록 조회 서비스 호출
         Map<String, Object> map = service.selectBoardList(boardCode, cp);
         
         // 조회 결과를 request scope에 세팅 후 forward
         model.addAttribute("map",map);
         
      }else { // 검색어가 있을 때(검색o)
         
         paramMap.put("boardCode", boardCode);
         
         Map<String, Object> map = service.selectBoardList(paramMap, cp); 
         
         model.addAttribute("map",map);
      }
      
      
      return "board/boardList";
   }
   
   // @PathVariable : 주소에 지정된 부분으로 변수에저장 + request scope 세팅
   
   // 게시글 상세 조회
   @GetMapping("/{boardCode}/{boardNo}")
   public String boardDetail(
           @PathVariable("boardCode") int boardCode
         , @PathVariable("boardNo") int boardNo
         , Model model // 데이터 전달용 객체
         , RedirectAttributes ra //리다이렉트 시 데이터 전달용 객체
         , @SessionAttribute(value="loginMember", required = false) Member loginMember
            // 세션에서 loginMember를 얻어오는데 없으면 null, 있으면 회원정보 저장
         
         // 쿠키를 이용한 조회 수 증가에서 사용
         , HttpServletRequest req
         , HttpServletResponse resp
         ) throws ParseException {
      
      Map<String, Object> map = new HashMap<String, Object>();
      map.put("boardCode", boardCode);
      map.put("boardNo", boardNo);
      
      
      // 게시글 상세 조회 서비스 호출
      Board board = service.selectBoard(map);
      
      String path = null;
      
      if(board != null){ // 조회 결과가 있을 경우

         // -------------------------------------------------------
         // 현재 로그인 상태인경우
         if(loginMember !=null) {
            // 로그인한 회원이 해당 게시글에 좋아요를 눌렀는지 확인
            
            // 회원 번호를 map에 추가
            // map(boardCod, boardNo, memberNo)
            map.put("memberNo", loginMember.getMemberNo());
            
            // 좋아요 여부 확인 서비스 호출
            int result = service.boardLikeCheck(map);
            
            // 좋아요 누른적이 있을 경우
            if(result>0)model.addAttribute("likeCheck","on");
         }
         
         
         // -------------------------------------------------------
         
         // 쿠키를 이용한 조회 수 증가 처리
         
         // 1) 비회원 로그인한 회원의 글이 아닌 경우
         if(loginMember == null || //비회원
            loginMember.getMemberNo() != board.getMemberNo()) {
            
            
            // 2) 쿠키 얻어오기
            Cookie c = null;
            
            //요청에 담겨있는 모든 쿠키 얻어오기
            Cookie[] cookies = req.getCookies();
            
            if(cookies != null) { // 쿠키가 존재할 경우
               // 쿠키중 "readBoardNo"라는 쿠키를 찾아서 c에 대입
               for(Cookie cookie : cookies) {
                  if(cookie.getName().equals("readBoardNo")) {
                     c = cookie;
                     break;
                  }
               }
            }
            
            // 3) 기존 쿠키가 없거나(c == null)
            //      존재는 하나 현재 게시글 번호가 쿠키에 저장되지 않는 경우
            //      (오늘 해당 게시글 본 적 없음)
            
            int result = 0;
            
            if(c ==null) {
               // 쿠키가 존재 X -> 하나 새로 생성
               // 톰캣 8.5이상부터 쿠키에 ,쉼표 /슬래시 =같다 띄어쓰기 작성불가
               c = new jakarta.servlet.http.Cookie("readBoardNo", "|" + boardNo +"|");
               // 조회수 증가 서비스 호출
               result = service.updateReadCount(boardNo);
            }else {
               // 현재 게시글 번호가 쿠키에 있는지 확인
               
               // Cookie.getValue() : 쿠키에 저장된 모든 값을 읽어옴 -> String으로 반환
               
               // String.indexof("문자열") : 찾는 문자열이 String이 몇번 인덱스에 존재하는지 반환
               //                      단, 없으면 -1 반환
               if(c.getValue().indexOf("|" + boardNo +"|") == -1) {
                  // 쿠키에 현재 게시글 번호가 없다면
                  
                  // 기존 값에 게시글 번호 추가해서 다시 세팅
                  c.setValue(c.getValue() + "|" + boardNo +"|");
                  
                  // 조회수 증가 서비스 호출
                  result = service.updateReadCount(boardNo);
               }
            } // 3) 종료
            
            // 4) 조회 수 증가 성공 시
            // 쿠키가 적용되는 경로, 수명(당일 23시 59분 59초) 지정
            if(result > 0) {
               
               // 조회된 board 조회 수와 db조회수 동기화
               board.setReadCount(board.getReadCount()+1);
               
               // 적용 경로 설정
               c.setPath("/"); // "/" 이하 경로 요청 시 쿠키 서버로 전달
               
               // 수명 지정
               Calendar cal = Calendar.getInstance(); // 오늘날짜  // 싱글톤 패턴
               cal.add(cal.DATE, 1); // 내일날짜
               
               // 날짜 표기법 변경 객체 (DB의 TO_CHAR()와 비슷)
               SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
               
               // java.util.Date
               Date a = new Date(); // 현재 시간
               
               Date temp = new Date(cal.getTimeInMillis()); // 내일 (24시간 후)
               // 2023-05-11 12:16:10
               
               Date b = sdf.parse(sdf.format(temp)); // 내일 (0시 0분 0초)
               
               // 내일 (0시 0분 0초) - 현재 시간
               long diff = (b.getTime() - a.getTime()) / 1000;
               // -> 내일 0시 0분 0초 까지 남은 시간은 초단위로 반환
               
               c.setMaxAge((int)diff); //수명 설정
               
               resp.addCookie(c);
            }
         }
         
         // -------------------------------------------------------
         path = "board/boardDetail"; // forward할 jsp경로
         model.addAttribute("board", board);
         
         // 게시글에 이미지가 있을 경우
//         if(!board.getImageList().isEmpty()) {}
         if(board.getImageList().size()>0) {
            BoardImage thumbnail = null;
            // IMG_ORDER의 값이 0인 이미지가 썸네일이다
            if(board.getImageList().get(0).getImageOrder() == 0) {
               thumbnail = board.getImageList().get(0);
            }
            model.addAttribute("thumbnail",thumbnail);
            // 썸네일이 있으면 start = 1
            // 썸네일이 없으면 start = 0
            model.addAttribute("start",thumbnail != null ? 1 : 0);
         }
         
         
      }else { // 조회 결과가 없을 경우
         path = "redirect:/board/" + boardCode;
         // 게시판 첫 페이지로 리다이렉트
         ra.addFlashAttribute("message","해당 게시글이 존재하지 않습니다.");
      }
      
      return path;
   }
   
   // 좋아요 처리
   @PostMapping("/like")
   @ResponseBody // 반환되는 값이 비동기 요청한 곳으로 돌아가게 함
   public int like(@RequestBody Map<String, Integer> paramMap) {
      // System.out.println(paramMap);
      return service.like(paramMap);
   }
   
   
    // 헤더 검색
    @GetMapping(value="/headerSearch", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<Map<String, Object>> headerSearch(String query){
       return service.headerSearch(query);
    }

   
   
   
}