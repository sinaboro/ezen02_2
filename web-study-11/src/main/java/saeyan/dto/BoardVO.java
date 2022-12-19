package saeyan.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
 * NUM        NOT NULL NUMBER(5)      
PASS                VARCHAR2(30)   
NAME                VARCHAR2(30)   
EMAIL               VARCHAR2(30)   
TITLE               VARCHAR2(50)   
CONTENT             VARCHAR2(1000) 
READCOUNT           NUMBER(4)      
WRITEDATE           DATE 
 */
@Getter
@Setter
@ToString
public class BoardVO {
	
	private int num;
	private String pass;
	private String name;
	private String email;
	private String title;
	private String content;
	private int readcount;
	private Timestamp writedate;
	
}
