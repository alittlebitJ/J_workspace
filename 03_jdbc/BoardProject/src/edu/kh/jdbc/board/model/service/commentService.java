package edu.kh.jdbc.board.model.service;

import static edu.kh.jdbc.common.JDBCTemplate.*;
import java.sql.Connection;

import edu.kh.jdbc.board.model.dao.CommentDAO;
import edu.kh.jdbc.board.model.dto.Comment;

public class commentService {

	CommentDAO commentDao = new CommentDAO();

	
	/** 댓글입력 서비스
	 * @param conmmentContent
	 * @param memberNo
	 * @param boardNo
	 * @return result
	 * @throws Exception
	 */
	public int insertComment(String conmmentContent, int memberNo, int boardNo) throws Exception {
		Connection conn = getConnection();
		int result = commentDao.insertComment(conn, conmmentContent, memberNo, boardNo);
		if (result > 0)		commit(conn);
		else				rollback(conn);
		return result;
	}


	/** 입력받은 댓글 확인하는 서비스
	 * @param input
	 * @return comment
	 * @throws Exception
	 */
	public Comment selectComment(int input) throws Exception{
		Connection conn = getConnection();
		Comment comment = commentDao.selectComment(conn, input);
		close(conn);
		return comment;
	}


	/** 댓글 수정 서비스
	 * @param input
	 * @param commentContent
	 * @return result
	 * @throws Exception
	 */
	public int updateComment(int input, String commentContent) throws Exception {
		Connection conn = getConnection();
		int result = commentDao.updateComment(conn, input, commentContent);
		if (result > 0) 			commit(conn);
		else						rollback(conn);
		close(conn);
		return result;
	}


	/** 댓글 삭제 서비스
	 * @param input
	 * @return result
	 * @throws Exception
	 */
	public int deleteComment(int input) throws Exception{
		Connection conn = getConnection();
		int result = commentDao.deleteComment(conn, input);
		if (result > 0) 			commit(conn);
		else						rollback(conn);
		close(conn);
		return result;
	}
	
	
	

}


