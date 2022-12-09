package kr.bit.model;
import java.io.InputStream;
// JDBC->MyBatis
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
public class MemberDAO {
   private static SqlSessionFactory sqlSessionFactory; //[O O O O O ]
 
   // 초기화 블럭-프로그램실행시 딱 한번만 실되는 코드영역
   static {
	   try {
		   String resource = "kr/bit/mybatis/config.xml";
		   InputStream inputStream = Resources.getResourceAsStream(resource);//읽기
		   sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream); 
	   }catch(Exception e) {
		   e.printStackTrace();
	   }
   }
   // 회원전체 리스트보기
   public List<MemberVO> memberList() {
	   // [Connection+Statement]=>SqlSession
	   SqlSession session=sqlSessionFactory.openSession();
	   List<MemberVO> list=session.selectList("memberList");
	   session.close();//반납
	   return list;
   } 
   // 회원가입
   public int memberInsert(MemberVO vo) {
	   SqlSession session=sqlSessionFactory.openSession();
	   int cnt=session.insert("memberInsert", vo);
	   session.commit();
	   session.close();//반납
	   return cnt;
   }
   // 회원삭제
   public int memberDelete(int num) {
	   SqlSession session=sqlSessionFactory.openSession();
	   int cnt=session.delete("memberDelete", num);
	   session.commit();
	   session.close();
	   return cnt;
   }
   // 회원상세보기
   public MemberVO memberContent(int num) {
	   SqlSession session=sqlSessionFactory.openSession();
	   MemberVO vo=session.selectOne("memberContent", num);
	   session.close();
	   return vo;
   }
   // 회원수정하기
   public int memberUpdate(MemberVO vo) {
	   SqlSession session=sqlSessionFactory.openSession();
	   int cnt=session.update("memberUpdate", vo);
	   session.commit();
	   session.close();
	   return cnt;
   }
}


