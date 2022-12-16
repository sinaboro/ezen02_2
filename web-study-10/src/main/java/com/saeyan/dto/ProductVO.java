package com.saeyan.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
 * CODE        NOT NULL NUMBER(5)      
NAME                 VARCHAR2(100)  
PRICE                NUMBER(8)      
PICTUREURL           VARCHAR2(50)   
DESCRIPTION          VARCHAR2(1000)
 */
@Getter
@Setter
@ToString
public class ProductVO {
	int code;
	String name;
	int price;
	String pictureUrl;
	String description;
}
