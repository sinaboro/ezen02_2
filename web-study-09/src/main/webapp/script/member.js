function idok(){
	opener.frm.userid.value = document.frm.userid.value;
	opener.frm.reid.value = document.frm.userid.value;
	self.close();
	
}

function idCheck(){
	
    if(document.frm.userid.value==""){
        alert("아이디 입력하여 주세요");
        document.frm.userid.focus();
        return ;
    }
    var url = "idCheck.do?userid="+document.frm.userid.value;
    window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars =yes, resizable=no, width=450, height=200");
} 

function loginCheck(){
	
	if(document.frm.userid.value.length==0){
		alert("아이디 필수 입력 사항입니다.");
		frm.userid.focus();
		return false;
	}
	
	if(document.frm.pwd.value==""){
		alert("비밀번호 필수 입력 사항입니다.");
		frm.pwd.focus();
		return false;
	}
	return true;
} 


function joinCheck(){
	
	if(document.frm.name.value.length==0){
		alert("이름 필수 입력 사항입니다.");
		frm.name.focus();
		return false;
	}
	
	if(document.frm.userid.value.length==0){
		alert("아이디 필수 입력 사항입니다.");
		frm.userid.focus();
		return false;
	}
	
	if(document.frm.userid.value.length < 4){
		alert("아이디는 4자 이상입니다.");
		frm.userid.focus();
		return false;
	}
	
	if(document.frm.pwd.value==""){
		alert("비밀번호 필수 입력 사항입니다.");
		frm.pwd.focus();
		return false;
	}
	
	if(document.frm.pwd.value != document.frm.pwd_check.value){
		alert("비밀번호가 일치하지 않습니다.");
		frm.pwd.focus();
		return false;
	}
	
	if(document.frm.reid.value.length==0){
		alert("유효성 체크를 하지 않았습니다. ");
		frm.userid.focus();
		return false;
	}
	return true;
}






















