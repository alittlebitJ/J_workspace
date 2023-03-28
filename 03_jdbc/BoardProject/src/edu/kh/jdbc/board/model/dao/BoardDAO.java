package edu.kh.jdbc.board.model.dao;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.jdbc.board.model.dto.Board;


public class BoardDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	// xml에 작성된 SQL을 읽어와 저장할 객체를 참조하는 변수
	private Properties prop;
	
	public BoardDAO() {
		
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream("board-sql.xml"));
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	/** 게시판 기능
	 *  1. 게시글 목록 조회 작성
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public List<Board> selectAllBoard(Connection conn) throws Exception {
		List<Board> boardList = new ArrayList<>();
		
		try {
			String sql = prop.getProperty("selectAllBoard");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				int boardNo = rs.getInt("BOARD_NO");
				String boardTitle = rs.getString("BOARD_TITLE");
				String memberName = rs.getString("MEMBER_NM");
				int readCount = rs.getInt("READ_COUNT");
				String createDate = rs.getString("CREATE_DT");
				int commentCount = rs.getInt("COMMENT_COUNT");
				
				Board board = new Board();
				
				board.setBoardNo(boardNo);
				board.setBoardTitle(boardTitle);
				board.setMemberName(memberName);
				board.setReadCount(readCount);
				board.setCreateDate(createDate);
				board.setCommentCount(commentCount);
				
				boardList.add(board);
				
			}
			
		} finally {
			close(rs);
			close(stmt);
		}
		
		return boardList;
	}
	
	
	

	/** 게시판 기능
	 * 2. 게시글 상세 조회(+ 댓글 기능)
	 * @param conn
	 * @param input
	 * @return board
	 * @throws Exception
	 */
	public Board selectBoard(Connection conn, int input) throws Exception  {
		Board board = null;
		try {
			String sql = prop.getProperty("selectBoard");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, input);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				
				int boardNo = rs.getInt("BOARD_NO");
				String boardTitle = rs.getString("BOARD_TITLE");
				String boardContent = rs.getString("BOARD_CONTENT");
				int memberNo = rs.getInt("MEMBER_NO");
				String memberName = rs.getString("MEMBER_NM");
				int readCount = rs.getInt("READ_COUNT");
				String creatDate = rs.getString("CREATE_DT");
				
				board = new Board();
				
				board.setBoardNo(boardNo);
				board.setBoardTitle(boardTitle);
				board.setMemberName(memberName);
				board.setReadCount(readCount);
				board.setCreateDate(creatDate);
				board.setBoardContent(boardContent);
				board.setMemberNo(memberNo);
			}
		} finally {
			close(rs);
			close(pstmt);
		}
		return board;
	}
	
	
	/** 게시판 기능
	 * 2. 게시글 상세 조회(+ 댓글 기능)
	 * - 조회수 증가 SQL
	 * @param conn
	 * @param input
	 * @return result
	 * @throws Exception
	 */
	public int updateReadCount(Connection conn, int input) throws Exception{
		int result = 0;
		try {
			String sql = prop.getProperty("updateReadCount");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, input);
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		return result;
	}

	/** 게시판 기능
	 * 2. 게시글 상세 조회(+ 댓글 기능)
	 * 상세 조회 후 게시글 수정 SQL 수행
	 * @param conn
	 * @param boardTitle
	 * @param boardContent
	 * @param boardNo
	 * @return result
	 * @throws Exception
	 */
	public int updateBoard(Connection conn, String boardTitle, String boardContent, int boardNo) throws Exception{
		int result = 0;
		
		try {
			String sql = prop.getProperty("updateBoard");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardTitle);
			pstmt.setString(2, boardContent);
			pstmt.setInt(3, boardNo);
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		return result;
	}

	
	
	
	
	/** 게시판 기능
	 * 2. 게시글 상세 조회(+ 댓글 기능)
	 * 상세 조회 후 게시글 삭제
	 * @param conn
	 * @param boardNo
	 * @return
	 * @throws Exception
	 */
	public int deleteBoard(Connection conn, int boardNo) throws Exception {
		int result = 0;
		
		
		try {
			String sql = prop.getProperty("deleteBoard");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
			result = pstmt.executeUpdate(); 
			// executeUpdate()는 DDL(CREATE, ALTER, DROP) 수행도 가능 -> -1로 반환
			// (성공 실패 여부는 결과값으로 알 수 없음)
			
		} finally {
			close(pstmt);
		}
		return result;
	} // deleteBoard 메서드 종료

	
	
	/** 3. 게시글 작성
	 * 게시글 작성 서비스
	 * 다음 게시글 번호 조회 SQL 수행
	 * @param conn
	 * @return boardNo
	 * @throws Exception
	 */
	public int nextBoardNo(Connection conn) throws Exception{
		int boardNo = 0;
		try {
			String sql = prop.getProperty("nextBoardNo");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) boardNo = rs.getInt(1); // 컬럼 순서
		} finally {
			close(rs);
			close(stmt);
		}
		return boardNo;
	}
	
	
	
	
	/** 3. 게시글 작성
	 * 게시글 작성 서비스
	 * 다음 게시글 삽입 SQL 수행
	 * @param conn
	 * @param boardTitle
	 * @param boardContent
	 * @param memberNo
	 * @param boardNo
	 * @return result
	 * @throws Exception
	 */
	public int insertBoard(Connection conn, String boardTitle, String boardContent, int memberNo, int boardNo) throws Exception{
		int result = 0;
		try {
			String sql = prop.getProperty("insertBoard");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			pstmt.setString(2, boardTitle);
			pstmt.setString(3, boardContent);
			pstmt.setInt(4, memberNo);
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
