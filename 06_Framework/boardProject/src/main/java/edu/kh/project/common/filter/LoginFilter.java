package edu.kh.project.common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.project.member.model.dto.Member;


// Filter : 클라이언트의 요청/응답을 걸러내거나, 첨가하는 클래스
// 클라이언트의 요청이 Dispatcher Servlet에 도달하기 직전에 있다
// @WebFilter : 해당 클래스를 필터로 등록하고, 지정된 주소 요청이 올 때 마다 동작
@WebFilter(filterName = "loginFilter",
		   urlPatterns = {"/myPage/*", "/board2/*"}) // {"/myPage/*, /board/*"} 여러개 작성도 가능
public class LoginFilter implements Filter {

	/*
	 * public LoginFilter() { } // 기본 생성자. 삭제해도 자동으로 생성해주니 삭제해도 됨
	 */

	
	// 초기화 메서드
	public void init(FilterConfig fConfig) throws ServletException {
		// 서버가 켜질 때, 필터 코드가 변경되었을 때 필터가 생성됨 : 생성 시 초기화 용도로 사용하는 메서드
		System.out.println("----로그인 필터 생성----");
	}
		
	public void destroy() {
		//필터 코드가 변경되었을 때, 변경 이전 필터를 파괴하는 메서드
		System.out.println("-- 이전 로그인 필터 파괴 -- ");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 필터링 코드를 작성하는 메서드
		// 1) ServletRequest, ServletResponse를 다운캐스팅
		HttpServletRequest req = (HttpServletRequest)request; 
		HttpServletResponse resp = (HttpServletResponse)response; 
		
		// 2) 다운캐스팅한 HttpServletRequest를 이용해서 HttpSession 얻어오기
		HttpSession session = req.getSession();
		
		// 3) session에서 “loginMember” key를 가진 속성을 얻어와, null인 경우 메인 페이지로 redirect
		
//		관리자가 아니면 메인페이지로 보내는 필터 예시
//		Member loginMember = (Member)session.getAttribute("loginMember");
//		if(loginMember.getAuthority() != 2) {
//			
//		} else {
//			
//		}
		
		
		if(session.getAttribute("loginMember") == null) {
			resp.sendRedirect("/");
		// 4) 로그인 상태인 경우 다음 필터 또는 Dispatcher Servlet으로 전달
		} else {
			chain.doFilter(request, response);
		}
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
