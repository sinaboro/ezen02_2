ALTER TABLE board ADD boardGroup number(5);
ALTER TABLE board ADD boardSequence number(5);
ALTER TABLE board ADD boardLevel number(5);
ALTER TABLE board ADD boardAvailable number(2);


insert into board(num, pass, name, email,title, content, readcount, writedate,BGROUP)
values(board_seq.nextval, '1', '2', '3', '4', '5',7, sysdate, (select nvl((max(BGROUP)+1),0) from board) );