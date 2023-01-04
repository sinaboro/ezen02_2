package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.Action;
import dto.MemberDAO;
import dto.MemberVO;

public class UserManagerAction implements Action {

	 @Override
	   public void execute(HttpServletRequest request, HttpServletResponse response)
	         throws ServletException, IOException{
		 
		 	String id = request.getParameter("id");
			String pass = request.getParameter("pass");
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			String lev = request.getParameter("lev");
			
			//회원 정보를 저장할 객체 생성
			MemberVO mVo = new MemberVO();
			mVo.setId(id);
			mVo.setPass(pass);
			mVo.setName(name);
			mVo.setPhone(phone);
			mVo.setEmail(email);
			mVo.setLev(lev);
			
			MemberDAO mDao = MemberDAO.getInstance();	
			mDao.userManager(mVo);
			
			response.sendRedirect("BookServlet?command=member_list");
		 
		 
		 
		 
	 }
}
