create table tbl_reply(
    rno number(10,0),
    bno number(10,0),
    reply varchar2(1000) not null,
    replyer varchar2(50) not null,
    replyDate date default sysdate,
    updateDate date default sysdate
);

create SEQUENCE seq_reply;

alter table tbl_reply add CONSTRAINT pk_reply PRIMARY key(rno);

alter table tbl_reply add CONSTRAINT fk_reply_board
FOREIGN key (bno) REFERENCES tbl_board(bno);

desc tbl_reply;