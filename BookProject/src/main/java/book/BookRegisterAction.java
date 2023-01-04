package book;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BookDAO;
import dto.BookVO;

public class BookRegisterAction implements Action{
   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException{
      
	  //BookVO에서 값을 불러옴
      BookVO bVo = new BookVO();
      
      //불러온 값을 bVo에 저장
      bVo.setCategory(request.getParameter("category"));
      bVo.setTitle(request.getParameter("title"));
      bVo.setPrice(request.getParameter("price"));
      bVo.setSummary(request.getParameter("summary"));
      bVo.setAuthor(request.getParameter("author"));
      bVo.setPub(request.getParameter("pub"));
      bVo.setGrade(request.getParameter("grade"));
      bVo.setPictureurl(request.getParameter("pictureurl"));
      
      BookDAO Dao = BookDAO.getInstance();
      
      //insertBook메서드를 호출해서 입력받은 VO값을 DB에 전달
      Dao.insertBook(bVo);
      
      //new BookListAction().execute(request, response);
      response.sendRedirect("BookServlet?command=book_list");
   }
}