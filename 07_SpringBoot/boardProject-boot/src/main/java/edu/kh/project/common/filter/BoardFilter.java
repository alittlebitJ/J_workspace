package edu.kh.project.common.filter;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class BoardFilter implements Filter {
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
								// ServletRequest, ServletResponse을 다운캐스팅
		HttpServletRequest req = (HttpServletRequest)request;
		
		// /board/1					-> {"", "board", "1"}
		// /board2/1/insert			-> {"", "board", "1", "insert"}
		// /board2/1/update			-> {"", "board", "1", "update"}
		
		// 1(보드코드)을 꺼내는 방법
		
		String[] arr = req.getRequestURI().split("/");
		
		try {
			String boardCode = arr[2];
	         List<Map<String, Object>> boardTypeList = (List<Map<String, Object>>)(req.getServletContext().getAttribute("boardTypeList"));
	         for(Map <String,Object> boardType : boardTypeList) {
	            if((boardType.get("BOARD_CODE") + "").equals(boardCode)) {  // boardCode 가 BigInteger타입이라 String으로 바꿔서 비교 (int타입으로 바꾸기 까다로워서 그냥 String으로 만듦)
	               req.setAttribute("boardName", boardType.get("BOARD_NAME"));
	            }
	         }
		} catch (Exception e) {} // 예외시 아무 처리도 하지 않음.
		
		chain.doFilter(request, response);
		
	}

}
