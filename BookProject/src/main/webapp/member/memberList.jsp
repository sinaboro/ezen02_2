<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<% 
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" />
<link rel="stylesheet" type="text/css" href="css/memberList.css">
<link rel="stylesheet" type="text/css" href="css/common.css">
<script type="text/javascript" src="script/member.js"></script>
</head>
<body>
<div id="container">
      <header>
		<div id="header">
			<div id="log">
				<ul>
					<c:choose>
						<c:when test="${empty member}">
							<li><a href="BookServlet?command=member_login_form">로그인</a></li>
							<li>&#124;</li>
							<li><a href="BookServlet?command=member_terms_form">회원가입</a></li>
							<li>&#124;</li>
							<li><a href="BookServlet?command=member_mypage"
								onclick="return check()">마이페이지</a></li>
						</c:when>
						<c:otherwise>
							<li id="hello">안녕하세요, ${member.name}님</li>
							<li>&#124;</li>
							<li><a href="BookServlet?command=member_logout"
								onclick="return logout()">로그아웃</a></li>
							<li>&#124;</li>
							<c:if test="${member.lev == 'A'}">
								<li><a href="BookServlet?command=member_mypage"
									onclick="location.href='BookServlet?command=member_mypage">마이페이지</a>
								</li>
								<li>&#124;</li>
								<li><a href="BookServlet?command=member_list"
									onclick="buttonClick()">관리자 페이지</a></li>
							</c:if>
							
							<c:if test="${member.lev == 'B'}">
								<li><a href="BookServlet?command=member_mypage"
									onclick="location.href='BookServlet?command=member_mypage&id=${param.id}'">마이페이지</a>
								</li>
							</c:if>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
			<div id="headnav">
				<h1 id="hlogo">
					<a href="BookServlet?command=book_main"> <img
						src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FCdrYl%2FbtrUTKBvWql%2FneUhG0VH9Jro8xRV8EGl61%2Fimg.png"
						alt="LOGO" width="230px" height="70px">
					</a>
				</h1>
				<div class="search">
					<!-- <select name="" id="hoption">
                        <option value="제목검색">제목검색</option>
                        <option value="작가검색">작가검색</option>
                        <option value="카테고리검색">카테고리검색</option>
                    </select>
                    &#124;
                    <input type="text" id="hsearch" value="검색할 내용을 입력해주세요">
                    <i class="fa-solid fa-magnifying-glass" id="searchbu"
                    onclick="return searchCheck()"></i> -->

					<form action="BookServlet" method="post" name="frm2">
						<input type="hidden" name="command" value="book_search"> <select
							name="searchCategory" id="hoption">
							<option value="title">제목</option>
							<option value="author">작가</option>
							<option value="pub">출판사</option>
						</select> &#124; <input type="text" name="keyWord" id="hsearch"
							placeholder="검색할 내용을 입력해 주세요">
						<button onclick="return searchCheck()">
							<i class="fa-solid fa-magnifying-glass" id="searchbu"></i>
						</button>
					</form>
				</div>
				<!-- <div class="mypage">
                    <a href="#">
                    	<i class="fa-solid fa-cart-shopping"></i>
                    </a>
                    <a href="MemberServlet?command=member_mypage">
                    	<i class="fa-solid fa-circle-user"></i>
                    </a>
                </div> -->
			</div>
			<nav>
				<ul class="hlist1">
					<li><a href="BookServlet?command=book_list">도서 전체</a></li>
					<li>&middot;</li>
					<!-- <li><a href="#">카테고리</a></li>
	                <li>·</li> -->
					<li><a href="BookServlet?command=book_best">베스트</a></li>
					<li>&middot;</li>
					<li><a href="BookServlet?command=book_new">신간</a></li>
					<!-- <li><a href="#">PICKS</a></li>
	                <li><a href="#">CASTing</a></li>
	                <li><a href="#">교보ONLY</a></li> -->
				</ul>
				<%-- <c:if test="${member.lev == 'A'}"> --%>
	            <ul class="hlist2">
	                <li><a href="BookServlet?command=notice_list">공지사항</a></li>
	                <!-- <li><a href="#">출석체크</a></li>
	                <li><a href="#">
	                    <i class="fa-solid fa-circle-plus"></i>
	                </a></li> -->
	            </ul>
	            <%-- </c:if> --%>
			</nav>
		</div>
	</header>
	<div id="down">
	<form action="BookServlet" method="post" name="frm">
	<!-- <input type="hidden" name="command" value="member_delete"> -->
	<%-- <input type="hidden" name="id" value="${param.id}"> --%>
	<div id="wrap" align="center">
		<h2 align="center"> 회원 목록 </h2>
      <table class="list" align="center">
         <tr>
            <th>아이디</th> <th>이름</th> <th>전화번호</th> <th>이메일</th> <th>등급</th> <th>수정</th> <th>삭제</th>
         </tr>
         <c:forEach var="member" items="${memberList}">
            <tr class="record">
               <td> ${member.id} </td>
               <td> 
                  <%-- <a href="BookServlet?command=member_info_form&id=${member.id}"> --%>
                        ${member.name}
                  <!-- </a> -->
               </td>
               <td> ${member.phone} </td>
               <td> ${member.email} </td>
               <td> ${member.lev} </td>
               <td><input type="button" value="수정" id="btn" onclick="location.href='BookServlet?command=member_info_form&id=${member.id}'"></td>
               <td><input type="button" value="삭제" id="btn" onclick="location.href='BookServlet?command=member_delete&id=${member.id}'"></td>
               
            </tr>
            
         </c:forEach>
      </table>
   </div>
</form>
 <footer>
            <div id="foot1">
                <div id="foot1-1">
                    <ul>
                        <li><a href="#">회사소개 </a></li>
                        <li>&#124;</li>
                        <li><a href="#">이용약관 </a></li>
                        <li>&#124;</li>
                        <li><a href="#"><b>개인정보처리방침 </b></a></li>
                        <li>&#124;</li>
                        <li><a href="#">청소년보호정책 </a></li>
                        <li>&#124;</li>
                        <li><a href="#">대량주문안내 </a></li>
                        <li>&#124;</li>
                        <li><a href="#">헙력사 </a></li>
                        <li>&#124;</li>
                        <li><a href="#">채용정보 </a></li>
                        <li>&#124;</li>
                        <li><a href="#">광고소개</a></li>
                    </ul>
                </div>
                <div id="foot1-2">
                    <p>대표이사 : 임채리 &#124; 주소 : (16455)경기도 수원시 팔달구 매산로1가 11-9 3F &#124; 사업자등록번호 : 000-00-00000</p>
                    <p>대표전화 : 1544-0000(발신자 부담전화) &#124; FAX : 0000-000-0000(지역번호 공통) &#124; 경기도 통신판매업신고번호 : 제 000호&nbsp;&nbsp;<button>사업자정보확인</button></p>
                    <p>&#169; SAO BOOK CENTRE</p>
                </div>
            </div>
        </footer>
    </div>
</div>
<script type="text/javascript">
function deleteCheck2() {
	var flag = confirm("삭제하시겠습니까?");
	if (flag) location.href = "BookServlet?command=member_delete";
}
</script>
</body>
</html>