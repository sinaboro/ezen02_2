<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="board" class="com.saeyan.javabeans.BoardBean"/>
<jsp:setProperty property="*" name="board"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>입력 완료된 정보</h2>
작성자 : ${ board.getName() }<br>
비밀번호 : ${ board.getPass()} <br>
이메일 : ${ board.getEmail() } <br>
글제목 : <%=board.getTitle() %><br>
글내용 : <%=board.getContent() %> <br>

empty : \${!empty board.getTitle() }<br>

\${( 5>2)  || (2<10) } : ${ ( 5>2)  || (2<10) }


<%
	if(board.getTitle() == null){
%>

		텅 빈 객체입니다.
<%
	}else{
%>
		텅 빈 객체가 아닙니다.
<%
	}
%>










</body>
</html>