<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.net.URLEncoder" %>

<%
//  	String userID = request.getParameter("userID");
	//String userPWD = request.getParameter("userPWD");
	String loginCheck = request.getParameter("loginCheck");
	
	if(loginCheck.equals("user")){
%>
	<jsp:forward page="09_userMain.jsp">
		<jsp:param value='<%=URLEncoder.encode("손흥민", "utf-8") %>' name="userName"/>
	</jsp:forward>
<%		
	}else{
%>
	<jsp:forward page="09_managerMain.jsp">
		<jsp:param value='<%=URLEncoder.encode("홍길동", "utf-8") %>' name="userName"/>
	</jsp:forward>
	
<%		
	}
%>
