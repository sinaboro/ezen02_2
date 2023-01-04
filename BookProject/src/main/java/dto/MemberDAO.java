package dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBManager;

public class MemberDAO {

	private MemberDAO() {}
	
	private static MemberDAO instance = new MemberDAO();
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
	//관리자페이지_회원관리(회원정보수정)시 사용하는 메서드
	public void userManager(MemberVO mVo) {
				
		String sql = "update member set pass=?, name=?, phone=?, email=?, lev=? where id=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try { 
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mVo.getPass());
			pstmt.setString(2, mVo.getName());
			pstmt.setString(3, mVo.getPhone());
			pstmt.setString(4, mVo.getEmail());
			pstmt.setString(5, mVo.getLev());
			pstmt.setString(6, mVo.getId());
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	//member의 정보를 얻어오는 메소드(관리자페이지에서 사용_lev포함)
	public MemberVO getMember(String id) {
		
		MemberVO mVo = null;
		
		String sql = "select * from member where id=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				mVo = new MemberVO();
				mVo.setId(rs.getString("id"));
				mVo.setPass(rs.getString("pass"));
				mVo.setName(rs.getString("name"));
				mVo.setPhone(rs.getString("phone"));
				mVo.setEmail(rs.getString("email"));
				mVo.setLev(rs.getString("lev"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}		
		return mVo;
	} 
	
	//member의 리스트 목록을 불러오는 메서드
	public List<MemberVO> listMember(){
		
		List<MemberVO> memberList = new ArrayList<MemberVO>();
		
		String sql = "select * from member";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			//pstmt.setString(1, id);
		    rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				MemberVO Vo = new MemberVO();
				Vo.setId(rs.getString("id"));
				Vo.setPass(rs.getString("pass"));
				Vo.setName(rs.getString("name"));
				Vo.setPhone(rs.getString("phone"));
				Vo.setEmail(rs.getString("email"));
				Vo.setLev(rs.getString("lev"));
			
				memberList.add(Vo);	
			}			
				
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return memberList;
	}
	
//	//member를 추가하는 메서드
//	public void addMember(MemberVO mVo) {
//		
//		String sql = "insert into member(id, pass, name, phone, email, lev) values(?,?,?,?,?,?)";
//		
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		
//		try { 
//			conn = DBManager.getConnection();
//			
//			String id = mVo.getId();
//			String pass = mVo.getPass();
//			String name = mVo.getName();
//			String phone = mVo.getPhone();
//			String email = mVo.getEmail();
//			String lev = mVo.getLev();
//			
//			pstmt = conn.prepareStatement(sql);
//			
//			pstmt.setString(1, id);
//			pstmt.setString(2, pass);
//			pstmt.setString(3, name);
//			pstmt.setString(4, phone);
//			pstmt.setString(5, email);
//			pstmt.setString(6, lev);
//			pstmt.executeUpdate();
//			pstmt.close();
//			conn.close();
//					
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}finally {
//			DBManager.close(conn, pstmt);
//		}
//		
//	}
	
	//회원가입시 사용하는 회원추가 메서드(권한 제외)
	public void insertMember(MemberVO mVo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
	

		String sql = "insert into member(id, pass, name, phone, email) values(?, ?, ?, ?, ?)";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mVo.getId());
			pstmt.setString(2, mVo.getPass());
			pstmt.setString(3, mVo.getName());
			pstmt.setString(4, mVo.getPhone());
			pstmt.setString(5, mVo.getEmail());

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	//아이디 체크(사용자 인증시 사용하는 메소드)
	public int userCheck(String id, String pass) {
				int result = -1;
				
				String sql = "select pass from member where id=?";
				
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				
				try {
					conn = DBManager.getConnection();
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, id);
					rs = pstmt.executeQuery();
					
					if(rs.next()) { //아이디가 있다.
						
						if(rs.getString("pass") != null && rs.getString("pass").equals(pass)) {
							result = 1; //아이디가 존재하고 비밀번호도 맞다.
						}else {
							result = 0; //아이디는 존재하고 비밀번호는 틀리다.
						}
						
					}else {
						result = -1; //아이디가 없다.
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					  DBManager.close(conn, pstmt, rs);
				}
				
				return result;
			}
	
	//아이디 중복확인 시 사용하는 메서드
	public int confirmID(String id) {
		int result = -1;
		
		String sql = "select id from member where id = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		try {
			conn = DBManager.getConnection(); // DB 연결 시도
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) { 
				result = 1;
			} else {
				result = -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return result;
	}
	
	    //마이페이지(일반회원) 수정 메서드
		public void updateMypage(MemberVO mVo) {
	    	
	    	String sql = "update member set name = ?, pass = ?, phone = ?, email = ? where id = ?";
			Connection conn = null;
			PreparedStatement pstmt = null;

			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, mVo.getName());
				pstmt.setString(2, mVo.getPass());
				pstmt.setString(3, mVo.getPhone());
				pstmt.setString(4, mVo.getEmail());
				pstmt.setString(5, mVo.getId());
				
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
	    
		//회원을 id값으로 조회 ? 추가필요
	    public MemberVO selectOneMemberById(String id) {
			MemberVO mVo = null;
			String sql = "select * from member where id = ?";
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				
				if (rs.next()) {
					mVo = new MemberVO();
					mVo.setId(rs.getString("id"));
					mVo.setPass(rs.getString("pass"));
					mVo.setName(rs.getString("name"));
					mVo.setPhone(rs.getString("phone"));
					mVo.setEmail(rs.getString("email"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
			return mVo;
		}
	    
	    //회원 삭제
		public void deleteMember(String id) {
			
			String sql = "delete member where id=?";
		
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
			
				pstmt.setString(1, id);
			
				pstmt.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		

		public MemberVO checkPass(String pass, String id) {
			
			String sql = "select * from member where pass= ? and id= ?";
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			MemberVO mVo = null;
			
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, pass);
				pstmt.setString(2, id);
				rs = pstmt.executeQuery();
				
				if (rs.next()) {
					mVo = new MemberVO();
					
					mVo.setId(rs.getString("id"));
					mVo.setPass(rs.getString("pass"));
					mVo.setName(rs.getString("name"));
					mVo.setPhone(rs.getString("phone"));
					mVo.setEmail(rs.getString("email"));
					mVo.setLev(rs.getString("lev"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return mVo;
		}
		
}
