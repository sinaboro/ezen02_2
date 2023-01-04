package book;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BookDAO;
import dto.BookVO;

public class BookDetailAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//책의 num값을 기준으로 상세정보를 검
		String url = "/book/bookDetail.jsp";
		
		int num = Integer.parseInt(request.getParameter("num"));

		BookDAO bDao = BookDAO.getInstance();

		BookVO bVo = bDao.selectOneBookByNum(num);

		//request객체의 속성에 데이터를 담아 jsp페이지로 보낸다.
		request.setAttribute("book", bVo);

		//bookDetail.jsp로 포워딩
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
