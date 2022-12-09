<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String[] movieList = { "타이타닉", "시네마 천국", "혹성 탈출", "킹콩" };
		pageContext.setAttribute("movieList", movieList);
	%>
	<c:forEach var="movie" items="${movieList}">
${movie}<br>
	</c:forEach>
</body>
</html>