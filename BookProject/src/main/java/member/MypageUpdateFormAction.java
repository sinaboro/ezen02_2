package member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.Action;
import dto.MemberDAO;
import dto.MemberVO;



public class MypageUpdateFormAction implements Action{

	 @Override
	   public void execute(HttpServletRequest request, HttpServletResponse response)
	         throws ServletException, IOException{
		 	String url = "/member/mypageUpdate.jsp";
		 	String id = request.getParameter("id");
			
		 	MemberDAO mDao = MemberDAO.getInstance();
			MemberVO mVo = mDao.selectOneMemberById(id);

			request.setAttribute("member", mVo);
			
			RequestDispatcher dis = request.getRequestDispatcher(url);
			dis.forward(request, response);
	 }
}