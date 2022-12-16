package com.saeyan.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/upload.do")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; utf-8");
		
		PrintWriter out = response.getWriter();
		
		String savePath = "upload";
		int uploadFileSize = 1024 * 1024 * 5;
		String encType = "utf-8";
		
		ServletContext context = getServletContext();
		String uploadFilePath =  context.getRealPath(savePath);
		System.out.println("서버상 실제 디렉토리");
		System.out.println(uploadFilePath);
		
		try {
			
			MultipartRequest multi = new MultipartRequest(
					request, 
					uploadFilePath,
					uploadFileSize,
					encType,
					new DefaultFileRenamePolicy());
			
			String fileName = multi.getFilesystemName("uploadFile");
			
			if(fileName == null) {
				System.out.println("파일이 업로드되지않았음.");
			}else {
				out.println("<br> 글쓴이 : " + multi.getParameter("name"));
				out.println("<br> 제목 : " + multi.getParameter("title"));
				out.println("<br> 파일명 : " + fileName);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
