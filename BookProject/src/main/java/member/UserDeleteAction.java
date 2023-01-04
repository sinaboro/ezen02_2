package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.Action;
import dto.MemberDAO;

public class UserDeleteAction implements Action{

	@Override 
	public void execute(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		String id = request.getParameter("id");

		MemberDAO mDao = MemberDAO.getInstance();
		
		mDao.deleteMember(id);
		
		new MemberListAction().execute(request, response);
		
	}
}