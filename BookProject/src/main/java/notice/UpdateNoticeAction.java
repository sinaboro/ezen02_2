package notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.Action;
import dto.NoticeDAO;
import dto.NoticeVO;

public class UpdateNoticeAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeVO nVo = new NoticeVO();
		
		nVo.setNum(Integer.parseInt(request.getParameter("num")));
		nVo.setTitle(request.getParameter("title"));
		nVo.setContent(request.getParameter("content"));
		
		NoticeDAO nDao = NoticeDAO.getInstance();
		nDao.updateNotice(nVo);
		
		response.sendRedirect("BookServlet?command=notice_list");
	}
}