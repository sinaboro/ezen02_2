package dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.DBManager;

public class NoticeDAO {

private NoticeDAO() { }
	
	private static NoticeDAO instance = new NoticeDAO();
	
	public static NoticeDAO getInstance() {
		return instance;
	}
	
	public List<NoticeVO> selectAllNotices() {
		String sql = "select * from notice order by num desc";
		
		List<NoticeVO> list = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				NoticeVO nVo = new NoticeVO();
				nVo.setNum(rs.getInt("num"));
				nVo.setId(rs.getString("id"));
				nVo.setTitle(rs.getString("title"));
				nVo.setContent(rs.getString("content"));
				nVo.setWritedate(rs.getTimestamp("writedate"));
				nVo.setReadcount(rs.getInt("readcount"));
				
				list.add(nVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}
	
	public void registerNotice(NoticeVO nVo) {
		String sql = "insert into notice(num, id, title, content, writedate) values(notice_seq.nextval, ?, ?, ?, sysdate)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nVo.getId());
			pstmt.setString(2, nVo.getTitle());
			pstmt.setString(3, nVo.getContent());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public void updateReadCount(int num) {
		String sql = "update notice set readcount = readcount + 1 where num = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public NoticeVO selectOneNotice(int num) {
		String sql = "select * from notice where num = ?";
		
		NoticeVO nVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				nVo = new NoticeVO();
				
				nVo.setNum(rs.getInt("num"));
				nVo.setId(rs.getString("id"));
				nVo.setTitle(rs.getString("title"));
				nVo.setContent(rs.getString("content"));
				nVo.setWritedate(rs.getTimestamp("writedate"));
				nVo.setReadcount(rs.getInt("readcount"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return nVo;
	}
	
	public void updateNotice(NoticeVO nVo) {
		String sql = "update notice set title = ?, content = ? where num = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nVo.getTitle());
			pstmt.setString(2, nVo.getContent());
			pstmt.setInt(3, nVo.getNum());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public void deleteNotice(int num) {
		String sql = "delete notice where num = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
}
