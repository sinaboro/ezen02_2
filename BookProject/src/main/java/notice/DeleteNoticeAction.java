package notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.Action;
import dto.NoticeDAO;

public class DeleteNoticeAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		
		NoticeDAO nDao = NoticeDAO.getInstance();
		nDao.deleteNotice(num);
		
		response.sendRedirect("BookServlet?command=notice_list");
	}
}
