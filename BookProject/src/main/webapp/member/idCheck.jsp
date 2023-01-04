<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중복 체크</title>
<script type="text/javascript" src="script/member.js"></script>
<link rel="stylesheet" type="text/css" href="css/idCheck.css">
</head>
<body>
<div id="container">
	<h2>아이디 중복 확인</h2>
	<form action="BookServlet" method="post" name="frm">
	<input type="hidden" name="command" value="id_check_form">
	아이디 <input type="text" name="id" id="id" value="${id}">
		 <input type="submit" value="중복 체크" id="btn">
	<br>
	<c:if test="${result == 1}">
		<script type="text/javascript">
			opener.document.frm.id.value="";
		</script>
		${id}은/는 이미 사용 중인 아이디입니다.
	</c:if>
	<c:if test="${result == -1}">
		${id}은/는 사용 가능한 아이디입니다.
		<input type="button" value="사용" id="btn" class="cancel" onclick="idOk()">
	</c:if>
	</form>
</div>
</body>
</html>