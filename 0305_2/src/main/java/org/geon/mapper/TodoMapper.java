package org.geon.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.geon.entity.Todo;


public interface TodoMapper {

	@Insert("insert into tbl_todo (title, complete) values(#{title},#{complete})")
	void insert(Todo todo);
	
}
