<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
		response.sendRedirect("http://localhost:8081/BookProject/BookServlet?command=book_main");
%>

</body>
</html>