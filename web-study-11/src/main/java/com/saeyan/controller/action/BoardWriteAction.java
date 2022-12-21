package com.saeyan.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import saeyan.dao.BoardDAO;
import saeyan.dto.BoardVO;

public class BoardWriteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardVO vo  = new BoardVO();
		
		vo.setName(request.getParameter("name"));
		vo.setPass(request.getParameter("pass"));
		vo.setEmail(request.getParameter("email"));
		vo.setTitle(request.getParameter("title"));
		vo.setContent(request.getParameter("content"));
		
		BoardDAO dao = BoardDAO.getInstance();
		dao.insertBoard(vo);
		
		new BoardListAction().execute(request, response);
		
	}

}
