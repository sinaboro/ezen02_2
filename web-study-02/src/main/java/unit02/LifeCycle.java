package unit02;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LifeCycle")
public class LifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	int initcount =1;
	int getcount =1;
	int destcount =1;
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init Method" + initcount++);
	}

	public void destroy() {
		System.out.println("destroy Method" + getcount++);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet Method" + destcount++);
	}

}
