package org.zerock.mapper;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {
	
	private Long[] bnoArr= {852019L,852018L,852017L,852016L,852015L};
	@Autowired
	private ReplyMapper mapper;
	
	@Test
	public void testMapper() {
		log.info("mapper : " + mapper);
	}
	
	@Test
	public void testCreate() {
		IntStream.rangeClosed(1, 10).forEach(i->{
			ReplyVO vo = new ReplyVO();
			
			vo.setBno(bnoArr[i % 5]);
			vo.setReply("댓글 테스트 " + i);
			vo.setReplyer("replyer " + i);
			mapper.insert(vo);
		});
	}
	
	@Test
	public void testRead() {
		mapper.read(5L);
	}
	
	@Test
	public void testDelete() {
		mapper.delete(5L);
	}
	
	@Test
	public void testUpdate() {
		ReplyVO vo = mapper.read(4L);
		
		vo.setReply("수정합니다.");
		int count = mapper.update(vo);
		log.info("count => " + count) ;
		
		
		
	}
	
	@Test
	public void testList() {
		Criteria cri = new Criteria();
		//852017L
		List<ReplyVO> replies = mapper.getListWithPaging(cri, bnoArr[2]);
		
		replies.forEach(reply->log.info(reply));
		
	}

	@Test
	public void testList2() {
		Criteria cri = new Criteria(1,10);
		//852019L
		List<ReplyVO> replies = mapper.getListWithPaging(cri, 852019L);
		
		replies.forEach(reply->log.info(reply));
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
