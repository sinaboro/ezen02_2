<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book45 신간</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" />
<link rel="stylesheet" type="text/css" href="css/new.css">
<link rel="stylesheet" href="css/common.css">
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
        <div id="section">
        <h2>신간 도서</h2>
        	<table class="list">
			<%-- <c:forEach var="book" items="${booklist}"> --%>
				<tr class="record">
					<td>1</td>
					<td>
						<a href="BookServlet?command=book_detail&num=1">
						<img alt="" 
						src="http://image.yes24.com/goods/113416767/XL" id="cover">
						</a>
					</td>
					<td><b>카테고리</b> &nbsp; 경제 경영<br>
						<b>제목</b> &nbsp; 
						<a href="BookServlet?command=book_detail&num=1">
							트렌드 코리아 2023
						</a>
						<br>
						<b>작가</b> &nbsp; 김난도, 전미영, 최지혜, 이수진, 권정윤 저 외 5명<br>
						<b>출판사</b> &nbsp; 미래의창<br>
						<b>가격</b> &nbsp; 17,100원<br>
						<b>줄거리</b> <br>
						침체와 불황을 넘어 더 높이 뛰어오를 토끼의 해 2023, 남다른 치열함과 기민함으로 새롭게 무장하라 
						2년이 넘는 시간 동안 지속된 코로나19 사태를 거치면서 우리의 삶은 큰 변화를 맞이했다. 2022년 하반기에 
						이르러 사회적 거리두기가 해제되면서 한산했던 거리가 조금씩 활기를 띠기 시작했고 그곳을 오가는 사람들...
					</td>
				</tr>
				<tr class="record">
					<td>2</td>
					<td>
						<a href="BookServlet?command=book_detail&num=7">
						<img alt="" 
						src="http://image.yes24.com/goods/113789375/XL" id="cover">
						</a>
					</td>
					<td><b>카테고리</b> &nbsp; 가정 살림<br>
						<b>제목</b> &nbsp; 
						<a href="BookServlet?command=book_detail&num=7">
							올리버쌤의 미국식 아이 영어 습관 365
						</a>
						<br>
						<b>작가</b> &nbsp; 올리버 샨 그랜트 저/정다운 그림<br>
						<b>출판사</b> &nbsp; 브라이트<br>
						<b>가격</b> &nbsp; 20,700원<br>
						<b>줄거리</b> <br>
						"미국 엄마, 아빠가 아이에게 매일 말해주는 필수 영어 표현 365" 209만 구독자 국민 영어 채널 
						'올리버쌤'의 아이를 위한 진짜 미국식 영어 습관! 일상생활에서 자연스럽게 영어를 알려주며 209만 
						구독자에게 사랑받는 올리버쌤이 아이를 위한 일력을 출간했다. 매일 한 장씩 아이와 함께 넘겨 보며 영어 자신...
					</td>
				</tr>
				<tr class="record">
					<td>3</td>
					<td>
						<a href="BookServlet?command=book_detail&num=24">
						<img alt="" 
						src="http://image.yes24.com/goods/114336082/XL" id="cover">
						</a>
					</td>
					<td><b>카테고리</b> &nbsp; 예술<br>
						<b>제목</b> &nbsp; 
						<a href="BookServlet?command=book_detail&num=24">
							헤어질 결심 스토리보드북
						</a>
						<br>
						<b>작가</b> &nbsp; 이윤호 그림/박찬욱 감독<br>
						<b>출판사</b> &nbsp; 을유문화사<br>
						<b>가격</b> &nbsp; 29,700원<br>
						<b>줄거리</b> <br>
						많은 관객의 마음속에 긴 여운을 남긴 영화 [헤어질 결심]을 수놓은 섬세한 디테일을 만나다 영화 
						[헤어질 결심]은 박해일과 탕웨이를 비롯한 배우들의 열연은 물론, 인상적인 대사와 꼼꼼한 디테일로
						 관객들을 사로잡았다. 그리고 이는 각본에 관한 관심으로 이어지면서 영화 각본 사상 종합 베스트셀러 
						 1위에 가장 오...
					</td>
				</tr>
				<tr class="record">
					<td>4</td>
					<td>
						<a href="BookServlet?command=book_detail&num=43">
						<img alt="" 
						src="http://image.yes24.com/goods/114273352/XL" id="cover">
						</a>
					</td>
					<td><b>카테고리</b> &nbsp; 소설/시/희곡<br>
						<b>제목</b> &nbsp; 
						<a href="BookServlet?command=book_detail&num=43">
							가녀장의 시대
						</a>
						<br>
						<b>작가</b> &nbsp; 이슬아 저<br>
						<b>출판사</b> &nbsp; 이야기장수<br>
						<b>가격</b> &nbsp; 13,500원<br>
						<b>줄거리</b> <br>
						"바야흐로 가녀장의 시대가 시작되었다." 가녀장家女長, 생계를 책임지며 세계를 뒤집어엎는 딸들의 
						이름 [일간 이슬아] 이슬아 첫 장편소설 매일 한 편씩 이메일로 독자들에게 글을 보내는 [일간 이슬아]로 
						그 어떤 등단 절차나 시스템의 승인 없이도 독자와 직거래를 트며 우리 시대의 대표 에세이스트로 자리잡...
					</td>
				</tr>
				<tr class="record">
					<td>5</td>
					<td>
						<a href="BookServlet?command=book_detail&num=61">
						<img alt="" 
						src="http://image.yes24.com/goods/114848694/XL" id="cover">
						</a>
					</td>
					<td><b>카테고리</b> &nbsp; 에세이<br>
						<b>제목</b> &nbsp; 
						<a href="BookServlet?command=book_detail&num=61">
							인생의 역사
						</a>
						<br>
						<b>작가</b> &nbsp; 신형철 저<br>
						<b>출판사</b> &nbsp; 난다<br>
						<b>가격</b> &nbsp; 16,200원<br>
						<b>줄거리</b> <br>
						"나는 인생의 육성이라는 게 있다면 그게 곧 시라고 믿고 있다." 4년 만에 선보이는 평론가 신형철의 
						신작 우리 문학을 향한 '정확한 사랑'이자 시대를 읽는 탁월한 문장, 평론가 신형철이 4년 만의 신작으로 
						돌아왔다. 다섯번째 책이자 처음으로 선보이는 '시화(詩話)'임에 그 제목을 『인생의 역사』라 달았다...
					</td>
				</tr>
				<tr class="record">
					<td>6</td>
					<td>
						<a href="BookServlet?command=book_detail&num=83">
						<img alt="" 
						src="http://image.yes24.com/goods/114951396/XL" id="cover">
						</a>
					</td>
					<td><b>카테고리</b> &nbsp; 경제 경영<br>
						<b>제목</b> &nbsp; 
						<a href="BookServlet?command=book_detail&num=83">
							나의 월급 독립 프로젝트 (리마스터 에디션)
						</a>
						<br>
						<b>작가</b> &nbsp; 유목민 저<br>
						<b>출판사</b> &nbsp; 리더스북<br>
						<b>가격</b> &nbsp; 17,820원<br>
						<b>줄거리</b> <br>
						"이 땅의 월급 노예들에게 단타를 권한다!" 초보 개미들이 열광한 새로운 관점의 투자 입문서! 
						『나의 월급 독립 프로젝트』 10만 부 기념 개정증보판 출간 * 본격 차트 스터디 '주린이도 차트를 읽고 싶다' 
						신규 수록 3년 만에 30억 벌고 퇴사한 단타 투자자의 생생한 경험담을 풀어내 출간 즉시 베스트셀러에...
					</td>
				</tr>
				<tr class="record">
					<td>7</td>
					<td>
						<a href="BookServlet?command=book_detail&num=88">
						<img alt="" 
						src="http://image.yes24.com/goods/113751739/XL" id="cover">
						</a>
					</td>
					<td><b>카테고리</b> &nbsp; 자기계발<br>
						<b>제목</b> &nbsp; 
						<a href="BookServlet?command=book_detail&num=88">
							데이터는 어떻게 인생의 무기가 되는가
						</a>
						<br>
						<b>작가</b> &nbsp; 세스 스티븐스 다비도위츠 저/안진이 역<br>
						<b>출판사</b> &nbsp; 더퀘스트<br>
						<b>가격</b> &nbsp; 16,920원<br>
						<b>줄거리</b> <br>
						"당신은 더 나은 결정을 할 수 있다" 이 책은 우리가 삶의 주요 결정을 내리는 방식을 바꿀 것이다 
						중요하고 큰 결정은 늘 어렵다. 우리는 친구나 가족과 의논하고, 온라인에서 '전문가'의 헷갈리는 조언들을 
						찾아보고, 지침을 얻고자 자기계발서를 읽어본다. 그러다가 결국에는 그냥 '적절하다고 느껴지는' 쪽을...
					</td>
				</tr>
				<tr class="record">
					<td>8</td>
					<td>
						<a href="BookServlet?command=book_detail&num=94">
						<img alt="" 
						src="http://image.yes24.com/goods/114857322/XL" id="cover">
						</a>
					</td>
					<td><b>카테고리</b> &nbsp; 에세이<br>
						<b>제목</b> &nbsp; 
						<a href="BookServlet?command=book_detail&num=94">
							망그러진 만화
						</a>
						<br>
						<b>작가</b> &nbsp; 유랑 저<br>
						<b>출판사</b> &nbsp; 좋은생각<br>
						<b>가격</b> &nbsp; 15,120원<br>
						<b>줄거리</b> <br>
						카카오 이모티콘 다운로드 1위 인기 캐릭터 '망그러진 곰'과 '망그러진 햄터'의 귀염뽀짝 즐거운 
						일상! ★★★★ 미공개 에피소드 수록! ★★★★ '이모티콘 캐릭터 장인' 유랑 작가의 웹툰 '망그러진 만화'가
						 단행본으로 출간됐다. 카카오 이모티콘 인기 캐릭터인 '망그러진 곰'과 '망그러진 햄터'의 ...
					</td>
				</tr>
				<tr class="record">
					<td>9</td>
					<td>
						<a href="BookServlet?command=book_detail&num=133">
						<img alt="" 
						src="http://image.yes24.com/goods/114648022/XL" id="cover">
						</a>
					</td>
					<td><b>카테고리</b> &nbsp; 에세이<br>
						<b>제목</b> &nbsp; 
						<a href="BookServlet?command=book_detail&num=133">
							사랑은 그렇게 하는 것이 아니다
						</a>
						<br>
						<b>작가</b> &nbsp; 김달 저<br>
						<b>출판사</b> &nbsp; 빅피시<br>
						<b>가격</b> &nbsp; 14,850원<br>
						<b>줄거리</b> <br>
						"지금 만나는 사람이 나의 내일을 바꾼다!" 관계의 모든 순간, 반드시 기억해야 할 것들 이미 세 권의 
						책을 베스트셀러로 만든 작가이자, 크리에이터로 다양한 매체에서 활동하고 있는 김달 작가가 이번에는 약 
						7년간 수십만 명의 사람과 함께한 상담 중에 가장 많은 이가 고민했던 문제들만 골라내 이 책에 담아냈다...
					</td>
				</tr>
				<tr class="record">
					<td>10</td>
					<td>
						<a href="BookServlet?command=book_detail&num=141">
						<img alt="" 
						src="http://image.yes24.com/goods/115053942/XL" id="cover">
						</a>
					</td>
					<td><b>카테고리</b> &nbsp; 에세이<br>
						<b>제목</b> &nbsp; 
						<a href="BookServlet?command=book_detail&num=141">
							무뎌진 감정이 말을 걸어올 때
						</a>
						<br>
						<b>작가</b> &nbsp; 김소영 저<br>
						<b>출판사</b> &nbsp; 책발전소X테라코타<br>
						<b>가격</b> &nbsp; 14,220원<br>
						<b>줄거리</b> <br>
						MBC 아나운서를 그만둔 후 '당인리책발전소' 서점 주인으로, 그리고 방송인으로 활동하며 새로운 인생의 
						방향을 찾은 김소영. 책과 문장의 힘을 믿는 그는 일이 잘 풀리지 않을 때 언제나 책이 곁에서 말을 걸어준 
						덕분에 버틸 수 있었다고 한다. 그런데 어느 순간 책과 데면데면해지면서 책 속 문장들을 통해 자신의 감...
					</td>
				</tr>
			<%-- </c:forEach> --%>
			</table>
        </div>
        <footer>
            <div id="foot1">
                <!-- <h1 id="flogo">
                    <a href="BookServlet?command=book_main">
                        <img src="images/4OJUNG logo2-2.png" alt="LOGO"
                        width="100%" height="100%">
                    </a>
                </h1> -->
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
</body>
</html>