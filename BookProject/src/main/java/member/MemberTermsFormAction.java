package member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.Action;

public class MemberTermsFormAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String url = "/member/memberTerms.jsp";
		
		RequestDispatcher dis = request.getRequestDispatcher(url);
	    dis.forward(request, response);
	} 
}