package org.zerock.board.service;

import java.util.List;

import org.zerock.board.domain.Reply;
import org.zerock.board.dto.ReplyDTO;
import org.zerock.common.dto.PageDTO;

public interface ReplyService {

	List<Reply> getReplyList(Integer bno,PageDTO pageDTO); 
	
	default ReplyDTO toDTO(Reply reply) {
		ReplyDTO dto = new ReplyDTO();
		dto.setRno(reply.getRno());
		dto.setBno(reply.getBno());
		dto.setReply(reply.getReply());
		dto.setReplyer(reply.getReplyer());
		dto.setReplyDate(reply.getReplyDate());
		dto.setUpdateDate(reply.getUpdateDate());
		return dto;
	}


}
