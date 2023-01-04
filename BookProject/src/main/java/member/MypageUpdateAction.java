package member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.Action;
import dto.MemberDAO;
import dto.MemberVO;

public class MypageUpdateAction implements Action {

	 @Override
	   public void execute(HttpServletRequest request, HttpServletResponse response)
	         throws ServletException, IOException{
		 
		 	
			
			//회원 정보를 저장할 객체 생성하고 값 불러오기
			MemberVO mVo = new MemberVO();
			mVo.setId(request.getParameter("id"));
			mVo.setPass(request.getParameter("pass"));
			mVo.setName(request.getParameter("name"));
			mVo.setPhone(request.getParameter("phone"));
			mVo.setEmail(request.getParameter("email"));
			
			System.out.println("mVo: " + mVo);
			MemberDAO mDao = MemberDAO.getInstance();	
			mDao.updateMypage(mVo);
			
			response.sendRedirect("BookServlet?command=member_mypage");
		 
		 
		 
	 }
}