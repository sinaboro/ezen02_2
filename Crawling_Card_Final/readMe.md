
SELECT * FROM card;
select * from event;

drop table card;
drop SEQUENCE card_seq;

create SEQUENCE card_seq start with 1 increment by 1;

create table Card (
    num number(3) not null PRIMARY KEY, --시퀀스
    img varchar2(80),   --카드이미지
    name varchar2(80),  --카드이름
    info varchar2(80),  --요약설명
    notice varchar2(100),   --공지
    dues varchar2(100), --  연회비
    performance varchar2(100),  --실적
    benefits varchar2(1000) --혜택내용
);

drop table event;
drop SEQUENCE event_seq;

create SEQUENCE event_seq start with 1 increment by 1;

CREATE table event(
eventnum number(5) not null primary key, --번호
eventcardimg varchar2(1000),--카드 이미지
eventspotimg varchar2(1000), -- 이벤트 이미지
eventname varchar2(1000), -- 카드 이름
eventinfo varchar2(1000), -- 카드 해택 요약
eventcal varchar2(1000), -- 기간
eventben varchar2(1000), -- 이벤트 해택
eventtar varchar2(1000),-- 대상
eventpay varchar2(1000) -- 지급예정일
);

commit;

