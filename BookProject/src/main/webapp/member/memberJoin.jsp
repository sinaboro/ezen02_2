<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script type="text/javascript" src="script/member.js"></script>
<link rel="stylesheet" type="text/css" href="css/join.css">
</head>
<body>
   <div id="container">
   		<div id="hlogo">
			<h1 id="logo">
				<a href="BookServlet?command=book_main">
					<img alt="LOGO" src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FCdrYl%2FbtrUTKBvWql%2FneUhG0VH9Jro8xRV8EGl61%2Fimg.png" width="70%" height="95%">
				</a>
			</h1>
		</div>
   <form action="BookServlet" method="post" name="frm">
   <input type="hidden" name="command" value="member_join">
   		<h2>회원가입</h2>
   		<div id="joinbox">
   			<p style="margin: 10px 0;">아이디</p>
   			<div id="idbox">
   			<input type="text" name="id" id="idtextbox" placeholder="아이디를 입력해 주세요">
   			<input type="hidden" name="id2">
   			<input type="button" value="중복확인" onclick="return idCheck()" id="overlap">
   			</div>
   			<br>
   			<span>4~20자 이내의 영문(소문자) 및 숫자</span>
   			<br>
   			<p style="margin: 20px 0 10px 0;">비밀번호</p>
   			<input type="password" name="pass" id="textbox" placeholder="비밀번호를 입력해 주세요">
   			<br>
   			<span>8~20자 이내로 영문 대문자, 소문자, 숫자, 특수문자 중 2개 이상 조합</span>
   			<br>
   			<p style="margin: 20px 0 10px 0;">비밀번호 재확인</p>
   			<input type="password" name="pass2" id="textbox" placeholder="비밀번호를 한 번 더 입력해 주세요">
   			<br>
   			<p style="margin: 20px 0 10px 0;">이름</p>
   			<input type="text" name="name" id="textbox" placeholder="이름을 입력해 주세요">
   			<br>
   			<p style="margin: 20px 0 10px 0;">휴대전화</p>
   			<input type="text" name="phone" placeholder="전화번호를 입력해 주세요" id="textbox">
   			<br>
            <p style="margin: 20px 0 10px 0;">이메일</p>
   			<input type="text" name="email" id="textbox" placeholder="이메일을 입력해 주세요">
   			<br>
   			<br><br>
   			<input type="submit" value="가입하기"
   			onclick="return joinCheck()" id="roger">
   			<br>
   			<input type="button" id="reset" value="취소" onclick="location.href='BookServlet?command=book_main'"> 
   		</div>
      <%-- <table>
         <tr>
            <td>아이디</td>
         </tr>
         <tr>
         	<td>
            <input type="text" name="id"  placeholder="4~15자리 영소문자, 숫자">*
            <input type="hidden" name="id2">&nbsp;
            <input type="button" value="중복확인" onclick="return idCheck()">
            </td>
         </tr>
         <tr>
            <td>비밀번호</td>
         </tr>
         <tr>
            <td><input type="password" name="pass">*</td>
         </tr>
         <tr>
            <td>비밀번호 재입력</td>
         </tr>
         <tr>
            <td><input type="password" name="pass2">*</td>
         </tr>
         <tr>
            <td>이름</td>
         </tr>
         <tr>
            <td><input type="text" name="name">*</td>
         </tr>
         <tr>
            <td>필수 전화번호</td>
         <tr>
         <td><input type="text" name="phone" placeholder="010-xxxx-xxxx"></td>
         </tr>
         <tr>
            <td>이메일</td>
         </tr>
         <tr>
            <td><input type="email" name="email"></td>
         </tr>
         <tr>
            <td><input type="hidden" id="webLoginType" name="webLoginType" value="B">
            <!-- A= 관리자 // B = 일반회원 //가입시, 일반회원 권한주기 -->
            
         </tr>
         <tr>
            <td><input type="submit" value="완료" onclick="location.href='BookServlet?command=member_join"></td>
            <!--
            <td><input type="reset" value="다시작성"></td>
            <td><input type="button" value="돌아가기"   onclick="location.href='MemberServlet?command=book_main'"></td>
             -->
         </tr>
         <tr>
            <td colspan="2">${message}</td>
         </tr>
      </table> --%>
   </form>
   </div>
</body>
</html>