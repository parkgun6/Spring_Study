package org.zerock.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.board.domain.Reply;
import org.zerock.common.dto.PageDTO;

public interface ReplyMapper {

	void insert(Reply reply);
	
	void update(Reply reply);
	
	void delete(Integer rno);
	
	List<Reply> selectList(@Param("bno") Integer bno,@Param("pageDTO") PageDTO pageDTO);
	
}
