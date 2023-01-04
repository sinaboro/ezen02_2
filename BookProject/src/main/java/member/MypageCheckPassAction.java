package member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.Action;
import dto.MemberDAO;
import dto.MemberVO;

public class MypageCheckPassAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String url = null;
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		MemberDAO mDao = MemberDAO.getInstance();
		MemberVO mVo = mDao.selectOneMemberById(id);
		
		if(mVo.getPass().equals(pass)) {
			url = "member/checkPassSuccess.jsp";}

		
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
		
	}
}