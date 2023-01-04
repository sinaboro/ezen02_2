<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BOOK45</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" />
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/common.css">
<script type="text/javascript" src="script/book.js"></script>
<script type="text/javascript" src="script/member.js"></script>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	session = request.getSession();
	session.getAttribute("login");
%>
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
        <div id="ad">
			
			<div id="adlist">
				<p id="view">카테고리</p>
				<ul id="ullist">
	                <li><a name="국어 외국어 사전" value="국어 외국어 사전" href="BookServlet?command=book_category_viewer&category=001">국어 외국어 사전</a></li>
	                <li><a name="청소년" value="청소년" href="BookServlet?command=book_category_viewer&category=002">청소년</a></li>
	                <li><a name="경제 경영" value="경제 경영" href="BookServlet?command=book_category_viewer&category=003">경제 경영</a></li>
	                <li><a name="가정 살림" value="가정 살림" href="BookServlet?command=book_category_viewer&category=004">가정 살림</a></li>
	                <li><a name="인문" value="인문" href="BookServlet?command=book_category_viewer&category=005">인문</a></li>
	                <li><a name="소설/시/희곡" value="소설/시/희곡" href="BookServlet?command=book_category_viewer&category=006">소설/시/희곡</a></li>
	                <li><a name="에세이" value="에세이" href="BookServlet?command=book_category_viewer&category=007">에세이</a></li>
	                <li><a name="수험서 자격증" value="수험서 자격증" href="BookServlet?command=book_category_viewer&category=008">수험서 자격증</a></li>
	                <li><a name="만화/라이트노벨" value="만화/라이트노벨" href="BookServlet?command=book_category_viewer&category=009">만화/라이트노벨</a></li>
	                <li><a name="종교" value="종교" href="BookServlet?command=book_category_viewer&category=010">종교</a></li>
	                <li><a name="자연과학" value="자연과학" href="BookServlet?command=book_category_viewer&category=011">자연과학</a></li>
	                <li><a name="자기계발" value="자기계발" href="BookServlet?command=book_category_viewer&category=012">자기계발</a></li>
	                <li><a name="예술" value="예술" href="BookServlet?command=book_category_viewer&category=013">예술</a></li>
	                <li><a name="유아" value="유아" href="BookServlet?command=book_category_viewer&category=014">유아</a></li>
	                <li><a name="어린이" value="어린이" href="BookServlet?command=book_category_viewer&category=015">어린이</a></li>
	                <li><a name="사회 정치" value="사회 정치" href="BookServlet?command=book_category_viewer&category=016">사회 정치</a></li>
	                <li><a name="IT 모바일" value="IT 모바일" href="BookServlet?command=book_category_viewer&category=017">IT 모바일</a></li>
            	</ul>
			</div>
            <div id="adimg">
            	<div class="mySlides fade">
				  <!-- <div class="numbertext">1 / 3</div> -->
				  <img src="https://cdn.pixabay.com/photo/2017/08/01/00/40/books-2562331_960_720.jpg" style="width:100%; height: 100%;">
				  <!-- <div class="text">Caption Text</div> -->
				</div>
				
				<div class="mySlides fade">
				  <!-- <div class="numbertext">2 / 3</div> -->
				  <img src="https://cdn.pixabay.com/photo/2019/07/05/06/51/library-4317851_960_720.jpg" style="width:100%; height: 100%;">
				  <!-- <div class="text">Caption Two</div> -->
				</div>
				
				<div class="mySlides fade">
				  <!-- <div class="numbertext">3 / 3</div> -->
				  <img src="https://cdn.pixabay.com/photo/2019/10/06/18/32/books-4530944_960_720.jpg" style="width:100%; height: 100%;">
				  <!-- <div class="text">Caption Three</div> -->
				</div>
            </div>
        </div>
        <section>
			<article id="sec1">
				<h2>오늘의 책</h2>
				<div id="sec1-1">
					<div class="sec1-1book">
						<a href="http://localhost:8081/BookProject/BookServlet?command=book_detail&num=82"><img alt="" src="http://image.yes24.com/goods/69655504/XL" width="100%" height="70%"></a>
						<div class="sec1-1text">
							<p><a href="http://localhost:8081/BookProject/BookServlet?command=book_detail&num=82">아주 작은 습관의 힘</a></p>
							<p>제임스 클리어 저/이한이 역</p>
							<p>12,900원</p>
						</div>
					</div>
					<div class="sec1-1book">
						<a href="http://localhost:8081/BookProject/BookServlet?command=book_detail&num=103"><img alt="" src="http://image.yes24.com/goods/1387488/XL" width="100%" height="70%"></a>
						<div class="sec1-1text">
							<p><a href="http://localhost:8081/BookProject/BookServlet?command=book_detail&num=103">인간실격</a></p>
							<p>다자이 오사무 저</p>
							<p>8,100원</p>
						</div>
					</div>
					<div class="sec1-1book">
						<a href="http://localhost:8081/BookProject/BookServlet?command=book_detail&num=135"><img alt="" src="http://image.yes24.com/goods/112046565/XL" width="100%" height="70%"></a>
						<div class="sec1-1text">
							<p><a href="http://localhost:8081/BookProject/BookServlet?command=book_detail&num=135">부모의 말</a></p>
							<p>김종원 저</p>
							<p>13,620원</p>
						</div>
					</div>
					<div class="sec1-1book">
						<a href="http://localhost:8081/BookProject/BookServlet?command=book_detail&num=142"><img alt="" src="http://image.yes24.com/goods/102687133/XL" width="100%" height="70%"></a>
						<div class="sec1-1text">
							<p><a href="http://localhost:8081/BookProject/BookServlet?command=book_detail&num=142">밝은 밤</a></p>
							<p>최은영 저</p>
							<p>11,550원</p>
						</div>
					</div>
				</div>
			</article>
			<article id="sec2">
				<h2>SAO CHANNEL</h2>
				<div id="youtube">
					<iframe width="100%" height="95%" src="https://www.youtube.com/embed/C7CR0Sruusw" title="YouTube video player" 
            		frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" 
               		allowfullscreen></iframe>
					
				</div>
				<div id="sec2text">
					<h3>2022 소설가 50인이 뽑은<br>올해의 소설 1위</h3>
					<br>
					<img src="https://contents.kyobobook.co.kr/display/bn_273_200_91fdcf4881fb4663b8c1780ef8d8c26f.jpg" width="287px">
					<p>
						'2022 소설가 50인이 뽑은 올해의 소설' 리스트는 소설가 약 90여 명에게 추천을 의뢰해 그 중 답변을 준 50명의 추천 도서를 모아 정리하였다. 
						
					</p>
				</div>
			</article>
        </section>
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
    
    <script>
		let slideIndex = 0;
		showSlides();
		
		function showSlides() {
		  let i;
		  let slides = document.getElementsByClassName("mySlides");
		  for (i = 0; i < slides.length; i++) {
		    slides[i].style.display = "none";  
		  }
		  slideIndex++;
		  if (slideIndex > slides.length) {slideIndex = 1}    
		  slides[slideIndex-1].style.display = "block";  
		  setTimeout(showSlides, 3000); // Change image every 3 seconds
		}
</script>
</body>
</html>