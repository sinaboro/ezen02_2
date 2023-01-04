
package member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.Action;
import dto.MemberDAO;
import dto.MemberVO;



public class MemberMyPageAction implements Action{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
	 	String id = request.getParameter("id");

		MemberVO mVo = new MemberVO();
		
		mVo.setId(request.getParameter("id"));
		mVo.setPass(request.getParameter("pass"));
		mVo.setName(request.getParameter("name"));
		mVo.setPhone(request.getParameter("phone"));
		mVo.setEmail(request.getParameter("email"));
		mVo.setLev(request.getParameter("lev"));
		
		MemberDAO Dao = MemberDAO.getInstance();
		
		mVo = Dao.getMember(id);
	
		
		 RequestDispatcher dis = request.getRequestDispatcher("/member/memberMypage.jsp");
		 dis.forward(request, response);
	}
	
}