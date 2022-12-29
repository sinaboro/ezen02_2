package org.zerock.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardMapper {
	
	//@Select("select * from tbl_board where bno > 0")
	public List<BoardVO> getList();
	public void insert(BoardVO vo);
	public void insertSelectKey(BoardVO vo);
	public BoardVO read(Long bno);
	public int delete(Long bno);
	public int update(BoardVO vo);
	public List<BoardVO> getListWithPagin(Criteria cri);
	public int getTotalCount(Criteria c);
	public List<BoardVO> searchTest(Map<String , Map<String, String>> map);// 추가..
	
	public void updateReplyCnt(@Param("bno") Long bno, @Param("amount") int amount);
}
