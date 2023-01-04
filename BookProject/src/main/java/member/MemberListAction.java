package member;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.Action;
import dto.MemberDAO;
import dto.MemberVO;

public class MemberListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
	         throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		MemberDAO mDao = MemberDAO.getInstance();
		
		List<MemberVO> memberList = mDao.listMember();
		request.setAttribute("memberList", memberList);
		
		System.out.println("작동중" +memberList);
		
		RequestDispatcher dis = request.getRequestDispatcher("member/memberList.jsp");
		dis.forward(request, response);
		
	}
}
