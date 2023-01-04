package book;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BookDAO;
import dto.BookVO;

public class BookListAction implements Action{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
	         throws ServletException, IOException {
		
	      String url = "/book/bookList.jsp";
	      
	      BookDAO bDao = BookDAO.getInstance();
	      
	      //selectAllBooks 메소드를 호출하여 List<BookVO>객체에 저장
	      List<BookVO> booklist = bDao.selectAllBooks();
	       
	      //request객체의 속성에 데이터를 담아 jsp 페이지로 보낸다.
	      request.setAttribute("booklist", booklist);
	      
	      RequestDispatcher dis = request.getRequestDispatcher(url);
	      dis.forward(request, response);
	   }

}
