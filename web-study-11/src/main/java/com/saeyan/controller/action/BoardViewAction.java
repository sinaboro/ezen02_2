package com.saeyan.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import saeyan.dao.BoardDAO;
import saeyan.dto.BoardVO;

public class BoardViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO vo = dao.selectOneBoardByNum(num);
		request.setAttribute("board", vo);
		
		RequestDispatcher dis = request.getRequestDispatcher("/board/boardView.jsp");
		dis.forward(request, response);
	}

}
