package dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
NUM       NOT NULL NUMBER(5)      
ID                 VARCHAR2(30)   
TITLE              VARCHAR2(1000) 
CONTENT            VARCHAR2(4000) 
READCOUNT          NUMBER(32)
 */

@Getter
@Setter
@ToString
public class NoticeVO {
	private int num;
	private String id;
	private String title;
	private String content;
	private Timestamp writedate;
	private int readcount;
}
