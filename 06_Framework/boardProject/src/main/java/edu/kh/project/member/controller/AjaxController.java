package edu.kh.project.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.kh.project.member.model.service.AjaxService;

@Controller // 요청, 응답 제어 + bean 등록
public class AjaxController {

	@Autowired // DI
	private AjaxService service;
	
	
	// 이메일로 닉네임 조회
				// Produces 속성은 한글이 깨질 대 사용
				// 한글이 깨져서 작성하는 문장. 한글이 없으면 작성 안 해도 됨
	@GetMapping(value="/selectNickname", produces = "application/text; charset=UTF-8")
	@ResponseBody
	public String selectNickname(String email) {
								// 쿼리스트링에 담긴 파라미터
		return service.selectNickname(email);
	}
	
	
	
	// 닉네임으로 전화번호 조회
	@GetMapping("/selectMemberTel")
	@ResponseBody
	public String selectMemberTel(String nickname) {
								  // 쿼리스트링에 담겨있는 파라미터
		
		
//		return 리다이렉트 / 포워드  -> 새로운 화면이 보임(동기식)
//		return 데이터; -> 데이터를 요청한 곳으로 반환(비동기식)
//		@ResponseBody : Controller의 결과로 데이터를 반환할 때 사용하는 어노테이션
//						사용법 1 : 메서드 위에 사용
//						사용법 2 : return값에 사용
		
		return service.selectMemberTel(nickname);
	}
	

	// 이메일 중복 검사
	@GetMapping("/dupCheck/email")
	@ResponseBody // HttpMessageConverter를 이용해 JS에서 인식할 수 있는 형태(TEXT/JSON) 변환
				  // + 비동기 요청한 곳으로 돌아감
	public int checkEmail(String email) {
		return service.checkEmail(email);
	}
	
	
	// 닉네임 중복 검사
	@GetMapping("/dupCheck/nickname")
	@ResponseBody
	public int checkNickname(String nickname) {
		return service.checkNickname(nickname);
	}
	
	
	
    /* Ajax를 이용한 비동기 통신 시
     * 
     * - 요청 데이터를 얻어오는 방법
     * 1) GET : 요청 url에 쿼리스트링 형태로 파라미터가 담겨있어
     *          @RequestParam, @ModelAttribute를 이용해서 얻어옴
     * 
     * 2) POST : HTTP 요청 Body에 파라미터가 담겨 있으므로
     *           @RequestBody를 통해 값(JSON)을 얻어와 
     *           Java객체로 변환(HttpMessageConverter)
     * 
     * - 응답 방법(GET/POST 구분 X)
     * : @ResponseBody를 이용해 반환
     *   -> 해당 어노테이션을 작성하면  
     *   Controller에서 반환되는 값이 ViewResolver가 아닌 
     *   HttpMessageConverter로 전달되어 
     *   반환된 Java객체를 text/JSON으로 변환 후 비동기 요청을 한 곳으로 응답함
     * 
     * 
     * ****************************
     * *** HttpMessageConverter ***
     * ****************************
     * 
     * HTTP 요청 Body의 내용을 Java 객체로 변환하고
     * HTTP 응답의 Body의 내용을 text/JSON 형태로 변환해주는 
     * Spring Framework 구성 요소
     * 
     * Spring에서 사용하는 MessageConverter 종류
     * 1순위 : ByteArrayHttpMessageConverter (바이트 배열 자동 변환)
    * 2순위 : StringHttpMessageConverter (Text 형식 자동 변환)
    * 3순위 : MappingJackson2HttpMessageConverter (요청 데이터 -> DTO/Map , 응답 데이터 -> JSON)
     * */
	
	
	
}
