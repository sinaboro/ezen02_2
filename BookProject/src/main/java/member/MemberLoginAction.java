package member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import book.Action;
import dto.MemberDAO;
import dto.MemberVO;

public class MemberLoginAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String url = "/member/memberLogin.jsp";
		
		HttpSession session = request.getSession();
		session.setAttribute("login", id);
		MemberDAO mDao = MemberDAO.getInstance();
		int result = mDao.userCheck(id, pass);
		
		if(result == 1) {
			MemberVO mVo = mDao.getMember(id);
			HttpSession session2 = request.getSession();
			session2.setAttribute("member", mVo);
			request.setAttribute("message", "로그인 성공");
			
			url = "/book/bookMain.jsp";
		} else if (result == 0) {
			request.setAttribute("message", "비밀번호가 일치하지 않습니다.");
		} else {
			request.setAttribute("message", "존재하지 않는 아이디입니다.");
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
	}
}