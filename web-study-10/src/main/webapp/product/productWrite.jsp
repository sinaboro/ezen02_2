<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/shopping.css">
<script type="text/javascript" src="script/product.js"></script>
</head>
<body>
	<div id="wrap" align="center">
	<h1>상품 등록 - 관리자 페이지</h1>
	<form  enctype="multipart/form-data" name="frm" method="post">
		<table>
			<tr>
				<th>상품명</th>
				<td><input type="text" name="name" size="80"></td>
			</tr>
			<tr>
				<th>가 격</th>
				<td><input type="text" name="price">원</td>
			</tr>
			<tr>
				<th>사 진</th>
				<td>
					<input type="file" name="pictureUrl"><br>
					(주의사항:이미지를 변경하고자 할때만 선택하시오)
				</td>
			</tr>
			<tr>
				<th>설 명</th>
				<td><textarea rows="10" cols="80" name="decription">
				</textarea> </td>
			</tr>
		</table>
		<br>
		<input type="submit" value="등록">
		<input type="reset" value="다시등록">
		<input type="button" value="목록">
	</form>	
	</div>
</body>
</html>