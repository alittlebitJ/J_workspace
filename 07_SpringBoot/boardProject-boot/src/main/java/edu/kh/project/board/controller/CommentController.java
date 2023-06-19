package edu.kh.project.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.kh.project.board.model.dto.Comment;
import edu.kh.project.board.model.service.CommentService;


//@RestController : @Controller + @ResponseBody(비동기 요청의 반환값) 
//					요청/응답 처리를 하는 클래스. 단, 모든 요청 응답은 비동기
//					REST API를 구축하기 위한 Controller (REST는 다 비동기)

@RestController 
public class CommentController {

	@Autowired
	private CommentService service;
	
	
	// 댓글 목록 조회
	@GetMapping(value="/comment", produces = "application/json; charset=UTF-8")
	public List<Comment> select(/*@RequestParam ("boardNo")*/int boardNo) {
		return service.select(boardNo); // HttpMessageConvert List -> JSON 변환(한국어가 깨지니 mapping어노테이션에 produces = "application/json; charset=UTF-8"추가)
	}
	
	
	// 댓글 삽입
	@PostMapping("/comment")
					// post방식은 requestbody에서 받아옴
					// 요청 데이터(JSON)를 HttpMessageConverter가 해석해서 Java객체(comment) 필드에 대입
	public int insert(@RequestBody Comment comment) {
		return service.insert(comment);
	}
	
	// 댓글 삭제
	@DeleteMapping("/comment")
					// ajax 요청 시 body에 담겨 있는 하나 밖에 없는 데이터는 매개변수 int commentNo에 담기게 된다
	public int delete(@RequestBody int commentNo) {
		return service.delete(commentNo);
	}
	
	// 댓글 수정
	@PutMapping("/comment")
	public int update(@RequestBody Comment comment) {
		return service.update(comment);
	}
	
	
	
	

}
