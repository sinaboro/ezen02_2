package kr.bit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;

public class MemberListController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// POJO가 해야할 일의 범위
		// 1. Model 연동
		MemberDAO dao=new MemberDAO();
		List<MemberVO> list=dao.memberList();
		// 2. 객체바인딩
		request.setAttribute("list", list);
		// member/memberList.jsp
		// 다음페이지는 
		// 3.다음페이지정보(View)
		return "memberList";		
	}
}
