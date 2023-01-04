파이썬 설치 링크: https://www.python.org/ftp/python/3.11.1/python-3.11.1-amd64.exe
설치시 Add python.exe to PATH 체크 필요

cmd(명령프롬프트)에서 
pip install requests
pip install fake_useragent
pip install bs4
각 1회 설치

https://aka.ms/vs/17/release/vs_BuildTools.exe

c++ Build Tools 위 링크로 설치 후 cmd(명령프롬프트)에서 아래 명령어 실행

pip install cx_Oracle

CREATE TABLE productT(
  num NUMBER(5) primary key,
  brand VARCHAR2(50),
  kind VARCHAR2(50),
  product VARCHAR2(400),
  subTitle VARCHAR2(400),
  kategorie VARCHAR2(50),
  state VARCHAR2(50),
  madeIn VARCHAR2(50),
  option1 VARCHAR2(100),
  option1_price NUMBER(10),
  option1_stock NUMBER(5),
  option2 VARCHAR2(100),
  option2_price NUMBER(10),
  option2_stock NUMBER(5),
  option3 VARCHAR2(100),
  option3_price NUMBER(10),
  option3_stock NUMBER(5),
  option4 VARCHAR2(100),
  option4_price NUMBER(10),
  option4_stock NUMBER(5),
  option5 VARCHAR2(100), 
  option5_price NUMBER(10),
  option5_stock NUMBER(5),
  option6 VARCHAR2(100),
  option6_price NUMBER(10),
  option6_stock NUMBER(5),
  main_img VARCHAR2(100),
  detailed_img1 VARCHAR2(200),
  detailed_img2 VARCHAR2(200),
  detailed_img3 VARCHAR2(200),
  detailed_img4 VARCHAR2(200),
  detailed_img5 VARCHAR2(200),
  detailed_img6 VARCHAR2(200),
  detailed_img7 VARCHAR2(200),
  detailed_img8 VARCHAR2(200),
  detailed_img9 VARCHAR2(200)
);

CREATE sequence seq_productT
increment by 1
start with 1;

drop table productT;
drop sequence  seq_productT;

commit;

SELECT * FROM productT;

crawling_img 먼저 컴파일 후
DB 실행