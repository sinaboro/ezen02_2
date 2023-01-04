package com.test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.*;

import javax.imageio.ImageIO;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;



public class CardEventCrawling {

	static ArrayList<CardVO> toEventList = new ArrayList<CardVO>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CardEventCrawling cc = new CardEventCrawling();
		
		cc.cardE_crawling();
	}
		
	public static ArrayList<CardVO> cardE_crawling(){
		
		try {
			//카드 정보 크롤링
		
			
			//카드 이벤트 페이지 크롤링
			Document docE = Jsoup.connect("https://card-search.naver.com/list?sortMethod=ri&isRefetch=true&bizType=CPA").get();

			for (int i = 0; i < 7; i++) {
				CardVO vo = new CardVO();

				Elements link = docE.select("ul.list li.item:eq(" + i + ") a.anchor");

				String linkId = link.attr("href");

				Document docE2 = Jsoup.connect("https://card-search.naver.com/promotion?" + linkId.substring(6)).get();

				Elements imgSpot = docE2.select("div.spot img");
				Elements imgCard = docE.select("li.item:eq("+i+") figure.figure img");
				
				String urlSpot = imgSpot.attr("src");
				String urlCard = imgCard.attr("src");
				
				
				System.out.println(urlCard);
				System.out.println(urlSpot);

				//여기서부터 이벤트광고사진 파일에 넣기
				URL imgUrlSpot = new URL(urlSpot);
				BufferedImage jpgSpot = ImageIO.read(imgUrlSpot);

				File fileSpot = new File("C:\\Works2\\Project_Team_6_FINAL\\src\\main\\webapp\\img\\eventSpot"+i+".png");
				ImageIO.write(jpgSpot, "png", fileSpot);
				
				//여기서부터 이벤트카드사진 파일에 넣기
				URL imgUrlCard = new URL(urlCard);
				BufferedImage jpgCard = ImageIO.read(imgUrlCard);
				
				File fileCard = new File("C:\\Works2\\Project_Team_6_FINAL\\src\\main\\webapp\\img\\eventCard"+i+".png");
				ImageIO.write(jpgCard, "png", fileCard);
				
				Elements eventName = docE.select("ul.list li.item:eq("+i+") b.name");
				// 이벤트카드이름
//				System.out.println("이벤트카드이름 : "+eventName.text());
				
				Elements eventInfo = docE.select("ul.list li.item:eq("+i+") p");
				// 이벤트설명
//				System.out.println("이벤트설명 : "+eventInfo.text());

				Elements eventCal = docE2.select("div.info dl:eq(0) div.inner");
				// 이벤트기간
//				System.out.println("이벤트기간 : "+eventCal.text());

				Elements eventBen = docE2.select("div.info dl:eq(1) div.inner");
				// 이벤트혜택
//				System.out.println("이벤트혜택 : "+eventBen.text());

				Elements eventTar = docE2.select("div.info dl:eq(2) div.inner");
				// 이벤트대상
//				System.out.println("이벤트대상 : "+eventTar.text());

				Elements eventPay = docE2.select("div.info dl:eq(4) div.inner");
				// 지급예정일
//				System.out.println("지급예정일 : "+eventPay.text());
				vo.setEventCardImg("eventCard"+i+".png");
				vo.setEventSpotImg("eventSpot"+i+".png");
				vo.setEventName(eventName.text());
				vo.setEventInfo(eventInfo.text());
				vo.setEventCal(eventCal.text());
				vo.setEventBen(eventBen.text());
				vo.setEventTar(eventTar.text());
				vo.setEventPay(eventPay.text());
				
				toEventList.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return toEventList;
	}

}
