package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;

//마이바티스 세팅이라서 스프링 어노테이션 세팅이 안들어간다.
public interface TimeMapper {

	@Select("select now()")
	String getTime();

	String getTime2();

}
