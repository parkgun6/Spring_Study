package org.gun.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.gun.board.domain.Board;

public interface BoardMapper {
	
	
	List<Board> getList(@Param("skip") int skip,
			@Param("count") int count ,
			@Param("arr") String[] arr ,
			@Param("keyword") String keyword
			);
	
	//리스트 페이지메이커용
	int getTotalCount(@Param("arr") String[] arr ,
					  @Param("keyword") String keyword);
	
	//service에서 dto로 변환해주기때문에 vo로 받는다.
	void insert(Board board);
	
	Board selectOne(Integer bno);
	
	void update(Board board);
	//checkBox를 이용한 검색기능을 만들 때 사용한다.
	//테스트 할때만 잠깐 사용했다.
	//dto가 service까지만 가야하는데 mapper까지 와서 사용하지 않는다.
	//List<Board> ex1(PageDTO dto);
	
	void delete(Integer bno);
	
}
