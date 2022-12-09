<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- MemberBean member = new MemberBean();  --%>
<jsp:useBean id="member" class="com.saeyan.javabeans.MemberBean"/>

<h2>빈 생성 전</h2>
<%= member.getName() %>
<%= member.getUserid() %>
------------------------------------------
<%
	member.setName("홍길동" + "<br>");
	member.setUserid("abcd" + "<br>");
%>
<h2>빈 생성 후</h2>
<%= member.getName() %> <br>
<%= member.getUserid() %> <br>
<%= member.getNickname() %> <br>
</body>
</html>