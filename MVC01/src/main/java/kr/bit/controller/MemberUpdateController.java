package kr.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;
@WebServlet("/memberUpdate.do")
public class MemberUpdateController extends HttpServlet {	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			                                   throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//파라메터 수집(VO)
		int num=Integer.parseInt(request.getParameter("num"));
		int age=Integer.parseInt(request.getParameter("age"));
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		
		MemberVO vo=new MemberVO();
		vo.setNum(num);
		vo.setAge(age);
		vo.setEmail(email);
		vo.setPhone(phone);
		
		MemberDAO dao=new MemberDAO();
		int cnt=dao.memberUpdate(vo);
		if(cnt>0) {
		    	// 가입성공		        
		    	response.sendRedirect("/MVC01/memberList.do");
		 }else {
		    	// 가입실패-> 예외객체를 만들어서  WAS에게 던지자.
		    	throw new ServletException("not update");	    	
		 }	
	}
}
