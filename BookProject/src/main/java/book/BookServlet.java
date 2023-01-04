package book;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	//요청을 받아서 요청에 해당하는 Model과 View를 호출하는 역할을 한다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		
		String command = request.getParameter("command");
		
		//요청을 서블릿이 받았음을 콘솔 창에서 확인할 수 있다.
		System.out.println("BoardServlet에서 요청을 받음을 확인 : "+command);
		
		ActionFactory af = ActionFactory.getInstance();
		
		//command 요청 파라미터 값을 af객체의 getAction()메소드에 전달해준다.
		Action action = af.getAction(command);
		
		if(action != null) {
			action.execute(request,response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
