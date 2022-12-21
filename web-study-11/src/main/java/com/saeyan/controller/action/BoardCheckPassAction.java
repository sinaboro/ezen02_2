package com.saeyan.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import saeyan.dao.BoardDAO;
import saeyan.dto.BoardVO;

public class BoardCheckPassAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = null;
		int num = Integer.parseInt(request.getParameter("num"));
		String pass = request.getParameter("pass");
		
		System.out.println("num : " + num + "pass : " + pass);
		
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO vo = dao.selectOneBoardByNum(num);
		System.out.println("BoardCheckPassAction vo : " + vo);
		if(vo.getPass().equals(pass)) {
			url = "/board/checkSuccess.jsp";
		}else {
			url = "/board/boardCheckPass.jsp";
			request.setAttribute("message", "비밀번호가 틀렸습니다.");
		}
		
		RequestDispatcher dis = 
				request.getRequestDispatcher(url);
		dis.forward(request, response);
		
	}

}
