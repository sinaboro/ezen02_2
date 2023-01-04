package notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import book.Action;
import dto.NoticeDAO;
import dto.NoticeVO;

public class NoticeRegisterAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		NoticeVO nVo = new NoticeVO();
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("login");
		
		nVo.setId(id);
		nVo.setTitle(request.getParameter("title"));
		nVo.setContent(request.getParameter("content"));
		
		NoticeDAO nDao = NoticeDAO.getInstance();
		nDao.registerNotice(nVo);
		
		
		response.sendRedirect("BookServlet?command=notice_list");
	}
}
