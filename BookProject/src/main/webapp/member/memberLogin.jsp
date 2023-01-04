<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<script type="text/javascript" src="script/member.js"></script>
<link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
<% session.invalidate(); %>
	<div id="container">
		<h2>
			<a href="BookServlet?command=book_main">
				<img alt="LOGO" src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FCdrYl%2FbtrUTKBvWql%2FneUhG0VH9Jro8xRV8EGl61%2Fimg.png"
				width="100%" height="110%">
			</a>
		</h2>
		<form action="BookServlet" method="post" name="frm">
		<input type="hidden" name="command" value="member_login">
		<table>
			<tr>
				<!-- <td> 아이디 </td> -->
				<td colspan="2"> <input type="text" name="id" value="${member.id}" id="id" 
				placeholder="아이디를 입력해 주세요"> </td>
			</tr>
			<tr>
				<!-- <td> 암호 </td> -->
				<td colspan="2"> <input type="password" name="pass" id="pass"
				placeholder="비밀번호를 입력해 주세요"> </td>
			</tr>
			<tr>
				<td colspan="2">
					${message}
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="로그인" onclick="return loginCheck()" id="login"><br>
					<input type="button" value="회원 가입"
					onclick="location.href='BookServlet?command=member_terms_form'" id="join">
				</td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>