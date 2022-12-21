package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import com.zerock.persistence.DataSourceTests;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	
	@Autowired
	private BoardMapper mapper;
	
	@Test
	public void testGetList() {
		mapper.getList().forEach(board->log.info(board));
	}
	
	@Test
	public void insertTest() {
		BoardVO vo = new BoardVO();
		vo.setTitle("새로 작성하는 글");
		vo.setContent("새로 작성하는 내용");
		vo.setWriter("newbie");
		
		mapper.insert(vo);
		log.info(vo);
	}

	@Test
	public void insertSelectKeyTest() {
		BoardVO vo = new BoardVO();
		vo.setTitle("새로 작성하는 글 insertSelectKey");
		vo.setContent("새로 작성하는 내용 insertSelectKey");
		vo.setWriter("홍길동");
		
		mapper.insertSelectKey(vo);
		log.info(vo);
	}
	
	@Test
	public void testread() {
		BoardVO vo = mapper.read(23L);
		log.info("vo ==> " + vo);
	}
	
	@Test
	public void tesdelete() {
		int result = mapper.delete(23L);
		log.info("vo ==> " + result);
	}
	
	@Test
	public void updateTest() {
		BoardVO vo = new BoardVO();
		vo.setBno(22L);
		vo.setTitle("변경하는 글");
		vo.setContent("변경되는 내용");
		vo.setWriter("박수무당");
		
		int result = mapper.update(vo);
		log.info(result);
	}
}
