package unit01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Add")
public class AdditionServlet01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public AdditionServlet01() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		int add = num1 +num2;
		PrintWriter out = response.getWriter();
		
		System.out.println("add = " + add);
		out.println("<html><head><title>Addition</title></head>");
		out.println("<body>");
		out.println(num1 +  "+" + num2 + " = " + add );
		out.println("</body></html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	}

}
