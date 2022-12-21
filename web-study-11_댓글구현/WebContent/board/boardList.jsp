<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


<link rel="stylesheet" type="text/css" href="css/shopping.css">
</head>
<body>
	<div id="wrap" align="center">
		<h1>게시글 리스트</h1>
		<table class="list">
			<tr>
				<td colspan="5" style="border: white; text-align: right"><a
					href="BoardServlet?command=board_write_form">게시글 등록</a></td>
			</tr>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회</th>
			</tr>
			<c:forEach var="board" items="${boardList }">
				<tr class="record">
					<td>${board.num }</td> 
					<c:if test="${board.blevel == 0 }">
						<td><a href="BoardServlet?command=board_view&num=${board.num}">
								${board.title } </a></td>
						<td>${board.name}</td>
						<td><fmt:formatDate value="${board.writedate }" /></td>
						<td>${board.readcount}</td>
					</c:if>
					
				 <!-- 	<c:if test="${vo.blevel>0}">
		              <c:forEach begin="1" end="${vo.blevel}">
		                 <span style="padding-left: 10px"></span>
		              </c:forEach>            
            		</c:if>  -->
            		
					<c:if test="${board.blevel >0 }">
						<td><a href="BoardServlet?command=board_view&num=${board.num}">
						<c:forEach begin="1" end="${board.blevel}">
							<span style="padding-left: 15px">
							</span>
						</c:forEach> 
								[RE]${board.title }
						</a></td>
						<td>${board.name}</td>
						<td><fmt:formatDate value="${board.writedate }" /></td>
						<td>${board.readcount}</td>
					</c:if>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>