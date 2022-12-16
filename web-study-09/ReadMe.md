DB설정

create table member(
    name varchar2(30),
    userid varchar2(20),
    pwd varchar2(10),
    email varchar2(30),
    phone char(13),
    admin number(1) -- 관리자 구분 번호(0:일반사용자, 1: 관리자)
);


