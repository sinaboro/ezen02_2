package book;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BookDAO;
import dto.BookVO;

public class BookCategoryViewerAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String url = "/book/bookCategoryViewer.jsp";
		String category = request.getParameter("category");
		System.out.println("category: " + category);
		
		String categoryName = "";
		
		try {
			switch(category) {
			case "001": 
				categoryName = "국어 외국어 사전";
				break;
			case "002": 
				categoryName = "청소년";
				break;
			case "003": 
				categoryName = "경제 경영";
				break;
			case "004": 
				categoryName = "가정 살림";
				break;
			case "005": 
				categoryName = "인문";
				break;
			case "006": 
				categoryName = "소설/시/희곡";
				break;
			case "007": 
				categoryName = "에세이";
				break;
			case "008": 
				categoryName = "수험서 자격증";
				break;
			case "009": 
				categoryName = "만화/라이트노벨";
				break;
			case "010": 
				categoryName = "종교";
				break;
			case "011": 
				categoryName = "자연과학";
				break;
			case "012": 
				categoryName = "자기계발";
				break;
			case "013": 
				categoryName = "예술";
				break;
			case "014": 
				categoryName = "유아";
				break;
			case "015": 
				categoryName = "어린이";
				break;
			case "016": 
				categoryName = "사회 정치";
				break;
			case "017": 
				categoryName = "IT 모바일";
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		BookDAO bDao = BookDAO.getInstance(); 
		
		//BookDAO의 객체를 얻어오기 위해 getInstance()를 호출
		List<BookVO> booklist = bDao.selectBooksByCategory(categoryName);
		
	    //selectBooksByCategory 메소드를 호출하여 List<BookVO>객체에 저장
		request.setAttribute("booklist", booklist);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}