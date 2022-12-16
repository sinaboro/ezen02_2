package com.saeyan.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.BoardDAO;
import com.saeyan.dto.BoardVO;

public class BoardReplyAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardVO bVo = new BoardVO();
		String num = request.getParameter("num");
		//부모정보가져오기
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO pboard = dao.selectOneBoardByNum(num);
		
		bVo.setName(request.getParameter("name"));
		bVo.setPass(request.getParameter("pass"));
		bVo.setEmail(request.getParameter("email"));
		bVo.setTitle(request.getParameter("title"));
		bVo.setContent(request.getParameter("content"));
		bVo.setBgroup(pboard.getBgroup());
		bVo.setBsequence(pboard.getBsequence()+1);
		bVo.setBlevel(pboard.getBlevel()+1);
		dao.replySeqUpdate(pboard);
//		BoardDAO bDao = BoardDAO.getInstance();
		dao.insertReplyBoard(bVo);
		new BoardListAction().execute(request, response);
	}
}
