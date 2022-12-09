<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html; charset=utf-8");
	String hak = request.getParameter("hak");
	String name = request.getParameter("name");
	int java = Integer.parseInt(request.getParameter("java"));
	int jsp = Integer.parseInt(request.getParameter("jsp"));
	int spring = Integer.parseInt(request.getParameter("spring"));
	int tot = java+jsp+spring;
	int avg = tot/3;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		학번 : <%=hak %><br>
		이름 : <%=name %><br>
		총점 : <%=tot %><br>
		평균 : <%=avg %><br>
</body>
</html>