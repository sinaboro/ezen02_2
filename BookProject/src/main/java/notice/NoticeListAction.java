package notice;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.Action;
import dto.NoticeDAO;
import dto.NoticeVO;


	public class NoticeListAction implements Action {
		@Override
		public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String url = "/notice/noticeList.jsp";
			
			NoticeDAO nDao = NoticeDAO.getInstance();
			List<NoticeVO> list = nDao.selectAllNotices();
			
			request.setAttribute("notice", list);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}
	}

