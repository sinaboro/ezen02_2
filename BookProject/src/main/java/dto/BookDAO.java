package dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.DBManager;

public class BookDAO {

	private BookDAO() {}
	
	private static BookDAO instance = new BookDAO();
	
	public static BookDAO getInstance() {
		return instance;
	}
	
	//책의 전체 데이터를 불러오는 메소드
	public List<BookVO> selectAllBooks() {
		
		  //Book에 저장된 전체 데이터들을 오름차순으로 정렬
	      String sql = "select * from book order by num asc";
	      
	      //책의 정보를 한개 이상 저장하기 위해 ArrayList 클래스로 객체 생성
	      List<BookVO> list = new ArrayList<BookVO>();
	      
	      Connection conn = null;
	      Statement stmt = null;
	      ResultSet rs = null;
	      
	      try {
	    	 
	    	 //쿼리문을 실행하기 전에 커넥션 객체를 얻기 위해 DBManager클래스의 정적 메소드(getConnection())를 호출
	         conn = DBManager.getConnection();
	         stmt = conn.createStatement();
	         
	         //stmt객체로 쿼리문을 실행한 후 결과를 ResultSet객체에 담는다.
	         rs = stmt.executeQuery(sql);
	         
	         //여러개의 책 정보를 담고있기 때문에 while문을 돌면서 rsmt next()메소드를 호출하여 행 단위로 이동하면서 상품 테이블에 접근한다.
	         	while (rs.next()) {
	        	
	        	 //상품 정보를 저장할 VO객체를 생성. 아직 데이터가 저장되어 있지 않아서 null로 채워져있다.
	            BookVO bVo = new BookVO();
	            
	            //rs로 컬럼 값을 얻어온다.
	            //set()메소드를 호출해서 VO객체의 각 필드를 채운다.
	            bVo.setNum(rs.getInt("num"));
	            bVo.setCategory(rs.getString("category"));
	            bVo.setTitle(rs.getString("title"));
	            bVo.setPrice(rs.getString("price"));
	            bVo.setSummary(rs.getString("summary"));
	            bVo.setAuthor(rs.getString("author"));
	            bVo.setPub(rs.getString("pub"));
	            bVo.setGrade(rs.getString("grade"));
	            bVo.setPictureurl(rs.getString("pictureurl"));
	            
	            //ArrayList객체에 BookVO객체를 추가
	            list.add(bVo);
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      }finally {
	         DBManager.close(conn, stmt, rs);
	      }
	      return list;
	   }
	
	//책의 정보를 추가하는 메소드
	public void insertBook(BookVO Vo) {
		
	      String sql = "insert into book values(Book_seq.nextval,?,?,?,?,?,?,?,?)";
	      
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      
	      try {
	    	  
	         conn = DBManager.getConnection();
	         pstmt = conn.prepareStatement(sql);
	         
	         pstmt.setString(1, Vo.getCategory());
	         pstmt.setString(2, Vo.getTitle());
	         pstmt.setString(3, Vo.getPrice());
	         pstmt.setString(4, Vo.getSummary());
	         pstmt.setString(5, Vo.getAuthor());
	         pstmt.setString(6, Vo.getPub());
	         pstmt.setString(7, Vo.getGrade());
	         pstmt.setString(8, Vo.getPictureurl());
	         
	         pstmt.executeUpdate();
	         
	      }catch(Exception e) {
	         e.printStackTrace();
	      }finally {
	         DBManager.close(conn, pstmt);
	      }
	   }

	//Book테이블에서 num값으로 해당 게시글을 찾아 게시글 정보를 VO객체로 얻어온다.
	public BookVO selectOneBookByNum(int num) {
		
	      String sql = "select * from book where num = ?";     
	      BookVO bVo = null;
	      
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      
	      try {
	         conn = DBManager.getConnection();
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setInt(1, num);
	         rs = pstmt.executeQuery();
	         
	         if (rs.next()) {
	            bVo = new BookVO();
	            
	            bVo.setNum(rs.getInt("num"));
	            bVo.setCategory(rs.getString("category"));
	            bVo.setTitle(rs.getString("title"));
	            bVo.setPrice(rs.getString("price"));
	            bVo.setSummary(rs.getString("summary"));
	            bVo.setAuthor(rs.getString("author"));
	            bVo.setPub(rs.getString("pub"));
	            bVo.setGrade(rs.getString("grade"));
	            bVo.setPictureurl(rs.getString("pictureurl"));
	            
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         DBManager.close(conn, pstmt, rs);
	      }
	      return bVo;
	   }
	
	   //도서 수정 메서드
	   public void updateBook(BookVO bVo) {
		   
	      String sql = "update book set category=?, title=?, price=?, "
	            + "summary=?, author=?, pub=?, grade=? where num=?";
	      
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      
	      try {
	         conn = DBManager.getConnection();
	         pstmt = conn.prepareStatement(sql);
	         
	         pstmt.setString(1, bVo.getCategory());
	         pstmt.setString(2, bVo.getTitle());
	         pstmt.setString(3, bVo.getPrice());
	         pstmt.setString(4, bVo.getSummary());
	         pstmt.setString(5, bVo.getAuthor());
	         pstmt.setString(6, bVo.getPub());
	         pstmt.setString(7, bVo.getGrade());
	         pstmt.setInt(8, bVo.getNum());
	         
	         pstmt.executeUpdate();
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         DBManager.close(conn, pstmt);
	      }
	   }
	   
	//도서 삭제 메서드  
	public void deleteBook(int num) {
		String sql = "delete book where num=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			
			pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//최근 등록한 책이 먼저 출력되도록 게시글 목록을 출력한다. ?
	public List<BookVO> selectAllCategory() {
		
		  String sql = "select distinct category from book";
	      
	      List<BookVO> list = new ArrayList<BookVO>();
	      
	      Connection conn = null;
	      Statement stmt = null;
	      ResultSet rs = null;
	      
	      try {  
	         conn = DBManager.getConnection();
	         stmt = conn.createStatement();
	         rs = stmt.executeQuery(sql);
	         
	         while (rs.next()) {
	            BookVO bVo = new BookVO(); 
	            bVo.setCategory(rs.getString("category"));
	            list.add(bVo);
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      }finally {
	         DBManager.close(conn, stmt, rs);
	      }
	      return list;
	}
	
	//카테고리별 조회
	public List<BookVO> selectBooksByCategory(String category) {
		
		String sql = "select * from book where category = ?";
		List<BookVO> list = new ArrayList<BookVO>();
		BookVO bVo = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				bVo = new BookVO();
				bVo.setNum(rs.getInt("num"));
				bVo.setCategory(rs.getString("category"));
				bVo.setTitle(rs.getString("title"));
				bVo.setPrice(rs.getString("price"));
				bVo.setSummary(rs.getString("summary"));
				bVo.setAuthor(rs.getString("author"));
				bVo.setPub(rs.getString("pub"));
				bVo.setGrade(rs.getString("grade"));
				bVo.setPictureurl(rs.getString("pictureurl"));
				
				list.add(bVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	//도서 검색 메서드
	public List<BookVO> searchBook(String searchCategory, String keyWord) {

	    //책의 정보를 한개 이상 저장하기 위해 ArrayList 클래스로 객체 생성
		List<BookVO> list = new ArrayList<>();
		BookVO bVo = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//searchCategory 검색 3분류(제목,작가,출판사)값을 받아와서 like 연산자를 사용하여 단어 검색  
		String sql = "select * from book where " + searchCategory.trim() + " like ?";
		
		sql += "order by num";

		try {
			
	        //쿼리문을 실행하기 전에 커넥션 객체를 얻기 위해 DBManager클래스의 정적 메소드(getConnection())를 호출
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			//키워드가 들어간 모든 검색 결과를 출력하기 위해 % 사용 
			pstmt.setString(1, "%" + keyWord.trim() + "%"); 
			rs = pstmt.executeQuery();

			while (rs.next()) {
				bVo = new BookVO();

				bVo.setNum(rs.getInt("num"));
				bVo.setCategory(rs.getString("category"));
				bVo.setTitle(rs.getString("title"));
				bVo.setPrice(rs.getString("price"));
				bVo.setSummary(rs.getString("summary"));
				bVo.setAuthor(rs.getString("author"));
				bVo.setPub(rs.getString("pub"));
				bVo.setGrade(rs.getString("grade"));
				bVo.setPictureurl(rs.getString("pictureurl"));
				
				list.add(bVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	//도서의 개수 출력 메서드
	public int bookCount(String searchCategory, String keyWord) {

		int count = 0;
		
		String sql = "select count(*) as count  from book where " + searchCategory.trim() + " like ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + keyWord.trim() + "%");
			rs = pstmt.executeQuery();

			if (rs.next()) {
				count = rs.getInt("count");

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return count;
		
	}
}
