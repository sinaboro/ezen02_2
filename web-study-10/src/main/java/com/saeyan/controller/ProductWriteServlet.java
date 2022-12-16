package com.saeyan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.saeyan.dto.ProductDAO;
import com.saeyan.dto.ProductVO;

@WebServlet("/productWrite.do")
public class ProductWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dis = request.getRequestDispatcher("product/productWrite.jsp");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String path = getServletContext().getRealPath("upload");
		String encType = "utf-8";
		int sizeLimit = 20*1024*1024; //20MB
		
		MultipartRequest multi = 
				new MultipartRequest(
						request, 
						path,
						sizeLimit,
						encType,
						new DefaultFileRenamePolicy());
		
		String name = multi.getParameter("name");
		int price = Integer.parseInt(multi.getParameter("price"));
		String pictureUrl = multi.getFilesystemName("pictureUrl");
		String description = multi.getParameter("decription");
		System.out.println("pictureUrl : " + pictureUrl);
		System.out.println("path : " + path);
		ProductVO vo = new ProductVO();
		vo.setName(name);
		vo.setPrice(price);
		vo.setPictureUrl(pictureUrl);
		vo.setDescription(description);
		
		ProductDAO dao = ProductDAO.getInstance();
		int result =  dao.insertProduct(vo);
		if(result == 1)
			response.sendRedirect("List");
		else {
			RequestDispatcher dis = request.getRequestDispatcher("product/productWrite.jsp");
			dis.forward(request, response);
		}
			
				
		
	}

}
