package org.geon.entity;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Todo {

	private Integer tno;
	private String title;
	private Boolean complete;
	private Date regdate;
	
}