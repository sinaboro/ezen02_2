package book;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BookBestFormAction implements Action {
		@Override
		public void execute(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
			String url = "/book/bookBest.jsp";
			
			RequestDispatcher dis = request.getRequestDispatcher(url);
			dis.forward(request, response);
		}
	}

