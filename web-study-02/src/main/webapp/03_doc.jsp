<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%!

	int cnt=1;
	public int abs(int n){
		return n>0? n : n*-1;
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int cnt2 = 1;
	System.out.println(cnt2++);
	System.out.println(cnt++);
	
%>
</body>
</html>