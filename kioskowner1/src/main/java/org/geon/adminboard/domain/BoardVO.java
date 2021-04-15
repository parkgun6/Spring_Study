package org.geon.adminboard.domain;

import java.sql.Date;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardVO {

	private Long bano;
	private Integer category;
	private String title, content, writer;
	private Date regdate, updateDate;
	private Boolean enabled;
	
}
