<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴</title>
</head>
<body>
<script type ="text/javascript">
if(window.name == 'delete') {
	
	window.opener.parent.location.href =
		"BookServlet?command=mypage_delete&id=${member.id}";
}
window.close();
</script>
</body>
</html>