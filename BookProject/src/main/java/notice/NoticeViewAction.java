package notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.Action;
import dto.NoticeDAO;
import dto.NoticeVO;

public class NoticeViewAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/notice/noticeView.jsp";
		int num = Integer.parseInt(request.getParameter("num"));
		
		NoticeDAO nDao = NoticeDAO.getInstance();
		nDao.updateReadCount(num);
		
		NoticeVO nVo = nDao.selectOneNotice(num);
		
		request.setAttribute("notice", nVo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
