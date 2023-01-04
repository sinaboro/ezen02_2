package book;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BookDAO;

public class BookDeleteAction implements Action {

	@Override 
	public void execute(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		//책의 num값을 기준으로 데이터를 삭제
		int num = Integer.parseInt(request.getParameter("num"));

		//BookDAO의객체를 얻어오기 위해 getInstanc()를 호출 
		BookDAO bDao = BookDAO.getInstance();
		//deleteBook을 호출하면서 위에서 입력받은 num값의 데이터를 삭
		bDao.deleteBook(num);
		
		new BookListAction().execute(request, response);
	}
}
