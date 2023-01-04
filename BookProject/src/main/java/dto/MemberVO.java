package dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
 *   id varchar2 (20) PRIMARY key,
    pass varchar2 (20),
    name varchar2 (10),
    phone char (15),
    email varchar2 (20),
    lev char(1) DEFAULT 'A'
 * */

@Setter
@Getter
@ToString

public class MemberVO {
	
	private String id ;
	private String pass;
	private String name;
	private String phone;
	private String email;
	private String lev;

}
