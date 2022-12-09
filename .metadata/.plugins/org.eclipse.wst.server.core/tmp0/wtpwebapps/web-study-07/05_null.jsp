<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	자바 코드 : <%=request.getParameter("id") %><br>
	EL식  : ${param.id } 
</body>
</html>