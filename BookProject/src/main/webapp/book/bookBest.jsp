<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book45 베스트</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" />
<link rel="stylesheet" type="text/css" href="css/best.css">
<link rel="stylesheet" href="css/common.css">
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
        <h2>베스트셀러</h2>
        	<table class="list">
			<%-- <c:forEach var="book" items="${booklist}"> --%>
				<tr class="record">
					<td>1</td>
					<td>
						<a href="BookServlet?command=book_detail&num=8">
							<img alt="" 
							src="http://image.yes24.com/goods/99308021/XL" id="cover">
						</a>
					</td>
					<td><b>카테고리</b> &nbsp; 소설/시/희곡<br>
						<b>제목</b> &nbsp; 
						<a href="BookServlet?command=book_detail&num=8">
							불편한 편의점
						</a>
						<br>
						<b>작가</b> &nbsp; 김호연 저<br>
						<b>출판사</b> &nbsp; 나무옆의자<br>
						<b>가격</b> &nbsp; 12,600원<br>
						<b>줄거리</b> <br>
						불편한데 자꾸 가고 싶은 편의점이 있다! 힘들게 살아낸 오늘을 위로하는 편의점의 밤 정체불명의 알바로부터 
						시작된 웃음과 감동의 나비효과 『망원동 브라더스』 김호연의 '동네 이야기' 시즌 2 2013년 세계문학상 우수상 수상작 
						『망원동 브라더스』로 데뷔한 후 일상적 현실을 위트 있게 그린 경쾌한 작품과 ...
					</td>
				</tr>
				<tr class="record">
					<td>2</td>
					<td>
						<img alt="" 
						src="http://image.yes24.com/momo/TopCate712/MidCate003/71122359.jpg" id="cover">
					</td>
					<td><b>카테고리</b> &nbsp; 자기계발<br>
						<b>제목</b> &nbsp; 
						<a href="BookServlet?command=book_detail&num=17">
							사람을 얻는 지혜
						</a>
						<br>
						<b>작가</b> &nbsp; 발타자르 그라시안 저/임정재 역<br>
						<b>출판사</b> &nbsp; 타커스<br>
						<b>가격</b> &nbsp; 12,420원<br>
						<b>줄거리</b> <br>
						누구에게도 적이 되지 않는 가장 현실적 조언 사람 때문에 힘들고 인간관계에 지친 당신을 위
						한 책! 이기적이고 불완전한 세상에서 어떻게 어울려 살 것인가? 
						지혜의 대가 발타자르 그라시안의 빛나는 통찰과 조언 세상에는 인생과 
						인간관계에 대한 다양한 조언이 넘쳐난다. 하지만 현실에 바탕을 두지 않은 조언은...
					</td>
				</tr>
				<tr class="record">
					<td>3</td>
					<td>
						<img alt="" 
						src="http://image.yes24.com/goods/97255028/XL" id="cover">
					</td>
					<td><b>카테고리</b> &nbsp; 어린이<br>
						<b>제목</b> &nbsp; 
						<a href="BookServlet?command=book_detail&num=32">
							긴긴밤
						</a>
						<br>
						<b>작가</b> &nbsp; 루리 글그림<br>
						<b>출판사</b> &nbsp; 문학동네<br>
						<b>가격</b> &nbsp; 10,350원<br>
						<b>줄거리</b> <br>
						제21회 문학동네어린이문학상 대상 수상작 『긴긴밤』 세상에 마지막 하나 남은 
						흰바위코뿔소와 코뿔소 품에서 태어난 어린 펭귄. 그땐 기적인 줄 몰랐다, 머리부터 발끝까지 모든 
						것이 다른 우리에게 서로밖에 없다는 게. 세상에 마지막 하나 남은 코뿔소가 된다면, 소중한 이를 다 잃고도 
						'마지막 하나 남은 존재...
					</td>
				</tr>
				<tr class="record">
					<td>4</td>
					<td>
						<img alt="" 
						src="http://image.yes24.com/goods/9349031/XL" id="cover">
					</td>
					<td><b>카테고리</b> &nbsp; 자기계발<br>
						<b>제목</b> &nbsp; 
						<a href="BookServlet?command=book_detail&num=19">
							원씽 THE ONE THING
						</a>
						<br>
						<b>작가</b> &nbsp; 게리 켈러, 제이 파파산 저/구세희 역<br>
						<b>출판사</b> &nbsp; 비즈니스북스<br>
						<b>가격</b> &nbsp; 12,600원<br>
						<b>줄거리</b> <br>
						아마존 종합 베스트셀러 1위! 아마존 자기계발 분야 260주 연속 스테디셀러! 「월스트리트 저널」 
						종합 베스트셀러 1위! 「뉴욕 타임스」「USA 투데이」「워싱턴 포스트」 베스트셀러! 전 세계 독자들이 
						주목한 최고의 책! 20만 부 판매 기념 리커버 특별한정판! 인생의 반전을 불러오는 단순함의 힘 당신의 삶을 ...
					</td>
				</tr>
				<tr class="record">
					<td>5</td>
					<td>
						<img alt="" 
						src="http://image.yes24.com/goods/105526047/XL" id="cover">
					</td>
					<td><b>카테고리</b> &nbsp; 자연과학<br>
						<b>제목</b> &nbsp; 
						<a href="BookServlet?command=book_detail&num=37">
							물고기는 존재하지 않는다
						</a>
						<br>
						<b>작가</b> &nbsp; 룰루 밀러 저/정지인 역<br>
						<b>출판사</b> &nbsp; 곰출판<br>
						<b>가격</b> &nbsp; 15,300원<br>
						<b>줄거리</b> <br>
						'방송계의 퓰리처상' 피버디상 수상자 룰루 밀러의 사랑과 혼돈, 과학적 집착에 관한 경이롭고도 
						충격적인 데뷔작! '방송계의 퓰리처상'으로 불리는 피버디상(Peabody Awards)을 수상한 과학 
						전문기자 룰루 밀러의 경이로운 논픽션 《삶과 우주의 혼돈과 질서에 대한 이야기》는 여러 언론 매체에서 
						'2020년 최고...
					</td>
				</tr>
				<tr class="record">
					<td>6</td>
					<td>
						<img alt="" 
						src="http://image.yes24.com/goods/96794060/XL" id="cover">
					</td>
					<td><b>카테고리</b> &nbsp; 자기계발<br>
						<b>제목</b> &nbsp; 
						<a href="BookServlet?command=book_detail&num=55">
							데일 카네기 자기관리론
						</a>
						<br>
						<b>작가</b> &nbsp; 데일 카네기 저/임상훈 역<br>
						<b>출판사</b> &nbsp; 현대지성<br>
						<b>가격</b> &nbsp; 10,350원<br>
						<b>줄거리</b> <br>
						『인간관계론』과 짝을 이루는 데일 카네기 최고의 역작 걱정이 내 인생을 망치기 전에 반드시 읽어야 
						할 책! 워런 버핏이 직접 적용한, 걱정 없는 인생의 핵심 원리 세계 최초의 '걱정 극복 실험실'에서 
						탄생한 마법의 공식 수록! 현대지성에서는 출간 즉시 베스트셀러가 된 『데일 카네기 인간관계론』에 이어...
					</td>
				</tr>
				<tr class="record">
					<td>7</td>
					<td>
						<img alt="" 
						src="http://image.yes24.com/goods/104692009/XL" id="cover">
					</td>
					<td><b>카테고리</b> &nbsp; 인문<br>
						<b>제목</b> &nbsp; 
						<a href="BookServlet?command=book_detail&num=68">
							이어령의 마지막 수업
						</a>
						<br>
						<b>작가</b> &nbsp; 김지수, 이어령 저<br>
						<b>출판사</b> &nbsp; 열림원<br>
						<b>가격</b> &nbsp; 14,850원<br>
						<b>줄거리</b> <br>
						시대의 지성 이어령과 '인터스텔라' 김지수의 '라스트 인터뷰' 삶과 죽음에 대한 마지막 인생 수업 
						이 시대의 대표지성 이어령이 마지막으로 들려주는 삶과 죽음에 대한 가장 지혜로운 이야기가 담긴 책이다.
						 오랜 암 투병으로 죽음을 옆에 둔 스승은 사랑, 용서, 종교, 과학 등 다양한 주제를 넘나들며, 우리에게 ...
					</td>
				</tr>
				<tr class="record">
					<td>8</td>
					<td>
						<img alt="" 
						src="http://image.yes24.com/goods/23030284/XL" id="cover">
					</td>
					<td><b>카테고리</b> &nbsp; 인문<br>
						<b>제목</b> &nbsp; 
						<a href="BookServlet?command=book_detail&num=78">
							사피엔스
						</a>
						<br>
						<b>작가</b> &nbsp; 유발 하라리 저/조현욱 역/이태수 감수<br>
						<b>출판사</b> &nbsp; 김영사<br>
						<b>가격</b> &nbsp; 19,800원<br>
						<b>줄거리</b> <br>
						변방의 유인원 호모 사피엔스는 어떻게 세상의 지배자가 되었는가? 과학은 모든 종교의 미래인가? 
						인간의 유효기간은 언제까지인가? 멀고먼 인류의 시원부터 인지혁명, 농업혁명, 과학혁명을 거쳐 끊임없이 
						진화해온 인간의 역사를 다양하고 생생한 시각으로 조명한 전인미답의 문제작. 호모 사피엔스부터 인공지능까지, 역...
					</td>
				</tr>
				<tr class="record">
					<td>9</td>
					<td>
						<img alt="" 
						src="http://image.yes24.com/goods/2312211/XL" id="cover">
					</td>
					<td><b>카테고리</b> &nbsp; 자연과학<br>
						<b>제목</b> &nbsp; 
						<a href="BookServlet?command=book_detail&num=86">
							코스모스
						</a>
						<br>
						<b>작가</b> &nbsp; 칼 에드워드 세이건 저/홍승수 역<br>
						<b>출판사</b> &nbsp; 사이언스북스<br>
						<b>가격</b> &nbsp; 17,910원<br>
						<b>줄거리</b> <br>
						전 세계 60개국에 방송되어 6억 시청자를 감동시킨 텔레비전 교양 프로그램을 책으로 옮긴 칼 
						세이건(Carl Sagan)의 『코스모스(Cosmos)』. 현대 천문학을 대표하는 저명한 과학자인 칼 세이건은 
						이 책에서 사람들의 상상력을 사로잡고, 난해한 개념을 명쾌하게 해설하는 놀라운 능력을 마음껏 발휘한다. 
						그는 에라토스테네...
					</td>
				</tr>
				<tr class="record">
					<td>10</td>
					<td>
						<img alt="" 
						src="http://image.yes24.com/goods/65067259/XL" id="cover">
					</td>
					<td><b>카테고리</b> &nbsp; 자연과학<br>
						<b>제목</b> &nbsp; 
						<a href="BookServlet?command=book_detail&num=98">
							이기적 유전자 The Selfish Gene
						</a>
						<br>
						<b>작가</b> &nbsp; 리처드 도킨스 저/홍영남, 이상임 역<br>
						<b>출판사</b> &nbsp; 을유문화사<br>
						<b>가격</b> &nbsp; 18,000원<br>
						<b>줄거리</b> <br>
						『이기적 유전자』는 처음 출간되었을 당시 과학계와 일반 대중들에게 폭발적인 반향을 불러일으키며 
						세기의 문제작으로 떠올랐다. 혁신적인 통찰에 더해 사람의 마음을 휘어잡는 뛰어난 문장력과 명쾌한 구성력 또한 
						보여 주는 이 책은 명실상부 과학 교양서의 바이블로 일컬어지기에 손색이 없다. 또 최재천 이화여대 석...
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
            <!-- <div id="foot2">
            	<p>경기도 수원시 매산로1가 11-9</p>
                <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d662.6889364947248!2d126.99987109621723!3d37.2680971866107!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357b431e8d19c277%3A0xceb17aba7af9e33d!2z7J207KCg7Lu07ZOo7YSw7JWE7Yq47ZWZ7JuQ!5e0!3m2!1sko!2skr!4v1672026021259!5m2!1sko!2skr"
                 width="100%" height="230" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
            </div> -->
        </footer>
	</div>
</body>
</html>