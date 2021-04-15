package org.geon.adminboard.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {


	private Long bano;
	private Integer category;
	private String title, content, writer;
	private Date regdate, updateDate;
	private Boolean enabled;
	
}
