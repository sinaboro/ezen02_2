package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyPageDTO;
import org.zerock.domain.ReplyVO;
import org.zerock.mapper.BoardMapper;
import org.zerock.mapper.ReplyMapper;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class ReplyServiceImpl implements ReplyService{

	@Autowired
	private ReplyMapper mapper;
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Transactional
	@Override
	public int Register(ReplyVO vo) {
		log.info("register........=> " + vo);
		boardMapper.updateReplyCnt(vo.getBno(), 1);
		return mapper.insert(vo);
	}

	@Override
	public ReplyVO get(Long rno) {
		log.info("get........=> " + rno);
		return mapper.read(rno);
	}

	@Override
	public int modify(ReplyVO vo) {
		log.info("modify........=> " + vo);
		return mapper.update(vo);
	}

	@Transactional
	@Override
	public int remove(Long rno) {
		log.info("remove........=> " + rno);
		ReplyVO vo =  mapper.read(rno);
		boardMapper.updateReplyCnt(vo.getBno(), -1);
		return mapper.delete(rno);
	}

	@Override
	public List<ReplyVO> getList(Criteria cri, Long rno) {
		log.info("getList........=> " + cri + " : " + rno);
		return mapper.getListWithPaging(cri, rno);
	}

	@Override
	public ReplyPageDTO getListPage(Criteria cri, Long bno) {
		
		return new ReplyPageDTO(mapper.getCountByBno(bno), mapper.getListWithPaging(cri, bno));
	}

}
