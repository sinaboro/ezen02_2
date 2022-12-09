<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<c:set var = "msg" value="Hello"/>
	\${msg} = ${msg }<br>
	<c:set var="age">
		30
	</c:set>
	
	\${age } = ${age} <br>
	
	<c:set var="member" value="<%=new com.ezen.ex01.MemberBean() %>" ></c:set>
	
	<c:set target="${member}" property="name" value="홍길동"/>
	<c:set target="${member}" property="userid" value="test"/>
	\${member } : ${member }<br>
	
	<c:set var="add" value="${10+5 }"/>
	\${add} : ${add }<br>
	
	<c:set var="flag" value="${10>5 }" />
	\${flag } : ${flag }
	
	
	
		
</body>
</html>