package member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.Action;
import dto.MemberDAO;
import dto.MemberVO;


public class IdCheckFormAction implements Action {
	
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");

		MemberDAO mDao = MemberDAO.getInstance();
		int result = mDao.confirmID(id);
		
		request.setAttribute("id", id);
		request.setAttribute("result", result);
		
		System.out.println("id: " + id + ", result: " + result);

		request.getRequestDispatcher("/member/idCheck.jsp").forward(request, response);
		//new IdCheckAction().execute(request, response);
		
	}
}