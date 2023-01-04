package member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import book.Action;

public class MemberLogoutAction implements Action {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		request.setAttribute("message", "로그아웃되었습니다.");
		session.invalidate();
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/book/bookMain.jsp");
		dispatcher.forward(request, response);
	}
}