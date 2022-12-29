package org.zerock.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapperTests;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {

	@Autowired
	private BoardService service;
	
	@Test
	public void testExist() {
		log.info("service : " + service);
		assertNotNull(service);
	}

	@Test
	public void testRegister() {
		BoardVO vo = new BoardVO();
		vo.setTitle("서비스로 작성하는 글");
		vo.setContent("서비스로 작성하는 내용");
		vo.setWriter("서비스");
		
		service.register(vo);
		log.info("생성된 게시물 번호 : " + vo.getBno());
	}
	
//	@Test
//	public void testgetList() {
//		service.getList().forEach(board->log.info(board));
//	}
	
	@Test
	public void testread() {
		log.info(service.get(24L));
		
	}

	@Test
	public void testupdate() {
		BoardVO vo = service.get(24L);
		
		vo.setTitle("제목을 수정합니다.");
		service.modify(vo);
		
	}

	@Test
	public void testremove() {
		service.remove(24L);
		
	}
	
	@Test
	public void testGetList() {
		service.getList(new Criteria(2,10)).forEach(board->log.info(board));
	}
	
	@Test
	public void testCac() {
		log.info( "TEST : " + (int)(Math.ceil(2/10.0))* 10);
	}
	
}
