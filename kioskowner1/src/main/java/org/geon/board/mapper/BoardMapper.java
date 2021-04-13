package org.geon.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.geon.board.domain.BoardVO;

public interface BoardMapper {

	BoardVO read(Long bno);
	
	List<BoardVO> getList(@Param("skip") int skip,
						  @Param("count") int count,
						  @Param("category") int category
						  //@Param("arr") String[] arr ,
						  //@Param("keyword") String keyword
						  );
	
	//리스트 페이지메이커용
	int getTotalCount(@Param("category") int category
					  //@Param("arr") String[] arr ,
					  //@Param("keyword") String keyword
					  );
	
	
	void insert(BoardVO board);
	
	void update(BoardVO board);
	
	void delete(Long bno);
}
