function bookCheck() {
   if (document.frm.category.value.length == 0) {
	   alert("카테고리를 선택해 주세요.");
	   return false;
   }
   if (document.frm.title.value.length == 0) {
	   alert("도서명을 입력해 주세요.");
	   return false;
   }
   if (document.frm.price.value.length == 0) {
	   alert("가격을 입력해 주세요.");
	   return false;
   }
   if (document.frm.summary.value.length == 0) {
	   alert("줄거리를 입력해 주세요.");
	   return false;
   }
   if (document.frm.author.value.length == 0) {
	   alert("작가를 입력해 주세요.");
	   return false;
   }
   if (document.frm.pub.value.length == 0) {
	   alert("출판사를 입력해 주세요.");
	   return false;
   }
   if (document.frm.grade.value.length == 0) {
	   alert("평점을 입력해 주세요.");
	   return false;
   }
   var flag = confirm("등록하시겠습니까?");
    if (!flag) return false;
    return true;
}

function blankCheck() {
	if (document.frm2.keyWord.value.length == 0) {
		alert("검색어를 입력해 주세요.");
		return false;
	}
	return true;
}

function deleteCheck() {
	var flag = confirm("삭제하시겠습니까?");
	if (flag) {
		alert("삭제되었습니다.");
		return true;
	}
	return false;
}

function updateCheck() {
   if (document.frm.category.value.length == 0) {
	   alert("카테고리를 선택해 주세요.");
	   return false;
   }
   if (document.frm.title.value.length == 0) {
	   alert("도서명을 입력해 주세요.");
	   return false;
   }
   if (document.frm.price.value.length == 0) {
	   alert("가격을 입력해 주세요.");
	   return false;
   }
   if (document.frm.summary.value.length == 0) {
	   alert("줄거리를 입력해 주세요.");
	   return false;
   }
   if (document.frm.author.value.length == 0) {
	   alert("작가를 입력해 주세요.");
	   return false;
   }
   if (document.frm.pub.value.length == 0) {
	   alert("출판사를 입력해 주세요.");
	   return false;
   }
   if (document.frm.grade.value.length == 0) {
	   alert("평점을 입력해 주세요.");
	   return false;
   }
   var flag = confirm("수정하시겠습니까?");
    if (!flag) return false;
    return true;
}