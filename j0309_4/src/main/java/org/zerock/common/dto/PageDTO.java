package org.zerock.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PageDTO {
	
	//이걸쓰지않으면 생성자를 만들어줘야한다.
	@Builder.Default
	private int page = 1;
	@Builder.Default
	private int perSheet = 10;
	
	//이 기능이 있어야지만 Skip을 해줄수있다.
	public int getSkip() {
		//음수가 나올경우에 디폴트값을 0으로 만드는 validation이 필요하다.
		return (page - 1) * perSheet;
	}
}
