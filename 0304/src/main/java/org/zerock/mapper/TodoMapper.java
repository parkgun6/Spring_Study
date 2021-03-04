package org.zerock.mapper;

import org.apache.ibatis.annotations.Insert;
import org.zerock.entity.Todo;

//객체만 bean이 될수 있기때문에 어너테이션을 안걸어준다.
public interface TodoMapper {
	
	@Insert("insert into tbl_todo (title, complete) values(#{title},#{complete})")
	void insert(Todo todo);
	
	
	
}
