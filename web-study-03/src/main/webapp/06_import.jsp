<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	Calendar date = Calendar.getInstance();
	SimpleDateFormat today = new SimpleDateFormat("yyyy년 MM월 dd일");
	SimpleDateFormat now = new SimpleDateFormat("hh시 mm분 ss초");

	System.out.println(date.getTime());
%>

<%= today.format(date.getTime()) %><br>
<%= now.format(date.getTime()) %><br>

</body>
</html>