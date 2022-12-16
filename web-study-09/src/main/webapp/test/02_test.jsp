<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.saeyan.dto.*" %>
<%

	MemberDAO dao = MemberDAO.getInstance();
    Connection conn = dao.getConnection();
    out.println("conn : " + conn);
	
%>