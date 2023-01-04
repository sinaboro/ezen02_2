package member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.Action;
import dto.MemberDAO;
import dto.MemberVO;



public class UserManagerFormAction implements Action{

	 @Override
	   public void execute(HttpServletRequest request, HttpServletResponse response)
	         throws ServletException, IOException{
		 
		 	String id = request.getParameter("id");
			MemberDAO mDao = MemberDAO.getInstance();
			
			MemberVO mVo = mDao.getMember(id);
			request.setAttribute("mVo", mVo);
			
			RequestDispatcher dis = request.getRequestDispatcher("/member/userManager.jsp");
			dis.forward(request, response);
	 }
}
