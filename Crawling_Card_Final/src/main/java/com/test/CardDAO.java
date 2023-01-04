package com.test;

import java.sql.*;
import java.util.*;

public class CardDAO {
	private static String driver = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private static String user = "scott";
	private static String pwd = "1234";

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		System.out.println("크롤링 시작!");
		ArrayList<CardVO> toList = CardCrawling.card_crawling();
		ArrayList<CardVO> toEventList = CardEventCrawling.cardE_crawling();
		System.out.println("크롤링 끝!");

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pwd);

			String sql = "insert into card values(card_seq.nextval, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			for (CardVO vo : toList) {
				pstmt.setString(1, vo.getImg());
				pstmt.setString(2, vo.getName());
				pstmt.setString(3, vo.getInfo());
				pstmt.setString(4, vo.getNotice());
				pstmt.setString(5, vo.getDues());
				pstmt.setString(6, vo.getPerformance());
				pstmt.setString(7, vo.getBenefits());
				pstmt.executeUpdate();	
			}

			String sqlE = "insert into event values(event_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sqlE);
			for (CardVO vo : toEventList) {
				pstmt.setString(1, vo.getEventCardImg());
				pstmt.setString(2, vo.getEventSpotImg());
				pstmt.setString(3, vo.getEventName());
				pstmt.setString(4, vo.getEventInfo());
				pstmt.setString(5, vo.getEventCal());
				pstmt.setString(6, vo.getEventBen());
				pstmt.setString(7, vo.getEventTar());
				pstmt.setString(8, vo.getEventPay());
				pstmt.executeUpdate();	
				
			}
			System.out.println("오라클 업로드 완료");
		} catch (Exception e) {
			// TODO: handle exception

		}

	}

}
