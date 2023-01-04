package dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
 *  Num NUMBER PRIMARY KEY,
    Category NVARCHAR2(1000), 
    Title NVARCHAR2(1000), 
    Price NVARCHAR2(20), 
    Summary VARCHAR2(4000), 
    Author NVARCHAR2(1000), 
    Pub NVARCHAR2(1000), 
    Grade NVARCHAR2(20)
 */

@Setter
@Getter 
@ToString
public class BookVO {

	private int num;
	private String category;
	private String title;
	private String price;
	private String summary;
	private String author;
	private String pub;
	private String grade;
	private String pictureurl;
	
}
