package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;

public interface BoardMapper {
	
	//@Select("select * from tbl_board where bno > 0")
	public List<BoardVO> getList();
	public void insert(BoardVO vo);
	public void insertSelectKey(BoardVO vo);
	public BoardVO read(Long bno);
	public int delete(Long bno);
	public int update(BoardVO vo);
}
