create sequence board_sql start with 1 INCREMENT by 1;

select * from board;

insert into board(num, name, email, pass, title, content)
values(board_sql.nextval, '성윤정', 'pink@google.com', '1234', '첫방문', '반갑습니다');

insert into board(num, name, email, pass, title, content)
values(board_sql.nextval, '성윤정2', 'pink2@google.com', '1234', '첫방문2', '반갑습니다2');
insert into board(num, name, email, pass, title, content)
values(board_sql.nextval, '전수빈', 'subin@google.com', '1234', '고동애', '일식입니다.');
insert into board(num, name, email, pass, title, content)
values(board_sql.nextval, '전원직', 'one@google.com', '1234', '개골마을', '돼지 삼겹살');

commit;