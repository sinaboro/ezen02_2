package book;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action { //명령 처리 클래스의 슈퍼 클래스로 사용할 인터페이스

	public void execute(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException;
}

