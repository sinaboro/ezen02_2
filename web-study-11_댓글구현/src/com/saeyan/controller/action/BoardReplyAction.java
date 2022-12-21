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
		
		BoardVO bVo = new BoardVO(); //차일드 댓글
		String num = request.getParameter("num");  //num는 누구꺼? 부모꺼
		
		
		//부모정보가져오기
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO pboard = dao.selectOneBoardByNum(num);  //부모글
		
		//아래꺼는 누구꺼? 댓글본인꺼
		bVo.setName(request.getParameter("name"));
		bVo.setPass(request.getParameter("pass"));
		bVo.setEmail(request.getParameter("email"));
		bVo.setTitle(request.getParameter("title"));
		bVo.setContent(request.getParameter("content"));
		
		//공식에 따라서... bgroup는 같고,  bsequence, blevel는 +1 시킨다.
		bVo.setBgroup(pboard.getBgroup());
		bVo.setBsequence(pboard.getBsequence()+1);
		bVo.setBlevel(pboard.getBlevel()+1);
		
		//기존 그룹이 같은 댓글들 bsequence+1식 증가
		dao.replySeqUpdate(pboard);
		
		
//		BoardDAO bDao = BoardDAO.getInstance();
		dao.insertReplyBoard(bVo);
		new BoardListAction().execute(request, response);
	}
}
