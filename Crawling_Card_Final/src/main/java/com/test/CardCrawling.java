package com.test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.*;

import javax.imageio.ImageIO;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class CardCrawling {

	static ArrayList<CardVO> toList = new ArrayList<CardVO>();
	static ArrayList<CardVO> toEventList = new ArrayList<CardVO>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CardCrawling cc = new CardCrawling();

		cc.card_crawling();
	}

	public static ArrayList<CardVO> card_crawling() {

		try {
			// 카드 정보 크롤링
			Document doc = Jsoup.connect("https://card-search.naver.com/list").get();

			for (int i = 0; i < 10; i++) {

				Elements imgLink = doc.select("ul.list li.item:eq(" + i + ") img.img");

				String url = imgLink.attr("src");

				URL imgUrl = new URL(url);
				BufferedImage jpg = ImageIO.read(imgUrl);

				File file = new File("C:\\Works2\\Project_Team_6_FINAL\\src\\main\\webapp\\img\\card" + i + ".png");
				
				ImageIO.write(jpg, "png", file);

				Elements name = doc.select("ul.list li:eq(" + i + ") b");
				// 카드명
//				System.out.println("카드명 : " + name.text());

				Elements info = doc.select("ul.list li:eq(" + i + ") p");
				// 요약설명 info
//				System.out.println("요약설명 : " + info.text());

				Elements link = doc.select("ul.list li:eq(" + i + ") a");
				Document doc2 = Jsoup.connect("https://card-search.naver.com" + link.attr("href")).get();

				Elements notice = doc2.select("dl.list dd.desc b.noti");
				// 공지 notice
//				System.out.println("공지 : " + notice.text());

				Elements dues = doc2.select("dl.list dd.as_annualFee");
				// 연회비 dues
//				System.out.println("연회비 : " + dues.text());

				Elements performance = doc2.select("dl.list dd.desc:eq(5)");
				// 실적 performance
//				System.out.println("실적 : " + performance.text());

				Elements benefits = doc2.select("dl.list dd.desc:eq(7)");
				// 혜택요약 benefits
//				System.out.println("혜택요약 : " + benefits.text());

				CardVO vo = new CardVO();
				vo.setImg("card" + i + ".png");
				vo.setName(name.text());
				vo.setInfo(info.text());
				vo.setNotice(notice.text());
				vo.setDues(dues.text());
				vo.setPerformance(performance.text());
				vo.setBenefits(benefits.text());

				toList.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return toList;
	}

}
