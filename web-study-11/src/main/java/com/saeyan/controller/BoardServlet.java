package com.saeyan.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.controller.action.Action;
import com.saeyan.controller.action.BoardWriteFormAction;

//Front Controller(브라우저 요청을 front controller가 받는다..)
//==> BoardServlet?command=board_list
//BoardServlet?command=board_write_form   BoardServlet?command=?????
//BoardServlet?command=board_write
@WebServlet("/BoardServlet")
public class BoardServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String command = request.getParameter("command");  //board_view
		System.out.println("BoardServlet에서 요청을 받음을 확인 : " + command); //board_write_form board_write
		
		ActionFactory af = ActionFactory.getInstance();
		Action action = af.getAction(command);  //BoardViewAction
		
		if(action != null) {
			action.execute(request, response);  //BoardViewAction
		} 
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request,response);
	}		
}
