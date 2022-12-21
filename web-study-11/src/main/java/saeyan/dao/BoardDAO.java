package saeyan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import saeyan.dto.BoardVO;
import util.DBManager;

public class BoardDAO {
	
	private BoardDAO() {
	}
	
	private static BoardDAO instance = new BoardDAO();
	
	public static BoardDAO getInstance() {
		return instance;
	}
	
	
	/*
	 * NUM        NOT NULL NUMBER(5)      
			PASS                VARCHAR2(30)   
			NAME                VARCHAR2(30)   
			EMAIL               VARCHAR2(30)   
			TITLE               VARCHAR2(50)   
			CONTENT             VARCHAR2(1000) 
			READCOUNT           NUMBER(4)      
			WRITEDATE           DATE 
	 */
	public List<BoardVO> selectAllBoards(){
		List<BoardVO> list = new ArrayList<BoardVO>();
		String sql = "select * from board order by num";
		Connection conn = null;;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setNum(rs.getInt("num"));
				vo.setName(rs.getString("name"));
				vo.setPass(rs.getString("pass"));
				vo.setEmail(rs.getString("email"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setReadcount(rs.getInt("readcount"));
				vo.setWritedate(rs.getTimestamp("writeDate"));
				
				list.add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn,pstmt,rs);
		}
		return list;
	};
	
	/*
	 * 	PASS                VARCHAR2(30)   
			NAME                VARCHAR2(30)   
			EMAIL               VARCHAR2(30)   
			TITLE               VARCHAR2(50)   
			CONTENT             VARCHAR2(1000)
	 */
	public void insertBoard(BoardVO vo) {
		int result = 0;
		
		String sql = "insert into board(num, pass,name,email,title,content) values(seq_board.nextval,?, ?, ?, ?, ?)";
		Connection conn = null;;
		PreparedStatement pstmt= null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPass());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getTitle());
			pstmt.setString(5, vo.getContent());
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn,pstmt);
		}
		
	}
	
	/*
	 *       
	NAME                VARCHAR2(30)   
	EMAIL               VARCHAR2(30)   
	TITLE               VARCHAR2(50)   
	CONTENT             VARCHAR2(1000) 
	READCOUNT           NUMBER(4)      
	WRITEDATE           DATE  
	 */
	public BoardVO selectOneBoardByNum(int num) {
		String sql = "select * from board where num = ?";
		BoardVO vo = null;
		
		Connection conn = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo = new BoardVO();
				vo.setNum(rs.getInt("num"));
				vo.setPass(rs.getString("pass"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setReadcount(rs.getInt("readcount"));
				vo.setWritedate(rs.getTimestamp("writedate"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn,pstmt,rs);
		}
		return vo;
	}
	
	
	public void updateReadCount(int num) {
		
		String sql = "update board set readcount= readcount+1 where num=?";
		Connection conn = null;;
		PreparedStatement pstmt= null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn,pstmt);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
