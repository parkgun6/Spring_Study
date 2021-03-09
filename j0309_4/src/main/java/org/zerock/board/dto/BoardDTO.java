package org.zerock.board.dto;

import java.sql.Date;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class BoardDTO {

	private Integer bno;
	//validation을 위해 지정
	@NotEmpty
	private String title;
	private String content;
	@NotEmpty
	private String writer;
	private Date regDate,updatedate;
}
