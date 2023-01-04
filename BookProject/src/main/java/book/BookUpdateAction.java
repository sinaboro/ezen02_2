package book;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BookDAO;
import dto.BookVO;

public class BookUpdateAction implements Action{

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) 
	  throws ServletException, IOException {
   
      BookVO bVo = new BookVO();
      
      bVo.setNum(Integer.parseInt(request.getParameter("num")));
      bVo.setCategory(request.getParameter("category"));
      bVo.setTitle(request.getParameter("title"));
      bVo.setPrice(request.getParameter("price"));
      bVo.setSummary(request.getParameter("summary"));
      bVo.setAuthor(request.getParameter("author"));
      bVo.setPub(request.getParameter("pub"));
      bVo.setGrade(request.getParameter("grade"));
      
      BookDAO bDao = BookDAO.getInstance();
      bDao.updateBook(bVo);
      
      new BookListAction().execute(request,response);
   }
}