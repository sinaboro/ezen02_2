package book;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.BookDAO;
import dto.BookVO;

public class BookSearchAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		//화면에서받아온 searchCategory와 keyword 정의. 
		String url = "/book/bookSearch.jsp";
		String searchCategory = request.getParameter("searchCategory");
		String keyWord = request.getParameter("keyWord");
		
		//세션에 키워드 값 저장.
		HttpSession session = request.getSession();
		session.setAttribute("keyWord", keyWord);
		
		BookDAO bDao = BookDAO.getInstance();
		
		//검색결과 개수를 나타내기 위해 bookCount메소드 사용 
		int count = bDao.bookCount(searchCategory, keyWord);
		request.setAttribute("count", count);
		
	    //searchBook 메소드를 호출하여 List<BookVO>객체에 저장
		List<BookVO> searchResult = bDao.searchBook(searchCategory, keyWord);
		
	    //request객체의 속성에 데이터를 담아 jsp 페이지로 보낸다.
		request.setAttribute("searchResult", searchResult);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}