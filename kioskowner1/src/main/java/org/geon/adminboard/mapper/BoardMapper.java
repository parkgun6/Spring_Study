package org.geon.adminboard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.geon.adminboard.domain.BoardVO;

public interface BoardMapper {

	BoardVO read(Long bano);
	
	List<BoardVO> getList(@Param("page") int page,
						  @Param("perSheet") int perSheet,
						  @Param("category") int category ,
						  @Param("arr") String[] arr ,
						  @Param("keyword") String keyword
						  );
	
	//리스트 페이지메이커용
	int getTotalCount(@Param("category") int category ,
					  @Param("arr") String[] arr ,
					  @Param("keyword") String keyword
					  );
	
	
	void insert(BoardVO board);
	
	void update(BoardVO board);
	
	void delete(Long bano);
	
	List<BoardVO> findByBano(Long bano);
}
