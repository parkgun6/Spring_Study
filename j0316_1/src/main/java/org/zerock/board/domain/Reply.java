package org.zerock.board.domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Reply {

	private Integer rno;
	private Integer bno;
	private String reply, replyer;
	private Timestamp replyDate, updateDate;
}
