package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper mapper;

	@Override
	public void register(BoardVO vo) {
		log.info("regiseter....." + vo);
		mapper.insertSelectKey(vo);
	}

	@Override
	public BoardVO get(Long bno) {
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO vo) {
		return mapper.update(vo) == 1;
	}

	@Override
	public boolean remove(Long bno) {
		return mapper.delete(bno)==1;
	}

	@Override
	public List<BoardVO> getList() {
		log.info("getList........");
		return mapper.getList();
	}
	
}
