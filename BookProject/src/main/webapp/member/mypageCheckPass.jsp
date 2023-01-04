<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴</title>
<script type="text/javascript" src="script/member.js"></script>
<link rel="stylesheet" href="css/checkPass.css">
</head>
<body>
	<div id="container">
		<h1>비밀번호 확인</h1>
		<form action="BookServlet" name="frm" method="get">
			<input type="hidden" name="command" value="mypage_check_pass">
			<input type="hidden" name="id" value="${member.id}">
			<table>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="pass" size="20">
					<input type="hidden" name="pass_check" value="${member.pass}"></td>
				</tr>
			</table>
			<input type="submit" value="확인" id="btn"
				onclick="return mypagePassCheck()"> <br>
			<br>${message}
		</form>
	</div>
</body>
</html>