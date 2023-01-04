package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.Action;
import dto.MemberDAO;
import dto.MemberVO;
public class MemberJoinAction implements Action {
	
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		MemberVO mVo = new MemberVO();
		
		mVo.setName(request.getParameter("name"));
		mVo.setId(request.getParameter("id"));
		mVo.setPass(request.getParameter("pass"));
		mVo.setEmail(request.getParameter("email"));
		mVo.setPhone(request.getParameter("phone"));
		
		MemberDAO mDAO = MemberDAO.getInstance();
		mDAO.insertMember(mVo);
		
		
		response.sendRedirect("BookServlet?command=book_main");
	}
}