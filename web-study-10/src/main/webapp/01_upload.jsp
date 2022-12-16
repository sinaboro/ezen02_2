<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="upload.do" method="post" enctype="multipart/form-data">
		
		글쓴이 : <input type="text" name="name"><br>
		제목 : <input type="text" name="title"><br>
		파일 지정하기 : <input type="file" name="uploadFile"><br>
		<input type = "submit" value="send">
	</form>
	
</body>
</html>