<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
function deleteCheck2() {
	var flag = confirm("삭제하시겠습니까?");
	if (flag) location.href = "BookServlet?command=member_delete&id=${mVo.id}";
}
</script>
</body>
</html>