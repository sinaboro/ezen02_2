<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/shopping.css">
</head>
<body>
<div id="wrap" align="center">
<h1>상품 수정 - 관리자 페이지</h1>
<form  enctype="multipart/form-data" name="frm" method="post">
	<table>
		<tr>
			<td>
				<c:choose>
					<c:when test="${empty product.pictureUrl}">
						<img src="upload/noimage.gif">;
					</c:when>
					<c:otherwise>
						<img src="upload/${product.pictureUrl}">
					</c:otherwise>
				</c:choose>
			</td>
		
			<td>
				<table>
					<tr>
						<th style="width:80px">상품명</th>
						<td><input type="text" name="name" value="${product.name}" size="80"></td>
					</tr>
					<tr>
						<th >가격</th>
						<td><input type="text" name="price" value="${product.price}">원</td>
					</tr>
					<tr>
						<th >사진</th>
						<td><input type="file" name="pictureUrl"><br>
							(주의사항 : 이미지를 변경하고자 할때만 선택하시오)
						</td>
					</tr>
					<tr>
						<th >설명</th>
						<td>
							<textarea rows="10" cols="90" name="description">${product.description}</textarea>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<input type="submit" value="확인">
	<input type="reset" value="다시수정">
	<input type="button" value="목록" onclick="location.href='List'">
</form>
</div>	
</body>
</html>