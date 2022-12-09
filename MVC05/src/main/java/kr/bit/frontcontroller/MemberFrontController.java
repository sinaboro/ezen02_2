package kr.bit.frontcontroller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.controller.Controller;
import kr.bit.controller.MemberContentController;
import kr.bit.controller.MemberDeleteController;
import kr.bit.controller.MemberInsertController;
import kr.bit.controller.MemberListController;
import kr.bit.controller.MemberRegisterController;
import kr.bit.controller.MemberUpdateController;
import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;
@WebServlet("*.do")
public class MemberFrontController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		// 클라이언트가 어떤 요청을 했는지 파악하기
		String url=request.getRequestURI();
		//System.out.println(url);		
		String ctx=request.getContextPath();
		//System.out.println(ctx);		
		// 실제로 요청한 명령이 무엇이지 파악
		String command=url.substring(ctx.length());
		System.out.println(command); // /memberInsert.do
		// 요청에 따른 분기작업(if~ else if~)
		Controller controller=null;
		String nextPage=null;
		// 핸들러매핑->HandlerMapping
	    HandlerMapping mapping=new HandlerMapping();
	    controller=mapping.getController(command);
	    nextPage=controller.requestHandler(request, response);
		// forward, redirect
		if(nextPage!=null) {
			if(nextPage.indexOf("redirect:")!=-1) {
				//            redirect:/MVC04/memberList.do
				response.sendRedirect(nextPage.split(":")[1]); // redirect
			}else {
				RequestDispatcher rd=request.getRequestDispatcher(ViewResolver.makeView(nextPage)); // forward
				rd.forward(request, response);
			}
		}		
	}
}
