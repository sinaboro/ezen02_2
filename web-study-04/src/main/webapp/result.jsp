<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int end = Integer.parseInt(request.getParameter("val"));
	int sum=0;
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>1부터 <%=end %>까지 자연수 합 구하기</h2>
	<%
		for(int i=1; i<=end; i++){
			sum +=i;
			/*if(i < end)
				out.print( i + "+" );
			else
				out.print( i + " = "); */
			out.print( i + (i < end ? "+" : "=") );
		}
	%>
	<%=sum %>
</body>
</html>