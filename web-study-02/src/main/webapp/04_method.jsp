<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="get" action="Method">
		이름 : <input type="text" name = "name" >
		나이 : <input type="text" name = "age" >
		<input type="submit" value="get방식으로 전송">
	</form>
	
	<br><br>
	<form method="post" action="Method">
		이름 : <input type="text" name = "name" >
		나이 : <input type="text" name = "age" >
		<input type="submit" value="post방식으로 전송">
	</form>
</body>
</html>