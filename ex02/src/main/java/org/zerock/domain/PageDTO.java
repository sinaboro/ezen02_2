package org.zerock.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageDTO {

	private int startPage;
	private int endPage;
	private boolean prev, next;
	
	private int total;
	private Criteria cri;
	
	
	//82개라고 가정           (2,10)     82
	public PageDTO(Criteria cri, int total) {
		this.cri =cri;  //(2,10)
		this.total = total;  //82
		
		this.endPage = (int)(Math.ceil(cri.getPageNum()/10.0))* 10;  //10
		this.startPage = endPage - 9; //10-9 - 1
		
		int realEnd = (int)(( Math.ceil(total*1.0)/cri.getAmount()));  // (82/1.0)/10 -> 8
		
		if(realEnd <this.endPage) {
			this.endPage = realEnd;
		}
		
		this.prev = this.startPage>1;
		this.next = this.endPage < realEnd;
	}
	
}
