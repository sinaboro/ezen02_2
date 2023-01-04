function loginCheck() {
	if(document.frm.id.value.length == 0){
		alert("아이디를 입력해주세요.");
		frm.id.focus();
		return false;
	}
	
	if(document.frm.pass.value == ""){
		alert("암호는 반드시 입력해주세요.");
		frm.pass.focus();
		return false;
	}
	return true;
}

function check() {
	alert("로그인 후 이용 가능합니다.");
	return false;
}

function logout() {
	alert("로그아웃되었습니다.");
	return true;
}

//회원가입 입력값 확인 유효성체크
function joinCheck() {

	if (document.frm.id.value == "") {
			alert("아이디를 입력해주세요.");
			return false;
		}
		
	if (document.frm.id2.value.length == 0) {
		alert("아이디 중복 체크가 필요합니다.");
		return false;
	}

	if (document.frm.pass.value == "") {
		alert("비밀번호를 입력해주세요.");
		return false;
	}

	if (document.frm.pass2.value == "") {
		alert("비밀번호를 확인해주세요.");
		return false;
	}

	if (document.frm.pass.value != document.frm.pass2.value) {
		alert("비밀번호가 일치하지 않습니다.");
		return false;
	}
	
	if (document.frm.name.value == "") {
		alert("이름을 입력해주세요.");
		return false;
	}
	
	if (document.frm.phone.value == "") {
		alert("전화번호를 입력해주세요.");
		return false;
	}
	
	if (document.frm.email.value == "") {
		alert("이메일 주소를 입력해주세요.");
		return false;
	}
	var flag = confirm("가입하시겠습니까?");
    if (!flag) return false;
    return true;
}

function idCheck() {
	// 사용자 아이디가 입력되었는지 확인 루틴 구현
	if (document.frm.id.value == "") {
		alert("사용자 아이디를 입력해주세요.");
		document.frm.id.focus();
		return;
	}
	// 아이디 중복 체크를 위한 페이지는 새로운 창에 출력
	var url = "BookServlet?command=id_check_form&id=" + document.frm.id.value;
	window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200");
}


function idOk(){
	opener.frm.id.value = document.frm.id.value;
	opener.frm.id2.value = document.frm.id.value;
	
	self.close();
}

function userCheck() {
	if(document.frm.name.value.length == 0) {
		alert("이름을 입력해 주세요.");
		return false;
	}
	if(document.frm.pass.value.length == 0){
		alert("암호는 반드시 입력해야 합니다.");
		return false;
	}
	if(document.frm.pass.value != document.frm.pass_check.value){
		alert("암호가 일치하지 않습니다.");
		return false;
	}
	if(document.frm.phone.value.length == 0) {
		alert("전화번호를 입력해 주세요.");
		return false;
	}
	if(document.frm.email.value.length == 0) {
		alert("이메일을 입력해 주세요.");
		return false;
	}
	var flag = confirm("수정하시겠습니까?");
    if (!flag) return false;
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

function termsCheck() {
var flag = document.getElementById('check1');
var flag2 = document.getElementById('check2');
	if (flag.checked == false || flag2.checked == false) {
		alert("이용약관과 개인정보 수집 및 이용에 대한 안내에 모두 동의해 주세요.");
		return false;
	}
	return true;
}

function open_win(url, name) {
	window.open(url, name, "width=500, height=230");
}

function mypagePassCheck(){
	if(document.frm.pass.value.length == 0){
	alert('비밀번호를 입력해 주세요.');
	return false;
	}
	
	if(document.frm.pass.value != document.frm.pass_check.value){
	alert('비밀번호가 일치하지 않습니다.');
	return false;
	}
	
	var flag = confirm("탈퇴하시겠습니까?");
	if (flag) {
		alert("탈퇴가 완료되었습니다.");
		return true;
	}
	return false;
}