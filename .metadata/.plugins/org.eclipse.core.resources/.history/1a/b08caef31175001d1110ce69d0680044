package unit01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JoinServlet")
public class JoinServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		
		String name = request.getParameter("name");
		out.println("이름 : <b>");
		out.print(name);		
		
		String jumin = request.getParameter("jumin_1")
				+ "-"+ request.getParameter("jumin_2");
		out.println("</b><br>주민번호 : <b>");
		out.print(jumin);
		
		String id = request.getParameter("id");
		out.println("</b><br>아 이 디 : <b>");
		out.print(id);
		
		String pwd = request.getParameter("pwd");
		out.println("</b><br>비밀번호 : <b>");
		out.print(pwd);
		
		String email = request.getParameter("email");
		if (request.getParameter("email_dns").trim() == "") {
			email += "@" + request.getParameter("emailaddr");
		} else {
			email += "@" + request.getParameter("email_dns");
		}
		out.println("</b><br>이 메 일 : <b>");
		out.print(email);
		
		String zip = request.getParameter("zip");
		out.println("</b><br>우편번호 : <b>");
		out.print(zip);
				
		String addr = request.getParameter("addr1")+request.getParameter("addr2");
		out.println("</b><br>주소 : <b>");
		out.print(addr);

		String phone = request.getParameter("phone");
		out.println("</b><br> 핸드폰번호 : <b>");
		out.print(phone);

		String job = request.getParameter("job");			
		out.println("</b><br>직업 : <b>");
		out.print(job);
		
		out.println("</b><br>관심분야 : <b>");
		String interests[] = request.getParameterValues("interest");
		if (interests == null) {
			out.print("선택한 항목이 없습니다.");
		} else {
			for (String interest : interests) {
				out.print(interest + " ");
			}
		}
		// 자바 스크립트로 이전 페이지로 이동하는 링크를 만들어 줌
		out.println("</b><br><br><a href='javascript:history.go(-1)'>다시</a>");
		out.print("</body></html>");
		out.close();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}
}
