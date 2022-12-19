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
	
	
	public List<BoardVO> selectAllBoards(){
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		String sql = "select * from board order by num";
		
		Connection conn = null;;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		
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
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setNum(rs.getInt("num"));
				vo.setName(rs.getString("name"));
				vo.setPass(rs.getString("pass"));
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
}
