package com.test;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CardVO {

	private int num;
	private String name;
	private String img;
	private String info;
	private String notice;
	private String dues;
	private String performance;
	private String benefits;
	
	private int eventnum;
	private String eventName;	
	private String eventCardImg;
	private String eventSpotImg;
	private String eventInfo;
	private String eventCal;
	private String eventBen;
	private String eventTar;
	private String eventPay;
}
