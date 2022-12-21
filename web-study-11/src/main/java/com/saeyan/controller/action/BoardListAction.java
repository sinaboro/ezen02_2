package com.saeyan.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import saeyan.dao.BoardDAO;
import saeyan.dto.BoardVO;

public class BoardListAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardDAO dao = BoardDAO.getInstance();
		List<BoardVO> list = dao.selectAllBoards();
		
	//	System.out.println("list :  " + list);
		
		request.setAttribute("boardList", list);
		RequestDispatcher dis = 
				request.getRequestDispatcher("/board/boardList.jsp");
		dis.forward(request, response);
		
		
	}

}
